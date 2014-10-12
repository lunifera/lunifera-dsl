/**
 * Copyright 2009-2013 Oy Vaadin Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lunifera.dsl.dto.lib.services.jpa.metadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.lunifera.dsl.dto.lib.services.filters.LAdvancedFilterableSupport;
import org.lunifera.dsl.dto.lib.services.filters.LAnd;
import org.lunifera.dsl.dto.lib.services.filters.LBetween;
import org.lunifera.dsl.dto.lib.services.filters.LCompare;
import org.lunifera.dsl.dto.lib.services.filters.LCompare.Equal;
import org.lunifera.dsl.dto.lib.services.filters.LCompare.Greater;
import org.lunifera.dsl.dto.lib.services.filters.ILFilter;
import org.lunifera.dsl.dto.lib.services.filters.LIsNull;
import org.lunifera.dsl.dto.lib.services.filters.LJoinFilter;
import org.lunifera.dsl.dto.lib.services.filters.LLike;
import org.lunifera.dsl.dto.lib.services.filters.LNot;
import org.lunifera.dsl.dto.lib.services.filters.LOr;
import org.lunifera.dsl.dto.lib.services.filters.LSimpleStringFilter;

/**
 * Converts a Vaadin 6.6 container filter into a JPA criteria predicate.
 * 
 * @param filter
 *            Vaadin 6.6 {@link ILFilter}
 * @return {@link Predicate}
 * 
 * @since 2.0
 */
public class FilterConverter {

	/**
	 * Interface for a converter that can convert a certain kind of
	 * {@link ILFilter} to a {@link Predicate}.
	 */
	private interface Converter {
		public boolean canConvert(ILFilter filter);

		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root);
	}

	/**
	 * Converts {@link LAnd} filters.
	 */
	private static class AndConverter implements Converter {
		public boolean canConvert(ILFilter filter) {
			return filter instanceof LAnd;
		}

		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root) {
			return cb.and(convertFiltersToArray(((LAnd) filter).getFilters(),
					cb, root));
		}
	}

	/**
	 * Converts {@link LOr} filters.
	 */
	private static class OrConverter implements Converter {
		public boolean canConvert(ILFilter filter) {
			return filter instanceof LOr;
		}

		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root) {
			return cb.or(convertFiltersToArray(((LOr) filter).getFilters(), cb,
					root));
		}
	}

	/**
	 * Converts {@link LCompare} filters ({@link Equal}, {@link Greater}, etc).
	 */
	private static class CompareConverter implements Converter {
		public boolean canConvert(ILFilter filter) {
			return filter instanceof LCompare;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root) {
			LCompare compare = (LCompare) filter;
			Expression propertyExpr = LAdvancedFilterableSupport
					.getPropertyPath(root, compare.getPropertyId());
			if (LCompare.Operation.EQUAL == compare.getOperation()
					&& compare.getValue() == null) {
				// Make an IS NULL instead if "= null" is passed
				return convertFilter(new LIsNull(compare.getPropertyId()), cb,
						root);
			}
			Expression valueExpr = cb.literal(compare.getValue());
			switch (compare.getOperation()) {
			case EQUAL:
				return cb.equal(propertyExpr, valueExpr);
			case GREATER:
				return cb.greaterThan(propertyExpr, valueExpr);
			case GREATER_OR_EQUAL:
				return cb.greaterThanOrEqualTo(propertyExpr, valueExpr);
			case LESS:
				return cb.lessThan(propertyExpr, valueExpr);
			case LESS_OR_EQUAL:
				return cb.lessThanOrEqualTo(propertyExpr, valueExpr);
			default: // Shouldn't happen
				return null;
			}
		}
	}

	/**
	 * Converts {@link LIsNull} filters.
	 */
	private static class IsNullConverter implements Converter {
		public boolean canConvert(ILFilter filter) {
			return filter instanceof LIsNull;
		}

		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root) {
			return cb.isNull(LAdvancedFilterableSupport.getPropertyPath(root,
					((LIsNull) filter).getPropertyId()));
		}
	}

	/**
	 * Converts {@link LSimpleStringFilter} filters.
	 */
	private static class SimpleStringFilterConverter implements Converter {
		public boolean canConvert(ILFilter filter) {
			return filter instanceof LSimpleStringFilter;
		}

		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root) {
			LSimpleStringFilter stringFilter = (LSimpleStringFilter) filter;
			String filterString = stringFilter.getFilterString();
			if (stringFilter.isOnlyMatchPrefix()) {
				filterString = filterString + "%";
			} else {
				filterString = "%" + filterString + "%";
			}
			if (stringFilter.isIgnoreCase()) {
				return cb.like(cb.upper(LAdvancedFilterableSupport
						.getPropertyPath(root, stringFilter.getPropertyId()
								.toString())), cb.upper(cb
						.literal(filterString)));
			} else {
				return cb.like(LAdvancedFilterableSupport.getPropertyPath(root,
						stringFilter.getPropertyId().toString()), cb
						.literal(filterString));
			}
		}
	}

	/**
	 * Converts {@link LLike} filters.
	 */
	private static class LikeConverter implements Converter {
		public boolean canConvert(ILFilter filter) {
			return filter instanceof LLike;
		}

		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root) {
			LLike like = (LLike) filter;
			if (like.isCaseSensitive()) {
				return cb.like(LAdvancedFilterableSupport.getPropertyPath(root,
						like.getPropertyId().toString()), cb.literal(like
						.getValue()));
			} else {
				return cb.like(
						cb.upper(LAdvancedFilterableSupport.getPropertyPath(
								root, like.getPropertyId().toString())), cb
								.upper(cb.literal(like.getValue())));
			}
		}
	}

	private static class BetweenConverter implements Converter {
		public boolean canConvert(ILFilter filter) {
			return filter instanceof LBetween;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root) {
			LBetween between = (LBetween) filter;
			Expression<? extends Comparable> field = LAdvancedFilterableSupport
					.getPropertyPath(root, between.getPropertyId());
			Expression<? extends Comparable> from = cb.literal(between
					.getStartValue());
			Expression<? extends Comparable> to = cb.literal(between
					.getEndValue());
			return cb.between(field, from, to);
		}
	}

	private static class JoinFilterConverter implements Converter {
		public boolean canConvert(ILFilter filter) {
			return filter instanceof LJoinFilter;
		}

		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root) {
			LJoinFilter hibernateJoin = (LJoinFilter) filter;
			From<X, Y> join = root.join(hibernateJoin.getJoinProperty());
			return cb.and(convertFiltersToArray(hibernateJoin.getFilters(), cb,
					join));
		}

	}

	private static class NotFilterConverter implements Converter {
		public boolean canConvert(ILFilter filter) {
			return filter instanceof LNot;
		}

		public <X, Y> Predicate toPredicate(ILFilter filter, CriteriaBuilder cb,
				From<X, Y> root) {
			LNot not = (LNot) filter;
			return cb.not(convertFilter(not.getFilter(), cb, root));
		}
	}

	private static Collection<Converter> converters;
	static {
		converters = Collections.unmodifiableCollection(Arrays.asList(
				new AndConverter(), new OrConverter(), new CompareConverter(),
				new IsNullConverter(), new SimpleStringFilterConverter(),
				new LikeConverter(), new BetweenConverter(),
				new JoinFilterConverter(), new NotFilterConverter()));
	}

	/**
	 * Convert a single {@link ILFilter} to a criteria {@link Predicate}.
	 * 
	 * @param filter
	 *            the {@link ILFilter} to convert
	 * @param criteriaBuilder
	 *            the {@link CriteriaBuilder} to use when creating the
	 *            {@link Predicate}
	 * @param root
	 *            the {@link CriteriaQuery} {@link Root} to use for finding
	 *            fields.
	 * @return a {@link Predicate} representing the {@link ILFilter} or null if
	 *         conversion failed.
	 */
	public static <X, Y> Predicate convertFilter(ILFilter filter,
			CriteriaBuilder criteriaBuilder, From<X, Y> root) {
		assert filter != null : "filter must not be null";

		for (Converter c : converters) {
			if (c.canConvert(filter)) {
				return c.toPredicate(filter, criteriaBuilder, root);
			}
		}

		throw new IllegalStateException("Cannot find any converters for "
				+ filter.getClass().getSimpleName() + " filters!");
	}

	/**
	 * Converts a collection of {@link ILFilter} into a list of {@link Predicate}
	 * .
	 * 
	 * @param filters
	 *            Collection of {@link ILFilter}
	 * @return List of {@link Predicate}
	 */
	public static <X, Y> List<Predicate> convertFilters(
			Collection<ILFilter> filters, CriteriaBuilder criteriaBuilder,
			From<X, Y> root) {
		List<Predicate> result = new ArrayList<Predicate>();
		for (ILFilter filter : filters) {
			result.add(convertFilter(filter, criteriaBuilder, root));
		}
		return result;
	}

	private static <X, Y> Predicate[] convertFiltersToArray(
			Collection<ILFilter> filters, CriteriaBuilder criteriaBuilder,
			From<X, Y> root) {
		return CollectionUtil.toArray(Predicate.class,
				convertFilters(filters, criteriaBuilder, root));
	}
}

/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Contributor:
 * 		Florian Pirchner - Copied filter and fixed them for lunifera usecase.
 */
package org.lunifera.dsl.dto.lib.services.filters;

public class LSimpleStringFilter implements ILFilter {

	final Object propertyId;
	final String filterString;
	final boolean ignoreCase;
	final boolean onlyMatchPrefix;

	public LSimpleStringFilter(Object propertyId, String filterString,
			boolean ignoreCase, boolean onlyMatchPrefix) {
		this.propertyId = propertyId;
		this.filterString = ignoreCase ? filterString.toLowerCase()
				: filterString;
		this.ignoreCase = ignoreCase;
		this.onlyMatchPrefix = onlyMatchPrefix;
	}

	@Override
	public boolean appliesToProperty(Object propertyId) {
		return this.propertyId.equals(propertyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		// Only ones of the objects of the same class can be equal
		if (!(obj instanceof LSimpleStringFilter)) {
			return false;
		}
		final LSimpleStringFilter o = (LSimpleStringFilter) obj;

		// Checks the properties one by one
		if (propertyId != o.propertyId && o.propertyId != null
				&& !o.propertyId.equals(propertyId)) {
			return false;
		}
		if (filterString != o.filterString && o.filterString != null
				&& !o.filterString.equals(filterString)) {
			return false;
		}
		if (ignoreCase != o.ignoreCase) {
			return false;
		}
		if (onlyMatchPrefix != o.onlyMatchPrefix) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return (propertyId != null ? propertyId.hashCode() : 0)
				^ (filterString != null ? filterString.hashCode() : 0);
	}

	/**
	 * Returns the property identifier to which this filter applies.
	 * 
	 * @return property id
	 */
	public Object getPropertyId() {
		return propertyId;
	}

	/**
	 * Returns the filter string.
	 * 
	 * Note: this method is intended only for implementations of lazy string
	 * filters and may change in the future.
	 * 
	 * @return filter string given to the constructor
	 */
	public String getFilterString() {
		return filterString;
	}

	/**
	 * Returns whether the filter is case-insensitive or case-sensitive.
	 * 
	 * Note: this method is intended only for implementations of lazy string
	 * filters and may change in the future.
	 * 
	 * @return true if performing case-insensitive filtering, false for
	 *         case-sensitive
	 */
	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	/**
	 * Returns true if the filter only applies to the beginning of the value
	 * string, false for any location in the value.
	 * 
	 * Note: this method is intended only for implementations of lazy string
	 * filters and may change in the future.
	 * 
	 * @return true if checking for matches at the beginning of the value only,
	 *         false if matching any part of value
	 */
	public boolean isOnlyMatchPrefix() {
		return onlyMatchPrefix;
	}
}

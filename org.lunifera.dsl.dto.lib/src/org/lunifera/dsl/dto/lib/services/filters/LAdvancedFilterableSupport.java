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

package org.lunifera.dsl.dto.lib.services.filters;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.From;
import javax.persistence.criteria.Path;

/**
 * Helper class that implements the filtering methods defined in
 * {@link LAdvancedFilterable} and can be either extended or used as a delegate.
 * 
 * @author Petter Holmström (Vaadin Ltd)
 * @since 1.0
 */
public class LAdvancedFilterableSupport implements LAdvancedFilterable,
        Serializable {

    private static final long serialVersionUID = 398382431841547719L;

    /**
     * ApplyFiltersListener interface to be implemented by classes that want to
     * be notified when the filters are applied.
     * 
     * @author Petter Holmström (Vaadin Ltd)
     * @since 1.0
     */
    public static interface ApplyFiltersListener extends Serializable {

        /**
         * Called when the filters have been applied.
         * 
         * @param sender
         *            the sender of the event.
         */
        public void filtersApplied(LAdvancedFilterableSupport sender);
    }

    /**
     * Adds <code>listener</code> to the list of listeners to be notified when
     * the filters are applied. The listener will be notified as many times as
     * it has been added.
     * 
     * @param listener
     *            the listener to add (must not be null).
     */
    public void addListener(ApplyFiltersListener listener) {
        assert listener != null : "listener must not be null";
        listeners.add(listener);
    }

    /**
     * Removes <code>listener</code> from the list of listeners. If the listener
     * has been added more than once, it will be notified one less time. If the
     * listener has not been added at all, nothing happens.
     * 
     * @param listener
     *            the listener to remove (must not be null).
     */
    public void removeListener(ApplyFiltersListener listener) {
        assert listener != null : "listener must not be null";
        listeners.remove(listener);
    }

    @SuppressWarnings("unchecked")
    protected void fireListeners() {
        LinkedList<ApplyFiltersListener> listenerList = (LinkedList<ApplyFiltersListener>) listeners
                .clone();
        for (ApplyFiltersListener l : listenerList) {
            l.filtersApplied(this);
        }
    }

    private Collection<Object> filterablePropertyIds;

    private LinkedList<ApplyFiltersListener> listeners = new LinkedList<ApplyFiltersListener>();

    private LinkedList<ILFilter> appliedFilters = new LinkedList<ILFilter>();

    private LinkedList<ILFilter> filters = new LinkedList<ILFilter>();

    private boolean applyFiltersImmediately = true;

    private boolean unappliedFilters = false;

    /**
     * @see LAdvancedFilterable#getFilterablePropertyIds()
     */
    public Collection<Object> getFilterablePropertyIds() {
        if (filterablePropertyIds == null) {
            return Collections.emptyList();
        } else {
            return Collections.unmodifiableCollection(filterablePropertyIds);
        }
    }

    /**
     * Sets the filterable property IDs.
     * 
     * @param propertyIds
     *            the property IDs to set (must not be null).
     */
    @SuppressWarnings("unchecked")
    public void setFilterablePropertyIds(Collection<?> propertyIds) {
        assert propertyIds != null : "propertyIds must not be null";
        filterablePropertyIds = (Collection<Object>) propertyIds;
    }

    /**
     * Sets the filterable property IDs.
     * 
     * @param propertyIds
     *            the property IDs to set (must not be null).
     */
    public void setFilterablePropertyIds(Object... propertyIds) {
        assert propertyIds != null : "propertyIds must not be null";
        setFilterablePropertyIds(Arrays.asList(propertyIds));
    }

    /**
     * @see LAdvancedFilterable#isFilterable(java.lang.Object)
     */
    public boolean isFilterable(Object propertyId) {
        return getFilterablePropertyIds().contains(propertyId);
    }

    /**
     * Checks if <code>filter</code> is a valid filter, i.e. that all the
     * properties that the filter restricts are filterable.
     * 
     * @param filter
     *            the filter to check (must not be null).
     * @return true if the filter is valid, false if it is not.
     */
    public boolean isValidFilter(ILFilter filter) {
        assert filter != null : "filter must not be null";
        if (filter instanceof LBetween) {
            return isFilterable(((LBetween) filter).getPropertyId());
        } else if (filter instanceof LCompare) {
            return isFilterable(((LCompare) filter).getPropertyId());
        } else if (filter instanceof LIsNull) {
            return isFilterable(((LIsNull) filter).getPropertyId());
        } else if (filter instanceof LLike) {
            return isFilterable(((LLike) filter).getPropertyId());
        } else if (filter instanceof LSimpleStringFilter) {
            return isFilterable(((LSimpleStringFilter) filter).getPropertyId());
        } else if (filter instanceof LAbstractJunctionFilter) {
            for (ILFilter f : ((LAbstractJunctionFilter) filter).getFilters()) {
                if (!isValidFilter(f)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @see LAdvancedFilterable#getFilters()
     */
    public List<ILFilter> getFilters() {
        return Collections.unmodifiableList(filters);
    }

    /**
     * @see LAdvancedFilterable#getAppliedFilters()
     */
    public List<ILFilter> getAppliedFilters() {
        return isApplyFiltersImmediately() ? getFilters() : Collections
                .unmodifiableList(appliedFilters);
    }

    /**
     * @see LAdvancedFilterable#setApplyFiltersImmediately(boolean)
     */
    public void setApplyFiltersImmediately(boolean applyFiltersImmediately) {
        this.applyFiltersImmediately = applyFiltersImmediately;
    }

    /**
     * @see LAdvancedFilterable#isApplyFiltersImmediately()
     */
    public boolean isApplyFiltersImmediately() {
        return applyFiltersImmediately;
    }

    /**
     * @see LAdvancedFilterable#applyFilters()
     */
    public void applyFilters() {
        unappliedFilters = false;
        appliedFilters.clear();
        appliedFilters.addAll(filters);
        fireListeners();
    }

    /**
     * @see LAdvancedFilterable#hasUnappliedFilters()
     */
    public boolean hasUnappliedFilters() {
        return unappliedFilters;
    }

    @SuppressWarnings("unchecked")
    public static Path<String> getPropertyPath(From<?, ?> root,
            Object propertyId) {
        return (Path<String>) getPropertyPathTyped(root, propertyId);
    }

    public static <X, Y> Path<X> getPropertyPathTyped(From<X, Y> root,
            Object propertyId) {
        String pid = propertyId.toString();
        String[] idStrings = pid.split("\\.");
        Path<X> path = root.get(idStrings[0]);
        for (int i = 1; i < idStrings.length; i++) {
            path = path.get(idStrings[i]);
        }
        return path;
    }

    /**
     * @param filter
     */
    public void addFilter(ILFilter filter) {
        filters.add(filter);
        unappliedFilters = true;
        if (isApplyFiltersImmediately()) {
            applyFilters();
        }
    }

    /**
     * @param filter
     */
    public void removeFilter(ILFilter filter) {
        filters.remove(filter);
        unappliedFilters = true;
        if (isApplyFiltersImmediately()) {
            applyFilters();
        }
    }

    public void removeAllFilters() {
        filters.clear();
        unappliedFilters = true;
        if (isApplyFiltersImmediately()) {
            applyFilters();
        }
    }
}

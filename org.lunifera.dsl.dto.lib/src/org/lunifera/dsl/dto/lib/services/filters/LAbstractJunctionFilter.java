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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class LAbstractJunctionFilter implements ILFilter {

    protected final Collection<ILFilter> filters;

    public LAbstractJunctionFilter(ILFilter... filters) {
        this.filters = Collections.unmodifiableCollection(Arrays
                .asList(filters));
    }

    /**
     * Returns an unmodifiable collection of the sub-filters of this composite
     * filter.
     * 
     * @return
     */
    public Collection<ILFilter> getFilters() {
        return filters;
    }

    /**
     * Returns true if a change in the named property may affect the filtering
     * result. If some of the sub-filters are not in-memory filters, true is
     * returned.
     * 
     * By default, all sub-filters are iterated to check if any of them applies.
     * If there are no sub-filters, false is returned - override in subclasses
     * to change this behavior.
     */
    @Override
    public boolean appliesToProperty(Object propertyId) {
        for (ILFilter filter : getFilters()) {
            if (filter.appliesToProperty(propertyId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        LAbstractJunctionFilter other = (LAbstractJunctionFilter) obj;
        // contents comparison with equals()
        return Arrays.equals(filters.toArray(), other.filters.toArray());
    }

    @Override
    public int hashCode() {
        int hash = getFilters().size();
        for (ILFilter filter : filters) {
            hash = (hash << 1) ^ filter.hashCode();
        }
        return hash;
    }
}

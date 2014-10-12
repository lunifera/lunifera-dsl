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

public class LNot implements ILFilter {
	private final ILFilter filter;

	/**
	 * Constructs a filter that negates a filter.
	 * 
	 * @param filter
	 *            {@link ILFilter} to negate, not-null
	 */
	public LNot(ILFilter filter) {
		this.filter = filter;
	}

	/**
	 * Returns the negated filter.
	 * 
	 * @return IFilter
	 */
	public ILFilter getFilter() {
		return filter;
	}

	/**
	 * Returns true if a change in the named property may affect the filtering
	 * result. Return value is the same as {@link #appliesToProperty(Object)}
	 * for the negated filter.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean appliesToProperty(Object propertyId) {
		return filter.appliesToProperty(propertyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !getClass().equals(obj.getClass())) {
			return false;
		}
		return filter.equals(((LNot) obj).getFilter());
	}

	@Override
	public int hashCode() {
		return filter.hashCode();
	}

}

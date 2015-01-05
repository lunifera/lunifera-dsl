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

public interface ILFilter {

    /**
     * Check if a change in the value of a property can affect the filtering
     * result. May always return true, at the cost of performance.
     * 
     * If the filter cannot determine whether it may depend on the property
     * or not, should return true.
     * 
     * @param propertyId
     * @return true if the filtering result may/does change based on changes
     *         to the property identified by propertyId
     */
    public boolean appliesToProperty(Object propertyId);
}

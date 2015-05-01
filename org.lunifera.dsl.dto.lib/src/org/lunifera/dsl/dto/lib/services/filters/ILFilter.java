/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
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

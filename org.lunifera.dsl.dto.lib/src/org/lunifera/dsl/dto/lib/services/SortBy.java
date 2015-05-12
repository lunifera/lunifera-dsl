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
package org.lunifera.dsl.dto.lib.services;

import java.io.Serializable;

public class SortBy  implements Serializable {

    private static final long serialVersionUID = -6308560006578484770L;

    /**
     * The property ID to sort by.
     */
    private final Object propertyId;

    /**
     * True to sort ascendingly, false to sort descendingly.
     */
    private final boolean ascending;

    /**
     * Gets the property ID to sort by.
     */
    public Object getPropertyId() {
        return propertyId;
    }

    /**
     * Returns true to sort ascendingly, false to sort descendingly.
     */
    public boolean isAscending() {
        return ascending;
    }

    /**
     * Creates a new <code>SortBy</code> instance.
     * 
     * @param propertyId
     *            the property ID to sort by (must not be null).
     * @param ascending
     *            true to sort ascendingly, false to sort descendingly.
     */
    public SortBy(Object propertyId, boolean ascending) {
        assert propertyId != null : "propertyId must not be null";
        this.propertyId = propertyId;
        this.ascending = ascending;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == getClass()) {
            SortBy o = (SortBy) obj;
            return o.propertyId.equals(propertyId) && o.ascending == ascending;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = propertyId.hashCode();
        hash = hash * 7 + new Boolean(ascending).hashCode();
        return hash;
    }
}

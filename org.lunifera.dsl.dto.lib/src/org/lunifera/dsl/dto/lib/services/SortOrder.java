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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortOrder {

	private final List<SortBy> sortBy = new ArrayList<SortBy>();

	public SortOrder() {
	}

	/**
	 * @return the sortOrder
	 */
	public List<SortBy> getSortBy() {
		return sortBy;
	}
	
	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(SortBy e) {
		return sortBy.add(e);
	}

	public void clear() {
		sortBy.clear();
	}

}

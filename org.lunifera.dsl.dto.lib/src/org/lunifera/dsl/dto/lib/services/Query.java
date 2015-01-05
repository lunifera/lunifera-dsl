/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.dto.lib.services;

import org.lunifera.dsl.dto.lib.services.filters.ILFilter;

public class Query implements IQuery {

	private final ILFilter filter;
	private final SortOrder sortOrder;

	public Query(ILFilter filter) {
		super();
		this.filter = filter;
		this.sortOrder = new SortOrder();
	}

	public Query(ILFilter filter, SortOrder sortOrder) {
		super();
		this.filter = filter;
		this.sortOrder = sortOrder != null ? sortOrder : new SortOrder();
	}

	@Override
	public ILFilter getFilter() {
		return filter;
	}

	@Override
	public SortOrder getSortOrder() {
		return sortOrder;
	}

}

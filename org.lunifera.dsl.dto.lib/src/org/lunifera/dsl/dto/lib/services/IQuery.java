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

import org.lunifera.dsl.dto.lib.services.filters.ILFilter;

/**
 * 
 * @Noimplement by clients. Will be changed in future!
 */
public interface IQuery {

	/**
	 * Returns the root filter that should be used for the query.
	 * 
	 * @return
	 */
	ILFilter getFilter();

	/**
	 * Returns the sortable columns.
	 * 
	 * @return
	 */
	SortOrder getSortOrder();

}

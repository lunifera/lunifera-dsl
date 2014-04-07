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
package org.lunifera.dsl.service.lib;

import java.util.Collection;

public interface IDTOService<A> extends IService {

	public static final String PROP_MAX_COLLECTION_CONTENT = "maxCollectionContent";

	/**
	 * Returns the dto for the given id.
	 * 
	 * @param id
	 * @return
	 */
	A get(Object id);

	/**
	 * Returns a collection of dtos matching the filter. <br>
	 * The maximum amount of contained elements is limited by
	 * {@link #PROP_MAX_COLLECTION_CONTENT}.
	 * 
	 * @param filter
	 * @param sort
	 * @return
	 */
	Collection<A> find(IFilter filter, ISortOrder sort);

	/**
	 * Returns a collection of dtos matching the filter and starting from the
	 * given startIndex. <br>
	 * May be used for lazy loading issues. Ensure that a sort order is used in
	 * that case.
	 * 
	 * The maximum amount of contained elements is limited by
	 * {@link #PROP_MAX_COLLECTION_CONTENT}.
	 * 
	 * @param filter
	 * @return
	 */
	Collection<A> find(IFilter filter, ISortOrder sort, int startIndex);

	/**
	 * Updates the given DTO.
	 * 
	 * @param dto
	 * @return
	 */
	void update(A dto);

	/**
	 * Deletes the given DTO.
	 * 
	 * @param dto
	 * @return
	 */
	void delete(A dto);

}

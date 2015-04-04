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

import java.util.Collection;
import java.util.List;

public interface IDTOService<A> extends IService {

	public static final int PROP_MAX_COLLECTION_CONTENT = 200;

	/**
	 * Returns the dto for the given id.
	 * 
	 * @param id
	 * @return
	 */
	A get(Object id);

	/**
	 * Returns a collection of dtos matching the filter in the query. <br>
	 * The maximum amount of contained elements is limited by
	 * {@link #PROP_MAX_COLLECTION_CONTENT}.
	 * 
	 * @param query
	 * @return
	 */
	Collection<A> find(IQuery query);

	/**
	 * Returns a collection of dtos matching the filter defined in the query and
	 * starting from the given startIndex. <br>
	 * May be used for lazy loading issues. Ensure that a sort order is used in
	 * that case.
	 * 
	 * The maximum amount of contained elements is limited by
	 * {@link #PROP_MAX_COLLECTION_CONTENT}.
	 * 
	 * @param query
	 * @return
	 */
	Collection<A> find(IQuery query, int startIndex);

	/**
	 * Updates the given DTO.
	 * 
	 * @param dto
	 */
	void update(A dto);

	/**
	 * Deletes the given DTO.
	 * 
	 * @param dto
	 * @return
	 */
	void delete(A dto);

	/**
	 * Returns the count of all dto matching the filter.
	 * 
	 * @param query
	 * @return
	 */
	int size(IQuery query);

	/**
	 * Returns true, if the the dto exists for the given filter.
	 * 
	 * @param dto
	 * @param query
	 * @return
	 */
	boolean contains(Object dto, IQuery query);

	/**
	 * Returns the next dto for the given one using the filter and the
	 * sortOrder.
	 * 
	 * @param dto
	 * @param query
	 * @return
	 */
	A getNext(A dto, IQuery query);

	/**
	 * Returns the previous dto for the given one using the filter and the
	 * sortOrder.
	 * 
	 * @param dto
	 * @param query
	 * @return
	 */
	A getPrevious(A dto, IQuery query);

	/**
	 * Returns the first dto for the given filter and the sortOrder.
	 * 
	 * @param query
	 * @return
	 */
	A getFirst(IQuery query);

	/**
	 * Returns the last dto for the given filter and the sortOrder.
	 * 
	 * @param query
	 * @return
	 */
	A getLast(IQuery query);

	/**
	 * Returns true, if the given dto is the first one for the filter and
	 * sortOrder.
	 * 
	 * @param query
	 * @return
	 */
	boolean isFirst(A dto, IQuery query);

	/**
	 * Returns true, if the given dto is the last one for the filter and
	 * sortOrder.
	 * 
	 * @param query
	 * @return
	 */
	boolean isLast(A dto, IQuery query);

	/**
	 * Returns the index of the given dto for the filter and sortOrder.
	 * 
	 * @param query
	 * @return
	 */
	int indexOf(A dto, IQuery query);

	/**
	 * Returns the dto for the given index, filter and sortOrder.
	 * 
	 * @param index
	 * @param query
	 * @return
	 */
	A getByIndex(int index, IQuery query);

	/**
	 * Returns a list of dtos with size <= numberOfItems, starting from the
	 * startIndex in respect to the filter and sortOrder.
	 * 
	 * @param startIndex
	 * @param numberOfItems
	 * @param query
	 * @return
	 */
	List<A> getByIndex(int startIndex, int numberOfItems, IQuery query);

}

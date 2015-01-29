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
package org.lunifera.dsl.dto.lib;

public interface IMapper<D, E> {

	/**
	 * Maps the given entity to the given dto.
	 * 
	 * @param dto
	 * @param entity
	 * @param context
	 */
	void mapToDTO(D dto, E entity, Context context);

	/**
	 * Maps the given dto to the given entity.
	 * 
	 * @param dto
	 * @param entity
	 * @param context
	 */
	void mapToEntity(D dto, E entity, Context context);

	/**
	 * Creates a new dto that is mapped by the current mapper.
	 * 
	 * @return
	 */
	<X> X createDto();

	/**
	 * Creates a new entity that is mapped by the current mapper.
	 * 
	 * @return
	 */
	<X> X createEntity();

}

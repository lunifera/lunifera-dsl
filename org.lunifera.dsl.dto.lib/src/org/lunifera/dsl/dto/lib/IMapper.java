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
	void mapToDTO(D dto, E entity, MappingContext context);

	/**
	 * Maps the given dto to the given entity.
	 * 
	 * @param dto
	 * @param entity
	 * @param context
	 */
	void mapToEntity(D dto, E entity, MappingContext context);

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

	/**
	 * Calculates a unique hash code for the DTO based on the entity. <br>
	 * For entity based dtos the FQN of the dto and the id of entity is used.
	 * <p>
	 * org.lunifera.dtos.ItemDTO(id=17):
	 * <code>hash=org.lunifera.dtos.ItemDto({entity.hashCode()})</code>
	 * 
	 * @param entity
	 * @return
	 */
	String createDtoHash(Object entity);
	
	/**
	 * Calculates a unique hash code for the entity based on the dto. <br>
	 * For entity based dtos the FQN of the entity and the id of dto is used.
	 * <p>
	 * org.lunifera.entities.Item(id=17):
	 * <code>hash=org.lunifera.entities.Item({dto.hashCode()})</code>
	 * 
	 * @param dto
	 * @return
	 */
	String createEntityHash(Object dto);

}

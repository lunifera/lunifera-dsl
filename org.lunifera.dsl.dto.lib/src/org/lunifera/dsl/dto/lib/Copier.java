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
package org.lunifera.dsl.dto.lib;

public abstract class Copier<A> {

	protected MappingContext context;

	/**
	 * Copies the given DTO including it's attributes and containment-reference
	 * tree. So referenced DTOs that are part of the lifecycle will be also
	 * copied.<br/>
	 * References are only copied in two cases:
	 * <ol>
	 * <li>The reference does not have an opposite</li>
	 * <li>The reference has an opposite but the source and target dto is part
	 * of the copied containment tree</li>
	 * </ol>
	 * 
	 * @param dto
	 *            the DTO to be copied.
	 * @param dto
	 *            the DTO-context. Contains information about the current copy
	 *            depth and the copied objects.
	 * @return a copy of the given DTO
	 * @throws IllegalArgumentException
	 *             if the context is null.
	 */
	public A copy(A dto, MappingContext context) throws IllegalArgumentException {
		this.context = context;
		if (context == null) {
			throw new IllegalArgumentException("Context must not be null!");
		}

		A newDto = createDto();
		context.register(dto, newDto);

		copyContainments(dto, newDto);
		copyCrossReferences(dto, newDto);
		return newDto;
	}

	/**
	 * Creates a new instance of the DTO.
	 * 
	 * @return
	 */
	public abstract A createDto();

	/**
	 * Creates a copy of the given DTO. The copy needs to contain all copied
	 * attributes and a copy of the containment-reference tree.
	 * 
	 * @param dto
	 * @param newDto
	 * @return
	 */
	public abstract void copyContainments(A dto, A newDto);

	/**
	 * Copies the pending references of the DTO. For details about
	 * "reference-copy" see {@link #copy(Object, MappingContext)}.
	 * 
	 * @param dto
	 *            - the DTO providing the references
	 * @param newDto
	 *            - the new DTO
	 */
	public abstract void copyCrossReferences(A dto, A newDto);

}

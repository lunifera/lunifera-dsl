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
package org.lunifera.dsl.metadata.services;

import org.lunifera.dsl.semantic.dto.LDto;

public interface IDtoMetadataService {

	/**
	 * Returns the dto model for the given class.
	 * 
	 * @param c
	 * @return
	 */
	LDto getMetadata(Class<?> dtoClass);

	/**
	 * Returns the dto model for the given class name.
	 * 
	 * @param c
	 * @return
	 */
	LDto getMetadata(String className);

}

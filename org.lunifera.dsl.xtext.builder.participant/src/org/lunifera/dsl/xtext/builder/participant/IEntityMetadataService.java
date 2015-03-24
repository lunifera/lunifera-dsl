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
package org.lunifera.dsl.xtext.builder.participant;

import org.lunifera.dsl.semantic.entity.LEntity;

/**
 * Should not implemented by clients. 
 */
public interface IEntityMetadataService {

	/**
	 * Returns the entity model for the given class. 
	 * @param c
	 * @return
	 */
	LEntity getMetadata(Class<?> entityClass);
	
	/**
	 * Returns the entity model for the given class name. 
	 * @param c
	 * @return
	 */
	LEntity getMetadata(String className);

}

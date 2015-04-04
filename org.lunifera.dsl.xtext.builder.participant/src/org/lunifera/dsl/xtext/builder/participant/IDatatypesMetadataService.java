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
package org.lunifera.dsl.xtext.builder.participant;

import org.lunifera.dsl.semantic.common.types.LDataType;

/**
 * Should not implemented by clients. 
 */
public interface IDatatypesMetadataService {

	/**
	 * Returns the datatypes model for the given datatype name.
	 * 
	 * @param c
	 * @return
	 */
	LDataType getMetadata(String datatypeName);

}

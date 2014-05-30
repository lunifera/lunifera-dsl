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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Returns the metadata model for the given fully qualified name and type.
 */
public interface IMetadataBuilderService {

	/**
	 * Returns the resolved model or <code>null</code> if the model could not be
	 * found.
	 * 
	 * @param fqn
	 * @param type
	 * @return
	 */
	EObject getMetadata(String qualifiedName, EClass type);

}

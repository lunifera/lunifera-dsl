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
package org.lunifera.dsl.xtext.lazyresolver.api;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

public interface IIndexModelAssociator extends IJvmModelAssociations {

	/**
	 * If a semantic element like an LDto will generate different jvmTypes like
	 * Dto and DtoMapper, this allows to register the sourceElement and the
	 * jvmElement by a given selector.
	 * 
	 * @param sourceElement
	 * @param jvmElement
	 * @param selector
	 */
	void associateBySelector(EObject sourceElement, JvmGenericType jvmElement,
			String selector);

	/**
	 * This method returns the registered jvmType by its source element and the
	 * given selector. See
	 * {@link #associateBySelector(EObject, JvmGenericType, String)}.
	 * 
	 * @param sourceElement
	 * @param selector
	 * @return
	 */
	JvmGenericType getBySelector(EObject sourceElement, String selector);

}

/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.xtext.lazyresolver.api.hook;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;

public interface IInferrerDelegate {

	/**
	 * Infers only the JvmTypes.
	 * <p>
	 * The type must become marked as to be derived later by following code:<br>
	 * <code>jvmType.markAsToBeDerivedLater(semanticElement, isPrelinkingPhase)</code>
	 * . See
	 * org.lunifera.dsl.entity.xtext.jvmmodel.EntityGrammarJvmModelInferrer
	 * #inferTypesOnly.
	 * 
	 * @param semanticElement
	 * @param acceptor
	 * @param preIndexingPhase
	 */
	void inferTypesOnly(EObject semanticElement,
			final IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase);

	/**
	 * Is called to install the complete derived state on the given jvmType
	 * using the information from the given semanticElement.
	 * <p>
	 * The type must become marked as "derived" by following code:<br>
	 * <code>jvmType.markAsDerived</code>. See
	 * org.lunifera.dsl.entity.xtext.jvmmodel
	 * .EntityGrammarJvmModelInferrer#inferForLater.
	 * 
	 * @param jvmType
	 * @param semanticElement
	 * @param acceptor
	 * @param preIndexingPhase
	 * @param selector
	 */
	void inferFullState(JvmDeclaredType jvmType, EObject semanticElement,
			IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase,
			String selector);

}

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
package org.lunifera.dsl.datatype.xtext;

import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.lunifera.dsl.datatype.xtext.valueconverter.DatatypesQualifiedNameProvider;
import org.lunifera.dsl.xtext.lazyresolver.IndexDerivedStateComputer;
import org.lunifera.dsl.xtext.lazyresolver.SemanticLoadingResource;
import org.lunifera.dsl.xtext.lazyresolver.api.IIndexModelAssociator;
import org.lunifera.dsl.xtext.lazyresolver.linker.FastLinkingService;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class DatatypeGrammarRuntimeModule extends
		org.lunifera.dsl.datatype.xtext.AbstractDatatypeGrammarRuntimeModule {

	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DatatypesQualifiedNameProvider.class;
	}

	public Class<? extends org.eclipse.xtext.resource.XtextResource> bindXtextResource() {
		return SemanticLoadingResource.class;
	}

	public Class<? extends ILinkingService> bindILinkingService() {
		return FastLinkingService.class;
	}

	// public void configureIJvmModelAssociations(Binder binder) {
	// binder.bind(IJvmModelAssociations.class)
	// .to(IIndexModelAssociator.class);
	// }

//	public Class<? extends IJvmModelAssociator> bindIJvmModelAssociator() {
//		return IndexDerivedStateComputer.class;
//	}
//
//	public Class<? extends IIndexModelAssociator> bindIIndexModelAssociator() {
//		return IndexDerivedStateComputer.class;
//	}
//
//	public Class<? extends IJvmModelAssociations> bindIJvmModelAssociations() {
//		return IndexDerivedStateComputer.class;
//	}
}

/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.datatype.xtext;

import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.lunifera.dsl.datatype.xtext.generator.Generator;
import org.lunifera.dsl.datatype.xtext.generator.OutputConfigurationProvider;
import org.lunifera.dsl.datatype.xtext.valueconverter.DatatypesQualifiedNameProvider;
import org.lunifera.dsl.xtext.lazyresolver.SemanticLoadingResource;
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

	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return Generator.class;
	}
	
	public Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return OutputConfigurationProvider.class;
	}
	
}

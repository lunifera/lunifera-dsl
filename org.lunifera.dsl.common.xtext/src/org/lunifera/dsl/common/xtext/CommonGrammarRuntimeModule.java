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
package org.lunifera.dsl.common.xtext;

import org.eclipse.xtext.linking.ILinkingService;
import org.lunifera.dsl.xtext.lazyresolver.SemanticLoadingResource;
import org.lunifera.dsl.xtext.lazyresolver.linker.FastLinkingService;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class CommonGrammarRuntimeModule extends
		org.lunifera.dsl.common.xtext.AbstractCommonGrammarRuntimeModule {

	public Class<? extends org.eclipse.xtext.resource.XtextResource> bindXtextResource() {
		return SemanticLoadingResource.class;
	}
	
	public Class<? extends ILinkingService> bindILinkingService() {
		return FastLinkingService.class;
	}

}

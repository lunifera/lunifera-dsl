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
package org.lunifera.dsl.dto.xtext;

import org.lunifera.dsl.xtext.types.bundles.BundleSpaceTypeProviderFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * It uses the {@link BundleSpaceTypeProviderFactory}.
 */
@SuppressWarnings("restriction")
public class DtoGrammarBundleSpaceSetup extends
		DtoGrammarStandaloneSetup {

	public static void doSetup() {
		new DtoGrammarBundleSpaceSetup()
				.createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		org.lunifera.dsl.common.xtext.CommonGrammarBundleSpaceSetup
				.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}

	public Injector createInjector() {
		return Guice.createInjector(new DtoGrammarBundleSpaceModule());
	}

}

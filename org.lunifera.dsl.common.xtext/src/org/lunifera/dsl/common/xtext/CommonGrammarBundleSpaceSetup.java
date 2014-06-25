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
package org.lunifera.dsl.common.xtext;

import org.lunifera.xtext.builder.xbase.setups.XbaseWithAnnotationsBundleSpaceStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
@SuppressWarnings("restriction")
public class CommonGrammarBundleSpaceSetup extends CommonGrammarStandaloneSetup {

	public static void doSetup() {
		new CommonGrammarBundleSpaceSetup()
				.createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		XbaseWithAnnotationsBundleSpaceStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}

	public Injector createInjector() {
		return Guice
				.createInjector(new org.lunifera.dsl.common.xtext.CommonGrammarBundleSpaceModule());
	}

}

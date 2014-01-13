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
package org.lunifera.dsl.entity.xtext.tests;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.lunifera.dsl.entity.xtext.EntityGrammarStandaloneSetup;

import com.google.inject.Injector;

public class InjectorProvider implements IInjectorProvider {

	@SuppressWarnings("restriction")
	@Override
	public Injector getInjector() {
		return new EntityGrammarStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
	}

}

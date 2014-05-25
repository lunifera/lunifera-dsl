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
package org.lunifera.dsl.metadata.services.impl;

import org.lunifera.dsl.datatype.xtext.DatatypeGrammarStandaloneSetup;
import org.lunifera.dsl.entity.xtext.EntityGrammarStandaloneSetup;

import com.google.inject.Injector;

/**
 * A helper class to setup the Xtext grammars properly.
 */
public class StandaloneGrammarsSetup {

	@SuppressWarnings("restriction")
	public static Injector setup() {
		DatatypeGrammarStandaloneSetup.doSetup();
		return EntityGrammarStandaloneSetup.doSetup();
	}

}

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
package org.lunifera.dsl.xtext.builder.participant.impl;

import org.lunifera.dsl.datatype.xtext.DatatypeGrammarBundleSpaceSetup;
import org.lunifera.dsl.dto.xtext.DtoGrammarBundleSpaceSetup;
import org.lunifera.dsl.entity.xtext.EntityGrammarBundleSpaceSetup;

/**
 * A helper class to setup the Xtext grammars properly.
 */
@SuppressWarnings("restriction")
public class StandaloneGrammarsSetup {

	public static void setup() {
		DatatypeGrammarBundleSpaceSetup.doSetup();
		DtoGrammarBundleSpaceSetup.doSetup();
		EntityGrammarBundleSpaceSetup.doSetup();
	}

}

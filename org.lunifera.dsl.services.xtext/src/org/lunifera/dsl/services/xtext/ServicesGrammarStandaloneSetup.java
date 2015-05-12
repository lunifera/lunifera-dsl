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
package org.lunifera.dsl.services.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ServicesGrammarStandaloneSetup extends ServicesGrammarStandaloneSetupGenerated{

	public static void doSetup() {
		new ServicesGrammarStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


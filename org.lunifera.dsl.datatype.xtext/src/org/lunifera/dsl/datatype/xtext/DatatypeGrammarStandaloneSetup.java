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

import org.eclipse.emf.ecore.EPackage;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class DatatypeGrammarStandaloneSetup extends
		DatatypeGrammarStandaloneSetupGenerated {

	public static void doSetup() {
		if (!EPackage.Registry.INSTANCE
				.containsKey("http://www.lunifera.org/dsl/common/types/v1")) {
			EPackage.Registry.INSTANCE.put(
					"http://www.lunifera.org/dsl/common/types/v1",
					LunTypesPackage.eINSTANCE);
		}

		new DatatypeGrammarStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
	}
}

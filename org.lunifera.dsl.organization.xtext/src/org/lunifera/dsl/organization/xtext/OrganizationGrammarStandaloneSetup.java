/*******************************************************************************
 * Copyright (c) 2011, 2012 Cristiano Gavião - Lunifera.org.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cristiano Gavião - initial API and implementation
 *******************************************************************************/

package org.lunifera.dsl.organization.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class OrganizationGrammarStandaloneSetup extends
		OrganizationGrammarStandaloneSetupGenerated {

	public static void doSetup() {
		new OrganizationGrammarStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
	}

	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE
				.containsKey(OrganizationPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(OrganizationPackage.eNS_URI,
					OrganizationPackage.eINSTANCE);
		}

		super.register(injector);
	}
}

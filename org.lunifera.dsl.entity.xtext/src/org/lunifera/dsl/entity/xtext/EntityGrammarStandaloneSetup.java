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
package org.lunifera.dsl.entity.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.entity.EntityPackage;
import org.lunifera.dsl.semantic.entity.impl.EntityFactoryImplCustom;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class EntityGrammarStandaloneSetup extends
		EntityGrammarStandaloneSetupGenerated {

	public static void doSetup() {
		new EntityGrammarStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE
				.containsKey("http://www.lunifera.org/entity/v1")) {
			EPackage.Registry.INSTANCE.put(
					"http://www.lunifera.org/dsl/entity/v1",
					EntityPackage.eINSTANCE);
			EntityPackage.eINSTANCE
					.setEFactoryInstance(new EntityFactoryImplCustom());
		}

		if (!EPackage.Registry.INSTANCE
				.containsKey("http://www.lunifera.org/dsl/common/types/v1")) {
			EPackage.Registry.INSTANCE.put(
					"http://www.lunifera.org/dsl/common/types/v1",
					LunTypesPackage.eINSTANCE);
		}

		super.register(injector);

	}
}

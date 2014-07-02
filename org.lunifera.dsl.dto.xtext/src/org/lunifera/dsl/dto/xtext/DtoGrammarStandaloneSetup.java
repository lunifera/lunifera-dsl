
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
 
package org.lunifera.dsl.dto.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;
import org.lunifera.dsl.semantic.dto.impl.DtoFactoryImplCustom;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;
import org.lunifera.dsl.semantic.entity.impl.EntityFactoryImplCustom;

import com.google.inject.Injector;




/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class DtoGrammarStandaloneSetup extends
		DtoGrammarStandaloneSetupGenerated {

	public static void doSetup() {
		new DtoGrammarStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE
				.containsKey("http://www.lunifera.org/dto/v1")) {
			EPackage.Registry.INSTANCE.put(
					"http://www.lunifera.org/dsl/dto/v1", LunDtoPackage.eINSTANCE);
			LunDtoPackage.eINSTANCE
					.setEFactoryInstance(new DtoFactoryImplCustom());
		}

		if (!EPackage.Registry.INSTANCE
				.containsKey("http://www.lunifera.org/entity/v1")) {
			EPackage.Registry.INSTANCE.put(
					"http://www.lunifera.org/dsl/entity/v1",
					LunEntityPackage.eINSTANCE);
			LunEntityPackage.eINSTANCE
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

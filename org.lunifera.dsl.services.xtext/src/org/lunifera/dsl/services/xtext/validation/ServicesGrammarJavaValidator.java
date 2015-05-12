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
package org.lunifera.dsl.services.xtext.validation;

import java.util.List;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Extension;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

@SuppressWarnings("restriction")
public class ServicesGrammarJavaValidator
		extends
		org.lunifera.dsl.services.xtext.validation.AbstractServicesGrammarJavaValidator {

	@Check
	public void checkClassPath(LTypedPackage model) {
		TypeReferences typeReferences = getServices().getTypeReferences();
		final JvmGenericType listType = (JvmGenericType) typeReferences
				.findDeclaredType(List.class, model);
		if (listType == null || listType.getTypeParameters().isEmpty()) {
			error("Couldn't find a JDK 1.5 or higher on the project's classpath.",
					model, LunTypesPackage.Literals.LPACKAGE__NAME,
					CODE__MISSING__JDK_1_5);
		}
		if (typeReferences.findDeclaredType(
				"org.lunifera.dsl.dto.lib.services.IDTOService", model) == null) {
			error("Couldn't find the mandatory library 'org.lunifera.dsl.dto.lib' on the project's classpath.",
					model, LunTypesPackage.Literals.LPACKAGE__NAME,
					CODE__MISSING__DTO_LIB);
		}
		if (typeReferences.findDeclaredType(
				"org.lunifera.runtime.common.annotations.Dispose", model) == null) {
			error("Couldn't find the mandatory library 'org.lunifera.runtime.common' on the project's classpath.",
					model, LunTypesPackage.Literals.LPACKAGE__NAME,
					CODE__MISSING__L_RUNTIME_COMMON);
		}
		if (typeReferences.findDeclaredType(Extension.class, model) == null) {
			error("Couldn't find the mandatory library 'org.eclipse.xtext.xbase.lib' 2.7.3 or higher on the project's classpath.",
					model, LunTypesPackage.Literals.LPACKAGE__NAME,
					CODE__MISSING__XBASE_LIB);
		}
		if (typeReferences.findDeclaredType("java.persistence.Persistence",
				model) == null) {
			warning("Couldn't find the optional library 'javax.persistence' 2.1.0 or higher on the project's classpath. If you are using JPA-Dto-Services, the library is mandatory.",
					model, LunTypesPackage.Literals.LPACKAGE__NAME,
					CODE__MISSING__JAVAX_PERSISTENCE);
		}
		if (typeReferences.findDeclaredType(
				"org.lunifera.dsl.common.datatypes.IDatatypeConstants", model) == null) {
			warning("Couldn't find the optional library 'org.lunifera.dsl.datatype.lib' on the project's classpath. This may cause resolving problems.",
					model, LunTypesPackage.Literals.LPACKAGE__NAME,
					CODE__MISSING__DATATYPE_LIB);
		}
	}
}

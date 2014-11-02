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
package org.lunifera.dsl.common.xtext.scope;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportScope;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.semantic.common.types.LPackage;
import org.lunifera.dsl.semantic.common.types.LType;

import com.google.inject.Inject;

public class CommonImportedNamespaceAwareLocalScopeProvider extends
		ImportedNamespaceAwareLocalScopeProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private ModelExtensions extensions;

	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> temp = new ArrayList<ImportNormalizer>();
//		temp.add(new ImportNormalizer(qualifiedNameConverter.toQualifiedName("java.lang"), true,
//				ignoreCase));
//		temp.add(new ImportNormalizer(qualifiedNameConverter.toQualifiedName("java.util"), true,
//				ignoreCase));
		return temp;
	}

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(
			EObject context, boolean ignoreCase) {
		List<ImportNormalizer> result = new ArrayList<ImportNormalizer>();
		result.addAll(super.internalGetImportedNamespaceResolvers(context,
				ignoreCase));
//		if (context instanceof LType) {
//			LPackage lPackage = extensions.getPackage(((LType) context));
//			if (lPackage != null) {
//				QualifiedName qfn = getQualifiedNameProvider()
//						.getFullyQualifiedName(lPackage);
//				if (qfn != null) {
////					result.add(createImportedNamespaceResolver(
////							qualifiedNameConverter.toString(qfn) + ".*",
////							ignoreCase));
//				}
//			}
//		}
		return result;
	}
}

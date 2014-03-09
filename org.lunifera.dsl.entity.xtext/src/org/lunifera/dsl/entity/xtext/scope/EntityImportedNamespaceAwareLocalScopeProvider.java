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
package org.lunifera.dsl.entity.xtext.scope;

import java.util.List;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.common.xtext.scope.CommonImportedNamespaceAwareLocalScopeProvider;

import com.google.inject.Inject;

public class EntityImportedNamespaceAwareLocalScopeProvider extends
		CommonImportedNamespaceAwareLocalScopeProvider {

	@Inject
	IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	ModelExtensions extensions;

	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> temp = super.getImplicitImports(ignoreCase);
		temp.add(new ImportNormalizer(qualifiedNameConverter
				.toQualifiedName("java.beans"), true, ignoreCase));
		temp.add(new ImportNormalizer(qualifiedNameConverter
				.toQualifiedName("org.lunifera.dsl.common.datatypes"), true,
				ignoreCase));

		return temp;
	}
}

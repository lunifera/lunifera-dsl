/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Hans Georg Gl??ckler - Initial implementation
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.dto.xtext.scope;

import java.util.List;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.lunifera.dsl.common.xtext.scope.CommonImportedNamespaceAwareLocalScopeProvider;
import org.lunifera.dsl.dto.xtext.extensions.DtoModelExtensions;

import com.google.inject.Inject;

public class DtoImportedNamespaceAwareLocalScopeProvider extends
		CommonImportedNamespaceAwareLocalScopeProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private DtoModelExtensions extensions;

	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> temp = super.getImplicitImports(ignoreCase);

		temp.add(new ImportNormalizer(qualifiedNameConverter
				.toQualifiedName("org.lunifera.dsl.common.datatypes"), true,
				ignoreCase));

		return temp;
	}
}

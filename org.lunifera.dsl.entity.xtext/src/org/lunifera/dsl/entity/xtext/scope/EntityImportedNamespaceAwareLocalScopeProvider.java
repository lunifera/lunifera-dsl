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

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportScope;
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.common.xtext.scope.CommonImportedNamespaceAwareLocalScopeProvider;

import com.google.inject.Inject;

public class EntityImportedNamespaceAwareLocalScopeProvider extends
		CommonImportedNamespaceAwareLocalScopeProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private ModelExtensions extensions;

	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> temp = super.getImplicitImports(ignoreCase);
//		temp.add(new ImportNormalizer(qualifiedNameConverter
//				.toQualifiedName("java.beans"), true, ignoreCase));
//		temp.add(new ImportNormalizer(qualifiedNameConverter
//				.toQualifiedName("org.lunifera.dsl.common.datatypes"), true,
//				ignoreCase));

		return temp;
	}

	protected ImportScope createImportScope(IScope parent,
			List<ImportNormalizer> namespaceResolvers, ISelectable importFrom,
			EClass type, boolean ignoreCase) {
		return new ImportScope(namespaceResolvers, parent, importFrom, type,
				ignoreCase);
	}

	private static class ImportScopeCustom extends ImportScope {

		private List<ImportNormalizer> normalizers;
		private EClass type;

		public ImportScopeCustom(List<ImportNormalizer> namespaceResolvers,
				IScope parent, ISelectable importFrom, EClass type,
				boolean ignoreCase) {
			super(namespaceResolvers, parent, importFrom, type, ignoreCase);

			this.type = type;
			this.normalizers = removeDuplicates(namespaceResolvers);
		}

		@Override
		protected Iterable<IEObjectDescription> getLocalElementsByName(
				QualifiedName name) {

			List<IEObjectDescription> result = newArrayList();
			QualifiedName resolvedQualifiedName = null;
			ISelectable importFrom = getImportFrom();

			for (ImportNormalizer normalizer : normalizers) {
				final QualifiedName resolvedName = normalizer.resolve(name);
				if (resolvedName != null) {
					Iterable<IEObjectDescription> resolvedElements = importFrom
							.getExportedObjects(type, resolvedName,
									isIgnoreCase());
					for (IEObjectDescription resolvedElement : resolvedElements) {
						if (resolvedQualifiedName == null)
							resolvedQualifiedName = resolvedName;
						else if (!resolvedQualifiedName.equals(resolvedName)) {
							if (result.get(0).getEObjectOrProxy() != resolvedElement
									.getEObjectOrProxy()) {
								return emptyList();
							}
						}
						QualifiedName alias = normalizer
								.deresolve(resolvedElement.getName());
						if (alias == null)
							throw new IllegalStateException(
									"Couldn't deresolve "
											+ resolvedElement.getName()
											+ " with import " + normalizer);
						final AliasedEObjectDescription aliasedEObjectDescription = new AliasedEObjectDescription(
								alias, resolvedElement);
						result.add(aliasedEObjectDescription);
					}
				}
			}
			return result;
		}
	}
}

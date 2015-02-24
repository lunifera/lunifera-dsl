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
package org.lunifera.dsl.xtext.lazyresolver.scoping;

import static java.util.Collections.singletonList;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.scoping.impl.MultimapBasedSelectable;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.lunifera.dsl.xtext.lazyresolver.SemanticLoadingResource;
import org.lunifera.dsl.xtext.lazyresolver.api.ISemanticLoadingResource;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class FastImportedNamespaceAwareLocalScopeProvider extends
		ImportedNamespaceAwareLocalScopeProvider {

	private boolean collectingParents;

	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;

	protected IScope getResourceScope(Resource res, EReference reference) {
		EObject context = null;
		if (res instanceof ISemanticLoadingResource) {
			context = ((ISemanticLoadingResource) res).getSemanticElement();
		} else {
			context = res.getContents().get(0);
		}
		IScope globalScope = getGlobalScope(res, reference);
		List<ImportNormalizer> normalizers = getImplicitImports(isIgnoreCase(reference));
		if (!normalizers.isEmpty()) {
			globalScope = createImportScope(globalScope, normalizers, null,
					reference.getEReferenceType(), isIgnoreCase(reference));
		}
		return getResourceScope(globalScope, context, reference);
	}

	protected IScope getResourceScope(final IScope parent,
			final EObject context, final EReference reference) {
		if (context.eResource() == null)
			return parent;

		ISelectable allDescriptions = null;
		if (context.eResource() instanceof SemanticLoadingResource
				&& !EcoreUtil2.isAssignableFrom(
						TypesPackage.Literals.JVM_TYPE_REFERENCE,
						reference.eClass())) {
			// avoid derived state creation
			allDescriptions = getSemanticDescription((SemanticLoadingResource) context
					.eResource());
		} else {
			allDescriptions = getAllDescriptions(context.eResource());
		}
		return SelectableBasedScope.createScope(parent, allDescriptions,
				reference.getEReferenceType(), isIgnoreCase(reference));
	}

	protected ISelectable getSemanticDescription(
			final SemanticLoadingResource resource) {
		return cache.get("internalGetSemanticDescription", resource,
				new Provider<ISelectable>() {
					public ISelectable get() {
						return internalGetSemanticDescription(resource);
					}
				});
	}

	protected ISelectable internalGetSemanticDescription(
			final SemanticLoadingResource resource) {
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllContents(resource.getSemanticElement(),
						false);
			}
		};

		Iterable<IEObjectDescription> allDescriptions = Scopes
				.scopedElementsFor(allContents, getQualifiedNameProvider());
		return new MultimapBasedSelectable(allDescriptions);
	}

	protected IScope getLocalElementsScope(IScope parent,
			final EObject context, final EReference reference) {
		IScope result = parent;
		ISelectable allDescriptions = null;
		if (context.eResource() instanceof SemanticLoadingResource
				&& !EcoreUtil2.isAssignableFrom(
						TypesPackage.Literals.JVM_TYPE_REFERENCE,
						reference.eClass())) {
			// avoid derived state creation
			allDescriptions = getSemanticDescription((SemanticLoadingResource) context
					.eResource());
		} else {
			allDescriptions = getAllDescriptions(context.eResource());
		}

		QualifiedName name = getQualifiedNameOfLocalElement(context);
		boolean ignoreCase = isIgnoreCase(reference);
		final List<ImportNormalizer> namespaceResolvers = getImportedNamespaceResolvers(
				context, ignoreCase);
		if (!namespaceResolvers.isEmpty()) {
			if (isRelativeImport() && name != null) {
				ImportNormalizer localNormalizer = doCreateImportNormalizer(
						name, true, ignoreCase);
				result = createImportScope(result,
						singletonList(localNormalizer), allDescriptions,
						reference.getEReferenceType(), isIgnoreCase(reference));
			}
			result = createImportScope(result, namespaceResolvers, null,
					reference.getEReferenceType(), isIgnoreCase(reference));
		}
		if (name != null) {
			ImportNormalizer localNormalizer = doCreateImportNormalizer(name,
					true, ignoreCase);
			result = createImportScope(result, singletonList(localNormalizer),
					allDescriptions, reference.getEReferenceType(),
					isIgnoreCase(reference));
		}
		return result;
	}

	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		if (!collectingParents) {
			try {
				collectingParents = true;
				return getCachingScope(context, reference);
			} finally {
				collectingParents = false;
			}
		} else {
			return super.getScope(context, reference);
		}
	}

	public IScope getCachingScope(final EObject context,
			final EReference reference) {
		final String cacheId = getCacheID(reference);
		return cache.get(cacheId, context.eResource(), new Provider<IScope>() {
			public IScope get() {
				try {
					collectingParents = true;
					final IScope parent = getScope(context, reference);
					return new CachingTypeScope(cacheId, parent);
				} finally {
					collectingParents = false;
				}
			}
		});
	}

	private String getCacheID(final EReference reference) {
		EClass eClass = reference.getEReferenceType();
		EPackage ePkg = eClass.getEPackage();

		return ePkg.getNsURI() + "-" + eClass.getName();
	}

	@Override
	protected boolean isRelativeImport() {
		// do not so to improve performance
		return false;
	}

}

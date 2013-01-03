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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.containers.FlatResourceSetBasedAllContainersState;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider;

import com.google.common.collect.Lists;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class OrganizationGrammarRuntimeModule extends
		AbstractOrganizationGrammarRuntimeModule {

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return org.lunifera.dsl.organization.xtext.naming.OrganizationGrammarQualifiedNameProvider.class;
	}

	// TODO this is needed due this bug:
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=382555

	public Class<? extends IAllContainersState.Provider> bindIAllContainersState$Provider() {
		return FixedResourceSetBasedAllContainersStateProvider.class;
	}

	public static class FixedResourceSetBasedAllContainersStateProvider extends
			ResourceSetBasedAllContainersStateProvider {

		@Override
		protected IAllContainersState handleAdapterNotFound(
				ResourceSet resourceSet) {
			return new FixedFlatResourceSetBasedAllContainersState(resourceSet);
		}
	}

	public static class FixedFlatResourceSetBasedAllContainersState extends
			FlatResourceSetBasedAllContainersState {

		public FixedFlatResourceSetBasedAllContainersState(ResourceSet rs) {
			super(rs);
		}

		public Collection<URI> getContainedURIs(String containerHandle) {
			if (!getHandle().equals(containerHandle))
				return Collections.emptySet();
			ResourceSet resourceSet = getResourceSet();
			List<URI> uris = Lists.newArrayListWithCapacity(resourceSet
					.getResources().size());
			URIConverter uriConverter = resourceSet.getURIConverter();
			for (Resource r : resourceSet.getResources())
				uris.add(uriConverter.normalize(r.getURI()));
			return uris;
		}
	}
}

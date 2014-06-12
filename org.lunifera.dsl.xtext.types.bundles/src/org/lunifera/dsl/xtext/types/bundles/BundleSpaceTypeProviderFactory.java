/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 * 
 * Based on Xtext org.eclipse.xtext.common.types.access.reflect.ReflectionTypeProviderFactory
 */
package org.lunifera.dsl.xtext.types.bundles;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class BundleSpaceTypeProviderFactory extends AbstractTypeProviderFactory {

	@Inject
	private BundleSpaceResourceSetProvider bundleSpaceProvider;

	public BundleSpaceTypeProviderFactory() {
	}

	public BundleSpaceTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		BundleSpaceTypeProvider result = createClasspathTypeProvider(resourceSet);
		return result;
	}

	protected BundleSpaceTypeProvider createClasspathTypeProvider(
			ResourceSet resourceSet) {
		return new BundleSpaceTypeProvider(
				bundleSpaceProvider.getBundleSpace(resourceSet), resourceSet,
				getIndexedJvmTypeAccess());
	}

	@Override
	public BundleSpaceTypeProvider createTypeProvider() {
		return (BundleSpaceTypeProvider) super.createTypeProvider();
	}

	@Override
	public BundleSpaceTypeProvider findTypeProvider(ResourceSet resourceSet) {
		return (BundleSpaceTypeProvider) super.findTypeProvider(resourceSet);
	}

}

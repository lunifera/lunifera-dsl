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
package org.lunifera.dsl.metadata.services.impl;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.lunifera.dsl.xtext.types.bundles.BundleSpaceTypeProviderFactory;
import org.lunifera.dsl.xtext.types.bundles.BundleSpaceTypeScopeProvider;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

@SuppressWarnings("restriction")
public class MetadataBuilderModule extends AbstractModule {

	protected void configure() {
		bind(IResourceDescriptions.class).annotatedWith(
				Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE))
				.to(ResourceSetBasedResourceDescriptions.class);
		bind(IResourceDescriptions.class).annotatedWith(
				Names.named(ResourceDescriptionsProvider.LIVE_SCOPE)).to(
				ResourceSetBasedResourceDescriptions.class);
		bind(IResourceDescriptions.class).to(
				ResourceSetBasedResourceDescriptions.class);
		bind(AbstractTypeScopeProvider.class).to(
				BundleSpaceTypeScopeProvider.class);
		bind(IJvmTypeProvider.Factory.class).to(
				BundleSpaceTypeProviderFactory.class);
	}
}

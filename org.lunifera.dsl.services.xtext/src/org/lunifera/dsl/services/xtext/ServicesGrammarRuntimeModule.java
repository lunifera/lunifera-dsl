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
package org.lunifera.dsl.services.xtext;

import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.lunifera.dsl.services.xtext.extensions.ServicesTypesBuilder;
import org.lunifera.dsl.services.xtext.formatting.ServicesGrammarFormatter;
import org.lunifera.dsl.services.xtext.generator.Generator;
import org.lunifera.dsl.services.xtext.jvmmodel.ServicesGrammarJvmModelInferrer;
import org.lunifera.dsl.services.xtext.linker.ServicesJvmLinkingHelper;
import org.lunifera.dsl.services.xtext.scope.ServicesBatchScopeProvider;
import org.lunifera.dsl.services.xtext.scope.ServicesImportedNamespaceAwareLocalScopeProvider;
import org.lunifera.dsl.services.xtext.scope.ServicesScopeProvider;
import org.lunifera.dsl.services.xtext.serializer.ServiceGrammarTransientValueService;
import org.lunifera.dsl.services.xtext.valueconverter.ServicesQualifiedNameProvider;
import org.lunifera.dsl.xtext.lazyresolver.IndexDerivedStateComputer;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinker;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper;
import org.lunifera.dsl.xtext.lazyresolver.SemanticLoadingResource;
import org.lunifera.dsl.xtext.lazyresolver.api.IIndexModelAssociator;
import org.lunifera.dsl.xtext.lazyresolver.linker.FastLinkingService;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class ServicesGrammarRuntimeModule extends
		org.lunifera.dsl.services.xtext.AbstractServicesGrammarRuntimeModule {

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return ServicesQualifiedNameProvider.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return ServicesScopeProvider.class;
	}

	@Override
	public Class<? extends XbaseBatchScopeProvider> bindXbaseBatchScopeProvider() {
		return ServicesBatchScopeProvider.class;
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class)
				.annotatedWith(
						Names.named("org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.delegate"))
				.to(ServicesImportedNamespaceAwareLocalScopeProvider.class);
	}

	public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
		return ServicesGrammarJvmModelInferrer.class;
	}

	public Class<? extends IFormatter> bindIFormatter() {
		return ServicesGrammarFormatter.class;
	}

	public Class<? extends org.lunifera.dsl.common.xtext.extensions.AnnotationExtension> bindAnnotationExtension() {
		return org.lunifera.dsl.services.xtext.extensions.AnnotationExtension.class;
	}

	public Class<? extends JvmTypesBuilder> bindJvmTypesBuilder() {
		return ServicesTypesBuilder.class;
	}

	public Class<? extends org.lunifera.dsl.common.xtext.extensions.ModelExtensions> bindModelExtensions() {
		return org.lunifera.dsl.services.xtext.extensions.ModelExtensions.class;
	}

	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return Generator.class;
	}

	public Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return org.lunifera.dsl.services.xtext.generator.OutputConfigurationProvider.class;
	}

	public Class<? extends org.eclipse.xtext.resource.XtextResource> bindXtextResource() {
		return SemanticLoadingResource.class;
	}

	public Class<? extends org.eclipse.xtext.linking.ILinker> bindILinker() {
		return LazyJvmTypeLinker.class;
	}

	public Class<? extends LazyJvmTypeLinkingHelper> bindJvmLinkingHelper() {
		return ServicesJvmLinkingHelper.class;
	}

	public Class<? extends org.eclipse.xtext.serializer.sequencer.ITransientValueService> bindSerializerITransientValueService() {
		return ServiceGrammarTransientValueService.class;
	}

	@Override
	public void configureSerializerIScopeProvider(Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
				.annotatedWith(
						org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding.class)
				.to(ServicesBatchScopeProvider.class);
	}

	public Class<? extends org.eclipse.xtext.resource.IDerivedStateComputer> bindIDerivedStateComputer() {
		return IndexDerivedStateComputer.class;
	}

	public Class<? extends ILinkingService> bindILinkingService() {
		return FastLinkingService.class;
	}

	public Class<? extends IJvmModelAssociator> bindIJvmModelAssociator() {
		return IndexDerivedStateComputer.class;
	}

	public Class<? extends IIndexModelAssociator> bindIIndexModelAssociator() {
		return IndexDerivedStateComputer.class;
	}

	public Class<? extends IJvmModelAssociations> bindIJvmModelAssociations() {
		return IndexDerivedStateComputer.class;
	}
}

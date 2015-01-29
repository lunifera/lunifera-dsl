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

package org.lunifera.dsl.dto.xtext;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.lunifera.dsl.dto.xtext.extensions.DtoTypesBuilder;
import org.lunifera.dsl.dto.xtext.formatting.DtoGrammarFormatter;
import org.lunifera.dsl.dto.xtext.generator.Generator;
import org.lunifera.dsl.dto.xtext.generator.OutputConfigurationProvider;
import org.lunifera.dsl.dto.xtext.jvmmodel.DtoGrammarJvmModelInferrer;
import org.lunifera.dsl.dto.xtext.linker.DtoJvmLinkingHelper;
import org.lunifera.dsl.dto.xtext.scope.DtoBatchScopeProvider;
import org.lunifera.dsl.dto.xtext.scope.DtoImportedNamespaceAwareLocalScopeProvider;
import org.lunifera.dsl.dto.xtext.scope.DtoScopeProvider;
import org.lunifera.dsl.dto.xtext.serializer.DtoGrammarTransientValueService;
import org.lunifera.dsl.dto.xtext.valueconverter.DtoQualifiedNameProvider;
import org.lunifera.dsl.dto.xtext.valueconverter.DtoValueConverterService;
import org.lunifera.dsl.xtext.lazyresolver.IndexDerivedStateComputer;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinker;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper;
import org.lunifera.dsl.xtext.lazyresolver.SemanticLoadingResource;
import org.lunifera.dsl.xtext.lazyresolver.linker.FastLinkingService;

import com.google.inject.Binder;
import com.google.inject.name.Names;

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

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
@SuppressWarnings("restriction")
public class DtoGrammarRuntimeModule extends
		org.lunifera.dsl.dto.xtext.AbstractDtoGrammarRuntimeModule {

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DtoQualifiedNameProvider.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return DtoScopeProvider.class;
	}

	@Override
	public Class<? extends XbaseBatchScopeProvider> bindXbaseBatchScopeProvider() {
		return DtoBatchScopeProvider.class;
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class)
				.annotatedWith(
						Names.named("org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.delegate"))
				.to(DtoImportedNamespaceAwareLocalScopeProvider.class);
	}

	public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
		return DtoGrammarJvmModelInferrer.class;
	}

	public Class<? extends IFormatter> bindIFormatter() {
		return DtoGrammarFormatter.class;
	}

	public Class<? extends org.lunifera.dsl.common.xtext.jvmmodel.AnnotationCompiler> bindAnnotationCompiler() {
		return org.lunifera.dsl.dto.xtext.jvmmodel.AnnotationCompiler.class;
	}

	public Class<? extends org.lunifera.dsl.common.xtext.extensions.AnnotationExtension> bindAnnotationExtension() {
		return org.lunifera.dsl.dto.xtext.extensions.AnnotationExtension.class;
	}

	public Class<? extends JvmTypesBuilder> bindJvmTypesBuilder() {
		return DtoTypesBuilder.class;
	}

	public Class<? extends org.lunifera.dsl.common.xtext.extensions.ModelExtensions> bindModelExtensions() {
		return org.lunifera.dsl.dto.xtext.extensions.DtoModelExtensions.class;
	}

	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return Generator.class;
	}

	public Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return OutputConfigurationProvider.class;
	}

	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return DtoValueConverterService.class;
	}

	public Class<? extends org.eclipse.xtext.resource.XtextResource> bindXtextResource() {
		return SemanticLoadingResource.class;
	}

	public Class<? extends org.eclipse.xtext.linking.ILinker> bindILinker() {
		return LazyJvmTypeLinker.class;
	}

	public Class<? extends LazyJvmTypeLinkingHelper> bindJvmLinkingHelper() {
		return DtoJvmLinkingHelper.class;
	}

	@Override
	public void configureSerializerIScopeProvider(Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
				.annotatedWith(
						org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding.class)
				.to(DtoScopeProvider.class);
	}

	public Class<? extends org.eclipse.xtext.serializer.sequencer.ITransientValueService> bindSerializerITransientValueService() {
		return DtoGrammarTransientValueService.class;
	}

	public Class<? extends org.eclipse.xtext.resource.IDerivedStateComputer> bindIDerivedStateComputer() {
		return IndexDerivedStateComputer.class;
	}
	
	public Class<? extends ILinkingService> bindILinkingService() {
		return FastLinkingService.class;
	}

}

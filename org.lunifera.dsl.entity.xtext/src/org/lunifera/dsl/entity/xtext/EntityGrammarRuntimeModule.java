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
package org.lunifera.dsl.entity.xtext;

import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.lunifera.dsl.entity.xtext.extensions.EntityTypesBuilder;
import org.lunifera.dsl.entity.xtext.formatting.EntityGrammarFormatter;
import org.lunifera.dsl.entity.xtext.jvmmodel.DerivedStateComputer;
import org.lunifera.dsl.entity.xtext.jvmmodel.EntityJvmModelGenerator;
import org.lunifera.dsl.entity.xtext.linker.EntityLinker;
import org.lunifera.dsl.entity.xtext.scope.EntityBatchScopeProvider;
import org.lunifera.dsl.entity.xtext.scope.EntityImportedNamespaceAwareLocalScopeProvider;
import org.lunifera.dsl.entity.xtext.scope.EntityScopeProvider;
import org.lunifera.dsl.entity.xtext.valueconverter.EntityQualifiedNameProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
@SuppressWarnings("restriction")
public class EntityGrammarRuntimeModule extends
		org.lunifera.dsl.entity.xtext.AbstractEntityGrammarRuntimeModule {

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return EntityQualifiedNameProvider.class;
	}

	@Override
	public Class<? extends XbaseBatchScopeProvider> bindXbaseBatchScopeProvider() {
		return EntityBatchScopeProvider.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return EntityScopeProvider.class;
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class)
				.annotatedWith(
						Names.named("org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.delegate"))
				.to(EntityImportedNamespaceAwareLocalScopeProvider.class);
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends IGenerator> bindIGenerator() {
		return EntityJvmModelGenerator.class;
	}

	public Class<? extends IFormatter> bindIFormatter() {
		return EntityGrammarFormatter.class;
	}

	public Class<? extends org.lunifera.dsl.common.xtext.jvmmodel.AnnotationCompiler> bindAnnotationCompiler() {
		return org.lunifera.dsl.entity.xtext.jvmmodel.AnnotationCompiler.class;
	}

	public Class<? extends JvmTypesBuilder> bindJvmTypesBuilder() {
		return EntityTypesBuilder.class;
	}

	public Class<? extends org.lunifera.dsl.common.xtext.extensions.ModelExtensions> bindModelExtensions() {
		return org.lunifera.dsl.entity.xtext.extensions.ModelExtensions.class;
	}

	public Class<? extends org.eclipse.xtext.linking.ILinker> bindILinker() {
		return EntityLinker.class;
	}

	public Class<? extends org.eclipse.xtext.resource.IDerivedStateComputer> bindIDerivedStateComputer() {
		return DerivedStateComputer.class;
	}
}

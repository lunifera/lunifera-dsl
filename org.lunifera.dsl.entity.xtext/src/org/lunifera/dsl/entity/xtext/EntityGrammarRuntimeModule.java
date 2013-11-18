/*
 * generated by Xtext
 */
package org.lunifera.dsl.entity.xtext;

import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.lunifera.dsl.entity.xtext.extensions.Constants;
import org.lunifera.dsl.entity.xtext.jvmmodel.DelegatingOperationContentCompiler;
import org.lunifera.dsl.entity.xtext.jvmmodel.EntityJvmModelGenerator;
import org.lunifera.dsl.entity.xtext.jvmmodel.services.IOperationContentCompiler;
import org.lunifera.dsl.entity.xtext.scope.EntityImportedNamespaceAwareLocalScopeProvider;
import org.lunifera.dsl.entity.xtext.scope.EntityScopeProvider;
import org.lunifera.dsl.entity.xtext.valueconverter.EntityQualifiedNameProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class EntityGrammarRuntimeModule extends
		org.lunifera.dsl.entity.xtext.AbstractEntityGrammarRuntimeModule {

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return EntityQualifiedNameProvider.class;
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

	// /**
	// * The modelInferrer delegate to be used for {@link LBean}s.
	// *
	// * @param binder
	// */
	// public void configurePojoJvmModelInferrerDelegate(Binder binder) {
	// binder.bind(IEntityJvmModelInferrerDelegate.class)
	// .annotatedWith(Names.named(Constants.POJO_COMPILER_FQN))
	// .to(PojoJvmModelInferrerDelegate.class);
	// }
	//
//	/**
//	 * The modelInferrer delegate to be used for JPA compiles.
//	 * 
//	 * @param binder
//	 */
//	public void configureJPAJvmModelInferrerDelegate(Binder binder) {
//		binder.bind(IEntityJvmModelInferrerDelegate.class)
//				.annotatedWith(
//						com.google.inject.name.Names
//								.named(Constants.JPA_COMPILER_FQN))
//				.to(JPAJvmModelInferrerDelegate.class);
//	}

	/**
	 * The operationsContentCompiler to be used to dispatch the calls.
	 */
	public void configureDelegateOperationsCompiler(Binder binder) {
		binder.bind(IOperationContentCompiler.class)
				.annotatedWith(Names.named(Constants.DELEGATE))
				.to(DelegatingOperationContentCompiler.class);
	}

	// /**
	// * The operationsContentCompiler to be used for entity compiles.
	// *
	// * @param binder
	// */
	// public void configurePojoOperationsCompiler(Binder binder) {
	// binder.bind(IOperationContentCompiler.class)
	// .annotatedWith(
	// com.google.inject.name.Names
	// .named(Constants.POJO_COMPILER_FQN))
	// .to(PojoOperationsGenerator.class);
	// }
	//
	// /**
	// * The operationsContentCompiler to be used for JPA compiles.
	// *
	// * @param binder
	// */
	// public void configureJPAOperationsCompiler(Binder binder) {
	// binder.bind(IOperationContentCompiler.class)
	// .annotatedWith(
	// com.google.inject.name.Names
	// .named(Constants.JPA_COMPILER_FQN))
	// .to(JPAOperationsGenerator.class);
	// }

	// /**
	// * The annotationCompiler to be used for pojo compiles.
	// *
	// * @param binder
	// */
	// public void configurePojoAnnotationCompiler(Binder binder) {
	// binder.bind(IAnnotationCompiler.class)
	// .annotatedWith(Names.named(Constants.POJO_COMPILER_FQN))
	// .to(PojoAnnotationCompiler.class);
	// }
	//
	// /**
	// * The annotationCompiler to be used for jpa compiles.
	// *
	// * @param binder
	// */
	// public void configureJPAAnnotationCompiler(Binder binder) {
	// binder.bind(IAnnotationCompiler.class)
	// .annotatedWith(Names.named(Constants.JPA_COMPILER_FQN))
	// .to(JPAAnnotationCompiler.class);
	// }

}

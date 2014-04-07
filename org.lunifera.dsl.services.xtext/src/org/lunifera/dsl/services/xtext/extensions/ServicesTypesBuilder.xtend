package org.lunifera.dsl.services.xtext.extensions

import com.google.inject.Inject
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator
import org.lunifera.dsl.common.xtext.extensions.TreeAppendableExtensions
import org.lunifera.dsl.common.xtext.jvmmodel.CommonTypesBuilder
import org.lunifera.dsl.common.xtext.jvmmodel.AnnotationCompiler

class ServicesTypesBuilder extends CommonTypesBuilder {

	@Inject extension ModelExtensions
	@Inject extension MethodNamingExtensions
	@Inject extension TreeAppendableExtensions
	@Inject extension IQualifiedNameProvider
	@Inject extension AnnotationExtension

	@Inject
	private IJvmModelAssociator associator;
	@Inject AnnotationCompiler annotationCompiler
	@Inject TypesFactory typesFactory;
	@Inject TypeReferences references;

}

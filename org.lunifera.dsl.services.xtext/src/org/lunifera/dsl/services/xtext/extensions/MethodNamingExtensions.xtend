package org.lunifera.dsl.services.xtext.extensions

import com.google.inject.Inject
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider
import org.eclipse.xtext.xbase.XExpression
import org.lunifera.dsl.common.xtext.extensions.NamingExtensions
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference
import org.lunifera.dsl.semantic.dto.LDtoFeature

class MethodNamingExtensions extends NamingExtensions {

	@Inject extension ModelExtensions;
	@Inject extension QualifiedNameProvider;


}

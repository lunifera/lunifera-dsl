/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.dto.xtext.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAttribute
import org.lunifera.dsl.semantic.dto.LDtoReference

/** 
 * This class is responsible to generate the Annotations defined in the entity model
 */
class AnnotationCompiler extends org.lunifera.dsl.common.xtext.jvmmodel.AnnotationCompiler {

	@Inject extension JvmTypesBuilder

	def protected dispatch void internalProcessAnnotation(LDto dto, JvmGenericType jvmType) {
		dto.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
	}

	def protected dispatch void internalProcessAnnotation(LDtoReference prop, JvmGenericType jvmType) {
		prop.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
	}

	def protected dispatch void internalProcessAnnotation(LDtoAttribute prop, JvmGenericType jvmType) {
		prop.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
	}
}

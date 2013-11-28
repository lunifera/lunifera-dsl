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
package org.lunifera.dsl.common.xtext.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.semantic.common.types.LAnnotationTarget
import org.lunifera.dsl.semantic.common.types.LOperation
import org.lunifera.dsl.semantic.common.types.LType

/** 
 * This class is responsible to generate the Annotations defined in the entity model
 */
class AnnotationCompiler {

	@Inject extension JvmTypesBuilder

	def processAnnotation(LAnnotationTarget annotationTarget, JvmMember jvmMember) {
		internalProcessAnnotation(annotationTarget, jvmMember)
	}

	def protected dispatch void internalProcessAnnotation(LType bean, JvmGenericType jvmType) {
		bean.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
	}

	def protected dispatch void internalProcessAnnotation(LOperation member, JvmOperation jvmOperation) {
		member.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmOperation);
	}

	def addAnno(LAnnotationTarget target, JvmAnnotationTarget jvmType, JvmAnnotationReference anno) {
		val annoDef = target.annotations.findFirst[annotation.annotationType == anno.annotation]
		if (annoDef == null || !annoDef.exclude) {
			jvmType.annotations += anno
		}
	}

}

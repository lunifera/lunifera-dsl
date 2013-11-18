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
package org.lunifera.dsl.entity.xtext.jvmmodel.services.bean

import com.google.inject.Inject
import javax.persistence.Embeddable
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.entity.semantic.model.LAnnotationTarget
import org.lunifera.dsl.entity.semantic.model.LClass
import org.lunifera.dsl.entity.semantic.model.LOperation
import org.lunifera.dsl.entity.semantic.model.LProperty
import org.lunifera.dsl.entity.xtext.jvmmodel.services.IAnnotationCompiler

/** 
 * This class is responsible to generate the JPAAnnotations
 */
class BeanAnnotationCompiler implements IAnnotationCompiler {

	@Inject extension JvmTypesBuilder

	def addAnno(LAnnotationTarget target, JvmAnnotationTarget jvmType, JvmAnnotationReference anno) {
		val annoDef = target.annotations.findFirst[annotation.annotationType == anno.annotation]
		if (annoDef == null || !annoDef.exclude) {
			jvmType.annotations += anno
		}
	}

	override processAnnotation(LClass lClass, JvmGenericType jvmType) {
		lClass.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);

		lClass.addAnno(jvmType, lClass.toAnnotation(typeof(Embeddable)))
	}

	override processAnnotation(LProperty member, JvmField jvmField) {
		member.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmField);
	}

	override processAnnotation(LOperation member, JvmOperation jvmOperation) {
		member.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmOperation);
	}
}

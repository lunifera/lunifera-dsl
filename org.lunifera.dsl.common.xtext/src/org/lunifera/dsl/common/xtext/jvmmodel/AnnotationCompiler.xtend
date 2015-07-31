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
package org.lunifera.dsl.common.xtext.jvmmodel

import com.google.inject.Inject
import javax.validation.constraints.AssertFalse
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Digits
import javax.validation.constraints.Future
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Null
import javax.validation.constraints.Past
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.common.xtext.extensions.AnnotationExtension
import org.lunifera.dsl.semantic.common.types.LAnnotationTarget
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LDataType
import org.lunifera.dsl.semantic.common.types.LDtCAssertFalse
import org.lunifera.dsl.semantic.common.types.LDtCAssertTrue
import org.lunifera.dsl.semantic.common.types.LDtCDecimalMax
import org.lunifera.dsl.semantic.common.types.LDtCDecimalMin
import org.lunifera.dsl.semantic.common.types.LDtCDigits
import org.lunifera.dsl.semantic.common.types.LDtCFuture
import org.lunifera.dsl.semantic.common.types.LDtCNotNull
import org.lunifera.dsl.semantic.common.types.LDtCNull
import org.lunifera.dsl.semantic.common.types.LDtCNumericMax
import org.lunifera.dsl.semantic.common.types.LDtCNumericMin
import org.lunifera.dsl.semantic.common.types.LDtCPast
import org.lunifera.dsl.semantic.common.types.LDtCRegEx
import org.lunifera.dsl.semantic.common.types.LDtCSize
import org.lunifera.dsl.semantic.common.types.LOperation
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LType

/** 
 * This class is responsible to generate the Annotations defined in the entity model
 */
class AnnotationCompiler {

	@Inject extension JvmTypesBuilder
	@Inject extension AnnotationExtension

	def processAnnotation(LAnnotationTarget annotationTarget, JvmMember jvmMember) {
		internalProcessAnnotation(annotationTarget, jvmMember)
	}

	def protected dispatch void internalProcessAnnotation(LType bean, JvmGenericType jvmType) {
		bean.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
	}

	def protected dispatch void internalProcessAnnotation(LReference ref, JvmField jvmType) {
		ref.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
	}

	def protected dispatch void internalProcessAnnotation(LAttribute att, JvmField jvmType) {
		att.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
	}

	def void toDatatypeBasedConstraintAnnotations(LAttribute att, JvmField jvmType) {
		if (att.type instanceof LDataType) {
			val LDataType dt = att.type as LDataType;
			for (c : dt.constraints) {
				c.toConstraintAnnotation(jvmType)
			}
		}
	}

	def protected dispatch void toConstraintAnnotation(LDtCAssertFalse constraint, JvmField field) {
		field.annotations += constraint.toAnnotation(typeof(AssertFalse))
	}

	def protected dispatch void toConstraintAnnotation(LDtCAssertTrue constraint, JvmField field) {
		field.annotations += constraint.toAnnotation(typeof(AssertTrue))
	}

	def protected dispatch void toConstraintAnnotation(LDtCNotNull constraint, JvmField field) {
		field.annotations += constraint.toAnnotation(typeof(NotNull))
	}

	def protected dispatch void toConstraintAnnotation(LDtCNull constraint, JvmField field) {
		field.annotations += constraint.toAnnotation(typeof(Null))
	}

	def protected dispatch void toConstraintAnnotation(LDtCFuture constraint, JvmField field) {
		field.annotations += constraint.toAnnotation(typeof(Future))
	}

	def protected dispatch void toConstraintAnnotation(LDtCPast constraint, JvmField field) {
		field.annotations += constraint.toAnnotation(typeof(Past))
	}

	def protected dispatch void toConstraintAnnotation(LDtCSize constraint, JvmField field) {
		val anno = constraint.toAnnotation(typeof(Size))
		if (constraint.min >= 0) {
			anno.addAnnAttr(constraint, "min", constraint.min)
		}
		if (constraint.max > 0) {
			anno.addAnnAttr(constraint, "max", constraint.max)
		}
		field.annotations += anno
	}

	def protected dispatch void toConstraintAnnotation(LDtCDigits constraint, JvmField field) {
		val anno = constraint.toAnnotation(typeof(Digits))
		if (constraint.intDigits >= 0) {
			anno.addAnnAttr(constraint, "integer", constraint.intDigits)
		}
		if (constraint.fractionDigits > 0) {
			anno.addAnnAttr(constraint, "fraction", constraint.fractionDigits)
		}
		field.annotations += anno
	}

	def protected dispatch void toConstraintAnnotation(LDtCDecimalMax constraint, JvmField field) {
		if (constraint.max > 0) {
			val anno = constraint.toAnnotation(typeof(DecimalMax))
			anno.addAnnAttr(constraint, "value", constraint.max)
			field.annotations += anno
		}
	}

	def protected dispatch void toConstraintAnnotation(LDtCDecimalMin constraint, JvmField field) {
		if (constraint.min >= 0) {
			val anno = constraint.toAnnotation(typeof(DecimalMin))
			anno.addAnnAttr(constraint, "value", constraint.min)
			field.annotations += anno
		}
	}

	def protected dispatch void toConstraintAnnotation(LDtCNumericMax constraint, JvmField field) {
		if (constraint.max > 0) {
			val anno = constraint.toAnnotation(typeof(Max))
			anno.addAnnAttr(constraint, "value", constraint.max)
			field.annotations += anno
		}
	}

	def protected dispatch void toConstraintAnnotation(LDtCNumericMin constraint, JvmField field) {
		if (constraint.min >= 0) {
			val anno = constraint.toAnnotation(typeof(Min))
			anno.addAnnAttr(constraint, "value", constraint.min)
			field.annotations += anno
		}
	}

	def protected dispatch void toConstraintAnnotation(LDtCRegEx constraint, JvmField field) {
		if (constraint.pattern != null && !constraint.pattern.isEmpty) {
			val anno = constraint.toAnnotation(typeof(Pattern))
			anno.addAnnAttr(constraint, "regexp", constraint.pattern)
			field.annotations += anno
		}
	}

	//	def protected dispatch void toConstraintAnnotation(LDtCPast constraint, JvmField field) {
	//		field.annotations += constraint.toAnnotation(typeof(Past))
	//	}
	def protected dispatch void internalProcessAnnotation(LOperation member, JvmOperation jvmOperation) {
		member.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmOperation);
	}
}

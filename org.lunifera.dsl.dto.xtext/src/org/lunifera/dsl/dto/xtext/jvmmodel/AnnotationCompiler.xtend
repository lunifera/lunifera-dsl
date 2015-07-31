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
package org.lunifera.dsl.dto.xtext.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.dto.xtext.extensions.AnnotationExtension
import org.lunifera.dsl.dto.xtext.extensions.DtoModelExtensions
import org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint
import org.lunifera.dsl.semantic.common.types.LResultFilters
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
import org.lunifera.dsl.semantic.dto.LDtoAttribute
import org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute
import org.lunifera.dsl.semantic.dto.LDtoInheritedReference
import org.lunifera.dsl.semantic.dto.LDtoReference
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntityReference
import org.lunifera.runtime.common.annotations.Dirty
import org.lunifera.runtime.common.annotations.Dispose
import org.lunifera.runtime.common.annotations.DomainDescription
import org.lunifera.runtime.common.annotations.DomainKey
import org.lunifera.runtime.common.annotations.DomainReference
import org.lunifera.runtime.common.annotations.TargetEnumConstraint
import org.lunifera.runtime.common.annotations.TargetEnumConstraints

/** 
 * This class is responsible to generate the Annotations defined in the entity model
 */
class AnnotationCompiler extends org.lunifera.dsl.common.xtext.jvmmodel.AnnotationCompiler {

	@Inject extension JvmTypesBuilder
	@Inject extension TypeHelper
	@Inject extension DtoModelExtensions
	@Inject extension AnnotationExtension

	def protected dispatch void internalProcessAnnotation(LDto dto, JvmGenericType jvmType) {
		dto.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
	}

	def protected dispatch void internalProcessAnnotation(LDtoReference prop, JvmGenericType jvmType) {
		prop.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
	}

	def protected dispatch void internalProcessAnnotation(LDtoReference prop, JvmField field) {
		prop.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(field);

		field.annotations += prop.toAnnotation(typeof(DomainReference))
	}

	def protected dispatch void internalProcessAnnotation(LDtoAttribute prop, JvmField field) {
		prop.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(field);

		if (prop.domainKey) {
			field.annotations += prop.toAnnotation(typeof(DomainKey))
		}

		if (prop.domainDescription) {
			field.annotations += prop.toAnnotation(typeof(DomainDescription))
		}
		
		if(prop.dirty){
			field.annotations += prop.toAnnotation(typeof(Dirty))
		}
		
		super.toDatatypeBasedConstraintAnnotations(prop, field)
	}

	def protected dispatch void internalProcessAnnotation(LDtoInheritedAttribute prop, JvmField field) {
		prop.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(field);

		if (prop.inheritedFeature.domainKey) {
			field.annotations += prop.toAnnotation(typeof(DomainKey))
		}

		if (prop.inheritedFeature.domainDescription) {
			field.annotations += prop.toAnnotation(typeof(DomainDescription))
		}
		
		super.toDatatypeBasedConstraintAnnotations(prop.inheritedFeature, field)
	}

	def protected dispatch void internalProcessAnnotation(LDtoInheritedReference prop, JvmField field) {
		prop.resolvedAnnotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(field);

		field.annotations += prop.toAnnotation(typeof(DomainReference))

		val inheritedRef = prop.inheritedFeature
		if (inheritedRef instanceof LEntityReference) {
			if (inheritedRef.resultFilters != null) {
				inheritedRef.resultFilters.addConstraintsAnno(field, prop.type)
			}
		} else if (inheritedRef instanceof LBeanReference) {
			if (inheritedRef.resultFilters != null) {
				inheritedRef.resultFilters.addConstraintsAnno(field, prop.type)
			}
		}
	}

	def void addConstraintsAnno(LResultFilters constraints, JvmField jvmField, LDto mapsTo) {

		// process the LAttributeMatchingConstraint
		if (!constraints.resultFilters.filter[it instanceof LAttributeMatchingConstraint].empty) {

			// collect all inner annotations
			val innerAnnotations = newArrayList()
			constraints.resultFilters.filter[it instanceof LAttributeMatchingConstraint].map[
				it as LAttributeMatchingConstraint].forEach [
				val enumClassTypeRef = attribute.name.findReplacementEnum(mapsTo)
				if (enumClassTypeRef != null) {
					val innerAnno = constraints.toAnnotation(typeof(TargetEnumConstraint))
					innerAnno.addAnnAttr(it, "targetProperty", attribute.name)
					innerAnno.addAnnAttr(it, "enumClass", enumClassTypeRef)
					innerAnno.addAnnAttr(it, "enumLiteral", matchingLiteral.name)
					innerAnnotations += innerAnno
				}
			]

			// now create the outer annotation and add the array of inner annotations
			val mainAnno = constraints.toAnnotation(typeof(TargetEnumConstraints))
			mainAnno.addAnnAttr(constraints, "constraints",
				innerAnnotations.toArray(<JvmAnnotationReference>newArrayOfSize(innerAnnotations.length)))
			jvmField.annotations += mainAnno
		}
	}

	/** 
	 * Iterates all attributes of the target dto. If a matching att name was found, the jvmType proxy will be returned.
	 */
	def JvmTypeReference findReplacementEnum(String property, LDto mapsTo) {
		for (att : mapsTo.allFeatures.filter[it instanceof LDtoAbstractAttribute].map[it as LDtoAbstractAttribute]) {
			if (att instanceof LDtoInheritedAttribute) {
				if (att.inheritedFeature.name.equals(property)) {
					return att.inheritedFeatureTypeJvm.cloneWithProxies
				}
			} else {
				if (att.name.equals(property)) {
					return att.typeJvm.cloneWithProxies
				}
			}
		}
		return null
	}

	def dispatch addDisposeFieldAnnotation(LDto dto, JvmField field) {
		addAnno(dto, field, dto.toAnnotation(typeof(Dispose)))
	}

	def dispatch addDisposeFieldAnnotation(LDto dto, JvmOperation op) {
		addAnno(dto, op, dto.toAnnotation(typeof(Dispose)))
	}

}

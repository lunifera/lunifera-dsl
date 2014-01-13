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
package org.lunifera.dsl.common.xtext.extensions

import com.google.inject.Inject
import java.beans.Transient
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.semantic.common.types.LAnnotationDef
import org.lunifera.dsl.semantic.common.types.LFeature

class AnnotationExtension {

	@Inject extension JvmTypesBuilder
	@Inject
	private TypesFactory typesFactory;
	@Inject
	private TypeReferences references;

	/**
	 * Creates an enum annotation value and adds it the the given annotation reference
	 */
	def dispatch addAnnAttr(JvmAnnotationReference annRef, EObject context, String name,
		Enum<?>... enums) {

		// create the parameter
		val value = typesFactory.createJvmEnumAnnotationValue
		annRef.values += value

		// create the enum type
		val declaredType = references.findDeclaredType(enums.get(0).declaringClass, context) as JvmDeclaredType
		for (Enum<?> enumxx : enums) {

			// create the operation
			val JvmOperation op = typesFactory.createJvmOperation
			op.setSimpleName(name)
			op.setDeclaringType(declaredType)
			value.setOperation(op)

			// create the literal
			val JvmEnumerationLiteral literal = typesFactory.createJvmEnumerationLiteral
			literal.setDeclaringType(declaredType)
			literal.setSimpleName(enumxx.name)
			value.values += literal
		}

		return value
	}

	/**
	 * Creates an enum annotation value and adds it the the given annotation reference
	 */
	def dispatch addAnnAttr(JvmAnnotationReference annRef, EObject context, String name,
		Enum<?> enumX) {

		// create the parameter
		val value = typesFactory.createJvmEnumAnnotationValue
		annRef.values += value

		// create the enum type
		val declaredType = references.findDeclaredType(enumX.declaringClass, context) as JvmDeclaredType

		// create the operation
		val JvmOperation op = typesFactory.createJvmOperation
		op.setSimpleName(name)
		op.setDeclaringType(declaredType)
		value.setOperation(op)

		// create the literal
		val JvmEnumerationLiteral literal = typesFactory.createJvmEnumerationLiteral
		literal.setDeclaringType(declaredType)
		literal.setSimpleName(enumX.name)
		value.values += literal

		return value
	}

	/**
     * Creates a boolean annotation value and adds it the the given annotation reference
     */
	def dispatch addAnnAttr(JvmAnnotationReference annRef, EObject context, String name,
		boolean booleanValue) {

		// create the parameter
		val value = typesFactory.createJvmBooleanAnnotationValue
		annRef.values += value

		// create the enum type
		val declaredType = references.findDeclaredType(typeof(Boolean), context) as JvmDeclaredType

		// create the operation
		val JvmOperation op = typesFactory.createJvmOperation
		op.setSimpleName(name)
		op.setDeclaringType(declaredType)
		value.setOperation(op)
		value.values += booleanValue

		return value
	}

	/**
     * Creates a string annotation value and adds it the the given annotation reference
     */
	def dispatch addAnnAttr(JvmAnnotationReference annRef, EObject context, String name,
		String stringValue) {

		// create the parameter
		val value = typesFactory.createJvmStringAnnotationValue
		annRef.values += value

		// create the enum type
		val declaredType = references.findDeclaredType(typeof(String), context) as JvmDeclaredType

		// create the operation
		val JvmOperation op = typesFactory.createJvmOperation
		op.setSimpleName(name)
		op.setDeclaringType(declaredType)
		value.setOperation(op)
		value.values += stringValue

		return value
	}

	/**
     * Creates a string annotation value and adds it the the given annotation reference
     */
	def dispatch addAnnAttr(JvmAnnotationReference annRef, EObject context, String name,
		int intValue) {

		// create the parameter
		val value = typesFactory.createJvmIntAnnotationValue
		annRef.values += value

		// create the enum type
		val declaredType = references.findDeclaredType(typeof(Integer), context) as JvmDeclaredType

		// create the operation
		val JvmOperation op = typesFactory.createJvmOperation
		op.setSimpleName(name)
		op.setDeclaringType(declaredType)
		value.setOperation(op)
		value.values += intValue

		return value
	}
	
	/**
     * Creates a string annotation value and adds it the the given annotation reference
     */
	def dispatch addAnnAttr(JvmAnnotationReference annRef, EObject context, String name,
		JvmAnnotationReference annotationValue) {

		// create the parameter
		val value = typesFactory.createJvmAnnotationAnnotationValue
		annRef.values += value

		// create the enum type
		val declaredType = references.findDeclaredType(typeof(JvmAnnotationReference), context) as JvmDeclaredType

		// create the operation
		val JvmOperation op = typesFactory.createJvmOperation
		op.setSimpleName(name)
		op.setDeclaringType(declaredType)
		value.setOperation(op)
		value.values += annotationValue

		return value
	}
	
		/**
     * Creates a string annotation value and adds it the the given annotation reference
     */
	def dispatch addAnnAttr(JvmAnnotationReference annRef, EObject context, String name,
		JvmAnnotationReference... annotationValues) {

		// create the parameter
		val value = typesFactory.createJvmAnnotationAnnotationValue
		annRef.values += value

		// create the enum type
		val declaredType = references.findDeclaredType(typeof(JvmAnnotationReference), context) as JvmDeclaredType

		// create the operation
		val JvmOperation op = typesFactory.createJvmOperation
		op.setSimpleName(name)
		op.setDeclaringType(declaredType)
		value.setOperation(op)
		value.values.addAll(annotationValues)

		return value
	}

	/**
	 * Returns a map with all excluded types
	 */
	def Map<String, LAnnotationDef> excludedTypes(List<LAnnotationDef> defs) {
		return defs.filter([exclude]).toMap(
			[
				val anno = it.annotation
				if (anno.annotationType != null) {
					return anno.annotationType.qualifiedName
				}
				return ""
			])
	}

	/**
	 * Returns a map with all included types
	 */
	def Map<String, LAnnotationDef> redefinedTypes(List<LAnnotationDef> defs) {
		return defs.filter([!exclude]).toMap(
			[
				val anno = it.annotation
				if (anno.annotationType != null) {
					return anno.annotationType.qualifiedName
				}
				return ""
			])
	}

	/**
	 * Returns true, if the clazz.canonicalName exists in the excluded types of defs
	 */
	def isExcluded(Class<?> clazz, List<LAnnotationDef> defs) {
		if (defs == null) {
			return false;
		}
		return defs.excludedTypes.containsKey(clazz.canonicalName)
	}

	/**
	 * Returns true, if the clazz.canonicalName exists in the included types of defs
	 */
	def isRedefined(Class<?> clazz, List<LAnnotationDef> defs) {
		if (defs == null) {
			return false;
		}
		return clazz.getRedefined(defs) != null
	}

	/**
	 * Returns true, if the clazz.canonicalName exists in the included types of defs
	 */
	def getRedefined(Class<?> clazz, List<LAnnotationDef> defs) {
		if (defs == null) {
			return null;
		}
		return defs.redefinedTypes.get(clazz.canonicalName)
	}

	def boolean isTransientAnnoExcluded(LFeature member) {
		return typeof(Transient).isExcluded(member.annotations)
	}

	def boolean isTransientAnnoRedefined(LFeature member) {
		return typeof(Transient).isRedefined(member.annotations)
	}

	def boolean isTransientAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(Transient), context)
	}

	def LAnnotationDef getTransientAnnoRedefine(LFeature member) {
		return typeof(Transient).getRedefined(member.annotations)
	}

	def boolean containsAnnotation(JvmAnnotationTarget target, Class<?> type, EObject context) {
		for (anno : target.annotations) {
			var JvmAnnotationType resolved
			val JvmAnnotationType xan = anno.annotation;
			if (xan != null) {
				if (xan.eIsProxy) {
					resolved = EcoreUtil::resolve(xan, context) as JvmAnnotationType
				} else {
					resolved = xan
				}
				if (resolved.qualifiedName != null) {
					if (resolved.qualifiedName.equals(type.canonicalName)) {
						return true;
					}
				}
			}
		}
	}
}

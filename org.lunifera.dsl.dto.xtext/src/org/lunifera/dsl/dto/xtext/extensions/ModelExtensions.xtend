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
package org.lunifera.dsl.dto.xtext.extensions

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAttribute
import org.lunifera.dsl.semantic.dto.LDtoOperation
import org.lunifera.dsl.semantic.dto.LDtoReference
import org.lunifera.dsl.semantic.entity.LEntityReference
import org.lunifera.dsl.semantic.entity.LEntityAttribute
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.dto.LDtoFeature

class ModelExtensions extends org.lunifera.dsl.common.xtext.extensions.ModelExtensions {

//	@Inject extension IQualifiedNameProvider
//	@Inject extension JvmTypesBuilder
//
//	def dispatch JvmTypeReference toTypeReference(LDtoReference prop) {
//		var jvmTypeRef = prop.type?.toTypeReference
//		if (jvmTypeRef != null && prop.isToMany) {
//			jvmTypeRef = newTypeRef(prop, typeof(List), jvmTypeRef);
//		}
//		return jvmTypeRef
//	}
//
//	def dispatch JvmTypeReference toTypeReference(LDtoWrappedReference prop) {
//		var jvmTypeRef = prop.toType?.toTypeReference
//		if (jvmTypeRef != null && prop.isToMany) {
//			jvmTypeRef = newTypeRef(prop, typeof(List), jvmTypeRef);
//		}
//		return jvmTypeRef
//	}
//
//	def dispatch isCascading(LDtoOperation prop) {
//		false
//	}
//
//	def dispatch isCascading(LDtoWrappedReference prop) {
//		prop.cascading
//	}
//
//	def getResolvedOpposite(LDtoReference prop) {
//
//		// For a toMany that has already an opposite, return it.
//		// Otherwise search in the referenced type for the property with the owner type.
//		if (prop.getOpposite() != null) {
//			return prop.getOpposite()
//		} else if (prop.type instanceof LDto) {
//			val LDto ref = prop.type as LDto
//			ref.references.findFirst[it.opposite == prop]
//		}
//	}
//
//	/**
//   	 * Returns true, if toCheck can be cast to superType
//   	 */
//	def boolean isCastable(LDto toCheck, LDto superType) {
//		val String toCheckFqn = toCheck.fullyQualifiedName.toString
//		val String superTypeFqn = superType.fullyQualifiedName.toString
//
//		if (toCheckFqn.equals(superTypeFqn)) {
//			return true
//		} else {
//			val LDto toCheckSuperType = toCheck.getSuperType
//			if (toCheckSuperType != null) {
//				return toCheckSuperType.isCastable(superType)
//			} else {
//				return false;
//			}
//		}
//	}
//
//	/**
//	 * The binary <code>+</code> operator that concatenates two strings.
//	 * 
//	 * @param a
//	 *            a string.
//	 * @param b
//	 *            another string.
//	 * @return <code>a + b</code>
//	 */
//	def static String operator_plus(String a, String b) {
//		return a + b;
//	}
//
//	def dispatch toType(LDtoAttribute prop) {
//		prop.type as LType
//	}
//	
//	def dispatch opposite(LDtoAttribute prop) {
//		null
//	}
//
//	def dispatch opposite(LDtoReference prop) {
//		prop.opposite
//	}
//	
//	def dispatch opposite(LDtoWrappedReference prop) {
//		
//	}
}

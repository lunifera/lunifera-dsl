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
import java.util.Date
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.semantic.common.helper.Bounds
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LClass
import org.lunifera.dsl.semantic.common.types.LDataType
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LPackage
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.common.types.LAnnotationTarget

class ModelExtensions {

	@Inject extension IQualifiedNameProvider
	@Inject extension JvmTypesBuilder

	@Inject TypeReferences references;

	def dispatch JvmTypeReference toTypeReference(LType type) {
		if (type == null || type.fullyQualifiedName == null) {
			return null
		}
		return type.newTypeRef(type.fullyQualifiedName.toString)
	}

	def dispatch JvmTypeReference toTypeReference(LDataType type) {
		if (type.syntheticFlag) {
			return type.toSyntheticTypeReference
		} else if (type.date) {
			return references.findDeclaredType(typeof(Date), type).newTypeRef()
		} else if (type.asBlob) {
			val typeRef = references.findDeclaredType(Byte::TYPE, type).newTypeRef()
			return references.createArrayType(typeRef)
		} else if (type.asPrimitive) {
			val fqn = type?.jvmTypeReference?.type?.fullyQualifiedName
			switch (fqn.toString) {
				case typeof(Integer).name: references.findDeclaredType(Integer::TYPE, type).newTypeRef()
				case typeof(Boolean).name: references.findDeclaredType(Boolean::TYPE, type).newTypeRef()
				case typeof(Short).name: references.findDeclaredType(Short::TYPE, type).newTypeRef()
				case typeof(Long).name: references.findDeclaredType(Long::TYPE, type).newTypeRef()
				case typeof(Double).name: references.findDeclaredType(Double::TYPE, type).newTypeRef()
				case typeof(Float).name: references.findDeclaredType(Float::TYPE, type).newTypeRef()
				case typeof(Character).name: references.findDeclaredType(Character::TYPE, type).newTypeRef()
				case typeof(Byte).name: references.findDeclaredType(Byte::TYPE, type).newTypeRef()
				case typeof(Boolean).name: references.findDeclaredType(Boolean::TYPE, type).newTypeRef()
				default: type?.jvmTypeReference
			}
		} else {
			return type.jvmTypeReference.cloneWithProxies
		}
	}
	
	
	def boolean isPrimitive(LDataType type) {
		return type.asPrimitive;
	}
	
	def JvmTypeReference toSyntheticTypeReference(LDataType type) {
	}

	def dispatch JvmTypeReference toTypeReference(LAttribute prop) {
		return prop.type?.toTypeReference
	}
	
	/**
	 * Create a type reference with respect to many multiplicity
	 */
	def dispatch JvmTypeReference toTypeReferenceWithMultiplicity(LAnnotationTarget context){
		var typeRef = context.toTypeReference
		if(typeRef != null && context.bounds.toMany){
			typeRef = context.toListTypeReference(typeRef)
		}
		return typeRef
	}
	
	def toListTypeReference(EObject context, JvmTypeReference jvmTypeRef){
		newTypeRef(context, typeof(List), jvmTypeRef);
	}
	
	def dispatch Bounds getBounds(LFeature prop) {
		Bounds::createFor(prop)
	}
	
	def dispatch Bounds getBounds(LAnnotationTarget context) {
		Bounds::createZeroToOne
	}
	
	def dispatch Bounds getBounds(Void context) {
		Bounds::createZeroToOne
	}
	
	def isToMany(LFeature prop) {
		prop.bounds.toMany
	}

	def dispatch isCascading(LAttribute prop) {
		prop.cascading
	}

	def dispatch isCascading(LReference prop) {
		prop.cascading
	}

	def typeIsBoolean(LFeature prop) {
		val typeRef = prop.toTypeReference
		return typeRef != null && !typeRef.eIsProxy() && typeRef.getType() != null && !typeRef.getType().eIsProxy() &&
			"boolean".equals(typeRef.getType().getIdentifier())
	}

	/**
   	 * Returns true, if toCheck can be cast to superType
   	 */
	def boolean nameEquals(LClass toCheck, LClass superType) {
		val String toCheckFqn = toCheck.fullyQualifiedName.toString
		val String superTypeFqn = superType.fullyQualifiedName.toString
		return toCheckFqn.equals(superTypeFqn);
	}

	/**
	 * Returns the {@link LPackage} for the given type.
	 * 
	 * @param lType
	 * @return
	 */
	def LPackage getPackage(LType lType) {
		var EObject current = lType;
		while (current != null && !(current instanceof LPackage)) {
			current = current.eContainer();
		}
		return current as LPackage;
	}

	def dispatch String toName(LFeature feature) {
		if(feature == null || feature.name == null) return ""
		return feature.name.replace("^", "")
	}

	def dispatch String toName(LClass clazz) {
		if (clazz == null || clazz.name == null) {
			return ""
		}
		return clazz.name.replace("^", "")
	}
	 
	def dispatch String toName(LType clazz) {
		if (clazz == null || clazz.name == null) {
			return ""
		}
		return clazz.name.replace("^", "")
	}

	/**
	 * The binary <code>+</code> operator that concatenates two strings.
	 * 
	 * @param a
	 *            a string.
	 * @param b
	 *            another string.
	 * @return <code>a + b</code>
	 */
	def static String operator_plus(String a, String b) {
		return a + b;
	}
}

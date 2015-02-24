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
import org.lunifera.dsl.semantic.common.types.LAnnotationTarget
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LClass
import org.lunifera.dsl.semantic.common.types.LDataType
import org.lunifera.dsl.semantic.common.types.LEnum
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LPackage
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.common.types.LTypedPackage

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

	def boolean isBool(LDataType type) {
		if (type.asPrimitive) {
			val fqn = type?.jvmTypeReference?.type?.fullyQualifiedName
			switch (fqn.toString) {
				case typeof(Boolean).name: return true
				default: return false
			}
		}
		return false
	}

	def boolean isPrimitive(LDataType type) {
		return type.asPrimitive;
	}
	
	def boolean isBasedOnDatatype(LFeature feature){
		if(feature instanceof LAttribute){
			return feature.type instanceof LDataType
		}
		return false
	}
	
	def LDataType getDatatype(LFeature feature){
		if(feature instanceof LAttribute){
			if(feature.type instanceof LDataType) {
				return feature.type as LDataType
			}
		}
		return null
	}

	def JvmTypeReference toSyntheticTypeReference(LDataType type) {
	}

	/**
	 * Returns true if jvm type proxies should be avoided for special datatypes like date or blob
	 */
	def boolean isAvoidJvmTypeProxiesForDatatype(LAttribute prop) {
		if (prop.type instanceof LDataType) {
//			val LDataType lDt = prop.type as LDataType
//			return lDt.asBlob || lDt.date
			return true
		}
		return false
	}

	/**
	 * Creates a jvmTypeReference based on the datatype.
	 */
	def JvmTypeReference toDataTypeTypeReference(LAttribute prop) {
		val LDataType lDt = prop.type as LDataType
		return lDt.toTypeReference
	}

	def dispatch JvmTypeReference toTypeReference(LAttribute prop) {
		if (isAvoidJvmTypeProxiesForDatatype(prop)) {
			return prop.toDataTypeTypeReference
		}
		// use the jvm type proxy
		return prop.typeJvm.cloneWithProxies
	}

	/**
	 * Create a type reference with respect to many multiplicity
	 */
	def dispatch JvmTypeReference toTypeReferenceWithMultiplicity(LAnnotationTarget context) {
		var typeRef = context.toTypeReference
		if (typeRef != null && context.bounds.toMany) {
			typeRef = context.toListTypeReference(typeRef)
		}
		return typeRef
	}

	def toListTypeReference(EObject context, JvmTypeReference jvmTypeRef) {
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
		val LDataType dt = prop.datatype
		if(dt==null){
			return false
		}
		val typeRef = dt.jvmTypeReference
		return typeRef != null && !typeRef.eIsProxy() && typeRef.getType() != null && !typeRef.getType().eIsProxy() &&
			"boolean".equals(typeRef.getType().getIdentifier())
	}
	
	def typeIsEnum(LAttribute prop) {
		return prop.type instanceof LEnum
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

	def toQualifiedName(LType type) {
		val LPackage pkg = type.getPackage
		return pkg.name + "." + type.name
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
		return a.concat(b);
	}

	def String toDtoPackageName(LTypedPackage pkg) {
		if (pkg.name.contains("entities")) {
			return pkg.name.replace("entities", "dtos")
		} else {
			return pkg.name + ".dtos"
		}
	}
}

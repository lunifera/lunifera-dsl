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
package org.lunifera.dsl.entity.xtext.extensions

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.semantic.common.helper.Bounds
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LClass
import org.lunifera.dsl.semantic.common.types.LDataType
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LPackage
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LBeanAttribute
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityAttribute
import org.lunifera.dsl.semantic.entity.LEntityReference

class ModelExtensions {

	@Inject extension IQualifiedNameProvider
	@Inject extension JvmTypesBuilder

	def dispatch JvmTypeReference toTypeReference(LType type) {
		if (type == null || type.fullyQualifiedName == null) { //###is this check needed?
			return null
		}
		return type.newTypeRef(type.fullyQualifiedName.toString)
	}

	def dispatch JvmTypeReference toTypeReference(LDataType type) {
		return type.jvmTypeReference
	}

	def dispatch JvmTypeReference toTypeReference(LAttribute prop) {
		var jvmTypeRef = prop.type?.toTypeReference
		if (jvmTypeRef != null && prop.isToMany) {
			jvmTypeRef = newTypeRef(prop, typeof(List), jvmTypeRef);
		}
		return jvmTypeRef
	}

	def dispatch JvmTypeReference toTypeReference(LEntityReference prop) {
		var jvmTypeRef = prop.type?.toTypeReference
		if (jvmTypeRef != null && prop.isToMany) {
			jvmTypeRef = newTypeRef(prop, typeof(List), jvmTypeRef);
		}
		return jvmTypeRef
	}

	def dispatch JvmTypeReference toTypeReference(LBeanReference prop) {
		var jvmTypeRef = prop.type?.toTypeReference
		if (jvmTypeRef != null && prop.isToMany) {
			jvmTypeRef = newTypeRef(prop, typeof(List), jvmTypeRef);
		}
		return jvmTypeRef
	}

	def Bounds getBounds(LFeature prop) {
		Bounds::createFor(prop)
	}

	def isToMany(LFeature prop) {
		prop.bounds.toMany
	}

	def dispatch isCascading(LEntityReference prop) {
		prop.cascading || if(prop.opposite != null) prop.opposite.cascading else false
	}

	def dispatch isCascading(LBeanReference prop) {
		prop.cascading || if(prop.opposite != null) prop.opposite.cascading else false
	}

	def dispatch isCascading(LAttribute prop) {
		prop.cascading
	}

	def dispatch getResolvedOpposite(LEntityReference prop) {

		// For a toMany that has already an opposite, return it.
		// Otherwise search in the referenced type for the property with the owner type.
		if (prop.getOpposite() != null) {
			return prop.getOpposite()
		} else if (prop.type instanceof LEntity) {
			val LEntity ref = prop.type as LEntity
			ref.references.findFirst[it.opposite == prop]
		}
	}

	def dispatch getResolvedOpposite(LBeanReference prop) {

		// For a toMany that has already an opposite, return it.
		// Otherwise search in the referenced type for the property with the owner type.
		if (prop.getOpposite() != null) {
			return prop.getOpposite()
		} else if (prop.type instanceof LBean) {
			val LBean ref = prop.type as LBean
			ref.references.findFirst[it.opposite == prop]
		}
	}

	def typeIsBoolean(LFeature prop) {
		val typeRef = prop.toTypeReference
		return typeRef != null && !typeRef.eIsProxy() && typeRef.getType() != null && !typeRef.getType().eIsProxy() &&
			"boolean".equals(typeRef.getType().getIdentifier())
	}

	/**
   	 * Returns true, if toCheck can be cast to superType
   	 */
	def dispatch boolean isCastable(LEntity toCheck, LEntity superType) {
		val String toCheckFqn = toCheck.fullyQualifiedName.toString
		val String superTypeFqn = superType.fullyQualifiedName.toString

		if (toCheckFqn.equals(superTypeFqn)) {
			return true
		} else {
			val LClass toCheckSuperType = toCheck.getSuperType
			if (toCheckSuperType != null) {
				return toCheckSuperType.isCastable(superType)
			} else {
				return false;
			}
		}
	}

	/**
   	 * Returns true, if toCheck can be cast to superType
   	 */
	def dispatch boolean isCastable(LBean toCheck, LBean superType) {
		val String toCheckFqn = toCheck.fullyQualifiedName.toString
		val String superTypeFqn = superType.fullyQualifiedName.toString

		if (toCheckFqn.equals(superTypeFqn)) {
			return true
		} else {
			val LClass toCheckSuperType = toCheck.getSuperType
			if (toCheckSuperType != null) {
				return toCheckSuperType.isCastable(superType)
			} else {
				return false;
			}
		}
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

	def dispatch String typeName(LEntityAttribute prop) {
		prop.type.name
	}

	def dispatch String typeName(LEntityReference prop) {
		prop.type.name
	}

	def dispatch String typeName(LBeanAttribute prop) {
		prop.type.name
	}

	def dispatch String typeName(LBeanReference prop) {
		prop.type.name
	}

	def dispatch type(LEntityAttribute prop) {
		prop.type
	}

	def dispatch type(LEntityReference prop) {
		prop.type
	}

	def dispatch type(LBeanAttribute prop) {
		prop.type
	}

	def dispatch type(LBeanReference prop) {
		prop.type
	}
	
	
	def dispatch opposite(LEntityAttribute prop) {
		null
	}

	def dispatch opposite(LEntityReference prop) {
		prop.opposite
	}

	def dispatch opposite(LBeanAttribute prop) {
		null
	}

	def dispatch opposite(LBeanReference prop) {
		prop.opposite
	}
}

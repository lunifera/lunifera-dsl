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
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.dto.xtext.common.ICrossReference
import org.lunifera.dsl.semantic.common.helper.Bounds
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAttribute
import org.lunifera.dsl.semantic.dto.LDtoFeature
import org.lunifera.dsl.semantic.dto.LDtoOperation
import org.lunifera.dsl.semantic.dto.LDtoReference
import org.lunifera.dsl.semantic.entity.LEntityReference

class ModelExtensions extends org.lunifera.dsl.common.xtext.extensions.ModelExtensions {

	@Inject extension IQualifiedNameProvider
	@Inject extension JvmTypesBuilder

	@Inject TypeReferences references;

	def dispatch JvmTypeReference toTypeReference(LDtoReference prop) {
		if (prop.inherit) {
			return prop.inheritedFeature.toTypeReference
		} else {
			var jvmTypeRef = prop.type?.toTypeReference
			if (jvmTypeRef != null && prop.isToMany) {
				jvmTypeRef = newTypeRef(prop, typeof(List), jvmTypeRef);
			}
			return jvmTypeRef
		}

	}

	def dispatch JvmTypeReference toTypeReference(LDtoAttribute prop) {
		val LAttribute att = if(prop.inherit) prop.inheritedFeature else prop

		var jvmTypeRef = att.type?.toTypeReference
		if (jvmTypeRef != null && att.isToMany) {
			jvmTypeRef = newTypeRef(att, typeof(List), jvmTypeRef);
		}
		return jvmTypeRef
	}

	def dispatch JvmTypeReference toTypeReference(LEntityReference ref) {

		var JvmTypeReference jvmTypeRef = null;
		if (!ref.cascading) {
			jvmTypeRef = newTypeRef(ref, typeof(ICrossReference), null)
		} else {
			jvmTypeRef = ref.type?.toTypeReference
		}

		if (jvmTypeRef != null && ref.isToMany) {
			jvmTypeRef = newTypeRef(ref, typeof(List), jvmTypeRef);
		}
		return jvmTypeRef
	}

	def dispatch JvmTypeReference toTypeParameterReference(LDtoReference prop) {
		if (prop.inherit) {
			return prop.inheritedFeature.toTypeParameterReference
		} else {
			return prop.type?.toTypeReference
		}

	}

	def dispatch JvmTypeReference toTypeParameterReference(LDtoAttribute prop) {
		val LAttribute att = if(prop.inherit) prop.inheritedFeature else prop
		return att.type?.toTypeReference
	}

	def dispatch JvmTypeReference toTypeParameterReference(LEntityReference ref) {

		var JvmTypeReference jvmTypeRef = null;
		if (!ref.cascading) {
			jvmTypeRef = newTypeRef(ref, typeof(ICrossReference), null)
		} else {
			jvmTypeRef = ref.type?.toTypeReference
		}

		return jvmTypeRef
	}

	def dispatch isCascading(LDtoOperation prop) {
		false
	}

	def getResolvedOpposite(LDtoReference prop) {

		// For a toMany that has already an opposite, return it.
		// Otherwise search in the referenced type for the property with the owner type.
		if (prop.opposite != null) {
			return prop.opposite
		} else if (prop.type instanceof LDto) {
			val LDto ref = prop.type as LDto
			ref.references.findFirst[it.opposite == prop]
		}
	}

	/**
   	 * Returns true, if toCheck can be cast to superType
   	 */
	def boolean isCastable(LDto toCheck, LDto superType) {
		val String toCheckFqn = toCheck.fullyQualifiedName.toString
		val String superTypeFqn = superType.fullyQualifiedName.toString

		if (toCheckFqn.equals(superTypeFqn)) {
			return true
		} else {
			val LDto toCheckSuperType = toCheck.getSuperType
			if (toCheckSuperType != null) {
				return toCheckSuperType.isCastable(superType)
			} else {
				return false;
			}
		}
	}

	def dispatch inherited(LFeature prop) {
		throw new UnsupportedOperationException
	}

	def dispatch inherited(LDtoFeature prop) {
		return prop.inherit
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
		if (a == null || b == null)
			return ""

		return a + b;
	}

	def dispatch String typeName(LDtoAttribute prop) {
		if (prop.inherit) {
			prop.inheritedFeature.type.name
		} else {
			prop.type.name
		}
	}

	def dispatch String typeName(LDtoReference prop) {
		if (prop.inherit) {
			prop.inheritedFeature.type.name
		} else {
			prop.type.name
		}
	}

	def dispatch toType(LDtoAttribute prop) {
		if (prop.inherit) {
			prop.inheritedFeature.type as LType
		} else {
			prop.type as LType
		}
	}

	def dispatch toType(LDtoReference prop) {
		if (prop.inherit) {
			prop.inheritedFeature.type
		} else {
			prop.type as LType
		}
	}

	def dispatch LReference opposite(LDtoFeature prop) {
		null
	}

	def dispatch LReference opposite(LDtoAttribute prop) {
		null
	}

	def dispatch LReference opposite(LDtoReference prop) {
		if (prop.inherit) {
			return prop.inheritedFeature.opposite
		} else {
			return prop.opposite
		}
	}

	override Bounds getBounds(LFeature prop) {
		return internalGetBound(prop)
	}

	def dispatch Bounds internalGetBound(LFeature prop) {
		return Bounds.createFor(prop);
	}

	def dispatch Bounds internalGetBound(LDtoFeature prop) {
		if (prop.inherit) {
			return Bounds.createFor(prop.inheritedFeature);
		} else {
			return Bounds.createFor(prop);
		}
	}

	override String toName(LFeature prop) {
		return prop.internalToName
	}

	def dispatch String internalToName(LFeature prop) {
		return prop.name;
	}

	def dispatch String internalToName(LDtoFeature prop) {
		if (prop.inherit) {
			return prop.inheritedFeature?.name;
		} else {
			return prop.name;
		}
	}

	def dispatch LReference inheritedFeature(LDtoReference prop) {
		return prop.inheritedFeature
	}

	def dispatch LAttribute inheritedFeature(LDtoAttribute prop) {
		return prop.inheritedFeature
	}

	override isToMany(LFeature prop) {
		return internalIsToMany(prop);
	}

	def dispatch boolean internalIsToMany(LFeature prop) {
		return prop.bounds.toMany;
	}

	def dispatch boolean internalIsToMany(LDtoFeature prop) {
		if (prop.inherit) {
			return prop.inheritedFeature.internalIsToMany
		} else {
			return prop.bounds.toMany;
		}
	}

	def dispatch isCascading(LDtoReference prop) {
		if (prop.inherit) {
			return prop.inheritedFeature.cascading
		} else {
			return prop.cascading;
		}
	}

	def dispatch isCascading(LDtoAttribute prop) {
		if (prop.inherit) {
			return prop.inheritedFeature.cascading
		} else {
			return prop.cascading;
		}
	}

	def isCrossReference(LDtoFeature prop) {
		return prop instanceof LReference && !prop.cascading
	}
}

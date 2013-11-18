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
import org.lunifera.dsl.entity.semantic.model.LBean
import org.lunifera.dsl.entity.semantic.model.LClass
import org.lunifera.dsl.entity.semantic.model.LDataType
import org.lunifera.dsl.entity.semantic.model.LEntity
import org.lunifera.dsl.entity.semantic.model.LEntityProp
import org.lunifera.dsl.entity.semantic.model.LOperation
import org.lunifera.dsl.entity.semantic.model.LPackage
import org.lunifera.dsl.entity.semantic.model.LPersistentProperty
import org.lunifera.dsl.entity.semantic.model.LProperty
import org.lunifera.dsl.entity.semantic.model.LScalarType
import org.lunifera.dsl.entity.semantic.model.LType
import org.lunifera.dsl.entity.xtext.util.PersistenceNamingUtils

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

	def dispatch JvmTypeReference toTypeReference(LProperty prop) {
		var jvmTypeRef = prop.jvmTypeRef
		if (jvmTypeRef == null) {
			jvmTypeRef = prop.type?.toTypeReference
		}
		if (jvmTypeRef != null && prop.isToMany) {
			jvmTypeRef = newTypeRef(prop, typeof(List), jvmTypeRef);
		}
		return jvmTypeRef
	}

	def EntityBounds getEntityBounds(LProperty prop) {
		EntityBounds::createFor(prop)
	}

	def isToMany(LProperty prop) {
		prop.entityBounds.toMany
	}

	def isCascading(LProperty prop) {
		prop.cascading || prop.opposite.cascading
	}

	def dispatch List<? extends LProperty> getProperties(LEntity type) {
		return type.properties
	}

	def dispatch List<? extends LProperty> getProperties(LBean type) {
		return type.properties
	}

	def dispatch List<? extends LProperty> getProperties(LClass type) {
		return newArrayList()
	}

	def dispatch List<? extends LOperation> getOperations(LEntity type) {
		return type.operations
	}

	def dispatch List<? extends LOperation> getOperations(LBean type) {
		return type.operations
	}

	def dispatch List<? extends LOperation> getOperations(LClass type) {
		return newArrayList()
	}

	def getResolvedOpposite(LProperty prop) {

		// For a toMany that has already an opposite, return it.
		// Otherwise search in the referenced type for the property with the owner type.
		if (prop.getOpposite() != null) {
			return prop.getOpposite()
		} else if (prop.type instanceof LEntity) {
			val LEntity ref = prop.type as LEntity
			ref.properties.findFirst[it.opposite == prop]
		} else if (prop.type instanceof LBean) {
			val LBean ref = prop.type as LBean
			ref.properties.findFirst[it.opposite == prop]
		}
	}

	def typeIsBoolean(LProperty prop) {
		val typeRef = prop.toTypeReference
		return typeRef != null && !typeRef.eIsProxy() && typeRef.getType() != null && !typeRef.getType().eIsProxy() &&
			"boolean".equals(typeRef.getType().getIdentifier())
	}

	/** 
	 * Returns the property name that is used for method signatures.
	 */
	def String toMethodParamName(LProperty prop) {
		return prop.toGeneratorDefaultMethodParamName;
	}

	/**
	 * Returns the generator default method param name.
	 */
	def String toGeneratorDefaultMethodParamName(LProperty sourceElement) {
		return toMethodParamName(sourceElement.getName())
	}

	/** 
	 * Returns the property name that is used for method signatures.
	 */
	def String toMethodParamName(String name) {
		return String::format("%s", name);
	}

	//	/**
	//	 * Returns the used compiler type of the given model element.
	//	 * If no compiler type was specified, the entity compiler type will be returned.
	//	 */
	//	def LCompilerType compilerType(EObject eObject) {
	//		if (eObject == null) {
	//			var result = EntityFactory::eINSTANCE.createLCompilerType;
	//			result.name = Constants::POJO_COMPILER_FQN
	//			return result
	//		}
	//
	//		var LCompilerType result = null
	//		if (eObject instanceof LEntityModel) {
	//			val LEntityModel model = eObject as LEntityModel
	//			if (model == null || model.genSettings == null) {
	//				result = EntityFactory::eINSTANCE.createLCompilerType;
	//				result.name = Constants::POJO_COMPILER_FQN
	//			} else {
	//				result = model.genSettings.compilerType
	//			}
	//
	//			return result
	//		} else if (eObject instanceof LCompilerType) {
	//			result = eObject as LCompilerType
	//		} else {
	//			result = compilerType(eObject.eContainer)
	//		}
	//	}
	//	/**
	//	 * Returns true, if the given eObject compiles to the pojo model
	//	 */
	//	def boolean compilesToPojoModel(EObject eObject) {
	//		eObject.compilerType.fullyQualifiedName.toString.equals(Constants::POJO_COMPILER_FQN)
	//	}
	//
	//	/**
	//	 * Returns true, if the given eObject compiles to the JPA model
	//	 */
	//	def boolean compilesToJPAModel(EObject eObject) {
	//		eObject.compilerType.fullyQualifiedName.toString.equals(Constants::JPA_COMPILER_FQN)
	//	}
	//
	//	def isLifecycleHandling(LGenSettings settings) {
	//		return settings != null && settings.lifecycle
	//	}
	/**
   	 * Returns true, if toCheck can be cast to superType
   	 */
	def boolean isCastable(LClass toCheck, LClass superType) {
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

	// ### Might move to PersistenceExtensions
	def columnName(LPersistentProperty prop) {
		var columnBaseName = prop.persistenceName
		if (columnBaseName.nullOrEmpty) {
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(prop.name)
		}

		// Compute the final column name using some settings. 
		// E.g. to add some prefix like the shortName of the Entity.
		// ### not yet implemented
		columnBaseName
	}

	def tableName(LEntity entity) {
		var tableBaseName = entity.persistenceName
		if (tableBaseName.nullOrEmpty) {
			tableBaseName = PersistenceNamingUtils::camelCaseToUpperCase(entity.name)
		}

		// Compute the final column name using some settings. 
		// E.g. to add some prefix like the shortName of the Entity.
		// ### not yet implemented
		tableBaseName
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
	 * Returns true if the property is a scalar type property
	 */
	def boolean isScalarType(LEntityProp prop) {
		return if(prop == null) false else prop.type instanceof LScalarType
	}

	/**
	 * Returns true if the property is an entity type property
	 */
	def boolean isEntityType(LEntityProp prop) {
		return !prop.scalarType
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

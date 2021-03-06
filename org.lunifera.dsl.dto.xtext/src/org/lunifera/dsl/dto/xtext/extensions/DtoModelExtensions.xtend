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
package org.lunifera.dsl.dto.xtext.extensions

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.common.helper.Bounds
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LDataType
import org.lunifera.dsl.semantic.common.types.LEnum
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.common.types.LReference
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference
import org.lunifera.dsl.semantic.dto.LDtoAttribute
import org.lunifera.dsl.semantic.dto.LDtoFeature
import org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute
import org.lunifera.dsl.semantic.dto.LDtoInheritedReference
import org.lunifera.dsl.semantic.dto.LDtoOperation
import org.lunifera.dsl.semantic.dto.LDtoReference
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LBeanAttribute
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityAttribute
import org.lunifera.dsl.semantic.entity.LEntityReference

class DtoModelExtensions extends ModelExtensions {

	@Inject extension IQualifiedNameProvider
	@Inject extension JvmTypesBuilder
	@Inject extension MethodNamingExtensions
	
	@Inject TypeReferences references;

	/**
	 * Creates a type reference with respect to mappings to DTOs. For instance "Item"-Entity is mapped to ItemDTO
	 */
	def dispatch JvmTypeReference toDtoTypeReference(LDtoAbstractReference prop) {

		// always use the lazy resolving jvmType proxy
		return prop.typeJvm?.cloneWithProxies
	}

	/**
	 * Creates a type reference with respect to mappings to DTOs. For instance "Item"-Entity is mapped to ItemDTO
	 */
	def dispatch JvmTypeReference toDtoTypeReference(LDtoAbstractAttribute prop) {
		if (isAvoidJvmTypeProxiesForDatatype(prop)) {
			return prop.toDataTypeTypeReference
		}

		// Use the jvmType proxy
		return prop.typeJvm?.cloneWithProxies
	}

	/**
	 * Creates a type reference with respect to mappings to DTOs. For instance "Item"-Entity is mapped to ItemDTO
	 */
	def dispatch JvmTypeReference toDtoTypeReference(LEntityAttribute prop, LDtoInheritedAttribute dtoAtt) {
		if (prop.type instanceof LBean || prop.type instanceof LEntity || prop.type instanceof LEnum) {
			return dtoAtt.inheritedFeatureTypeJvm.cloneWithProxies
		} else {
			return super.toTypeReference(prop)
		}
	}

	/**
	 * Creates a type reference with respect to mappings to DTOs. For instance "Item"-Entity is mapped to ItemDTO
	 */
	def dispatch JvmTypeReference toDtoTypeReference(LBeanAttribute prop, LDtoInheritedAttribute dtoAtt) {
		if (prop.type instanceof LBean || prop.type instanceof LEntity || prop.type instanceof LEnum) {
			return dtoAtt.inheritedFeatureTypeJvm.cloneWithProxies
		} else {
			return super.toTypeReference(prop)
		}
	}

	/**
	 * Creates a type reference with respect to mappings to DTOs. For instance "Item"-Entity is mapped to ItemDTO
	 */
	def dispatch JvmTypeReference toDtoTypeReference(LEntityReference prop, LDtoInheritedReference dtoRef) {
		return dtoRef.inheritedFeatureTypeJvm.cloneWithProxies
	}

	/**
	 * Creates a type reference with respect to mappings to DTOs. For instance "Item"-Entity is mapped to ItemDTO
	 */
	def dispatch JvmTypeReference toDtoTypeReference(LBeanReference prop, LDtoInheritedAttribute dtoRef) {
		return dtoRef.inheritedFeatureTypeJvm.cloneWithProxies
	}

	/**
	 * Creates a type reference with respect to mappings to DTOs. For instance "Item"-Entity is mapped to ItemDTO
	 */
	def dispatch JvmTypeReference toDtoTypeReference(LDtoInheritedAttribute prop) {

		if (prop.type != null) {

			// if the type is a different one, then use the type of the property
			// it needs to be mapped by a custom mapper in dsl
			if (prop.isAvoidJvmTypeProxiesForDatatype) {
				return prop.toDataTypeTypeReference
			} else {

				// use the lazy resolving jvm type proxy
				return prop.typeJvm.cloneWithProxies
			}
		}

		// creates a proxy reference
		return prop.inheritedFeature?.toDtoTypeReference(prop).cloneWithProxies
	}

	/**
	 * Creates a type reference with respect to mappings to DTOs. For instance "Item"-Entity is mapped to ItemDTO
	 */
	def dispatch JvmTypeReference toDtoTypeReference(LDtoInheritedReference prop) {

		if (prop.type != null) {

			// if the type is a different one, then use the type of the property
			// it needs to be mapped by a custom mapper in dsl
			return prop.typeJvm.cloneWithProxies
		}

		// creates a proxy reference
		return prop.inheritedFeature?.toDtoTypeReference(prop).cloneWithProxies
	}

	/**
	 * Creates a type reference with respect to mappings to DTOs. For instance "Item"-Entity is mapped to ItemDTO
	 */
	def JvmTypeReference toDtoTypeReferenceWithMultiplicity(LDtoFeature prop) {
		var ref = prop.toDtoTypeReference
		if (ref != null && prop.bounds.toMany) {
			ref = references.getTypeForName(typeof(List), prop, ref)
		}
		return ref
	}

	/**
	 * Creates a type reference with respect to multiplicity
	 */
	def JvmTypeReference toRawTypeReferenceWithMultiplicity(LDtoFeature prop) {
		var ref = prop.toRawTypeRefernce;
		if (prop.bounds.toMany) {
			ref = references.getTypeForName(typeof(List), prop, ref)
		}
		return ref
	}

	def dispatch isCascading(LDtoOperation prop) {
		false
	}

	def LDtoAbstractReference getResolvedOpposite(LDtoReference prop) {

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
		return false
	}

	def dispatch inherited(LDtoInheritedReference prop) {
		return true
	}

	def dispatch inherited(LDtoInheritedAttribute prop) {
		return true
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

	def dispatch String toTypeName(LDtoAttribute prop) {
		prop.type.name
	}

	def dispatch String toTypeName(LDtoInheritedAttribute prop) {
		if (prop.type != null) {
			prop.type.name
		} else {
			prop.inheritedFeature.^type.name
		}
	}

	def dispatch String toTypeName(LDtoReference prop) {
		prop.type?.name
	}

	def dispatch String toTypeName(LDtoInheritedReference prop) {
		prop.type?.name
	}

	def dispatch String toQualifiedTypeName(LDtoAttribute prop) {
		prop.type.fullyQualifiedName.toString
	}

	def dispatch String toQualifiedTypeName(LDtoInheritedAttribute prop) {
		if (prop.type != null) {
			prop.type.fullyQualifiedName.toString
		} else {
			prop.inheritedFeature.^type.fullyQualifiedName.toString
		}
	}

	def dispatch String toQualifiedTypeName(LDtoReference prop) {
		prop.type?.fullyQualifiedName.toString
	}

	def dispatch String toQualifiedTypeName(LDtoInheritedReference prop) {
		prop.type?.fullyQualifiedName.toString
	}

	def dispatch LType toRawType(LFeature prop) {
		throw new IllegalStateException("not a valid call")
	}

	/**
	 * Returns the type of the property or reference without any mappings
	 */
	def dispatch LType toRawType(LDtoAttribute prop) {
		prop.type
	}

	/**
	 * Returns the type of the property or reference without any mappings
	 */
	def dispatch LType toRawType(LDtoInheritedAttribute prop) {
		prop.inheritedFeature?.type
	}
	
	/**
	 * Returns the type of the property or reference without any mappings
	 */
	def dispatch LType toRawType(LDtoReference prop) {
		prop.type
	}
	
	/**
	 * Returns the type of the property or reference without any mappings
	 */
	def dispatch LType toRawType(LDtoInheritedReference prop) {
		prop.inheritedFeature?.toRawType
	}

	/**
	 * Returns the type of the property or reference without any mappings
	 */
	def dispatch LType toRawType(LEntityReference prop) {
		prop.type
	}
	
	/**
	 * Returns the type of the property or reference without any mappings
	 */
	def dispatch LType toRawType(LEntityAttribute prop) {
		prop.type
	}
	
	/**
	 * Returns the type of the property or reference without any mappings
	 */
	def dispatch LType toRawType(LBeanReference prop) {
		prop.type
	}

	/**
	 * Returns the type of the property or reference without any mappings
	 */
	def dispatch LType toRawType(LBeanAttribute prop) {
		prop.type
	}
	
	/**
	 * Returns the type reference of the property or reference without any mappings
	 */
	def dispatch toRawTypeRefernce(LDtoFeature prop) {
		prop.toRawType?.toTypeReference
	}

	/**
	 * Returns the type reference of the property or reference without any mappings
	 */
	def dispatch toRawTypeRefernce(LDtoInheritedReference prop) {
		val LReference ref = prop.inheritedFeature
		if (ref instanceof LEntityReference) {
			return ref.typeJvm.cloneWithProxies
		} else if (ref instanceof LBeanReference) {
			return ref.typeJvm.cloneWithProxies
		}
		return TypesFactory.eINSTANCE.createJvmUnknownTypeReference
	}
	
	/**
	 * Returns the type reference of the property or reference without any mappings
	 */
	def dispatch toRawTypeRefernce(LDtoAbstractReference prop) {
		prop.toRawType?.toTypeReference
	}
	
	/**
	 * Returns the type reference of the property or reference without any mappings
	 */
	def String toRawTypeName(LDtoFeature prop) {
		prop.toRawType?.name
	}
	
	def dispatch LFeature opposite(LDtoFeature prop) {
		null
	}

	def dispatch LFeature opposite(LDtoReference prop) {
		return prop.opposite
	}

	def dispatch LFeature opposite(LDtoInheritedReference prop) {
		if (prop.inherited && prop.inheritedFeature != null) {
			return prop.inheritedFeature.opposite
		} else {
			return null
		}
	}
 
	def dispatch LFeature opposite(LEntityReference prop) {
		prop.opposite
	}

	def dispatch LFeature opposite(LBeanReference prop) {
		prop.opposite
	}

	def dispatch Bounds getBounds(LDtoFeature prop) {
		if (prop.inherited) {
			return Bounds.createFor(prop.inheritedFeature);
		} else {
			return Bounds.createFor(prop);
		}
	}

	def dispatch String toName(LDtoFeature feature) {
		if(feature == null || !feature.inherited && feature.name == null) return ""
		if (feature.inherited) {
			return feature.inheritedFeature?.toName
		}
		return feature.name.replace("^", "")
	}

	def dispatch String toName(LDto dto) {
		if (dto == null || dto.name == null) {
			return ""
		}
		return dto.name.replace("^", "")
	}

	def dispatch String toName(Void param) {
		return ""
	}

	//	def dispatch String internalToName(LFeature prop) {
	//		return prop.name;
	//	}
	//
	//	def dispatch String internalToName(LDtoFeature prop) {
	//		if (prop.inherited) {
	//			return prop.inheritedFeature?.name;
	//		} else {
	//			return prop.name;
	//		}
	//	}
	def dispatch LReference inheritedFeature(LDtoFeature prop) {
		return null
	}

	def dispatch LReference inheritedFeature(LDtoInheritedReference prop) {
		return prop.inheritedFeature
	}

	def dispatch LAttribute inheritedFeature(LDtoInheritedAttribute prop) {
		return prop.inheritedFeature
	}

	override isToMany(LFeature prop) {
		if (prop == null) {
			return false
		}
		return internalIsToMany(prop);
	}

	def dispatch boolean isAbstract(LType context) {
		false
	}

	def dispatch boolean isAbstract(LEntity context) {
		context.abstract
	}

	def dispatch boolean isAbstract(LDto context) {
		context.abstract
	}

	def dispatch boolean isTransient(EObject context) {
		false
	}

	def dispatch boolean isTransient(LDtoAttribute context) {
		context.transient
	}

	def dispatch boolean internalIsToMany(LFeature prop) {
		return prop.bounds.toMany;
	}

	def dispatch boolean internalIsToMany(LDtoFeature prop) {
		if (prop.inherited && prop.inheritedFeature != null) {
			return prop.inheritedFeature.internalIsToMany
		} else {
			return prop.bounds.toMany;
		}
	}

	def dispatch boolean isCascading(LDtoAbstractReference prop) {
		if (prop.inherited && prop.inheritedFeature != null) {
			return prop.inheritedFeature.cascading
		} else {
			return prop.cascading;
		}
	}

	def dispatch boolean isCascading(LDtoAbstractAttribute prop) {
		if (prop.inherited && prop.inheritedFeature != null) {
			return prop.inheritedFeature.cascading
		} else {
			return prop.cascading;
		}
	}

	def isAttribute(LDtoFeature prop) {
		return prop instanceof LAttribute
	}

	def isContainmentReference(LDtoFeature prop) {
		return prop instanceof LReference && prop.cascading
	}

	def isCrossReference(LDtoFeature prop) {
		return prop instanceof LReference && !prop.cascading
	}

	def dispatch isContainerReference(LDtoAbstractAttribute prop) {
		return false
	}

	def dispatch isContainerReference(LDtoReference prop) {
		val opposite = prop.opposite
		if (opposite != null && opposite.cascading) {
			return true
		}
		return false
	}

	def dispatch isContainerReference(LDtoInheritedReference prop) {
		val opposite = prop.inheritedFeature.opposite
		if (opposite != null && opposite.cascading) {
			return true
		}
		return false
	}

	def toMapperTypeReference(LType type) {
		references.getTypeForName(type.toFqnMapperName, type, null)
	}

	def toMapperTypeReference(LDtoAbstractReference ref) {
		ref.type.toMapperTypeReference
	}

	def dispatch isIDorUUID(LAttribute prop) {
		return false
	}

	def dispatch isIDorUUID(LDtoAttribute prop) {
		return prop.id || prop.uuid
	}

	def dispatch isIDorUUID(LDtoInheritedAttribute prop) {
		return prop.inheritedFeature.id || prop.inheritedFeature.uuid
	}

	/**
	 * Returns all containment features that need to be copied.
	 */
	def getContainmentReferencesToCopy(LDto dto) {
		dto.features.filter [
			it.containmentReference
		]
	}
	
	override boolean isBasedOnDatatype(LFeature feature){
		if(feature instanceof LDtoInheritedAttribute){
			return if(feature.inheritedFeature != null) feature.inheritedFeature.isBasedOnDatatype else false
		}
		return super.isBasedOnDatatype(feature)
	}
	
	override LDataType getDatatype(LFeature feature){
		if(feature instanceof LDtoInheritedAttribute){
			return if(feature.inheritedFeature != null) feature.inheritedFeature.getDatatype else null
		}
		return super.getDatatype(feature)
	}
	
	override typeIsEnum(LAttribute prop) {
		if(prop instanceof LDtoInheritedAttribute){
			return if(prop.inheritedFeature != null) prop.inheritedFeature.typeIsEnum else false
		}
		return super.typeIsEnum(prop)
	}

	/**
	 * Returns all attributes that need to be copied.
	 */
	def getAttributesToCopy(LDto dto) {
		dto.features.filter [
			it.attribute
		]
	}

	/**
	 * Returns all crossreferences that need to be copied.
	 */
	def getCrossReferencesToCopy(LDto dto) {
		dto.features.filter [
			return !it.containerReference && it.isCrossReference
		]
	}
	
	def boolean isBean(LType type){
		if(type instanceof LDto){
			return type.wrappedType instanceof LBean
		}
		return type instanceof LBean
	}

}

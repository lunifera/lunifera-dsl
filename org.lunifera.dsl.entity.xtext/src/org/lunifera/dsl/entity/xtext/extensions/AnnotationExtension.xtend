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
import java.util.Map
import javax.persistence.Cacheable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MappedSuperclass
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Transient
import javax.persistence.Version
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.entity.semantic.model.LAnnotationDef
import org.lunifera.dsl.entity.semantic.model.LEntity
import org.lunifera.dsl.entity.semantic.model.LEntityMember

class AnnotationExtension {
	 
	@Inject extension JvmTypesBuilder
	@Inject
	private TypesFactory typesFactory;
	@Inject
	private TypeReferences references;
	
	/**
	 * Creates an enum annotation value and adds it the the given annotation reference
	 */
	def JvmEnumAnnotationValue addEnumAnnotationValue(JvmAnnotationReference annRef, EObject context, String name, Enum<?>... enums) {
		// create the parameter
		val JvmEnumAnnotationValue value = typesFactory.createJvmEnumAnnotationValue
		annRef.values += value
		
		val Enum<?> enumx = enums.get(0);
		// create the enum type
		val JvmDeclaredType declaredType = references.findDeclaredType(enumx.declaringClass, context) as JvmDeclaredType;
		for(Enum<?> enumxx : enums){
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
	 * Creates a boolean annotation value and adds it the the given annotation reference
	 */
	def JvmBooleanAnnotationValue addBooleanAnnotationValue(JvmAnnotationReference annRef, EObject context, String name, boolean booleanValue) {
		// create the parameter
		val JvmBooleanAnnotationValue value = typesFactory.createJvmBooleanAnnotationValue
		annRef.values += value
		
		// create the enum type
		val JvmDeclaredType declaredType = references.findDeclaredType(typeof(Boolean), context) as JvmDeclaredType;
		
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
	def JvmStringAnnotationValue addStringAnnotationValue(JvmAnnotationReference annRef, EObject context, String name, String stringValue) {
		// create the parameter
		val JvmStringAnnotationValue value = typesFactory.createJvmStringAnnotationValue
		annRef.values += value
		
		// create the enum type
		val JvmDeclaredType declaredType = references.findDeclaredType(typeof(String), context) as JvmDeclaredType;
		
		// create the operation
		val JvmOperation op = typesFactory.createJvmOperation
		op.setSimpleName(name)
		op.setDeclaringType(declaredType)
		value.setOperation(op)
		value.values += stringValue
		
		return value
	}
	
	/**
	 * Returns a map with all excluded types
	 */
	def Map<String, LAnnotationDef> excludedTypes(List<LAnnotationDef> defs){
		return defs.filter([exclude]).toMap(
			[val anno = it.annotation
			if(anno.annotationType != null){
				return anno.annotationType.qualifiedName
			}
				return ""
			])
	}
	
	/**
	 * Returns a map with all included types
	 */
	def Map<String, LAnnotationDef> redefinedTypes(List<LAnnotationDef> defs){
		return defs.filter([!exclude]).toMap(
			[val anno = it.annotation
			if(anno.annotationType != null){
				return anno.annotationType.qualifiedName
			}
				return ""
			])
	}
	
	/**
	 * Returns true, if the clazz.canonicalName exists in the excluded types of defs
	 */
	def isExcluded(Class<?> clazz, List<LAnnotationDef> defs){
		if(defs == null){
			return false;
		}
		return defs.excludedTypes.containsKey(clazz.canonicalName)
	}
	
	/**
	 * Returns true, if the clazz.canonicalName exists in the included types of defs
	 */
	def isRedefined(Class<?> clazz, List<LAnnotationDef> defs){
		if(defs == null){
			return false;
		}
		return clazz.getRedefined(defs) != null
	}
	
	/**
	 * Returns true, if the clazz.canonicalName exists in the included types of defs
	 */
	def getRedefined(Class<?> clazz, List<LAnnotationDef> defs){
		if(defs == null){
			return null;
		}
		return defs.redefinedTypes.get(clazz.canonicalName)
	}
	
	def boolean isEntityAnnoExcluded(LEntity lEntity){
		return typeof(Entity).isExcluded(lEntity.annotations)
	}
	
	def boolean isEntityAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(Entity), context)
	}
	
	def boolean isEntityAnnoRedefined(LEntity lEntity){
		return typeof(Entity).isRedefined(lEntity.annotations)
	}
	
	def LAnnotationDef getEntityAnnoRedefine(LEntity lEntity){
		return typeof(Entity).getRedefined(lEntity.annotations)
	}
	
	def boolean isOneToManyAnnoExcluded(LEntityMember member){
		return typeof(OneToMany).isExcluded(member.annotations)
	}
	
	def boolean isOneToManyAnnoRedefined(LEntityMember member){
		return typeof(OneToMany).isRedefined(member.annotations)
	}
	
	def boolean isOneToManyValueAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(OneToMany), context)
	}
	
	def LAnnotationDef getOneToManyAnnoRedefine(LEntityMember member){
		return typeof(OneToMany).getRedefined(member.annotations)
	}
	
	def boolean isOneToOneAnnoExcluded(LEntityMember member){
		return typeof(OneToOne).isExcluded(member.annotations)
	}
	
	def boolean isOneToOneAnnoRedefined(LEntityMember member){
		return typeof(OneToOne).isRedefined(member.annotations)
	}
	
	def boolean isOneToOneAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(OneToOne), context)
	}
	
	def LAnnotationDef getOneToOneAnnoRedefine(LEntityMember member){
		return typeof(OneToOne).getRedefined(member.annotations)
	}
	
	def boolean isManyToOneAnnoExcluded(LEntityMember member){
		return typeof(ManyToOne).isExcluded(member.annotations)
	}
	
	def boolean isManyToOneAnnoRedefined(LEntityMember member){
		return typeof(ManyToOne).isRedefined(member.annotations)
	}
	
	def boolean isManyToOneValueAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(ManyToOne), context)
	}
	
	def LAnnotationDef getManyToOneAnnoRedefine(LEntityMember member){
		return typeof(ManyToOne).getRedefined(member.annotations)
	}
	
	def boolean isIdAnnoExcluded(LEntityMember member){
		return typeof(Id).isExcluded(member.annotations)
	}
	
	def boolean isIdAnnoRedefined(LEntityMember member){
		return typeof(Id).isRedefined(member.annotations)
	}
	
	def LAnnotationDef getIdAnnoRedefine(LEntityMember member){
		return typeof(Id).getRedefined(member.annotations)
	}
	
	def boolean isIdAnnoCreated(JvmAnnotationTarget target, EObject context){
		val result = target.containsAnnotation(typeof(Id), context)
		return result
	}
	
	def boolean isTransientAnnoExcluded(LEntityMember member){
		return typeof(Transient).isExcluded(member.annotations)
	}
	
	def boolean isTransientAnnoRedefined(LEntityMember member){
		return typeof(Transient).isRedefined(member.annotations)
	}
	
	def boolean isTransientAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(Transient), context)
	}
	
	def LAnnotationDef getTransientAnnoRedefine(LEntityMember member){
		return typeof(Transient).getRedefined(member.annotations)
	}
	
	def boolean isVersionAnnoExcluded(LEntityMember member){
		return typeof(Version).isExcluded(member.annotations)
	}
	
	def boolean isVersionAnnoRedefined(LEntityMember member){
		return typeof(Version).isRedefined(member.annotations)
	}
	
	def boolean isVersionAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(Version), context)
	}
	
	def LAnnotationDef getVersionAnnoRedefine(LEntityMember member){
		return typeof(Version).getRedefined(member.annotations)
	}
	
	def boolean isGeneratedValueAnnoExcluded(LEntityMember member){
		return typeof(GeneratedValue).isExcluded(member.annotations)
	}
	
	def boolean isGeneratedValueAnnoRedefined(LEntityMember member){
		return typeof(GeneratedValue).isRedefined(member.annotations)
	}
	
	def boolean isGeneratedValueAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(GeneratedValue), context)
	}
	
	def LAnnotationDef getGeneratedValueAnnoRedefine(LEntityMember member){
		return typeof(GeneratedValue).getRedefined(member.annotations)
	}
	
	def boolean isCachableAnnoExcluded(LEntity member){
		return typeof(Cacheable).isExcluded(member.annotations)
	}
	
	def boolean isCacheableAnnoRedefined(LEntity member){
		return typeof(Cacheable).isRedefined(member.annotations)
	}
	
	def LAnnotationDef getCacheableAnnoRedefine(LEntity member){
		return typeof(Cacheable).getRedefined(member.annotations)
	}
	
	def boolean isCacheableAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(Cacheable), context)
	}
	
	def boolean isEmbeddedAnnoExcluded(LEntityMember member){
		return typeof(Embedded).isExcluded(member.annotations)
	}
	
	def boolean isEmbeddedAnnoRedefined(LEntityMember member){
		return typeof(Embedded).isRedefined(member.annotations)
	}
	
	def LAnnotationDef getEmbeddedAnnoRedefine(LEntityMember member){
		return typeof(Embedded).getRedefined(member.annotations)
	}
	
	def boolean isEmbeddedAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(Embedded), context)
	}
	
	def boolean isEmbeddableAnnoExcluded(LEntity member){
		return typeof(Embeddable).isExcluded(member.annotations)
	}
	
	def boolean isEmbeddableAnnoRedefined(LEntity member){
		return typeof(Embeddable).isRedefined(member.annotations)
	}
	
	def LAnnotationDef getEmbeddableAnnoRedefine(LEntity member){
		return typeof(Embeddable).getRedefined(member.annotations)
	}
	
	def boolean isEmbeddableAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(Embeddable), context)
	}
	
	def boolean isColumnAnnoExcluded(LEntityMember member){
		return typeof(Column).isExcluded(member.annotations)
	}
	
	def boolean isColumnAnnoRedefined(LEntityMember member){
		return typeof(Column).isRedefined(member.annotations)
	}
	
	def boolean isColumnAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(Column), context)
	}
	
	def LAnnotationDef getColumnAnnoRedefine(LEntityMember member){
		return typeof(Column).getRedefined(member.annotations)
	}
	
	def boolean isJoinColumnAnnoExcluded(LEntityMember member){
		return typeof(JoinColumn).isExcluded(member.annotations)
	}
	
	def boolean isJoinColumnAnnoRedefined(LEntityMember member){
		return typeof(JoinColumn).isRedefined(member.annotations)
	}
	
	def boolean isJoinColumnAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(JoinColumn), context)
	}
	
	def LAnnotationDef getJoinColumnAnnoRedefine(LEntityMember member){
		return typeof(JoinColumn).getRedefined(member.annotations)
	}
	
	def boolean isMappedSuperclassAnnoExcluded(LEntity entity){
		return typeof(MappedSuperclass).isExcluded(entity.annotations)
	}
	
	def boolean isMappedSuperclassAnnoRedefined(LEntity entity){
		return typeof(MappedSuperclass).isRedefined(entity.annotations)
	}
	
	def boolean isMappedSuperclassAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(MappedSuperclass), context)
	}
	
	def LAnnotationDef getMappedSuperclassAnnoRedefine(LEntity entity){
		return typeof(MappedSuperclass).getRedefined(entity.annotations)
	}
	
	def boolean isInheritanceAnnoExcluded(LEntity entity){
		return typeof(Inheritance).isExcluded(entity.annotations)
	}
	
	def boolean isInheritanceAnnoRedefined(LEntity entity){
		return typeof(Inheritance).isRedefined(entity.annotations)
	}
	
	def boolean isInheritanceAnnoCreated(JvmAnnotationTarget target, EObject context){
		return target.containsAnnotation(typeof(Inheritance), context)
	}
	
	def LAnnotationDef getInheritanceAnnoRedefine(LEntity entity){
		return typeof(Inheritance).getRedefined(entity.annotations)
	}
	 
	def boolean containsAnnotation(JvmAnnotationTarget target, Class<?> type, EObject context){
		for(anno : target.annotations){
			var JvmAnnotationType resolved
			val JvmAnnotationType xan = anno.annotation;
			if(xan != null){
				if(xan.eIsProxy){
					resolved = EcoreUtil::resolve(xan, context) as JvmAnnotationType
				} else {
					resolved = xan
				}
				if(resolved.qualifiedName != null){
					if(resolved.qualifiedName.equals(type.canonicalName)){
						return true;
					}
				}
			}
		}
	}
}

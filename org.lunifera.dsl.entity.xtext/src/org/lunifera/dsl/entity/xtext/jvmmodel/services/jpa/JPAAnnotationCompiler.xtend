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
package org.lunifera.dsl.entity.xtext.jvmmodel.services.jpa

import com.google.inject.Inject
import com.google.inject.name.Named
import javax.persistence.Cacheable
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MappedSuperclass
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Transient
import javax.persistence.Version
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.lunifera.dsl.entity.semantic.model.LCompilerType
import org.lunifera.dsl.entity.semantic.model.LContainer
import org.lunifera.dsl.entity.semantic.model.LContains
import org.lunifera.dsl.entity.semantic.model.LEntity
import org.lunifera.dsl.entity.semantic.model.LEntityMember
import org.lunifera.dsl.entity.semantic.model.LGenSettings
import org.lunifera.dsl.entity.semantic.model.LProperty
import org.lunifera.dsl.entity.semantic.model.LRefers
import org.lunifera.dsl.entity.semantic.model.LowerBound
import org.lunifera.dsl.entity.semantic.model.UpperBound
import org.lunifera.dsl.entity.xtext.extensions.AnnotationExtension
import org.lunifera.dsl.entity.xtext.extensions.Constants
import org.lunifera.dsl.entity.xtext.extensions.EntityBounds
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.entity.xtext.jvmmodel.services.IAnnotationCompiler
import org.lunifera.dsl.entity.xtext.jvmmodel.services.entity.EntityTypesBuilder

/** 
 * This class is responsible to generate the Annotations defined in the entity model
 */
class JPAAnnotationCompiler implements IAnnotationCompiler {
	
	@Inject extension ModelExtensions
	@Inject extension EntityTypesBuilder
	@Inject extension AnnotationExtension
 	@Inject 
 	@Named(Constants::POJO_COMPILER_FQN)  
 	IAnnotationCompiler entityAnnotationCompiler
 
	override isResponsible(LCompilerType lCompilerType) {
		lCompilerType.compilesToJPAModel
	} 
	 
	override processAnnotation(LEntity lEntity, JvmGenericType jvmType, LGenSettings setting) {
		// use the entity annotation compiler that compiles the annotations specified in the model
		entityAnnotationCompiler.processAnnotation(lEntity,  jvmType, setting)
	 
		if(lEntity.isAbstract()) {
			if(!lEntity.mappedSuperclassAnnoExcluded && !jvmType.isMappedSuperclassAnnoCreated(lEntity)) {
				jvmType.annotations += lEntity.toAnnotation(typeof(MappedSuperclass))
			}
			if(!lEntity.inheritanceAnnoExcluded && !jvmType.isInheritanceAnnoCreated(lEntity)) {
				val JvmAnnotationReference annRef = lEntity.toAnnotation(typeof(Inheritance))
				annRef.addEnumAnnotationValue(lEntity, "strategy", InheritanceType::TABLE_PER_CLASS)
				jvmType.annotations+=annRef
			}
		}
	
		if(!lEntity.entityAnnoExcluded && !jvmType.isEntityAnnoCreated(lEntity)) {
			jvmType.annotations += lEntity.toAnnotation(typeof(Entity))
		}
 
		if(lEntity.cachable && !lEntity.cachableAnnoExcluded && !jvmType.isCacheableAnnoCreated(lEntity)){
			jvmType.annotations += lEntity.toAnnotation(typeof(Cacheable))
		}
		if(lEntity.embeddable && !lEntity.embeddableAnnoExcluded && !jvmType.isEmbeddableAnnoCreated(lEntity)){
			jvmType.annotations += lEntity.toAnnotation(typeof(Embeddable))
		}
	}
	
	override processAnnotation(LEntityMember member, JvmOperation jvmOperation, LGenSettings setting) {
		// use the entity annotation compiler that compiles the annotations specified in the model
		entityAnnotationCompiler.processAnnotation(member,  jvmOperation, setting)
	}
	 
	override processAnnotation(LEntityMember member, JvmField jvmField, LGenSettings setting) {
		// use the entity annotation compiler that compiles the annotations specified in the model
		entityAnnotationCompiler.processAnnotation(member,  jvmField,  setting)
		
		processAnnotation_dispatch(member, jvmField, setting)
	}

	def dispatch void processAnnotation_dispatch(LProperty prop, JvmField jvmField, LGenSettings setting) {
		if(!prop.columnAnnoExcluded && !jvmField.isColumnAnnoCreated(prop) && !prop.transient) {
            val JvmAnnotationReference annRef = prop.toAnnotation(typeof(Column)) 
            jvmField.annotations += annRef
            if(prop.notnull){
                annRef.addBooleanAnnotationValue(prop, "nullable", false)
            }
		}
		if(prop.id){
			if(!prop.idAnnoExcluded && !jvmField.isIdAnnoCreated(prop)){
				// there is no redefine
				jvmField.annotations += prop.toAnnotation(typeof(Id))
			}
			if(!prop.isGeneratedValueAnnoExcluded() && !jvmField.isGeneratedValueAnnoCreated(prop)){
				val JvmAnnotationReference annRef = prop.toAnnotation(typeof(GeneratedValue))
				jvmField.annotations+=annRef
				annRef.addEnumAnnotationValue(prop, "strategy", GenerationType::IDENTITY)
			}
		}
		if(prop.version && !prop.versionAnnoExcluded && !jvmField.isVersionAnnoCreated(prop)){
			jvmField.annotations += prop.toAnnotation(typeof(Version))
		}
		if(prop.transient && !prop.transientAnnoExcluded && !jvmField.isTransientAnnoCreated(prop)){
			jvmField.annotations += prop.toAnnotation(typeof(Transient))
		}
	}
	
	def dispatch void processAnnotation_dispatch(LRefers refers, JvmField jvmField, LGenSettings setting) {
		val bounds = EntityBounds::createFor(refers.multiplicity)
		val LRefers opposite = refers.opposite
		
		var EntityBounds oppBounds = null
		if(opposite != null){
			oppBounds =  EntityBounds::createFor(opposite.multiplicity)
		}else{
		 	oppBounds =  new EntityBounds(LowerBound::ZERO, UpperBound::ONE)
		}
		
		if(bounds.toMany && oppBounds.toMany){
			throw new IllegalStateException("ManyToMany not supported yet!");
		} else if(bounds.toMany && !oppBounds.toMany){
			if(!refers.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(refers)){
				jvmField.annotations += refers.toAnnotation(typeof(JoinColumn))
			}
			if(!refers.oneToManyAnnoExcluded && !jvmField.isOneToManyValueAnnoCreated(refers)){
				val JvmAnnotationReference annRef = refers.toAnnotation(typeof(OneToMany))
				jvmField.annotations+=annRef
				if(refers.lazy){
					annRef.addEnumAnnotationValue(refers, "fetch", FetchType::LAZY)
				}
				if(opposite != null){
					annRef.addStringAnnotationValue(refers, "mappedBy", opposite.name)
				}
			}
		} else if(!bounds.toMany && oppBounds.toMany){
			if(!refers.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(refers)){
				jvmField.annotations += refers.toAnnotation(typeof(JoinColumn))
			}
			if(!refers.manyToOneAnnoExcluded && !jvmField.isManyToOneValueAnnoCreated(refers)){
				val JvmAnnotationReference annRef = refers.toAnnotation(typeof(ManyToOne))
				jvmField.annotations+=annRef
				if(refers.lazy){
					annRef.addEnumAnnotationValue(refers, "fetch", FetchType::LAZY)
				}
			}
		} else if(!bounds.toMany && !oppBounds.toMany){
			if(!refers.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(refers)){
				jvmField.annotations += refers.toAnnotation(typeof(JoinColumn))
			}
			if(!refers.oneToOneAnnoRedefined && !jvmField.isOneToOneAnnoCreated(refers)){
				val JvmAnnotationReference annRef = refers.toAnnotation(typeof(OneToOne))
				jvmField.annotations+=annRef
				if(refers.lazy){
					annRef.addEnumAnnotationValue(refers, "fetch", FetchType::LAZY)
				}
				if(refers.notnull){
					annRef.addBooleanAnnotationValue(refers, "optional", false)
				}
			}
		}
	}
	
	def dispatch void processAnnotation_dispatch(LContains contains, JvmField jvmField, LGenSettings setting) {
		val bounds = EntityBounds::createFor(contains.multiplicity)
		if(bounds.toMany){
			if(!contains.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(contains)){
				jvmField.annotations += contains.toAnnotation(typeof(JoinColumn))
			}
			if(!contains.oneToManyAnnoExcluded && !jvmField.isOneToManyValueAnnoCreated(contains)){
				val JvmAnnotationReference annRef = contains.toAnnotation(typeof(OneToMany))
				annRef.addEnumAnnotationValue(contains, "cascade", CascadeType::ALL)
				
				jvmField.annotations+=annRef
				if(contains.lazy){
					annRef.addEnumAnnotationValue(contains, "fetch", FetchType::LAZY)
				}
				if(contains.opposite != null){
					val LContainer container = contains.opposite
					annRef.addStringAnnotationValue(contains, "mappedBy", container.name)
				}
			}
		}else{
			if(!contains.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(contains)){
				jvmField.annotations += contains.toAnnotation(typeof(JoinColumn))
			}
			if(!contains.oneToOneAnnoExcluded && !jvmField.isOneToOneAnnoCreated(contains)){
				val JvmAnnotationReference annRef = contains.toAnnotation(typeof(OneToOne))
				annRef.addEnumAnnotationValue(contains, "cascade", CascadeType::ALL)
				
				jvmField.annotations+=annRef
				if(contains.lazy){
					annRef.addEnumAnnotationValue(contains, "fetch", FetchType::LAZY)
				}
				if(contains.notnull){
					annRef.addBooleanAnnotationValue(contains, "optional", false)
				}
				
				if(contains.opposite != null){
					val LContainer container = contains.opposite
					annRef.addStringAnnotationValue(contains, "mappedBy", container.name)
				}
			}
		}
	}
	
	def dispatch void processAnnotation_dispatch(LContainer container, JvmField jvmField, LGenSettings setting) {
		val opposite = container.opposite
		if(opposite == null){
			// nothing to generate
		} else {
			val oppositeBounds = EntityBounds::createFor(opposite.multiplicity)
			if(oppositeBounds.toMany){
				if(!container.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(container)){
					jvmField.annotations += container.toAnnotation(typeof(JoinColumn))
				}
				if(!container.manyToOneAnnoExcluded && !jvmField.isManyToOneValueAnnoCreated(container)){
					val JvmAnnotationReference annRef = container.toAnnotation(typeof(ManyToOne))
					jvmField.annotations+=annRef
					
					annRef.addBooleanAnnotationValue(container, "optional", false)
				}
			}else{
				if(!container.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(container)){
					jvmField.annotations += container.toAnnotation(typeof(JoinColumn))
				}
				if(!container.oneToOneAnnoExcluded && !jvmField.isOneToOneAnnoCreated(container)){
					val JvmAnnotationReference annRef = container.toAnnotation(typeof(OneToOne))
					jvmField.annotations+=annRef
					
					annRef.addBooleanAnnotationValue(container, "optional", false)
				}
			}
		}
	}
}







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
import javax.persistence.AttributeOverrides
import javax.persistence.Cacheable
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Transient
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.entity.semantic.model.LAnnotationTarget
import org.lunifera.dsl.entity.semantic.model.LBean
import org.lunifera.dsl.entity.semantic.model.LClass
import org.lunifera.dsl.entity.semantic.model.LEntity
import org.lunifera.dsl.entity.semantic.model.LGenSettings
import org.lunifera.dsl.entity.semantic.model.LOperation
import org.lunifera.dsl.entity.semantic.model.LPersistentProperty
import org.lunifera.dsl.entity.semantic.model.LProperty
import org.lunifera.dsl.entity.semantic.model.LScalarType
import org.lunifera.dsl.entity.xtext.extensions.AnnotationExtension
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.entity.xtext.jvmmodel.services.IAnnotationCompiler

/** 
 * This class is responsible to generate the Annotations defined in the entity model
 */
class JPAAnnotationCompiler implements IAnnotationCompiler {
	
	@Inject extension ModelExtensions
	@Inject extension JvmTypesBuilder
	@Inject extension AnnotationExtension

    def addAnno(LAnnotationTarget target, JvmAnnotationTarget jvmType, JvmAnnotationReference anno) {
        val annoDef = target.annotations.findFirst[annotation.annotationType == anno.annotation]
        if (annoDef == null || !annoDef.exclude) {
            jvmType.annotations += anno
        }
    }

	override processAnnotation(LClass lClass, JvmGenericType jvmType, LGenSettings setting) {
        val entity = lClass as LEntity
        lClass.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
        addAnno(lClass, jvmType, lClass.toAnnotation(typeof(Entity)))

	    val useSingleTableMapping = true // might come from settings in the future

        // Process inheritance.
		if (lClass.superType == null) {
		    // The Entity is a top-level Entity.
		    
		    // Add @Table(name="T_ORDER", schema="LUNIXAMPLE")
		    //addAnno(lClass, jvmType, lClass.toAnnotation(typeof(Table)))
		    
		    // If the Entity has subclasses, setup @Inheritance
		    if (!lClass.subTypes.empty) {
    			val annRef = lClass.toAnnotation(typeof(Inheritance))
    			annRef.addAnnAttr(lClass, "strategy", 
    			         if (useSingleTableMapping) InheritanceType::SINGLE_TABLE
    			         else                       InheritanceType::JOINED)
    			         //InheritanceType::TABLE_PER_CLASS)
    			addAnno(lClass, jvmType, annRef)

                if (useSingleTableMapping) {
                    // @DiscriminatorColumn(name="DISCRIMINATOR", discriminatorType=DiscriminatorType.STRING)
                    
                    // If the entity is not abstract, add @DiscriminatorValue("EMPLOYEE")
                }		        
		    }
		     
//		    addAnno(lClass, jvmType, lClass.toAnnotation(typeof(MappedSuperclass)))

		} else {
		    // The Entity is a sub-Entity.
		    if (useSingleTableMapping) {
                // @DiscriminatorValue("EMPLOYEE")
		        
		    } else {
                // @Table(name="T_EMPLOYEE", schema="LUNIXAMPLE")
                
		        // @PrimaryKeyJoinColumn(name="PERS_ID")
		    }
		}

        if (entity.cacheable) {
            addAnno(entity, jvmType, entity.toAnnotation(typeof(Cacheable)))
        }
	}
	
	override processAnnotation(LOperation member, JvmOperation jvmOperation, LGenSettings setting) {
        member.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmOperation);
	}
	 
	override processAnnotation(LProperty prop, JvmField jvmField, LGenSettings setting) {
        prop.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmField);

		if (prop.transient) {
		    if (!prop.transientAnnoExcluded && !jvmField.isTransientAnnoCreated(prop)) {
                jvmField.annotations += prop.toAnnotation(typeof(Transient))
            }
		} else {
		    processAnnotation(prop as LPersistentProperty, jvmField)
		}
	}

    def void processAnnotation(LPersistentProperty prop, JvmField jvmField) {
        if (prop.id) {
            // @Id
        } else if (prop.version) {
            // @Version
//        } else if (prop.typeIsLocalized) {
        } else if (prop.type instanceof LScalarType) {
            // ### Check if userType must be added
            addColumnAnno(prop, jvmField, prop.columnName, prop.notnull)
        } else if (prop.type instanceof LBean) {
            // @Embedded
            addEmbeddedAnno(prop, jvmField)
        } else if (prop.type instanceof LEntity) {
            if (prop.toMany) {
                // *toMany
                if (prop.opposite.toMany) {
                    // @ManyToMany
                    addManyToManyAnno(prop, jvmField)
                } else {
                    // @OneToMany
                    addOneToManyAnno(prop, jvmField)
                }
            } else {
                // *toOne
                val opposite = prop.resolvedOpposite
                // When we have no opposite, then the master-side has no collection
                // and we assume a many-to-one relation.
                // A one-to-one relation needs an "opposite" on both sides.
                if (opposite != null && !opposite.toMany) {
                    // @OneToOne
                    addOneToOneAnno(prop, jvmField)
                } else {
                    // @ManyToOne
                    addManyToOneAnno(prop, jvmField)
                }
            }
        } 
        
    }

    def private addColumnAnno(LPersistentProperty prop, JvmAnnotationTarget jvmAnnTarget, 
                              String columnName, boolean notnull)
    {
        val ann = prop.toAnnotation(typeof(Column)) 
        if(notnull){
            ann.addAnnAttr(prop, "nullable", false)
        }
        addAnno(prop, jvmAnnTarget, ann)
    }

    def private addEmbeddedAnno(LPersistentProperty prop, JvmAnnotationTarget jvmAnnTarget)
    {
        val ann = prop.toAnnotation(typeof(Embedded)) 
        addAnno(prop, jvmAnnTarget, ann)
        
        // Add @AttributeOverrides with a list of @AttributeOverride
        val bean = prop.type as LBean
        val aoAnn = prop.toAnnotation(typeof(AttributeOverrides)) 
        // TODO drill into bean recursively
    }

    def private addOneToManyAnno(LPersistentProperty prop, JvmAnnotationTarget jvmAnnTarget)
    {
        val ann = prop.toAnnotation(typeof(OneToMany)) 
        if (prop.opposite != null) {
            ann.addAnnAttr(prop, "mappedBy", prop.opposite.name)
        }
        if (prop.composition) {
            ann.addAnnAttr(prop, "cascade", CascadeType::ALL)
            ann.addAnnAttr(prop, "orphanRemoval", true)
        }
        // Skip "fetch=LAZY" because it is the JPA default.
        //ann.addEnumAnnotationValue(prop, "fetch", FetchType::LAZY)
        
        addAnno(prop, jvmAnnTarget, ann)
    }

    def private addManyToManyAnno(LPersistentProperty prop, JvmAnnotationTarget jvmAnnTarget)
    {
        throw new UnsupportedOperationException("ManyToMany not yet supported");
    }

    def private addManyToOneAnno(LPersistentProperty prop, JvmAnnotationTarget jvmAnnTarget)
    {
        val manyToOne = prop.toAnnotation(typeof(ManyToOne)) 
        if (prop.notnull) {
            manyToOne.addAnnAttr(prop, "optional", !prop.notnull)
        }
        manyToOne.addAnnAttr(prop, "fetch", FetchType::LAZY)
        addAnno(prop, jvmAnnTarget, manyToOne)

        val joinColumn = prop.toAnnotation(typeof(JoinColumn)) 
        joinColumn.addAnnAttr(prop, "name", prop.columnName)
        addAnno(prop, jvmAnnTarget, joinColumn)
    }

    def private addOneToOneAnno(LPersistentProperty prop, JvmAnnotationTarget jvmAnnTarget)
    {
        val oneToOne = prop.toAnnotation(typeof(OneToOne)) 
        if (prop.notnull) {
            oneToOne.addAnnAttr(prop, "optional", !prop.notnull)
        }
        val opposite = prop.resolvedOpposite
        if (opposite != null && prop.composition) {
            oneToOne.addAnnAttr(prop, "mappedBy", opposite.name)
        }
        //oneToOne.addAnnAttr(prop, "fetch", FetchType::LAZY)
        addAnno(prop, jvmAnnTarget, oneToOne)

        if (opposite != null && opposite.composition) {
            val joinColumn = prop.toAnnotation(typeof(JoinColumn)) 
            joinColumn.addAnnAttr(prop, "name", prop.columnName)
            addAnno(prop, jvmAnnTarget, joinColumn)
        }
    }


//		if(prop.id){
//			if(!prop.idAnnoExcluded && !jvmField.isIdAnnoCreated(prop)){
//				// there is no redefine
//				jvmField.annotations += prop.toAnnotation(typeof(Id))
//			}
//			if(!prop.isGeneratedValueAnnoExcluded() && !jvmField.isGeneratedValueAnnoCreated(prop)){
//				val JvmAnnotationReference annRef = prop.toAnnotation(typeof(GeneratedValue))
//				jvmField.annotations+=annRef
//				annRef.addEnumAnnotationValue(prop, "strategy", GenerationType::IDENTITY)
//			}
//		}
//		if(prop.version && !prop.versionAnnoExcluded && !jvmField.isVersionAnnoCreated(prop)){
//			jvmField.annotations += prop.toAnnotation(typeof(Version))
//		}

//###	
//	def dispatch void processAnnotation_dispatch(LRefers refers, JvmField jvmField, LGenSettings setting) {
//		val bounds = EntityBounds::createFor(refers.multiplicity)
//		val LRefers opposite = refers.opposite
//		
//		var EntityBounds oppBounds = null
//		if(opposite != null){
//			oppBounds =  EntityBounds::createFor(opposite.multiplicity)
//		}else{
//		 	oppBounds =  new EntityBounds(LowerBound::ZERO, UpperBound::ONE)
//		}
//		
//		if(bounds.toMany && oppBounds.toMany){
//			throw new IllegalStateException("ManyToMany not supported yet!");
//		} else if(bounds.toMany && !oppBounds.toMany){
//			if(!refers.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(refers)){
//				jvmField.annotations += refers.toAnnotation(typeof(JoinColumn))
//			}
//			if(!refers.oneToManyAnnoExcluded && !jvmField.isOneToManyValueAnnoCreated(refers)){
//				val JvmAnnotationReference annRef = refers.toAnnotation(typeof(OneToMany))
//				jvmField.annotations+=annRef
//				if(refers.lazy){
//					annRef.addEnumAnnotationValue(refers, "fetch", FetchType::LAZY)
//				}
//				if(opposite != null){
//					annRef.addStringAnnotationValue(refers, "mappedBy", opposite.name)
//				}
//			}
//		} else if(!bounds.toMany && oppBounds.toMany){
//			if(!refers.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(refers)){
//				jvmField.annotations += refers.toAnnotation(typeof(JoinColumn))
//			}
//			if(!refers.manyToOneAnnoExcluded && !jvmField.isManyToOneValueAnnoCreated(refers)){
//				val JvmAnnotationReference annRef = refers.toAnnotation(typeof(ManyToOne))
//				jvmField.annotations+=annRef
//				if(refers.lazy){
//					annRef.addEnumAnnotationValue(refers, "fetch", FetchType::LAZY)
//				}
//			}
//		} else if(!bounds.toMany && !oppBounds.toMany){
//			if(!refers.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(refers)){
//				jvmField.annotations += refers.toAnnotation(typeof(JoinColumn))
//			}
//			if(!refers.oneToOneAnnoRedefined && !jvmField.isOneToOneAnnoCreated(refers)){
//				val JvmAnnotationReference annRef = refers.toAnnotation(typeof(OneToOne))
//				jvmField.annotations+=annRef
//				if(refers.lazy){
//					annRef.addEnumAnnotationValue(refers, "fetch", FetchType::LAZY)
//				}
//				if(refers.notnull){
//					annRef.addBooleanAnnotationValue(refers, "optional", false)
//				}
//			}
//		}
//	}
//	
//	def dispatch void processAnnotation_dispatch(LContains contains, JvmField jvmField, LGenSettings setting) {
//		val bounds = EntityBounds::createFor(contains.multiplicity)
//		if(bounds.toMany){
//			if(!contains.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(contains)){
//				jvmField.annotations += contains.toAnnotation(typeof(JoinColumn))
//			}
//			if(!contains.oneToManyAnnoExcluded && !jvmField.isOneToManyValueAnnoCreated(contains)){
//				val JvmAnnotationReference annRef = contains.toAnnotation(typeof(OneToMany))
//				annRef.addEnumAnnotationValue(contains, "cascade", CascadeType::ALL)
//				
//				jvmField.annotations+=annRef
//				if(contains.lazy){
//					annRef.addEnumAnnotationValue(contains, "fetch", FetchType::LAZY)
//				}
//				if(contains.opposite != null){
//					val LContainer container = contains.opposite
//					annRef.addStringAnnotationValue(contains, "mappedBy", container.name)
//				}
//			}
//		}else{
//			if(!contains.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(contains)){
//				jvmField.annotations += contains.toAnnotation(typeof(JoinColumn))
//			}
//			if(!contains.oneToOneAnnoExcluded && !jvmField.isOneToOneAnnoCreated(contains)){
//				val JvmAnnotationReference annRef = contains.toAnnotation(typeof(OneToOne))
//				annRef.addEnumAnnotationValue(contains, "cascade", CascadeType::ALL)
//				
//				jvmField.annotations+=annRef
//				if(contains.lazy){
//					annRef.addEnumAnnotationValue(contains, "fetch", FetchType::LAZY)
//				}
//				if(contains.notnull){
//					annRef.addBooleanAnnotationValue(contains, "optional", false)
//				}
//				
//				if(contains.opposite != null){
//					val LContainer container = contains.opposite
//					annRef.addStringAnnotationValue(contains, "mappedBy", container.name)
//				}
//			}
//		}
//	}
//	
//	def dispatch void processAnnotation_dispatch(LContainer container, JvmField jvmField, LGenSettings setting) {
//		val opposite = container.opposite
//		if(opposite == null){
//			// nothing to generate
//		} else {
//			val oppositeBounds = EntityBounds::createFor(opposite.multiplicity)
//			if(oppositeBounds.toMany){
//				if(!container.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(container)){
//					jvmField.annotations += container.toAnnotation(typeof(JoinColumn))
//				}
//				if(!container.manyToOneAnnoExcluded && !jvmField.isManyToOneValueAnnoCreated(container)){
//					val JvmAnnotationReference annRef = container.toAnnotation(typeof(ManyToOne))
//					jvmField.annotations+=annRef
//					
//					annRef.addBooleanAnnotationValue(container, "optional", false)
//				}
//			}else{
//				if(!container.joinColumnAnnoExcluded && !jvmField.isJoinColumnAnnoCreated(container)){
//					jvmField.annotations += container.toAnnotation(typeof(JoinColumn))
//				}
//				if(!container.oneToOneAnnoExcluded && !jvmField.isOneToOneAnnoCreated(container)){
//					val JvmAnnotationReference annRef = container.toAnnotation(typeof(OneToOne))
//					jvmField.annotations+=annRef
//					
//					annRef.addBooleanAnnotationValue(container, "optional", false)
//				}
//			}
//		}
//	}
}







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
package org.lunifera.dsl.entity.xtext.jvmmodel

import com.google.inject.Inject
import javax.persistence.Basic
import javax.persistence.Cacheable
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Transient
import javax.persistence.Version
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.lunifera.dsl.entity.xtext.extensions.AnnotationExtension
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LBeanAttribute
import org.lunifera.dsl.semantic.entity.LBeanReference
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityAttribute
import org.lunifera.dsl.semantic.entity.LEntityReference

/** 
 * This class is responsible to generate the Annotations defined in the entity model
 */
class AnnotationCompiler extends org.lunifera.dsl.common.xtext.jvmmodel.AnnotationCompiler {

	@Inject extension ModelExtensions
	@Inject extension JvmTypesBuilder
	@Inject extension AnnotationExtension

	def protected dispatch void internalProcessAnnotation(LBean bean, JvmGenericType jvmType) {
		bean.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);

		bean.addAnno(jvmType, bean.toAnnotation(typeof(Embeddable)))
	}

	def protected dispatch void internalProcessAnnotation(LEntity entity, JvmGenericType jvmType) {
		entity.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmType);
		addAnno(entity, jvmType, entity.toAnnotation(typeof(Entity)))

		val useSingleTableMapping = true // might come from settings in the future

		// Process inheritance.
		if (entity.superType == null) {

			// The Entity is a top-level Entity.
			// Add @Table(name="T_ORDER", schema="LUNIXAMPLE")
			//addAnno(lClass, jvmType, lClass.toAnnotation(typeof(Table)))
			// If the Entity has subclasses, setup @Inheritance
			if (!entity.subTypes.empty) {
				val annRef = entity.toAnnotation(typeof(Inheritance))
				annRef.addAnnAttr(entity, "strategy",
					if(useSingleTableMapping) InheritanceType::SINGLE_TABLE else InheritanceType::JOINED)

				//InheritanceType::TABLE_PER_CLASS)
				addAnno(entity, jvmType, annRef)

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

	def protected dispatch void internalProcessAnnotation(LEntityReference prop, JvmField jvmField) {
		prop.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmField);

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

	def protected dispatch void internalProcessAnnotation(LEntityAttribute prop, JvmField jvmField) {
		prop.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmField);

		if (prop.id) {
			jvmField.annotations += prop.toAnnotation(typeof(Id))
		} else if (prop.version) {
			jvmField.annotations += prop.toAnnotation(typeof(Version))
		} else {
			if (prop.toMany) {
				val ann = prop.toAnnotation(typeof(ElementCollection))
				addAnno(prop, jvmField, ann)
			} else {
				if (prop.type instanceof LBean) {
					val ann = prop.toAnnotation(typeof(Embedded))
					addAnno(prop, jvmField, ann)
				}
			}

			val ann = prop.toAnnotation(typeof(Column))
			if (prop.bounds.required) {
				ann.addAnnAttr(prop, "nullable", false)
			}
			addAnno(prop, jvmField, ann)
		}
	}

	def protected dispatch void internalProcessAnnotation(LBeanAttribute prop, JvmField jvmField) {
		prop.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmField);

		if (prop.transient) {
			jvmField.annotations += prop.toAnnotation(typeof(Transient))
		}

		jvmField.annotations += prop.toAnnotation(typeof(Basic))
	}

	def protected dispatch void internalProcessAnnotation(LBeanReference prop, JvmField jvmField) {
		prop.annotations.filter([!exclude]).map([annotation]).translateAnnotationsTo(jvmField);

		jvmField.annotations += prop.toAnnotation(typeof(Basic))

		val ann = prop.toAnnotation(typeof(Embedded))
		addAnno(prop, jvmField, ann)
	}

	def private addOneToManyAnno(LEntityReference prop, JvmAnnotationTarget jvmAnnTarget) {
		val ann = prop.toAnnotation(typeof(OneToMany))
		if (prop.opposite != null) {
			if (prop.opposite.name == null) {
				ann.addAnnAttr(prop, "mappedBy", "")
			} else {
				ann.addAnnAttr(prop, "mappedBy", prop.opposite.name)
			}
		}
		if (prop.cascading) {
			ann.addAnnAttr(prop, "cascade", CascadeType::ALL)
			ann.addAnnAttr(prop, "orphanRemoval", true)
		}

		// Skip "fetch=LAZY" because it is the JPA default.
		//ann.addEnumAnnotationValue(prop, "fetch", FetchType::LAZY)
		addAnno(prop, jvmAnnTarget, ann)
	}

	def private addManyToManyAnno(LEntityReference prop, JvmAnnotationTarget jvmAnnTarget) {
		//		throw new UnsupportedOperationException("ManyToMany not yet supported");
	}

	def private addManyToOneAnno(LEntityReference prop, JvmAnnotationTarget jvmAnnTarget) {
		val manyToOne = prop.toAnnotation(typeof(ManyToOne))
		if (prop.bounds.required) {
			manyToOne.addAnnAttr(prop, "optional", !prop.bounds.required)
		}
		manyToOne.addAnnAttr(prop, "fetch", FetchType::LAZY)
		addAnno(prop, jvmAnnTarget, manyToOne)

		val joinColumn = prop.toAnnotation(typeof(JoinColumn))
		joinColumn.addAnnAttr(prop, "name", prop.name)
		addAnno(prop, jvmAnnTarget, joinColumn)
	}

	def private addOneToOneAnno(LEntityReference prop, JvmAnnotationTarget jvmAnnTarget) {
		val oneToOne = prop.toAnnotation(typeof(OneToOne))
		if (prop.bounds.required) {
			oneToOne.addAnnAttr(prop, "optional", !prop.bounds.required)
		}
		val opposite = prop.resolvedOpposite
		if (opposite != null && prop.cascading) {
			oneToOne.addAnnAttr(prop, "mappedBy", if(opposite.name != null) opposite.name else "")
		}
		if (prop.cascading) {
			oneToOne.addAnnAttr(prop, "cascade", CascadeType::ALL)
			oneToOne.addAnnAttr(prop, "orphanRemoval", true)
		}

		//oneToOne.addAnnAttr(prop, "fetch", FetchType::LAZY)
		addAnno(prop, jvmAnnTarget, oneToOne)

		if (opposite != null && opposite.cascading) {
			val joinColumn = prop.toAnnotation(typeof(JoinColumn))
			joinColumn.addAnnAttr(prop, "name", prop.name)
			addAnno(prop, jvmAnnTarget, joinColumn)
		}
	}

	def dispatch addDisposeFieldAnnotation(LEntity entity, JvmField field) {
		val anno = entity.toAnnotation(typeof(Transient))
		addAnno(entity, field, anno)
	}

	def dispatch addDisposeFieldAnnotation(LBean entity, JvmField field) {
	}

	def dispatch addDisposeFieldAnnotation(LEntity entity, JvmOperation op) {
	}

	def dispatch addDisposeFieldAnnotation(LBean entity, JvmOperation op) {
		//		val anno = entity.toAnnotation(typeof(java.beans.Transient))
		//		addAnno(entity, op, anno)
	}

}

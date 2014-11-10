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
package org.lunifera.dsl.entity.xtext.extensions

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
import javax.persistence.Version
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.lunifera.dsl.semantic.common.types.LAnnotationDef
import org.lunifera.dsl.semantic.common.types.LClass
import org.lunifera.dsl.semantic.common.types.LFeature
 
class AnnotationExtension extends org.lunifera.dsl.common.xtext.extensions.AnnotationExtension {

	def boolean isEntityAnnoExcluded(LClass lEntity) {
		return typeof(Entity).isExcluded(lEntity.getAnnotations)
	}
 
	def boolean isEntityAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(Entity), context)
	}

	def boolean isEntityAnnoRedefined(LClass lEntity) {
		return typeof(Entity).isRedefined(lEntity.getAnnotations)
	}

	def LAnnotationDef getEntityAnnoRedefine(LClass lEntity) {
		return typeof(Entity).getRedefined(lEntity.getAnnotations)
	}

	def boolean isOneToManyAnnoExcluded(LFeature member) {
		return typeof(OneToMany).isExcluded(member.annotations)
	}

	def boolean isOneToManyAnnoRedefined(LFeature member) {
		return typeof(OneToMany).isRedefined(member.annotations)
	}

	def boolean isOneToManyValueAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(OneToMany), context)
	}

	def LAnnotationDef getOneToManyAnnoRedefine(LFeature member) {
		return typeof(OneToMany).getRedefined(member.annotations)
	}

	def boolean isOneToOneAnnoExcluded(LFeature member) {
		return typeof(OneToOne).isExcluded(member.annotations)
	}

	def boolean isOneToOneAnnoRedefined(LFeature member) {
		return typeof(OneToOne).isRedefined(member.annotations)
	}

	def boolean isOneToOneAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(OneToOne), context)
	}

	def LAnnotationDef getOneToOneAnnoRedefine(LFeature member) {
		return typeof(OneToOne).getRedefined(member.annotations)
	}

	def boolean isManyToOneAnnoExcluded(LFeature member) {
		return typeof(ManyToOne).isExcluded(member.annotations)
	}

	def boolean isManyToOneAnnoRedefined(LFeature member) {
		return typeof(ManyToOne).isRedefined(member.annotations)
	}

	def boolean isManyToOneValueAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(ManyToOne), context)
	}

	def LAnnotationDef getManyToOneAnnoRedefine(LFeature member) {
		return typeof(ManyToOne).getRedefined(member.annotations)
	}

	def boolean isIdAnnoExcluded(LFeature member) {
		return typeof(Id).isExcluded(member.annotations)
	}

	def boolean isIdAnnoRedefined(LFeature member) {
		return typeof(Id).isRedefined(member.annotations)
	}

	def LAnnotationDef getIdAnnoRedefine(LFeature member) {
		return typeof(Id).getRedefined(member.annotations)
	}

	def boolean isIdAnnoCreated(JvmAnnotationTarget target, EObject context) {
		val result = target.containsAnnotation(typeof(Id), context)
		return result
	}

	def boolean isVersionAnnoExcluded(LFeature member) {
		return typeof(Version).isExcluded(member.annotations)
	}

	def boolean isVersionAnnoRedefined(LFeature member) {
		return typeof(Version).isRedefined(member.annotations)
	}

	def boolean isVersionAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(Version), context)
	}

	def LAnnotationDef getVersionAnnoRedefine(LFeature member) {
		return typeof(Version).getRedefined(member.annotations)
	}

	def boolean isGeneratedValueAnnoExcluded(LFeature member) {
		return typeof(GeneratedValue).isExcluded(member.annotations)
	}

	def boolean isGeneratedValueAnnoRedefined(LFeature member) {
		return typeof(GeneratedValue).isRedefined(member.annotations)
	}

	def boolean isGeneratedValueAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(GeneratedValue), context)
	}

	def LAnnotationDef getGeneratedValueAnnoRedefine(LFeature member) {
		return typeof(GeneratedValue).getRedefined(member.annotations)
	}

	def boolean isCachableAnnoExcluded(LClass member) {
		return typeof(Cacheable).isExcluded(member.getAnnotations)
	}

	def boolean isCacheableAnnoRedefined(LClass member) {
		return typeof(Cacheable).isRedefined(member.getAnnotations)
	}

	def LAnnotationDef getCacheableAnnoRedefine(LClass member) {
		return typeof(Cacheable).getRedefined(member.getAnnotations)
	}

	def boolean isCacheableAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(Cacheable), context)
	}

	def boolean isEmbeddedAnnoExcluded(LFeature member) {
		return typeof(Embedded).isExcluded(member.annotations)
	}

	def boolean isEmbeddedAnnoRedefined(LFeature member) {
		return typeof(Embedded).isRedefined(member.annotations)
	}

	def LAnnotationDef getEmbeddedAnnoRedefine(LFeature member) {
		return typeof(Embedded).getRedefined(member.annotations)
	}

	def boolean isEmbeddedAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(Embedded), context)
	}

	def boolean isEmbeddableAnnoExcluded(LClass member) {
		return typeof(Embeddable).isExcluded(member.getAnnotations)
	}

	def boolean isEmbeddableAnnoRedefined(LClass member) {
		return typeof(Embeddable).isRedefined(member.getAnnotations)
	}

	def LAnnotationDef getEmbeddableAnnoRedefine(LClass member) {
		return typeof(Embeddable).getRedefined(member.getAnnotations)
	}

	def boolean isEmbeddableAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(Embeddable), context)
	}

	def boolean isColumnAnnoExcluded(LFeature member) {
		return typeof(Column).isExcluded(member.annotations)
	}

	def boolean isColumnAnnoRedefined(LFeature member) {
		return typeof(Column).isRedefined(member.annotations)
	}

	def boolean isColumnAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(Column), context)
	}

	def LAnnotationDef getColumnAnnoRedefine(LFeature member) {
		return typeof(Column).getRedefined(member.annotations)
	}

	def boolean isJoinColumnAnnoExcluded(LFeature member) {
		return typeof(JoinColumn).isExcluded(member.annotations)
	}

	def boolean isJoinColumnAnnoRedefined(LFeature member) {
		return typeof(JoinColumn).isRedefined(member.annotations)
	}

	def boolean isJoinColumnAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(JoinColumn), context)
	}

	def LAnnotationDef getJoinColumnAnnoRedefine(LFeature member) {
		return typeof(JoinColumn).getRedefined(member.annotations)
	}

	def boolean isMappedSuperclassAnnoExcluded(LClass entity) {
		return typeof(MappedSuperclass).isExcluded(entity.getAnnotations)
	}

	def boolean isMappedSuperclassAnnoRedefined(LClass entity) {
		return typeof(MappedSuperclass).isRedefined(entity.getAnnotations)
	}

	def boolean isMappedSuperclassAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(MappedSuperclass), context)
	}

	def LAnnotationDef getMappedSuperclassAnnoRedefine(LClass entity) {
		return typeof(MappedSuperclass).getRedefined(entity.getAnnotations)
	}

	def boolean isInheritanceAnnoExcluded(LClass entity) {
		return typeof(Inheritance).isExcluded(entity.getAnnotations)
	}

	def boolean isInheritanceAnnoRedefined(LClass entity) {
		return typeof(Inheritance).isRedefined(entity.getAnnotations)
	}

	def boolean isInheritanceAnnoCreated(JvmAnnotationTarget target, EObject context) {
		return target.containsAnnotation(typeof(Inheritance), context)
	}

	def LAnnotationDef getInheritanceAnnoRedefine(LClass entity) {
		return typeof(Inheritance).getRedefined(entity.getAnnotations)
	}
}

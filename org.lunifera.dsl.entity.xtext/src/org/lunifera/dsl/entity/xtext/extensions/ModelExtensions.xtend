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
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.lunifera.dsl.entity.semantic.model.EntityFactory
import org.lunifera.dsl.entity.semantic.model.LCompilerType
import org.lunifera.dsl.entity.semantic.model.LContainer
import org.lunifera.dsl.entity.semantic.model.LContains
import org.lunifera.dsl.entity.semantic.model.LEntity
import org.lunifera.dsl.entity.semantic.model.LEntityMember
import org.lunifera.dsl.entity.semantic.model.LEntityModel
import org.lunifera.dsl.entity.semantic.model.LGenSettings
import org.lunifera.dsl.entity.semantic.model.LMultiplicity
import org.lunifera.dsl.entity.semantic.model.LProperty
import org.lunifera.dsl.entity.semantic.model.LReference
import org.lunifera.dsl.entity.semantic.model.LRefers

class ModelExtensions { 
	
	@Inject extension IQualifiedNameProvider

	
	def EntityBounds getEntityBounds(LEntityMember ref){
		EntityBounds::createFor(ref.mulitiplicity_dispatch)
	}
	
	def LMultiplicity getMulitiplicitySetting(LEntityMember ref){
		ref.mulitiplicity_dispatch
	} 
	
	def dispatch LMultiplicity getMulitiplicity_dispatch(LContainer ref){
		return null;
	}
	
	def dispatch LMultiplicity getMulitiplicity_dispatch(LContains ref){
		return ref.multiplicity
	}
	
	def dispatch LMultiplicity getMulitiplicity_dispatch(LRefers ref){
		return ref.multiplicity
	}
	
	def dispatch LMultiplicity getMulitiplicity_dispatch(LProperty prop){
		return prop.multiplicity
	}
	
	def boolean isToMany(LEntityMember ref){
		ref.entityBounds.toMany
	}
	
	def boolean isRequired(LEntityMember ref){
		ref.entityBounds.required
	}
	
	def boolean isOptional(LEntityMember ref){
		ref.entityBounds.optional
	}
	
	/** 
	 * Returns the property name that is used for method signatures.
	 */
	def String toMethodParamName(LReference sourceElement) {
		return sourceElement.toMethodParamName_dispatch
	}
	
	/** 
	 * Returns the property name that is used for method signatures.
	 */
	def String toMethodParamName(LProperty sourceElement) {
		if(sourceElement.toMany && sourceElement.singularName != null){
			return sourceElement.singularName.toMethodParamName;
		}else{
			return sourceElement.toGeneratorDefaultMethodParamName;
		}
	}
	
	/** 
	 * Returns the property name that is used for method signatures.
	 */
	def dispatch String toMethodParamName_dispatch(LRefers sourceElement) {
		if(sourceElement.toMany && sourceElement.singularName != null){
			return sourceElement.singularName.toMethodParamName;
		} else{
			return sourceElement.toGeneratorDefaultMethodParamName;
		}
	}
	
	/** 
	 * Returns the property name that is used for method signatures.
	 */
	def dispatch String toMethodParamName_dispatch(LContains sourceElement) {
		if(sourceElement.toMany && sourceElement.singularName != null){
			sourceElement.singularName.toMethodParamName;
		}else{
			return sourceElement.toGeneratorDefaultMethodParamName;
		}
	}
	
	/**
	 * Returns the property name that is used for method signatures.
	 */
	def dispatch String toMethodParamName_dispatch(LContainer sourceElement) {
		return sourceElement.toGeneratorDefaultMethodParamName;
	}
	
	/**
	 * Returns the generator default method param name.
	 * The SingularName definition is not included!
	 */
	def String toGeneratorDefaultMethodParamName(LReference sourceElement) {
		if(sourceElement.type != null) {
			return sourceElement.type.name.toFirstLower.toMethodParamName;
		}else{
			return sourceElement.name.toMethodParamName;
		}
	}
	
	/**
	 * Returns the generator default method param name.
	 * The SingularName definition is not included!
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
	
	/**
	 * Returns the used compiler type of the given model element.
	 * If no compiler type was specified, the entity compiler type will be returned.
	 */
	def LCompilerType compilerType(EObject eObject){
		if(eObject == null){
			var result = EntityFactory::eINSTANCE.createLCompilerType;
		 	result.name = Constants::POJO_COMPILER_FQN
			return result
		}
		
		var LCompilerType result = null
		 if(eObject instanceof LEntityModel){
		 	val LEntityModel model = eObject as LEntityModel
				if(model == null || model.genSettings == null){
				 	result = EntityFactory::eINSTANCE.createLCompilerType;
				 	result.name = Constants::POJO_COMPILER_FQN
				} else {
				 	result = model.genSettings.compilerType
				}
			
			return result
		 } else if(eObject instanceof LCompilerType) {
		 	result = eObject as LCompilerType
		 } else {
		 	result = compilerType(eObject.eContainer)
		 }
	}
	
	/**
	 * Returns true, if the given eObject compiles to the pojo model
	 */
	def boolean compilesToPojoModel(EObject eObject) {
		eObject.compilerType.fullyQualifiedName.toString.equals(Constants::POJO_COMPILER_FQN)
	}
	
	/**
	 * Returns true, if the given eObject compiles to the JPA model
	 */
	def boolean compilesToJPAModel(EObject eObject) {
		eObject.compilerType.fullyQualifiedName.toString.equals(Constants::JPA_COMPILER_FQN)
	}
	
   	def isLifecycleHandling(LGenSettings settings){
   		return settings != null && settings.lifecycle
   	}

   	/**
   	 * Returns true, if toCheck can be cast to superType
   	 */
   	def boolean isCastable(LEntity toCheck, LEntity superType){
   		val String toCheckFqn = toCheck.fullyQualifiedName.toString
   		val String superTypeFqn = superType.fullyQualifiedName.toString
   		
   		if(toCheckFqn.equals(superTypeFqn)){
   			return true
   		} else {
   			val LEntity toCheckSuperType = toCheck.superType
   			if(toCheckSuperType != null){
   				return toCheckSuperType.isCastable(superType)
   			}else{
   				return false;
   			}
   		}
   	}
   	
 	/**
   	 * Returns true, if toCheck can be cast to superType
   	 */
   	def boolean nameEquals(LEntity toCheck, LEntity superType){
   		val String toCheckFqn = toCheck.fullyQualifiedName.toString
   		val String superTypeFqn = superType.fullyQualifiedName.toString
   		
   		return toCheckFqn.equals(superTypeFqn);
   	}
}
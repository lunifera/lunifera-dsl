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

import org.lunifera.dsl.entity.xtext.jvmmodel.services.IOperationContentCompiler

class DelegatingOperationContentCompiler implements IOperationContentCompiler {
	 
//	@Inject 
//	@Named(Constants::POJO_COMPILER_FQN)
//	IOperationContentCompiler entityCompiler
//	
//	@Inject 
//	@Named(Constants::JPA_COMPILER_FQN)
//	IOperationContentCompiler jpaCompiler
//	 
//	List<IOperationContentCompiler> delegates;
//	
//	override isResponsible(LCompilerType compilerType) {
//		return true
//	}
//	
//	def IOperationContentCompiler findCompiler(EObject eObject){
//		if(eObject == null){
//			return null
//		}
//		
//		if(delegates == null){
//			delegates = newArrayList
//			delegates.add(entityCompiler)
//			delegates.add(jpaCompiler)
//		} 
//		
//		 if(eObject instanceof LEntityModel){
//		 	val LEntityModel model = eObject as LEntityModel
//		 	var result = delegates.findFirst([
//				var LCompilerType compilerType;
//				if(model == null || model.genSettings == null){
//					compilerType = null;
//				} else {
//					compilerType = model.genSettings.compilerType
//				}
//				return isResponsible(compilerType)
//			])
//			
//			// at least use the entity generator for default
//			if(result == null){
//				result = entityCompiler
//			}
//			return result
//		 } else {
//		 	return findCompiler(eObject.eContainer)
//		 }
//	}
//
//	override add_toMany_Containmant_Documentantion(LContains ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).add_toMany_Containmant_Documentantion( ref,  localVarName,  fieldName,  typeRef,  setting)
//	}
//	
//	override add_toMany_Containmant_OperationContent(LContains ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).add_toMany_Containmant_OperationContent(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override add_toMany_Property_Documentantion(LProperty prop, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(prop).add_toMany_Property_Documentantion(prop, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override add_toMany_Property_OperationContent(LProperty prop, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(prop).add_toMany_Property_OperationContent(prop, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override add_toMany_Refers_Documentantion(LRefers ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).add_toMany_Refers_Documentantion(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override add_toMany_Refers_OperationContent(LRefers ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).add_toMany_Refers_OperationContent(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override checkDisposed_Documentantion(LClass lEntity) {
//		findCompiler(lEntity).checkDisposed_Documentantion(lEntity)
//	}
//	
//	override checkDisposed_OperationContent(LClass lEntity) {
//		findCompiler(lEntity).checkDisposed_OperationContent(lEntity)
//	}
//	
//	override dispose_Documentantion(LClass lEntity) {
//		findCompiler(lEntity).dispose_Documentantion(lEntity)
//	}
//	
//	override dispose_OperationContent(LClass entity) {
//		findCompiler(entity).dispose_OperationContent(entity)
//	}
//	
//	override get_toMany_Property_Documentantion(LProperty prop, String fieldName, LGenSettings setting) {
//		findCompiler(prop).get_toMany_Property_Documentantion(prop, fieldName, setting)
//	}
//	
//	override get_toMany_Property_OperationContent(LProperty prop, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(prop).get_toMany_Property_OperationContent(prop, fieldName, typeRef, setting)
//	}
//	
//	override get_toMany_Reference_Documentantion(LReference ref, String fieldName, LGenSettings setting) {
//		findCompiler(ref).get_toMany_Reference_Documentantion(ref, fieldName, setting)
//	}
//	
//	override get_toMany_Reference_OperationContent(LReference ref, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).get_toMany_Reference_OperationContent(ref, fieldName, typeRef, setting)
//	}
//	
//	override get_toOne_Property_Documentantion(LProperty property, String fieldName, LGenSettings setting) {
//		findCompiler(property).get_toOne_Property_Documentantion(property, fieldName, setting)
//	}
//	
//	override get_toOne_Property_OperationContent(LProperty property, String fieldName, LGenSettings setting) {
//		findCompiler(property).get_toOne_Property_OperationContent(property, fieldName, setting)
//	}
//	
//	override get_toOne_Reference_Documentantion(LReference ref, String fieldName, LGenSettings setting) {
//		findCompiler(ref).get_toOne_Reference_Documentantion(ref, fieldName, setting)
//	}
//	
//	override get_toOne_Reference_OperationContent(LReference ref, String fieldName, LGenSettings setting) {
//		findCompiler(ref).get_toOne_Reference_OperationContent(ref, fieldName, setting)
//	}
//	
//	override isDisposed_Documentantion(LClass lEntity) {
//		findCompiler(lEntity).isDisposed_Documentantion(lEntity)
//	}
//	
//	override isDisposed_OperationContent(LClass lEntity) {
//		findCompiler(lEntity).isDisposed_OperationContent(lEntity)
//	}
//	
//	override remove_toMany_Containmant_Documentantion(LContains ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).remove_toMany_Containmant_Documentantion(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override remove_toMany_Containmant_OperationContent(LContains ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).remove_toMany_Containmant_OperationContent(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override remove_toMany_Property_Documentantion(LProperty prop, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(prop).remove_toMany_Property_Documentantion(prop, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override remove_toMany_Property_OperationContent(LProperty prop, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(prop).remove_toMany_Property_OperationContent(prop, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override remove_toMany_Refers_Documentantion(LRefers ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).remove_toMany_Refers_Documentantion(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override remove_toMany_Refers_OperationContent(LRefers ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).remove_toMany_Refers_OperationContent(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override set_toOne_Container_Documentantion(LContainer ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).set_toOne_Container_Documentantion(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override set_toOne_Container_OperationContent(LContainer ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).set_toOne_Container_OperationContent(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override set_toOne_Containment_Documentantion(LContains ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).set_toOne_Containment_Documentantion(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override set_toOne_Containment_OperationContent(LContains ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).set_toOne_Containment_OperationContent(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override set_toOne_Property_Documentantion(LProperty property, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(property).set_toOne_Property_Documentantion(property, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override set_toOne_Property_OperationContent(LProperty property, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(property).set_toOne_Property_OperationContent(property, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override set_toOne_Refers_Documentantion(LRefers ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).set_toOne_Refers_Documentantion(ref, localVarName, fieldName, typeRef, setting)
//	}
//	
//	override set_toOne_Refers_OperationContent(LRefers ref, String localVarName, String fieldName, JvmTypeReference typeRef, LGenSettings setting) {
//		findCompiler(ref).set_toOne_Refers_OperationContent(ref, localVarName, fieldName, typeRef, setting)
//	}

}




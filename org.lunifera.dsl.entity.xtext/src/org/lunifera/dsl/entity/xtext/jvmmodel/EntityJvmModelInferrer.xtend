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
import com.google.inject.name.Named
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.lunifera.dsl.entity.semantic.model.LCompilerType
import org.lunifera.dsl.entity.semantic.model.LEntity
import org.lunifera.dsl.entity.semantic.model.LEntityModel
import org.lunifera.dsl.entity.semantic.model.LEnum
import org.lunifera.dsl.entity.semantic.model.LPackage
import org.lunifera.dsl.entity.xtext.extensions.Constants
import org.lunifera.dsl.entity.xtext.jvmmodel.services.IEntityJvmModelInferrerDelegate

class EntityJvmModelInferrer extends AbstractModelInferrer {
    static val Logger log = Logger::getLogger(typeof(EntityJvmModelInferrer))
	
	@Inject 
	@Named(Constants::POJO_COMPILER_FQN)
	IEntityJvmModelInferrerDelegate entityModelInferrer
	
	@Inject 
	@Named(Constants::JPA_COMPILER_FQN)
	IEntityJvmModelInferrerDelegate jpaModelInferrer
	 
	List<IEntityJvmModelInferrerDelegate> delegates;
	
	def isResponsible(LCompilerType lCompilerType) {
		return true
	}
	 
	/**
	 * Returns true if the resource of the specified object has syntax errors.
	 * This method allows an eary abort of inferring that would cause NPEs because of not loaded 
	 * Ecore proxy instances.
	 * Inspired by DefaultFoldingStructureProvider.modelChanged().
	 */
	def hasSyntaxErrors(EObject o) {
	    return o.eResource.errors.exists [ it instanceof XtextSyntaxDiagnostic ]
	}
	
	def dispatch infer(LEntity e, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
	    if (hasSyntaxErrors(e)) {
	        log.warn("Abort inferring due to syntax errors: " + e)
	        return
	    }

		val LPackage pkg = e.eContainer as LPackage;
		val LEntityModel model = pkg.eContainer as LEntityModel;
		if(model == null){
			return;
		}
		
		if(model.genSettings == null || model.genSettings.compilerType == null){
			entityModelInferrer.infer(e, acceptor, isPrelinkingPhase)
		} else if(jpaModelInferrer.isResponsible(model.genSettings.compilerType)){
			jpaModelInferrer.infer(e, acceptor, isPrelinkingPhase)
		} else if(entityModelInferrer.isResponsible(model.genSettings.compilerType)){
			entityModelInferrer.infer(e, acceptor, isPrelinkingPhase)
		}
	}
	
	def dispatch infer(LEnum e, IJvmDeclaredTypeAcceptor acceptor, boolean isPrelinkingPhase) {
		val LPackage pkg = e.eContainer as LPackage;
		val LEntityModel model = pkg.eContainer as LEntityModel;
		if(model == null){
			return;
		}
		
		if(model.genSettings == null || model.genSettings.compilerType == null){
			entityModelInferrer.infer(e, acceptor, isPrelinkingPhase)
		} else if(jpaModelInferrer.isResponsible(model.genSettings.compilerType)){
			jpaModelInferrer.infer(e, acceptor, isPrelinkingPhase)
		} else if(entityModelInferrer.isResponsible(model.genSettings.compilerType)){
			entityModelInferrer.infer(e, acceptor, isPrelinkingPhase)
		}
	}
	
	def IEntityJvmModelInferrerDelegate findDelegate(LEntityModel model){
		if(delegates == null){
			delegates = newArrayList
			delegates.add(entityModelInferrer)
			delegates.add(jpaModelInferrer)
		} 
		
		return delegates.findFirst([
			var LCompilerType compilerType;
			if(model == null || model.genSettings == null ){
				compilerType = null;
			} else {
				compilerType = model.genSettings.compilerType
			}
			return isResponsible(compilerType)
		])
	}
	
}
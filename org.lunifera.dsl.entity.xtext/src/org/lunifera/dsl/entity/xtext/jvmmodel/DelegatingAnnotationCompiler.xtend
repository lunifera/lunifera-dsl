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
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.lunifera.dsl.entity.semantic.model.LCompilerType
import org.lunifera.dsl.entity.semantic.model.LEntity
import org.lunifera.dsl.entity.semantic.model.LEntityMember
import org.lunifera.dsl.entity.semantic.model.LGenSettings
import org.lunifera.dsl.entity.xtext.extensions.Constants
import org.lunifera.dsl.entity.xtext.jvmmodel.services.IAnnotationCompiler

class DelegatingAnnotationCompiler implements IAnnotationCompiler {
	
	@Inject
	@Named(Constants::POJO_COMPILER_FQN)
	IAnnotationCompiler entityCompiler
	
	@Inject
	@Named(Constants::JPA_COMPILER_FQN)
	IAnnotationCompiler jpaCompiler
	 
	List<IAnnotationCompiler> delegates;
	
	override isResponsible(LCompilerType lCompilerType) {
		true
	}
	 
	override processAnnotation(LEntity lEntity, JvmGenericType jvmType, LGenSettings setting) {
		val IAnnotationCompiler compiler = findDelegate(setting)
		if(compiler != null){
			compiler.processAnnotation(lEntity, jvmType, setting)
		}
	}

	override processAnnotation(LEntityMember member, JvmField jvmField, LGenSettings setting) {
		val IAnnotationCompiler compiler = findDelegate(setting)
		if(compiler != null){
			compiler.processAnnotation(member, jvmField, setting)
		}
	}
	
	override processAnnotation(LEntityMember member, JvmOperation jvmOperation, LGenSettings setting) {
		val IAnnotationCompiler compiler = findDelegate(setting)
		if(compiler != null){
			compiler.processAnnotation(member, jvmOperation, setting)
		}
	}
	
	def IAnnotationCompiler findDelegate(LGenSettings setting){
		if(delegates == null){
			delegates = newArrayList
			delegates.add(entityCompiler);
			delegates.add(jpaCompiler)
		} 
		
		return delegates.findFirst([
			var LCompilerType compilerType;
			if(setting == null){
				compilerType = null;
			} else {
				compilerType = setting.compilerType
			}
			return isResponsible(compilerType)
		])
	}
}




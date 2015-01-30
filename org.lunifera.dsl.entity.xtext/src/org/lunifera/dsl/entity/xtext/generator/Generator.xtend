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
package org.lunifera.dsl.entity.xtext.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.xtext.lazyresolver.api.logger.TimeLogger
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Generator extends JvmModelGenerator {

	static final Logger LOGGER = LoggerFactory.getLogger(typeof(Generator))

	@Inject extension ModelExtensions
	@Inject extension DtosFileGenerator
	
	override dispatch void internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		val log = TimeLogger.start(typeof(Generator));
		super._internalDoGenerate(type, fsa)
		log.stop(LOGGER, "generated " + type.qualifiedName)
	}

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)

		for (tmp : input.allContents.filter[it instanceof LTypedPackage].toList) {
			val log = TimeLogger.start(typeof(Generator));
			val LTypedPackage pkg = tmp as LTypedPackage
			fsa.deleteFile(input.toDtosFileName);
			fsa.generateFile(input.toDtosFileName, "DTOs", pkg.content);
			log.stop(LOGGER, "generated " + input.toDtosFileName)
		}
	}

	def toDtosFileName(Resource input) {
		val r = input.URI.lastSegment.replace("entitymodel", "dtos")
		return r
	}

}

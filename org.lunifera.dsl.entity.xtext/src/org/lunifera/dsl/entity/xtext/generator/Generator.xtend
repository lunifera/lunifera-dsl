/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.generator

import com.google.inject.Inject
import java.io.StringWriter
import java.io.Writer
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.generator.IFileSystemAccess
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions
import org.lunifera.dsl.semantic.common.types.LCommonModel
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.entity.LEntityModel
import org.lunifera.dsl.xtext.lazyresolver.api.logger.TimeLogger
import org.lunifera.dsl.xtext.lazyresolver.generator.DelegatingGenerator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Generator extends DelegatingGenerator {

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
		// persist the entities model
		toBinary(input, fsa)
	}
	
	def toBinary(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)

		val XMLResource outputRes = new XMLResourceImpl
		val LEntityModel lModel = input.contents.get(0) as LEntityModel
		outputRes.contents += EcoreUtil.copy(lModel)

		val Writer writer = new StringWriter
		outputRes.save(writer, null)

		fsa.generateFile(input.URI.lastSegment + ".entities_bin", "ModelBin", writer.toString)
	}

	def toDtosFileName(Resource input) {
		val r = input.URI.lastSegment.replace("entitymodel", "dtos")
		return r
	}

}

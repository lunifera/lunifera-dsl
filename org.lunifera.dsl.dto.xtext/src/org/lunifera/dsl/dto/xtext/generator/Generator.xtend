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
package org.lunifera.dsl.dto.xtext.generator

import com.google.inject.Inject
import java.io.StringWriter
import java.io.Writer
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.lunifera.dsl.dto.lib.IMapper
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoModel
import org.lunifera.dsl.xtext.lazyresolver.api.logger.TimeLogger
import org.lunifera.dsl.xtext.lazyresolver.generator.DelegatingGenerator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Generator extends DelegatingGenerator {

	static final Logger LOGGER = LoggerFactory.getLogger(typeof(Generator))

	@Inject extension MethodNamingExtensions
	@Inject extension ComponentGenerator
	@Inject extension ServicesFileGenerator
	@Inject extension SuperTypeCollector
	@Inject
	TypeReferences typeRefs

	@Inject IGeneratorConfigProvider generatorConfigProvider

	override dispatch void internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		if (DisableCodeGenerationAdapter.isDisabled(type))
			return;
		if (type.qualifiedName != null) {
			val log = TimeLogger.start(typeof(Generator));
			val JvmType mapper = typeRefs.getTypeForName(typeof(IMapper), type, null).type
			if (mapper instanceof JvmDeclaredType && type.isSuperType(mapper as JvmDeclaredType)) {
				fsa.generateFile(type.qualifiedName.replace('.', '/') + '.java', "Dto-Mappers",
					type.generateType(generatorConfigProvider.get(type)))
			} else {
				val log2 = TimeLogger.start(typeof(Generator));
				val output = type.generateType(generatorConfigProvider.get(type))
				log2.stop(LOGGER, "raw class generation for " + type.qualifiedName)
				fsa.generateFile(type.qualifiedName.replace('.', '/') + '.java', output)
			}
			log.stop(LOGGER, "generated " + type.qualifiedName)
		}
	}

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)

		for (tmp : input.allContents.filter[if(it instanceof LDto) wrappedType != null else false].toList) {
			val LDto dto = tmp as LDto
			val log = TimeLogger.start(typeof(Generator));
			fsa.deleteFile(dto.toServiceComponentName);
			fsa.generateFile(dto.toServiceComponentName, "OSGI-INF", dto.serviceContent);
			log.stop(LOGGER, "generated " + dto.toServiceComponentName)
		}

		input.allContents.filter[it instanceof LTypedPackage].map[it as LTypedPackage].forEach [
			val log = TimeLogger.start(typeof(Generator));
			fsa.deleteFile(input.toServiceName);
			fsa.generateFile(input.toServiceName, "Services-DSL", it.content);
			log.stop(LOGGER, "generated " + input.toServiceName)
		]

		// persist the dto model
		toBinary(input, fsa)
	}

	def toBinary(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)

		val XMLResource outputRes = new XMLResourceImpl
		val LDtoModel lModel = input.contents.get(0) as LDtoModel
		outputRes.contents += EcoreUtil.copy(lModel)

		val Writer writer = new StringWriter
		outputRes.save(writer, null)

		fsa.generateFile(input.URI.lastSegment + ".dtos_bin", "ModelBin", writer.toString)
	}

	def toServiceComponentName(LDto dto) {
		dto.toFqnMapperName + ".xml"
	}

	def toServiceName(Resource input) {
		val r = input.URI.lastSegment.replace("dtos", "services")
		return r
	}

}

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
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.lunifera.dsl.dto.lib.IMapper
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.dto.LDto

class Generator extends JvmModelGenerator {

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
			val JvmType mapper = typeRefs.getTypeForName(typeof(IMapper), type, null).type
			if (mapper instanceof JvmDeclaredType && type.isSuperType(mapper as JvmDeclaredType)) {
				fsa.generateFile(type.qualifiedName.replace('.', '/') + '.java', "Dto-Mappers",
					type.generateType(generatorConfigProvider.get(type)))
			} else {
				fsa.generateFile(type.qualifiedName.replace('.', '/') + '.java',
					type.generateType(generatorConfigProvider.get(type)))
			}
		}
	}

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)

		for (tmp : input.allContents.filter[if(it instanceof LDto) wrappedType != null else false].toList) {
			val LDto dto = tmp as LDto
			fsa.deleteFile(dto.toServiceComponentName);
			fsa.generateFile(dto.toServiceComponentName, "OSGI-INF", dto.serviceContent);
		}

		input.allContents.filter[it instanceof LTypedPackage].map[it as LTypedPackage].forEach [
			fsa.deleteFile(toServiceName);
			fsa.generateFile(toServiceName, "Services-DSL", it.content);
		]
	}

	def toServiceComponentName(LDto dto) {
		dto.toFqnMapperName + ".xml"
	}

	def toServiceName(LTypedPackage pkg) {
		pkg.name + ".services"
	}

}

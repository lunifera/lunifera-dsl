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

import org.lunifera.dsl.semantic.common.types.LDataType
import org.lunifera.dsl.semantic.common.types.LTypedPackage
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.entity.LEntity

/**
 *  This generator automatically creates a generic .dtos-file from a given entity model.
 * 	Imports, datatype declarations, enums and comments are carried over to the .dtos file, 
 * 	while bean and entity declarations are translated to DTO declarations with the
 *  appropriate inheritance information. Attributes and references are defined as inherited
 *  in this default conversion.
 */
class ServicesFileGenerator {

	def getContent(LTypedPackage pkg) '''
		package «pkg.getPkgName» {
			
			/* Imports the original entity and dto package */
			import «pkg.name».*;
			import «pkg.name».dtos.*; 
			
			«FOR LDto lDto : pkg.dtos»
				dtoservice «lDto.wrappedType.name»Service provides «lDto.name» {
				}
			«ENDFOR»
		}
	'''

	def String getPkgName(LTypedPackage pkg) {
		return pkg.name + ".services"
	}

	def String toPackageName(LTypedPackage pkg) {
		pkg.name + ".dtos"
	}

	def Iterable<LDataType> datatypes(LTypedPackage pkg) {
		pkg.types.filter[it instanceof LDataType].map[it as LDataType];
	}

	def Iterable<LDto> dtos(LTypedPackage pkg) {
		pkg.types.filter[it instanceof LDto].map[it as LDto].filter[
			wrappedType != null && wrappedType instanceof LEntity];
	}

}

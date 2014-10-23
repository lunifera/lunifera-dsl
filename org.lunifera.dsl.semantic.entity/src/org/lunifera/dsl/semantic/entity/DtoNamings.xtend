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
package org.lunifera.dsl.semantic.entity

import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.common.types.LPackage
import org.eclipse.emf.ecore.EObject

/**
 * Naming helper for DTOs
 */
class DtoNamings {
	
	def static String getDtoPackage(LPackage pkg) {
		var temp = pkg.name
		if (temp.endsWith(".entities")) {
			temp = temp.substring(0, temp.lastIndexOf(".entities"))
		}
		return temp + ".dtos"
	}
	
	def static String getGeneratedDtoFileName(LPackage pkg) {
		pkg.name + ".dtos"
	}
	 
	def static String getDtoClassFullyQualifiedName(LType type) {
		val pkg = type.package
		return pkg.dtoPackage + "." + type.dtoClassSimpleName
	}
	
	def static String getDtoClassSimpleName(LType type) {
		val name = type.name
		return name + "Dto"
	}
	
	def static LPackage getPackage(LType lType) {
		var EObject current = lType;
		while (current != null && !(current instanceof LPackage)) {
			current = current.eContainer();
		}
		return current as LPackage;
	}
	
}
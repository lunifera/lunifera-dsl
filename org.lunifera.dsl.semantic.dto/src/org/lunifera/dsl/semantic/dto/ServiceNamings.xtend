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
package org.lunifera.dsl.semantic.dto

import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.common.types.LPackage
import org.eclipse.emf.ecore.EObject
 
/**
 * Naming helper for DTO-Services
 */
class ServiceNamings {
	
	def static String getServicePackage(LPackage pkg) {
		var temp = pkg.name
		if (temp.endsWith(".dtos")) {
			temp = temp.substring(0, temp.lastIndexOf(".dtos"))
		}
		return temp + ".services"
	}
	
	def static String getGeneratedServiceFileName(LPackage pkg) {
		pkg.name + ".services"
	}
	 
	def static String getServiceClassFullyQualifiedName(LType type) {
		val pkg = type.package
		return pkg.servicePackage + "." + type.serviceClassSimpleName
	}
	
	def static String getServiceClassSimpleName(LType type) {
		val name = type.name
		return name + "Service"
	}
	
	def static LPackage getPackage(LType lType) {
		var EObject current = lType;
		while (current != null && !(current instanceof LPackage)) {
			current = current.eContainer();
		}
		return current as LPackage;
	}
	
}
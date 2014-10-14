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
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.dto.LDto

class ComponentGenerator {

	@Inject extension MethodNamingExtensions
	@Inject extension IQualifiedNameProvider

	def getServiceContent(LDto dto) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<scr:component xmlns:scr="http://www.osgi.org/xmlns/scr/v1.1.0" name="«dto.toFqnMapperName.toLowerCase»">
		       <implementation class="«dto.toFqnMapperName»"/>
		       <service>
				<provide interface="org.lunifera.dsl.dto.lib.IMapper"/>
			   </service>
		       <property name="dto" type="String" value="«dto.fullyQualifiedName.toString»"/>
		       <property name="entity" type="String" value="«dto.wrappedType.fullyQualifiedName.toString»"/>
		       <property name="service.pid" type="String" value="«dto.toFqnMapperName.toLowerCase»"/>
		       <reference name="bind" interface="org.lunifera.dsl.dto.lib.IMapperAccess" 
		       		cardinality="1..1" policy="static" bind="bindMapperAccess" unbind="unbindMapperAccess"/>
		</scr:component>
	'''
}

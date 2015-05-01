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
package org.lunifera.dsl.dto.xtext.generator

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.entity.LBean
import org.lunifera.dsl.semantic.entity.LEntity

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
				  
				«val tempDtos = dto.withParent»
				<property name="fordto.from.entity" type="String" value="«dto.wrappedType.fullyQualifiedName.toString»"/>
				«IF tempDtos.length > 1»
					<property name="fordto.to.dto" type="String">«tempDtos.toOrString»
					</property>
				«ELSE»
					<property name="fordto.to.dto" type="String" value="«dto.fullyQualifiedName.toString»"/>
				«ENDIF»

				<property name="forentity.from.dto" type="String" value="«dto.fullyQualifiedName.toString»"/>
				«val tempEntities = dto.wrappedType.withParent»
				«IF tempEntities.length > 1»
					<property name="forentity.to.entity" type="String">«tempEntities.toOrString»
					</property>
				«ELSE»
					<property name="forentity.to.entity" type="String" value="«dto.wrappedType.fullyQualifiedName.toString»"/>
				«ENDIF»
				
				<property name="service.pid" type="String" value="«dto.toFqnMapperName.toLowerCase»"/>
				<reference name="bind" interface="org.lunifera.dsl.dto.lib.IMapperAccess" 
						cardinality="1..1" policy="static" bind="bindMapperAccess" unbind="unbindMapperAccess"/>
		</scr:component>
	'''

	/**
	 * Properties will be returned as a String that OSGi will interpret as a list.
	 */
	def String toOrString(List<LType> types) {
		val StringBuilder b = new StringBuilder

		types.forEach [
			if (b.length > 0) {
				b.append("\n")
			}
			b.append(fullyQualifiedName.toString)
		]

		return b.toString
	}

	def dispatch List<LType> getWithParent(LEntity entity) {
		val result = <LType>newArrayList()
		collectWithParent(result, entity)
		return result
	}

	def void collectWithParent(List<LType> result, LEntity entity) {
		result += entity

		if (entity.superType != null) {
			collectWithParent(result, entity.superType)
		}
	}

	def dispatch List<LType> getWithParent(LBean bean) {
		val result = <LType>newArrayList()
		collectWithParent(result, bean)
		return result
	}

	def void collectWithParent(List<LType> result, LBean bean) {
		result += bean

		if (bean.superType != null) {
			collectWithParent(result, bean.superType)
		}
	}

	def dispatch List<LType> getWithParent(LDto dto) {
		val result = <LType>newArrayList()
		collectWithParent(result, dto)
		return result
	}

	def void collectWithParent(List<LType> result, LDto dto) {
		result += dto

		if (dto.superType != null) {
			collectWithParent(result, dto.superType)
		}
	}
}

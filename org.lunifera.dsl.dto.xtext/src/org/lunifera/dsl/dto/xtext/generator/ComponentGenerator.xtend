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
		<components xmlns:scr="http://www.osgi.org/xmlns/scr/v1.0.0">
		   <scr:component name="«dto.toFqnMapperName.toLowerCase»">
		       <implementation class="«dto.toFqnMapperName»"/>
		       <property name="dto" value="«dto.fullyQualifiedName.toString»"/>
		       <property name="entity" value="«dto.wrappedType.fullyQualifiedName.toString»"/>
		       <property name="service.pid" value="«dto.toFqnMapperName.toLowerCase»"/>
		       <reference name="bind" interface="org.lunifera.dsl.dto.common.IMapperAccess" 
		       		cardinality="1..1" policy="static" bind="bindMapperAccess" unbind="unbindMapperAccess"/>
		   </scr:component>
		</components>
	'''
}

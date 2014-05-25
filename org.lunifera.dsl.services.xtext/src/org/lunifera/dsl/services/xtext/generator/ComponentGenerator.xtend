package org.lunifera.dsl.services.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.service.LDTOService

class ComponentGenerator {

	@Inject extension MethodNamingExtensions
	@Inject extension IQualifiedNameProvider

	def getServiceContent(LDTOService service) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<components xmlns:scr="http://www.osgi.org/xmlns/scr/v1.0.0">
		   <scr:component name="«service.fullyQualifiedName.toLowerCase»">
		       <implementation class="«service.fullyQualifiedName»"/>
		       <service>
		       	<provide interface="org.lunifera.dsl.service.lib.IDTOService"/>
		       </service>
		       <property name="dto" value="«service.dto.fullyQualifiedName.toString»"/>
		       <property name="service.pid" value="«service.fullyQualifiedName.toLowerCase»"/>
		       «FOR ref : service.injectedServices.services»
		       	«IF ref.cardinality»
		       	<reference name="«ref.attributeName.toFirstLower»" interface="«ref.service.qualifiedName.toString»" 
		       			cardinality="1..1" policy="dynamic" bind="bind«ref.attributeName.toFirstUpper»" unbind="unbind«ref.
			attributeName.toFirstUpper»"/>
		       «ENDFOR»
		   </scr:component>
		</components>
	'''
}

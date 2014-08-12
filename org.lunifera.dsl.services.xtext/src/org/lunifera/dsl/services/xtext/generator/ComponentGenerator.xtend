package org.lunifera.dsl.services.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.service.LCardinality
import org.lunifera.dsl.semantic.service.LDTOService

import static org.lunifera.dsl.semantic.service.LCardinality.*
import org.lunifera.dsl.semantic.service.LService

class ComponentGenerator {

	@Inject extension MethodNamingExtensions
	@Inject extension IQualifiedNameProvider

	def dispatch getServiceContent(LDTOService service) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<components xmlns:scr="http://www.osgi.org/xmlns/scr/v1.0.0">
		   <scr:component name="«service.fullyQualifiedName.toLowerCase»">
		       <implementation class="«service.fullyQualifiedName»"/>
		       <service>
		       	<provide interface="org.lunifera.dsl.service.lib.IDTOService"/>
		       </service>
		       <property name="dto" value="«service.dto.fullyQualifiedName.toString»"/>
		       <property name="service.pid" value="«service.fullyQualifiedName.toLowerCase»"/>
		       «IF service.injectedServices != null»
		       «FOR ref : service.injectedServices.services»
		       	<reference name="«ref.attributeName.toFirstLower»" interface="«ref.service.qualifiedName.toString»" 
		       			cardinality="«ref.cardinality.cardinalityString»" policy="dynamic" bind="bind«ref.attributeName.
			toFirstUpper»" unbind="unbind«ref.attributeName.toFirstUpper»"/>
		       «ENDFOR»
		       «ENDIF»
		   </scr:component>
		</components>
	'''

	def dispatch getServiceContent(LService service) '''
«««		<?xml version="1.0" encoding="UTF-8"?>
«««		<components xmlns:scr="http://www.osgi.org/xmlns/scr/v1.0.0">
«««		   <scr:component name="«service.fullyQualifiedName.toLowerCase»">
«««		       <implementation class="«service.fullyQualifiedName»"/>
«««		       <service>
«««		       	<provide interface="org.lunifera.dsl.service.lib.IDTOService"/>
«««		       </service>
«««		       <property name="dto" value="«service.dto.fullyQualifiedName.toString»"/>
«««		       <property name="service.pid" value="«service.fullyQualifiedName.toLowerCase»"/>
«««		       «FOR ref : service.injectedServices.services»
«««		       	<reference name="«ref.attributeName.toFirstLower»" interface="«ref.service.qualifiedName.toString»" 
«««		       			cardinality="«ref.cardinality.cardinalityString»" policy="dynamic" bind="bind«ref.attributeName.
«««			toFirstUpper»" unbind="unbind«ref.attributeName.toFirstUpper»"/>
«««		       «ENDFOR»
«««		   </scr:component>
«««		</components>
	'''

	def String cardinalityString(LCardinality cardinality) {
		switch (cardinality) {
			case ZERO_TO_ONE:
				return "0..1"
			case ZERO_TO_MANY:
				return "0..n"
			case ONE_TO_ONE:
				return "1..1"
			case ONE_TO_MANY:
				return "1..n"
			default:
				return "0..1"
		}
	}

}

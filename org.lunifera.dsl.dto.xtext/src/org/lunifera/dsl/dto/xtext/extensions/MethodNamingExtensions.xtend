package org.lunifera.dsl.dto.xtext.extensions

import com.google.inject.Inject
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider
import org.lunifera.dsl.common.xtext.extensions.NamingExtensions
import org.lunifera.dsl.semantic.dto.LDto
import org.lunifera.dsl.semantic.dto.LDtoFeature
import org.eclipse.xtext.xbase.XExpression
import org.lunifera.dsl.semantic.common.types.LDtoMapper
import org.lunifera.dsl.semantic.dto.LDtoAttribute
import org.lunifera.dsl.semantic.dto.LDtoReference

class MethodNamingExtensions extends NamingExtensions {

	@Inject extension ModelExtensions;
	@Inject extension QualifiedNameProvider;

	def toMapPropertyToDto(LDtoFeature prop) {
		"toDto_" + prop.toName
	}

	def toMapPropertyToEntity(LDtoFeature prop) {
		"toEntity_" + prop.toName
	}

	def toMapperName(LDto dto) {
		if (dto == null || dto.toName == null) {
			return "setMISSING_NAME"
		}
		dto.toName + "Mapper"
	}

	def toFqnMapperName(LDto dto) {
		if (dto == null || dto.toName == null) {
			return "setMISSING_NAME"
		}
		dto.toMapperNamePackage + "." + dto.toMapperName
	}

	def toMapperNamePackage(LDto dto) {
		if (dto == null) {
			return "setMISSING_NAME"
		}
		dto.fullyQualifiedName.skipLast(1).append("mapper").toString
	}
	
	def dispatch XExpression toMapToEntityExpression(LDtoAttribute prop){
		if(prop.mapper != null) return prop.mapper.fromDTO else null
	}
	
	def dispatch XExpression toMapToDtoExpression(LDtoAttribute prop){
		if(prop.mapper != null) return prop.mapper.toDTO else null
	}
	
	def dispatch XExpression toMapToEntityExpression(LDtoReference prop){
		null
	}
	
	def dispatch XExpression toMapToDtoExpression(LDtoReference prop){
		null
	}
}

package org.lunifera.dsl.services.xtext.extensions

import com.google.inject.Inject
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider
import org.eclipse.xtext.xbase.XExpression
import org.lunifera.dsl.common.xtext.extensions.NamingExtensions
import org.lunifera.dsl.semantic.common.types.LType
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference
import org.lunifera.dsl.semantic.dto.LDtoFeature

class MethodNamingExtensions extends NamingExtensions {

	@Inject extension ModelExtensions;
	@Inject extension QualifiedNameProvider;

	def toMapPropertyToDto(LDtoFeature prop) {
		"toDto_" + prop.toName
	}

	def toMapPropertyToEntity(LDtoFeature prop) {
		"toEntity_" + prop.toName
	}

	def toMapperFieldName(LDtoFeature prop) {
		prop.toName + "Mapper"
	}

	def toMapperName(LType dto) {
		if (dto == null || dto.toName == null) {
			return "setMISSING_NAME"
		}
		dto.toName + "Mapper"
	}

	def toFqnMapperName(LType dto) {
		if (dto == null || dto.toName == null) {
			return "setMISSING_NAME"
		}
		dto.toMapperNamePackage + "." + dto.toMapperName
	}

	def toMapperNamePackage(LType dto) {
		if (dto == null || dto.fullyQualifiedName == null) {
			return "setMISSING_NAME"
		}
		dto.fullyQualifiedName.skipLast(1).append("mapper").toString
	}

	def XExpression toMapToEntityExpression(LDtoFeature prop) {
		if(prop.mapper != null) return prop.mapper.fromDTO else null
	}

	def XExpression toMapToDtoExpression(LDtoFeature prop) {
		if(prop.mapper != null) return prop.mapper.toDTO else null
	}

}

package org.lunifera.dsl.entity.xtext.extensions

import org.lunifera.dsl.entity.xtext.util.PersistenceNamingUtils
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.entity.LEntity

class MethodNamingExtensions extends org.lunifera.dsl.common.xtext.extensions.MethodNamingExtensions {

	// ### Might move to PersistenceExtensions
	def columnName(LAttribute prop) {
		var columnBaseName = prop.name
		if (columnBaseName.nullOrEmpty) {
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(prop.name)
		}

		// Compute the final column name using some settings. 
		// E.g. to add some prefix like the shortName of the Entity.
		// ### not yet implemented
		columnBaseName
	}

	def tableName(LEntity entity) {
		var tableBaseName = entity.persistenceName
		if (tableBaseName.nullOrEmpty) {
			tableBaseName = PersistenceNamingUtils::camelCaseToUpperCase(entity.name)
		}

		// Compute the final column name using some settings. 
		// E.g. to add some prefix like the shortName of the Entity.
		// ### not yet implemented
		tableBaseName
	}
}

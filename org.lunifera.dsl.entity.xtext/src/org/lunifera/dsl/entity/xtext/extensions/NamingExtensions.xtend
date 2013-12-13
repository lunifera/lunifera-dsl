package org.lunifera.dsl.entity.xtext.extensions

import org.lunifera.dsl.entity.xtext.util.PersistenceNamingUtils
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityAttribute
import org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo
import org.lunifera.dsl.semantic.entity.LEntityReference

class NamingExtensions extends org.lunifera.dsl.common.xtext.extensions.NamingExtensions {

	// ### Might move to PersistenceExtensions
	def dispatch toColumnName(LAttribute prop) {
		var columnBaseName = prop.name
		if (columnBaseName.nullOrEmpty) {
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(prop.name)
		}
 
		// Compute the final column name using some settings. 
		// E.g. to add some prefix like the shortName of the Entity.
		// ### not yet implemented
		columnBaseName
	}

	// ### Might move to PersistenceExtensions
	def dispatch toColumnName(LEntityAttribute prop) {
		var columnBaseName = prop.persistenceInfo?.columnName
		if (columnBaseName.nullOrEmpty) {
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(prop.name)
		} else {
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(columnBaseName)
		}

		// Compute the final column name using some settings. 
		// E.g. to add some prefix like the shortName of the Entity.
		// ### not yet implemented
		columnBaseName
	}

	// ### Might move to PersistenceExtensions
	def dispatch toColumnName(LEntityReference prop) {
		var columnBaseName = prop.persistenceInfo?.columnName
		if (columnBaseName.nullOrEmpty) {
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(prop.name)
		} else {
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(columnBaseName)
		}

		// Compute the final column name using some settings. 
		// E.g. to add some prefix like the shortName of the Entity.
		// ### not yet implemented
		columnBaseName
	}

	def toTableName(LEntity entity) {
		var tableBaseName = entity.persistenceInfo?.tableName
		if (tableBaseName.nullOrEmpty) {
			tableBaseName = PersistenceNamingUtils::camelCaseToUpperCase(entity.name)
		} else {
			tableBaseName = PersistenceNamingUtils::camelCaseToUpperCase(tableBaseName)
		}

		// Compute the final column name using some settings. 
		// E.g. to add some prefix like the shortName of the Entity.
		// ### not yet implemented
		tableBaseName
	}

	def toSchemaName(LEntity entity) {
		entity.persistenceInfo.toSchemaName
	}

	def toSchemaName(LEntityPersistenceInfo info) {
		var schemaName = info.schemaName
		if (!schemaName.nullOrEmpty) {
			schemaName = PersistenceNamingUtils::camelCaseToUpperCase(schemaName)
		}

		schemaName
	}
}

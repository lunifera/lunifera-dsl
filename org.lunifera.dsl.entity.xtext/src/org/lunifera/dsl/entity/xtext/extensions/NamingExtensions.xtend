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
package org.lunifera.dsl.entity.xtext.extensions

import com.google.inject.Inject
import org.lunifera.dsl.entity.xtext.util.PersistenceNamingUtils
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.entity.LEntity
import org.lunifera.dsl.semantic.entity.LEntityAttribute
import org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo
import org.lunifera.dsl.semantic.entity.LEntityReference

class NamingExtensions extends org.lunifera.dsl.common.xtext.extensions.NamingExtensions {

	@Inject extension ModelExtensions;

	// ### Might move to PersistenceExtensions
	def dispatch toColumnName(LAttribute prop) {
		var columnBaseName = prop.name
		if (columnBaseName.nullOrEmpty) {
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(prop.toName)
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
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(prop.toName)
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
			columnBaseName = PersistenceNamingUtils::camelCaseToUpperCase(prop.toName)
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
			tableBaseName = PersistenceNamingUtils::camelCaseToUpperCase(entity.toName)
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

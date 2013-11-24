package org.lunifera.dsl.entity.xtext.extensions

import org.lunifera.dsl.entity.xtext.util.PersistenceNamingUtils
import org.lunifera.dsl.semantic.common.types.LAttribute
import org.lunifera.dsl.semantic.common.types.LFeature
import org.lunifera.dsl.semantic.entity.LEntity

class MethodNamingExtensions { 
	
    def toSetterName(LFeature prop) {
        "set".concat(prop.name.toFirstUpper);
    }
    def toGetterName(LFeature prop) {
        "get".concat(prop.name.toFirstUpper);
    }
    def toBooleanGetterName(LFeature prop) {
        val propName = prop.name.toFirstLower 
        if (propName.startsWith("is") || propName.startsWith("has")) {
            return propName
        } 
        return "is".concat(prop.name.toFirstUpper);
    }

    def toCollectionAdderName(LFeature collectionProp) {
        return "addTo".concat(collectionProp.name.toFirstUpper);
    }
    def toCollectionRemoverName(LFeature collectionProp) {
        return "removeFrom".concat(collectionProp.name.toFirstUpper);
    }

    def toCollectionInternalGetterName(LFeature collectionProp) {
        return "internalGet".concat(collectionProp.name.toFirstUpper);
    }

    def toCollectionInternalAdderName(LFeature collectionProp) {
        return "internalAddTo".concat(collectionProp.name.toFirstUpper);
    }
    def toCollectionInternalRemoverName(LFeature collectionProp) {
        return "internalRemoveFrom".concat(collectionProp.name.toFirstUpper);
    }
    def toInternalSetterName(LFeature ref) {
        return "internalSet".concat(ref.name.toFirstUpper);
    }
    
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
	
		/** 
	 * Returns the property name that is used for method signatures.
	 */
	def String toMethodParamName(LFeature prop) {
		return prop.toGeneratorDefaultMethodParamName;
	}

	/**
	 * Returns the generator default method param name.
	 */
	def String toGeneratorDefaultMethodParamName(LFeature sourceElement) {
		return toMethodParamName(sourceElement.getName())
	}

	/** 
	 * Returns the property name that is used for method signatures.
	 */
	def String toMethodParamName(String name) {
		return String::format("%s", name);
	}
	
}
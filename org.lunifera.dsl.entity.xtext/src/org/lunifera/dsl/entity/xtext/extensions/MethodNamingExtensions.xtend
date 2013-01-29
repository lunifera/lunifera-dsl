package org.lunifera.dsl.entity.xtext.extensions

import org.lunifera.dsl.entity.semantic.model.LProperty

class MethodNamingExtensions { 
	
    def toSetterName(LProperty prop) {
        "set" + prop.name.toFirstUpper;
    }
    def toGetterName(LProperty prop) {
        "get" + prop.name.toFirstUpper;
    }
    def toBooleanGetterName(LProperty prop) {
        val propName = prop.name.toFirstLower 
        if (propName.startsWith("is") || propName.startsWith("has")) {
            return propName
        } 
        return "is" + prop.name.toFirstUpper;
    }

    def toCollectionAdderName(LProperty collectionProp) {
        return "addTo" + collectionProp.name.toFirstUpper;
    }
    def toCollectionRemoverName(LProperty collectionProp) {
        return "removeFrom" + collectionProp.name.toFirstUpper;
    }

    def toCollectionInternalGetterName(LProperty collectionProp) {
        return "internalGet" + collectionProp.name.toFirstUpper;
    }

    def toCollectionInternalAdderName(LProperty collectionProp) {
        return "internalAddTo" + collectionProp.name.toFirstUpper;
    }
    def toCollectionInternalRemoverName(LProperty collectionProp) {
        return "internalRemoveFrom" + collectionProp.name.toFirstUpper;
    }
    def toInternalSetterName(LProperty ref) {
        return "internalSet" + ref.name.toFirstUpper;
    }
	
}
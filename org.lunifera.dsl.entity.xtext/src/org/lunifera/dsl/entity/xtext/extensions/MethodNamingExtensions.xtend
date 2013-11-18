package org.lunifera.dsl.entity.xtext.extensions

import org.lunifera.dsl.entity.semantic.model.LProperty

class MethodNamingExtensions { 
	
    def toSetterName(LProperty prop) {
        "set".concat(prop.name.toFirstUpper);
    }
    def toGetterName(LProperty prop) {
        "get".concat(prop.name.toFirstUpper);
    }
    def toBooleanGetterName(LProperty prop) {
        val propName = prop.name.toFirstLower 
        if (propName.startsWith("is") || propName.startsWith("has")) {
            return propName
        } 
        return "is".concat(prop.name.toFirstUpper);
    }

    def toCollectionAdderName(LProperty collectionProp) {
        return "addTo".concat(collectionProp.name.toFirstUpper);
    }
    def toCollectionRemoverName(LProperty collectionProp) {
        return "removeFrom".concat(collectionProp.name.toFirstUpper);
    }

    def toCollectionInternalGetterName(LProperty collectionProp) {
        return "internalGet".concat(collectionProp.name.toFirstUpper);
    }

    def toCollectionInternalAdderName(LProperty collectionProp) {
        return "internalAddTo".concat(collectionProp.name.toFirstUpper);
    }
    def toCollectionInternalRemoverName(LProperty collectionProp) {
        return "internalRemoveFrom".concat(collectionProp.name.toFirstUpper);
    }
    def toInternalSetterName(LProperty ref) {
        return "internalSet".concat(ref.name.toFirstUpper);
    }
	
}
package org.lunifera.dsl.entity.xtext.extensions

import org.lunifera.dsl.entity.semantic.model.LProperty
import org.lunifera.dsl.entity.semantic.model.LReference

class MethodNamingExtensions { 
	
//	@Inject extension IQualifiedNameProvider

    def toCollectionAdderName(LReference collectionProp) {
        return "addTo" + collectionProp.name.toFirstUpper;
    }
    def toCollectionAdderName(LProperty collectionProp) {
        return "addTo" + collectionProp.name.toFirstUpper;
    }

    def toCollectionInternalGetterName(LReference collectionProp) {
        return "internalGet" + collectionProp.name.toFirstUpper;
    }
    def toCollectionInternalGetterName(LProperty collectionProp) {
        return "internalGet" + collectionProp.name.toFirstUpper;
    }

    def toCollectionInternalAdderName(LReference collectionProp) {
        return "internalAddTo" + collectionProp.name.toFirstUpper;
    }
    def toCollectionInternalRemoverName(LReference collectionProp) {
        return "internalRemoveFrom" + collectionProp.name.toFirstUpper;
    }
    def toInternalSetterName(LReference ref) {
        return "internalSet" + ref.name.toFirstUpper;
    }
	  
}
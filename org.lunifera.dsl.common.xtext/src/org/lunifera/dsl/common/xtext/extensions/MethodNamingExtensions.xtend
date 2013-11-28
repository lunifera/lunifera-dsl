package org.lunifera.dsl.common.xtext.extensions

import org.lunifera.dsl.semantic.common.types.LFeature

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

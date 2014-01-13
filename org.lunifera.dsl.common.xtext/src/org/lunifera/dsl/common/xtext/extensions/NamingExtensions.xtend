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
package org.lunifera.dsl.common.xtext.extensions

import com.google.inject.Inject
import org.lunifera.dsl.semantic.common.types.LFeature

class NamingExtensions {

	@Inject extension ModelExtensions;

	def toSetterName(LFeature prop) {
		if (prop == null || prop.toName == null) {
			return "setMISSING_NAME"
		}
		"set".concat(prop.toName.toFirstUpper);
	}

	def toGetterName(LFeature prop) {
		if (prop == null || prop.toName == null) {
			return "getMISSING_NAME"
		}
		if(prop.typeIsBoolean) "is".concat(prop.toName.toFirstUpper) else "get".concat(prop.toName.toFirstUpper);
	}

	def toBooleanGetterName(LFeature prop) {
		if (prop == null || prop.toName == null) {
			return "isMISSING_NAME"
		}
		val propName = prop.toName.toFirstLower
		if (propName.startsWith("is") || propName.startsWith("has")) {
			return propName
		}
		return "is".concat(prop.toName.toFirstUpper);
	}

	def toCollectionAdderName(LFeature collectionProp) {
		return "addTo".concat(collectionProp.toName.toFirstUpper);
	}

	def toCollectionRemoverName(LFeature collectionProp) {
		return "removeFrom".concat(collectionProp.toName.toFirstUpper);
	}

	def toCollectionInternalGetterName(LFeature collectionProp) {
		return "internalGet".concat(collectionProp.toName.toFirstUpper);
	}

	def toCollectionInternalAdderName(LFeature collectionProp) {
		return "internalAddTo".concat(collectionProp.toName.toFirstUpper);
	}

	def toCollectionInternalRemoverName(LFeature collectionProp) {
		return "internalRemoveFrom".concat(collectionProp.toName.toFirstUpper);
	}

	def toInternalSetterName(LFeature ref) {
		return "internalSet".concat(ref.toName.toFirstUpper);
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
		return toMethodParamName(sourceElement.toName)
	}

	/** 
	 * Returns the property name that is used for method signatures.
	 */
	def String toMethodParamName(String name) {
		return String::format("%s", name);
	}

}

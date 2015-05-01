
/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */

package org.lunifera.dsl.dto.xtext.jvmmodel;

import java.util.Date;

import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@SuppressWarnings("restriction")
@Singleton
public class TypeHelper {

	@Inject
	private TypeReferences typeReferences;

	/**
	 * Returns true, if the type is numeric without digits
	 * 
	 * @param type
	 * @return
	 */
	public boolean isNumber(JvmType type) {
		if (typeReferences.is(type, Byte.class)
				|| typeReferences.is(type, Byte.TYPE)
				|| typeReferences.is(type, Short.class)
				|| typeReferences.is(type, Short.TYPE)
				|| typeReferences.is(type, Integer.class)
				|| typeReferences.is(type, Integer.TYPE)
				|| typeReferences.is(type, Long.class)
				|| typeReferences.is(type, Long.TYPE)
				|| typeReferences.is(type, Float.class)
				|| typeReferences.is(type, Float.TYPE)
				|| typeReferences.is(type, Double.class)
				|| typeReferences.is(type, Double.TYPE)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true, if the type is boolean
	 * 
	 * @param type
	 * @return
	 */
	public boolean isBoolean(JvmType type) {
		if (typeReferences.is(type, Boolean.class)
				|| typeReferences.is(type, Boolean.TYPE)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true, if the type is boolean
	 * 
	 * @param type
	 * @return
	 */
	public boolean isString(JvmType type) {
		if (typeReferences.is(type, String.class)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true, if the type is date
	 * 
	 * @param type
	 * @return
	 */
	public boolean isDate(JvmType type) {
		if (typeReferences.is(type, Date.class)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true, if the type is enum
	 * 
	 * @param type
	 * @return
	 */
	public boolean isEnum(JvmType type) {
		return type instanceof JvmEnumerationType;
	}

	/**
	 * Returns true, if the type is complex
	 * 
	 * @param type
	 * @return
	 */
	public boolean isComplexType(JvmType type) {
		return !isBoolean(type) && !isDate(type) && !isEnum(type)
				&& !isNumber(type) && !isString(type);
	}
}

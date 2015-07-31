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
package org.lunifera.dsl.common.xtext.ui.contentassist;

import java.sql.Blob;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.lunifera.dsl.semantic.common.helper.Bounds;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LReference;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to
 * customize content assistant
 */
public class CommonGrammarProposalProvider
		extends
		org.lunifera.dsl.common.xtext.ui.contentassist.AbstractCommonGrammarProposalProvider {

	private static final String IS_PAST = "isPast";
	private static final String IS_FUTURE = "isFuture";
	private static final String MAX_SIZE = "maxSize";
	private static final String MIN_SIZE = "minSize";
	private static final String REGEX = "regex";
	private static final String IS_TRUE = "isTrue";
	private static final String IS_FALSE = "isFalse";
	private static final String IS_NULL = "isNull";
	private static final String IS_NOT_NULL = "isNotNull";
	private static final String MIN_NUMBER = "minNumber";
	private static final String MAX_NUMBER = "maxNumber";
	private static final String DIGITS = "digits";
	private static final String MIN_DECIMAL = "minDecimal";
	private static final String MAX_DECIMAL = "maxDecimal";
	private static Set<String> constraints = new HashSet<String>();
	private static Map<String, Set<String>> allowedConstraints = new HashMap<String, Set<String>>();
	static {
		constraints.add(IS_FALSE);
		constraints.add(IS_TRUE);
		constraints.add(MAX_DECIMAL);
		constraints.add(MIN_DECIMAL);
		constraints.add(DIGITS);
		constraints.add(IS_FUTURE);
		constraints.add(IS_PAST);
		constraints.add(MAX_NUMBER);
		constraints.add(MIN_NUMBER);
		constraints.add(IS_NOT_NULL);
		constraints.add(IS_NULL);
		constraints.add(REGEX);
		constraints.add(MIN_SIZE);
		constraints.add(MAX_SIZE);

		// constraints for String
		Set<String> stringConstraints = new HashSet<String>();
		allowedConstraints.put(String.class.getCanonicalName(),
				stringConstraints);
		stringConstraints.add(IS_NOT_NULL);
		stringConstraints.add(IS_NULL);
		stringConstraints.add(REGEX);
		stringConstraints.add(MIN_SIZE);
		stringConstraints.add(MAX_SIZE);
		
		// constraints for String
		Set<String> charConstraints = new HashSet<String>();
		allowedConstraints.put(Character.class.getCanonicalName(),
				stringConstraints);
		charConstraints.add(IS_NOT_NULL);
		charConstraints.add(IS_NULL);
		charConstraints.add(REGEX);

		// constraints for numeric
		Set<String> numericConstraints = new HashSet<String>();
		allowedConstraints.put(Short.class.getCanonicalName(),
				numericConstraints);
		allowedConstraints.put(Byte.class.getCanonicalName(),
				numericConstraints);
		allowedConstraints.put(Integer.class.getCanonicalName(),
				numericConstraints);
		allowedConstraints.put(Long.class.getCanonicalName(),
				numericConstraints);
		numericConstraints.add(MAX_NUMBER);
		numericConstraints.add(MIN_NUMBER);
		numericConstraints.add(IS_NOT_NULL);
		numericConstraints.add(IS_NULL);

		// constraints for decimal
		Set<String> decimalConstraints = new HashSet<String>();
		allowedConstraints.put(Float.class.getCanonicalName(),
				decimalConstraints);
		allowedConstraints.put(Double.class.getCanonicalName(),
				decimalConstraints);
		decimalConstraints.add(MAX_DECIMAL);
		decimalConstraints.add(MIN_DECIMAL);
		decimalConstraints.add(DIGITS);
		decimalConstraints.add(IS_NOT_NULL);
		decimalConstraints.add(IS_NULL);

		// constraints for boolean
		Set<String> booleanConstraints = new HashSet<String>();
		allowedConstraints.put(Boolean.class.getCanonicalName(),
				booleanConstraints);
		booleanConstraints.add(IS_FALSE);
		booleanConstraints.add(IS_TRUE);
		booleanConstraints.add(IS_NOT_NULL);
		booleanConstraints.add(IS_NULL);

		// constraints for Date
		Set<String> dateConstraints = new HashSet<String>();
		allowedConstraints.put(Date.class.getCanonicalName(), dateConstraints);
		dateConstraints.add(IS_NOT_NULL);
		dateConstraints.add(IS_NULL);
		dateConstraints.add(IS_PAST);
		dateConstraints.add(IS_FUTURE);

		// constraints for Blob
		Set<String> blobConstraints = new HashSet<String>();
		allowedConstraints.put(Blob.class.getCanonicalName(), blobConstraints);
		blobConstraints.add(IS_NOT_NULL);
		blobConstraints.add(IS_NULL);
	}

	protected boolean isKeywordWorthyToPropose(Keyword keyword,
			ContentAssistContext context) {
		EObject model = context.getCurrentModel();
		if (model instanceof LDataType) {
			String value = keyword.getValue();
			if (constraints.contains(value)) {
				LDataType dt = (LDataType) model;
				return forDatatype(value, dt);
			}
		} else if (model instanceof LAttribute) {
			String value = keyword.getValue();
			if (constraints.contains(value)) {
				LAttribute att = (LAttribute) model;
				if (att.getType() instanceof LDataType) {
					LDataType dt = (LDataType) att.getType();
					return forDatatype(value, dt);
				}
			}
		} else if (model instanceof LReference) {
			String value = keyword.getValue();
			if (constraints.contains(value)) {
				LReference ref = (LReference) model;
				if (Bounds.createFor(ref).isToMany()) {
					return false;
				}
				if (!value.equals(IS_NOT_NULL) && !value.equals(IS_NULL)) {
					return false;
				}
			}
		}
		return true;
	}

	protected boolean forDatatype(String value, LDataType dt) {
		if (!dt.isDate() && !dt.isAsBlob()) {
			if (dt.isAsPrimitive()
					&& (value.equals(IS_NOT_NULL) || value.equals(IS_NULL))) {
				return false;
			}
			String fqn = dt.getJvmTypeReference().getQualifiedName();
			Set<String> constraints = allowedConstraints.get(fqn);
			if (constraints != null) {
				return constraints.contains(value);
			} else {
				return false;
			}
		} else if (dt.isDate()) {
			Set<String> constraints = allowedConstraints.get(Date.class
					.getCanonicalName());
			if (constraints != null) {
				return constraints.contains(value);
			} else {
				return false;
			}
		} else if (dt.isAsBlob()) {
			Set<String> constraints = allowedConstraints.get(Blob.class
					.getCanonicalName());
			if (constraints != null) {
				return constraints.contains(value);
			} else {
				return false;
			}
		}

		return false;
	}
}

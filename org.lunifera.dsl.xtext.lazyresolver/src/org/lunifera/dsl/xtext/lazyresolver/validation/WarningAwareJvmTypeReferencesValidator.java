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
package org.lunifera.dsl.xtext.lazyresolver.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.validation.JvmTypeReferencesValidator;

@SuppressWarnings("restriction")
public class WarningAwareJvmTypeReferencesValidator extends
		JvmTypeReferencesValidator {

	@Override
	protected void warnRawType(JvmType type,
			JvmParameterizedTypeReference typeRef) {
		if (!isSuppressed(SuppressWarningAdapter.RAW_TYPE, typeRef)) {
			super.warnRawType(type, typeRef);
		}
	}

	protected boolean isSuppressed(String warning, EObject eObject) {
		SuppressWarningAdapter adapter = (SuppressWarningAdapter) EcoreUtil
				.getAdapter(eObject.eAdapters(), SuppressWarningAdapter.class);
		if (adapter != null) {
			return adapter.isSuppressed(warning);
		} else {
			return false;
		}
	}
}

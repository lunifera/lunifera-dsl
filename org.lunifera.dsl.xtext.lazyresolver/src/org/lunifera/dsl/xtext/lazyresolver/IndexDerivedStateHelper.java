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
package org.lunifera.dsl.xtext.lazyresolver;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.lunifera.dsl.xtext.lazyresolver.api.DerivedRootAdapter;

public class IndexDerivedStateHelper {

	/**
	 * Marks the given type to be derived later if its index is requested.
	 * 
	 * @param type
	 * @param context
	 * @param isPrelinkingPhase
	 */
	public void markAsToBeDerivedLater(JvmDeclaredType type,
			EObject context, boolean isPrelinkingPhase) {
		markAsToBeDerivedLater(type, context, isPrelinkingPhase, "");
	}

	/**
	 * Marks the given type to be derived later if its index is requested. The
	 * selector is used if more then one JvmType is derived with the same
	 * semantic element.
	 * 
	 * @param type
	 * @param context
	 * @param isPrelinkingPhase
	 */
	public void markAsToBeDerivedLater(JvmDeclaredType type,
			EObject context, boolean isPrelinkingPhase, String selector) {
		if (!isPrelinkingPhase) {

			DerivedRootAdapter adapter = new DerivedRootAdapter(context,
					selector);
			type.eAdapters().add(adapter);
		}
	}

	/**
	 * Marks the given type as derived.
	 * 
	 * @param type
	 */
	public void markAsDerived(JvmDeclaredType type) {
		DerivedRootAdapter adapter = (DerivedRootAdapter) EcoreUtil.getAdapter(
				type.eAdapters(), DerivedRootAdapter.class);
		if (adapter != null) {
			type.eAdapters().remove(adapter);
		}
	}

}

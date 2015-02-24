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
package org.lunifera.dsl.xtext.lazyresolver.api;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;

/**
 * An adapter to attach the semantic element and a selector to the
 * {@link JvmType}. The selector is used, if more then one {@link JvmType} is
 * inferred for a single {@link EObject}. Then the inferer needs to separate
 * which JvmTypes needs to be inferrerd at this state.
 */
public class DerivedRootAdapter extends AdapterImpl {

	private final EObject semantic;
	private final String selector;

	public DerivedRootAdapter(EObject context, String selector) {
		this.semantic = context;
		this.selector = selector;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DerivedRootAdapter.class;
	}

	/**
	 * @return the semantic
	 */
	public EObject getSemantic() {
		return semantic;
	}

	/**
	 * @return the selector
	 */
	public String getSelector() {
		return selector;
	}

}

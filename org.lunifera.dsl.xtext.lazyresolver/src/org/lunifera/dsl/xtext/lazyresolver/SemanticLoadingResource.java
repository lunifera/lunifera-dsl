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

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.lunifera.dsl.xtext.lazyresolver.api.ISemanticLoadingResource;

@SuppressWarnings("restriction")
public class SemanticLoadingResource extends BatchLinkableResource implements
		ISemanticLoadingResource {

	private boolean suppressDerivedState;

	@Override
	public EObject getSemanticElement(String fragment) {
		try {
			suppressDerivedState = true;
			return super.getEObject(fragment);
		} finally {
			suppressDerivedState = false;
		}
	}

	@Override
	public EObject getSemanticElement() {
		try {
			suppressDerivedState = true;
			return getContents().get(0);
		} finally {
			suppressDerivedState = false;
		}
	}

	public void installDerivedState(boolean preIndexingPhase) {
		if (preIndexingPhase || !suppressDerivedState) {
			super.installDerivedState(preIndexingPhase);
		}
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {

		EObject semanticElement = getSemanticElement();
		if (semanticElement == null)
			throw new IllegalStateException(
					"The Xtext resource must contain at least one element.");
		SaveOptions saveOptions = SaveOptions.getOptions(options);
		setEncodingFromOptions(options);
		getSerializer().serialize(semanticElement,
				new OutputStreamWriter(outputStream, getEncoding()),
				saveOptions);
	}

	@Override
	public EObject getEObject(String uriFragment) {
		if (uriFragment.startsWith("/0")) {
			// will access semantic model -> No need to install derived state
			try {
				suppressDerivedState = true;
				return super.getEObject(uriFragment);
			} finally {
				suppressDerivedState = false;
			}
		} else {
			return super.getEObject(uriFragment);
		}
	}

	protected void clearInternalState() {
		try {
			suppressDerivedState = true;
			super.clearInternalState();
		} finally {
			suppressDerivedState = false;
		}
	}
}
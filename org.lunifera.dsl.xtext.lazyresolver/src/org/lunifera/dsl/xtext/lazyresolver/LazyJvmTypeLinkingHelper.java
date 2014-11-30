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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A helper class to register jvmLinkingReferences.
 */
public class LazyJvmTypeLinkingHelper {

	private Map<EReference, EReference> linkMappings = new HashMap<EReference, EReference>();

	public LazyJvmTypeLinkingHelper() {
	}

	/**
	 * Registers a jvmTypeReference for a given semanticReference.
	 * 
	 * @param semanticReference
	 * @param jvmTypeReference
	 * @return
	 */
	public EReference register(EReference semanticReference,
			EReference jvmTypeReference) {
		return linkMappings.put(semanticReference, jvmTypeReference);
	}

	/**
	 * Returns true, if the semanticReference needs jvmLinking
	 * 
	 * @param semanticReference
	 * @return
	 */
	public boolean needsJvmLinking(EReference semanticReference) {
		return linkMappings.containsKey(semanticReference);
	}

	/**
	 * Returns true, if the given reference is a jvmLink
	 * 
	 * @param reference
	 * @return
	 */
	public boolean isJvmLink(EStructuralFeature feature) {
		if (feature instanceof EReference) {
			return linkMappings.containsValue(feature);
		} else {
			return false;
		}
	}

	/**
	 * Returns the jvmLinkingReference for the given semanticReference.
	 * 
	 * @param semanticReference
	 * @return
	 */
	public EReference getJvmLinkingReference(EReference semanticReference) {
		return linkMappings.get(semanticReference);
	}

}

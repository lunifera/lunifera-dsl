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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * A helper class to register jvmLinkingReferences.
 */
public class LazyJvmTypeLinkingHelper {

	private Map<EReference, Set<EReference>> linkMappings = new HashMap<EReference, Set<EReference>>();
	private Map<EReference, IJvmLinkCrossRefStringEnhancer> jvmLinkToEnhancers = new HashMap<EReference, IJvmLinkCrossRefStringEnhancer>();
	private Map<EReference, IJvmTypeRefFinisher> jvmLinkToFinisher = new HashMap<EReference, IJvmTypeRefFinisher>();
	private Set<EReference> jvmLinks = new HashSet<EReference>();

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
		return register(semanticReference, jvmTypeReference, null, null);
	}

	/**
	 * Registers a jvmTypeReference for a given semanticReference.
	 * 
	 * @param semanticReference
	 * @param jvmTypeReference
	 * @param enhancer
	 * @return
	 */
	public EReference register(EReference semanticReference,
			EReference jvmTypeReference,
			IJvmLinkCrossRefStringEnhancer enhancer,
			IJvmTypeRefFinisher finisher) {

		Set<EReference> links = linkMappings.get(semanticReference);
		if (links == null) {
			links = new HashSet<EReference>();
			linkMappings.put(semanticReference, links);
		}
		links.add(jvmTypeReference);
		jvmLinks.add(jvmTypeReference);

		if (enhancer != null) {
			jvmLinkToEnhancers.put(jvmTypeReference, enhancer);
		}

		if (finisher != null) {
			jvmLinkToFinisher.put(jvmTypeReference, finisher);
		}

		return jvmTypeReference;
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
			return jvmLinks.contains(feature);
		} else {
			return false;
		}
	}

	/**
	 * Returns the enhancer for the given feature.
	 * 
	 * @param feature
	 * @return
	 */
	public IJvmLinkCrossRefStringEnhancer getEnhancer(EStructuralFeature feature) {
		return jvmLinkToEnhancers.get(feature);
	}

	/**
	 * Returns the finisher for the given feature.
	 * 
	 * @param feature
	 * @return
	 */
	public IJvmTypeRefFinisher getFinisher(EStructuralFeature feature) {
		return jvmLinkToFinisher.get(feature);
	}

	/**
	 * Returns the jvmLinkingReference for the given semanticReference.
	 * 
	 * @param semanticReference
	 * @return
	 */
	public Set<EReference> getJvmLinkingReferences(EReference semanticReference) {
		return linkMappings.get(semanticReference);
	}

	/**
	 * The JvmLinks are a helper construct to provide proper proxies. But in
	 * some cases the cross reference String that is used for scoping needs to
	 * be enhanced. For instance if a DTO mapper is queried. The naming
	 * convention defines, that a mapper is called "{DTO-FQN}Mapper". So the
	 * jvmLink-proxy from LDto#mapperJvmType needs to become resolved with the
	 * name of the mapper.
	 */
	public interface IJvmLinkCrossRefStringEnhancer {

		/**
		 * Returns the crossRefString to be used.
		 * <p>
		 * Example: given "ItemDTO" and returned "ItemDTOMapper".
		 * 
		 * @param crossRefString
		 * @return
		 */
		String enhance(String crossRefString);

	}

	/**
	 * The JvmHelperProxies will be validated by Xbase. So it is necessary to
	 * add type arguments to raw types. This finisher gives access to the
	 * created {@link JvmTypeReference}.
	 */
	public interface IJvmTypeRefFinisher {

		/**
		 * Allows to manipulate the created type reference.
		 * 
		 * @param jvmLinkFeature
		 * @param typeRef
		 */
		void finish(EStructuralFeature jvmLinkFeature, JvmTypeReference typeRef);

	}

}

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
package org.lunifera.dsl.xtext.lazyresolver.linker;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.serializer.sequencer.LegacyTransientValueService;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper;

import com.google.inject.Inject;

/**
 * Ensures, that jvm links will not be serialized.
 */
@SuppressWarnings("restriction")
public class LazyJvmTypeTransientValueService extends
		LegacyTransientValueService {

	@Inject
	LazyJvmTypeLinkingHelper linkingHelper;

	@Override
	public ValueTransient isValueTransient(EObject semanticObject,
			EStructuralFeature feature) {
		if (linkingHelper.isJvmLink(feature)) {
			// JvmHelperLinks must not be serialized
			return ValueTransient.YES;
		}

		return super.isValueTransient(semanticObject, feature);
	}

}

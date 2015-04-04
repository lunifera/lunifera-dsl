
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


package org.lunifera.dsl.entity.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;
import org.lunifera.dsl.xtext.lazyresolver.linker.LazyJvmTypeTransientValueService;

@SuppressWarnings("restriction")
public class EntityGrammarTransientValueService extends
LazyJvmTypeTransientValueService {

	@Override
	public ListTransient isListTransient(EObject semanticObject,
			EStructuralFeature feature) {

		if (feature == LunEntityPackage.Literals.LBEAN__SUB_TYPES
				|| feature == LunEntityPackage.Literals.LENTITY__SUB_TYPES) {
			return ListTransient.YES;
		}

		return super.isListTransient(semanticObject, feature);
	}

}

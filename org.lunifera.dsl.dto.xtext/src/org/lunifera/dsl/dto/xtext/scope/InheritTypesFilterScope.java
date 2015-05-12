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
package org.lunifera.dsl.dto.xtext.scope;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.xtext.lazyresolver.api.EcoreUtil3;

import com.google.common.base.Predicate;

public class InheritTypesFilterScope extends FilteringScope {

	public InheritTypesFilterScope(LType context, IScope scope) {
		super(scope, createPredicate(context));
	}

	private static Predicate<IEObjectDescription> createPredicate(
			final LType context) {
		return new Predicate<IEObjectDescription>() {

			@Override
			public boolean apply(IEObjectDescription input) {
				LType type = (LType) input.getEObjectOrProxy();
				if (type.eIsProxy()) {
					type = (LType) EcoreUtil3.resolve(type, context.eResource()
							.getResourceSet());
				}
				if (type != context && type.getName() != null) {
					return true;
				}
				return false;
			}
		};
	}
}

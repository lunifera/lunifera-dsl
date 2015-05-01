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
import org.lunifera.dsl.semantic.common.types.LDataType;

import com.google.common.base.Predicate;

public class DatatypesFilterScope extends FilteringScope {

	public DatatypesFilterScope(IScope scope) {
		super(scope, createPredicate());
	}

	private static Predicate<IEObjectDescription> createPredicate() {
		return new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				if (input.getEObjectOrProxy() instanceof LDataType) {
					return true;
				}
				return false;
			}
		};
	}
}
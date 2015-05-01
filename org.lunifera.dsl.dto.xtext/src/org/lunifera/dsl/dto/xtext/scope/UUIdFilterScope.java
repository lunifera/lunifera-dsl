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
import org.lunifera.dsl.semantic.common.types.LType;

import com.google.common.base.Predicate;

public class UUIdFilterScope extends FilteringScope {

	public UUIdFilterScope(IScope scope) {
		super(scope, createPredicate());
	}

	private static Predicate<IEObjectDescription> createPredicate() {
		return new Predicate<IEObjectDescription>() {

			@Override
			public boolean apply(IEObjectDescription input) {
				LType temp = (LType) input.getEObjectOrProxy();
				if (temp instanceof LDataType) {
					LDataType type = (LDataType) temp;
					if (type.getJvmTypeReference() != null) {
						if (type.getJvmTypeReference().getQualifiedName()
								.equals("java.lang.String")) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}
}
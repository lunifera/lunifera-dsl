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
package org.lunifera.dsl.entity.xtext.scope;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;

public class DatatypesScope extends AbstractScope {

	// private final IScope parent;
	private final LAttribute context;
	@SuppressWarnings("unused")
	private final EReference reference;

	public DatatypesScope(IScope parent, final LAttribute context,
			EReference reference) {
		super(parent, false);
		// this.parent = parent;
		this.context = context;
		this.reference = reference;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		// Resource resource = context.eResource();
		List<IEObjectDescription> result = new ArrayList<IEObjectDescription>();

		LTypedPackage lPkg = getPackage(context);

		for (LType lType : lPkg.getTypes()) {
			if (lType instanceof LDataType) {
				result.add(EObjectDescription.create(lType.getName(), lType));
			}
		}

		return result;
	}

	private LTypedPackage getPackage(EObject context) {
		if (context instanceof LTypedPackage) {
			return (LTypedPackage) context;
		}

		return getPackage(context.eContainer());
	}

}
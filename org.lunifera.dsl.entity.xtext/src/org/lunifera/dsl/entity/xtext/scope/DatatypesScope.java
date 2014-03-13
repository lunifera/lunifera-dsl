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
package org.lunifera.dsl.entity.xtext.scope;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.lunifera.dsl.semantic.common.types.LAttribute;

public class DatatypesScope extends AbstractScope {

	private final IScope parent;
	private final LAttribute context;
	private final EReference reference;

	public DatatypesScope(IScope parent, final LAttribute context,
			EReference reference) {
		super(IScope.NULLSCOPE, true);
		this.parent = parent;
		this.context = context;
		this.reference = reference;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		Resource resource = context.eResource();
		List<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		for (IEObjectDescription desc : parent.getAllElements()) {
			InternalEObject descEObject = (InternalEObject) desc
					.getEObjectOrProxy();

			if (descEObject.eResource() == resource) {
				// include local datatypes
				result.add(desc);
			} else {
				// only support datatypes provided by the datatypes grammar
				URI uri = desc.getEObjectURI();
				if (uri.fileExtension().equals("datatypes")) {
					result.add(desc);
				}
			}
		}

		return result;
	}
}
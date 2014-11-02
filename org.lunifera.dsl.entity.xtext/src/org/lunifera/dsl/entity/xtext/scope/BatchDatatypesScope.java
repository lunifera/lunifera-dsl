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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

public class BatchDatatypesScope extends AbstractScope {

	private final LAttribute context;
	private final EReference reference;

	public BatchDatatypesScope(final LAttribute context, EReference reference,
			IResourceDescriptions resourceDescriptions) {
		super(createParentScope(context, reference, resourceDescriptions),
				false);
		this.context = context;
		this.reference = reference;
	}

	private static IScope createParentScope(final LAttribute context,
			final EReference reference,
			final IResourceDescriptions resourceDescriptions) {
		return new AbstractScope(IScope.NULLSCOPE, false) {
			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(context,
						reference);
				if (nodes.size() > 0) {
					String text = NodeModelUtils.getTokenText(nodes.get(0));
					if (text != null && !text.equals("")) {
						String datatypeName = "org.lunifera.dsl.common.datatypes."
								+ text;
						Iterable<IEObjectDescription> exported = resourceDescriptions
								.getExportedObjects(
										LunTypesPackage.Literals.LSCALAR_TYPE,
										QualifiedName.create(datatypeName
												.split("\\.")), false);
						if (exported.iterator().hasNext()) {
							return Collections
									.<IEObjectDescription> singletonList(new AliasedEObjectDescription(
											QualifiedName.create(text),
											exported.iterator().next()));
						}
					}
				}
				return null;
			}
		};
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<INode> nodes = NodeModelUtils.findNodesForFeature(context,
				reference);
		if (nodes.size() > 0) {
			String text = NodeModelUtils.getTokenText(nodes.get(0));
			if (text != null && !text.equals("")) {
				LDataType lDatatype = getInternalDatatype(context, text);
				if (lDatatype != null) {
					return Collections
							.<IEObjectDescription> singletonList(EObjectDescription
									.create(lDatatype.getName(), lDatatype));
				}
			}
		}

		return Collections.emptyList();
	}

	private static LDataType getInternalDatatype(EObject context, String name) {
		LTypedPackage lPkg = (LTypedPackage) context.eContainer().eContainer();
		for (LType lType : lPkg.getTypes()) {
			if (lType instanceof LDataType) {
				if (lType.getName().equals(name)) {
					return (LDataType) lType;
				}
			}
		}
		return null;
	}
}
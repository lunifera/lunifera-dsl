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

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityFeature;
import org.lunifera.dsl.semantic.entity.LEntityReference;

public class IndexScope extends AbstractScope {

	private final LEntity context;

	public IndexScope(final LEntity context) {
		super(IScope.NULLSCOPE, true);
		this.context = context;
	}
 
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		ModelExtensions ext = new ModelExtensions();

		List<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		for (LEntityFeature feature : context.getAllFeatures()) {
			if (feature instanceof LEntityAttribute) {
				LEntityAttribute attribute = (LEntityAttribute) feature;
				if (attribute.getType() instanceof LDataType) {
					if (ext.isPrimitive((LDataType) attribute.getType())) {
						result.add(new EObjectDescription(QualifiedName
								.create(feature.getName()), feature, null));
					}
				}
			} else if (feature instanceof LEntityReference) {
				result.add(new EObjectDescription(QualifiedName.create(feature
						.getName()), feature, null));
			}
		}

		return result;
	}
}
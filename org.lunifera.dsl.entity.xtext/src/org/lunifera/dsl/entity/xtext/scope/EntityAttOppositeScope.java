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

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;

public class EntityAttOppositeScope extends AbstractScope {
	private final LEntityAttribute prop;

	public EntityAttOppositeScope(LEntityAttribute prop) {
		super(IScope.NULLSCOPE, true);
		this.prop = prop;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		if (prop.getType() != null) {
			LEntity propClass = prop.getEntity();
			LScalarType type = prop.getType();
			if (type instanceof LBean) {
				LBean bean = (LBean) type;
				for (LBeanReference oppositeProp : bean.getReferences()) {
					if (oppositeProp.getType() == propClass) {
						String name = oppositeProp.getName();
						if (name != null) {
							result.add(new EObjectDescription(QualifiedName
									.create(name), oppositeProp, null));
						}
					}
				}
			}
		}
		return result;
	}
}
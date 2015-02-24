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

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LConstraints;
import org.lunifera.dsl.semantic.common.types.LReference;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanAttribute;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityReference;

public class EntityConstraintAttributeScope extends AbstractScope {
	private final LReference prop;

	public EntityConstraintAttributeScope(LReference reference) {
		super(IScope.NULLSCOPE, true);
		this.prop = reference;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		if (getType() != null && getType() instanceof LClass) {
			LType propClass = getType();
			if (propClass instanceof LBean) {
				LBean bean = (LBean) propClass;
				for (LBeanAttribute property : bean.getAllAttributes()) {
					String name = property.getName();
					if (name != null) {
						result.add(new EObjectDescription(QualifiedName
								.create(name), property, null));
					}
				}
			} else if (propClass instanceof LEntity) {
				LEntity entity = (LEntity) propClass;
				for (LEntityAttribute property : entity.getAllAttributes()) {
					String name = property.getName();
					if (name != null) {
						result.add(new EObjectDescription(QualifiedName
								.create(name), property, null));
					}
				}
			}
		}
		return result;
	}

	private LType getType() {
		if (prop instanceof LBeanReference) {
			return ((LBeanReference) prop).getType();
		} else if (prop instanceof LEntityReference) {
			return ((LEntityReference) prop).getType();
		}
		return null;
	}
}
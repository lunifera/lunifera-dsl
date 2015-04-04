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
package org.lunifera.dsl.services.xtext.scope;

import java.util.ArrayList;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.dto.LDtoInheritedReference;
import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityReference;

public class ServicesInheritedReferenceScope extends AbstractScope {
	private final LDtoInheritedReference prop;

	public ServicesInheritedReferenceScope(LDtoInheritedReference prop) {
		super(IScope.NULLSCOPE, true);
		this.prop = prop;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		LDto container = prop.getDTO();
		LType type = container.getWrappedType();

		if (type instanceof LEntity) {
			LEntity entity = (LEntity) type;
			for (LEntityReference entityRef : entity.getAllReferences()) {
				result.add(new EObjectDescription(QualifiedName
						.create(entityRef.getName()), entityRef, null));
			}
		} else if (type instanceof LBean) {
			LBean bean = (LBean) type;
			for (LBeanReference beanRef : bean.getAllReferences()) {
				result.add(new EObjectDescription(QualifiedName.create(beanRef
						.getName()), beanRef, null));
			}
		}

		return result;
	}
}
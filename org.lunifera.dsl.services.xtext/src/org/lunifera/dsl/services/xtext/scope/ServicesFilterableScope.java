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
import org.lunifera.dsl.dto.xtext.extensions.DtoModelExtensions;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.service.LFilterableAttributes;

public class ServicesFilterableScope extends AbstractScope {
	private final LFilterableAttributes container;

	public ServicesFilterableScope(LFilterableAttributes container) {
		super(IScope.NULLSCOPE, true);
		this.container = container;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		LDto dto = container.getParent().getDto();

		DtoModelExtensions dtoExtensions = new DtoModelExtensions();
		for (LFeature feature : dto.getAllFeatures()) {
			result.add(new EObjectDescription(QualifiedName
					.create(dtoExtensions.toName(feature)), feature, null));
		}

		return result;
	}
}

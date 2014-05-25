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
package org.lunifera.dsl.metadata.services.impl;

import org.lunifera.dsl.metadata.services.IEntityMetadataService;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

public class EntityMetadataService implements IEntityMetadataService {

	private final MetadataBuilder builder;

	public EntityMetadataService(MetadataBuilder builder) {
		super();
		this.builder = builder;
	}

	@Override
	public LEntity getMetadata(Class<?> entityClass) {
		return getMetadata(entityClass.getName());
	}

	@Override
	public LEntity getMetadata(String className) {
		return (LEntity) builder
				.getMetadata(className, LunEntityPackage.Literals.LENTITY);
	}

}

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

import org.lunifera.dsl.metadata.services.IDtoMetadataService;
import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;

public class DtoMetadataService implements IDtoMetadataService {

	private final MetadataBuilder builder;

	public DtoMetadataService(MetadataBuilder builder) {
		super();
		this.builder = builder;
	}

	@Override
	public LDto getMetadata(Class<?> entityClass) {
		return getMetadata(entityClass.getName());
	}

	@Override
	public LDto getMetadata(String className) {
		return (LDto) builder.getMetadata(className,
				LunDtoPackage.Literals.LDTO);
	}

}

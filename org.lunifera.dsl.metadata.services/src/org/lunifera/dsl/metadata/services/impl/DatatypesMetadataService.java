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

import org.lunifera.dsl.metadata.services.IDatatypesMetadataService;
import org.lunifera.dsl.metadata.services.IMetadataBuilderService;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

public class DatatypesMetadataService implements IDatatypesMetadataService {

	private final IMetadataBuilderService builder;

	public DatatypesMetadataService(IMetadataBuilderService builder) {
		super();
		this.builder = builder;
	}

	@Override
	public LDataType getMetadata(String qualifiedName) {
		return (LDataType) builder.getMetadata(qualifiedName,
				LunTypesPackage.Literals.LDATA_TYPE);
	}

}

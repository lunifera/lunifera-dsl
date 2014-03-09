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
package org.lunifera.dsl.dto.xtext.common;

@SuppressWarnings("serial")
public class CrossReference implements ICrossReferenceInfo {

	private String target;
	private Object id;
	private String number;
	private String description;

	@Override
	public String getTarget() {
		return target;
	}

	@Override
	public Object getId() {
		return id;
	}

	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public String getDescription() {
		return description;
	}

}

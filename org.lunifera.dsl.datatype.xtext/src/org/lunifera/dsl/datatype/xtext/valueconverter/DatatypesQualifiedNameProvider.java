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
package org.lunifera.dsl.datatype.xtext.valueconverter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.common.xtext.valueconverter.CommonQualifiedNameProvider;

import com.google.inject.Inject;

public class DatatypesQualifiedNameProvider extends CommonQualifiedNameProvider {

	
	@Inject
	private ModelExtensions extensions;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		return super.getFullyQualifiedName(obj);
	}

}

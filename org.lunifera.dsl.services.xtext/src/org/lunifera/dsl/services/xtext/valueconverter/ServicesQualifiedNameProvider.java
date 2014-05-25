/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Hans Georg Gl??ckler - Initial implementation
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.services.xtext.valueconverter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.common.xtext.valueconverter.CommonQualifiedNameProvider;
import org.lunifera.dsl.semantic.service.LFilterableAttributes;
import org.lunifera.dsl.semantic.service.LService;
import org.lunifera.dsl.semantic.service.LSortableAttributes;

import com.google.inject.Inject;

public class ServicesQualifiedNameProvider extends CommonQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	ModelExtensions extensions;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj == null) {
			return QualifiedName.create("");
		}

		if (obj instanceof LFilterableAttributes) {
			LFilterableAttributes filters = (LFilterableAttributes) obj;
			LService service = filters.getParent();
			QualifiedName name = getFullyQualifiedName(service);
			return name.append("supportedFilter");
		} else if (obj instanceof LSortableAttributes) {
			LSortableAttributes sortable = (LSortableAttributes) obj;
			LService service = sortable.getParent();
			QualifiedName name = getFullyQualifiedName(service);
			return name.append("supportedFilter");
		}

		return super.getFullyQualifiedName(obj);
	}

}

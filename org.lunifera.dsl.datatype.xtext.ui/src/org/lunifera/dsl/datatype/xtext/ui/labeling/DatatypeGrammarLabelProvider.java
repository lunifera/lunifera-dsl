/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Hans Georg Glöckler, Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Based on org.eclipse.xtend.ide.labeling.XtendLabelProvider
 */
package org.lunifera.dsl.datatype.xtext.ui.labeling;

import static com.google.common.collect.Iterables.filter;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LImport;
import org.lunifera.dsl.semantic.common.types.LPackage;

//git@github.com/lunifera/lunifera-dsl.git
import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 */
@SuppressWarnings("restriction")
public class DatatypeGrammarLabelProvider extends XbaseLabelProvider {

	@Inject
	private DatatypeGrammarImages images;

	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	public DatatypeGrammarLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}


	public String image(LImport element) {
		return "import.gif";
	}

	public ImageDescriptor image(LDataType element) {
		return images.forDatatype();
	}

	public ImageDescriptor image(LPackage element) {
		return images.forPackage();
	}

	public ImageDescriptor image(JvmParameterizedTypeReference typeRef) {
		return images.forTypeParameter(0);
	}

	public String text(LImport element) {
		return element.getImportedNamespace();
	}

	public String text(LClass element) {
		return element.getName();
	}

	public String text(LFeature element) {
		JvmField inferredField = getFirstOrNull(
				associations.getJvmElements(element), JvmField.class);
		if (inferredField != null) {
			JvmTypeReference type = inferredField.getType();
			if (type != null) {
				return element.getName() + " : " + type.getSimpleName();
			}
		}
		return element.getName();
	}


	public String text(JvmParameterizedTypeReference typeRef) {
		return typeRef.getType().getSimpleName();
	}

	protected <T> T getFirstOrNull(Iterable<EObject> elements, Class<T> type) {
		Iterator<T> iterator = filter(elements, type).iterator();
		return iterator.hasNext() ? iterator.next() : null;
	}
}

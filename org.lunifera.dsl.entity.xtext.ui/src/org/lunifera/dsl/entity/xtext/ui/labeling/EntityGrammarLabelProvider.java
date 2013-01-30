/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Based on org.eclipse.xtend.ide.labeling.XtendLabelProvider
 * 
 */
package org.lunifera.dsl.entity.xtext.ui.labeling;

import static com.google.common.collect.Iterables.filter;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.lunifera.dsl.entity.semantic.model.LClass;
import org.lunifera.dsl.entity.semantic.model.LEnum;
import org.lunifera.dsl.entity.semantic.model.LEnumLiteral;
import org.lunifera.dsl.entity.semantic.model.LImport;
import org.lunifera.dsl.entity.semantic.model.LOperation;
import org.lunifera.dsl.entity.semantic.model.LProperty;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 */
@SuppressWarnings("restriction")
public class EntityGrammarLabelProvider extends XbaseLabelProvider {

	@Inject
	private UIStrings uiStrings;

	@Inject
	private EntityGrammarImages images;

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	public EntityGrammarLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	public Image image(LImport element) {
		return images.forImport();
	}

	public Image image(LClass element) {
		final JvmGenericType inferredType = getFirstOrNull(
				associations.getJvmElements(element), JvmGenericType.class);
		return images.forClass(inferredType.getVisibility());
	}

	public Image image(LEnum element) {
		return images.forEnum(JvmVisibility.PUBLIC);
	}

	public Image image(LEnumLiteral element) {
		return images.forEnumLiteral();
	}

	public Image image(LOperation element) {
		JvmOperation inferredOperation = getFirstOrNull(
				associations.getJvmElements(element), JvmOperation.class);
		return images.forOperation(inferredOperation.getVisibility(),
				inferredOperation.isStatic());
	}

	public Image image(LProperty element) {
		if (!element.isComposition()) {
			JvmField inferredField = getFirstOrNull(
					associations.getJvmElements(element), JvmField.class);
			return images.forField(inferredField.getVisibility(),
					inferredField.isStatic(), false);
		} else {
			return images.forComposition(JvmVisibility.PUBLIC);
		}
	}

	// public Image image(LRefers element) {
	// return images.forRefers();
	// }
	//
	// public Image image(LContains element) {
	// return images.forContains();
	// }
	//
	// public Image image(LContainer element) {
	// return images.forContainer();
	// }

	public Image image(JvmParameterizedTypeReference typeRef) {
		return images.forTypeParameter();
	}

	public String text(LImport element) {
		return element.getImportedNamespace();
	}

	public String text(LClass element) {
		return element.getName();
	}

	public Object text(LOperation element) {
		JvmOperation inferredOperation = getFirstOrNull(
				associations.getJvmElements(element), JvmOperation.class);
		return signature(element.getName(), inferredOperation);
	}

	public String text(LProperty element) {
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

	// public String text(LRefers element) {
	// JvmField inferredField = getFirstOrNull(
	// associations.getJvmElements(element), JvmField.class);
	// if (inferredField != null) {
	// JvmTypeReference type = inferredField.getType();
	// if (type != null) {
	// return element.getName() + " : " + type.getSimpleName()
	// + " [refers]";
	// }
	// }
	// return element.getName();
	// }
	//
	// public String text(LContains element) {
	// JvmField inferredField = getFirstOrNull(
	// associations.getJvmElements(element), JvmField.class);
	// if (inferredField != null) {
	// JvmTypeReference type = inferredField.getType();
	// if (type != null) {
	// return element.getName() + " : " + type.getSimpleName()
	// + " [contains]";
	// }
	// }
	// return element.getName();
	// }
	//
	// public String text(LContainer element) {
	// JvmField inferredField = getFirstOrNull(
	// associations.getJvmElements(element), JvmField.class);
	// if (inferredField != null) {
	// JvmTypeReference type = inferredField.getType();
	// if (type != null) {
	// return element.getName() + " : " + type.getSimpleName()
	// + " [container]";
	// }
	// }
	// return element.getName();
	// }

	public String text(JvmParameterizedTypeReference typeRef) {
		return typeRef.getType().getSimpleName();
	}

	protected <T> T getFirstOrNull(Iterable<EObject> elements, Class<T> type) {
		Iterator<T> iterator = filter(elements, type).iterator();
		return iterator.hasNext() ? iterator.next() : null;
	}
}

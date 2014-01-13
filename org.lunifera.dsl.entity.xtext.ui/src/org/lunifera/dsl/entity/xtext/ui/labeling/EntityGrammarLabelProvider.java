/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Hans Georg Glöckler, Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Based on org.eclipse.xtend.ide.labeling.XtendLabelProvider
 */
package org.lunifera.dsl.entity.xtext.ui.labeling;

import static com.google.common.collect.Iterables.filter;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;
import org.lunifera.dsl.semantic.common.types.LAnnotationDef;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LEnum;
import org.lunifera.dsl.semantic.common.types.LEnumLiteral;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LImport;
import org.lunifera.dsl.semantic.common.types.LPackage;
import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanAttribute;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityFeature;
import org.lunifera.dsl.semantic.entity.LEntityReference;
import org.lunifera.dsl.semantic.entity.LOperation;

//git@github.com/lunifera/lunifera-dsl.git
import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 */
@SuppressWarnings("restriction")
public class EntityGrammarLabelProvider extends XbaseLabelProvider {

	@Inject
	private EntityGrammarImages images;

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	public EntityGrammarLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	public ImageDescriptor image(LImport element) {
		return images.forImport();
	}

	public ImageDescriptor image(LEntity element) {
		final JvmGenericType inferredType = getFirstOrNull(
				associations.getJvmElements(element), JvmGenericType.class);
		return images.forClass(inferredType.getVisibility(),
				JavaElementImageDescriptor.STATIC);
	}

	public ImageDescriptor image(LBean element) {
		final JvmGenericType inferredType = getFirstOrNull(
				associations.getJvmElements(element), JvmGenericType.class);
		return images.forClass(inferredType.getVisibility(), 0);
	}

	public ImageDescriptor image(LEnum element) {
		return images.forEnum(JvmVisibility.PUBLIC);
	}

	public ImageDescriptor image(LEnumLiteral element) {
		return images.forEnumLiteral();
	}

	public ImageDescriptor image(LOperation element) {
		JvmOperation inferredOperation = getFirstOrNull(
				associations.getJvmElements(element), JvmOperation.class);
		return images.forOperation(inferredOperation.getVisibility(), 0);
	}

	public ImageDescriptor image(LEntityReference element) {
		if (!element.isCascading()) {
			JvmField inferredField = getFirstOrNull(
					associations.getJvmElements(element), JvmField.class);
			return images.forField(inferredField.getVisibility(), 0);
		} else {
			return images.forCascading(JvmVisibility.PUBLIC);
		}
	}

	public ImageDescriptor image(LBeanReference element) {
		if (!element.isCascading()) {
			JvmField inferredField = getFirstOrNull(
					associations.getJvmElements(element), JvmField.class);
			return images.forField(inferredField.getVisibility(), 0);
		} else {
			return images.forCascading(JvmVisibility.PUBLIC);
		}
	}

	public ImageDescriptor image(LEntityAttribute element) {
		if (!element.isCascading()) {
			JvmField inferredField = getFirstOrNull(
					associations.getJvmElements(element), JvmField.class);
			return images.forField(inferredField.getVisibility(), 0);
		} else {
			return images.forCascading(JvmVisibility.PUBLIC);
		}
	}

	public ImageDescriptor image(LBeanAttribute element) {
		if (!element.isCascading()) {
			JvmField inferredField = getFirstOrNull(
					associations.getJvmElements(element), JvmField.class);
			return images.forField(inferredField.getVisibility(), 0);
		} else {
			return images.forCascading(JvmVisibility.PUBLIC);
		}
	}

	public ImageDescriptor image(LDataType element) {
		return images.forDatatype();
	}

	public ImageDescriptor image(LPackage element) {
		return images.forPackage();
	}

	public ImageDescriptor image(LEntityFeature element) {
		return images.forCascading(JvmVisibility.PUBLIC);
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

	public ImageDescriptor image(JvmParameterizedTypeReference typeRef) {
		return images.forTypeParameter(0);
	}

	public String text(LImport element) {
		return element.getImportedNamespace();
	}

	public String text(LAnnotationDef element) {
		return "@"
				+ element.getAnnotation().getAnnotationType()
						.getQualifiedName();
	}

	public String text(LClass element) {
		return element.getName();
	}

	public Object text(LOperation element) {
		JvmOperation inferredOperation = getFirstOrNull(
				associations.getJvmElements(element), JvmOperation.class);
		return signature(element.getName(), inferredOperation);
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

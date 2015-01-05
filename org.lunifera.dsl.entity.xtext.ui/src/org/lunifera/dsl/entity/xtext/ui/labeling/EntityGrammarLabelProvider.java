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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;
import org.lunifera.dsl.semantic.common.types.LAnnotationDef;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LEnum;
import org.lunifera.dsl.semantic.common.types.LEnumLiteral;
import org.lunifera.dsl.semantic.common.types.LFeature;
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
	public EntityGrammarLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	public ImageDescriptor image(LEntity element) {
		return images.forClass(JvmVisibility.PUBLIC, 0);
	}

	public ImageDescriptor image(LBean element) {
		return images.forClass(JvmVisibility.PUBLIC, 0);
	}

	public ImageDescriptor image(LEnum element) {
		return images.forEnum(JvmVisibility.PUBLIC);
	}

	public ImageDescriptor image(LEnumLiteral element) {
		return images.forEnumLiteral();
	}

	public ImageDescriptor image(LOperation element) {
		return images.forOperation(JvmVisibility.PUBLIC, 0);
	}

	public ImageDescriptor image(LEntityReference element) {
		if (!element.isCascading()) {
			return images.forField(JvmVisibility.PUBLIC, 0);
		} else {
			return images.forCascading(JvmVisibility.PUBLIC);
		}
	}

	public ImageDescriptor image(LBeanReference element) {
		if (!element.isCascading()) {
			return images.forField(JvmVisibility.PUBLIC, 0);
		} else {
			return images.forCascading(JvmVisibility.PUBLIC);
		}
	}

	public ImageDescriptor image(LEntityAttribute element) {
		if (!element.isCascading()) {
			return images.forField(JvmVisibility.PUBLIC, 0);
		} else {
			return images.forCascading(JvmVisibility.PUBLIC);
		}
	}

	public ImageDescriptor image(LBeanAttribute element) {
		if (!element.isCascading()) {
			return images.forField(JvmVisibility.PUBLIC, 0);
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

	public ImageDescriptor image(JvmParameterizedTypeReference typeRef) {
		return images.forTypeParameter(0);
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
		return element.getName();
	}

	public String text(LFeature element) {
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

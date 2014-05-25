/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Hans Georg Glöckler, Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Based on org.eclipse.xtend.ide.labeling.XtendLabelProvider
 */
package org.lunifera.dsl.dto.xtext.ui.labeling;

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
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LEnum;
import org.lunifera.dsl.semantic.common.types.LEnumLiteral;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LImport;
import org.lunifera.dsl.semantic.common.types.LPackage;
import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.dto.LDtoAttribute;
import org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute;
import org.lunifera.dsl.semantic.dto.LDtoInheritedReference;
import org.lunifera.dsl.semantic.dto.LDtoMapper;
import org.lunifera.dsl.semantic.dto.LDtoOperation;
import org.lunifera.dsl.semantic.dto.LDtoReference;

//git@github.com/lunifera/lunifera-dsl.git
import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 */
@SuppressWarnings("restriction")
public class DtoGrammarLabelProvider extends XbaseLabelProvider {

	@Inject
	private DtoGrammarImages images;

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private org.lunifera.dsl.dto.xtext.extensions.DtoModelExtensions extension;

	@Inject
	public DtoGrammarLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	public String image(LImport element) {
		return "import.gif";
	}

	public ImageDescriptor image(LDto element) {
		final JvmGenericType inferredType = getFirstOrNull(
				associations.getJvmElements(element), JvmGenericType.class);
		return images.forClass(inferredType.getVisibility(),
				JavaElementImageDescriptor.STATIC);
	}

	public ImageDescriptor image(LEnum element) {
		return images.forEnum(JvmVisibility.PUBLIC);
	}

	public ImageDescriptor image(LEnumLiteral element) {
		return images.forEnumLiteral();
	}

	public String image(LDtoMapper element) {
		return "converter.gif";
	}

	public String image(LDtoInheritedReference element) {
		return "inheritedfeature.gif";
	}

	public ImageDescriptor image(LDtoReference element) {
		if (!element.isCascading()) {
			JvmField inferredField = getFirstOrNull(
					associations.getJvmElements(element), JvmField.class);
			return images.forField(inferredField.getVisibility(), 0);
		} else {
			return images.forCascading(JvmVisibility.PUBLIC);
		}
	}

	public String image(LDtoInheritedAttribute element) {
		return "inheritedfeature.gif";
	}
	
	public ImageDescriptor image(LDtoOperation element) {
		JvmOperation inferredOperation = getFirstOrNull(
				associations.getJvmElements(element), JvmOperation.class);
		return images.forOperation(inferredOperation.getVisibility(), 0);
	}

	public ImageDescriptor image(LDtoAttribute element) {
		if (!element.isCascading()) {
			JvmField inferredField = getFirstOrNull(
					associations.getJvmElements(element), JvmField.class);
			return images.forField(inferredField.getVisibility(), 0);
		} else {
			return images.forCascading(JvmVisibility.PUBLIC);
		}
	}

	// public ImageDescriptor image(LDtoMapper element) {
	// if (!element.getisCascading()) {
	// JvmField inferredField = getFirstOrNull(
	// associations.getJvmElements(element), JvmField.class);
	// return images.forField(inferredField.getVisibility(), 0);
	// } else {
	// return images.forCascading(JvmVisibility.PUBLIC);
	// }
	// }

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

	public String text(LDtoMapper element) {
		return "Mapper";
	}

	public String text(LDtoInheritedAttribute element) {
		JvmField inferredField = getFirstOrNull(
				associations.getJvmElements(element), JvmField.class);
		if (inferredField != null) {
			JvmTypeReference type = inferredField.getType();
			if (type != null) {
				return extension.inheritedFeature(element).getName() + " : "
						+ type.getSimpleName();
			}
		}
		return element.getName();
	}

	public String text(LDtoInheritedReference element) {
		JvmField inferredField = getFirstOrNull(
				associations.getJvmElements(element), JvmField.class);
		if (inferredField != null) {
			JvmTypeReference type = inferredField.getType();
			if (type != null) {
				return extension.inheritedFeature(element).getName() + " : "
						+ type.getSimpleName();
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

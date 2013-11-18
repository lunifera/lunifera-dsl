/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Based on org.eclipse.xtend.ide.labeling.XtendImages
 * 
 */
package org.lunifera.dsl.entity.xtext.ui.labeling;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages2;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class EntityGrammarImages extends XbaseImages2 {

	@Inject
	private IImageHelper imageHelper;

	public ImageDescriptor forFilter() {
		return JavaPluginImages.DESC_ELCL_FILTER;
	}

	public ImageDescriptor forImplementsAnnotation() {
		return JavaPluginImages.DESC_OBJ_IMPLEMENTS;
	}

	public ImageDescriptor forOverridesAnnotation() {
		return JavaPluginImages.DESC_OBJ_OVERRIDES;
	}

	public ImageDescriptor forPackage() {
		return JavaPluginImages.DESC_OBJS_PACKDECL;
	}

	public ImageDescriptor forImport() {
		return forImport();
	}

	public ImageDescriptor forField(JvmVisibility visibility, int attachment) {
		ImageDescriptor descriptor = JavaElementImageProvider
				.getFieldImageDescriptor(false, toFlags(JvmVisibility.PUBLIC));
		return attachment >= 0 ? getDecorated(descriptor, attachment)
				: descriptor;
	}

	public ImageDescriptor forEnum(JvmVisibility visibility) {
		int flags = toFlags(visibility);
		flags |= Flags.AccEnum;
		return super.forEnum(visibility, flags);
	}

	public ImageDescriptor forEnumLiteral() {
		ImageDescriptor descriptor = JavaElementImageProvider
				.getFieldImageDescriptor(false, toFlags(JvmVisibility.PUBLIC));
		return descriptor;
	}

	public ImageDescriptor forProperty() {
		return super.forField(JvmVisibility.PUBLIC, -1);
	}

	public ImageDescriptor forRefers() {
		return forField(JvmVisibility.PUBLIC, -1);
	}

	public ImageDescriptor forCascading(JvmVisibility visibility) {
		return forField(JvmVisibility.PUBLIC, -1);
	}
}

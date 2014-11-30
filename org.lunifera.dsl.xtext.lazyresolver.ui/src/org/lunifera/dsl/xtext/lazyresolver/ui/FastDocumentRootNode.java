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
package org.lunifera.dsl.xtext.lazyresolver.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.lunifera.dsl.xtext.lazyresolver.api.ISemanticLoadingResource;

/**
 * This implementation ensures, that the editor is opened immediately. Further
 * calculations like "installing derived state" is processed in background.<br>
 * So it may happen, that tooltips about the JvmTypes will be available only a
 * few seconds later. And please note: The derived states will only be
 * installed, if the cursor is positioned in the editor.
 */
public class FastDocumentRootNode extends DocumentRootNode {
	public FastDocumentRootNode(Image image, Object text,
			IXtextDocument document, IOutlineTreeStructureProvider treeProvider) {
		super(image, text, document, treeProvider);
	}

	@Override
	public <T> T readOnly(final IUnitOfWork<T, EObject> work) {
		return getDocument().readOnly(new IUnitOfWork<T, XtextResource>() {
			public T exec(XtextResource resource) throws Exception {
				ISemanticLoadingResource semanticLoadingResource = (ISemanticLoadingResource) resource;
				EObject semanticElement = semanticLoadingResource
						.getSemanticElement();
				if (resource != null && semanticElement != null) {
					work.exec(semanticElement);
				}
				return null;
			}
		});
	}
}
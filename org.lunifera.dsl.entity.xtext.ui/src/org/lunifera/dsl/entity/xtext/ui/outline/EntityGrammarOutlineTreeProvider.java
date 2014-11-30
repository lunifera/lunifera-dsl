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
package org.lunifera.dsl.entity.xtext.ui.outline;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.util.TextRegion;
import org.lunifera.dsl.semantic.common.types.LAnnotationDef;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanAttribute;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityFeature;
import org.lunifera.dsl.semantic.entity.LEntityReference;
import org.lunifera.dsl.semantic.entity.LIndex;
import org.lunifera.dsl.semantic.entity.LOperation;
import org.lunifera.dsl.xtext.lazyresolver.ui.FastDocumentRootNode;

public class EntityGrammarOutlineTreeProvider extends
		DefaultOutlineTreeProvider {

	public IOutlineNode createRoot(IXtextDocument document) {
		DocumentRootNode documentNode = new FastDocumentRootNode(
				labelProvider.getImage(document),
				labelProvider.getText(document), document, this);
		documentNode.setTextRegion(new TextRegion(0, document.getLength()));
		return documentNode;
	}
	
	protected void _createChildren(IOutlineNode parentNode, LTypedPackage modelElement) {
		for (LType childElement : modelElement.getTypes()) {
			createNode(parentNode, childElement);
		}
	}
	
	protected void _createChildren(IOutlineNode parentNode, LEntity modelElement) {
		for (LAnnotationDef childElement : modelElement.getAnnotations()) {
			createNode(parentNode, childElement);
		}

		for (LEntityAttribute childElement : modelElement.getAttributes()) {
			createNode(parentNode, childElement);
		}
		
		for (LEntityReference childElement : modelElement.getReferences()) {
			createNode(parentNode, childElement);
		}
		
		for (LOperation childElement : modelElement.getOperations()) {
			createNode(parentNode, childElement);
		}
		
		for (LIndex childElement : modelElement.getIndexes()) {
			createNode(parentNode, childElement);
		}
	}
	
	protected void _createChildren(IOutlineNode parentNode, LBean modelElement) {
		for (LAnnotationDef childElement : modelElement.getAnnotations()) {
			createNode(parentNode, childElement);
		}

		for (LBeanAttribute childElement : modelElement.getAttributes()) {
			createNode(parentNode, childElement);
		}
		
		for (LBeanReference childElement : modelElement.getReferences()) {
			createNode(parentNode, childElement);
		}
		
		for (LOperation childElement : modelElement.getOperations()) {
			createNode(parentNode, childElement);
		}
	}
}

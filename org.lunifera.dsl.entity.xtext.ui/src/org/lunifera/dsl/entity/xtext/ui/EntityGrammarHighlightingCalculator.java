/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributions:
 * 		Hans Georg Glöckler - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.lunifera.dsl.entity.semantic.model.LClass;
import org.lunifera.dsl.entity.semantic.model.LGenSettings;
import org.lunifera.dsl.entity.semantic.model.LProperty;

public class EntityGrammarHighlightingCalculator implements
		ISemanticHighlightingCalculator {

	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getParseResult() == null)
			return;

		INode root = resource.getParseResult().getRootNode();
		BidiTreeIterator<INode> it = root.getAsTreeIterable().iterator();
		while (it.hasNext()) {
			INode node = it.next();
			String text = node.getText();
			EObject semanticElement = node.getSemanticElement();

			if (semanticElement instanceof LProperty) {
				if ("id".equals(text) || "transient".equals(text)
						|| "version".equals(text)) {
					if (node.getNextSibling() == null) {
						if (!"transient".equals(text)) {
							acceptor.addPosition(node.getOffset(),
									node.getLength(),
									EntityHighlightingConfiguration.DEFAULT_ID);
						}
					} else {
						acceptor.addPosition(node.getOffset(),
								node.getLength(),
								EntityHighlightingConfiguration.MODIFIER_ID);
					}

				}
			} else if (semanticElement instanceof LClass) {
				if ("cachable".equals(text) || "embeddable".equals(text)) {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							EntityHighlightingConfiguration.MODIFIER_ID);
				}
			} else if (semanticElement instanceof LGenSettings) {
				if ("compilerType=".equals(text)) {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							EntityHighlightingConfiguration.DEFAULT_ID);
				}
			}
		}
	}

}

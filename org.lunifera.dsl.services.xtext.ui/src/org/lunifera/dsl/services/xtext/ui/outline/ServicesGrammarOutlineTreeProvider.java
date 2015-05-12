

/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */


package org.lunifera.dsl.services.xtext.ui.outline;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.util.TextRegion;
import org.lunifera.dsl.xtext.lazyresolver.ui.FastDocumentRootNode;

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
public class ServicesGrammarOutlineTreeProvider extends
		org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider {

	public IOutlineNode createRoot(IXtextDocument document) {
		DocumentRootNode documentNode = new FastDocumentRootNode(
				labelProvider.getImage(document),
				labelProvider.getText(document), document, this);
		documentNode.setTextRegion(new TextRegion(0, document.getLength()));
		return documentNode;
	}
}

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

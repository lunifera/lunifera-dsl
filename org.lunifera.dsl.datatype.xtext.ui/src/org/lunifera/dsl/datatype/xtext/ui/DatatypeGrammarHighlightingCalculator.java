package org.lunifera.dsl.datatype.xtext.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.lunifera.dsl.common.xtext.services.CommonGrammarGrammarAccess.ScalarTypeElements;
import org.lunifera.dsl.datatype.xtext.ui.DatatypeHighlightingConfiguration;

public class DatatypeGrammarHighlightingCalculator implements
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

			if (semanticElement instanceof ScalarTypeElements) {
				if ("long".equals(text) || "int".equals(text)
						|| "short".equals(text) || "char".equals(text)) {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							DatatypeHighlightingConfiguration.DEFAULT_ID);
				}
			}
		}

	}
}

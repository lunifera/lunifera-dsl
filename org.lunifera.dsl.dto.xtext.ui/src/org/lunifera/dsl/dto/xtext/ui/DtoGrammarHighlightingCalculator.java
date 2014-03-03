package org.lunifera.dsl.dto.xtext.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.lunifera.dsl.dto.xtext.ui.DtoHighlightingConfiguration;
import org.lunifera.dsl.semantic.dto.LDtoFeature;
import org.lunifera.dsl.semantic.dto.LDtoMapper;

public class DtoGrammarHighlightingCalculator implements
		ISemanticHighlightingCalculator {

	@Override
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

				if (semanticElement instanceof LDtoFeature) {
					if ("id".equals(text) || "transient".equals(text)
							|| "version".equals(text)) {
						if (node.getNextSibling() == null) {
							if (!"transient".equals(text)) {
								acceptor.addPosition(node.getOffset(),
										node.getLength(),
										DtoHighlightingConfiguration.DEFAULT_ID);
							}
						} else {
							acceptor.addPosition(node.getOffset(),
									node.getLength(),
									DtoHighlightingConfiguration.MODIFIER_ID);
						}
					}
				} else if (semanticElement instanceof LDtoMapper) {
					if ("toDTO".equals(text) || "fromDTO".equals(text)) {
						acceptor.addPosition(node.getOffset(), node.getLength(),
								DtoHighlightingConfiguration.MODIFIER_ID);
					}
				}
			}
		}
	}



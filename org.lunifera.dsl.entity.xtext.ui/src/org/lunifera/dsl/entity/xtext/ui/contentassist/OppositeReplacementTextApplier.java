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
package org.lunifera.dsl.entity.xtext.ui.contentassist;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ReplacementTextApplier;

public class OppositeReplacementTextApplier extends ReplacementTextApplier {
	// protected LProperty refProp;

	protected ITextViewer viewer;

	protected IScope scope;

	protected IQualifiedNameConverter qualifiedNameConverter;

	protected IValueConverter<String> qualifiedNameValueConverter;

	// public OppositeReplacementTextApplier(LProperty refProp,
	// ITextViewer viewer, IScope scope,
	// IQualifiedNameConverter qualifiedNameConverter,
	// IValueConverter<String> qualifiedNameValueConverter) {
	// this.refProp = refProp;
	// this.viewer = viewer;
	// this.scope = scope;
	// this.qualifiedNameConverter = qualifiedNameConverter;
	// this.qualifiedNameValueConverter = qualifiedNameValueConverter;
	// }
	//
	// @Override
	// public void apply(IDocument document,
	// ConfigurableCompletionProposal proposal)
	// throws BadLocationException {
	// String replacementString = getActualReplacementString(proposal);
	// proposal.setCursorPosition(replacementString.length());
	// int replacementOffset = proposal.getReplacementOffset();
	//
	// // IEObjectDescription oppositeDescription = scope
	// // .getSingleElement(qualifiedNameConverter
	// // .toQualifiedName(qualifiedNameValueConverter.toValue(
	// // replacementString, null)));
	// // EObject opposite = oppositeDescription.getEObjectOrProxy();
	// document.replace(replacementOffset, proposal.getReplacementLength(),
	// replacementString);
	// }

	@Override
	public String getActualReplacementString(
			ConfigurableCompletionProposal proposal) {
		return proposal.getReplacementString();
	}
}

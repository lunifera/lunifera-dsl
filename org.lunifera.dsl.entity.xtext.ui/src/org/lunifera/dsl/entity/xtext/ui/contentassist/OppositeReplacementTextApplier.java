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
package org.lunifera.dsl.entity.xtext.ui.contentassist;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ReplacementTextApplier;

public class OppositeReplacementTextApplier extends ReplacementTextApplier {
	

	private ITextViewer viewer;

	private IScope scope;

	private IQualifiedNameConverter qualifiedNameConverter;

	private IValueConverter<String> qualifiedNameValueConverter;

	

	@Override
	public String getActualReplacementString(
			ConfigurableCompletionProposal proposal) {
		return proposal.getReplacementString();
	}
}

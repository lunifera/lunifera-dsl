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

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.lunifera.dsl.entity.xtext.services.EntityGrammarGrammarAccess;

import com.google.inject.Inject;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
@SuppressWarnings("restriction")
public class EntityGrammarProposalProvider extends
		AbstractEntityGrammarProposalProvider {
	@Inject
	private IScopeProvider entityScopeProvider;
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private QualifiedNameValueConverter qualifiedNameValueConverter;
	@Inject
	private EntityGrammarGrammarAccess xcoreGrammarAccess;
	@Inject
	private JdtVariableCompletions completions;

	protected boolean isKeywordWorthyToPropose(Keyword keyword) {
		return true;
	}

	// @Override
	// public void completeEntityMember_Opposite(EObject model,
	// Assignment assignment, ContentAssistContext context,
	// ICompletionProposalAcceptor acceptor) {
	// if (model instanceof LContains) {
	// final IReplacementTextApplier textApplier = new
	// OppositeReplacementTextApplier(
	// (LContains) model, context.getViewer(),
	// entityScopeProvider.getScope(model,
	// EntitymodelPackage.Literals.LCONTAINS__OPPOSITE),
	// qualifiedNameConverter, qualifiedNameValueConverter);
	// ICompletionProposalAcceptor oppositeAware = new
	// ICompletionProposalAcceptor.Delegate(
	// acceptor) {
	// @Override
	// public void accept(ICompletionProposal proposal) {
	// if (proposal instanceof ConfigurableCompletionProposal
	// && textApplier != null) {
	// ((ConfigurableCompletionProposal) proposal)
	// .setTextApplier(textApplier);
	// }
	// super.accept(proposal);
	// }
	// };
	// super.completeEntityMember_Opposite(model, assignment, context,
	// oppositeAware);
	// } else if (model instanceof LContainer) {
	// IScope scope = entityScopeProvider.getScope(model,
	// EntitymodelPackage.Literals.LCONTAINER__OPPOSITE);
	//
	// final IReplacementTextApplier textApplier = new
	// OppositeReplacementTextApplier(
	// (LContainer) model, context.getViewer(), scope,
	// qualifiedNameConverter, qualifiedNameValueConverter);
	// ICompletionProposalAcceptor oppositeAware = new
	// ICompletionProposalAcceptor.Delegate(
	// acceptor) {
	// @Override
	// public void accept(ICompletionProposal proposal) {
	// if (proposal instanceof ConfigurableCompletionProposal
	// && textApplier != null) {
	// ((ConfigurableCompletionProposal) proposal)
	// .setTextApplier(textApplier);
	// }
	// super.accept(proposal);
	// }
	// };
	// super.completeEntityMember_Opposite(model, assignment, context,
	// oppositeAware);
	// } else if (model instanceof LRefers) {
	// IScope scope = entityScopeProvider.getScope(model,
	// EntitymodelPackage.Literals.LREFERS__OPPOSITE);
	// final IReplacementTextApplier textApplier = new
	// OppositeReplacementTextApplier(
	// (LRefers) model, context.getViewer(), scope,
	// qualifiedNameConverter, qualifiedNameValueConverter);
	// ICompletionProposalAcceptor oppositeAware = new
	// ICompletionProposalAcceptor.Delegate(
	// acceptor) {
	// @Override
	// public void accept(ICompletionProposal proposal) {
	// if (proposal instanceof ConfigurableCompletionProposal
	// && textApplier != null) {
	// ((ConfigurableCompletionProposal) proposal)
	// .setTextApplier(textApplier);
	// }
	// super.accept(proposal);
	// }
	// };
	// super.completeEntityMember_Opposite(model, assignment, context,
	// oppositeAware);
	// }
	// }
	//
}
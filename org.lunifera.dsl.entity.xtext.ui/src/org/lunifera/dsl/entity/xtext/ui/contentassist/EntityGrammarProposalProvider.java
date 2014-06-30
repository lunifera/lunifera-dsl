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
	private EntityGrammarGrammarAccess xcoreGrammarAccess;
	

	protected boolean isKeywordWorthyToPropose(Keyword keyword) {
		return true;
	}

	
}
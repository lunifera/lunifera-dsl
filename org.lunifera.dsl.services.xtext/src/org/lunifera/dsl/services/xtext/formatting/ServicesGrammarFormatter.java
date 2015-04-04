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
package org.lunifera.dsl.services.xtext.formatting;

import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.lunifera.dsl.common.xtext.formatting.CommonGrammarFormatter;
import org.lunifera.dsl.services.xtext.services.ServicesGrammarGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
public class ServicesGrammarFormatter extends CommonGrammarFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		configure(c, (ServicesGrammarGrammarAccess) getGrammarAccess());
	}

	public void configure(FormattingConfig c, ServicesGrammarGrammarAccess ga) {
		ServicesGrammarGrammarAccess f = (ServicesGrammarGrammarAccess) getGrammarAccess();

		super.configure(c, ga.getCommonGrammarGrammarAccess());
	}

}

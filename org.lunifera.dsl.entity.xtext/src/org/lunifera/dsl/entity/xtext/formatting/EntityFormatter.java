/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Sources generated by Xtext.
 * 
 * IP: Used sourcecode from org.eclipse.emf.ecore.xcore.formatting.XcoreFormatting
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.xbase.formatting.XbaseFormatter;
import org.lunifera.dsl.entity.xtext.services.EntityGrammarGrammarAccess;

import com.google.inject.Inject;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
@SuppressWarnings({ "restriction", "deprecation" })
public class EntityFormatter extends AbstractDeclarativeFormatter {

	@Inject
	private XbaseFormatter xbaseFormatter;
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		configure(c, (EntityGrammarGrammarAccess) getGrammarAccess());
	}

	public void configure(FormattingConfig c, EntityGrammarGrammarAccess ga) {
		xbaseFormatter.configure(c, ga.getXbaseWithAnnotationsGrammarAccess()
				.getXbaseGrammarAccess());

		EntityGrammarGrammarAccess f = (EntityGrammarGrammarAccess) getGrammarAccess();

		c.setAutoLinewrap(120);

		configureLPackage(c, f.getLPackageAccess());
		configureLAnnotationDef(c, f.getLAnnotationDefAccess());
		configureLEntityPropElement(c, f.getLEntityPropAccess());

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).after(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(1, 1, 1).after(f.getML_COMMENTRule());
	}

	public void configureLPackage(FormattingConfig config,
			EntityGrammarGrammarAccess.LPackageElements ele) {

		// linewrap
		config.setLinewrap(1, 1, 2).around(ele.getRule());
		config.setLinewrap(1, 1, 2).after(ele.getLeftCurlyBracketKeyword_3_0());
		config.setLinewrap().around(ele.getImportsAssignment_3_1());
		config.setLinewrap(1, 1, 2).around(ele.getTypesAssignment_3_2());
		config.setLinewrap(1).before(ele.getRightCurlyBracketKeyword_3_3());

		// indentation
		config.setIndentationIncrement().after(
				ele.getLeftCurlyBracketKeyword_3_0());
		config.setIndentationDecrement().before(
				ele.getRightCurlyBracketKeyword_3_3());
	}

	public void configureLEntityPropElement(FormattingConfig config,
			EntityGrammarGrammarAccess.LEntityPropElements elements) {
		config.setLinewrap().around(elements.getRule());
		// ###
		// config.setLinewrap().around(elements.getAnnotationsAssignment_1());
		config.setLinewrap(1).around(elements.getRule());
	}

	protected void configureLAnnotationDef(FormattingConfig c,
			EntityGrammarGrammarAccess.LAnnotationDefElements ele) {
		c.setLinewrap(1).after(ele.getRule());
	}
}

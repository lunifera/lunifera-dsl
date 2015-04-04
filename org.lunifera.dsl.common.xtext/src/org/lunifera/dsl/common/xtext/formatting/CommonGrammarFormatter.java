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
package org.lunifera.dsl.common.xtext.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.xbase.formatting.XbaseFormatter;
import org.lunifera.dsl.common.xtext.services.CommonGrammarGrammarAccess;

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
@SuppressWarnings({ "deprecation", "restriction" })
public class CommonGrammarFormatter extends AbstractDeclarativeFormatter {

	@Inject
	private XbaseFormatter xbaseFormatter;

	@Override
	protected void configureFormatting(FormattingConfig c) {
		configure(c, (CommonGrammarGrammarAccess) getGrammarAccess());
	}

	public void configure(FormattingConfig c, CommonGrammarGrammarAccess ga) {
		xbaseFormatter.configure(c, ga.getXbaseWithAnnotationsGrammarAccess()
				.getXbaseGrammarAccess());

		CommonGrammarGrammarAccess f = (CommonGrammarGrammarAccess) ga;
		c.setAutoLinewrap(120);

		configurePackageDef(c, f.getTypedPackageAccess());
		configureImportDef(c, f.getImportAccess());
		configureDataTypeDef(c, f.getDataTypeAccess());
		configureAnnotationDef(c, f.getAnnotationDefAccess());
		configureConstraints(c, f.getConstraintsAccess());
		configureAttributeMatchingConstraint(c,
				f.getAttributeMatchingConstraintAccess());

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).after(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(1, 1, 1).after(f.getML_COMMENTRule());

		for (Keyword kw : ga.findKeywords("@")) {
			c.setNoSpace().after(kw);
		}
		for (Keyword kw : ga.findKeywords("(")) {
			c.setNoSpace().after(kw);
		}
		for (Keyword kw : ga.findKeywords("(")) {
			c.setNoSpace().before(kw);
		}
		for (Keyword kw : ga.findKeywords(")")) {
			c.setNoSpace().before(kw);
		}
		for (Keyword kw : ga.findKeywords(";")) {
			c.setNoSpace().before(kw);
		}
		for (Keyword kw : ga.findKeywords(",")) {
			c.setNoSpace().before(kw);
		}
	}

	protected void configurePackageDef(FormattingConfig c,
			CommonGrammarGrammarAccess.TypedPackageElements ele) {

		// Zeilenumbruch
		c.setLinewrap(1, 1, 2).around(ele.getRule());
		c.setLinewrap(1, 1, 2).after(ele.getLeftCurlyBracketKeyword_3_0());
		c.setLinewrap().around(ele.getImportsAssignment_3_1());
		c.setLinewrap(1, 1, 2).around(ele.getTypesAssignment_3_2());
		c.setLinewrap(1).before(ele.getRightCurlyBracketKeyword_3_3());
		// Einzug
		c.setIndentationIncrement().after(ele.getLeftCurlyBracketKeyword_3_0());
		c.setIndentationDecrement().before(
				ele.getRightCurlyBracketKeyword_3_3());
	}

	protected void configureImportDef(FormattingConfig c,
			CommonGrammarGrammarAccess.ImportElements ele) {
		c.setLinewrap().before(ele.getRule());

	}

	protected void configureDataTypeDef(FormattingConfig c,
			CommonGrammarGrammarAccess.DataTypeElements ele) {
		c.setLinewrap().before(ele.getRule());
	}

	protected void configureAnnotationDef(FormattingConfig c,
			CommonGrammarGrammarAccess.AnnotationDefElements ele) {
		c.setLinewrap().around(ele.getRule());
	}

	protected void configureConstraints(FormattingConfig c,
			CommonGrammarGrammarAccess.ConstraintsElements ele) {

		c.setLinewrap().after(ele.getLeftCurlyBracketKeyword_2());
		c.setLinewrap().before(ele.getRightCurlyBracketKeyword_4());
		c.setIndentationIncrement().after(ele.getLeftCurlyBracketKeyword_2());
		c.setIndentationDecrement().before(ele.getRightCurlyBracketKeyword_4());
	}

	protected void configureAttributeMatchingConstraint(FormattingConfig c,
			CommonGrammarGrammarAccess.AttributeMatchingConstraintElements ele) {
		c.setLinewrap().after(ele.getSemicolonKeyword_3());
	}
}

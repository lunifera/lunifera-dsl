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
package org.lunifera.dsl.entity.xtext.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.lunifera.dsl.common.xtext.formatting.CommonGrammarFormatter;
import org.lunifera.dsl.common.xtext.services.CommonGrammarGrammarAccess;
import org.lunifera.dsl.entity.xtext.services.EntityGrammarGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
public class EntityGrammarFormatter extends CommonGrammarFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		configure(c, (EntityGrammarGrammarAccess) getGrammarAccess());
	}

	// TODO formatting for index

	public void configure(FormattingConfig c, EntityGrammarGrammarAccess ga) {
		EntityGrammarGrammarAccess f = (EntityGrammarGrammarAccess) getGrammarAccess();

		super.configure(c, ga.getCommonGrammarGrammarAccess());

		configureClassDef(c, f.getClassAccess());
		configureEntityDef(c, f.getEntityFeatureAccess());
		configureBeanDef(c, f.getBeanFeatureAccess());
		configureMultiplicityDef(c, f.getMultiplicityAccess());
		configureEnumDef(c, f.getEnumAccess());
		configureEnumLiteralDef(c, f.getEnumLiteralAccess());

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

	protected void configureClassDef(FormattingConfig c,
			EntityGrammarGrammarAccess.ClassElements ele) {

		// entity
		c.setIndentationIncrement().after(
				ele.getLeftCurlyBracketKeyword_2_0_5());
		c.setIndentationDecrement().before(
				ele.getRightCurlyBracketKeyword_2_0_10());
		c.setLinewrap(2).after(ele.getRightCurlyBracketKeyword_2_0_10());

		// bean
		c.setIndentationIncrement().after(
				ele.getLeftCurlyBracketKeyword_2_1_4());
		c.setIndentationIncrement().after(
				ele.getLeftCurlyBracketKeyword_2_1_11());
		c.setIndentationDecrement().before(
				ele.getRightCurlyBracketKeyword_2_1_13());
		c.setIndentationDecrement().before(
				ele.getRightCurlyBracketKeyword_2_1_13());
		c.setLinewrap(2).after(ele.getRightCurlyBracketKeyword_2_1_13());
	}

	protected void configureEntityDef(FormattingConfig c,
			EntityGrammarGrammarAccess.EntityFeatureElements ele) {
		c.setLinewrap(1, 1, 2).around(ele.getRule());
	}

	protected void configureBeanDef(FormattingConfig c,
			EntityGrammarGrammarAccess.BeanFeatureElements ele) {
		c.setLinewrap(1, 1, 2).around(ele.getRule());
	}

	protected void configureMultiplicityDef(FormattingConfig c,
			CommonGrammarGrammarAccess.MultiplicityElements ele) {
		c.setNoSpace().after(ele.getLeftSquareBracketKeyword_0());
		c.setNoSpace().before(ele.getRightSquareBracketKeyword_3());
	}

	protected void configureEnumDef(FormattingConfig c,
			CommonGrammarGrammarAccess.EnumElements ele) {

		c.setLinewrap(2).before(ele.getEnumKeyword_0());
		c.setLinewrap().after(ele.getLeftCurlyBracketKeyword_2_0());
		c.setLinewrap().before(ele.getRightCurlyBracketKeyword_2_2());
		c.setNoSpace().before(ele.getCommaKeyword_2_1_1_0());
		c.setSpace(null).after(ele.getCommaKeyword_2_1_1_0());

		// Einzug for Enum
		c.setIndentationIncrement().after(ele.getLeftCurlyBracketKeyword_2_0());
		c.setIndentationDecrement().before(
				ele.getRightCurlyBracketKeyword_2_2());
	}

	protected void configureEnumLiteralDef(FormattingConfig c,
			CommonGrammarGrammarAccess.EnumLiteralElements ele) {
		
	}

}

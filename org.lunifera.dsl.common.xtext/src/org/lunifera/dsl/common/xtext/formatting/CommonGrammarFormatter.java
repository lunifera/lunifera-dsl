/*
 * generated by Xtext
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
public class CommonGrammarFormatter extends AbstractDeclarativeFormatter {

	@Inject
	private XbaseFormatter xbaseFormatter;

	@Override
	protected void configureFormatting(FormattingConfig c) {
		configure(c, (CommonGrammarGrammarAccess) getGrammarAccess());
	}

	@SuppressWarnings("restriction")
	public void configure(FormattingConfig c, CommonGrammarGrammarAccess ga) {
		xbaseFormatter.configure(c, ga.getXbaseWithAnnotationsGrammarAccess()
				.getXbaseGrammarAccess());

		CommonGrammarGrammarAccess f = (CommonGrammarGrammarAccess) getGrammarAccess();
		c.setAutoLinewrap(120);

		configureTypedPackage(c, f.getTypedPackageAccess());
		configureAnnotationDef(c, f.getAnnotationDefAccess());
		configureDataTypeDef(c, f.getDataTypeAccess());
		configureClassDef(c, f.getClassAccess());
		configureMultiplicityDef(c, f.getMultiplicityAccess());
		configureEnumDef(c, f.getEnumAccess());
		configureEnumLiteralDef(c, f.getEnumLiteralAccess());

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).after(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(1, 1, 1).after(f.getML_COMMENTRule());

		for (Keyword kw : ga.findKeywords(";")) {
			c.setNoSpace().before(kw);
		}
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

	}

	protected void configureTypedPackage(FormattingConfig c,
			CommonGrammarGrammarAccess.TypedPackageElements ele) {

		// linewrap
		c.setLinewrap(1, 1, 2).around(ele.getRule());
		c.setLinewrap(1, 1, 2).after(ele.getLeftCurlyBracketKeyword_3_0());
		c.setLinewrap().around(ele.getImportsAssignment_3_1());
		c.setLinewrap(1, 1, 2).around(ele.getTypesAssignment_3_2());
		c.setLinewrap(1).before(ele.getRightCurlyBracketKeyword_3_3());
		// indentation
		c.setIndentationIncrement().after(ele.getLeftCurlyBracketKeyword_3_0());
		c.setIndentationDecrement().before(
				ele.getRightCurlyBracketKeyword_3_3());
	}

	protected void configureAnnotationDef(FormattingConfig c,
			CommonGrammarGrammarAccess.AnnotationDefElements ele) {
		c.setLinewrap().around(ele.getRule());
	}

	protected void configureDataTypeDef(FormattingConfig c,
			CommonGrammarGrammarAccess.DataTypeElements ele) {
		c.setLinewrap(1).before(ele.getRule());
	}

	protected void configureClassDef(FormattingConfig c,
			CommonGrammarGrammarAccess.ClassElements ele) {
		c.setLinewrap().around(ele.getAnnotationsAssignment_1());
		c.setLinewrap(1).around(ele.getRule());
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

		// indentation for Enum
		c.setIndentationIncrement().after(ele.getLeftCurlyBracketKeyword_2_0());
		c.setIndentationDecrement().before(
				ele.getRightCurlyBracketKeyword_2_2());
	}

	protected void configureEnumLiteralDef(FormattingConfig c,
			CommonGrammarGrammarAccess.EnumLiteralElements ele) {
		// c.setLinewrap().around(ele.getRule());
		// c.setLinewrap(1).after(ele.getRule());

	}
}

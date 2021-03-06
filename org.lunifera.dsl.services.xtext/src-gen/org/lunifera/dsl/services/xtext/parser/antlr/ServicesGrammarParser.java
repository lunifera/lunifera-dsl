/*
* generated by Xtext
*/
package org.lunifera.dsl.services.xtext.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.lunifera.dsl.services.xtext.services.ServicesGrammarGrammarAccess;

public class ServicesGrammarParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private ServicesGrammarGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.lunifera.dsl.services.xtext.parser.antlr.internal.InternalServicesGrammarParser createParser(XtextTokenStream stream) {
		return new org.lunifera.dsl.services.xtext.parser.antlr.internal.InternalServicesGrammarParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "LServiceModel";
	}
	
	public ServicesGrammarGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ServicesGrammarGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}

package org.lunifera.dsl.services.xtext.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.lunifera.dsl.services.xtext.services.ServicesGrammarGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractServicesGrammarSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ServicesGrammarGrammarAccess grammarAccess;
	protected AbstractElementAlias match_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__a;
	protected AbstractElementAlias match_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__p;
	protected AbstractElementAlias match_EnumLiteral___LeftParenthesisKeyword_1_0_0_or_RightParenthesisKeyword_1_1_1__a;
	protected AbstractElementAlias match_EnumLiteral___RightParenthesisKeyword_1_1_1_LeftParenthesisKeyword_1_0_0_a__p;
	protected AbstractElementAlias match_EnumLiteral___RightParenthesisKeyword_1_1_1_a_LeftParenthesisKeyword_1_0_0__p;
	protected AbstractElementAlias match_EnumLiteral___RightParenthesisKeyword_1_1_1_p_LeftParenthesisKeyword_1_0_0_p__p;
	protected AbstractElementAlias match_TypedPackage___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q;
	protected AbstractElementAlias match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q;
	protected AbstractElementAlias match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_XExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XImportDeclaration_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ServicesGrammarGrammarAccess) access;
		match_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__a = new GroupAlias(true, true, new TokenAlias(true, true, grammarAccess.getEnumLiteralAccess().getLeftParenthesisKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getEnumLiteralAccess().getRightParenthesisKeyword_1_1_1()));
		match_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__p = new GroupAlias(true, false, new TokenAlias(true, true, grammarAccess.getEnumLiteralAccess().getLeftParenthesisKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getEnumLiteralAccess().getRightParenthesisKeyword_1_1_1()));
		match_EnumLiteral___LeftParenthesisKeyword_1_0_0_or_RightParenthesisKeyword_1_1_1__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getEnumLiteralAccess().getLeftParenthesisKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getEnumLiteralAccess().getRightParenthesisKeyword_1_1_1()));
		match_EnumLiteral___RightParenthesisKeyword_1_1_1_LeftParenthesisKeyword_1_0_0_a__p = new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getEnumLiteralAccess().getRightParenthesisKeyword_1_1_1()), new TokenAlias(true, true, grammarAccess.getEnumLiteralAccess().getLeftParenthesisKeyword_1_0_0()));
		match_EnumLiteral___RightParenthesisKeyword_1_1_1_a_LeftParenthesisKeyword_1_0_0__p = new GroupAlias(true, false, new TokenAlias(true, true, grammarAccess.getEnumLiteralAccess().getRightParenthesisKeyword_1_1_1()), new TokenAlias(false, false, grammarAccess.getEnumLiteralAccess().getLeftParenthesisKeyword_1_0_0()));
		match_EnumLiteral___RightParenthesisKeyword_1_1_1_p_LeftParenthesisKeyword_1_0_0_p__p = new GroupAlias(true, false, new TokenAlias(true, false, grammarAccess.getEnumLiteralAccess().getRightParenthesisKeyword_1_1_1()), new TokenAlias(true, false, grammarAccess.getEnumLiteralAccess().getLeftParenthesisKeyword_1_0_0()));
		match_TypedPackage___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTypedPackageAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getTypedPackageAccess().getRightCurlyBracketKeyword_3_3()));
		match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2()));
		match_XBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XImportDeclaration_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getArrayBracketsRule())
			return getArrayBracketsToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * ArrayBrackets :
	 * 	'[' ']'
	 * ;
	 */
	protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	/**
	 * OpSingleAssign:
	 * 	'='
	 * ;
	 */
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__a.equals(syntax))
				emit_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__p.equals(syntax))
				emit_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EnumLiteral___LeftParenthesisKeyword_1_0_0_or_RightParenthesisKeyword_1_1_1__a.equals(syntax))
				emit_EnumLiteral___LeftParenthesisKeyword_1_0_0_or_RightParenthesisKeyword_1_1_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EnumLiteral___RightParenthesisKeyword_1_1_1_LeftParenthesisKeyword_1_0_0_a__p.equals(syntax))
				emit_EnumLiteral___RightParenthesisKeyword_1_1_1_LeftParenthesisKeyword_1_0_0_a__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EnumLiteral___RightParenthesisKeyword_1_1_1_a_LeftParenthesisKeyword_1_0_0__p.equals(syntax))
				emit_EnumLiteral___RightParenthesisKeyword_1_1_1_a_LeftParenthesisKeyword_1_0_0__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EnumLiteral___RightParenthesisKeyword_1_1_1_p_LeftParenthesisKeyword_1_0_0_p__p.equals(syntax))
				emit_EnumLiteral___RightParenthesisKeyword_1_1_1_p_LeftParenthesisKeyword_1_0_0_p__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypedPackage___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q.equals(syntax))
				emit_TypedPackage___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q.equals(syntax))
				emit_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(syntax))
				emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XImportDeclaration_SemicolonKeyword_2_q.equals(syntax))
				emit_XImportDeclaration_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('('* ')')*
	 */
	protected void emit_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('('* ')')+
	 */
	protected void emit_EnumLiteral___LeftParenthesisKeyword_1_0_0_a_RightParenthesisKeyword_1_1_1__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' | ')')*
	 */
	protected void emit_EnumLiteral___LeftParenthesisKeyword_1_0_0_or_RightParenthesisKeyword_1_1_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (')' '('*)+
	 */
	protected void emit_EnumLiteral___RightParenthesisKeyword_1_1_1_LeftParenthesisKeyword_1_0_0_a__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (')'* '(')+
	 */
	protected void emit_EnumLiteral___RightParenthesisKeyword_1_1_1_a_LeftParenthesisKeyword_1_0_0__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (')'+ '('+)+
	 */
	protected void emit_EnumLiteral___RightParenthesisKeyword_1_1_1_p_LeftParenthesisKeyword_1_0_0_p__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_TypedPackage___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XImportDeclaration_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}

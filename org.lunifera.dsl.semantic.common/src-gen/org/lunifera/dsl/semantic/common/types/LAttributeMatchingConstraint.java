/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
 * 
 *  Based on ideas from Xtext, Xtend, Xcore
 *   
 *  Contributors:  
 *  		Florian Pirchner - Initial implementation 
 *  
 */
package org.lunifera.dsl.semantic.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LAttribute Matching Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint#getComparatorType <em>Comparator Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint#getMatchingValue <em>Matching Value</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint#getMatchingLiteral <em>Matching Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttributeMatchingConstraint()
 * @model
 * @generated
 */
public interface LAttributeMatchingConstraint extends LConstraint {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(LAttribute)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttributeMatchingConstraint_Attribute()
	 * @model
	 * @generated
	 */
	LAttribute getAttribute();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(LAttribute value);

	/**
	 * Returns the value of the '<em><b>Comparator Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.lunifera.dsl.semantic.common.types.LComparatorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparator Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparator Type</em>' attribute.
	 * @see org.lunifera.dsl.semantic.common.types.LComparatorType
	 * @see #setComparatorType(LComparatorType)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttributeMatchingConstraint_ComparatorType()
	 * @model unique="false"
	 * @generated
	 */
	LComparatorType getComparatorType();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint#getComparatorType <em>Comparator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comparator Type</em>' attribute.
	 * @see org.lunifera.dsl.semantic.common.types.LComparatorType
	 * @see #getComparatorType()
	 * @generated
	 */
	void setComparatorType(LComparatorType value);

	/**
	 * Returns the value of the '<em><b>Matching Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matching Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matching Value</em>' attribute.
	 * @see #setMatchingValue(String)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttributeMatchingConstraint_MatchingValue()
	 * @model unique="false"
	 * @generated
	 */
	String getMatchingValue();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint#getMatchingValue <em>Matching Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matching Value</em>' attribute.
	 * @see #getMatchingValue()
	 * @generated
	 */
	void setMatchingValue(String value);

	/**
	 * Returns the value of the '<em><b>Matching Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matching Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matching Literal</em>' reference.
	 * @see #setMatchingLiteral(LEnumLiteral)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttributeMatchingConstraint_MatchingLiteral()
	 * @model
	 * @generated
	 */
	LEnumLiteral getMatchingLiteral();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint#getMatchingLiteral <em>Matching Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matching Literal</em>' reference.
	 * @see #getMatchingLiteral()
	 * @generated
	 */
	void setMatchingLiteral(LEnumLiteral value);

} // LAttributeMatchingConstraint

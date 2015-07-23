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
 * A representation of the model object '<em><b>LDt CDigits</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDtCDigits#getIntDigits <em>Int Digits</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDtCDigits#getFractionDigits <em>Fraction Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDtCDigits()
 * @model
 * @generated
 */
public interface LDtCDigits extends LDatatypeConstraint {
	/**
	 * Returns the value of the '<em><b>Int Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Int Digits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Int Digits</em>' attribute.
	 * @see #setIntDigits(int)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDtCDigits_IntDigits()
	 * @model unique="false"
	 * @generated
	 */
	int getIntDigits();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDtCDigits#getIntDigits <em>Int Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Int Digits</em>' attribute.
	 * @see #getIntDigits()
	 * @generated
	 */
	void setIntDigits(int value);

	/**
	 * Returns the value of the '<em><b>Fraction Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fraction Digits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fraction Digits</em>' attribute.
	 * @see #setFractionDigits(int)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDtCDigits_FractionDigits()
	 * @model unique="false"
	 * @generated
	 */
	int getFractionDigits();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDtCDigits#getFractionDigits <em>Fraction Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fraction Digits</em>' attribute.
	 * @see #getFractionDigits()
	 * @generated
	 */
	void setFractionDigits(int value);

} // LDtCDigits

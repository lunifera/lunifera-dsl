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
 * A representation of the model object '<em><b>LEnum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LEnumLiteral#getName <em>Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LEnumLiteral#isDefault <em>Default</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LEnumLiteral#isNull <em>Null</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLEnumLiteral()
 * @model
 * @generated
 */
public interface LEnumLiteral extends LLazyResolver {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLEnumLiteral_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LEnumLiteral#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLEnumLiteral_Default()
	 * @model unique="false"
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LEnumLiteral#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Null</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Null</em>' attribute.
	 * @see #setNull(boolean)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLEnumLiteral_Null()
	 * @model unique="false"
	 * @generated
	 */
	boolean isNull();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LEnumLiteral#isNull <em>Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null</em>' attribute.
	 * @see #isNull()
	 * @generated
	 */
	void setNull(boolean value);

} // LEnumLiteral

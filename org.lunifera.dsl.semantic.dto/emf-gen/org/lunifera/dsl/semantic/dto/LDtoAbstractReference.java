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
package org.lunifera.dsl.semantic.dto;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.lunifera.dsl.semantic.common.types.LReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDto Abstract Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDtoAbstractReference#getType <em>Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDtoAbstractReference#getTypeJvm <em>Type Jvm</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoAbstractReference()
 * @model abstract="true"
 * @generated
 */
public interface LDtoAbstractReference extends LDtoFeature, LReference {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(LDto)
	 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoAbstractReference_Type()
	 * @model
	 * @generated
	 */
	LDto getType();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDtoAbstractReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(LDto value);

	/**
	 * Returns the value of the '<em><b>Type Jvm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Jvm</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Jvm</em>' containment reference.
	 * @see #setTypeJvm(JvmTypeReference)
	 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoAbstractReference_TypeJvm()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	JvmTypeReference getTypeJvm();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDtoAbstractReference#getTypeJvm <em>Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Jvm</em>' containment reference.
	 * @see #getTypeJvm()
	 * @generated
	 */
	void setTypeJvm(JvmTypeReference value);

} // LDtoAbstractReference

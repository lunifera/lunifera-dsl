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
package org.lunifera.dsl.semantic.entity;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.lunifera.dsl.semantic.common.types.LConstraints;
import org.lunifera.dsl.semantic.common.types.LReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LEntity Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityReference#getType <em>Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityReference#getTypeJvm <em>Type Jvm</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityReference#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityReference#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntityReference()
 * @model
 * @generated
 */
public interface LEntityReference extends LEntityFeature, LReference {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(LEntity)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntityReference_Type()
	 * @model
	 * @generated
	 */
	LEntity getType();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(LEntity value);

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
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntityReference_TypeJvm()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	JvmTypeReference getTypeJvm();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityReference#getTypeJvm <em>Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Jvm</em>' containment reference.
	 * @see #getTypeJvm()
	 * @generated
	 */
	void setTypeJvm(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(LEntityReference)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntityReference_Opposite()
	 * @model
	 * @generated
	 */
	LEntityReference getOpposite();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityReference#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(LEntityReference value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference.
	 * @see #setConstraints(LConstraints)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntityReference_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	LConstraints getConstraints();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityReference#getConstraints <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' containment reference.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(LConstraints value);

} // LEntityReference

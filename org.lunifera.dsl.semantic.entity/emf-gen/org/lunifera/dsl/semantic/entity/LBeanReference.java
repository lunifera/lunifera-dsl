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

import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LReference;
import org.lunifera.dsl.semantic.common.types.LResultFilters;
import org.lunifera.dsl.semantic.common.types.LType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LBean Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBeanReference#getType <em>Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBeanReference#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBeanReference#getTypeJvm <em>Type Jvm</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBeanReference#getResultFilters <em>Result Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanReference()
 * @model
 * @generated
 */
public interface LBeanReference extends LBeanFeature, LReference {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(LType)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanReference_Type()
	 * @model
	 * @generated
	 */
	LType getType();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(LType value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(LFeature)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanReference_Opposite()
	 * @model
	 * @generated
	 */
	LFeature getOpposite();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(LFeature value);

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
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanReference_TypeJvm()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	JvmTypeReference getTypeJvm();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getTypeJvm <em>Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Jvm</em>' containment reference.
	 * @see #getTypeJvm()
	 * @generated
	 */
	void setTypeJvm(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Result Filters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Filters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Filters</em>' containment reference.
	 * @see #setResultFilters(LResultFilters)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanReference_ResultFilters()
	 * @model containment="true"
	 * @generated
	 */
	LResultFilters getResultFilters();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getResultFilters <em>Result Filters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Filters</em>' containment reference.
	 * @see #getResultFilters()
	 * @generated
	 */
	void setResultFilters(LResultFilters value);

} // LBeanReference

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

import org.lunifera.dsl.semantic.common.types.LReference;

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
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanReference()
 * @model
 * @generated
 */
public interface LBeanReference extends LBeanFeature, LReference {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(LBeanTypeReference)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanReference_Type()
	 * @model containment="true"
	 * @generated
	 */
	LBeanTypeReference getType();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(LBeanTypeReference value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(LBeanReference)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanReference_Opposite()
	 * @model
	 * @generated
	 */
	LBeanReference getOpposite();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(LBeanReference value);

} // LBeanReference

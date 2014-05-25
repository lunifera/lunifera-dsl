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
package org.lunifera.dsl.semantic.service;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LInjected Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.LInjectedService#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LInjectedService#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LInjectedService#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLInjectedService()
 * @model
 * @generated
 */
public interface LInjectedService extends EObject
{
  /**
   * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
   * The literals are from the enumeration {@link org.lunifera.dsl.semantic.service.LCardinality}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cardinality</em>' attribute.
   * @see org.lunifera.dsl.semantic.service.LCardinality
   * @see #setCardinality(LCardinality)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLInjectedService_Cardinality()
   * @model unique="false"
   * @generated
   */
  LCardinality getCardinality();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LInjectedService#getCardinality <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cardinality</em>' attribute.
   * @see org.lunifera.dsl.semantic.service.LCardinality
   * @see #getCardinality()
   * @generated
   */
  void setCardinality(LCardinality value);

  /**
   * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Name</em>' attribute.
   * @see #setAttributeName(String)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLInjectedService_AttributeName()
   * @model unique="false"
   * @generated
   */
  String getAttributeName();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LInjectedService#getAttributeName <em>Attribute Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Name</em>' attribute.
   * @see #getAttributeName()
   * @generated
   */
  void setAttributeName(String value);

  /**
   * Returns the value of the '<em><b>Service</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service</em>' containment reference.
   * @see #setService(JvmTypeReference)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLInjectedService_Service()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getService();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LInjectedService#getService <em>Service</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Service</em>' containment reference.
   * @see #getService()
   * @generated
   */
  void setService(JvmTypeReference value);

} // LInjectedService

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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDto Mapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDtoMapper#getFromDto <em>From Dto</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDtoMapper#getToDto <em>To Dto</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDtoMapper()
 * @model
 * @generated
 */
public interface LDtoMapper extends EObject
{
  /**
   * Returns the value of the '<em><b>From Dto</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From Dto</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From Dto</em>' containment reference.
   * @see #setFromDto(XExpression)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDtoMapper_FromDto()
   * @model containment="true"
   * @generated
   */
  XExpression getFromDto();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDtoMapper#getFromDto <em>From Dto</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From Dto</em>' containment reference.
   * @see #getFromDto()
   * @generated
   */
  void setFromDto(XExpression value);

  /**
   * Returns the value of the '<em><b>To Dto</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Dto</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Dto</em>' containment reference.
   * @see #setToDto(XExpression)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDtoMapper_ToDto()
   * @model containment="true"
   * @generated
   */
  XExpression getToDto();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDtoMapper#getToDto <em>To Dto</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Dto</em>' containment reference.
   * @see #getToDto()
   * @generated
   */
  void setToDto(XExpression value);

} // LDtoMapper

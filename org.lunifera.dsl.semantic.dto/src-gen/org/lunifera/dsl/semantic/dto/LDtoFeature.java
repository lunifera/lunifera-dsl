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

import org.lunifera.dsl.semantic.common.types.LFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDto Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDtoFeature#getMapper <em>Mapper</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoFeature()
 * @model
 * @generated
 */
public interface LDtoFeature extends LFeature
{
  /**
   * Returns the value of the '<em><b>Mapper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mapper</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mapper</em>' containment reference.
   * @see #setMapper(LDtoMapper)
   * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoFeature_Mapper()
   * @model containment="true"
   * @generated
   */
  LDtoMapper getMapper();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDtoFeature#getMapper <em>Mapper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mapper</em>' containment reference.
   * @see #getMapper()
   * @generated
   */
  void setMapper(LDtoMapper value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.ecore.EObject%> _eContainer = this.eContainer();\nreturn ((<%org.lunifera.dsl.semantic.dto.LDto%>) _eContainer);'"
   * @generated
   */
  LDto getDTO();

} // LDtoFeature

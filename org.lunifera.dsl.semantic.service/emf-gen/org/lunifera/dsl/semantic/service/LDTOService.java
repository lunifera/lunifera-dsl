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

import org.lunifera.dsl.semantic.dto.LDto;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDTO Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getPrimaryDTO <em>Primary DTO</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getSupportedDTOs <em>Supported DT Os</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService()
 * @model
 * @generated
 */
public interface LDTOService extends LService
{
  /**
   * Returns the value of the '<em><b>Primary DTO</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary DTO</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary DTO</em>' reference.
   * @see #setPrimaryDTO(LDto)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_PrimaryDTO()
   * @model
   * @generated
   */
  LDto getPrimaryDTO();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getPrimaryDTO <em>Primary DTO</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary DTO</em>' reference.
   * @see #getPrimaryDTO()
   * @generated
   */
  void setPrimaryDTO(LDto value);

  /**
   * Returns the value of the '<em><b>Supported DT Os</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getService <em>Service</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supported DT Os</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supported DT Os</em>' containment reference.
   * @see #setSupportedDTOs(LSupportedDTOCollection)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_SupportedDTOs()
   * @see org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getService
   * @model opposite="service" containment="true"
   * @generated
   */
  LSupportedDTOCollection getSupportedDTOs();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getSupportedDTOs <em>Supported DT Os</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Supported DT Os</em>' containment reference.
   * @see #getSupportedDTOs()
   * @generated
   */
  void setSupportedDTOs(LSupportedDTOCollection value);

} // LDTOService

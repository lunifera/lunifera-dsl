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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LSupported DTO Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getService <em>Service</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getSupportedDtos <em>Supported Dtos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSupportedDTOCollection()
 * @model
 * @generated
 */
public interface LSupportedDTOCollection extends EObject
{
  /**
   * Returns the value of the '<em><b>Service</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.service.LDTOService#getSupportedDTOs <em>Supported DT Os</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service</em>' container reference.
   * @see #setService(LDTOService)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSupportedDTOCollection_Service()
   * @see org.lunifera.dsl.semantic.service.LDTOService#getSupportedDTOs
   * @model opposite="supportedDTOs" transient="false"
   * @generated
   */
  LDTOService getService();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getService <em>Service</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Service</em>' container reference.
   * @see #getService()
   * @generated
   */
  void setService(LDTOService value);

  /**
   * Returns the value of the '<em><b>Supported Dtos</b></em>' containment reference list.
   * The list contents are of type {@link org.lunifera.dsl.semantic.service.LSupportedDTO}.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supported Dtos</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supported Dtos</em>' containment reference list.
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSupportedDTOCollection_SupportedDtos()
   * @see org.lunifera.dsl.semantic.service.LSupportedDTO#getParent
   * @model opposite="parent" containment="true"
   * @generated
   */
  EList<LSupportedDTO> getSupportedDtos();

} // LSupportedDTOCollection

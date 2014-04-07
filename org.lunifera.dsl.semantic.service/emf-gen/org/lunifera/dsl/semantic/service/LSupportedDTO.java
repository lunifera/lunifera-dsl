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

import org.lunifera.dsl.semantic.dto.LDto;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LSupported DTO</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getParent <em>Parent</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getDto <em>Dto</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSupportedDTO()
 * @model
 * @generated
 */
public interface LSupportedDTO extends EObject
{
  /**
   * Returns the value of the '<em><b>Parent</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getSupportedDtos <em>Supported Dtos</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent</em>' container reference.
   * @see #setParent(LSupportedDTOCollection)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSupportedDTO_Parent()
   * @see org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getSupportedDtos
   * @model opposite="supportedDtos" transient="false"
   * @generated
   */
  LSupportedDTOCollection getParent();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getParent <em>Parent</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' container reference.
   * @see #getParent()
   * @generated
   */
  void setParent(LSupportedDTOCollection value);

  /**
   * Returns the value of the '<em><b>Dto</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dto</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dto</em>' reference.
   * @see #setDto(LDto)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSupportedDTO_Dto()
   * @model
   * @generated
   */
  LDto getDto();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getDto <em>Dto</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dto</em>' reference.
   * @see #getDto()
   * @generated
   */
  void setDto(LDto value);

  /**
   * Returns the value of the '<em><b>Filters</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.service.LSupportedFilters#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filters</em>' containment reference.
   * @see #setFilters(LSupportedFilters)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSupportedDTO_Filters()
   * @see org.lunifera.dsl.semantic.service.LSupportedFilters#getParent
   * @model opposite="parent" containment="true"
   * @generated
   */
  LSupportedFilters getFilters();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getFilters <em>Filters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filters</em>' containment reference.
   * @see #getFilters()
   * @generated
   */
  void setFilters(LSupportedFilters value);

} // LSupportedDTO

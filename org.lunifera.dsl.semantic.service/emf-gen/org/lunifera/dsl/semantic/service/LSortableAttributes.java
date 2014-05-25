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

import org.lunifera.dsl.semantic.dto.LDtoFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LSortable Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.LSortableAttributes#getParent <em>Parent</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LSortableAttributes#getSortableFeatures <em>Sortable Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSortableAttributes()
 * @model
 * @generated
 */
public interface LSortableAttributes extends EObject
{
  /**
   * Returns the value of the '<em><b>Parent</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.service.LDTOService#getSortable <em>Sortable</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent</em>' container reference.
   * @see #setParent(LDTOService)
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSortableAttributes_Parent()
   * @see org.lunifera.dsl.semantic.service.LDTOService#getSortable
   * @model opposite="sortable" transient="false"
   * @generated
   */
  LDTOService getParent();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LSortableAttributes#getParent <em>Parent</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' container reference.
   * @see #getParent()
   * @generated
   */
  void setParent(LDTOService value);

  /**
   * Returns the value of the '<em><b>Sortable Features</b></em>' reference list.
   * The list contents are of type {@link org.lunifera.dsl.semantic.dto.LDtoFeature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sortable Features</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sortable Features</em>' reference list.
   * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLSortableAttributes_SortableFeatures()
   * @model
   * @generated
   */
  EList<LDtoFeature> getSortableFeatures();

} // LSortableAttributes

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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.service.LunServicePackage
 * @generated
 */
public interface LunServiceFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LunServiceFactory eINSTANCE = org.lunifera.dsl.semantic.service.impl.LunServiceFactoryImpl.init();

  /**
   * Returns a new object of class '<em>LService Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LService Model</em>'.
   * @generated
   */
  LServiceModel createLServiceModel();

  /**
   * Returns a new object of class '<em>LInjected Services</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LInjected Services</em>'.
   * @generated
   */
  LInjectedServices createLInjectedServices();

  /**
   * Returns a new object of class '<em>LInjected Service</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LInjected Service</em>'.
   * @generated
   */
  LInjectedService createLInjectedService();

  /**
   * Returns a new object of class '<em>LDTO Service</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDTO Service</em>'.
   * @generated
   */
  LDTOService createLDTOService();

  /**
   * Returns a new object of class '<em>LFilterable Attributes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LFilterable Attributes</em>'.
   * @generated
   */
  LFilterableAttributes createLFilterableAttributes();

  /**
   * Returns a new object of class '<em>LSortable Attributes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LSortable Attributes</em>'.
   * @generated
   */
  LSortableAttributes createLSortableAttributes();

  /**
   * Returns a new object of class '<em>LChart Service</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LChart Service</em>'.
   * @generated
   */
  LChartService createLChartService();

  /**
   * Returns a new object of class '<em>LFree Service</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LFree Service</em>'.
   * @generated
   */
  LFreeService createLFreeService();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  LunServicePackage getLunServicePackage();

} //LunServiceFactory

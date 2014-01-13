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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage
 * @generated
 */
public interface LunTypesFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LunTypesFactory eINSTANCE = org.lunifera.dsl.semantic.common.types.impl.LunTypesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>LPackage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LPackage</em>'.
   * @generated
   */
  LPackage createLPackage();

  /**
   * Returns a new object of class '<em>LTyped Package</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LTyped Package</em>'.
   * @generated
   */
  LTypedPackage createLTypedPackage();

  /**
   * Returns a new object of class '<em>LImport</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LImport</em>'.
   * @generated
   */
  LImport createLImport();

  /**
   * Returns a new object of class '<em>LType</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LType</em>'.
   * @generated
   */
  LType createLType();

  /**
   * Returns a new object of class '<em>LAnnotation Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LAnnotation Def</em>'.
   * @generated
   */
  LAnnotationDef createLAnnotationDef();

  /**
   * Returns a new object of class '<em>LAnnotation Target</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LAnnotation Target</em>'.
   * @generated
   */
  LAnnotationTarget createLAnnotationTarget();

  /**
   * Returns a new object of class '<em>LScalar Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LScalar Type</em>'.
   * @generated
   */
  LScalarType createLScalarType();

  /**
   * Returns a new object of class '<em>LData Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LData Type</em>'.
   * @generated
   */
  LDataType createLDataType();

  /**
   * Returns a new object of class '<em>LEnum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LEnum</em>'.
   * @generated
   */
  LEnum createLEnum();

  /**
   * Returns a new object of class '<em>LEnum Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LEnum Literal</em>'.
   * @generated
   */
  LEnumLiteral createLEnumLiteral();

  /**
   * Returns a new object of class '<em>LClass</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LClass</em>'.
   * @generated
   */
  LClass createLClass();

  /**
   * Returns a new object of class '<em>LOperation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LOperation</em>'.
   * @generated
   */
  LOperation createLOperation();

  /**
   * Returns a new object of class '<em>LModifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LModifier</em>'.
   * @generated
   */
  LModifier createLModifier();

  /**
   * Returns a new object of class '<em>LMultiplicity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LMultiplicity</em>'.
   * @generated
   */
  LMultiplicity createLMultiplicity();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  LunTypesPackage getLunTypesPackage();

} //LunTypesFactory

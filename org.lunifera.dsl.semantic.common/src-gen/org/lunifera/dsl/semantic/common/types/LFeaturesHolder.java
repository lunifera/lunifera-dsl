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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LFeatures Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLFeaturesHolder()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LFeaturesHolder extends EObject
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns the features of the holder
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.common.types.FeaturesList" unique="false"
   * @generated
   */
  List<? extends LFeature> getFeatures();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all features of the holder and from super types
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.common.types.FeaturesList" unique="false"
   * @generated
   */
  List<? extends LFeature> getAllFeatures();

} // LFeaturesHolder

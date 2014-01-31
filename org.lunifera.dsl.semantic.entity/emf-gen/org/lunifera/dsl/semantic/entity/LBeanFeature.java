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
package org.lunifera.dsl.semantic.entity;

import org.lunifera.dsl.semantic.common.types.LFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LBean Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanFeature()
 * @model
 * @generated
 */
public interface LBeanFeature extends LFeature
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.ecore.EObject%> _eContainer = this.eContainer();\nreturn ((<%org.lunifera.dsl.semantic.entity.LBean%>) _eContainer);'"
   * @generated
   */
  LBean getBean();

} // LBeanFeature

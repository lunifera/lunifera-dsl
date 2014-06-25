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

import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LService</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.LService#getInjectedServices <em>Injected Services</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LService#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLService()
 * @model abstract="true"
 * @generated
 */
public interface LService extends LClass {
	/**
	 * Returns the value of the '<em><b>Injected Services</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Injected Services</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Injected Services</em>' containment reference.
	 * @see #setInjectedServices(LInjectedServices)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLService_InjectedServices()
	 * @model containment="true"
	 * @generated
	 */
	LInjectedServices getInjectedServices();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LService#getInjectedServices <em>Injected Services</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Injected Services</em>' containment reference.
	 * @see #getInjectedServices()
	 * @generated
	 */
	void setInjectedServices(LInjectedServices value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.semantic.common.types.LOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLService_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<LOperation> getOperations();

} // LService

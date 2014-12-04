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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.lunifera.dsl.semantic.common.types.LTypedPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDto Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDtoModel#getPackages <em>Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoModel()
 * @model
 * @generated
 */
public interface LDtoModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.semantic.common.types.LTypedPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoModel_Packages()
	 * @model containment="true"
	 * @generated
	 */
	EList<LTypedPackage> getPackages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" proxyDataType="org.lunifera.dsl.semantic.dto.InternalEObject" proxyUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.ecore.resource.Resource%> _eResource = this.eResource();\n<%org.eclipse.emf.ecore.resource.ResourceSet%> _resourceSet = _eResource.getResourceSet();\nreturn <%org.lunifera.dsl.xtext.lazyresolver.api.EcoreUtil3%>.resolve(proxy, _resourceSet);'"
	 * @generated
	 */
	EObject eResolveProxy(InternalEObject proxy);

} // LDtoModel

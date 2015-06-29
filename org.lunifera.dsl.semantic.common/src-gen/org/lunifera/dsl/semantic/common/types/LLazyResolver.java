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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LLazy Resolver</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLLazyResolver()
 * @model
 * @generated
 */
public interface LLazyResolver extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" proxyDataType="org.lunifera.dsl.semantic.common.types.InternalEObject" proxyUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.ecore.resource.Resource%> _eResource = this.eResource();\n<%org.eclipse.emf.ecore.resource.ResourceSet%> _resourceSet = null;\nif (_eResource!=null)\n{\n\t_resourceSet=_eResource.getResourceSet();\n}\nreturn <%org.lunifera.dsl.xtext.lazyresolver.api.EcoreUtil3%>.resolve(proxy, _resourceSet);'"
	 * @generated
	 */
	EObject eResolveProxy(InternalEObject proxy);

} // LLazyResolver

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
package org.lunifera.dsl.semantic.common.types.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.lunifera.dsl.semantic.common.types.LLazyResolver;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import org.lunifera.dsl.xtext.lazyresolver.api.EcoreUtil3;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LLazy Resolver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LLazyResolverImpl extends MinimalEObjectImpl.Container implements LLazyResolver {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LLazyResolverImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunTypesPackage.Literals.LLAZY_RESOLVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject eResolveProxy(final InternalEObject proxy) {
		Resource _eResource = this.eResource();
		ResourceSet _resourceSet = _eResource != null ? _eResource.getResourceSet() : null;
		return EcoreUtil3.resolve(proxy, _resourceSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LunTypesPackage.LLAZY_RESOLVER___ERESOLVE_PROXY__INTERNALEOBJECT:
				return eResolveProxy((InternalEObject)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //LLazyResolverImpl

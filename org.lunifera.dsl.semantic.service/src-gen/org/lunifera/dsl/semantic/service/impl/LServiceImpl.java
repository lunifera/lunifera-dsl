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
package org.lunifera.dsl.semantic.service.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.lunifera.dsl.semantic.common.types.impl.LClassImpl;

import org.lunifera.dsl.semantic.service.LInjectedServices;
import org.lunifera.dsl.semantic.service.LService;
import org.lunifera.dsl.semantic.service.LServiceOperation;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LService</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LServiceImpl#getInjectedServices <em>Injected Services</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LServiceImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LServiceImpl extends LClassImpl implements LService {
	/**
	 * The cached value of the '{@link #getInjectedServices() <em>Injected Services</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInjectedServices()
	 * @generated
	 * @ordered
	 */
	protected LInjectedServices injectedServices;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<LServiceOperation> operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunServicePackage.Literals.LSERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LInjectedServices getInjectedServices() {
		return injectedServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInjectedServices(LInjectedServices newInjectedServices, NotificationChain msgs) {
		LInjectedServices oldInjectedServices = injectedServices;
		injectedServices = newInjectedServices;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LSERVICE__INJECTED_SERVICES, oldInjectedServices, newInjectedServices);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInjectedServices(LInjectedServices newInjectedServices) {
		if (newInjectedServices != injectedServices) {
			NotificationChain msgs = null;
			if (injectedServices != null)
				msgs = ((InternalEObject)injectedServices).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LSERVICE__INJECTED_SERVICES, null, msgs);
			if (newInjectedServices != null)
				msgs = ((InternalEObject)newInjectedServices).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LSERVICE__INJECTED_SERVICES, null, msgs);
			msgs = basicSetInjectedServices(newInjectedServices, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LSERVICE__INJECTED_SERVICES, newInjectedServices, newInjectedServices));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LServiceOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<LServiceOperation>(LServiceOperation.class, this, LunServicePackage.LSERVICE__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunServicePackage.LSERVICE__INJECTED_SERVICES:
				return basicSetInjectedServices(null, msgs);
			case LunServicePackage.LSERVICE__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LunServicePackage.LSERVICE__INJECTED_SERVICES:
				return getInjectedServices();
			case LunServicePackage.LSERVICE__OPERATIONS:
				return getOperations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LunServicePackage.LSERVICE__INJECTED_SERVICES:
				setInjectedServices((LInjectedServices)newValue);
				return;
			case LunServicePackage.LSERVICE__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends LServiceOperation>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LunServicePackage.LSERVICE__INJECTED_SERVICES:
				setInjectedServices((LInjectedServices)null);
				return;
			case LunServicePackage.LSERVICE__OPERATIONS:
				getOperations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LunServicePackage.LSERVICE__INJECTED_SERVICES:
				return injectedServices != null;
			case LunServicePackage.LSERVICE__OPERATIONS:
				return operations != null && !operations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LServiceImpl

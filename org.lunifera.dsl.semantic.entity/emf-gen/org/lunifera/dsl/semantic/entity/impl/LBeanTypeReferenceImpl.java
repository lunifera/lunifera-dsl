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
package org.lunifera.dsl.semantic.entity.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.lunifera.dsl.lazyreferences.EcoreUtil3;

import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanTypeReference;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LBean Type Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanTypeReferenceImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LBeanTypeReferenceImpl extends MinimalEObjectImpl.Container implements LBeanTypeReference {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected LBean type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LBeanTypeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunEntityPackage.Literals.LBEAN_TYPE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LBean getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (LBean)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunEntityPackage.LBEAN_TYPE_REFERENCE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LBean basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(LBean newType) {
		LBean oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_TYPE_REFERENCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LBean getLazyResolved() {
		boolean _and = false;
		LBean _type = this.getType();
		boolean _notEquals = (!Objects.equal(_type, null));
		if (!_notEquals) {
			_and = false;
		} else {
			LBean _type_1 = this.getType();
			boolean _eIsProxy = _type_1.eIsProxy();
			_and = _eIsProxy;
		}
		if (_and) {
			LBean _type_2 = this.getType();
			final InternalEObject oldType = ((InternalEObject) _type_2);
			EObject _resolveLazy = EcoreUtil3.resolveLazy(oldType, this);
			this.setType(((LBean) _resolveLazy));
		}
		return this.getType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LunEntityPackage.LBEAN_TYPE_REFERENCE__TYPE:
				if (resolve) return getType();
				return basicGetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LunEntityPackage.LBEAN_TYPE_REFERENCE__TYPE:
				setType((LBean)newValue);
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
			case LunEntityPackage.LBEAN_TYPE_REFERENCE__TYPE:
				setType((LBean)null);
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
			case LunEntityPackage.LBEAN_TYPE_REFERENCE__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LunEntityPackage.LBEAN_TYPE_REFERENCE___GET_LAZY_RESOLVED:
				return getLazyResolved();
		}
		return super.eInvoke(operationID, arguments);
	}

} //LBeanTypeReferenceImpl

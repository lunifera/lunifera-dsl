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
package org.lunifera.dsl.semantic.dto.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

import org.lunifera.dsl.semantic.common.types.impl.LLazyResolverImpl;

import org.lunifera.dsl.semantic.dto.LDtoMapper;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDto Mapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoMapperImpl#getToDTO <em>To DTO</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoMapperImpl#getFromDTO <em>From DTO</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDtoMapperImpl extends LLazyResolverImpl implements LDtoMapper {
	/**
	 * The cached value of the '{@link #getToDTO() <em>To DTO</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToDTO()
	 * @generated
	 * @ordered
	 */
	protected XExpression toDTO;

	/**
	 * The cached value of the '{@link #getFromDTO() <em>From DTO</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromDTO()
	 * @generated
	 * @ordered
	 */
	protected XExpression fromDTO;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LDtoMapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunDtoPackage.Literals.LDTO_MAPPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getToDTO() {
		return toDTO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToDTO(XExpression newToDTO, NotificationChain msgs) {
		XExpression oldToDTO = toDTO;
		toDTO = newToDTO;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_MAPPER__TO_DTO, oldToDTO, newToDTO);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToDTO(XExpression newToDTO) {
		if (newToDTO != toDTO) {
			NotificationChain msgs = null;
			if (toDTO != null)
				msgs = ((InternalEObject)toDTO).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_MAPPER__TO_DTO, null, msgs);
			if (newToDTO != null)
				msgs = ((InternalEObject)newToDTO).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_MAPPER__TO_DTO, null, msgs);
			msgs = basicSetToDTO(newToDTO, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_MAPPER__TO_DTO, newToDTO, newToDTO));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getFromDTO() {
		return fromDTO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromDTO(XExpression newFromDTO, NotificationChain msgs) {
		XExpression oldFromDTO = fromDTO;
		fromDTO = newFromDTO;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_MAPPER__FROM_DTO, oldFromDTO, newFromDTO);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromDTO(XExpression newFromDTO) {
		if (newFromDTO != fromDTO) {
			NotificationChain msgs = null;
			if (fromDTO != null)
				msgs = ((InternalEObject)fromDTO).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_MAPPER__FROM_DTO, null, msgs);
			if (newFromDTO != null)
				msgs = ((InternalEObject)newFromDTO).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_MAPPER__FROM_DTO, null, msgs);
			msgs = basicSetFromDTO(newFromDTO, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_MAPPER__FROM_DTO, newFromDTO, newFromDTO));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunDtoPackage.LDTO_MAPPER__TO_DTO:
				return basicSetToDTO(null, msgs);
			case LunDtoPackage.LDTO_MAPPER__FROM_DTO:
				return basicSetFromDTO(null, msgs);
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
			case LunDtoPackage.LDTO_MAPPER__TO_DTO:
				return getToDTO();
			case LunDtoPackage.LDTO_MAPPER__FROM_DTO:
				return getFromDTO();
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
			case LunDtoPackage.LDTO_MAPPER__TO_DTO:
				setToDTO((XExpression)newValue);
				return;
			case LunDtoPackage.LDTO_MAPPER__FROM_DTO:
				setFromDTO((XExpression)newValue);
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
			case LunDtoPackage.LDTO_MAPPER__TO_DTO:
				setToDTO((XExpression)null);
				return;
			case LunDtoPackage.LDTO_MAPPER__FROM_DTO:
				setFromDTO((XExpression)null);
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
			case LunDtoPackage.LDTO_MAPPER__TO_DTO:
				return toDTO != null;
			case LunDtoPackage.LDTO_MAPPER__FROM_DTO:
				return fromDTO != null;
		}
		return super.eIsSet(featureID);
	}

} //LDtoMapperImpl

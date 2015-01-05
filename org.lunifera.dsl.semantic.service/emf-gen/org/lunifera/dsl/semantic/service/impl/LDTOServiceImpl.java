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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.lunifera.dsl.semantic.dto.LDto;

import org.lunifera.dsl.semantic.service.LDTOService;
import org.lunifera.dsl.semantic.service.LFilterableAttributes;
import org.lunifera.dsl.semantic.service.LSortableAttributes;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDTO Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getDto <em>Dto</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getDtoJvm <em>Dto Jvm</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getPersistenceId <em>Persistence Id</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getFilterable <em>Filterable</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getSortable <em>Sortable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDTOServiceImpl extends LServiceImpl implements LDTOService {
	/**
	 * The cached value of the '{@link #getDto() <em>Dto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDto()
	 * @generated
	 * @ordered
	 */
	protected LDto dto;

	/**
	 * The cached value of the '{@link #getDtoJvm() <em>Dto Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDtoJvm()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference dtoJvm;

	/**
	 * The default value of the '{@link #getPersistenceId() <em>Persistence Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistenceId()
	 * @generated
	 * @ordered
	 */
	protected static final String PERSISTENCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPersistenceId() <em>Persistence Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistenceId()
	 * @generated
	 * @ordered
	 */
	protected String persistenceId = PERSISTENCE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFilterable() <em>Filterable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterable()
	 * @generated
	 * @ordered
	 */
	protected LFilterableAttributes filterable;

	/**
	 * The cached value of the '{@link #getSortable() <em>Sortable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortable()
	 * @generated
	 * @ordered
	 */
	protected LSortableAttributes sortable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LDTOServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunServicePackage.Literals.LDTO_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDto getDto() {
		if (dto != null && dto.eIsProxy()) {
			InternalEObject oldDto = (InternalEObject)dto;
			dto = (LDto)eResolveProxy(oldDto);
			if (dto != oldDto) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunServicePackage.LDTO_SERVICE__DTO, oldDto, dto));
			}
		}
		return dto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDto basicGetDto() {
		return dto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDto(LDto newDto) {
		LDto oldDto = dto;
		dto = newDto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__DTO, oldDto, dto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getDtoJvm() {
		return dtoJvm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDtoJvm(JvmTypeReference newDtoJvm, NotificationChain msgs) {
		JvmTypeReference oldDtoJvm = dtoJvm;
		dtoJvm = newDtoJvm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__DTO_JVM, oldDtoJvm, newDtoJvm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDtoJvm(JvmTypeReference newDtoJvm) {
		if (newDtoJvm != dtoJvm) {
			NotificationChain msgs = null;
			if (dtoJvm != null)
				msgs = ((InternalEObject)dtoJvm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__DTO_JVM, null, msgs);
			if (newDtoJvm != null)
				msgs = ((InternalEObject)newDtoJvm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__DTO_JVM, null, msgs);
			msgs = basicSetDtoJvm(newDtoJvm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__DTO_JVM, newDtoJvm, newDtoJvm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPersistenceId() {
		return persistenceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistenceId(String newPersistenceId) {
		String oldPersistenceId = persistenceId;
		persistenceId = newPersistenceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__PERSISTENCE_ID, oldPersistenceId, persistenceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LFilterableAttributes getFilterable() {
		return filterable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFilterable(LFilterableAttributes newFilterable, NotificationChain msgs) {
		LFilterableAttributes oldFilterable = filterable;
		filterable = newFilterable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__FILTERABLE, oldFilterable, newFilterable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterable(LFilterableAttributes newFilterable) {
		if (newFilterable != filterable) {
			NotificationChain msgs = null;
			if (filterable != null)
				msgs = ((InternalEObject)filterable).eInverseRemove(this, LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT, LFilterableAttributes.class, msgs);
			if (newFilterable != null)
				msgs = ((InternalEObject)newFilterable).eInverseAdd(this, LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT, LFilterableAttributes.class, msgs);
			msgs = basicSetFilterable(newFilterable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__FILTERABLE, newFilterable, newFilterable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LSortableAttributes getSortable() {
		return sortable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSortable(LSortableAttributes newSortable, NotificationChain msgs) {
		LSortableAttributes oldSortable = sortable;
		sortable = newSortable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__SORTABLE, oldSortable, newSortable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSortable(LSortableAttributes newSortable) {
		if (newSortable != sortable) {
			NotificationChain msgs = null;
			if (sortable != null)
				msgs = ((InternalEObject)sortable).eInverseRemove(this, LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT, LSortableAttributes.class, msgs);
			if (newSortable != null)
				msgs = ((InternalEObject)newSortable).eInverseAdd(this, LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT, LSortableAttributes.class, msgs);
			msgs = basicSetSortable(newSortable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__SORTABLE, newSortable, newSortable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				if (filterable != null)
					msgs = ((InternalEObject)filterable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__FILTERABLE, null, msgs);
				return basicSetFilterable((LFilterableAttributes)otherEnd, msgs);
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				if (sortable != null)
					msgs = ((InternalEObject)sortable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__SORTABLE, null, msgs);
				return basicSetSortable((LSortableAttributes)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunServicePackage.LDTO_SERVICE__DTO_JVM:
				return basicSetDtoJvm(null, msgs);
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				return basicSetFilterable(null, msgs);
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				return basicSetSortable(null, msgs);
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
			case LunServicePackage.LDTO_SERVICE__DTO:
				if (resolve) return getDto();
				return basicGetDto();
			case LunServicePackage.LDTO_SERVICE__DTO_JVM:
				return getDtoJvm();
			case LunServicePackage.LDTO_SERVICE__PERSISTENCE_ID:
				return getPersistenceId();
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				return getFilterable();
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				return getSortable();
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
			case LunServicePackage.LDTO_SERVICE__DTO:
				setDto((LDto)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__DTO_JVM:
				setDtoJvm((JvmTypeReference)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__PERSISTENCE_ID:
				setPersistenceId((String)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				setFilterable((LFilterableAttributes)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				setSortable((LSortableAttributes)newValue);
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
			case LunServicePackage.LDTO_SERVICE__DTO:
				setDto((LDto)null);
				return;
			case LunServicePackage.LDTO_SERVICE__DTO_JVM:
				setDtoJvm((JvmTypeReference)null);
				return;
			case LunServicePackage.LDTO_SERVICE__PERSISTENCE_ID:
				setPersistenceId(PERSISTENCE_ID_EDEFAULT);
				return;
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				setFilterable((LFilterableAttributes)null);
				return;
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				setSortable((LSortableAttributes)null);
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
			case LunServicePackage.LDTO_SERVICE__DTO:
				return dto != null;
			case LunServicePackage.LDTO_SERVICE__DTO_JVM:
				return dtoJvm != null;
			case LunServicePackage.LDTO_SERVICE__PERSISTENCE_ID:
				return PERSISTENCE_ID_EDEFAULT == null ? persistenceId != null : !PERSISTENCE_ID_EDEFAULT.equals(persistenceId);
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				return filterable != null;
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				return sortable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (persistenceId: ");
		result.append(persistenceId);
		result.append(')');
		return result.toString();
	}

} //LDTOServiceImpl

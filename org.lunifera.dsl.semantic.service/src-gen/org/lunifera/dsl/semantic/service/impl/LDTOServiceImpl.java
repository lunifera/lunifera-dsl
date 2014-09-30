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

import org.eclipse.xtext.xbase.XExpression;

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
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getFilterable <em>Filterable</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getSortable <em>Sortable</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getGetExpression <em>Get Expression</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getFindExpression <em>Find Expression</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getFindExpressionWithDelimiter <em>Find Expression With Delimiter</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getUpdateExpression <em>Update Expression</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getDeleteExpression <em>Delete Expression</em>}</li>
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
	 * The cached value of the '{@link #getGetExpression() <em>Get Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression getExpression;

	/**
	 * The cached value of the '{@link #getFindExpression() <em>Find Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFindExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression findExpression;

	/**
	 * The cached value of the '{@link #getFindExpressionWithDelimiter() <em>Find Expression With Delimiter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFindExpressionWithDelimiter()
	 * @generated
	 * @ordered
	 */
	protected XExpression findExpressionWithDelimiter;

	/**
	 * The cached value of the '{@link #getUpdateExpression() <em>Update Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdateExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression updateExpression;

	/**
	 * The cached value of the '{@link #getDeleteExpression() <em>Delete Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeleteExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression deleteExpression;

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
	public XExpression getGetExpression() {
		return getExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGetExpression(XExpression newGetExpression, NotificationChain msgs) {
		XExpression oldGetExpression = getExpression;
		getExpression = newGetExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__GET_EXPRESSION, oldGetExpression, newGetExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGetExpression(XExpression newGetExpression) {
		if (newGetExpression != getExpression) {
			NotificationChain msgs = null;
			if (getExpression != null)
				msgs = ((InternalEObject)getExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__GET_EXPRESSION, null, msgs);
			if (newGetExpression != null)
				msgs = ((InternalEObject)newGetExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__GET_EXPRESSION, null, msgs);
			msgs = basicSetGetExpression(newGetExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__GET_EXPRESSION, newGetExpression, newGetExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getFindExpression() {
		return findExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFindExpression(XExpression newFindExpression, NotificationChain msgs) {
		XExpression oldFindExpression = findExpression;
		findExpression = newFindExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION, oldFindExpression, newFindExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFindExpression(XExpression newFindExpression) {
		if (newFindExpression != findExpression) {
			NotificationChain msgs = null;
			if (findExpression != null)
				msgs = ((InternalEObject)findExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION, null, msgs);
			if (newFindExpression != null)
				msgs = ((InternalEObject)newFindExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION, null, msgs);
			msgs = basicSetFindExpression(newFindExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION, newFindExpression, newFindExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getFindExpressionWithDelimiter() {
		return findExpressionWithDelimiter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFindExpressionWithDelimiter(XExpression newFindExpressionWithDelimiter, NotificationChain msgs) {
		XExpression oldFindExpressionWithDelimiter = findExpressionWithDelimiter;
		findExpressionWithDelimiter = newFindExpressionWithDelimiter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER, oldFindExpressionWithDelimiter, newFindExpressionWithDelimiter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFindExpressionWithDelimiter(XExpression newFindExpressionWithDelimiter) {
		if (newFindExpressionWithDelimiter != findExpressionWithDelimiter) {
			NotificationChain msgs = null;
			if (findExpressionWithDelimiter != null)
				msgs = ((InternalEObject)findExpressionWithDelimiter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER, null, msgs);
			if (newFindExpressionWithDelimiter != null)
				msgs = ((InternalEObject)newFindExpressionWithDelimiter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER, null, msgs);
			msgs = basicSetFindExpressionWithDelimiter(newFindExpressionWithDelimiter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER, newFindExpressionWithDelimiter, newFindExpressionWithDelimiter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getUpdateExpression() {
		return updateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpdateExpression(XExpression newUpdateExpression, NotificationChain msgs) {
		XExpression oldUpdateExpression = updateExpression;
		updateExpression = newUpdateExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__UPDATE_EXPRESSION, oldUpdateExpression, newUpdateExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateExpression(XExpression newUpdateExpression) {
		if (newUpdateExpression != updateExpression) {
			NotificationChain msgs = null;
			if (updateExpression != null)
				msgs = ((InternalEObject)updateExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__UPDATE_EXPRESSION, null, msgs);
			if (newUpdateExpression != null)
				msgs = ((InternalEObject)newUpdateExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__UPDATE_EXPRESSION, null, msgs);
			msgs = basicSetUpdateExpression(newUpdateExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__UPDATE_EXPRESSION, newUpdateExpression, newUpdateExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getDeleteExpression() {
		return deleteExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeleteExpression(XExpression newDeleteExpression, NotificationChain msgs) {
		XExpression oldDeleteExpression = deleteExpression;
		deleteExpression = newDeleteExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__DELETE_EXPRESSION, oldDeleteExpression, newDeleteExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeleteExpression(XExpression newDeleteExpression) {
		if (newDeleteExpression != deleteExpression) {
			NotificationChain msgs = null;
			if (deleteExpression != null)
				msgs = ((InternalEObject)deleteExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__DELETE_EXPRESSION, null, msgs);
			if (newDeleteExpression != null)
				msgs = ((InternalEObject)newDeleteExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__DELETE_EXPRESSION, null, msgs);
			msgs = basicSetDeleteExpression(newDeleteExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__DELETE_EXPRESSION, newDeleteExpression, newDeleteExpression));
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
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				return basicSetFilterable(null, msgs);
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				return basicSetSortable(null, msgs);
			case LunServicePackage.LDTO_SERVICE__GET_EXPRESSION:
				return basicSetGetExpression(null, msgs);
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION:
				return basicSetFindExpression(null, msgs);
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER:
				return basicSetFindExpressionWithDelimiter(null, msgs);
			case LunServicePackage.LDTO_SERVICE__UPDATE_EXPRESSION:
				return basicSetUpdateExpression(null, msgs);
			case LunServicePackage.LDTO_SERVICE__DELETE_EXPRESSION:
				return basicSetDeleteExpression(null, msgs);
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
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				return getFilterable();
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				return getSortable();
			case LunServicePackage.LDTO_SERVICE__GET_EXPRESSION:
				return getGetExpression();
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION:
				return getFindExpression();
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER:
				return getFindExpressionWithDelimiter();
			case LunServicePackage.LDTO_SERVICE__UPDATE_EXPRESSION:
				return getUpdateExpression();
			case LunServicePackage.LDTO_SERVICE__DELETE_EXPRESSION:
				return getDeleteExpression();
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
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				setFilterable((LFilterableAttributes)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				setSortable((LSortableAttributes)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__GET_EXPRESSION:
				setGetExpression((XExpression)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION:
				setFindExpression((XExpression)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER:
				setFindExpressionWithDelimiter((XExpression)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__UPDATE_EXPRESSION:
				setUpdateExpression((XExpression)newValue);
				return;
			case LunServicePackage.LDTO_SERVICE__DELETE_EXPRESSION:
				setDeleteExpression((XExpression)newValue);
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
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				setFilterable((LFilterableAttributes)null);
				return;
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				setSortable((LSortableAttributes)null);
				return;
			case LunServicePackage.LDTO_SERVICE__GET_EXPRESSION:
				setGetExpression((XExpression)null);
				return;
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION:
				setFindExpression((XExpression)null);
				return;
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER:
				setFindExpressionWithDelimiter((XExpression)null);
				return;
			case LunServicePackage.LDTO_SERVICE__UPDATE_EXPRESSION:
				setUpdateExpression((XExpression)null);
				return;
			case LunServicePackage.LDTO_SERVICE__DELETE_EXPRESSION:
				setDeleteExpression((XExpression)null);
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
			case LunServicePackage.LDTO_SERVICE__FILTERABLE:
				return filterable != null;
			case LunServicePackage.LDTO_SERVICE__SORTABLE:
				return sortable != null;
			case LunServicePackage.LDTO_SERVICE__GET_EXPRESSION:
				return getExpression != null;
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION:
				return findExpression != null;
			case LunServicePackage.LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER:
				return findExpressionWithDelimiter != null;
			case LunServicePackage.LDTO_SERVICE__UPDATE_EXPRESSION:
				return updateExpression != null;
			case LunServicePackage.LDTO_SERVICE__DELETE_EXPRESSION:
				return deleteExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //LDTOServiceImpl

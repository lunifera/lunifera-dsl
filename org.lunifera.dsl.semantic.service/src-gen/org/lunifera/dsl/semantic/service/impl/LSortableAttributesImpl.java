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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.lunifera.dsl.semantic.dto.LDtoFeature;

import org.lunifera.dsl.semantic.service.LDTOService;
import org.lunifera.dsl.semantic.service.LSortableAttributes;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LSortable Attributes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LSortableAttributesImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LSortableAttributesImpl#getSortableFeatures <em>Sortable Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LSortableAttributesImpl extends MinimalEObjectImpl.Container implements LSortableAttributes {
	/**
	 * The cached value of the '{@link #getSortableFeatures() <em>Sortable Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortableFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<LDtoFeature> sortableFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LSortableAttributesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunServicePackage.Literals.LSORTABLE_ATTRIBUTES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDTOService getParent() {
		if (eContainerFeatureID() != LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT) return null;
		return (LDTOService)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDTOService basicGetParent() {
		if (eContainerFeatureID() != LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT) return null;
		return (LDTOService)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(LDTOService newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(LDTOService newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, LunServicePackage.LDTO_SERVICE__SORTABLE, LDTOService.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LDtoFeature> getSortableFeatures() {
		if (sortableFeatures == null) {
			sortableFeatures = new EObjectResolvingEList<LDtoFeature>(LDtoFeature.class, this, LunServicePackage.LSORTABLE_ATTRIBUTES__SORTABLE_FEATURES);
		}
		return sortableFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((LDTOService)otherEnd, msgs);
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
			case LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT:
				return eInternalContainer().eInverseRemove(this, LunServicePackage.LDTO_SERVICE__SORTABLE, LDTOService.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case LunServicePackage.LSORTABLE_ATTRIBUTES__SORTABLE_FEATURES:
				return getSortableFeatures();
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
			case LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT:
				setParent((LDTOService)newValue);
				return;
			case LunServicePackage.LSORTABLE_ATTRIBUTES__SORTABLE_FEATURES:
				getSortableFeatures().clear();
				getSortableFeatures().addAll((Collection<? extends LDtoFeature>)newValue);
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
			case LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT:
				setParent((LDTOService)null);
				return;
			case LunServicePackage.LSORTABLE_ATTRIBUTES__SORTABLE_FEATURES:
				getSortableFeatures().clear();
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
			case LunServicePackage.LSORTABLE_ATTRIBUTES__PARENT:
				return basicGetParent() != null;
			case LunServicePackage.LSORTABLE_ATTRIBUTES__SORTABLE_FEATURES:
				return sortableFeatures != null && !sortableFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LSortableAttributesImpl

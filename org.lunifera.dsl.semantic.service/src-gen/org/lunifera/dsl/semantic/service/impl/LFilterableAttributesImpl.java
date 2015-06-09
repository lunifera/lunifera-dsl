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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.lunifera.dsl.semantic.common.types.impl.LLazyResolverImpl;

import org.lunifera.dsl.semantic.dto.LDtoFeature;

import org.lunifera.dsl.semantic.service.LDTOService;
import org.lunifera.dsl.semantic.service.LFilterableAttributes;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LFilterable Attributes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LFilterableAttributesImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LFilterableAttributesImpl#getFilterableFeatures <em>Filterable Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LFilterableAttributesImpl extends LLazyResolverImpl implements LFilterableAttributes {
	/**
	 * The cached value of the '{@link #getFilterableFeatures() <em>Filterable Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterableFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<LDtoFeature> filterableFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LFilterableAttributesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunServicePackage.Literals.LFILTERABLE_ATTRIBUTES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDTOService getParent() {
		if (eContainerFeatureID() != LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT) return null;
		return (LDTOService)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDTOService basicGetParent() {
		if (eContainerFeatureID() != LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT) return null;
		return (LDTOService)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(LDTOService newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(LDTOService newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, LunServicePackage.LDTO_SERVICE__FILTERABLE, LDTOService.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LDtoFeature> getFilterableFeatures() {
		if (filterableFeatures == null) {
			filterableFeatures = new EObjectResolvingEList<LDtoFeature>(LDtoFeature.class, this, LunServicePackage.LFILTERABLE_ATTRIBUTES__FILTERABLE_FEATURES);
		}
		return filterableFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT:
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
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT:
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
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT:
				return eInternalContainer().eInverseRemove(this, LunServicePackage.LDTO_SERVICE__FILTERABLE, LDTOService.class, msgs);
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
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__FILTERABLE_FEATURES:
				return getFilterableFeatures();
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
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT:
				setParent((LDTOService)newValue);
				return;
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__FILTERABLE_FEATURES:
				getFilterableFeatures().clear();
				getFilterableFeatures().addAll((Collection<? extends LDtoFeature>)newValue);
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
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT:
				setParent((LDTOService)null);
				return;
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__FILTERABLE_FEATURES:
				getFilterableFeatures().clear();
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
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__PARENT:
				return basicGetParent() != null;
			case LunServicePackage.LFILTERABLE_ATTRIBUTES__FILTERABLE_FEATURES:
				return filterableFeatures != null && !filterableFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LFilterableAttributesImpl

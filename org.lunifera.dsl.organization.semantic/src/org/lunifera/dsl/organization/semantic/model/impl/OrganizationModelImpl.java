/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.lunifera.dsl.organization.semantic.model.Organization;
import org.lunifera.dsl.organization.semantic.model.OrganizationModel;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;
import org.lunifera.dsl.organization.semantic.model.OrganizationUnitType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationModelImpl#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationModelImpl#getOrganizationUnitTypes <em>Organization Unit Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrganizationModelImpl extends MinimalEObjectImpl.Container implements OrganizationModel {
	/**
	 * The cached value of the '{@link #getOrganization() <em>Organization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganization()
	 * @generated
	 * @ordered
	 */
	protected Organization organization;
	/**
	 * The cached value of the '{@link #getOrganizationUnitTypes() <em>Organization Unit Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganizationUnitTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<OrganizationUnitType> organizationUnitTypes;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrganizationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.ORGANIZATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrganization(Organization newOrganization, NotificationChain msgs) {
		Organization oldOrganization = organization;
		organization = newOrganization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION, oldOrganization, newOrganization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrganization(Organization newOrganization) {
		if (newOrganization != organization) {
			NotificationChain msgs = null;
			if (organization != null)
				msgs = ((InternalEObject)organization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION, null, msgs);
			if (newOrganization != null)
				msgs = ((InternalEObject)newOrganization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION, null, msgs);
			msgs = basicSetOrganization(newOrganization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION, newOrganization, newOrganization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrganizationUnitType> getOrganizationUnitTypes() {
		if (organizationUnitTypes == null) {
			organizationUnitTypes = new EObjectContainmentEList<OrganizationUnitType>(OrganizationUnitType.class, this, OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION_UNIT_TYPES);
		}
		return organizationUnitTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION:
				return basicSetOrganization(null, msgs);
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION_UNIT_TYPES:
				return ((InternalEList<?>)getOrganizationUnitTypes()).basicRemove(otherEnd, msgs);
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
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION:
				return getOrganization();
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION_UNIT_TYPES:
				return getOrganizationUnitTypes();
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
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION:
				setOrganization((Organization)newValue);
				return;
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION_UNIT_TYPES:
				getOrganizationUnitTypes().clear();
				getOrganizationUnitTypes().addAll((Collection<? extends OrganizationUnitType>)newValue);
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
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION:
				setOrganization((Organization)null);
				return;
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION_UNIT_TYPES:
				getOrganizationUnitTypes().clear();
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
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION:
				return organization != null;
			case OrganizationPackage.ORGANIZATION_MODEL__ORGANIZATION_UNIT_TYPES:
				return organizationUnitTypes != null && !organizationUnitTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OrganizationModelImpl

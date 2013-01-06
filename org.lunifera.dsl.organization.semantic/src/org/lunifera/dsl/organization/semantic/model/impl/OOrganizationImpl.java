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
import org.lunifera.dsl.organization.semantic.model.ODescribed;
import org.lunifera.dsl.organization.semantic.model.OGroup;
import org.lunifera.dsl.organization.semantic.model.OOrganization;
import org.lunifera.dsl.organization.semantic.model.OOrganizationMember;
import org.lunifera.dsl.organization.semantic.model.OPerson;
import org.lunifera.dsl.organization.semantic.model.OPersonRole;
import org.lunifera.dsl.organization.semantic.model.OUnit;
import org.lunifera.dsl.organization.semantic.model.OWorker;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;
import org.lunifera.dsl.organization.semantic.model.util.DerivedOrganizationFeatures;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>OOrganization</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationImpl#getLongName
 * <em>Long Name</em>}</li>
 * <li>
 * {@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationImpl#getDescription
 * <em>Description</em>}</li>
 * <li>
 * {@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationImpl#getVersion
 * <em>Version</em>}</li>
 * <li>
 * {@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationImpl#getElements
 * <em>Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OOrganizationImpl extends MinimalEObjectImpl.Container implements
		OOrganization {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongName() <em>Long Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected static final String LONG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLongName() <em>Long Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected String longName = LONG_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<OOrganizationMember> elements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OOrganizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.OORGANIZATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OrganizationPackage.OORGANIZATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLongName() {
		return longName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLongName(String newLongName) {
		String oldLongName = longName;
		longName = newLongName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OrganizationPackage.OORGANIZATION__LONG_NAME, oldLongName,
					longName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OrganizationPackage.OORGANIZATION__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OrganizationPackage.OORGANIZATION__VERSION, oldVersion,
					version));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<OOrganizationMember> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<OOrganizationMember>(
					OOrganizationMember.class, this,
					OrganizationPackage.OORGANIZATION__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EList<OUnit> getUnits() {
		return new DerivedOrganizationFeatures(this).getOrganizationUnits();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EList<OPersonRole> getRoles() {
		return new DerivedOrganizationFeatures(this).getBusinessRoles();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EList<OPerson> getPersons() {
		return new DerivedOrganizationFeatures(this).getPersons();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EList<OWorker> getWorkers() {
		return new DerivedOrganizationFeatures(this).getWorkers();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EList<OGroup> getGroups() {
		return new DerivedOrganizationFeatures(this).getGroups();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OrganizationPackage.OORGANIZATION__ELEMENTS:
			return ((InternalEList<?>) getElements()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OrganizationPackage.OORGANIZATION__NAME:
			return getName();
		case OrganizationPackage.OORGANIZATION__LONG_NAME:
			return getLongName();
		case OrganizationPackage.OORGANIZATION__DESCRIPTION:
			return getDescription();
		case OrganizationPackage.OORGANIZATION__VERSION:
			return getVersion();
		case OrganizationPackage.OORGANIZATION__ELEMENTS:
			return getElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OrganizationPackage.OORGANIZATION__NAME:
			setName((String) newValue);
			return;
		case OrganizationPackage.OORGANIZATION__LONG_NAME:
			setLongName((String) newValue);
			return;
		case OrganizationPackage.OORGANIZATION__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case OrganizationPackage.OORGANIZATION__VERSION:
			setVersion((String) newValue);
			return;
		case OrganizationPackage.OORGANIZATION__ELEMENTS:
			getElements().clear();
			getElements().addAll(
					(Collection<? extends OOrganizationMember>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case OrganizationPackage.OORGANIZATION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case OrganizationPackage.OORGANIZATION__LONG_NAME:
			setLongName(LONG_NAME_EDEFAULT);
			return;
		case OrganizationPackage.OORGANIZATION__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case OrganizationPackage.OORGANIZATION__VERSION:
			setVersion(VERSION_EDEFAULT);
			return;
		case OrganizationPackage.OORGANIZATION__ELEMENTS:
			getElements().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case OrganizationPackage.OORGANIZATION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case OrganizationPackage.OORGANIZATION__LONG_NAME:
			return LONG_NAME_EDEFAULT == null ? longName != null
					: !LONG_NAME_EDEFAULT.equals(longName);
		case OrganizationPackage.OORGANIZATION__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null
					: !DESCRIPTION_EDEFAULT.equals(description);
		case OrganizationPackage.OORGANIZATION__VERSION:
			return VERSION_EDEFAULT == null ? version != null
					: !VERSION_EDEFAULT.equals(version);
		case OrganizationPackage.OORGANIZATION__ELEMENTS:
			return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ODescribed.class) {
			switch (derivedFeatureID) {
			case OrganizationPackage.OORGANIZATION__LONG_NAME:
				return OrganizationPackage.ODESCRIBED__LONG_NAME;
			case OrganizationPackage.OORGANIZATION__DESCRIPTION:
				return OrganizationPackage.ODESCRIBED__DESCRIPTION;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ODescribed.class) {
			switch (baseFeatureID) {
			case OrganizationPackage.ODESCRIBED__LONG_NAME:
				return OrganizationPackage.OORGANIZATION__LONG_NAME;
			case OrganizationPackage.ODESCRIBED__DESCRIPTION:
				return OrganizationPackage.OORGANIZATION__DESCRIPTION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", longName: ");
		result.append(longName);
		result.append(", description: ");
		result.append(description);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} // OOrganizationImpl

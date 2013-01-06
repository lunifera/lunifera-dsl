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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.lunifera.dsl.organization.semantic.model.ODescribed;
import org.lunifera.dsl.organization.semantic.model.OGroup;
import org.lunifera.dsl.organization.semantic.model.ONamed;
import org.lunifera.dsl.organization.semantic.model.OWorker;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OGroup</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OGroupImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OGroupImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OGroupImpl#getWorkers <em>Workers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OGroupImpl extends OOrganizationMemberImpl implements OGroup {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected static final String LONG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected String longName = LONG_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWorkers() <em>Workers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkers()
	 * @generated
	 * @ordered
	 */
	protected EList<OWorker> workers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.OGROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.OGROUP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongName() {
		return longName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongName(String newLongName) {
		String oldLongName = longName;
		longName = newLongName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.OGROUP__LONG_NAME, oldLongName, longName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.OGROUP__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OWorker> getWorkers() {
		if (workers == null) {
			workers = new EObjectResolvingEList<OWorker>(OWorker.class, this, OrganizationPackage.OGROUP__WORKERS);
		}
		return workers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OrganizationPackage.OGROUP__NAME:
				return getName();
			case OrganizationPackage.OGROUP__LONG_NAME:
				return getLongName();
			case OrganizationPackage.OGROUP__DESCRIPTION:
				return getDescription();
			case OrganizationPackage.OGROUP__WORKERS:
				return getWorkers();
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
			case OrganizationPackage.OGROUP__NAME:
				setName((String)newValue);
				return;
			case OrganizationPackage.OGROUP__LONG_NAME:
				setLongName((String)newValue);
				return;
			case OrganizationPackage.OGROUP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case OrganizationPackage.OGROUP__WORKERS:
				getWorkers().clear();
				getWorkers().addAll((Collection<? extends OWorker>)newValue);
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
			case OrganizationPackage.OGROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OrganizationPackage.OGROUP__LONG_NAME:
				setLongName(LONG_NAME_EDEFAULT);
				return;
			case OrganizationPackage.OGROUP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case OrganizationPackage.OGROUP__WORKERS:
				getWorkers().clear();
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
			case OrganizationPackage.OGROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OrganizationPackage.OGROUP__LONG_NAME:
				return LONG_NAME_EDEFAULT == null ? longName != null : !LONG_NAME_EDEFAULT.equals(longName);
			case OrganizationPackage.OGROUP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case OrganizationPackage.OGROUP__WORKERS:
				return workers != null && !workers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ONamed.class) {
			switch (derivedFeatureID) {
				case OrganizationPackage.OGROUP__NAME: return OrganizationPackage.ONAMED__NAME;
				default: return -1;
			}
		}
		if (baseClass == ODescribed.class) {
			switch (derivedFeatureID) {
				case OrganizationPackage.OGROUP__LONG_NAME: return OrganizationPackage.ODESCRIBED__LONG_NAME;
				case OrganizationPackage.OGROUP__DESCRIPTION: return OrganizationPackage.ODESCRIBED__DESCRIPTION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ONamed.class) {
			switch (baseFeatureID) {
				case OrganizationPackage.ONAMED__NAME: return OrganizationPackage.OGROUP__NAME;
				default: return -1;
			}
		}
		if (baseClass == ODescribed.class) {
			switch (baseFeatureID) {
				case OrganizationPackage.ODESCRIBED__LONG_NAME: return OrganizationPackage.OGROUP__LONG_NAME;
				case OrganizationPackage.ODESCRIBED__DESCRIPTION: return OrganizationPackage.OGROUP__DESCRIPTION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", longName: ");
		result.append(longName);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //OGroupImpl

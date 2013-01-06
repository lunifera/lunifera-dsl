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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.lunifera.dsl.organization.semantic.model.OPerson;
import org.lunifera.dsl.organization.semantic.model.OPersonRole;
import org.lunifera.dsl.organization.semantic.model.OUnit;
import org.lunifera.dsl.organization.semantic.model.OWorker;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OWorker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OWorkerImpl#getPerson <em>Person</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OWorkerImpl#getAllocationUnit <em>Allocation Unit</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OWorkerImpl#getPlayRoles <em>Play Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OWorkerImpl extends OOrganizationMemberImpl implements OWorker {
	/**
	 * The cached value of the '{@link #getPerson() <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerson()
	 * @generated
	 * @ordered
	 */
	protected OPerson person;

	/**
	 * The cached value of the '{@link #getAllocationUnit() <em>Allocation Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationUnit()
	 * @generated
	 * @ordered
	 */
	protected OUnit allocationUnit;

	/**
	 * The cached value of the '{@link #getPlayRoles() <em>Play Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<OPersonRole> playRoles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OWorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.OWORKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPerson getPerson() {
		if (person != null && person.eIsProxy()) {
			InternalEObject oldPerson = (InternalEObject)person;
			person = (OPerson)eResolveProxy(oldPerson);
			if (person != oldPerson) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OrganizationPackage.OWORKER__PERSON, oldPerson, person));
			}
		}
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPerson basicGetPerson() {
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerson(OPerson newPerson) {
		OPerson oldPerson = person;
		person = newPerson;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.OWORKER__PERSON, oldPerson, person));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OUnit getAllocationUnit() {
		if (allocationUnit != null && allocationUnit.eIsProxy()) {
			InternalEObject oldAllocationUnit = (InternalEObject)allocationUnit;
			allocationUnit = (OUnit)eResolveProxy(oldAllocationUnit);
			if (allocationUnit != oldAllocationUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OrganizationPackage.OWORKER__ALLOCATION_UNIT, oldAllocationUnit, allocationUnit));
			}
		}
		return allocationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OUnit basicGetAllocationUnit() {
		return allocationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationUnit(OUnit newAllocationUnit) {
		OUnit oldAllocationUnit = allocationUnit;
		allocationUnit = newAllocationUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.OWORKER__ALLOCATION_UNIT, oldAllocationUnit, allocationUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPersonRole> getPlayRoles() {
		if (playRoles == null) {
			playRoles = new EObjectResolvingEList<OPersonRole>(OPersonRole.class, this, OrganizationPackage.OWORKER__PLAY_ROLES);
		}
		return playRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OrganizationPackage.OWORKER__PERSON:
				if (resolve) return getPerson();
				return basicGetPerson();
			case OrganizationPackage.OWORKER__ALLOCATION_UNIT:
				if (resolve) return getAllocationUnit();
				return basicGetAllocationUnit();
			case OrganizationPackage.OWORKER__PLAY_ROLES:
				return getPlayRoles();
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
			case OrganizationPackage.OWORKER__PERSON:
				setPerson((OPerson)newValue);
				return;
			case OrganizationPackage.OWORKER__ALLOCATION_UNIT:
				setAllocationUnit((OUnit)newValue);
				return;
			case OrganizationPackage.OWORKER__PLAY_ROLES:
				getPlayRoles().clear();
				getPlayRoles().addAll((Collection<? extends OPersonRole>)newValue);
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
			case OrganizationPackage.OWORKER__PERSON:
				setPerson((OPerson)null);
				return;
			case OrganizationPackage.OWORKER__ALLOCATION_UNIT:
				setAllocationUnit((OUnit)null);
				return;
			case OrganizationPackage.OWORKER__PLAY_ROLES:
				getPlayRoles().clear();
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
			case OrganizationPackage.OWORKER__PERSON:
				return person != null;
			case OrganizationPackage.OWORKER__ALLOCATION_UNIT:
				return allocationUnit != null;
			case OrganizationPackage.OWORKER__PLAY_ROLES:
				return playRoles != null && !playRoles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OWorkerImpl

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
import org.lunifera.dsl.organization.semantic.model.BusinessRole;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;
import org.lunifera.dsl.organization.semantic.model.OrganizationUnit;
import org.lunifera.dsl.organization.semantic.model.Person;
import org.lunifera.dsl.organization.semantic.model.Worker;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Worker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.WorkerImpl#getPerson <em>Person</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.WorkerImpl#getAllocationUnit <em>Allocation Unit</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.WorkerImpl#getPlayRoles <em>Play Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkerImpl extends OrganizationMemberImpl implements Worker {
	/**
	 * The cached value of the '{@link #getPerson() <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerson()
	 * @generated
	 * @ordered
	 */
	protected Person person;

	/**
	 * The cached value of the '{@link #getAllocationUnit() <em>Allocation Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationUnit()
	 * @generated
	 * @ordered
	 */
	protected OrganizationUnit allocationUnit;

	/**
	 * The cached value of the '{@link #getPlayRoles() <em>Play Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<BusinessRole> playRoles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.WORKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getPerson() {
		if (person != null && person.eIsProxy()) {
			InternalEObject oldPerson = (InternalEObject)person;
			person = (Person)eResolveProxy(oldPerson);
			if (person != oldPerson) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OrganizationPackage.WORKER__PERSON, oldPerson, person));
			}
		}
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetPerson() {
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerson(Person newPerson) {
		Person oldPerson = person;
		person = newPerson;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.WORKER__PERSON, oldPerson, person));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnit getAllocationUnit() {
		if (allocationUnit != null && allocationUnit.eIsProxy()) {
			InternalEObject oldAllocationUnit = (InternalEObject)allocationUnit;
			allocationUnit = (OrganizationUnit)eResolveProxy(oldAllocationUnit);
			if (allocationUnit != oldAllocationUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OrganizationPackage.WORKER__ALLOCATION_UNIT, oldAllocationUnit, allocationUnit));
			}
		}
		return allocationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnit basicGetAllocationUnit() {
		return allocationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationUnit(OrganizationUnit newAllocationUnit) {
		OrganizationUnit oldAllocationUnit = allocationUnit;
		allocationUnit = newAllocationUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.WORKER__ALLOCATION_UNIT, oldAllocationUnit, allocationUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusinessRole> getPlayRoles() {
		if (playRoles == null) {
			playRoles = new EObjectResolvingEList<BusinessRole>(BusinessRole.class, this, OrganizationPackage.WORKER__PLAY_ROLES);
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
			case OrganizationPackage.WORKER__PERSON:
				if (resolve) return getPerson();
				return basicGetPerson();
			case OrganizationPackage.WORKER__ALLOCATION_UNIT:
				if (resolve) return getAllocationUnit();
				return basicGetAllocationUnit();
			case OrganizationPackage.WORKER__PLAY_ROLES:
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
			case OrganizationPackage.WORKER__PERSON:
				setPerson((Person)newValue);
				return;
			case OrganizationPackage.WORKER__ALLOCATION_UNIT:
				setAllocationUnit((OrganizationUnit)newValue);
				return;
			case OrganizationPackage.WORKER__PLAY_ROLES:
				getPlayRoles().clear();
				getPlayRoles().addAll((Collection<? extends BusinessRole>)newValue);
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
			case OrganizationPackage.WORKER__PERSON:
				setPerson((Person)null);
				return;
			case OrganizationPackage.WORKER__ALLOCATION_UNIT:
				setAllocationUnit((OrganizationUnit)null);
				return;
			case OrganizationPackage.WORKER__PLAY_ROLES:
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
			case OrganizationPackage.WORKER__PERSON:
				return person != null;
			case OrganizationPackage.WORKER__ALLOCATION_UNIT:
				return allocationUnit != null;
			case OrganizationPackage.WORKER__PLAY_ROLES:
				return playRoles != null && !playRoles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WorkerImpl

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
import org.lunifera.dsl.organization.semantic.model.OBusinessRole;
import org.lunifera.dsl.organization.semantic.model.OHierarchyRoot;
import org.lunifera.dsl.organization.semantic.model.OOrganizationModel;
import org.lunifera.dsl.organization.semantic.model.OPersonRole;
import org.lunifera.dsl.organization.semantic.model.OUnitRole;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;
import org.lunifera.dsl.organization.semantic.model.util.DerivedOrganizationModelFeatures;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>OOrganization Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationModelImpl#getBusinessRoles
 * <em>Business Roles</em>}</li>
 * <li>
 * {@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationModelImpl#getRoot
 * <em>Root</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OOrganizationModelImpl extends MinimalEObjectImpl.Container
		implements OOrganizationModel {
	/**
	 * The cached value of the '{@link #getBusinessRoles()
	 * <em>Business Roles</em>}' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getBusinessRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<OBusinessRole> businessRoles;

	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected OHierarchyRoot root;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OOrganizationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.OORGANIZATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<OBusinessRole> getBusinessRoles() {
		if (businessRoles == null) {
			businessRoles = new EObjectContainmentEList<OBusinessRole>(
					OBusinessRole.class, this,
					OrganizationPackage.OORGANIZATION_MODEL__BUSINESS_ROLES);
		}
		return businessRoles;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OHierarchyRoot getRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRoot(OHierarchyRoot newRoot,
			NotificationChain msgs) {
		OHierarchyRoot oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					OrganizationPackage.OORGANIZATION_MODEL__ROOT, oldRoot,
					newRoot);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRoot(OHierarchyRoot newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null)
				msgs = ((InternalEObject) root)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OrganizationPackage.OORGANIZATION_MODEL__ROOT,
								null, msgs);
			if (newRoot != null)
				msgs = ((InternalEObject) newRoot)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- OrganizationPackage.OORGANIZATION_MODEL__ROOT,
								null, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OrganizationPackage.OORGANIZATION_MODEL__ROOT, newRoot,
					newRoot));
	}

	public EList<OUnitRole> getUnitRoles() {
		return new DerivedOrganizationModelFeatures(this).getUnitRoles();
	}

	public EList<OPersonRole> getPersonRoles() {
		return new DerivedOrganizationModelFeatures(this).getPersonRoles();
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
		case OrganizationPackage.OORGANIZATION_MODEL__BUSINESS_ROLES:
			return ((InternalEList<?>) getBusinessRoles()).basicRemove(
					otherEnd, msgs);
		case OrganizationPackage.OORGANIZATION_MODEL__ROOT:
			return basicSetRoot(null, msgs);
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
		case OrganizationPackage.OORGANIZATION_MODEL__BUSINESS_ROLES:
			return getBusinessRoles();
		case OrganizationPackage.OORGANIZATION_MODEL__ROOT:
			return getRoot();
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
		case OrganizationPackage.OORGANIZATION_MODEL__BUSINESS_ROLES:
			getBusinessRoles().clear();
			getBusinessRoles().addAll(
					(Collection<? extends OBusinessRole>) newValue);
			return;
		case OrganizationPackage.OORGANIZATION_MODEL__ROOT:
			setRoot((OHierarchyRoot) newValue);
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
		case OrganizationPackage.OORGANIZATION_MODEL__BUSINESS_ROLES:
			getBusinessRoles().clear();
			return;
		case OrganizationPackage.OORGANIZATION_MODEL__ROOT:
			setRoot((OHierarchyRoot) null);
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
		case OrganizationPackage.OORGANIZATION_MODEL__BUSINESS_ROLES:
			return businessRoles != null && !businessRoles.isEmpty();
		case OrganizationPackage.OORGANIZATION_MODEL__ROOT:
			return root != null;
		}
		return super.eIsSet(featureID);
	}

} // OOrganizationModelImpl

/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.lunifera.dsl.organization.semantic.model.ONamed;
import org.lunifera.dsl.organization.semantic.model.OOrganization;
import org.lunifera.dsl.organization.semantic.model.OPartnership;
import org.lunifera.dsl.organization.semantic.model.OWorker;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OPartnership</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OPartnershipImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OPartnershipImpl#getCompany <em>Company</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OPartnershipImpl#getResponsible <em>Responsible</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.impl.OPartnershipImpl#getAgreement <em>Agreement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPartnershipImpl extends OOrganizationMemberImpl implements OPartnership {
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
	 * The cached value of the '{@link #getCompany() <em>Company</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompany()
	 * @generated
	 * @ordered
	 */
	protected OOrganization company;

	/**
	 * The cached value of the '{@link #getResponsible() <em>Responsible</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsible()
	 * @generated
	 * @ordered
	 */
	protected OWorker responsible;

	/**
	 * The default value of the '{@link #getAgreement() <em>Agreement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgreement()
	 * @generated
	 * @ordered
	 */
	protected static final String AGREEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgreement() <em>Agreement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgreement()
	 * @generated
	 * @ordered
	 */
	protected String agreement = AGREEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPartnershipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrganizationPackage.Literals.OPARTNERSHIP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.OPARTNERSHIP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OOrganization getCompany() {
		if (company != null && company.eIsProxy()) {
			InternalEObject oldCompany = (InternalEObject)company;
			company = (OOrganization)eResolveProxy(oldCompany);
			if (company != oldCompany) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OrganizationPackage.OPARTNERSHIP__COMPANY, oldCompany, company));
			}
		}
		return company;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OOrganization basicGetCompany() {
		return company;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompany(OOrganization newCompany) {
		OOrganization oldCompany = company;
		company = newCompany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.OPARTNERSHIP__COMPANY, oldCompany, company));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OWorker getResponsible() {
		if (responsible != null && responsible.eIsProxy()) {
			InternalEObject oldResponsible = (InternalEObject)responsible;
			responsible = (OWorker)eResolveProxy(oldResponsible);
			if (responsible != oldResponsible) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OrganizationPackage.OPARTNERSHIP__RESPONSIBLE, oldResponsible, responsible));
			}
		}
		return responsible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OWorker basicGetResponsible() {
		return responsible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsible(OWorker newResponsible) {
		OWorker oldResponsible = responsible;
		responsible = newResponsible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.OPARTNERSHIP__RESPONSIBLE, oldResponsible, responsible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAgreement() {
		return agreement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgreement(String newAgreement) {
		String oldAgreement = agreement;
		agreement = newAgreement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrganizationPackage.OPARTNERSHIP__AGREEMENT, oldAgreement, agreement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OrganizationPackage.OPARTNERSHIP__NAME:
				return getName();
			case OrganizationPackage.OPARTNERSHIP__COMPANY:
				if (resolve) return getCompany();
				return basicGetCompany();
			case OrganizationPackage.OPARTNERSHIP__RESPONSIBLE:
				if (resolve) return getResponsible();
				return basicGetResponsible();
			case OrganizationPackage.OPARTNERSHIP__AGREEMENT:
				return getAgreement();
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
			case OrganizationPackage.OPARTNERSHIP__NAME:
				setName((String)newValue);
				return;
			case OrganizationPackage.OPARTNERSHIP__COMPANY:
				setCompany((OOrganization)newValue);
				return;
			case OrganizationPackage.OPARTNERSHIP__RESPONSIBLE:
				setResponsible((OWorker)newValue);
				return;
			case OrganizationPackage.OPARTNERSHIP__AGREEMENT:
				setAgreement((String)newValue);
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
			case OrganizationPackage.OPARTNERSHIP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OrganizationPackage.OPARTNERSHIP__COMPANY:
				setCompany((OOrganization)null);
				return;
			case OrganizationPackage.OPARTNERSHIP__RESPONSIBLE:
				setResponsible((OWorker)null);
				return;
			case OrganizationPackage.OPARTNERSHIP__AGREEMENT:
				setAgreement(AGREEMENT_EDEFAULT);
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
			case OrganizationPackage.OPARTNERSHIP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OrganizationPackage.OPARTNERSHIP__COMPANY:
				return company != null;
			case OrganizationPackage.OPARTNERSHIP__RESPONSIBLE:
				return responsible != null;
			case OrganizationPackage.OPARTNERSHIP__AGREEMENT:
				return AGREEMENT_EDEFAULT == null ? agreement != null : !AGREEMENT_EDEFAULT.equals(agreement);
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
				case OrganizationPackage.OPARTNERSHIP__NAME: return OrganizationPackage.ONAMED__NAME;
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
				case OrganizationPackage.ONAMED__NAME: return OrganizationPackage.OPARTNERSHIP__NAME;
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
		result.append(", agreement: ");
		result.append(agreement);
		result.append(')');
		return result.toString();
	}

} //OPartnershipImpl

/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.lunifera.dsl.organization.semantic.model.BusinessRole;
import org.lunifera.dsl.organization.semantic.model.Group;
import org.lunifera.dsl.organization.semantic.model.Organization;
import org.lunifera.dsl.organization.semantic.model.OrganizationFactory;
import org.lunifera.dsl.organization.semantic.model.OrganizationModel;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;
import org.lunifera.dsl.organization.semantic.model.OrganizationUnit;
import org.lunifera.dsl.organization.semantic.model.OrganizationUnitType;
import org.lunifera.dsl.organization.semantic.model.Partnership;
import org.lunifera.dsl.organization.semantic.model.Person;
import org.lunifera.dsl.organization.semantic.model.Worker;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrganizationFactoryImpl extends EFactoryImpl implements OrganizationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OrganizationFactory init() {
		try {
			OrganizationFactory theOrganizationFactory = (OrganizationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.lunifera.org/dsl/organization/v1"); 
			if (theOrganizationFactory != null) {
				return theOrganizationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OrganizationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OrganizationPackage.ORGANIZATION_MODEL: return createOrganizationModel();
			case OrganizationPackage.ORGANIZATION: return createOrganization();
			case OrganizationPackage.ORGANIZATION_UNIT: return createOrganizationUnit();
			case OrganizationPackage.ORGANIZATION_UNIT_TYPE: return createOrganizationUnitType();
			case OrganizationPackage.BUSINESS_ROLE: return createBusinessRole();
			case OrganizationPackage.PERSON: return createPerson();
			case OrganizationPackage.WORKER: return createWorker();
			case OrganizationPackage.GROUP: return createGroup();
			case OrganizationPackage.PARTNERSHIP: return createPartnership();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationModel createOrganizationModel() {
		OrganizationModelImpl organizationModel = new OrganizationModelImpl();
		return organizationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization createOrganization() {
		OrganizationImpl organization = new OrganizationImpl();
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnit createOrganizationUnit() {
		OrganizationUnitImpl organizationUnit = new OrganizationUnitImpl();
		return organizationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnitType createOrganizationUnitType() {
		OrganizationUnitTypeImpl organizationUnitType = new OrganizationUnitTypeImpl();
		return organizationUnitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessRole createBusinessRole() {
		BusinessRoleImpl businessRole = new BusinessRoleImpl();
		return businessRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person createPerson() {
		PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Worker createWorker() {
		WorkerImpl worker = new WorkerImpl();
		return worker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partnership createPartnership() {
		PartnershipImpl partnership = new PartnershipImpl();
		return partnership;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationPackage getOrganizationPackage() {
		return (OrganizationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OrganizationPackage getPackage() {
		return OrganizationPackage.eINSTANCE;
	}

} //OrganizationFactoryImpl

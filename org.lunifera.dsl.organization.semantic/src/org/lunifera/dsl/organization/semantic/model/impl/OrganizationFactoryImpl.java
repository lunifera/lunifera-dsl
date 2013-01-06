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
import org.lunifera.dsl.organization.semantic.model.*;
import org.lunifera.dsl.organization.semantic.model.OGroup;
import org.lunifera.dsl.organization.semantic.model.OHierarchyRoot;
import org.lunifera.dsl.organization.semantic.model.OOrganization;
import org.lunifera.dsl.organization.semantic.model.OOrganizationModel;
import org.lunifera.dsl.organization.semantic.model.OPartnership;
import org.lunifera.dsl.organization.semantic.model.OPerson;
import org.lunifera.dsl.organization.semantic.model.OPersonRole;
import org.lunifera.dsl.organization.semantic.model.OUnit;
import org.lunifera.dsl.organization.semantic.model.OUnitRole;
import org.lunifera.dsl.organization.semantic.model.OWorker;
import org.lunifera.dsl.organization.semantic.model.OrganizationFactory;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;

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
			case OrganizationPackage.OORGANIZATION_MODEL: return createOOrganizationModel();
			case OrganizationPackage.OHIERARCHY_ROOT: return createOHierarchyRoot();
			case OrganizationPackage.OORGANIZATION: return createOOrganization();
			case OrganizationPackage.OUNIT: return createOUnit();
			case OrganizationPackage.OPERSON_ROLE: return createOPersonRole();
			case OrganizationPackage.OUNIT_ROLE: return createOUnitRole();
			case OrganizationPackage.OPERSON: return createOPerson();
			case OrganizationPackage.OWORKER: return createOWorker();
			case OrganizationPackage.OGROUP: return createOGroup();
			case OrganizationPackage.OPARTNERSHIP: return createOPartnership();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OOrganizationModel createOOrganizationModel() {
		OOrganizationModelImpl oOrganizationModel = new OOrganizationModelImpl();
		return oOrganizationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OHierarchyRoot createOHierarchyRoot() {
		OHierarchyRootImpl oHierarchyRoot = new OHierarchyRootImpl();
		return oHierarchyRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OOrganization createOOrganization() {
		OOrganizationImpl oOrganization = new OOrganizationImpl();
		return oOrganization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OUnit createOUnit() {
		OUnitImpl oUnit = new OUnitImpl();
		return oUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPersonRole createOPersonRole() {
		OPersonRoleImpl oPersonRole = new OPersonRoleImpl();
		return oPersonRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OUnitRole createOUnitRole() {
		OUnitRoleImpl oUnitRole = new OUnitRoleImpl();
		return oUnitRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPerson createOPerson() {
		OPersonImpl oPerson = new OPersonImpl();
		return oPerson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OWorker createOWorker() {
		OWorkerImpl oWorker = new OWorkerImpl();
		return oWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OGroup createOGroup() {
		OGroupImpl oGroup = new OGroupImpl();
		return oGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPartnership createOPartnership() {
		OPartnershipImpl oPartnership = new OPartnershipImpl();
		return oPartnership;
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

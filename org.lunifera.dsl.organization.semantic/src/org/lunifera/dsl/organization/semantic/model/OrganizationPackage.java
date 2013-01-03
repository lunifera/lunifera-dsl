/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationFactory
 * @model kind="package"
 * @generated
 */
public interface OrganizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.lunifera.org/dsl/organization/v1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OrganizationPackage eINSTANCE = org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationModelImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganizationModel()
	 * @generated
	 */
	int ORGANIZATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Organization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_MODEL__ORGANIZATION = 0;

	/**
	 * The feature id for the '<em><b>Organization Unit Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_MODEL__ORGANIZATION_UNIT_TYPES = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationImpl <em>Organization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganization()
	 * @generated
	 */
	int ORGANIZATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__LONG_NAME = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__ELEMENTS = 4;

	/**
	 * The number of structural features of the '<em>Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationMemberImpl <em>Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationMemberImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganizationMember()
	 * @generated
	 */
	int ORGANIZATION_MEMBER = 9;

	/**
	 * The number of structural features of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_MEMBER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationUnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationUnitImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganizationUnit()
	 * @generated
	 */
	int ORGANIZATION_UNIT = 2;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.BusinessRoleImpl <em>Business Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.BusinessRoleImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getBusinessRole()
	 * @generated
	 */
	int BUSINESS_ROLE = 4;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.PersonImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 5;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.WorkerImpl <em>Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.WorkerImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getWorker()
	 * @generated
	 */
	int WORKER = 6;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.GroupImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 7;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.PartnershipImpl <em>Partnership</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.PartnershipImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getPartnership()
	 * @generated
	 */
	int PARTNERSHIP = 8;

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OrganizationModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationModel
	 * @generated
	 */
	EClass getOrganizationModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.organization.semantic.model.OrganizationModel#getOrganization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Organization</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationModel#getOrganization()
	 * @see #getOrganizationModel()
	 * @generated
	 */
	EReference getOrganizationModel_Organization();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.organization.semantic.model.OrganizationModel#getOrganizationUnitTypes <em>Organization Unit Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Organization Unit Types</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationModel#getOrganizationUnitTypes()
	 * @see #getOrganizationModel()
	 * @generated
	 */
	EReference getOrganizationModel_OrganizationUnitTypes();

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT__NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT__PARENT = ORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT__LONG_NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT__DESCRIPTION = ORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT__TYPES = ORGANIZATION_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_FEATURE_COUNT = ORGANIZATION_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationUnitTypeImpl <em>Unit Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationUnitTypeImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganizationUnitType()
	 * @generated
	 */
	int ORGANIZATION_UNIT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_TYPE__NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_TYPE__LONG_NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_TYPE__DESCRIPTION = ORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_TYPE_FEATURE_COUNT = ORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ROLE__NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ROLE__LONG_NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ROLE__DESCRIPTION = ORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Business Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ROLE_FEATURE_COUNT = ORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRST_NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Middle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__MIDDLE_NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LAST_NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__EMAIL = ORGANIZATION_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = ORGANIZATION_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__PERSON = ORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allocation Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__ALLOCATION_UNIT = ORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Play Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__PLAY_ROLES = ORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FEATURE_COUNT = ORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__LONG_NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DESCRIPTION = ORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Workers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__WORKERS = ORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = ORGANIZATION_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNERSHIP__NAME = ORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Company</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNERSHIP__COMPANY = ORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Responsible</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNERSHIP__RESPONSIBLE = ORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Agreement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNERSHIP__AGREEMENT = ORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Partnership</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNERSHIP_FEATURE_COUNT = ORGANIZATION_MEMBER_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.Organization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Organization
	 * @generated
	 */
	EClass getOrganization();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Organization#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Organization#getName()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Organization#getLongName <em>Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Organization#getLongName()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_LongName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Organization#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Organization#getVersion()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Organization#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Organization#getDescription()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.organization.semantic.model.Organization#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Organization#getElements()
	 * @see #getOrganization()
	 * @generated
	 */
	EReference getOrganization_Elements();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnit
	 * @generated
	 */
	EClass getOrganizationUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getName()
	 * @see #getOrganizationUnit()
	 * @generated
	 */
	EAttribute getOrganizationUnit_Name();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getParent()
	 * @see #getOrganizationUnit()
	 * @generated
	 */
	EReference getOrganizationUnit_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getLongName <em>Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getLongName()
	 * @see #getOrganizationUnit()
	 * @generated
	 */
	EAttribute getOrganizationUnit_LongName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getDescription()
	 * @see #getOrganizationUnit()
	 * @generated
	 */
	EAttribute getOrganizationUnit_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Types</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnit#getTypes()
	 * @see #getOrganizationUnit()
	 * @generated
	 */
	EReference getOrganizationUnit_Types();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnitType <em>Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Type</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnitType
	 * @generated
	 */
	EClass getOrganizationUnitType();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnitType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnitType#getName()
	 * @see #getOrganizationUnitType()
	 * @generated
	 */
	EAttribute getOrganizationUnitType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnitType#getLongName <em>Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnitType#getLongName()
	 * @see #getOrganizationUnitType()
	 * @generated
	 */
	EAttribute getOrganizationUnitType_LongName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OrganizationUnitType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationUnitType#getDescription()
	 * @see #getOrganizationUnitType()
	 * @generated
	 */
	EAttribute getOrganizationUnitType_Description();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.BusinessRole <em>Business Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Role</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.BusinessRole
	 * @generated
	 */
	EClass getBusinessRole();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.BusinessRole#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.BusinessRole#getName()
	 * @see #getBusinessRole()
	 * @generated
	 */
	EAttribute getBusinessRole_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.BusinessRole#getLongName <em>Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.BusinessRole#getLongName()
	 * @see #getBusinessRole()
	 * @generated
	 */
	EAttribute getBusinessRole_LongName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.BusinessRole#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.BusinessRole#getDescription()
	 * @see #getBusinessRole()
	 * @generated
	 */
	EAttribute getBusinessRole_Description();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Person#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Person#getFirstName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Person#getMiddleName <em>Middle Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Middle Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Person#getMiddleName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_MiddleName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Person#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Person#getLastName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_LastName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Person#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Person#getEmail()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Email();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.Worker <em>Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Worker</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Worker
	 * @generated
	 */
	EClass getWorker();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.organization.semantic.model.Worker#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Person</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Worker#getPerson()
	 * @see #getWorker()
	 * @generated
	 */
	EReference getWorker_Person();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.organization.semantic.model.Worker#getAllocationUnit <em>Allocation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocation Unit</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Worker#getAllocationUnit()
	 * @see #getWorker()
	 * @generated
	 */
	EReference getWorker_AllocationUnit();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.organization.semantic.model.Worker#getPlayRoles <em>Play Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Play Roles</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Worker#getPlayRoles()
	 * @see #getWorker()
	 * @generated
	 */
	EReference getWorker_PlayRoles();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Group#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Group#getLongName <em>Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Group#getLongName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_LongName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Group#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Group#getDescription()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.organization.semantic.model.Group#getWorkers <em>Workers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Workers</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Group#getWorkers()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Workers();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.Partnership <em>Partnership</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partnership</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Partnership
	 * @generated
	 */
	EClass getPartnership();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Partnership#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Partnership#getName()
	 * @see #getPartnership()
	 * @generated
	 */
	EAttribute getPartnership_Name();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.organization.semantic.model.Partnership#getCompany <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Company</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Partnership#getCompany()
	 * @see #getPartnership()
	 * @generated
	 */
	EReference getPartnership_Company();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.organization.semantic.model.Partnership#getResponsible <em>Responsible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsible</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Partnership#getResponsible()
	 * @see #getPartnership()
	 * @generated
	 */
	EReference getPartnership_Responsible();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.Partnership#getAgreement <em>Agreement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Agreement</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.Partnership#getAgreement()
	 * @see #getPartnership()
	 * @generated
	 */
	EAttribute getPartnership_Agreement();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OrganizationMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationMember
	 * @generated
	 */
	EClass getOrganizationMember();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OrganizationFactory getOrganizationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationModelImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganizationModel()
		 * @generated
		 */
		EClass ORGANIZATION_MODEL = eINSTANCE.getOrganizationModel();

		/**
		 * The meta object literal for the '<em><b>Organization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORGANIZATION_MODEL__ORGANIZATION = eINSTANCE.getOrganizationModel_Organization();

		/**
		 * The meta object literal for the '<em><b>Organization Unit Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORGANIZATION_MODEL__ORGANIZATION_UNIT_TYPES = eINSTANCE.getOrganizationModel_OrganizationUnitTypes();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationImpl <em>Organization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganization()
		 * @generated
		 */
		EClass ORGANIZATION = eINSTANCE.getOrganization();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__NAME = eINSTANCE.getOrganization_Name();

		/**
		 * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__LONG_NAME = eINSTANCE.getOrganization_LongName();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__VERSION = eINSTANCE.getOrganization_Version();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__DESCRIPTION = eINSTANCE.getOrganization_Description();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORGANIZATION__ELEMENTS = eINSTANCE.getOrganization_Elements();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationUnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationUnitImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganizationUnit()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT = eINSTANCE.getOrganizationUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION_UNIT__NAME = eINSTANCE.getOrganizationUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORGANIZATION_UNIT__PARENT = eINSTANCE.getOrganizationUnit_Parent();

		/**
		 * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION_UNIT__LONG_NAME = eINSTANCE.getOrganizationUnit_LongName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION_UNIT__DESCRIPTION = eINSTANCE.getOrganizationUnit_Description();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORGANIZATION_UNIT__TYPES = eINSTANCE.getOrganizationUnit_Types();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationUnitTypeImpl <em>Unit Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationUnitTypeImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganizationUnitType()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT_TYPE = eINSTANCE.getOrganizationUnitType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION_UNIT_TYPE__NAME = eINSTANCE.getOrganizationUnitType_Name();

		/**
		 * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION_UNIT_TYPE__LONG_NAME = eINSTANCE.getOrganizationUnitType_LongName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION_UNIT_TYPE__DESCRIPTION = eINSTANCE.getOrganizationUnitType_Description();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.BusinessRoleImpl <em>Business Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.BusinessRoleImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getBusinessRole()
		 * @generated
		 */
		EClass BUSINESS_ROLE = eINSTANCE.getBusinessRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_ROLE__NAME = eINSTANCE.getBusinessRole_Name();

		/**
		 * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_ROLE__LONG_NAME = eINSTANCE.getBusinessRole_LongName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_ROLE__DESCRIPTION = eINSTANCE.getBusinessRole_Description();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.PersonImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FIRST_NAME = eINSTANCE.getPerson_FirstName();

		/**
		 * The meta object literal for the '<em><b>Middle Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__MIDDLE_NAME = eINSTANCE.getPerson_MiddleName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__LAST_NAME = eINSTANCE.getPerson_LastName();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__EMAIL = eINSTANCE.getPerson_Email();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.WorkerImpl <em>Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.WorkerImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getWorker()
		 * @generated
		 */
		EClass WORKER = eINSTANCE.getWorker();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKER__PERSON = eINSTANCE.getWorker_Person();

		/**
		 * The meta object literal for the '<em><b>Allocation Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKER__ALLOCATION_UNIT = eINSTANCE.getWorker_AllocationUnit();

		/**
		 * The meta object literal for the '<em><b>Play Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKER__PLAY_ROLES = eINSTANCE.getWorker_PlayRoles();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.GroupImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__LONG_NAME = eINSTANCE.getGroup_LongName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__DESCRIPTION = eINSTANCE.getGroup_Description();

		/**
		 * The meta object literal for the '<em><b>Workers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__WORKERS = eINSTANCE.getGroup_Workers();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.PartnershipImpl <em>Partnership</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.PartnershipImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getPartnership()
		 * @generated
		 */
		EClass PARTNERSHIP = eINSTANCE.getPartnership();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTNERSHIP__NAME = eINSTANCE.getPartnership_Name();

		/**
		 * The meta object literal for the '<em><b>Company</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTNERSHIP__COMPANY = eINSTANCE.getPartnership_Company();

		/**
		 * The meta object literal for the '<em><b>Responsible</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTNERSHIP__RESPONSIBLE = eINSTANCE.getPartnership_Responsible();

		/**
		 * The meta object literal for the '<em><b>Agreement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTNERSHIP__AGREEMENT = eINSTANCE.getPartnership_Agreement();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OrganizationMemberImpl <em>Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationMemberImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOrganizationMember()
		 * @generated
		 */
		EClass ORGANIZATION_MEMBER = eINSTANCE.getOrganizationMember();

	}

} //OrganizationPackage

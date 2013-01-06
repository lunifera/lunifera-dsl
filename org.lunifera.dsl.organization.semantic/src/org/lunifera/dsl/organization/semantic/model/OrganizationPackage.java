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
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.ONamed <em>ONamed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.ONamed
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getONamed()
	 * @generated
	 */
	int ONAMED = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONAMED__NAME = 0;

	/**
	 * The number of structural features of the '<em>ONamed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONAMED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.ODescribed <em>ODescribed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.ODescribed
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getODescribed()
	 * @generated
	 */
	int ODESCRIBED = 1;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODESCRIBED__LONG_NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODESCRIBED__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>ODescribed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODESCRIBED_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationModelImpl <em>OOrganization Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OOrganizationModelImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOOrganizationModel()
	 * @generated
	 */
	int OORGANIZATION_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Business Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION_MODEL__BUSINESS_ROLES = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION_MODEL__ROOT = 1;

	/**
	 * The number of structural features of the '<em>OOrganization Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OHierarchyRootImpl <em>OHierarchy Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OHierarchyRootImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOHierarchyRoot()
	 * @generated
	 */
	int OHIERARCHY_ROOT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OHIERARCHY_ROOT__NAME = ONAMED__NAME;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OHIERARCHY_ROOT__LONG_NAME = ONAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OHIERARCHY_ROOT__DESCRIPTION = ONAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Organizations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OHIERARCHY_ROOT__ORGANIZATIONS = ONAMED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>OHierarchy Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OHIERARCHY_ROOT_FEATURE_COUNT = ONAMED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationImpl <em>OOrganization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OOrganizationImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOOrganization()
	 * @generated
	 */
	int OORGANIZATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION__NAME = ONAMED__NAME;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION__LONG_NAME = ONAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION__DESCRIPTION = ONAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION__VERSION = ONAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION__ELEMENTS = ONAMED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>OOrganization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION_FEATURE_COUNT = ONAMED_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationMemberImpl <em>OOrganization Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OOrganizationMemberImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOOrganizationMember()
	 * @generated
	 */
	int OORGANIZATION_MEMBER = 12;

	/**
	 * The number of structural features of the '<em>OOrganization Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OORGANIZATION_MEMBER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OUnitImpl <em>OUnit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OUnitImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOUnit()
	 * @generated
	 */
	int OUNIT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT__NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT__LONG_NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT__DESCRIPTION = OORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT__PARENT = OORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Play Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT__PLAY_ROLES = OORGANIZATION_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>OUnit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT_FEATURE_COUNT = OORGANIZATION_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OBusinessRoleImpl <em>OBusiness Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OBusinessRoleImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOBusinessRole()
	 * @generated
	 */
	int OBUSINESS_ROLE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBUSINESS_ROLE__NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBUSINESS_ROLE__LONG_NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBUSINESS_ROLE__DESCRIPTION = OORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>OBusiness Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBUSINESS_ROLE_FEATURE_COUNT = OORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OPersonRoleImpl <em>OPerson Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OPersonRoleImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOPersonRole()
	 * @generated
	 */
	int OPERSON_ROLE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON_ROLE__NAME = OBUSINESS_ROLE__NAME;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON_ROLE__LONG_NAME = OBUSINESS_ROLE__LONG_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON_ROLE__DESCRIPTION = OBUSINESS_ROLE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>OPerson Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON_ROLE_FEATURE_COUNT = OBUSINESS_ROLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OUnitRoleImpl <em>OUnit Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OUnitRoleImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOUnitRole()
	 * @generated
	 */
	int OUNIT_ROLE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT_ROLE__NAME = OBUSINESS_ROLE__NAME;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT_ROLE__LONG_NAME = OBUSINESS_ROLE__LONG_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT_ROLE__DESCRIPTION = OBUSINESS_ROLE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>OUnit Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUNIT_ROLE_FEATURE_COUNT = OBUSINESS_ROLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OPersonImpl <em>OPerson</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OPersonImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOPerson()
	 * @generated
	 */
	int OPERSON = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON__NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON__FIRST_NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Middle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON__MIDDLE_NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON__LAST_NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON__EMAIL = OORGANIZATION_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>OPerson</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERSON_FEATURE_COUNT = OORGANIZATION_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OWorkerImpl <em>OWorker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OWorkerImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOWorker()
	 * @generated
	 */
	int OWORKER = 10;

	/**
	 * The feature id for the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWORKER__PERSON = OORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allocation Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWORKER__ALLOCATION_UNIT = OORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Play Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWORKER__PLAY_ROLES = OORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>OWorker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWORKER_FEATURE_COUNT = OORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OGroupImpl <em>OGroup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OGroupImpl
	 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOGroup()
	 * @generated
	 */
	int OGROUP = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OGROUP__NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OGROUP__LONG_NAME = OORGANIZATION_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OGROUP__DESCRIPTION = OORGANIZATION_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Workers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OGROUP__WORKERS = OORGANIZATION_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>OGroup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OGROUP_FEATURE_COUNT = OORGANIZATION_MEMBER_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.ONamed <em>ONamed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ONamed</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.ONamed
	 * @generated
	 */
	EClass getONamed();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.ONamed#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.ONamed#getName()
	 * @see #getONamed()
	 * @generated
	 */
	EAttribute getONamed_Name();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.ODescribed <em>ODescribed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ODescribed</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.ODescribed
	 * @generated
	 */
	EClass getODescribed();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.ODescribed#getLongName <em>Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.ODescribed#getLongName()
	 * @see #getODescribed()
	 * @generated
	 */
	EAttribute getODescribed_LongName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.ODescribed#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.ODescribed#getDescription()
	 * @see #getODescribed()
	 * @generated
	 */
	EAttribute getODescribed_Description();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OOrganizationModel <em>OOrganization Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OOrganization Model</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganizationModel
	 * @generated
	 */
	EClass getOOrganizationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.organization.semantic.model.OOrganizationModel#getBusinessRoles <em>Business Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Business Roles</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganizationModel#getBusinessRoles()
	 * @see #getOOrganizationModel()
	 * @generated
	 */
	EReference getOOrganizationModel_BusinessRoles();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.organization.semantic.model.OOrganizationModel#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganizationModel#getRoot()
	 * @see #getOOrganizationModel()
	 * @generated
	 */
	EReference getOOrganizationModel_Root();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OHierarchyRoot <em>OHierarchy Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OHierarchy Root</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OHierarchyRoot
	 * @generated
	 */
	EClass getOHierarchyRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.organization.semantic.model.OHierarchyRoot#getOrganizations <em>Organizations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Organizations</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OHierarchyRoot#getOrganizations()
	 * @see #getOHierarchyRoot()
	 * @generated
	 */
	EReference getOHierarchyRoot_Organizations();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OOrganization <em>OOrganization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OOrganization</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganization
	 * @generated
	 */
	EClass getOOrganization();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OOrganization#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganization#getVersion()
	 * @see #getOOrganization()
	 * @generated
	 */
	EAttribute getOOrganization_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.organization.semantic.model.OOrganization#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganization#getElements()
	 * @see #getOOrganization()
	 * @generated
	 */
	EReference getOOrganization_Elements();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OUnit <em>OUnit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OUnit</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OUnit
	 * @generated
	 */
	EClass getOUnit();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.organization.semantic.model.OUnit#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OUnit#getParent()
	 * @see #getOUnit()
	 * @generated
	 */
	EReference getOUnit_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.organization.semantic.model.OUnit#getPlayRoles <em>Play Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Play Roles</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OUnit#getPlayRoles()
	 * @see #getOUnit()
	 * @generated
	 */
	EReference getOUnit_PlayRoles();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OBusinessRole <em>OBusiness Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OBusiness Role</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OBusinessRole
	 * @generated
	 */
	EClass getOBusinessRole();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OPersonRole <em>OPerson Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OPerson Role</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OPersonRole
	 * @generated
	 */
	EClass getOPersonRole();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OUnitRole <em>OUnit Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OUnit Role</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OUnitRole
	 * @generated
	 */
	EClass getOUnitRole();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OPerson <em>OPerson</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OPerson</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OPerson
	 * @generated
	 */
	EClass getOPerson();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OPerson#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OPerson#getFirstName()
	 * @see #getOPerson()
	 * @generated
	 */
	EAttribute getOPerson_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OPerson#getMiddleName <em>Middle Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Middle Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OPerson#getMiddleName()
	 * @see #getOPerson()
	 * @generated
	 */
	EAttribute getOPerson_MiddleName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OPerson#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OPerson#getLastName()
	 * @see #getOPerson()
	 * @generated
	 */
	EAttribute getOPerson_LastName();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.organization.semantic.model.OPerson#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OPerson#getEmail()
	 * @see #getOPerson()
	 * @generated
	 */
	EAttribute getOPerson_Email();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OWorker <em>OWorker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OWorker</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OWorker
	 * @generated
	 */
	EClass getOWorker();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.organization.semantic.model.OWorker#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Person</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OWorker#getPerson()
	 * @see #getOWorker()
	 * @generated
	 */
	EReference getOWorker_Person();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.organization.semantic.model.OWorker#getAllocationUnit <em>Allocation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocation Unit</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OWorker#getAllocationUnit()
	 * @see #getOWorker()
	 * @generated
	 */
	EReference getOWorker_AllocationUnit();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.organization.semantic.model.OWorker#getPlayRoles <em>Play Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Play Roles</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OWorker#getPlayRoles()
	 * @see #getOWorker()
	 * @generated
	 */
	EReference getOWorker_PlayRoles();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OGroup <em>OGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OGroup</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OGroup
	 * @generated
	 */
	EClass getOGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.organization.semantic.model.OGroup#getWorkers <em>Workers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Workers</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OGroup#getWorkers()
	 * @see #getOGroup()
	 * @generated
	 */
	EReference getOGroup_Workers();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.organization.semantic.model.OOrganizationMember <em>OOrganization Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OOrganization Member</em>'.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganizationMember
	 * @generated
	 */
	EClass getOOrganizationMember();

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
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.ONamed <em>ONamed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.ONamed
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getONamed()
		 * @generated
		 */
		EClass ONAMED = eINSTANCE.getONamed();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ONAMED__NAME = eINSTANCE.getONamed_Name();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.ODescribed <em>ODescribed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.ODescribed
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getODescribed()
		 * @generated
		 */
		EClass ODESCRIBED = eINSTANCE.getODescribed();

		/**
		 * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ODESCRIBED__LONG_NAME = eINSTANCE.getODescribed_LongName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ODESCRIBED__DESCRIPTION = eINSTANCE.getODescribed_Description();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationModelImpl <em>OOrganization Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OOrganizationModelImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOOrganizationModel()
		 * @generated
		 */
		EClass OORGANIZATION_MODEL = eINSTANCE.getOOrganizationModel();

		/**
		 * The meta object literal for the '<em><b>Business Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OORGANIZATION_MODEL__BUSINESS_ROLES = eINSTANCE.getOOrganizationModel_BusinessRoles();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OORGANIZATION_MODEL__ROOT = eINSTANCE.getOOrganizationModel_Root();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OHierarchyRootImpl <em>OHierarchy Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OHierarchyRootImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOHierarchyRoot()
		 * @generated
		 */
		EClass OHIERARCHY_ROOT = eINSTANCE.getOHierarchyRoot();

		/**
		 * The meta object literal for the '<em><b>Organizations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OHIERARCHY_ROOT__ORGANIZATIONS = eINSTANCE.getOHierarchyRoot_Organizations();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationImpl <em>OOrganization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OOrganizationImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOOrganization()
		 * @generated
		 */
		EClass OORGANIZATION = eINSTANCE.getOOrganization();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OORGANIZATION__VERSION = eINSTANCE.getOOrganization_Version();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OORGANIZATION__ELEMENTS = eINSTANCE.getOOrganization_Elements();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OUnitImpl <em>OUnit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OUnitImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOUnit()
		 * @generated
		 */
		EClass OUNIT = eINSTANCE.getOUnit();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUNIT__PARENT = eINSTANCE.getOUnit_Parent();

		/**
		 * The meta object literal for the '<em><b>Play Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUNIT__PLAY_ROLES = eINSTANCE.getOUnit_PlayRoles();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OBusinessRoleImpl <em>OBusiness Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OBusinessRoleImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOBusinessRole()
		 * @generated
		 */
		EClass OBUSINESS_ROLE = eINSTANCE.getOBusinessRole();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OPersonRoleImpl <em>OPerson Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OPersonRoleImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOPersonRole()
		 * @generated
		 */
		EClass OPERSON_ROLE = eINSTANCE.getOPersonRole();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OUnitRoleImpl <em>OUnit Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OUnitRoleImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOUnitRole()
		 * @generated
		 */
		EClass OUNIT_ROLE = eINSTANCE.getOUnitRole();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OPersonImpl <em>OPerson</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OPersonImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOPerson()
		 * @generated
		 */
		EClass OPERSON = eINSTANCE.getOPerson();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERSON__FIRST_NAME = eINSTANCE.getOPerson_FirstName();

		/**
		 * The meta object literal for the '<em><b>Middle Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERSON__MIDDLE_NAME = eINSTANCE.getOPerson_MiddleName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERSON__LAST_NAME = eINSTANCE.getOPerson_LastName();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERSON__EMAIL = eINSTANCE.getOPerson_Email();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OWorkerImpl <em>OWorker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OWorkerImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOWorker()
		 * @generated
		 */
		EClass OWORKER = eINSTANCE.getOWorker();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OWORKER__PERSON = eINSTANCE.getOWorker_Person();

		/**
		 * The meta object literal for the '<em><b>Allocation Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OWORKER__ALLOCATION_UNIT = eINSTANCE.getOWorker_AllocationUnit();

		/**
		 * The meta object literal for the '<em><b>Play Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OWORKER__PLAY_ROLES = eINSTANCE.getOWorker_PlayRoles();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OGroupImpl <em>OGroup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OGroupImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOGroup()
		 * @generated
		 */
		EClass OGROUP = eINSTANCE.getOGroup();

		/**
		 * The meta object literal for the '<em><b>Workers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OGROUP__WORKERS = eINSTANCE.getOGroup_Workers();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.organization.semantic.model.impl.OOrganizationMemberImpl <em>OOrganization Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OOrganizationMemberImpl
		 * @see org.lunifera.dsl.organization.semantic.model.impl.OrganizationPackageImpl#getOOrganizationMember()
		 * @generated
		 */
		EClass OORGANIZATION_MEMBER = eINSTANCE.getOOrganizationMember();

	}

} //OrganizationPackage

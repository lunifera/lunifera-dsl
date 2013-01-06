/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.lunifera.dsl.organization.semantic.model.OBusinessRole;
import org.lunifera.dsl.organization.semantic.model.ODescribed;
import org.lunifera.dsl.organization.semantic.model.OGroup;
import org.lunifera.dsl.organization.semantic.model.OHierarchyRoot;
import org.lunifera.dsl.organization.semantic.model.ONamed;
import org.lunifera.dsl.organization.semantic.model.OOrganization;
import org.lunifera.dsl.organization.semantic.model.OOrganizationMember;
import org.lunifera.dsl.organization.semantic.model.OOrganizationModel;
import org.lunifera.dsl.organization.semantic.model.OPerson;
import org.lunifera.dsl.organization.semantic.model.OPersonRole;
import org.lunifera.dsl.organization.semantic.model.OUnit;
import org.lunifera.dsl.organization.semantic.model.OUnitRole;
import org.lunifera.dsl.organization.semantic.model.OWorker;
import org.lunifera.dsl.organization.semantic.model.OrganizationFactory;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrganizationPackageImpl extends EPackageImpl implements OrganizationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oNamedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oDescribedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oOrganizationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oHierarchyRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oOrganizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oBusinessRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oPersonRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oUnitRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oPersonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oWorkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oOrganizationMemberEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OrganizationPackageImpl() {
		super(eNS_URI, OrganizationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OrganizationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OrganizationPackage init() {
		if (isInited) return (OrganizationPackage)EPackage.Registry.INSTANCE.getEPackage(OrganizationPackage.eNS_URI);

		// Obtain or create and register package
		OrganizationPackageImpl theOrganizationPackage = (OrganizationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OrganizationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OrganizationPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theOrganizationPackage.createPackageContents();

		// Initialize created meta-data
		theOrganizationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOrganizationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OrganizationPackage.eNS_URI, theOrganizationPackage);
		return theOrganizationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getONamed() {
		return oNamedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getONamed_Name() {
		return (EAttribute)oNamedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getODescribed() {
		return oDescribedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getODescribed_LongName() {
		return (EAttribute)oDescribedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getODescribed_Description() {
		return (EAttribute)oDescribedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOOrganizationModel() {
		return oOrganizationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOOrganizationModel_BusinessRoles() {
		return (EReference)oOrganizationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOOrganizationModel_Root() {
		return (EReference)oOrganizationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOHierarchyRoot() {
		return oHierarchyRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOHierarchyRoot_Organizations() {
		return (EReference)oHierarchyRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOOrganization() {
		return oOrganizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOOrganization_Version() {
		return (EAttribute)oOrganizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOOrganization_Elements() {
		return (EReference)oOrganizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOUnit() {
		return oUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOUnit_Parent() {
		return (EReference)oUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOUnit_PlayRoles() {
		return (EReference)oUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOBusinessRole() {
		return oBusinessRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPersonRole() {
		return oPersonRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOUnitRole() {
		return oUnitRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPerson() {
		return oPersonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPerson_FirstName() {
		return (EAttribute)oPersonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPerson_MiddleName() {
		return (EAttribute)oPersonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPerson_LastName() {
		return (EAttribute)oPersonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPerson_Email() {
		return (EAttribute)oPersonEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOWorker() {
		return oWorkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOWorker_Person() {
		return (EReference)oWorkerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOWorker_AllocationUnit() {
		return (EReference)oWorkerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOWorker_PlayRoles() {
		return (EReference)oWorkerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOGroup() {
		return oGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOGroup_Workers() {
		return (EReference)oGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOOrganizationMember() {
		return oOrganizationMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationFactory getOrganizationFactory() {
		return (OrganizationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		oNamedEClass = createEClass(ONAMED);
		createEAttribute(oNamedEClass, ONAMED__NAME);

		oDescribedEClass = createEClass(ODESCRIBED);
		createEAttribute(oDescribedEClass, ODESCRIBED__LONG_NAME);
		createEAttribute(oDescribedEClass, ODESCRIBED__DESCRIPTION);

		oOrganizationModelEClass = createEClass(OORGANIZATION_MODEL);
		createEReference(oOrganizationModelEClass, OORGANIZATION_MODEL__BUSINESS_ROLES);
		createEReference(oOrganizationModelEClass, OORGANIZATION_MODEL__ROOT);

		oHierarchyRootEClass = createEClass(OHIERARCHY_ROOT);
		createEReference(oHierarchyRootEClass, OHIERARCHY_ROOT__ORGANIZATIONS);

		oOrganizationEClass = createEClass(OORGANIZATION);
		createEAttribute(oOrganizationEClass, OORGANIZATION__VERSION);
		createEReference(oOrganizationEClass, OORGANIZATION__ELEMENTS);

		oUnitEClass = createEClass(OUNIT);
		createEReference(oUnitEClass, OUNIT__PARENT);
		createEReference(oUnitEClass, OUNIT__PLAY_ROLES);

		oBusinessRoleEClass = createEClass(OBUSINESS_ROLE);

		oPersonRoleEClass = createEClass(OPERSON_ROLE);

		oUnitRoleEClass = createEClass(OUNIT_ROLE);

		oPersonEClass = createEClass(OPERSON);
		createEAttribute(oPersonEClass, OPERSON__FIRST_NAME);
		createEAttribute(oPersonEClass, OPERSON__MIDDLE_NAME);
		createEAttribute(oPersonEClass, OPERSON__LAST_NAME);
		createEAttribute(oPersonEClass, OPERSON__EMAIL);

		oWorkerEClass = createEClass(OWORKER);
		createEReference(oWorkerEClass, OWORKER__PERSON);
		createEReference(oWorkerEClass, OWORKER__ALLOCATION_UNIT);
		createEReference(oWorkerEClass, OWORKER__PLAY_ROLES);

		oGroupEClass = createEClass(OGROUP);
		createEReference(oGroupEClass, OGROUP__WORKERS);

		oOrganizationMemberEClass = createEClass(OORGANIZATION_MEMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		oHierarchyRootEClass.getESuperTypes().add(this.getONamed());
		oHierarchyRootEClass.getESuperTypes().add(this.getODescribed());
		oOrganizationEClass.getESuperTypes().add(this.getONamed());
		oOrganizationEClass.getESuperTypes().add(this.getODescribed());
		oUnitEClass.getESuperTypes().add(this.getOOrganizationMember());
		oUnitEClass.getESuperTypes().add(this.getONamed());
		oUnitEClass.getESuperTypes().add(this.getODescribed());
		oBusinessRoleEClass.getESuperTypes().add(this.getOOrganizationMember());
		oBusinessRoleEClass.getESuperTypes().add(this.getONamed());
		oBusinessRoleEClass.getESuperTypes().add(this.getODescribed());
		oPersonRoleEClass.getESuperTypes().add(this.getOBusinessRole());
		oUnitRoleEClass.getESuperTypes().add(this.getOBusinessRole());
		oPersonEClass.getESuperTypes().add(this.getOOrganizationMember());
		oPersonEClass.getESuperTypes().add(this.getONamed());
		oWorkerEClass.getESuperTypes().add(this.getOOrganizationMember());
		oGroupEClass.getESuperTypes().add(this.getOOrganizationMember());
		oGroupEClass.getESuperTypes().add(this.getONamed());
		oGroupEClass.getESuperTypes().add(this.getODescribed());

		// Initialize classes and features; add operations and parameters
		initEClass(oNamedEClass, ONamed.class, "ONamed", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getONamed_Name(), ecorePackage.getEString(), "name", null, 0, 1, ONamed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oDescribedEClass, ODescribed.class, "ODescribed", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getODescribed_LongName(), ecorePackage.getEString(), "longName", null, 0, 1, ODescribed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getODescribed_Description(), ecorePackage.getEString(), "description", null, 0, 1, ODescribed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oOrganizationModelEClass, OOrganizationModel.class, "OOrganizationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOOrganizationModel_BusinessRoles(), this.getOBusinessRole(), null, "businessRoles", null, 0, -1, OOrganizationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOOrganizationModel_Root(), this.getOHierarchyRoot(), null, "root", null, 0, 1, OOrganizationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(oOrganizationModelEClass, this.getOUnitRole(), "getUnitRoles", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(oOrganizationModelEClass, this.getOPersonRole(), "getPersonRoles", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(oHierarchyRootEClass, OHierarchyRoot.class, "OHierarchyRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOHierarchyRoot_Organizations(), this.getOOrganization(), null, "organizations", null, 0, -1, OHierarchyRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oOrganizationEClass, OOrganization.class, "OOrganization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOOrganization_Version(), ecorePackage.getEString(), "version", null, 0, 1, OOrganization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOOrganization_Elements(), this.getOOrganizationMember(), null, "elements", null, 0, -1, OOrganization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(oOrganizationEClass, this.getOUnit(), "getUnits", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(oOrganizationEClass, this.getOPerson(), "getPersons", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(oOrganizationEClass, this.getOWorker(), "getWorkers", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(oOrganizationEClass, this.getOGroup(), "getGroups", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(oUnitEClass, OUnit.class, "OUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOUnit_Parent(), this.getOUnit(), null, "parent", null, 0, 1, OUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOUnit_PlayRoles(), this.getOUnitRole(), null, "playRoles", null, 0, -1, OUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oBusinessRoleEClass, OBusinessRole.class, "OBusinessRole", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oPersonRoleEClass, OPersonRole.class, "OPersonRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oUnitRoleEClass, OUnitRole.class, "OUnitRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oPersonEClass, OPerson.class, "OPerson", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOPerson_FirstName(), ecorePackage.getEString(), "firstName", null, 0, 1, OPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOPerson_MiddleName(), ecorePackage.getEString(), "middleName", null, 0, 1, OPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOPerson_LastName(), ecorePackage.getEString(), "lastName", null, 0, 1, OPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOPerson_Email(), ecorePackage.getEString(), "email", null, 0, 1, OPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oWorkerEClass, OWorker.class, "OWorker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOWorker_Person(), this.getOPerson(), null, "person", null, 0, 1, OWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOWorker_AllocationUnit(), this.getOUnit(), null, "allocationUnit", null, 0, 1, OWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOWorker_PlayRoles(), this.getOPersonRole(), null, "playRoles", null, 0, -1, OWorker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oGroupEClass, OGroup.class, "OGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOGroup_Workers(), this.getOWorker(), null, "workers", null, 0, -1, OGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oOrganizationMemberEClass, OOrganizationMember.class, "OOrganizationMember", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OrganizationPackageImpl

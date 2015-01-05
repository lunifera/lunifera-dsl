/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
 * 
 *  Based on ideas from Xtext, Xtend, Xcore
 *    
 *  Contributors:  
 *  		Florian Pirchner - Initial implementation 
 *  
 */
package org.lunifera.dsl.semantic.service.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import org.lunifera.dsl.semantic.dto.LunDtoPackage;

import org.lunifera.dsl.semantic.service.LCardinality;
import org.lunifera.dsl.semantic.service.LChartService;
import org.lunifera.dsl.semantic.service.LDTOService;
import org.lunifera.dsl.semantic.service.LFilterableAttributes;
import org.lunifera.dsl.semantic.service.LFreeService;
import org.lunifera.dsl.semantic.service.LInjectedService;
import org.lunifera.dsl.semantic.service.LInjectedServices;
import org.lunifera.dsl.semantic.service.LService;
import org.lunifera.dsl.semantic.service.LServiceModel;
import org.lunifera.dsl.semantic.service.LServiceOperation;
import org.lunifera.dsl.semantic.service.LSortableAttributes;
import org.lunifera.dsl.semantic.service.LunServiceFactory;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LunServicePackageImpl extends EPackageImpl implements LunServicePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lServiceModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lInjectedServicesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lInjectedServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldtoServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lFilterableAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lSortableAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lChartServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lFreeServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lServiceOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lCardinalityEEnum = null;

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
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LunServicePackageImpl() {
		super(eNS_URI, LunServiceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LunServicePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LunServicePackage init() {
		if (isInited) return (LunServicePackage)EPackage.Registry.INSTANCE.getEPackage(LunServicePackage.eNS_URI);

		// Obtain or create and register package
		LunServicePackageImpl theLunServicePackage = (LunServicePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LunServicePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LunServicePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		LunDtoPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLunServicePackage.createPackageContents();

		// Initialize created meta-data
		theLunServicePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLunServicePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LunServicePackage.eNS_URI, theLunServicePackage);
		return theLunServicePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLServiceModel() {
		return lServiceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLServiceModel_Packages() {
		return (EReference)lServiceModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLService() {
		return lServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLService_InjectedServices() {
		return (EReference)lServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLService_Operations() {
		return (EReference)lServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLInjectedServices() {
		return lInjectedServicesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLInjectedServices_Services() {
		return (EReference)lInjectedServicesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLInjectedService() {
		return lInjectedServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLInjectedService_Cardinality() {
		return (EAttribute)lInjectedServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLInjectedService_AttributeName() {
		return (EAttribute)lInjectedServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLInjectedService_Service() {
		return (EReference)lInjectedServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLDTOService() {
		return ldtoServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLDTOService_Dto() {
		return (EReference)ldtoServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLDTOService_DtoJvm() {
		return (EReference)ldtoServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLDTOService_PersistenceId() {
		return (EAttribute)ldtoServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLDTOService_Filterable() {
		return (EReference)ldtoServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLDTOService_Sortable() {
		return (EReference)ldtoServiceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLFilterableAttributes() {
		return lFilterableAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLFilterableAttributes_Parent() {
		return (EReference)lFilterableAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLFilterableAttributes_FilterableFeatures() {
		return (EReference)lFilterableAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLSortableAttributes() {
		return lSortableAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLSortableAttributes_Parent() {
		return (EReference)lSortableAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLSortableAttributes_SortableFeatures() {
		return (EReference)lSortableAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLChartService() {
		return lChartServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLFreeService() {
		return lFreeServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLServiceOperation() {
		return lServiceOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLCardinality() {
		return lCardinalityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LunServiceFactory getLunServiceFactory() {
		return (LunServiceFactory)getEFactoryInstance();
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
		lServiceModelEClass = createEClass(LSERVICE_MODEL);
		createEReference(lServiceModelEClass, LSERVICE_MODEL__PACKAGES);

		lServiceEClass = createEClass(LSERVICE);
		createEReference(lServiceEClass, LSERVICE__INJECTED_SERVICES);
		createEReference(lServiceEClass, LSERVICE__OPERATIONS);

		lInjectedServicesEClass = createEClass(LINJECTED_SERVICES);
		createEReference(lInjectedServicesEClass, LINJECTED_SERVICES__SERVICES);

		lInjectedServiceEClass = createEClass(LINJECTED_SERVICE);
		createEAttribute(lInjectedServiceEClass, LINJECTED_SERVICE__CARDINALITY);
		createEAttribute(lInjectedServiceEClass, LINJECTED_SERVICE__ATTRIBUTE_NAME);
		createEReference(lInjectedServiceEClass, LINJECTED_SERVICE__SERVICE);

		ldtoServiceEClass = createEClass(LDTO_SERVICE);
		createEReference(ldtoServiceEClass, LDTO_SERVICE__DTO);
		createEReference(ldtoServiceEClass, LDTO_SERVICE__DTO_JVM);
		createEAttribute(ldtoServiceEClass, LDTO_SERVICE__PERSISTENCE_ID);
		createEReference(ldtoServiceEClass, LDTO_SERVICE__FILTERABLE);
		createEReference(ldtoServiceEClass, LDTO_SERVICE__SORTABLE);

		lFilterableAttributesEClass = createEClass(LFILTERABLE_ATTRIBUTES);
		createEReference(lFilterableAttributesEClass, LFILTERABLE_ATTRIBUTES__PARENT);
		createEReference(lFilterableAttributesEClass, LFILTERABLE_ATTRIBUTES__FILTERABLE_FEATURES);

		lSortableAttributesEClass = createEClass(LSORTABLE_ATTRIBUTES);
		createEReference(lSortableAttributesEClass, LSORTABLE_ATTRIBUTES__PARENT);
		createEReference(lSortableAttributesEClass, LSORTABLE_ATTRIBUTES__SORTABLE_FEATURES);

		lChartServiceEClass = createEClass(LCHART_SERVICE);

		lFreeServiceEClass = createEClass(LFREE_SERVICE);

		lServiceOperationEClass = createEClass(LSERVICE_OPERATION);

		// Create enums
		lCardinalityEEnum = createEEnum(LCARDINALITY);
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

		// Obtain other dependent packages
		LunTypesPackage theLunTypesPackage = (LunTypesPackage)EPackage.Registry.INSTANCE.getEPackage(LunTypesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		LunDtoPackage theLunDtoPackage = (LunDtoPackage)EPackage.Registry.INSTANCE.getEPackage(LunDtoPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		lServiceModelEClass.getESuperTypes().add(theLunTypesPackage.getLLazyResolver());
		lServiceEClass.getESuperTypes().add(theLunTypesPackage.getLClass());
		lInjectedServicesEClass.getESuperTypes().add(theLunTypesPackage.getLLazyResolver());
		lInjectedServiceEClass.getESuperTypes().add(theLunTypesPackage.getLLazyResolver());
		ldtoServiceEClass.getESuperTypes().add(this.getLService());
		lFilterableAttributesEClass.getESuperTypes().add(theLunTypesPackage.getLLazyResolver());
		lSortableAttributesEClass.getESuperTypes().add(theLunTypesPackage.getLLazyResolver());
		lChartServiceEClass.getESuperTypes().add(this.getLService());
		lFreeServiceEClass.getESuperTypes().add(this.getLService());
		lServiceOperationEClass.getESuperTypes().add(theLunTypesPackage.getLOperation());
		lServiceOperationEClass.getESuperTypes().add(theLunDtoPackage.getLDtoFeature());

		// Initialize classes and features; add operations and parameters
		initEClass(lServiceModelEClass, LServiceModel.class, "LServiceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLServiceModel_Packages(), theLunTypesPackage.getLTypedPackage(), null, "packages", null, 0, -1, LServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lServiceEClass, LService.class, "LService", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLService_InjectedServices(), this.getLInjectedServices(), null, "injectedServices", null, 0, 1, LService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLService_Operations(), this.getLServiceOperation(), null, "operations", null, 0, -1, LService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lInjectedServicesEClass, LInjectedServices.class, "LInjectedServices", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLInjectedServices_Services(), this.getLInjectedService(), null, "services", null, 0, -1, LInjectedServices.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lInjectedServiceEClass, LInjectedService.class, "LInjectedService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLInjectedService_Cardinality(), this.getLCardinality(), "cardinality", null, 0, 1, LInjectedService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLInjectedService_AttributeName(), theEcorePackage.getEString(), "attributeName", null, 0, 1, LInjectedService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLInjectedService_Service(), theTypesPackage.getJvmTypeReference(), null, "service", null, 0, 1, LInjectedService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ldtoServiceEClass, LDTOService.class, "LDTOService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLDTOService_Dto(), theLunDtoPackage.getLDto(), null, "dto", null, 0, 1, LDTOService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLDTOService_DtoJvm(), theTypesPackage.getJvmTypeReference(), null, "dtoJvm", null, 0, 1, LDTOService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLDTOService_PersistenceId(), theEcorePackage.getEString(), "persistenceId", null, 0, 1, LDTOService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLDTOService_Filterable(), this.getLFilterableAttributes(), this.getLFilterableAttributes_Parent(), "filterable", null, 0, 1, LDTOService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLDTOService_Sortable(), this.getLSortableAttributes(), this.getLSortableAttributes_Parent(), "sortable", null, 0, 1, LDTOService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lFilterableAttributesEClass, LFilterableAttributes.class, "LFilterableAttributes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLFilterableAttributes_Parent(), this.getLDTOService(), this.getLDTOService_Filterable(), "parent", null, 0, 1, LFilterableAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLFilterableAttributes_FilterableFeatures(), theLunDtoPackage.getLDtoFeature(), null, "filterableFeatures", null, 0, -1, LFilterableAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lSortableAttributesEClass, LSortableAttributes.class, "LSortableAttributes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLSortableAttributes_Parent(), this.getLDTOService(), this.getLDTOService_Sortable(), "parent", null, 0, 1, LSortableAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLSortableAttributes_SortableFeatures(), theLunDtoPackage.getLDtoFeature(), null, "sortableFeatures", null, 0, -1, LSortableAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lChartServiceEClass, LChartService.class, "LChartService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lFreeServiceEClass, LFreeService.class, "LFreeService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lServiceOperationEClass, LServiceOperation.class, "LServiceOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(lCardinalityEEnum, LCardinality.class, "LCardinality");
		addEEnumLiteral(lCardinalityEEnum, LCardinality.ZERO_TO_ONE);
		addEEnumLiteral(lCardinalityEEnum, LCardinality.ONE_TO_ONE);
		addEEnumLiteral(lCardinalityEEnum, LCardinality.ZERO_TO_MANY);
		addEEnumLiteral(lCardinalityEEnum, LCardinality.ONE_TO_MANY);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "rootPackage", "services"
		   });
	}

} //LunServicePackageImpl

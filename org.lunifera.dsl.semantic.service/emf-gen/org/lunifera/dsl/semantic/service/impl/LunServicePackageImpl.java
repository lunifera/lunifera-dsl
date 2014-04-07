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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import org.lunifera.dsl.semantic.dto.LunDtoPackage;

import org.lunifera.dsl.semantic.service.LChartService;
import org.lunifera.dsl.semantic.service.LDTOService;
import org.lunifera.dsl.semantic.service.LFreeService;
import org.lunifera.dsl.semantic.service.LService;
import org.lunifera.dsl.semantic.service.LServiceModel;
import org.lunifera.dsl.semantic.service.LSupportedDTO;
import org.lunifera.dsl.semantic.service.LSupportedDTOCollection;
import org.lunifera.dsl.semantic.service.LSupportedFilters;
import org.lunifera.dsl.semantic.service.LunServiceFactory;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LunServicePackageImpl extends EPackageImpl implements LunServicePackage
{
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
  private EClass ldtoServiceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lSupportedDTOCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lSupportedDTOEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lSupportedFiltersEClass = null;

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
  private LunServicePackageImpl()
  {
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
  public static LunServicePackage init()
  {
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
  public EClass getLServiceModel()
  {
    return lServiceModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLServiceModel_Packages()
  {
    return (EReference)lServiceModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLService()
  {
    return lServiceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDTOService()
  {
    return ldtoServiceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDTOService_PrimaryDTO()
  {
    return (EReference)ldtoServiceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDTOService_SupportedDTOs()
  {
    return (EReference)ldtoServiceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLSupportedDTOCollection()
  {
    return lSupportedDTOCollectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLSupportedDTOCollection_Service()
  {
    return (EReference)lSupportedDTOCollectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLSupportedDTOCollection_SupportedDtos()
  {
    return (EReference)lSupportedDTOCollectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLSupportedDTO()
  {
    return lSupportedDTOEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLSupportedDTO_Parent()
  {
    return (EReference)lSupportedDTOEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLSupportedDTO_Dto()
  {
    return (EReference)lSupportedDTOEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLSupportedDTO_Filters()
  {
    return (EReference)lSupportedDTOEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLSupportedFilters()
  {
    return lSupportedFiltersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLSupportedFilters_Parent()
  {
    return (EReference)lSupportedFiltersEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLSupportedFilters_FilterFeatures()
  {
    return (EReference)lSupportedFiltersEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLChartService()
  {
    return lChartServiceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLFreeService()
  {
    return lFreeServiceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LunServiceFactory getLunServiceFactory()
  {
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    lServiceModelEClass = createEClass(LSERVICE_MODEL);
    createEReference(lServiceModelEClass, LSERVICE_MODEL__PACKAGES);

    lServiceEClass = createEClass(LSERVICE);

    ldtoServiceEClass = createEClass(LDTO_SERVICE);
    createEReference(ldtoServiceEClass, LDTO_SERVICE__PRIMARY_DTO);
    createEReference(ldtoServiceEClass, LDTO_SERVICE__SUPPORTED_DT_OS);

    lSupportedDTOCollectionEClass = createEClass(LSUPPORTED_DTO_COLLECTION);
    createEReference(lSupportedDTOCollectionEClass, LSUPPORTED_DTO_COLLECTION__SERVICE);
    createEReference(lSupportedDTOCollectionEClass, LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS);

    lSupportedDTOEClass = createEClass(LSUPPORTED_DTO);
    createEReference(lSupportedDTOEClass, LSUPPORTED_DTO__PARENT);
    createEReference(lSupportedDTOEClass, LSUPPORTED_DTO__DTO);
    createEReference(lSupportedDTOEClass, LSUPPORTED_DTO__FILTERS);

    lSupportedFiltersEClass = createEClass(LSUPPORTED_FILTERS);
    createEReference(lSupportedFiltersEClass, LSUPPORTED_FILTERS__PARENT);
    createEReference(lSupportedFiltersEClass, LSUPPORTED_FILTERS__FILTER_FEATURES);

    lChartServiceEClass = createEClass(LCHART_SERVICE);

    lFreeServiceEClass = createEClass(LFREE_SERVICE);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    LunTypesPackage theLunTypesPackage = (LunTypesPackage)EPackage.Registry.INSTANCE.getEPackage(LunTypesPackage.eNS_URI);
    LunDtoPackage theLunDtoPackage = (LunDtoPackage)EPackage.Registry.INSTANCE.getEPackage(LunDtoPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    lServiceEClass.getESuperTypes().add(theLunTypesPackage.getLClass());
    lServiceEClass.getESuperTypes().add(theLunTypesPackage.getLFeaturesHolder());
    ldtoServiceEClass.getESuperTypes().add(this.getLService());
    lChartServiceEClass.getESuperTypes().add(this.getLService());
    lFreeServiceEClass.getESuperTypes().add(this.getLService());

    // Initialize classes and features; add operations and parameters
    initEClass(lServiceModelEClass, LServiceModel.class, "LServiceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLServiceModel_Packages(), theLunTypesPackage.getLTypedPackage(), null, "packages", null, 0, -1, LServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lServiceEClass, LService.class, "LService", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ldtoServiceEClass, LDTOService.class, "LDTOService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLDTOService_PrimaryDTO(), theLunDtoPackage.getLDto(), null, "primaryDTO", null, 0, 1, LDTOService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLDTOService_SupportedDTOs(), this.getLSupportedDTOCollection(), this.getLSupportedDTOCollection_Service(), "supportedDTOs", null, 0, 1, LDTOService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lSupportedDTOCollectionEClass, LSupportedDTOCollection.class, "LSupportedDTOCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLSupportedDTOCollection_Service(), this.getLDTOService(), this.getLDTOService_SupportedDTOs(), "service", null, 0, 1, LSupportedDTOCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLSupportedDTOCollection_SupportedDtos(), this.getLSupportedDTO(), this.getLSupportedDTO_Parent(), "supportedDtos", null, 0, -1, LSupportedDTOCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lSupportedDTOEClass, LSupportedDTO.class, "LSupportedDTO", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLSupportedDTO_Parent(), this.getLSupportedDTOCollection(), this.getLSupportedDTOCollection_SupportedDtos(), "parent", null, 0, 1, LSupportedDTO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLSupportedDTO_Dto(), theLunDtoPackage.getLDto(), null, "dto", null, 0, 1, LSupportedDTO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLSupportedDTO_Filters(), this.getLSupportedFilters(), this.getLSupportedFilters_Parent(), "filters", null, 0, 1, LSupportedDTO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lSupportedFiltersEClass, LSupportedFilters.class, "LSupportedFilters", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLSupportedFilters_Parent(), this.getLSupportedDTO(), this.getLSupportedDTO_Filters(), "parent", null, 0, 1, LSupportedFilters.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLSupportedFilters_FilterFeatures(), theLunDtoPackage.getLDtoFeature(), null, "filterFeatures", null, 0, -1, LSupportedFilters.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lChartServiceEClass, LChartService.class, "LChartService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lFreeServiceEClass, LFreeService.class, "LFreeService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
  protected void createEcoreAnnotations()
  {
    String source = "http://www.eclipse.org/emf/2002/Ecore";			
    addAnnotation
      (this, 
       source, 
       new String[] 
       {
       "rootPackage", "services"
       });
  }

} //LunServicePackageImpl

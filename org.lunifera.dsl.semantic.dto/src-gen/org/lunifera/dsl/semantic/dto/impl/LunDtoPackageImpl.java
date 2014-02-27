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
package org.lunifera.dsl.semantic.dto.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.xbase.XbasePackage;

import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute;
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference;
import org.lunifera.dsl.semantic.dto.LDtoAttribute;
import org.lunifera.dsl.semantic.dto.LDtoFeature;
import org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute;
import org.lunifera.dsl.semantic.dto.LDtoInheritedReference;
import org.lunifera.dsl.semantic.dto.LDtoMapper;
import org.lunifera.dsl.semantic.dto.LDtoModel;
import org.lunifera.dsl.semantic.dto.LDtoOperation;
import org.lunifera.dsl.semantic.dto.LDtoReference;
import org.lunifera.dsl.semantic.dto.LunDtoFactory;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LunDtoPackageImpl extends EPackageImpl implements LunDtoPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoMapperEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoFeatureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoAbstractAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoInheritedAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoAbstractReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoInheritedReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lDtoOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType dtoFeatureListEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType operationsListEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType dtoReferenceListEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType dtoAttributeListEDataType = null;

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
   * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private LunDtoPackageImpl()
  {
    super(eNS_URI, LunDtoFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link LunDtoPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static LunDtoPackage init()
  {
    if (isInited) return (LunDtoPackage)EPackage.Registry.INSTANCE.getEPackage(LunDtoPackage.eNS_URI);

    // Obtain or create and register package
    LunDtoPackageImpl theLunDtoPackage = (LunDtoPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LunDtoPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LunDtoPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    LunTypesPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theLunDtoPackage.createPackageContents();

    // Initialize created meta-data
    theLunDtoPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theLunDtoPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(LunDtoPackage.eNS_URI, theLunDtoPackage);
    return theLunDtoPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoModel()
  {
    return lDtoModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDtoModel_Packages()
  {
    return (EReference)lDtoModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDto()
  {
    return lDtoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDto_Features()
  {
    return (EReference)lDtoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDto_SuperType()
  {
    return (EReference)lDtoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDto_SubTypes()
  {
    return (EReference)lDtoEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDto_WrappedType()
  {
    return (EReference)lDtoEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoMapper()
  {
    return lDtoMapperEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDtoMapper_ToDTO()
  {
    return (EReference)lDtoMapperEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDtoMapper_FromDTO()
  {
    return (EReference)lDtoMapperEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoFeature()
  {
    return lDtoFeatureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDtoFeature_Mapper()
  {
    return (EReference)lDtoFeatureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoAbstractAttribute()
  {
    return lDtoAbstractAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoInheritedAttribute()
  {
    return lDtoInheritedAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDtoInheritedAttribute_InheritedFeature()
  {
    return (EReference)lDtoInheritedAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoAttribute()
  {
    return lDtoAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoAbstractReference()
  {
    return lDtoAbstractReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDtoAbstractReference_Type()
  {
    return (EReference)lDtoAbstractReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoInheritedReference()
  {
    return lDtoInheritedReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDtoInheritedReference_InheritedFeature()
  {
    return (EReference)lDtoInheritedReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoReference()
  {
    return lDtoReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLDtoReference_Opposite()
  {
    return (EReference)lDtoReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLDtoOperation()
  {
    return lDtoOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getDtoFeatureList()
  {
    return dtoFeatureListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getOperationsList()
  {
    return operationsListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getDtoReferenceList()
  {
    return dtoReferenceListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getDtoAttributeList()
  {
    return dtoAttributeListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LunDtoFactory getLunDtoFactory()
  {
    return (LunDtoFactory)getEFactoryInstance();
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
    lDtoModelEClass = createEClass(LDTO_MODEL);
    createEReference(lDtoModelEClass, LDTO_MODEL__PACKAGES);

    lDtoEClass = createEClass(LDTO);
    createEReference(lDtoEClass, LDTO__FEATURES);
    createEReference(lDtoEClass, LDTO__SUPER_TYPE);
    createEReference(lDtoEClass, LDTO__SUB_TYPES);
    createEReference(lDtoEClass, LDTO__WRAPPED_TYPE);

    lDtoMapperEClass = createEClass(LDTO_MAPPER);
    createEReference(lDtoMapperEClass, LDTO_MAPPER__TO_DTO);
    createEReference(lDtoMapperEClass, LDTO_MAPPER__FROM_DTO);

    lDtoFeatureEClass = createEClass(LDTO_FEATURE);
    createEReference(lDtoFeatureEClass, LDTO_FEATURE__MAPPER);

    lDtoAbstractAttributeEClass = createEClass(LDTO_ABSTRACT_ATTRIBUTE);

    lDtoInheritedAttributeEClass = createEClass(LDTO_INHERITED_ATTRIBUTE);
    createEReference(lDtoInheritedAttributeEClass, LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE);

    lDtoAttributeEClass = createEClass(LDTO_ATTRIBUTE);

    lDtoAbstractReferenceEClass = createEClass(LDTO_ABSTRACT_REFERENCE);
    createEReference(lDtoAbstractReferenceEClass, LDTO_ABSTRACT_REFERENCE__TYPE);

    lDtoInheritedReferenceEClass = createEClass(LDTO_INHERITED_REFERENCE);
    createEReference(lDtoInheritedReferenceEClass, LDTO_INHERITED_REFERENCE__INHERITED_FEATURE);

    lDtoReferenceEClass = createEClass(LDTO_REFERENCE);
    createEReference(lDtoReferenceEClass, LDTO_REFERENCE__OPPOSITE);

    lDtoOperationEClass = createEClass(LDTO_OPERATION);

    // Create data types
    dtoFeatureListEDataType = createEDataType(DTO_FEATURE_LIST);
    operationsListEDataType = createEDataType(OPERATIONS_LIST);
    dtoReferenceListEDataType = createEDataType(DTO_REFERENCE_LIST);
    dtoAttributeListEDataType = createEDataType(DTO_ATTRIBUTE_LIST);
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
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    lDtoEClass.getESuperTypes().add(theLunTypesPackage.getLClass());
    lDtoEClass.getESuperTypes().add(theLunTypesPackage.getLFeaturesHolder());
    lDtoEClass.getESuperTypes().add(theLunTypesPackage.getLScalarType());
    lDtoFeatureEClass.getESuperTypes().add(theLunTypesPackage.getLFeature());
    lDtoAbstractAttributeEClass.getESuperTypes().add(this.getLDtoFeature());
    lDtoAbstractAttributeEClass.getESuperTypes().add(theLunTypesPackage.getLAttribute());
    lDtoInheritedAttributeEClass.getESuperTypes().add(this.getLDtoAbstractAttribute());
    lDtoAttributeEClass.getESuperTypes().add(this.getLDtoAbstractAttribute());
    lDtoAbstractReferenceEClass.getESuperTypes().add(this.getLDtoFeature());
    lDtoAbstractReferenceEClass.getESuperTypes().add(theLunTypesPackage.getLReference());
    lDtoInheritedReferenceEClass.getESuperTypes().add(this.getLDtoAbstractReference());
    lDtoReferenceEClass.getESuperTypes().add(this.getLDtoAbstractReference());
    lDtoOperationEClass.getESuperTypes().add(theLunTypesPackage.getLOperation());
    lDtoOperationEClass.getESuperTypes().add(this.getLDtoFeature());

    // Initialize classes and features; add operations and parameters
    initEClass(lDtoModelEClass, LDtoModel.class, "LDtoModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLDtoModel_Packages(), theLunTypesPackage.getLTypedPackage(), null, "packages", null, 0, -1, LDtoModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lDtoEClass, LDto.class, "LDto", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLDto_Features(), this.getLDtoFeature(), null, "features", null, 0, -1, LDto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLDto_SuperType(), this.getLDto(), this.getLDto_SubTypes(), "superType", null, 0, 1, LDto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLDto_SubTypes(), this.getLDto(), this.getLDto_SuperType(), "subTypes", null, 0, -1, LDto.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLDto_WrappedType(), theLunTypesPackage.getLType(), null, "wrappedType", null, 0, 1, LDto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(lDtoEClass, this.getOperationsList(), "getOperations", 0, 1, !IS_UNIQUE, IS_ORDERED);

    addEOperation(lDtoEClass, this.getDtoReferenceList(), "getReferences", 0, 1, !IS_UNIQUE, IS_ORDERED);

    addEOperation(lDtoEClass, this.getDtoAttributeList(), "getAttributes", 0, 1, !IS_UNIQUE, IS_ORDERED);

    addEOperation(lDtoEClass, theLunTypesPackage.getFeaturesList(), "getAllFeatures", 0, 1, !IS_UNIQUE, IS_ORDERED);

    EOperation op = addEOperation(lDtoEClass, null, "collectAllLunFeatures", 0, 1, !IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getLDto(), "current", 0, 1, !IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getDtoFeatureList(), "result", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(lDtoMapperEClass, LDtoMapper.class, "LDtoMapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLDtoMapper_ToDTO(), theXbasePackage.getXExpression(), null, "toDTO", null, 0, 1, LDtoMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLDtoMapper_FromDTO(), theXbasePackage.getXExpression(), null, "fromDTO", null, 0, 1, LDtoMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lDtoFeatureEClass, LDtoFeature.class, "LDtoFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLDtoFeature_Mapper(), this.getLDtoMapper(), null, "mapper", null, 0, 1, LDtoFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(lDtoFeatureEClass, this.getLDto(), "getDTO", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(lDtoAbstractAttributeEClass, LDtoAbstractAttribute.class, "LDtoAbstractAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lDtoInheritedAttributeEClass, LDtoInheritedAttribute.class, "LDtoInheritedAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLDtoInheritedAttribute_InheritedFeature(), theLunTypesPackage.getLAttribute(), null, "inheritedFeature", null, 0, 1, LDtoInheritedAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(lDtoInheritedAttributeEClass, theLunTypesPackage.getLScalarType(), "getInheritedType", 0, 1, !IS_UNIQUE, IS_ORDERED);

    addEOperation(lDtoInheritedAttributeEClass, theLunTypesPackage.getLMultiplicity(), "getInheritedMultiplicity", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(lDtoAttributeEClass, LDtoAttribute.class, "LDtoAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lDtoAbstractReferenceEClass, LDtoAbstractReference.class, "LDtoAbstractReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLDtoAbstractReference_Type(), this.getLDto(), null, "type", null, 0, 1, LDtoAbstractReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lDtoInheritedReferenceEClass, LDtoInheritedReference.class, "LDtoInheritedReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLDtoInheritedReference_InheritedFeature(), theLunTypesPackage.getLReference(), null, "inheritedFeature", null, 0, 1, LDtoInheritedReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(lDtoInheritedReferenceEClass, theLunTypesPackage.getLMultiplicity(), "getInheritedMultiplicity", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(lDtoReferenceEClass, LDtoReference.class, "LDtoReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLDtoReference_Opposite(), this.getLDtoReference(), null, "opposite", null, 0, 1, LDtoReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lDtoOperationEClass, LDtoOperation.class, "LDtoOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize data types
    initEDataType(dtoFeatureListEDataType, List.class, "DtoFeatureList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.dto.LDtoFeature>");
    initEDataType(operationsListEDataType, List.class, "OperationsList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.dto.LDtoOperation>");
    initEDataType(dtoReferenceListEDataType, List.class, "DtoReferenceList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.dto.LDtoReference>");
    initEDataType(dtoAttributeListEDataType, List.class, "DtoAttributeList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.dto.LDtoAttribute>");

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
       "rootPackage", "dto"
       });										
  }

} //LunDtoPackageImpl

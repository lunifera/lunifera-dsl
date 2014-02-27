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
package org.lunifera.dsl.semantic.entity.impl;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanAttribute;
import org.lunifera.dsl.semantic.entity.LBeanFeature;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LDiscriminatorType;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo;
import org.lunifera.dsl.semantic.entity.LEntityFeature;
import org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy;
import org.lunifera.dsl.semantic.entity.LEntityModel;
import org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo;
import org.lunifera.dsl.semantic.entity.LEntityReference;
import org.lunifera.dsl.semantic.entity.LIndex;
import org.lunifera.dsl.semantic.entity.LOperation;
import org.lunifera.dsl.semantic.entity.LTablePerClassStrategy;
import org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy;
import org.lunifera.dsl.semantic.entity.LunEntityFactory;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LunEntityPackageImpl extends EPackageImpl implements LunEntityPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lEntityModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lBeanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lEntityPersistenceInfoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lEntityColumnPersistenceInfoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lEntityInheritanceStrategyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lTablePerClassStrategyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lTablePerSubclassStrategyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lEntityFeatureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lEntityAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lEntityReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lBeanFeatureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lBeanAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lBeanReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lIndexEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum lDiscriminatorTypeEEnum = null;

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
  private EDataType entityFeatureListEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType entityReferenceListEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType entityAttributeListEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType beanFeatureListEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType beanReferenceListEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType beanAttributeListEDataType = null;

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
   * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private LunEntityPackageImpl()
  {
    super(eNS_URI, LunEntityFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link LunEntityPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static LunEntityPackage init()
  {
    if (isInited) return (LunEntityPackage)EPackage.Registry.INSTANCE.getEPackage(LunEntityPackage.eNS_URI);

    // Obtain or create and register package
    LunEntityPackageImpl theLunEntityPackage = (LunEntityPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LunEntityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LunEntityPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    LunTypesPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theLunEntityPackage.createPackageContents();

    // Initialize created meta-data
    theLunEntityPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theLunEntityPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(LunEntityPackage.eNS_URI, theLunEntityPackage);
    return theLunEntityPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLEntityModel()
  {
    return lEntityModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntityModel_Packages()
  {
    return (EReference)lEntityModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLBean()
  {
    return lBeanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLBean_Features()
  {
    return (EReference)lBeanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLBean_SuperType()
  {
    return (EReference)lBeanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLBean_SubTypes()
  {
    return (EReference)lBeanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLBean__GetOperations()
  {
    return lBeanEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLBean__GetReferences()
  {
    return lBeanEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLBean__GetAttributes()
  {
    return lBeanEClass.getEOperations().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLBean__GetAllFeatures()
  {
    return lBeanEClass.getEOperations().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLBean__GetAllAttributes()
  {
    return lBeanEClass.getEOperations().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLBean__GetAllReferences()
  {
    return lBeanEClass.getEOperations().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLBean__CollectAllLunFeatures__LBean_List()
  {
    return lBeanEClass.getEOperations().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLEntity()
  {
    return lEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLEntity_Cacheable()
  {
    return (EAttribute)lEntityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLEntity_Historized()
  {
    return (EAttribute)lEntityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLEntity_Timedependent()
  {
    return (EAttribute)lEntityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLEntity_TimedependentDateType()
  {
    return (EAttribute)lEntityEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLEntity_MappedSuperclass()
  {
    return (EAttribute)lEntityEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntity_PersistenceInfo()
  {
    return (EReference)lEntityEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntity_InheritanceStrategy()
  {
    return (EReference)lEntityEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntity_Features()
  {
    return (EReference)lEntityEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntity_Indexes()
  {
    return (EReference)lEntityEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntity_SuperType()
  {
    return (EReference)lEntityEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntity_SubTypes()
  {
    return (EReference)lEntityEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLEntity__GetOperations()
  {
    return lEntityEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLEntity__GetReferences()
  {
    return lEntityEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLEntity__GetAttributes()
  {
    return lEntityEClass.getEOperations().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLEntity__GetAllFeatures()
  {
    return lEntityEClass.getEOperations().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLEntity__GetAllAttributes()
  {
    return lEntityEClass.getEOperations().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLEntity__GetAllReferences()
  {
    return lEntityEClass.getEOperations().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLEntity__CollectAllLunFeatures__LEntity_List()
  {
    return lEntityEClass.getEOperations().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLEntityPersistenceInfo()
  {
    return lEntityPersistenceInfoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLEntityPersistenceInfo_SchemaName()
  {
    return (EAttribute)lEntityPersistenceInfoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLEntityPersistenceInfo_TableName()
  {
    return (EAttribute)lEntityPersistenceInfoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLEntityColumnPersistenceInfo()
  {
    return lEntityColumnPersistenceInfoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLEntityColumnPersistenceInfo_ColumnName()
  {
    return (EAttribute)lEntityColumnPersistenceInfoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLEntityInheritanceStrategy()
  {
    return lEntityInheritanceStrategyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLTablePerClassStrategy()
  {
    return lTablePerClassStrategyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLTablePerClassStrategy_DiscriminatorColumn()
  {
    return (EAttribute)lTablePerClassStrategyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLTablePerClassStrategy_DiscriminatorType()
  {
    return (EAttribute)lTablePerClassStrategyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLTablePerClassStrategy_DiscriminatorValue()
  {
    return (EAttribute)lTablePerClassStrategyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLTablePerSubclassStrategy()
  {
    return lTablePerSubclassStrategyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLTablePerSubclassStrategy_DiscriminatorColumn()
  {
    return (EAttribute)lTablePerSubclassStrategyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLTablePerSubclassStrategy_DiscriminatorType()
  {
    return (EAttribute)lTablePerSubclassStrategyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLTablePerSubclassStrategy_DiscriminatorValue()
  {
    return (EAttribute)lTablePerSubclassStrategyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLEntityFeature()
  {
    return lEntityFeatureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntityFeature_PersistenceInfo()
  {
    return (EReference)lEntityFeatureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLEntityFeature__GetEntity()
  {
    return lEntityFeatureEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLEntityAttribute()
  {
    return lEntityAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLEntityReference()
  {
    return lEntityReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntityReference_Type()
  {
    return (EReference)lEntityReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLEntityReference_Opposite()
  {
    return (EReference)lEntityReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLBeanFeature()
  {
    return lBeanFeatureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getLBeanFeature__GetBean()
  {
    return lBeanFeatureEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLBeanAttribute()
  {
    return lBeanAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLBeanReference()
  {
    return lBeanReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLBeanReference_Type()
  {
    return (EReference)lBeanReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLBeanReference_Opposite()
  {
    return (EReference)lBeanReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLIndex()
  {
    return lIndexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLIndex_Unique()
  {
    return (EAttribute)lIndexEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLIndex_Name()
  {
    return (EAttribute)lIndexEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLIndex_Features()
  {
    return (EReference)lIndexEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLOperation()
  {
    return lOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getLDiscriminatorType()
  {
    return lDiscriminatorTypeEEnum;
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
  public EDataType getEntityFeatureList()
  {
    return entityFeatureListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getEntityReferenceList()
  {
    return entityReferenceListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getEntityAttributeList()
  {
    return entityAttributeListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getBeanFeatureList()
  {
    return beanFeatureListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getBeanReferenceList()
  {
    return beanReferenceListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getBeanAttributeList()
  {
    return beanAttributeListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LunEntityFactory getLunEntityFactory()
  {
    return (LunEntityFactory)getEFactoryInstance();
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
    lEntityModelEClass = createEClass(LENTITY_MODEL);
    createEReference(lEntityModelEClass, LENTITY_MODEL__PACKAGES);

    lBeanEClass = createEClass(LBEAN);
    createEReference(lBeanEClass, LBEAN__FEATURES);
    createEReference(lBeanEClass, LBEAN__SUPER_TYPE);
    createEReference(lBeanEClass, LBEAN__SUB_TYPES);
    createEOperation(lBeanEClass, LBEAN___GET_OPERATIONS);
    createEOperation(lBeanEClass, LBEAN___GET_REFERENCES);
    createEOperation(lBeanEClass, LBEAN___GET_ATTRIBUTES);
    createEOperation(lBeanEClass, LBEAN___GET_ALL_FEATURES);
    createEOperation(lBeanEClass, LBEAN___GET_ALL_ATTRIBUTES);
    createEOperation(lBeanEClass, LBEAN___GET_ALL_REFERENCES);
    createEOperation(lBeanEClass, LBEAN___COLLECT_ALL_LUN_FEATURES__LBEAN_LIST);

    lEntityEClass = createEClass(LENTITY);
    createEAttribute(lEntityEClass, LENTITY__CACHEABLE);
    createEAttribute(lEntityEClass, LENTITY__HISTORIZED);
    createEAttribute(lEntityEClass, LENTITY__TIMEDEPENDENT);
    createEAttribute(lEntityEClass, LENTITY__TIMEDEPENDENT_DATE_TYPE);
    createEAttribute(lEntityEClass, LENTITY__MAPPED_SUPERCLASS);
    createEReference(lEntityEClass, LENTITY__PERSISTENCE_INFO);
    createEReference(lEntityEClass, LENTITY__INHERITANCE_STRATEGY);
    createEReference(lEntityEClass, LENTITY__FEATURES);
    createEReference(lEntityEClass, LENTITY__INDEXES);
    createEReference(lEntityEClass, LENTITY__SUPER_TYPE);
    createEReference(lEntityEClass, LENTITY__SUB_TYPES);
    createEOperation(lEntityEClass, LENTITY___GET_OPERATIONS);
    createEOperation(lEntityEClass, LENTITY___GET_REFERENCES);
    createEOperation(lEntityEClass, LENTITY___GET_ATTRIBUTES);
    createEOperation(lEntityEClass, LENTITY___GET_ALL_FEATURES);
    createEOperation(lEntityEClass, LENTITY___GET_ALL_ATTRIBUTES);
    createEOperation(lEntityEClass, LENTITY___GET_ALL_REFERENCES);
    createEOperation(lEntityEClass, LENTITY___COLLECT_ALL_LUN_FEATURES__LENTITY_LIST);

    lEntityPersistenceInfoEClass = createEClass(LENTITY_PERSISTENCE_INFO);
    createEAttribute(lEntityPersistenceInfoEClass, LENTITY_PERSISTENCE_INFO__SCHEMA_NAME);
    createEAttribute(lEntityPersistenceInfoEClass, LENTITY_PERSISTENCE_INFO__TABLE_NAME);

    lEntityColumnPersistenceInfoEClass = createEClass(LENTITY_COLUMN_PERSISTENCE_INFO);
    createEAttribute(lEntityColumnPersistenceInfoEClass, LENTITY_COLUMN_PERSISTENCE_INFO__COLUMN_NAME);

    lEntityInheritanceStrategyEClass = createEClass(LENTITY_INHERITANCE_STRATEGY);

    lTablePerClassStrategyEClass = createEClass(LTABLE_PER_CLASS_STRATEGY);
    createEAttribute(lTablePerClassStrategyEClass, LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_COLUMN);
    createEAttribute(lTablePerClassStrategyEClass, LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_TYPE);
    createEAttribute(lTablePerClassStrategyEClass, LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_VALUE);

    lTablePerSubclassStrategyEClass = createEClass(LTABLE_PER_SUBCLASS_STRATEGY);
    createEAttribute(lTablePerSubclassStrategyEClass, LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_COLUMN);
    createEAttribute(lTablePerSubclassStrategyEClass, LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_TYPE);
    createEAttribute(lTablePerSubclassStrategyEClass, LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_VALUE);

    lEntityFeatureEClass = createEClass(LENTITY_FEATURE);
    createEReference(lEntityFeatureEClass, LENTITY_FEATURE__PERSISTENCE_INFO);
    createEOperation(lEntityFeatureEClass, LENTITY_FEATURE___GET_ENTITY);

    lEntityAttributeEClass = createEClass(LENTITY_ATTRIBUTE);

    lEntityReferenceEClass = createEClass(LENTITY_REFERENCE);
    createEReference(lEntityReferenceEClass, LENTITY_REFERENCE__TYPE);
    createEReference(lEntityReferenceEClass, LENTITY_REFERENCE__OPPOSITE);

    lBeanFeatureEClass = createEClass(LBEAN_FEATURE);
    createEOperation(lBeanFeatureEClass, LBEAN_FEATURE___GET_BEAN);

    lBeanAttributeEClass = createEClass(LBEAN_ATTRIBUTE);

    lBeanReferenceEClass = createEClass(LBEAN_REFERENCE);
    createEReference(lBeanReferenceEClass, LBEAN_REFERENCE__TYPE);
    createEReference(lBeanReferenceEClass, LBEAN_REFERENCE__OPPOSITE);

    lIndexEClass = createEClass(LINDEX);
    createEAttribute(lIndexEClass, LINDEX__UNIQUE);
    createEAttribute(lIndexEClass, LINDEX__NAME);
    createEReference(lIndexEClass, LINDEX__FEATURES);

    lOperationEClass = createEClass(LOPERATION);

    // Create enums
    lDiscriminatorTypeEEnum = createEEnum(LDISCRIMINATOR_TYPE);

    // Create data types
    operationsListEDataType = createEDataType(OPERATIONS_LIST);
    entityFeatureListEDataType = createEDataType(ENTITY_FEATURE_LIST);
    entityReferenceListEDataType = createEDataType(ENTITY_REFERENCE_LIST);
    entityAttributeListEDataType = createEDataType(ENTITY_ATTRIBUTE_LIST);
    beanFeatureListEDataType = createEDataType(BEAN_FEATURE_LIST);
    beanReferenceListEDataType = createEDataType(BEAN_REFERENCE_LIST);
    beanAttributeListEDataType = createEDataType(BEAN_ATTRIBUTE_LIST);
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
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    lBeanEClass.getESuperTypes().add(theLunTypesPackage.getLClass());
    lBeanEClass.getESuperTypes().add(theLunTypesPackage.getLScalarType());
    lBeanEClass.getESuperTypes().add(theLunTypesPackage.getLFeaturesHolder());
    lEntityEClass.getESuperTypes().add(theLunTypesPackage.getLClass());
    lEntityEClass.getESuperTypes().add(theLunTypesPackage.getLFeaturesHolder());
    lTablePerClassStrategyEClass.getESuperTypes().add(this.getLEntityInheritanceStrategy());
    lTablePerSubclassStrategyEClass.getESuperTypes().add(this.getLEntityInheritanceStrategy());
    lEntityFeatureEClass.getESuperTypes().add(theLunTypesPackage.getLFeature());
    lEntityAttributeEClass.getESuperTypes().add(this.getLEntityFeature());
    lEntityAttributeEClass.getESuperTypes().add(theLunTypesPackage.getLAttribute());
    lEntityReferenceEClass.getESuperTypes().add(this.getLEntityFeature());
    lEntityReferenceEClass.getESuperTypes().add(theLunTypesPackage.getLReference());
    lBeanFeatureEClass.getESuperTypes().add(theLunTypesPackage.getLFeature());
    lBeanAttributeEClass.getESuperTypes().add(this.getLBeanFeature());
    lBeanAttributeEClass.getESuperTypes().add(theLunTypesPackage.getLAttribute());
    lBeanReferenceEClass.getESuperTypes().add(this.getLBeanFeature());
    lBeanReferenceEClass.getESuperTypes().add(theLunTypesPackage.getLReference());
    lOperationEClass.getESuperTypes().add(theLunTypesPackage.getLOperation());
    lOperationEClass.getESuperTypes().add(this.getLBeanFeature());
    lOperationEClass.getESuperTypes().add(this.getLEntityFeature());

    // Initialize classes, features, and operations; add parameters
    initEClass(lEntityModelEClass, LEntityModel.class, "LEntityModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLEntityModel_Packages(), theLunTypesPackage.getLTypedPackage(), null, "packages", null, 0, -1, LEntityModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lBeanEClass, LBean.class, "LBean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLBean_Features(), this.getLBeanFeature(), null, "features", null, 0, -1, LBean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLBean_SuperType(), this.getLBean(), this.getLBean_SubTypes(), "superType", null, 0, 1, LBean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLBean_SubTypes(), this.getLBean(), this.getLBean_SuperType(), "subTypes", null, 0, -1, LBean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getLBean__GetOperations(), this.getOperationsList(), "getOperations", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLBean__GetReferences(), this.getBeanReferenceList(), "getReferences", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLBean__GetAttributes(), this.getBeanAttributeList(), "getAttributes", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLBean__GetAllFeatures(), this.getBeanFeatureList(), "getAllFeatures", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLBean__GetAllAttributes(), this.getBeanAttributeList(), "getAllAttributes", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLBean__GetAllReferences(), this.getBeanReferenceList(), "getAllReferences", 0, 1, !IS_UNIQUE, IS_ORDERED);

    EOperation op = initEOperation(getLBean__CollectAllLunFeatures__LBean_List(), null, "collectAllLunFeatures", 0, 1, !IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getLBean(), "current", 0, 1, !IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getBeanFeatureList(), "result", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(lEntityEClass, LEntity.class, "LEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLEntity_Cacheable(), theEcorePackage.getEBoolean(), "cacheable", null, 0, 1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLEntity_Historized(), theEcorePackage.getEBoolean(), "historized", null, 0, 1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLEntity_Timedependent(), theEcorePackage.getEBoolean(), "timedependent", null, 0, 1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLEntity_TimedependentDateType(), theLunTypesPackage.getLDateType(), "timedependentDateType", null, 0, 1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLEntity_MappedSuperclass(), theEcorePackage.getEBoolean(), "mappedSuperclass", null, 0, 1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLEntity_PersistenceInfo(), this.getLEntityPersistenceInfo(), null, "persistenceInfo", null, 0, 1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLEntity_InheritanceStrategy(), this.getLEntityInheritanceStrategy(), null, "inheritanceStrategy", null, 0, 1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLEntity_Features(), this.getLEntityFeature(), null, "features", null, 0, -1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLEntity_Indexes(), this.getLIndex(), null, "indexes", null, 0, -1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLEntity_SuperType(), this.getLEntity(), this.getLEntity_SubTypes(), "superType", null, 0, 1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLEntity_SubTypes(), this.getLEntity(), this.getLEntity_SuperType(), "subTypes", null, 0, -1, LEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getLEntity__GetOperations(), this.getOperationsList(), "getOperations", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLEntity__GetReferences(), this.getEntityReferenceList(), "getReferences", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLEntity__GetAttributes(), this.getEntityAttributeList(), "getAttributes", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLEntity__GetAllFeatures(), this.getEntityFeatureList(), "getAllFeatures", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLEntity__GetAllAttributes(), this.getEntityAttributeList(), "getAllAttributes", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEOperation(getLEntity__GetAllReferences(), this.getEntityReferenceList(), "getAllReferences", 0, 1, !IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getLEntity__CollectAllLunFeatures__LEntity_List(), null, "collectAllLunFeatures", 0, 1, !IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getLEntity(), "current", 0, 1, !IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getEntityFeatureList(), "result", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(lEntityPersistenceInfoEClass, LEntityPersistenceInfo.class, "LEntityPersistenceInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLEntityPersistenceInfo_SchemaName(), theEcorePackage.getEString(), "schemaName", null, 0, 1, LEntityPersistenceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLEntityPersistenceInfo_TableName(), theEcorePackage.getEString(), "tableName", null, 0, 1, LEntityPersistenceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lEntityColumnPersistenceInfoEClass, LEntityColumnPersistenceInfo.class, "LEntityColumnPersistenceInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLEntityColumnPersistenceInfo_ColumnName(), theEcorePackage.getEString(), "columnName", null, 0, 1, LEntityColumnPersistenceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lEntityInheritanceStrategyEClass, LEntityInheritanceStrategy.class, "LEntityInheritanceStrategy", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lTablePerClassStrategyEClass, LTablePerClassStrategy.class, "LTablePerClassStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLTablePerClassStrategy_DiscriminatorColumn(), theEcorePackage.getEString(), "discriminatorColumn", null, 0, 1, LTablePerClassStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLTablePerClassStrategy_DiscriminatorType(), this.getLDiscriminatorType(), "discriminatorType", null, 0, 1, LTablePerClassStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLTablePerClassStrategy_DiscriminatorValue(), theEcorePackage.getEString(), "discriminatorValue", null, 0, 1, LTablePerClassStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lTablePerSubclassStrategyEClass, LTablePerSubclassStrategy.class, "LTablePerSubclassStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLTablePerSubclassStrategy_DiscriminatorColumn(), theEcorePackage.getEString(), "discriminatorColumn", null, 0, 1, LTablePerSubclassStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLTablePerSubclassStrategy_DiscriminatorType(), this.getLDiscriminatorType(), "discriminatorType", null, 0, 1, LTablePerSubclassStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLTablePerSubclassStrategy_DiscriminatorValue(), theEcorePackage.getEString(), "discriminatorValue", null, 0, 1, LTablePerSubclassStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lEntityFeatureEClass, LEntityFeature.class, "LEntityFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLEntityFeature_PersistenceInfo(), this.getLEntityColumnPersistenceInfo(), null, "persistenceInfo", null, 0, 1, LEntityFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getLEntityFeature__GetEntity(), this.getLEntity(), "getEntity", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(lEntityAttributeEClass, LEntityAttribute.class, "LEntityAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lEntityReferenceEClass, LEntityReference.class, "LEntityReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLEntityReference_Type(), this.getLEntity(), null, "type", null, 0, 1, LEntityReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLEntityReference_Opposite(), this.getLEntityReference(), null, "opposite", null, 0, 1, LEntityReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lBeanFeatureEClass, LBeanFeature.class, "LBeanFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getLBeanFeature__GetBean(), this.getLBean(), "getBean", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(lBeanAttributeEClass, LBeanAttribute.class, "LBeanAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lBeanReferenceEClass, LBeanReference.class, "LBeanReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLBeanReference_Type(), this.getLBean(), null, "type", null, 0, 1, LBeanReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLBeanReference_Opposite(), this.getLBeanReference(), null, "opposite", null, 0, 1, LBeanReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lIndexEClass, LIndex.class, "LIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLIndex_Unique(), theEcorePackage.getEBoolean(), "unique", null, 0, 1, LIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLIndex_Name(), theEcorePackage.getEString(), "name", null, 0, 1, LIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLIndex_Features(), this.getLEntityFeature(), null, "features", null, 0, -1, LIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lOperationEClass, LOperation.class, "LOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(lDiscriminatorTypeEEnum, LDiscriminatorType.class, "LDiscriminatorType");
    addEEnumLiteral(lDiscriminatorTypeEEnum, LDiscriminatorType.INHERIT);
    addEEnumLiteral(lDiscriminatorTypeEEnum, LDiscriminatorType.STRING);
    addEEnumLiteral(lDiscriminatorTypeEEnum, LDiscriminatorType.CHAR);
    addEEnumLiteral(lDiscriminatorTypeEEnum, LDiscriminatorType.INTEGER);

    // Initialize data types
    initEDataType(operationsListEDataType, List.class, "OperationsList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.entity.LOperation>");
    initEDataType(entityFeatureListEDataType, List.class, "EntityFeatureList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.entity.LEntityFeature>");
    initEDataType(entityReferenceListEDataType, List.class, "EntityReferenceList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.entity.LEntityReference>");
    initEDataType(entityAttributeListEDataType, List.class, "EntityAttributeList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.entity.LEntityAttribute>");
    initEDataType(beanFeatureListEDataType, List.class, "BeanFeatureList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.entity.LBeanFeature>");
    initEDataType(beanReferenceListEDataType, List.class, "BeanReferenceList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.entity.LBeanReference>");
    initEDataType(beanAttributeListEDataType, List.class, "BeanAttributeList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.entity.LBeanAttribute>");

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
       "rootPackage", "entity"
       });																			
  }

} //LunEntityPackageImpl

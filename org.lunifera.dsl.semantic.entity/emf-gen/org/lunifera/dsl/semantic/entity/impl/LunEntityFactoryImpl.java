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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.lunifera.dsl.semantic.entity.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LunEntityFactoryImpl extends EFactoryImpl implements LunEntityFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LunEntityFactory init()
  {
    try
    {
      LunEntityFactory theLunEntityFactory = (LunEntityFactory)EPackage.Registry.INSTANCE.getEFactory(LunEntityPackage.eNS_URI);
      if (theLunEntityFactory != null)
      {
        return theLunEntityFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LunEntityFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LunEntityFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case LunEntityPackage.LENTITY_MODEL: return createLEntityModel();
      case LunEntityPackage.LBEAN: return createLBean();
      case LunEntityPackage.LENTITY: return createLEntity();
      case LunEntityPackage.LENTITY_PERSISTENCE_INFO: return createLEntityPersistenceInfo();
      case LunEntityPackage.LENTITY_COLUMN_PERSISTENCE_INFO: return createLEntityColumnPersistenceInfo();
      case LunEntityPackage.LTABLE_PER_CLASS_STRATEGY: return createLTablePerClassStrategy();
      case LunEntityPackage.LTABLE_PER_SUBCLASS_STRATEGY: return createLTablePerSubclassStrategy();
      case LunEntityPackage.LENTITY_FEATURE: return createLEntityFeature();
      case LunEntityPackage.LENTITY_ATTRIBUTE: return createLEntityAttribute();
      case LunEntityPackage.LENTITY_REFERENCE: return createLEntityReference();
      case LunEntityPackage.LBEAN_FEATURE: return createLBeanFeature();
      case LunEntityPackage.LBEAN_ATTRIBUTE: return createLBeanAttribute();
      case LunEntityPackage.LBEAN_REFERENCE: return createLBeanReference();
      case LunEntityPackage.LINDEX: return createLIndex();
      case LunEntityPackage.LOPERATION: return createLOperation();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case LunEntityPackage.LDISCRIMINATOR_TYPE:
        return createLDiscriminatorTypeFromString(eDataType, initialValue);
      case LunEntityPackage.OPERATIONS_LIST:
        return createOperationsListFromString(eDataType, initialValue);
      case LunEntityPackage.ENTITY_FEATURE_LIST:
        return createEntityFeatureListFromString(eDataType, initialValue);
      case LunEntityPackage.ENTITY_REFERENCE_LIST:
        return createEntityReferenceListFromString(eDataType, initialValue);
      case LunEntityPackage.ENTITY_ATTRIBUTE_LIST:
        return createEntityAttributeListFromString(eDataType, initialValue);
      case LunEntityPackage.BEAN_FEATURE_LIST:
        return createBeanFeatureListFromString(eDataType, initialValue);
      case LunEntityPackage.BEAN_REFERENCE_LIST:
        return createBeanReferenceListFromString(eDataType, initialValue);
      case LunEntityPackage.BEAN_ATTRIBUTE_LIST:
        return createBeanAttributeListFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case LunEntityPackage.LDISCRIMINATOR_TYPE:
        return convertLDiscriminatorTypeToString(eDataType, instanceValue);
      case LunEntityPackage.OPERATIONS_LIST:
        return convertOperationsListToString(eDataType, instanceValue);
      case LunEntityPackage.ENTITY_FEATURE_LIST:
        return convertEntityFeatureListToString(eDataType, instanceValue);
      case LunEntityPackage.ENTITY_REFERENCE_LIST:
        return convertEntityReferenceListToString(eDataType, instanceValue);
      case LunEntityPackage.ENTITY_ATTRIBUTE_LIST:
        return convertEntityAttributeListToString(eDataType, instanceValue);
      case LunEntityPackage.BEAN_FEATURE_LIST:
        return convertBeanFeatureListToString(eDataType, instanceValue);
      case LunEntityPackage.BEAN_REFERENCE_LIST:
        return convertBeanReferenceListToString(eDataType, instanceValue);
      case LunEntityPackage.BEAN_ATTRIBUTE_LIST:
        return convertBeanAttributeListToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntityModel createLEntityModel()
  {
    LEntityModelImpl lEntityModel = new LEntityModelImpl();
    return lEntityModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LBean createLBean()
  {
    LBeanImpl lBean = new LBeanImpl();
    return lBean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntity createLEntity()
  {
    LEntityImpl lEntity = new LEntityImpl();
    return lEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntityPersistenceInfo createLEntityPersistenceInfo()
  {
    LEntityPersistenceInfoImpl lEntityPersistenceInfo = new LEntityPersistenceInfoImpl();
    return lEntityPersistenceInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntityColumnPersistenceInfo createLEntityColumnPersistenceInfo()
  {
    LEntityColumnPersistenceInfoImpl lEntityColumnPersistenceInfo = new LEntityColumnPersistenceInfoImpl();
    return lEntityColumnPersistenceInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LTablePerClassStrategy createLTablePerClassStrategy()
  {
    LTablePerClassStrategyImpl lTablePerClassStrategy = new LTablePerClassStrategyImpl();
    return lTablePerClassStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LTablePerSubclassStrategy createLTablePerSubclassStrategy()
  {
    LTablePerSubclassStrategyImpl lTablePerSubclassStrategy = new LTablePerSubclassStrategyImpl();
    return lTablePerSubclassStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntityFeature createLEntityFeature()
  {
    LEntityFeatureImpl lEntityFeature = new LEntityFeatureImpl();
    return lEntityFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntityAttribute createLEntityAttribute()
  {
    LEntityAttributeImpl lEntityAttribute = new LEntityAttributeImpl();
    return lEntityAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntityReference createLEntityReference()
  {
    LEntityReferenceImpl lEntityReference = new LEntityReferenceImpl();
    return lEntityReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LBeanFeature createLBeanFeature()
  {
    LBeanFeatureImpl lBeanFeature = new LBeanFeatureImpl();
    return lBeanFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LBeanAttribute createLBeanAttribute()
  {
    LBeanAttributeImpl lBeanAttribute = new LBeanAttributeImpl();
    return lBeanAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LBeanReference createLBeanReference()
  {
    LBeanReferenceImpl lBeanReference = new LBeanReferenceImpl();
    return lBeanReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LIndex createLIndex()
  {
    LIndexImpl lIndex = new LIndexImpl();
    return lIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LOperation createLOperation()
  {
    LOperationImpl lOperation = new LOperationImpl();
    return lOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDiscriminatorType createLDiscriminatorTypeFromString(EDataType eDataType, String initialValue)
  {
    LDiscriminatorType result = LDiscriminatorType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLDiscriminatorTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public List<LOperation> createOperationsListFromString(EDataType eDataType, String initialValue)
  {
    return (List<LOperation>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOperationsListToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public List<LEntityFeature> createEntityFeatureListFromString(EDataType eDataType, String initialValue)
  {
    return (List<LEntityFeature>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEntityFeatureListToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public List<LEntityReference> createEntityReferenceListFromString(EDataType eDataType, String initialValue)
  {
    return (List<LEntityReference>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEntityReferenceListToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public List<LEntityAttribute> createEntityAttributeListFromString(EDataType eDataType, String initialValue)
  {
    return (List<LEntityAttribute>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEntityAttributeListToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public List<LBeanFeature> createBeanFeatureListFromString(EDataType eDataType, String initialValue)
  {
    return (List<LBeanFeature>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBeanFeatureListToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public List<LBeanReference> createBeanReferenceListFromString(EDataType eDataType, String initialValue)
  {
    return (List<LBeanReference>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBeanReferenceListToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public List<LBeanAttribute> createBeanAttributeListFromString(EDataType eDataType, String initialValue)
  {
    return (List<LBeanAttribute>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBeanAttributeListToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LunEntityPackage getLunEntityPackage()
  {
    return (LunEntityPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LunEntityPackage getPackage()
  {
    return LunEntityPackage.eINSTANCE;
  }

} //LunEntityFactoryImpl

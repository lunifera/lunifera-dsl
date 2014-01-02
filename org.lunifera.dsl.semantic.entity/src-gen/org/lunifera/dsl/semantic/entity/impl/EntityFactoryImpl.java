/**
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
public class EntityFactoryImpl extends EFactoryImpl implements EntityFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EntityFactory init()
  {
    try
    {
      EntityFactory theEntityFactory = (EntityFactory)EPackage.Registry.INSTANCE.getEFactory(EntityPackage.eNS_URI);
      if (theEntityFactory != null)
      {
        return theEntityFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EntityFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntityFactoryImpl()
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
      case EntityPackage.LENTITY_MODEL: return createLEntityModel();
      case EntityPackage.LBEAN: return createLBean();
      case EntityPackage.LENTITY: return createLEntity();
      case EntityPackage.LENTITY_PERSISTENCE_INFO: return createLEntityPersistenceInfo();
      case EntityPackage.LENTITY_COLUMN_PERSISTENCE_INFO: return createLEntityColumnPersistenceInfo();
      case EntityPackage.LTABLE_PER_CLASS_STRATEGY: return createLTablePerClassStrategy();
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY: return createLTablePerSubclassStrategy();
      case EntityPackage.LENTITY_FEATURE: return createLEntityFeature();
      case EntityPackage.LENTITY_ATTRIBUTE: return createLEntityAttribute();
      case EntityPackage.LENTITY_REFERENCE: return createLEntityReference();
      case EntityPackage.LBEAN_FEATURE: return createLBeanFeature();
      case EntityPackage.LBEAN_ATTRIBUTE: return createLBeanAttribute();
      case EntityPackage.LBEAN_REFERENCE: return createLBeanReference();
      case EntityPackage.LE_OPERATION: return createLEOperation();
      case EntityPackage.LINDEX: return createLIndex();
      case EntityPackage.LOPERATION: return createLOperation();
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
      case EntityPackage.LDISCRIMINATOR_TYPE:
        return createLDiscriminatorTypeFromString(eDataType, initialValue);
      case EntityPackage.OPERATIONS_LIST:
        return createOperationsListFromString(eDataType, initialValue);
      case EntityPackage.ENTITY_FEATURE_LIST:
        return createEntityFeatureListFromString(eDataType, initialValue);
      case EntityPackage.ENTITY_REFERENCE_LIST:
        return createEntityReferenceListFromString(eDataType, initialValue);
      case EntityPackage.ENTITY_ATTRIBUTE_LIST:
        return createEntityAttributeListFromString(eDataType, initialValue);
      case EntityPackage.BEAN_FEATURE_LIST:
        return createBeanFeatureListFromString(eDataType, initialValue);
      case EntityPackage.BEAN_REFERENCE_LIST:
        return createBeanReferenceListFromString(eDataType, initialValue);
      case EntityPackage.BEAN_ATTRIBUTE_LIST:
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
      case EntityPackage.LDISCRIMINATOR_TYPE:
        return convertLDiscriminatorTypeToString(eDataType, instanceValue);
      case EntityPackage.OPERATIONS_LIST:
        return convertOperationsListToString(eDataType, instanceValue);
      case EntityPackage.ENTITY_FEATURE_LIST:
        return convertEntityFeatureListToString(eDataType, instanceValue);
      case EntityPackage.ENTITY_REFERENCE_LIST:
        return convertEntityReferenceListToString(eDataType, instanceValue);
      case EntityPackage.ENTITY_ATTRIBUTE_LIST:
        return convertEntityAttributeListToString(eDataType, instanceValue);
      case EntityPackage.BEAN_FEATURE_LIST:
        return convertBeanFeatureListToString(eDataType, instanceValue);
      case EntityPackage.BEAN_REFERENCE_LIST:
        return convertBeanReferenceListToString(eDataType, instanceValue);
      case EntityPackage.BEAN_ATTRIBUTE_LIST:
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
  public LEOperation createLEOperation()
  {
    LEOperationImpl leOperation = new LEOperationImpl();
    return leOperation;
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
  public List<LEOperation> createOperationsListFromString(EDataType eDataType, String initialValue)
  {
    return (List<LEOperation>)super.createFromString(initialValue);
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
  public EntityPackage getEntityPackage()
  {
    return (EntityPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EntityPackage getPackage()
  {
    return EntityPackage.eINSTANCE;
  }

} //EntityFactoryImpl

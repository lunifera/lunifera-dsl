/**
 */
package org.lunifera.dsl.semantic.entity.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.lunifera.dsl.semantic.common.types.LAnnotationTarget;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LFeaturesHolder;
import org.lunifera.dsl.semantic.common.types.LReference;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.common.types.LType;

import org.lunifera.dsl.semantic.entity.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.entity.EntityPackage
 * @generated
 */
public class EntityAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EntityPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntityAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = EntityPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntitySwitch<Adapter> modelSwitch =
    new EntitySwitch<Adapter>()
    {
      @Override
      public Adapter caseLEntityModel(LEntityModel object)
      {
        return createLEntityModelAdapter();
      }
      @Override
      public Adapter caseLBean(LBean object)
      {
        return createLBeanAdapter();
      }
      @Override
      public Adapter caseLEntity(LEntity object)
      {
        return createLEntityAdapter();
      }
      @Override
      public Adapter caseLEntityPersistenceInfo(LEntityPersistenceInfo object)
      {
        return createLEntityPersistenceInfoAdapter();
      }
      @Override
      public Adapter caseLEntityColumnPersistenceInfo(LEntityColumnPersistenceInfo object)
      {
        return createLEntityColumnPersistenceInfoAdapter();
      }
      @Override
      public Adapter caseLEntityInheritanceStrategy(LEntityInheritanceStrategy object)
      {
        return createLEntityInheritanceStrategyAdapter();
      }
      @Override
      public Adapter caseLTablePerClassStrategy(LTablePerClassStrategy object)
      {
        return createLTablePerClassStrategyAdapter();
      }
      @Override
      public Adapter caseLTablePerSubclassStrategy(LTablePerSubclassStrategy object)
      {
        return createLTablePerSubclassStrategyAdapter();
      }
      @Override
      public Adapter caseLEntityFeature(LEntityFeature object)
      {
        return createLEntityFeatureAdapter();
      }
      @Override
      public Adapter caseLEntityAttribute(LEntityAttribute object)
      {
        return createLEntityAttributeAdapter();
      }
      @Override
      public Adapter caseLEntityReference(LEntityReference object)
      {
        return createLEntityReferenceAdapter();
      }
      @Override
      public Adapter caseLBeanFeature(LBeanFeature object)
      {
        return createLBeanFeatureAdapter();
      }
      @Override
      public Adapter caseLBeanAttribute(LBeanAttribute object)
      {
        return createLBeanAttributeAdapter();
      }
      @Override
      public Adapter caseLBeanReference(LBeanReference object)
      {
        return createLBeanReferenceAdapter();
      }
      @Override
      public Adapter caseLIndex(LIndex object)
      {
        return createLIndexAdapter();
      }
      @Override
      public Adapter caseLOperation(LOperation object)
      {
        return createLOperationAdapter();
      }
      @Override
      public Adapter caseLAnnotationTarget(LAnnotationTarget object)
      {
        return createLAnnotationTargetAdapter();
      }
      @Override
      public Adapter caseLType(LType object)
      {
        return createLTypeAdapter();
      }
      @Override
      public Adapter caseLClass(LClass object)
      {
        return createLClassAdapter();
      }
      @Override
      public Adapter caseLScalarType(LScalarType object)
      {
        return createLScalarTypeAdapter();
      }
      @Override
      public Adapter caseLFeaturesHolder(LFeaturesHolder object)
      {
        return createLFeaturesHolderAdapter();
      }
      @Override
      public Adapter caseLFeature(LFeature object)
      {
        return createLFeatureAdapter();
      }
      @Override
      public Adapter caseLAttribute(LAttribute object)
      {
        return createLAttributeAdapter();
      }
      @Override
      public Adapter caseLReference(LReference object)
      {
        return createLReferenceAdapter();
      }
      @Override
      public Adapter caseLunTypes_LOperation(org.lunifera.dsl.semantic.common.types.LOperation object)
      {
        return createLunTypes_LOperationAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LEntityModel <em>LEntity Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LEntityModel
   * @generated
   */
  public Adapter createLEntityModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LBean <em>LBean</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LBean
   * @generated
   */
  public Adapter createLBeanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LEntity <em>LEntity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LEntity
   * @generated
   */
  public Adapter createLEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo <em>LEntity Persistence Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo
   * @generated
   */
  public Adapter createLEntityPersistenceInfoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo <em>LEntity Column Persistence Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo
   * @generated
   */
  public Adapter createLEntityColumnPersistenceInfoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy <em>LEntity Inheritance Strategy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy
   * @generated
   */
  public Adapter createLEntityInheritanceStrategyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy <em>LTable Per Class Strategy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LTablePerClassStrategy
   * @generated
   */
  public Adapter createLTablePerClassStrategyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy <em>LTable Per Subclass Strategy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy
   * @generated
   */
  public Adapter createLTablePerSubclassStrategyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LEntityFeature <em>LEntity Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LEntityFeature
   * @generated
   */
  public Adapter createLEntityFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LEntityAttribute <em>LEntity Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LEntityAttribute
   * @generated
   */
  public Adapter createLEntityAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LEntityReference <em>LEntity Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LEntityReference
   * @generated
   */
  public Adapter createLEntityReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LBeanFeature <em>LBean Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LBeanFeature
   * @generated
   */
  public Adapter createLBeanFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LBeanAttribute <em>LBean Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LBeanAttribute
   * @generated
   */
  public Adapter createLBeanAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LBeanReference <em>LBean Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LBeanReference
   * @generated
   */
  public Adapter createLBeanReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LIndex <em>LIndex</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LIndex
   * @generated
   */
  public Adapter createLIndexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.entity.LOperation <em>LOperation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.entity.LOperation
   * @generated
   */
  public Adapter createLOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LAnnotationTarget <em>LAnnotation Target</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.common.types.LAnnotationTarget
   * @generated
   */
  public Adapter createLAnnotationTargetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LType <em>LType</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.common.types.LType
   * @generated
   */
  public Adapter createLTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LClass <em>LClass</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.common.types.LClass
   * @generated
   */
  public Adapter createLClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LScalarType <em>LScalar Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.common.types.LScalarType
   * @generated
   */
  public Adapter createLScalarTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LFeaturesHolder <em>LFeatures Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.common.types.LFeaturesHolder
   * @generated
   */
  public Adapter createLFeaturesHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LFeature <em>LFeature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.common.types.LFeature
   * @generated
   */
  public Adapter createLFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LAttribute <em>LAttribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.common.types.LAttribute
   * @generated
   */
  public Adapter createLAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LReference <em>LReference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.common.types.LReference
   * @generated
   */
  public Adapter createLReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LOperation <em>LOperation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.lunifera.dsl.semantic.common.types.LOperation
   * @generated
   */
  public Adapter createLunTypes_LOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //EntityAdapterFactory

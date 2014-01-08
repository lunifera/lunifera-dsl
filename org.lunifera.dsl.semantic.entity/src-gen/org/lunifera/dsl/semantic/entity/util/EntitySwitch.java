/**
 */
package org.lunifera.dsl.semantic.entity.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.entity.EntityPackage
 * @generated
 */
public class EntitySwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EntityPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntitySwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = EntityPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case EntityPackage.LENTITY_MODEL:
      {
        LEntityModel lEntityModel = (LEntityModel)theEObject;
        T result = caseLEntityModel(lEntityModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LBEAN:
      {
        LBean lBean = (LBean)theEObject;
        T result = caseLBean(lBean);
        if (result == null) result = caseLClass(lBean);
        if (result == null) result = caseLScalarType(lBean);
        if (result == null) result = caseLFeaturesHolder(lBean);
        if (result == null) result = caseLType(lBean);
        if (result == null) result = caseLAnnotationTarget(lBean);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LENTITY:
      {
        LEntity lEntity = (LEntity)theEObject;
        T result = caseLEntity(lEntity);
        if (result == null) result = caseLClass(lEntity);
        if (result == null) result = caseLFeaturesHolder(lEntity);
        if (result == null) result = caseLType(lEntity);
        if (result == null) result = caseLAnnotationTarget(lEntity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LENTITY_PERSISTENCE_INFO:
      {
        LEntityPersistenceInfo lEntityPersistenceInfo = (LEntityPersistenceInfo)theEObject;
        T result = caseLEntityPersistenceInfo(lEntityPersistenceInfo);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LENTITY_COLUMN_PERSISTENCE_INFO:
      {
        LEntityColumnPersistenceInfo lEntityColumnPersistenceInfo = (LEntityColumnPersistenceInfo)theEObject;
        T result = caseLEntityColumnPersistenceInfo(lEntityColumnPersistenceInfo);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LENTITY_INHERITANCE_STRATEGY:
      {
        LEntityInheritanceStrategy lEntityInheritanceStrategy = (LEntityInheritanceStrategy)theEObject;
        T result = caseLEntityInheritanceStrategy(lEntityInheritanceStrategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LTABLE_PER_CLASS_STRATEGY:
      {
        LTablePerClassStrategy lTablePerClassStrategy = (LTablePerClassStrategy)theEObject;
        T result = caseLTablePerClassStrategy(lTablePerClassStrategy);
        if (result == null) result = caseLEntityInheritanceStrategy(lTablePerClassStrategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LTABLE_PER_SUBCLASS_STRATEGY:
      {
        LTablePerSubclassStrategy lTablePerSubclassStrategy = (LTablePerSubclassStrategy)theEObject;
        T result = caseLTablePerSubclassStrategy(lTablePerSubclassStrategy);
        if (result == null) result = caseLEntityInheritanceStrategy(lTablePerSubclassStrategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LENTITY_FEATURE:
      {
        LEntityFeature lEntityFeature = (LEntityFeature)theEObject;
        T result = caseLEntityFeature(lEntityFeature);
        if (result == null) result = caseLFeature(lEntityFeature);
        if (result == null) result = caseLAnnotationTarget(lEntityFeature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LENTITY_ATTRIBUTE:
      {
        LEntityAttribute lEntityAttribute = (LEntityAttribute)theEObject;
        T result = caseLEntityAttribute(lEntityAttribute);
        if (result == null) result = caseLEntityFeature(lEntityAttribute);
        if (result == null) result = caseLAttribute(lEntityAttribute);
        if (result == null) result = caseLFeature(lEntityAttribute);
        if (result == null) result = caseLAnnotationTarget(lEntityAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LENTITY_REFERENCE:
      {
        LEntityReference lEntityReference = (LEntityReference)theEObject;
        T result = caseLEntityReference(lEntityReference);
        if (result == null) result = caseLEntityFeature(lEntityReference);
        if (result == null) result = caseLReference(lEntityReference);
        if (result == null) result = caseLFeature(lEntityReference);
        if (result == null) result = caseLAnnotationTarget(lEntityReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LBEAN_FEATURE:
      {
        LBeanFeature lBeanFeature = (LBeanFeature)theEObject;
        T result = caseLBeanFeature(lBeanFeature);
        if (result == null) result = caseLFeature(lBeanFeature);
        if (result == null) result = caseLAnnotationTarget(lBeanFeature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LBEAN_ATTRIBUTE:
      {
        LBeanAttribute lBeanAttribute = (LBeanAttribute)theEObject;
        T result = caseLBeanAttribute(lBeanAttribute);
        if (result == null) result = caseLBeanFeature(lBeanAttribute);
        if (result == null) result = caseLAttribute(lBeanAttribute);
        if (result == null) result = caseLFeature(lBeanAttribute);
        if (result == null) result = caseLAnnotationTarget(lBeanAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LBEAN_REFERENCE:
      {
        LBeanReference lBeanReference = (LBeanReference)theEObject;
        T result = caseLBeanReference(lBeanReference);
        if (result == null) result = caseLBeanFeature(lBeanReference);
        if (result == null) result = caseLReference(lBeanReference);
        if (result == null) result = caseLFeature(lBeanReference);
        if (result == null) result = caseLAnnotationTarget(lBeanReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LINDEX:
      {
        LIndex lIndex = (LIndex)theEObject;
        T result = caseLIndex(lIndex);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EntityPackage.LOPERATION:
      {
        LOperation lOperation = (LOperation)theEObject;
        T result = caseLOperation(lOperation);
        if (result == null) result = caseLunTypes_LOperation(lOperation);
        if (result == null) result = caseLBeanFeature(lOperation);
        if (result == null) result = caseLEntityFeature(lOperation);
        if (result == null) result = caseLFeature(lOperation);
        if (result == null) result = caseLAnnotationTarget(lOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LEntity Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LEntity Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLEntityModel(LEntityModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LBean</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LBean</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLBean(LBean object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LEntity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LEntity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLEntity(LEntity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LEntity Persistence Info</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LEntity Persistence Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLEntityPersistenceInfo(LEntityPersistenceInfo object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LEntity Column Persistence Info</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LEntity Column Persistence Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLEntityColumnPersistenceInfo(LEntityColumnPersistenceInfo object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LEntity Inheritance Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LEntity Inheritance Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLEntityInheritanceStrategy(LEntityInheritanceStrategy object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LTable Per Class Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LTable Per Class Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLTablePerClassStrategy(LTablePerClassStrategy object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LTable Per Subclass Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LTable Per Subclass Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLTablePerSubclassStrategy(LTablePerSubclassStrategy object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LEntity Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LEntity Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLEntityFeature(LEntityFeature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LEntity Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LEntity Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLEntityAttribute(LEntityAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LEntity Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LEntity Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLEntityReference(LEntityReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LBean Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LBean Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLBeanFeature(LBeanFeature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LBean Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LBean Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLBeanAttribute(LBeanAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LBean Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LBean Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLBeanReference(LBeanReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LIndex</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LIndex</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLIndex(LIndex object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LOperation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LOperation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLOperation(LOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LAnnotation Target</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LAnnotation Target</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLAnnotationTarget(LAnnotationTarget object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LType</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LType</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLType(LType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LClass</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LClass</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLClass(LClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LScalar Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LScalar Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLScalarType(LScalarType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LFeatures Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LFeatures Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLFeaturesHolder(LFeaturesHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LFeature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LFeature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLFeature(LFeature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LAttribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LAttribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLAttribute(LAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LReference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LReference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLReference(LReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LOperation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LOperation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLunTypes_LOperation(org.lunifera.dsl.semantic.common.types.LOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //EntitySwitch

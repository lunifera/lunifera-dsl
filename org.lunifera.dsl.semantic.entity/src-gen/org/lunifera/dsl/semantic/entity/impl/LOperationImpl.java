/**
 */
package org.lunifera.dsl.semantic.entity.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.lunifera.dsl.semantic.common.types.LAnnotationDef;
import org.lunifera.dsl.semantic.common.types.LAnnotationTarget;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LMultiplicity;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import org.lunifera.dsl.semantic.entity.EntityPackage;
import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanFeature;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo;
import org.lunifera.dsl.semantic.entity.LEntityFeature;
import org.lunifera.dsl.semantic.entity.LOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LOperation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LOperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LOperationImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LOperationImpl#getAnnotationInfo <em>Annotation Info</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LOperationImpl#getPersistenceInfo <em>Persistence Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LOperationImpl extends org.lunifera.dsl.semantic.common.types.impl.LOperationImpl implements LOperation
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected LMultiplicity multiplicity;

  /**
   * The cached value of the '{@link #getAnnotationInfo() <em>Annotation Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotationInfo()
   * @generated
   * @ordered
   */
  protected LAnnotationTarget annotationInfo;

  /**
   * The cached value of the '{@link #getPersistenceInfo() <em>Persistence Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPersistenceInfo()
   * @generated
   * @ordered
   */
  protected LEntityColumnPersistenceInfo persistenceInfo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LOperationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EntityPackage.Literals.LOPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.LOPERATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LMultiplicity getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicity(LMultiplicity newMultiplicity, NotificationChain msgs)
  {
    LMultiplicity oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EntityPackage.LOPERATION__MULTIPLICITY, oldMultiplicity, newMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicity(LMultiplicity newMultiplicity)
  {
    if (newMultiplicity != multiplicity)
    {
      NotificationChain msgs = null;
      if (multiplicity != null)
        msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EntityPackage.LOPERATION__MULTIPLICITY, null, msgs);
      if (newMultiplicity != null)
        msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EntityPackage.LOPERATION__MULTIPLICITY, null, msgs);
      msgs = basicSetMultiplicity(newMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.LOPERATION__MULTIPLICITY, newMultiplicity, newMultiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LAnnotationTarget getAnnotationInfo()
  {
    return annotationInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAnnotationInfo(LAnnotationTarget newAnnotationInfo, NotificationChain msgs)
  {
    LAnnotationTarget oldAnnotationInfo = annotationInfo;
    annotationInfo = newAnnotationInfo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EntityPackage.LOPERATION__ANNOTATION_INFO, oldAnnotationInfo, newAnnotationInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnotationInfo(LAnnotationTarget newAnnotationInfo)
  {
    if (newAnnotationInfo != annotationInfo)
    {
      NotificationChain msgs = null;
      if (annotationInfo != null)
        msgs = ((InternalEObject)annotationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EntityPackage.LOPERATION__ANNOTATION_INFO, null, msgs);
      if (newAnnotationInfo != null)
        msgs = ((InternalEObject)newAnnotationInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EntityPackage.LOPERATION__ANNOTATION_INFO, null, msgs);
      msgs = basicSetAnnotationInfo(newAnnotationInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.LOPERATION__ANNOTATION_INFO, newAnnotationInfo, newAnnotationInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntityColumnPersistenceInfo getPersistenceInfo()
  {
    return persistenceInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPersistenceInfo(LEntityColumnPersistenceInfo newPersistenceInfo, NotificationChain msgs)
  {
    LEntityColumnPersistenceInfo oldPersistenceInfo = persistenceInfo;
    persistenceInfo = newPersistenceInfo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EntityPackage.LOPERATION__PERSISTENCE_INFO, oldPersistenceInfo, newPersistenceInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPersistenceInfo(LEntityColumnPersistenceInfo newPersistenceInfo)
  {
    if (newPersistenceInfo != persistenceInfo)
    {
      NotificationChain msgs = null;
      if (persistenceInfo != null)
        msgs = ((InternalEObject)persistenceInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EntityPackage.LOPERATION__PERSISTENCE_INFO, null, msgs);
      if (newPersistenceInfo != null)
        msgs = ((InternalEObject)newPersistenceInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EntityPackage.LOPERATION__PERSISTENCE_INFO, null, msgs);
      msgs = basicSetPersistenceInfo(newPersistenceInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.LOPERATION__PERSISTENCE_INFO, newPersistenceInfo, newPersistenceInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntity getEntity()
  {
    EObject _eContainer = this.eContainer();
    return ((LEntity) _eContainer);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LBean getBean()
  {
    EObject _eContainer = this.eContainer();
    return ((LBean) _eContainer);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LAnnotationDef> getResolvedAnnotations()
  {
    EList<LAnnotationDef> _xifexpression = null;
    LAnnotationTarget _annotationInfo = this.getAnnotationInfo();
    boolean _notEquals = (!Objects.equal(_annotationInfo, null));
    if (_notEquals)
    {
      LAnnotationTarget _annotationInfo_1 = this.getAnnotationInfo();
      EList<LAnnotationDef> _annotations = _annotationInfo_1.getAnnotations();
      _xifexpression = _annotations;
    }
    else
    {
      EList<LAnnotationDef> _annotations_1 = this.getAnnotations();
      _xifexpression = _annotations_1;
    }
    return _xifexpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EntityPackage.LOPERATION__MULTIPLICITY:
        return basicSetMultiplicity(null, msgs);
      case EntityPackage.LOPERATION__ANNOTATION_INFO:
        return basicSetAnnotationInfo(null, msgs);
      case EntityPackage.LOPERATION__PERSISTENCE_INFO:
        return basicSetPersistenceInfo(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EntityPackage.LOPERATION__NAME:
        return getName();
      case EntityPackage.LOPERATION__MULTIPLICITY:
        return getMultiplicity();
      case EntityPackage.LOPERATION__ANNOTATION_INFO:
        return getAnnotationInfo();
      case EntityPackage.LOPERATION__PERSISTENCE_INFO:
        return getPersistenceInfo();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EntityPackage.LOPERATION__NAME:
        setName((String)newValue);
        return;
      case EntityPackage.LOPERATION__MULTIPLICITY:
        setMultiplicity((LMultiplicity)newValue);
        return;
      case EntityPackage.LOPERATION__ANNOTATION_INFO:
        setAnnotationInfo((LAnnotationTarget)newValue);
        return;
      case EntityPackage.LOPERATION__PERSISTENCE_INFO:
        setPersistenceInfo((LEntityColumnPersistenceInfo)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EntityPackage.LOPERATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case EntityPackage.LOPERATION__MULTIPLICITY:
        setMultiplicity((LMultiplicity)null);
        return;
      case EntityPackage.LOPERATION__ANNOTATION_INFO:
        setAnnotationInfo((LAnnotationTarget)null);
        return;
      case EntityPackage.LOPERATION__PERSISTENCE_INFO:
        setPersistenceInfo((LEntityColumnPersistenceInfo)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EntityPackage.LOPERATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case EntityPackage.LOPERATION__MULTIPLICITY:
        return multiplicity != null;
      case EntityPackage.LOPERATION__ANNOTATION_INFO:
        return annotationInfo != null;
      case EntityPackage.LOPERATION__PERSISTENCE_INFO:
        return persistenceInfo != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == LFeature.class)
    {
      switch (derivedFeatureID)
      {
        case EntityPackage.LOPERATION__NAME: return LunTypesPackage.LFEATURE__NAME;
        case EntityPackage.LOPERATION__MULTIPLICITY: return LunTypesPackage.LFEATURE__MULTIPLICITY;
        case EntityPackage.LOPERATION__ANNOTATION_INFO: return LunTypesPackage.LFEATURE__ANNOTATION_INFO;
        default: return -1;
      }
    }
    if (baseClass == LBeanFeature.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == LEntityFeature.class)
    {
      switch (derivedFeatureID)
      {
        case EntityPackage.LOPERATION__PERSISTENCE_INFO: return EntityPackage.LENTITY_FEATURE__PERSISTENCE_INFO;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == LFeature.class)
    {
      switch (baseFeatureID)
      {
        case LunTypesPackage.LFEATURE__NAME: return EntityPackage.LOPERATION__NAME;
        case LunTypesPackage.LFEATURE__MULTIPLICITY: return EntityPackage.LOPERATION__MULTIPLICITY;
        case LunTypesPackage.LFEATURE__ANNOTATION_INFO: return EntityPackage.LOPERATION__ANNOTATION_INFO;
        default: return -1;
      }
    }
    if (baseClass == LBeanFeature.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == LEntityFeature.class)
    {
      switch (baseFeatureID)
      {
        case EntityPackage.LENTITY_FEATURE__PERSISTENCE_INFO: return EntityPackage.LOPERATION__PERSISTENCE_INFO;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
  {
    if (baseClass == org.lunifera.dsl.semantic.common.types.LOperation.class)
    {
      switch (baseOperationID)
      {
        case LunTypesPackage.LOPERATION___GET_RESOLVED_ANNOTATIONS: return EntityPackage.LOPERATION___GET_RESOLVED_ANNOTATIONS;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
    }
    if (baseClass == LFeature.class)
    {
      switch (baseOperationID)
      {
        case LunTypesPackage.LFEATURE___GET_RESOLVED_ANNOTATIONS: return EntityPackage.LOPERATION___GET_RESOLVED_ANNOTATIONS;
        default: return -1;
      }
    }
    if (baseClass == LBeanFeature.class)
    {
      switch (baseOperationID)
      {
        case EntityPackage.LBEAN_FEATURE___GET_BEAN: return EntityPackage.LOPERATION___GET_BEAN;
        default: return -1;
      }
    }
    if (baseClass == LEntityFeature.class)
    {
      switch (baseOperationID)
      {
        case EntityPackage.LENTITY_FEATURE___GET_ENTITY: return EntityPackage.LOPERATION___GET_ENTITY;
        default: return -1;
      }
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
  {
    switch (operationID)
    {
      case EntityPackage.LOPERATION___GET_ENTITY:
        return getEntity();
      case EntityPackage.LOPERATION___GET_BEAN:
        return getBean();
      case EntityPackage.LOPERATION___GET_RESOLVED_ANNOTATIONS:
        return getResolvedAnnotations();
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //LOperationImpl

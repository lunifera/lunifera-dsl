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

import com.google.common.base.Objects;

import com.google.common.collect.Iterables;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import org.lunifera.dsl.semantic.common.types.LDateType;
import org.lunifera.dsl.semantic.common.types.LFeaturesHolder;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import org.lunifera.dsl.semantic.common.types.impl.LClassImpl;

import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityFeature;
import org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy;
import org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo;
import org.lunifera.dsl.semantic.entity.LEntityReference;
import org.lunifera.dsl.semantic.entity.LIndex;
import org.lunifera.dsl.semantic.entity.LOperation;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LEntity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#isCacheable <em>Cacheable</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#isHistorized <em>Historized</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#isTimedependent <em>Timedependent</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#getTimedependentDateType <em>Timedependent Date Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#isMappedSuperclass <em>Mapped Superclass</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#getPersistenceInfo <em>Persistence Info</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#getInheritanceStrategy <em>Inheritance Strategy</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl#getSubTypes <em>Sub Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LEntityImpl extends LClassImpl implements LEntity
{
  /**
   * The default value of the '{@link #isCacheable() <em>Cacheable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCacheable()
   * @generated
   * @ordered
   */
  protected static final boolean CACHEABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCacheable() <em>Cacheable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCacheable()
   * @generated
   * @ordered
   */
  protected boolean cacheable = CACHEABLE_EDEFAULT;

  /**
   * The default value of the '{@link #isHistorized() <em>Historized</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHistorized()
   * @generated
   * @ordered
   */
  protected static final boolean HISTORIZED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHistorized() <em>Historized</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHistorized()
   * @generated
   * @ordered
   */
  protected boolean historized = HISTORIZED_EDEFAULT;

  /**
   * The default value of the '{@link #isTimedependent() <em>Timedependent</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTimedependent()
   * @generated
   * @ordered
   */
  protected static final boolean TIMEDEPENDENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTimedependent() <em>Timedependent</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTimedependent()
   * @generated
   * @ordered
   */
  protected boolean timedependent = TIMEDEPENDENT_EDEFAULT;

  /**
   * The default value of the '{@link #getTimedependentDateType() <em>Timedependent Date Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimedependentDateType()
   * @generated
   * @ordered
   */
  protected static final LDateType TIMEDEPENDENT_DATE_TYPE_EDEFAULT = LDateType.DATE;

  /**
   * The cached value of the '{@link #getTimedependentDateType() <em>Timedependent Date Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimedependentDateType()
   * @generated
   * @ordered
   */
  protected LDateType timedependentDateType = TIMEDEPENDENT_DATE_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #isMappedSuperclass() <em>Mapped Superclass</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMappedSuperclass()
   * @generated
   * @ordered
   */
  protected static final boolean MAPPED_SUPERCLASS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMappedSuperclass() <em>Mapped Superclass</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMappedSuperclass()
   * @generated
   * @ordered
   */
  protected boolean mappedSuperclass = MAPPED_SUPERCLASS_EDEFAULT;

  /**
   * The cached value of the '{@link #getPersistenceInfo() <em>Persistence Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPersistenceInfo()
   * @generated
   * @ordered
   */
  protected LEntityPersistenceInfo persistenceInfo;

  /**
   * The cached value of the '{@link #getInheritanceStrategy() <em>Inheritance Strategy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInheritanceStrategy()
   * @generated
   * @ordered
   */
  protected LEntityInheritanceStrategy inheritanceStrategy;

  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<LEntityFeature> features;

  /**
   * The cached value of the '{@link #getIndexes() <em>Indexes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndexes()
   * @generated
   * @ordered
   */
  protected EList<LIndex> indexes;

  /**
   * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperType()
   * @generated
   * @ordered
   */
  protected LEntity superType;

  /**
   * The cached value of the '{@link #getSubTypes() <em>Sub Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubTypes()
   * @generated
   * @ordered
   */
  protected EList<LEntity> subTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LEntityImpl()
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
    return LunEntityPackage.Literals.LENTITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCacheable()
  {
    return cacheable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCacheable(boolean newCacheable)
  {
    boolean oldCacheable = cacheable;
    cacheable = newCacheable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__CACHEABLE, oldCacheable, cacheable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHistorized()
  {
    return historized;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHistorized(boolean newHistorized)
  {
    boolean oldHistorized = historized;
    historized = newHistorized;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__HISTORIZED, oldHistorized, historized));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTimedependent()
  {
    return timedependent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimedependent(boolean newTimedependent)
  {
    boolean oldTimedependent = timedependent;
    timedependent = newTimedependent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__TIMEDEPENDENT, oldTimedependent, timedependent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDateType getTimedependentDateType()
  {
    return timedependentDateType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimedependentDateType(LDateType newTimedependentDateType)
  {
    LDateType oldTimedependentDateType = timedependentDateType;
    timedependentDateType = newTimedependentDateType == null ? TIMEDEPENDENT_DATE_TYPE_EDEFAULT : newTimedependentDateType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__TIMEDEPENDENT_DATE_TYPE, oldTimedependentDateType, timedependentDateType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMappedSuperclass()
  {
    return mappedSuperclass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMappedSuperclass(boolean newMappedSuperclass)
  {
    boolean oldMappedSuperclass = mappedSuperclass;
    mappedSuperclass = newMappedSuperclass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__MAPPED_SUPERCLASS, oldMappedSuperclass, mappedSuperclass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntityPersistenceInfo getPersistenceInfo()
  {
    return persistenceInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPersistenceInfo(LEntityPersistenceInfo newPersistenceInfo, NotificationChain msgs)
  {
    LEntityPersistenceInfo oldPersistenceInfo = persistenceInfo;
    persistenceInfo = newPersistenceInfo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__PERSISTENCE_INFO, oldPersistenceInfo, newPersistenceInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPersistenceInfo(LEntityPersistenceInfo newPersistenceInfo)
  {
    if (newPersistenceInfo != persistenceInfo)
    {
      NotificationChain msgs = null;
      if (persistenceInfo != null)
        msgs = ((InternalEObject)persistenceInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunEntityPackage.LENTITY__PERSISTENCE_INFO, null, msgs);
      if (newPersistenceInfo != null)
        msgs = ((InternalEObject)newPersistenceInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunEntityPackage.LENTITY__PERSISTENCE_INFO, null, msgs);
      msgs = basicSetPersistenceInfo(newPersistenceInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__PERSISTENCE_INFO, newPersistenceInfo, newPersistenceInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntityInheritanceStrategy getInheritanceStrategy()
  {
    return inheritanceStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInheritanceStrategy(LEntityInheritanceStrategy newInheritanceStrategy, NotificationChain msgs)
  {
    LEntityInheritanceStrategy oldInheritanceStrategy = inheritanceStrategy;
    inheritanceStrategy = newInheritanceStrategy;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__INHERITANCE_STRATEGY, oldInheritanceStrategy, newInheritanceStrategy);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInheritanceStrategy(LEntityInheritanceStrategy newInheritanceStrategy)
  {
    if (newInheritanceStrategy != inheritanceStrategy)
    {
      NotificationChain msgs = null;
      if (inheritanceStrategy != null)
        msgs = ((InternalEObject)inheritanceStrategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunEntityPackage.LENTITY__INHERITANCE_STRATEGY, null, msgs);
      if (newInheritanceStrategy != null)
        msgs = ((InternalEObject)newInheritanceStrategy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunEntityPackage.LENTITY__INHERITANCE_STRATEGY, null, msgs);
      msgs = basicSetInheritanceStrategy(newInheritanceStrategy, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__INHERITANCE_STRATEGY, newInheritanceStrategy, newInheritanceStrategy));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LEntityFeature> getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentEList<LEntityFeature>(LEntityFeature.class, this, LunEntityPackage.LENTITY__FEATURES);
    }
    return features;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LIndex> getIndexes()
  {
    if (indexes == null)
    {
      indexes = new EObjectContainmentEList<LIndex>(LIndex.class, this, LunEntityPackage.LENTITY__INDEXES);
    }
    return indexes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntity getSuperType()
  {
    if (superType != null && superType.eIsProxy())
    {
      InternalEObject oldSuperType = (InternalEObject)superType;
      superType = (LEntity)eResolveProxy(oldSuperType);
      if (superType != oldSuperType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunEntityPackage.LENTITY__SUPER_TYPE, oldSuperType, superType));
      }
    }
    return superType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LEntity basicGetSuperType()
  {
    return superType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuperType(LEntity newSuperType, NotificationChain msgs)
  {
    LEntity oldSuperType = superType;
    superType = newSuperType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__SUPER_TYPE, oldSuperType, newSuperType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperType(LEntity newSuperType)
  {
    if (newSuperType != superType)
    {
      NotificationChain msgs = null;
      if (superType != null)
        msgs = ((InternalEObject)superType).eInverseRemove(this, LunEntityPackage.LENTITY__SUB_TYPES, LEntity.class, msgs);
      if (newSuperType != null)
        msgs = ((InternalEObject)newSuperType).eInverseAdd(this, LunEntityPackage.LENTITY__SUB_TYPES, LEntity.class, msgs);
      msgs = basicSetSuperType(newSuperType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LENTITY__SUPER_TYPE, newSuperType, newSuperType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LEntity> getSubTypes()
  {
    if (subTypes == null)
    {
      subTypes = new EObjectWithInverseResolvingEList<LEntity>(LEntity.class, this, LunEntityPackage.LENTITY__SUB_TYPES, LunEntityPackage.LENTITY__SUPER_TYPE);
    }
    return subTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<LOperation> getOperations()
  {
    LEntity _this = this;
    EList<LEntityFeature> _features = _this.getFeatures();
    Iterable<LOperation> _filter = Iterables.<LOperation>filter(_features, LOperation.class);
    return IterableExtensions.<LOperation>toList(_filter);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<LEntityReference> getReferences()
  {
    LEntity _this = this;
    EList<LEntityFeature> _features = _this.getFeatures();
    Iterable<LEntityReference> _filter = Iterables.<LEntityReference>filter(_features, LEntityReference.class);
    return IterableExtensions.<LEntityReference>toList(_filter);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<LEntityAttribute> getAttributes()
  {
    LEntity _this = this;
    EList<LEntityFeature> _features = _this.getFeatures();
    Iterable<LEntityAttribute> _filter = Iterables.<LEntityAttribute>filter(_features, LEntityAttribute.class);
    return IterableExtensions.<LEntityAttribute>toList(_filter);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<LEntityFeature> getAllFeatures()
  {
    final List<LEntityFeature> result = CollectionLiterals.<LEntityFeature>newArrayList();
    LEntity _this = this;
    LEntity _this_1 = this;
    _this.collectAllLunFeatures(_this_1, result);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<LEntityAttribute> getAllAttributes()
  {
    final List<LEntityFeature> result = CollectionLiterals.<LEntityFeature>newArrayList();
    LEntity _this = this;
    LEntity _this_1 = this;
    _this.collectAllLunFeatures(_this_1, result);
    Iterable<LEntityAttribute> _filter = Iterables.<LEntityAttribute>filter(result, LEntityAttribute.class);
    return IterableExtensions.<LEntityAttribute>toList(_filter);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<LEntityReference> getAllReferences()
  {
    final List<LEntityFeature> result = CollectionLiterals.<LEntityFeature>newArrayList();
    LEntity _this = this;
    LEntity _this_1 = this;
    _this.collectAllLunFeatures(_this_1, result);
    Iterable<LEntityReference> _filter = Iterables.<LEntityReference>filter(result, LEntityReference.class);
    return IterableExtensions.<LEntityReference>toList(_filter);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void collectAllLunFeatures(final LEntity current, final List<LEntityFeature> result)
  {
    boolean _equals = Objects.equal(current, null);
    if (_equals)
    {
      return;
    }
    EList<LEntityFeature> _features = current.getFeatures();
    result.addAll(_features);
    LEntity _this = this;
    LEntity _superType = current.getSuperType();
    _this.collectAllLunFeatures(_superType, result);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LunEntityPackage.LENTITY__SUPER_TYPE:
        if (superType != null)
          msgs = ((InternalEObject)superType).eInverseRemove(this, LunEntityPackage.LENTITY__SUB_TYPES, LEntity.class, msgs);
        return basicSetSuperType((LEntity)otherEnd, msgs);
      case LunEntityPackage.LENTITY__SUB_TYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubTypes()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case LunEntityPackage.LENTITY__PERSISTENCE_INFO:
        return basicSetPersistenceInfo(null, msgs);
      case LunEntityPackage.LENTITY__INHERITANCE_STRATEGY:
        return basicSetInheritanceStrategy(null, msgs);
      case LunEntityPackage.LENTITY__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
      case LunEntityPackage.LENTITY__INDEXES:
        return ((InternalEList<?>)getIndexes()).basicRemove(otherEnd, msgs);
      case LunEntityPackage.LENTITY__SUPER_TYPE:
        return basicSetSuperType(null, msgs);
      case LunEntityPackage.LENTITY__SUB_TYPES:
        return ((InternalEList<?>)getSubTypes()).basicRemove(otherEnd, msgs);
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
      case LunEntityPackage.LENTITY__CACHEABLE:
        return isCacheable();
      case LunEntityPackage.LENTITY__HISTORIZED:
        return isHistorized();
      case LunEntityPackage.LENTITY__TIMEDEPENDENT:
        return isTimedependent();
      case LunEntityPackage.LENTITY__TIMEDEPENDENT_DATE_TYPE:
        return getTimedependentDateType();
      case LunEntityPackage.LENTITY__MAPPED_SUPERCLASS:
        return isMappedSuperclass();
      case LunEntityPackage.LENTITY__PERSISTENCE_INFO:
        return getPersistenceInfo();
      case LunEntityPackage.LENTITY__INHERITANCE_STRATEGY:
        return getInheritanceStrategy();
      case LunEntityPackage.LENTITY__FEATURES:
        return getFeatures();
      case LunEntityPackage.LENTITY__INDEXES:
        return getIndexes();
      case LunEntityPackage.LENTITY__SUPER_TYPE:
        if (resolve) return getSuperType();
        return basicGetSuperType();
      case LunEntityPackage.LENTITY__SUB_TYPES:
        return getSubTypes();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LunEntityPackage.LENTITY__CACHEABLE:
        setCacheable((Boolean)newValue);
        return;
      case LunEntityPackage.LENTITY__HISTORIZED:
        setHistorized((Boolean)newValue);
        return;
      case LunEntityPackage.LENTITY__TIMEDEPENDENT:
        setTimedependent((Boolean)newValue);
        return;
      case LunEntityPackage.LENTITY__TIMEDEPENDENT_DATE_TYPE:
        setTimedependentDateType((LDateType)newValue);
        return;
      case LunEntityPackage.LENTITY__MAPPED_SUPERCLASS:
        setMappedSuperclass((Boolean)newValue);
        return;
      case LunEntityPackage.LENTITY__PERSISTENCE_INFO:
        setPersistenceInfo((LEntityPersistenceInfo)newValue);
        return;
      case LunEntityPackage.LENTITY__INHERITANCE_STRATEGY:
        setInheritanceStrategy((LEntityInheritanceStrategy)newValue);
        return;
      case LunEntityPackage.LENTITY__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends LEntityFeature>)newValue);
        return;
      case LunEntityPackage.LENTITY__INDEXES:
        getIndexes().clear();
        getIndexes().addAll((Collection<? extends LIndex>)newValue);
        return;
      case LunEntityPackage.LENTITY__SUPER_TYPE:
        setSuperType((LEntity)newValue);
        return;
      case LunEntityPackage.LENTITY__SUB_TYPES:
        getSubTypes().clear();
        getSubTypes().addAll((Collection<? extends LEntity>)newValue);
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
      case LunEntityPackage.LENTITY__CACHEABLE:
        setCacheable(CACHEABLE_EDEFAULT);
        return;
      case LunEntityPackage.LENTITY__HISTORIZED:
        setHistorized(HISTORIZED_EDEFAULT);
        return;
      case LunEntityPackage.LENTITY__TIMEDEPENDENT:
        setTimedependent(TIMEDEPENDENT_EDEFAULT);
        return;
      case LunEntityPackage.LENTITY__TIMEDEPENDENT_DATE_TYPE:
        setTimedependentDateType(TIMEDEPENDENT_DATE_TYPE_EDEFAULT);
        return;
      case LunEntityPackage.LENTITY__MAPPED_SUPERCLASS:
        setMappedSuperclass(MAPPED_SUPERCLASS_EDEFAULT);
        return;
      case LunEntityPackage.LENTITY__PERSISTENCE_INFO:
        setPersistenceInfo((LEntityPersistenceInfo)null);
        return;
      case LunEntityPackage.LENTITY__INHERITANCE_STRATEGY:
        setInheritanceStrategy((LEntityInheritanceStrategy)null);
        return;
      case LunEntityPackage.LENTITY__FEATURES:
        getFeatures().clear();
        return;
      case LunEntityPackage.LENTITY__INDEXES:
        getIndexes().clear();
        return;
      case LunEntityPackage.LENTITY__SUPER_TYPE:
        setSuperType((LEntity)null);
        return;
      case LunEntityPackage.LENTITY__SUB_TYPES:
        getSubTypes().clear();
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
      case LunEntityPackage.LENTITY__CACHEABLE:
        return cacheable != CACHEABLE_EDEFAULT;
      case LunEntityPackage.LENTITY__HISTORIZED:
        return historized != HISTORIZED_EDEFAULT;
      case LunEntityPackage.LENTITY__TIMEDEPENDENT:
        return timedependent != TIMEDEPENDENT_EDEFAULT;
      case LunEntityPackage.LENTITY__TIMEDEPENDENT_DATE_TYPE:
        return timedependentDateType != TIMEDEPENDENT_DATE_TYPE_EDEFAULT;
      case LunEntityPackage.LENTITY__MAPPED_SUPERCLASS:
        return mappedSuperclass != MAPPED_SUPERCLASS_EDEFAULT;
      case LunEntityPackage.LENTITY__PERSISTENCE_INFO:
        return persistenceInfo != null;
      case LunEntityPackage.LENTITY__INHERITANCE_STRATEGY:
        return inheritanceStrategy != null;
      case LunEntityPackage.LENTITY__FEATURES:
        return features != null && !features.isEmpty();
      case LunEntityPackage.LENTITY__INDEXES:
        return indexes != null && !indexes.isEmpty();
      case LunEntityPackage.LENTITY__SUPER_TYPE:
        return superType != null;
      case LunEntityPackage.LENTITY__SUB_TYPES:
        return subTypes != null && !subTypes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
  {
    if (baseClass == LFeaturesHolder.class)
    {
      switch (baseOperationID)
      {
        case LunTypesPackage.LFEATURES_HOLDER___GET_FEATURES: return LunEntityPackage.LENTITY___GET_FEATURES;
        case LunTypesPackage.LFEATURES_HOLDER___GET_ALL_FEATURES: return LunEntityPackage.LENTITY___GET_ALL_FEATURES;
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
  @SuppressWarnings("unchecked")
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
  {
    switch (operationID)
    {
      case LunEntityPackage.LENTITY___GET_OPERATIONS:
        return getOperations();
      case LunEntityPackage.LENTITY___GET_REFERENCES:
        return getReferences();
      case LunEntityPackage.LENTITY___GET_ATTRIBUTES:
        return getAttributes();
      case LunEntityPackage.LENTITY___GET_ALL_FEATURES:
        return getAllFeatures();
      case LunEntityPackage.LENTITY___GET_ALL_ATTRIBUTES:
        return getAllAttributes();
      case LunEntityPackage.LENTITY___GET_ALL_REFERENCES:
        return getAllReferences();
      case LunEntityPackage.LENTITY___COLLECT_ALL_LUN_FEATURES__LENTITY_LIST:
        collectAllLunFeatures((LEntity)arguments.get(0), (List<LEntityFeature>)arguments.get(1));
        return null;
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
    result.append(" (cacheable: ");
    result.append(cacheable);
    result.append(", historized: ");
    result.append(historized);
    result.append(", timedependent: ");
    result.append(timedependent);
    result.append(", timedependentDateType: ");
    result.append(timedependentDateType);
    result.append(", mappedSuperclass: ");
    result.append(mappedSuperclass);
    result.append(')');
    return result.toString();
  }

} //LEntityImpl

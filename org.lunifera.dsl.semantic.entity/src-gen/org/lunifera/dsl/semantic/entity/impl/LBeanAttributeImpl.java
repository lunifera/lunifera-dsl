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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import org.lunifera.dsl.semantic.entity.LBeanAttribute;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LBean Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl#isId <em>Id</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl#isUuid <em>Uuid</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl#isVersion <em>Version</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl#isLazy <em>Lazy</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl#isCascading <em>Cascading</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl#getDerivedGetterExpression <em>Derived Getter Expression</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LBeanAttributeImpl extends LBeanFeatureImpl implements LBeanAttribute
{
  /**
   * The default value of the '{@link #isId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isId()
   * @generated
   * @ordered
   */
  protected static final boolean ID_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isId()
   * @generated
   * @ordered
   */
  protected boolean id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #isUuid() <em>Uuid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUuid()
   * @generated
   * @ordered
   */
  protected static final boolean UUID_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUuid() <em>Uuid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUuid()
   * @generated
   * @ordered
   */
  protected boolean uuid = UUID_EDEFAULT;

  /**
   * The default value of the '{@link #isVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVersion()
   * @generated
   * @ordered
   */
  protected static final boolean VERSION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVersion()
   * @generated
   * @ordered
   */
  protected boolean version = VERSION_EDEFAULT;

  /**
   * The default value of the '{@link #isLazy() <em>Lazy</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLazy()
   * @generated
   * @ordered
   */
  protected static final boolean LAZY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLazy() <em>Lazy</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLazy()
   * @generated
   * @ordered
   */
  protected boolean lazy = LAZY_EDEFAULT;

  /**
   * The default value of the '{@link #isCascading() <em>Cascading</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCascading()
   * @generated
   * @ordered
   */
  protected static final boolean CASCADING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCascading() <em>Cascading</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCascading()
   * @generated
   * @ordered
   */
  protected boolean cascading = CASCADING_EDEFAULT;

  /**
   * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTransient()
   * @generated
   * @ordered
   */
  protected static final boolean TRANSIENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTransient()
   * @generated
   * @ordered
   */
  protected boolean transient_ = TRANSIENT_EDEFAULT;

  /**
   * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected static final boolean DERIVED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected boolean derived = DERIVED_EDEFAULT;

  /**
   * The cached value of the '{@link #getDerivedGetterExpression() <em>Derived Getter Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDerivedGetterExpression()
   * @generated
   * @ordered
   */
  protected XExpression derivedGetterExpression;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected LScalarType type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LBeanAttributeImpl()
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
    return LunEntityPackage.Literals.LBEAN_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(boolean newId)
  {
    boolean oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUuid()
  {
    return uuid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUuid(boolean newUuid)
  {
    boolean oldUuid = uuid;
    uuid = newUuid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__UUID, oldUuid, uuid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVersion()
  {
    return version;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(boolean newVersion)
  {
    boolean oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__VERSION, oldVersion, version));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isLazy()
  {
    return lazy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLazy(boolean newLazy)
  {
    boolean oldLazy = lazy;
    lazy = newLazy;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__LAZY, oldLazy, lazy));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCascading()
  {
    return cascading;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCascading(boolean newCascading)
  {
    boolean oldCascading = cascading;
    cascading = newCascading;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__CASCADING, oldCascading, cascading));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTransient()
  {
    return transient_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransient(boolean newTransient)
  {
    boolean oldTransient = transient_;
    transient_ = newTransient;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__TRANSIENT, oldTransient, transient_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDerived()
  {
    return derived;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDerived(boolean newDerived)
  {
    boolean oldDerived = derived;
    derived = newDerived;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED, oldDerived, derived));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getDerivedGetterExpression()
  {
    return derivedGetterExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDerivedGetterExpression(XExpression newDerivedGetterExpression, NotificationChain msgs)
  {
    XExpression oldDerivedGetterExpression = derivedGetterExpression;
    derivedGetterExpression = newDerivedGetterExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION, oldDerivedGetterExpression, newDerivedGetterExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDerivedGetterExpression(XExpression newDerivedGetterExpression)
  {
    if (newDerivedGetterExpression != derivedGetterExpression)
    {
      NotificationChain msgs = null;
      if (derivedGetterExpression != null)
        msgs = ((InternalEObject)derivedGetterExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION, null, msgs);
      if (newDerivedGetterExpression != null)
        msgs = ((InternalEObject)newDerivedGetterExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION, null, msgs);
      msgs = basicSetDerivedGetterExpression(newDerivedGetterExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION, newDerivedGetterExpression, newDerivedGetterExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LScalarType getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (LScalarType)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunEntityPackage.LBEAN_ATTRIBUTE__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LScalarType basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(LScalarType newType)
  {
    LScalarType oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_ATTRIBUTE__TYPE, oldType, type));
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
      case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION:
        return basicSetDerivedGetterExpression(null, msgs);
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
      case LunEntityPackage.LBEAN_ATTRIBUTE__ID:
        return isId();
      case LunEntityPackage.LBEAN_ATTRIBUTE__UUID:
        return isUuid();
      case LunEntityPackage.LBEAN_ATTRIBUTE__VERSION:
        return isVersion();
      case LunEntityPackage.LBEAN_ATTRIBUTE__LAZY:
        return isLazy();
      case LunEntityPackage.LBEAN_ATTRIBUTE__CASCADING:
        return isCascading();
      case LunEntityPackage.LBEAN_ATTRIBUTE__TRANSIENT:
        return isTransient();
      case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED:
        return isDerived();
      case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION:
        return getDerivedGetterExpression();
      case LunEntityPackage.LBEAN_ATTRIBUTE__TYPE:
        if (resolve) return getType();
        return basicGetType();
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
      case LunEntityPackage.LBEAN_ATTRIBUTE__ID:
        setId((Boolean)newValue);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__UUID:
        setUuid((Boolean)newValue);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__VERSION:
        setVersion((Boolean)newValue);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__LAZY:
        setLazy((Boolean)newValue);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__CASCADING:
        setCascading((Boolean)newValue);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__TRANSIENT:
        setTransient((Boolean)newValue);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED:
        setDerived((Boolean)newValue);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION:
        setDerivedGetterExpression((XExpression)newValue);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__TYPE:
        setType((LScalarType)newValue);
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
      case LunEntityPackage.LBEAN_ATTRIBUTE__ID:
        setId(ID_EDEFAULT);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__UUID:
        setUuid(UUID_EDEFAULT);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__VERSION:
        setVersion(VERSION_EDEFAULT);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__LAZY:
        setLazy(LAZY_EDEFAULT);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__CASCADING:
        setCascading(CASCADING_EDEFAULT);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__TRANSIENT:
        setTransient(TRANSIENT_EDEFAULT);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED:
        setDerived(DERIVED_EDEFAULT);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION:
        setDerivedGetterExpression((XExpression)null);
        return;
      case LunEntityPackage.LBEAN_ATTRIBUTE__TYPE:
        setType((LScalarType)null);
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
      case LunEntityPackage.LBEAN_ATTRIBUTE__ID:
        return id != ID_EDEFAULT;
      case LunEntityPackage.LBEAN_ATTRIBUTE__UUID:
        return uuid != UUID_EDEFAULT;
      case LunEntityPackage.LBEAN_ATTRIBUTE__VERSION:
        return version != VERSION_EDEFAULT;
      case LunEntityPackage.LBEAN_ATTRIBUTE__LAZY:
        return lazy != LAZY_EDEFAULT;
      case LunEntityPackage.LBEAN_ATTRIBUTE__CASCADING:
        return cascading != CASCADING_EDEFAULT;
      case LunEntityPackage.LBEAN_ATTRIBUTE__TRANSIENT:
        return transient_ != TRANSIENT_EDEFAULT;
      case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED:
        return derived != DERIVED_EDEFAULT;
      case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION:
        return derivedGetterExpression != null;
      case LunEntityPackage.LBEAN_ATTRIBUTE__TYPE:
        return type != null;
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
    if (baseClass == LAttribute.class)
    {
      switch (derivedFeatureID)
      {
        case LunEntityPackage.LBEAN_ATTRIBUTE__ID: return LunTypesPackage.LATTRIBUTE__ID;
        case LunEntityPackage.LBEAN_ATTRIBUTE__UUID: return LunTypesPackage.LATTRIBUTE__UUID;
        case LunEntityPackage.LBEAN_ATTRIBUTE__VERSION: return LunTypesPackage.LATTRIBUTE__VERSION;
        case LunEntityPackage.LBEAN_ATTRIBUTE__LAZY: return LunTypesPackage.LATTRIBUTE__LAZY;
        case LunEntityPackage.LBEAN_ATTRIBUTE__CASCADING: return LunTypesPackage.LATTRIBUTE__CASCADING;
        case LunEntityPackage.LBEAN_ATTRIBUTE__TRANSIENT: return LunTypesPackage.LATTRIBUTE__TRANSIENT;
        case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED: return LunTypesPackage.LATTRIBUTE__DERIVED;
        case LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION: return LunTypesPackage.LATTRIBUTE__DERIVED_GETTER_EXPRESSION;
        case LunEntityPackage.LBEAN_ATTRIBUTE__TYPE: return LunTypesPackage.LATTRIBUTE__TYPE;
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
    if (baseClass == LAttribute.class)
    {
      switch (baseFeatureID)
      {
        case LunTypesPackage.LATTRIBUTE__ID: return LunEntityPackage.LBEAN_ATTRIBUTE__ID;
        case LunTypesPackage.LATTRIBUTE__UUID: return LunEntityPackage.LBEAN_ATTRIBUTE__UUID;
        case LunTypesPackage.LATTRIBUTE__VERSION: return LunEntityPackage.LBEAN_ATTRIBUTE__VERSION;
        case LunTypesPackage.LATTRIBUTE__LAZY: return LunEntityPackage.LBEAN_ATTRIBUTE__LAZY;
        case LunTypesPackage.LATTRIBUTE__CASCADING: return LunEntityPackage.LBEAN_ATTRIBUTE__CASCADING;
        case LunTypesPackage.LATTRIBUTE__TRANSIENT: return LunEntityPackage.LBEAN_ATTRIBUTE__TRANSIENT;
        case LunTypesPackage.LATTRIBUTE__DERIVED: return LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED;
        case LunTypesPackage.LATTRIBUTE__DERIVED_GETTER_EXPRESSION: return LunEntityPackage.LBEAN_ATTRIBUTE__DERIVED_GETTER_EXPRESSION;
        case LunTypesPackage.LATTRIBUTE__TYPE: return LunEntityPackage.LBEAN_ATTRIBUTE__TYPE;
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
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (id: ");
    result.append(id);
    result.append(", uuid: ");
    result.append(uuid);
    result.append(", version: ");
    result.append(version);
    result.append(", lazy: ");
    result.append(lazy);
    result.append(", cascading: ");
    result.append(cascading);
    result.append(", transient: ");
    result.append(transient_);
    result.append(", derived: ");
    result.append(derived);
    result.append(')');
    return result.toString();
  }

} //LBeanAttributeImpl

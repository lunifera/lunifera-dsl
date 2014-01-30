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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.lunifera.dsl.semantic.common.types.LReference;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LBean Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanReferenceImpl#isLazy <em>Lazy</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanReferenceImpl#isCascading <em>Cascading</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanReferenceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.impl.LBeanReferenceImpl#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LBeanReferenceImpl extends LBeanFeatureImpl implements LBeanReference
{
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
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected LBean type;

  /**
   * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpposite()
   * @generated
   * @ordered
   */
  protected LBeanReference opposite;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LBeanReferenceImpl()
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
    return LunEntityPackage.Literals.LBEAN_REFERENCE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_REFERENCE__LAZY, oldLazy, lazy));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_REFERENCE__CASCADING, oldCascading, cascading));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LBean getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (LBean)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunEntityPackage.LBEAN_REFERENCE__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LBean basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(LBean newType)
  {
    LBean oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_REFERENCE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LBeanReference getOpposite()
  {
    if (opposite != null && opposite.eIsProxy())
    {
      InternalEObject oldOpposite = (InternalEObject)opposite;
      opposite = (LBeanReference)eResolveProxy(oldOpposite);
      if (opposite != oldOpposite)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunEntityPackage.LBEAN_REFERENCE__OPPOSITE, oldOpposite, opposite));
      }
    }
    return opposite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LBeanReference basicGetOpposite()
  {
    return opposite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpposite(LBeanReference newOpposite)
  {
    LBeanReference oldOpposite = opposite;
    opposite = newOpposite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunEntityPackage.LBEAN_REFERENCE__OPPOSITE, oldOpposite, opposite));
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
      case LunEntityPackage.LBEAN_REFERENCE__LAZY:
        return isLazy();
      case LunEntityPackage.LBEAN_REFERENCE__CASCADING:
        return isCascading();
      case LunEntityPackage.LBEAN_REFERENCE__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case LunEntityPackage.LBEAN_REFERENCE__OPPOSITE:
        if (resolve) return getOpposite();
        return basicGetOpposite();
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
      case LunEntityPackage.LBEAN_REFERENCE__LAZY:
        setLazy((Boolean)newValue);
        return;
      case LunEntityPackage.LBEAN_REFERENCE__CASCADING:
        setCascading((Boolean)newValue);
        return;
      case LunEntityPackage.LBEAN_REFERENCE__TYPE:
        setType((LBean)newValue);
        return;
      case LunEntityPackage.LBEAN_REFERENCE__OPPOSITE:
        setOpposite((LBeanReference)newValue);
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
      case LunEntityPackage.LBEAN_REFERENCE__LAZY:
        setLazy(LAZY_EDEFAULT);
        return;
      case LunEntityPackage.LBEAN_REFERENCE__CASCADING:
        setCascading(CASCADING_EDEFAULT);
        return;
      case LunEntityPackage.LBEAN_REFERENCE__TYPE:
        setType((LBean)null);
        return;
      case LunEntityPackage.LBEAN_REFERENCE__OPPOSITE:
        setOpposite((LBeanReference)null);
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
      case LunEntityPackage.LBEAN_REFERENCE__LAZY:
        return lazy != LAZY_EDEFAULT;
      case LunEntityPackage.LBEAN_REFERENCE__CASCADING:
        return cascading != CASCADING_EDEFAULT;
      case LunEntityPackage.LBEAN_REFERENCE__TYPE:
        return type != null;
      case LunEntityPackage.LBEAN_REFERENCE__OPPOSITE:
        return opposite != null;
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
    if (baseClass == LReference.class)
    {
      switch (derivedFeatureID)
      {
        case LunEntityPackage.LBEAN_REFERENCE__LAZY: return LunTypesPackage.LREFERENCE__LAZY;
        case LunEntityPackage.LBEAN_REFERENCE__CASCADING: return LunTypesPackage.LREFERENCE__CASCADING;
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
    if (baseClass == LReference.class)
    {
      switch (baseFeatureID)
      {
        case LunTypesPackage.LREFERENCE__LAZY: return LunEntityPackage.LBEAN_REFERENCE__LAZY;
        case LunTypesPackage.LREFERENCE__CASCADING: return LunEntityPackage.LBEAN_REFERENCE__CASCADING;
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
    result.append(" (lazy: ");
    result.append(lazy);
    result.append(", cascading: ");
    result.append(cascading);
    result.append(')');
    return result.toString();
  }

} //LBeanReferenceImpl

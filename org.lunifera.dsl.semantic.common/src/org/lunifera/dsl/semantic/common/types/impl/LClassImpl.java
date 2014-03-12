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
package org.lunifera.dsl.semantic.common.types.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LClassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LClassImpl#isSerializable <em>Serializable</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LClassImpl#getShortName <em>Short Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LClassImpl extends LTypeImpl implements LClass
{
  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The default value of the '{@link #isSerializable() <em>Serializable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSerializable()
   * @generated
   * @ordered
   */
  protected static final boolean SERIALIZABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSerializable() <em>Serializable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSerializable()
   * @generated
   * @ordered
   */
  protected boolean serializable = SERIALIZABLE_EDEFAULT;

  /**
   * The default value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortName()
   * @generated
   * @ordered
   */
  protected static final String SHORT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortName()
   * @generated
   * @ordered
   */
  protected String shortName = SHORT_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LClassImpl()
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
    return LunTypesPackage.Literals.LCLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LCLASS__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSerializable()
  {
    return serializable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSerializable(boolean newSerializable)
  {
    boolean oldSerializable = serializable;
    serializable = newSerializable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LCLASS__SERIALIZABLE, oldSerializable, serializable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShortName()
  {
    return shortName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShortName(String newShortName)
  {
    String oldShortName = shortName;
    shortName = newShortName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LCLASS__SHORT_NAME, oldShortName, shortName));
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
      case LunTypesPackage.LCLASS__ABSTRACT:
        return isAbstract();
      case LunTypesPackage.LCLASS__SERIALIZABLE:
        return isSerializable();
      case LunTypesPackage.LCLASS__SHORT_NAME:
        return getShortName();
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
      case LunTypesPackage.LCLASS__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case LunTypesPackage.LCLASS__SERIALIZABLE:
        setSerializable((Boolean)newValue);
        return;
      case LunTypesPackage.LCLASS__SHORT_NAME:
        setShortName((String)newValue);
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
      case LunTypesPackage.LCLASS__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case LunTypesPackage.LCLASS__SERIALIZABLE:
        setSerializable(SERIALIZABLE_EDEFAULT);
        return;
      case LunTypesPackage.LCLASS__SHORT_NAME:
        setShortName(SHORT_NAME_EDEFAULT);
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
      case LunTypesPackage.LCLASS__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case LunTypesPackage.LCLASS__SERIALIZABLE:
        return serializable != SERIALIZABLE_EDEFAULT;
      case LunTypesPackage.LCLASS__SHORT_NAME:
        return SHORT_NAME_EDEFAULT == null ? shortName != null : !SHORT_NAME_EDEFAULT.equals(shortName);
    }
    return super.eIsSet(featureID);
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
    result.append(" (abstract: ");
    result.append(abstract_);
    result.append(", serializable: ");
    result.append(serializable);
    result.append(", shortName: ");
    result.append(shortName);
    result.append(')');
    return result.toString();
  }

} //LClassImpl

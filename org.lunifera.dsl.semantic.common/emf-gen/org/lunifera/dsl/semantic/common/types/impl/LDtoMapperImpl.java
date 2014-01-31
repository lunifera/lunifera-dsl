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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xbase.XExpression;

import org.lunifera.dsl.semantic.common.types.LDtoMapper;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDto Mapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDtoMapperImpl#getFromDto <em>From Dto</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDtoMapperImpl#getToDto <em>To Dto</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDtoMapperImpl extends MinimalEObjectImpl.Container implements LDtoMapper
{
  /**
   * The cached value of the '{@link #getFromDto() <em>From Dto</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFromDto()
   * @generated
   * @ordered
   */
  protected XExpression fromDto;

  /**
   * The cached value of the '{@link #getToDto() <em>To Dto</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToDto()
   * @generated
   * @ordered
   */
  protected XExpression toDto;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LDtoMapperImpl()
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
    return LunTypesPackage.Literals.LDTO_MAPPER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getFromDto()
  {
    return fromDto;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFromDto(XExpression newFromDto, NotificationChain msgs)
  {
    XExpression oldFromDto = fromDto;
    fromDto = newFromDto;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDTO_MAPPER__FROM_DTO, oldFromDto, newFromDto);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFromDto(XExpression newFromDto)
  {
    if (newFromDto != fromDto)
    {
      NotificationChain msgs = null;
      if (fromDto != null)
        msgs = ((InternalEObject)fromDto).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunTypesPackage.LDTO_MAPPER__FROM_DTO, null, msgs);
      if (newFromDto != null)
        msgs = ((InternalEObject)newFromDto).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunTypesPackage.LDTO_MAPPER__FROM_DTO, null, msgs);
      msgs = basicSetFromDto(newFromDto, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDTO_MAPPER__FROM_DTO, newFromDto, newFromDto));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getToDto()
  {
    return toDto;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToDto(XExpression newToDto, NotificationChain msgs)
  {
    XExpression oldToDto = toDto;
    toDto = newToDto;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDTO_MAPPER__TO_DTO, oldToDto, newToDto);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToDto(XExpression newToDto)
  {
    if (newToDto != toDto)
    {
      NotificationChain msgs = null;
      if (toDto != null)
        msgs = ((InternalEObject)toDto).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunTypesPackage.LDTO_MAPPER__TO_DTO, null, msgs);
      if (newToDto != null)
        msgs = ((InternalEObject)newToDto).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunTypesPackage.LDTO_MAPPER__TO_DTO, null, msgs);
      msgs = basicSetToDto(newToDto, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDTO_MAPPER__TO_DTO, newToDto, newToDto));
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
      case LunTypesPackage.LDTO_MAPPER__FROM_DTO:
        return basicSetFromDto(null, msgs);
      case LunTypesPackage.LDTO_MAPPER__TO_DTO:
        return basicSetToDto(null, msgs);
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
      case LunTypesPackage.LDTO_MAPPER__FROM_DTO:
        return getFromDto();
      case LunTypesPackage.LDTO_MAPPER__TO_DTO:
        return getToDto();
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
      case LunTypesPackage.LDTO_MAPPER__FROM_DTO:
        setFromDto((XExpression)newValue);
        return;
      case LunTypesPackage.LDTO_MAPPER__TO_DTO:
        setToDto((XExpression)newValue);
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
      case LunTypesPackage.LDTO_MAPPER__FROM_DTO:
        setFromDto((XExpression)null);
        return;
      case LunTypesPackage.LDTO_MAPPER__TO_DTO:
        setToDto((XExpression)null);
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
      case LunTypesPackage.LDTO_MAPPER__FROM_DTO:
        return fromDto != null;
      case LunTypesPackage.LDTO_MAPPER__TO_DTO:
        return toDto != null;
    }
    return super.eIsSet(featureID);
  }

} //LDtoMapperImpl

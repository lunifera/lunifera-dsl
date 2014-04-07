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
package org.lunifera.dsl.semantic.service.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.lunifera.dsl.semantic.dto.LDto;

import org.lunifera.dsl.semantic.service.LSupportedDTO;
import org.lunifera.dsl.semantic.service.LSupportedDTOCollection;
import org.lunifera.dsl.semantic.service.LSupportedFilters;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LSupported DTO</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LSupportedDTOImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LSupportedDTOImpl#getDto <em>Dto</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LSupportedDTOImpl#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LSupportedDTOImpl extends MinimalEObjectImpl.Container implements LSupportedDTO
{
  /**
   * The cached value of the '{@link #getDto() <em>Dto</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDto()
   * @generated
   * @ordered
   */
  protected LDto dto;

  /**
   * The cached value of the '{@link #getFilters() <em>Filters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilters()
   * @generated
   * @ordered
   */
  protected LSupportedFilters filters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LSupportedDTOImpl()
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
    return LunServicePackage.Literals.LSUPPORTED_DTO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSupportedDTOCollection getParent()
  {
    if (eContainerFeatureID() != LunServicePackage.LSUPPORTED_DTO__PARENT) return null;
    return (LSupportedDTOCollection)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSupportedDTOCollection basicGetParent()
  {
    if (eContainerFeatureID() != LunServicePackage.LSUPPORTED_DTO__PARENT) return null;
    return (LSupportedDTOCollection)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(LSupportedDTOCollection newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, LunServicePackage.LSUPPORTED_DTO__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(LSupportedDTOCollection newParent)
  {
    if (newParent != eInternalContainer() || (eContainerFeatureID() != LunServicePackage.LSUPPORTED_DTO__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, LunServicePackage.LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS, LSupportedDTOCollection.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LSUPPORTED_DTO__PARENT, newParent, newParent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDto getDto()
  {
    if (dto != null && dto.eIsProxy())
    {
      InternalEObject oldDto = (InternalEObject)dto;
      dto = (LDto)eResolveProxy(oldDto);
      if (dto != oldDto)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunServicePackage.LSUPPORTED_DTO__DTO, oldDto, dto));
      }
    }
    return dto;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDto basicGetDto()
  {
    return dto;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDto(LDto newDto)
  {
    LDto oldDto = dto;
    dto = newDto;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LSUPPORTED_DTO__DTO, oldDto, dto));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSupportedFilters getFilters()
  {
    return filters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFilters(LSupportedFilters newFilters, NotificationChain msgs)
  {
    LSupportedFilters oldFilters = filters;
    filters = newFilters;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LSUPPORTED_DTO__FILTERS, oldFilters, newFilters);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFilters(LSupportedFilters newFilters)
  {
    if (newFilters != filters)
    {
      NotificationChain msgs = null;
      if (filters != null)
        msgs = ((InternalEObject)filters).eInverseRemove(this, LunServicePackage.LSUPPORTED_FILTERS__PARENT, LSupportedFilters.class, msgs);
      if (newFilters != null)
        msgs = ((InternalEObject)newFilters).eInverseAdd(this, LunServicePackage.LSUPPORTED_FILTERS__PARENT, LSupportedFilters.class, msgs);
      msgs = basicSetFilters(newFilters, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LSUPPORTED_DTO__FILTERS, newFilters, newFilters));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LunServicePackage.LSUPPORTED_DTO__PARENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParent((LSupportedDTOCollection)otherEnd, msgs);
      case LunServicePackage.LSUPPORTED_DTO__FILTERS:
        if (filters != null)
          msgs = ((InternalEObject)filters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LSUPPORTED_DTO__FILTERS, null, msgs);
        return basicSetFilters((LSupportedFilters)otherEnd, msgs);
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
      case LunServicePackage.LSUPPORTED_DTO__PARENT:
        return basicSetParent(null, msgs);
      case LunServicePackage.LSUPPORTED_DTO__FILTERS:
        return basicSetFilters(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case LunServicePackage.LSUPPORTED_DTO__PARENT:
        return eInternalContainer().eInverseRemove(this, LunServicePackage.LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS, LSupportedDTOCollection.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
      case LunServicePackage.LSUPPORTED_DTO__PARENT:
        if (resolve) return getParent();
        return basicGetParent();
      case LunServicePackage.LSUPPORTED_DTO__DTO:
        if (resolve) return getDto();
        return basicGetDto();
      case LunServicePackage.LSUPPORTED_DTO__FILTERS:
        return getFilters();
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
      case LunServicePackage.LSUPPORTED_DTO__PARENT:
        setParent((LSupportedDTOCollection)newValue);
        return;
      case LunServicePackage.LSUPPORTED_DTO__DTO:
        setDto((LDto)newValue);
        return;
      case LunServicePackage.LSUPPORTED_DTO__FILTERS:
        setFilters((LSupportedFilters)newValue);
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
      case LunServicePackage.LSUPPORTED_DTO__PARENT:
        setParent((LSupportedDTOCollection)null);
        return;
      case LunServicePackage.LSUPPORTED_DTO__DTO:
        setDto((LDto)null);
        return;
      case LunServicePackage.LSUPPORTED_DTO__FILTERS:
        setFilters((LSupportedFilters)null);
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
      case LunServicePackage.LSUPPORTED_DTO__PARENT:
        return basicGetParent() != null;
      case LunServicePackage.LSUPPORTED_DTO__DTO:
        return dto != null;
      case LunServicePackage.LSUPPORTED_DTO__FILTERS:
        return filters != null;
    }
    return super.eIsSet(featureID);
  }

} //LSupportedDTOImpl

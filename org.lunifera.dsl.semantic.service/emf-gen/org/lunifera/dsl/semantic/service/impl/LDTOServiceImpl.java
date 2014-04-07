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

import org.lunifera.dsl.semantic.dto.LDto;

import org.lunifera.dsl.semantic.service.LDTOService;
import org.lunifera.dsl.semantic.service.LSupportedDTOCollection;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDTO Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getPrimaryDTO <em>Primary DTO</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl#getSupportedDTOs <em>Supported DT Os</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDTOServiceImpl extends LServiceImpl implements LDTOService
{
  /**
   * The cached value of the '{@link #getPrimaryDTO() <em>Primary DTO</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimaryDTO()
   * @generated
   * @ordered
   */
  protected LDto primaryDTO;

  /**
   * The cached value of the '{@link #getSupportedDTOs() <em>Supported DT Os</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupportedDTOs()
   * @generated
   * @ordered
   */
  protected LSupportedDTOCollection supportedDTOs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LDTOServiceImpl()
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
    return LunServicePackage.Literals.LDTO_SERVICE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDto getPrimaryDTO()
  {
    if (primaryDTO != null && primaryDTO.eIsProxy())
    {
      InternalEObject oldPrimaryDTO = (InternalEObject)primaryDTO;
      primaryDTO = (LDto)eResolveProxy(oldPrimaryDTO);
      if (primaryDTO != oldPrimaryDTO)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunServicePackage.LDTO_SERVICE__PRIMARY_DTO, oldPrimaryDTO, primaryDTO));
      }
    }
    return primaryDTO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDto basicGetPrimaryDTO()
  {
    return primaryDTO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimaryDTO(LDto newPrimaryDTO)
  {
    LDto oldPrimaryDTO = primaryDTO;
    primaryDTO = newPrimaryDTO;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__PRIMARY_DTO, oldPrimaryDTO, primaryDTO));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSupportedDTOCollection getSupportedDTOs()
  {
    return supportedDTOs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSupportedDTOs(LSupportedDTOCollection newSupportedDTOs, NotificationChain msgs)
  {
    LSupportedDTOCollection oldSupportedDTOs = supportedDTOs;
    supportedDTOs = newSupportedDTOs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS, oldSupportedDTOs, newSupportedDTOs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSupportedDTOs(LSupportedDTOCollection newSupportedDTOs)
  {
    if (newSupportedDTOs != supportedDTOs)
    {
      NotificationChain msgs = null;
      if (supportedDTOs != null)
        msgs = ((InternalEObject)supportedDTOs).eInverseRemove(this, LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE, LSupportedDTOCollection.class, msgs);
      if (newSupportedDTOs != null)
        msgs = ((InternalEObject)newSupportedDTOs).eInverseAdd(this, LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE, LSupportedDTOCollection.class, msgs);
      msgs = basicSetSupportedDTOs(newSupportedDTOs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS, newSupportedDTOs, newSupportedDTOs));
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
      case LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS:
        if (supportedDTOs != null)
          msgs = ((InternalEObject)supportedDTOs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS, null, msgs);
        return basicSetSupportedDTOs((LSupportedDTOCollection)otherEnd, msgs);
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
      case LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS:
        return basicSetSupportedDTOs(null, msgs);
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
      case LunServicePackage.LDTO_SERVICE__PRIMARY_DTO:
        if (resolve) return getPrimaryDTO();
        return basicGetPrimaryDTO();
      case LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS:
        return getSupportedDTOs();
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
      case LunServicePackage.LDTO_SERVICE__PRIMARY_DTO:
        setPrimaryDTO((LDto)newValue);
        return;
      case LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS:
        setSupportedDTOs((LSupportedDTOCollection)newValue);
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
      case LunServicePackage.LDTO_SERVICE__PRIMARY_DTO:
        setPrimaryDTO((LDto)null);
        return;
      case LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS:
        setSupportedDTOs((LSupportedDTOCollection)null);
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
      case LunServicePackage.LDTO_SERVICE__PRIMARY_DTO:
        return primaryDTO != null;
      case LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS:
        return supportedDTOs != null;
    }
    return super.eIsSet(featureID);
  }

} //LDTOServiceImpl

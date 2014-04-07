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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.lunifera.dsl.semantic.service.LDTOService;
import org.lunifera.dsl.semantic.service.LSupportedDTO;
import org.lunifera.dsl.semantic.service.LSupportedDTOCollection;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LSupported DTO Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LSupportedDTOCollectionImpl#getService <em>Service</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LSupportedDTOCollectionImpl#getSupportedDtos <em>Supported Dtos</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LSupportedDTOCollectionImpl extends MinimalEObjectImpl.Container implements LSupportedDTOCollection
{
  /**
   * The cached value of the '{@link #getSupportedDtos() <em>Supported Dtos</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupportedDtos()
   * @generated
   * @ordered
   */
  protected EList<LSupportedDTO> supportedDtos;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LSupportedDTOCollectionImpl()
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
    return LunServicePackage.Literals.LSUPPORTED_DTO_COLLECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDTOService getService()
  {
    if (eContainerFeatureID() != LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE) return null;
    return (LDTOService)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDTOService basicGetService()
  {
    if (eContainerFeatureID() != LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE) return null;
    return (LDTOService)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetService(LDTOService newService, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newService, LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setService(LDTOService newService)
  {
    if (newService != eInternalContainer() || (eContainerFeatureID() != LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE && newService != null))
    {
      if (EcoreUtil.isAncestor(this, newService))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newService != null)
        msgs = ((InternalEObject)newService).eInverseAdd(this, LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS, LDTOService.class, msgs);
      msgs = basicSetService(newService, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE, newService, newService));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LSupportedDTO> getSupportedDtos()
  {
    if (supportedDtos == null)
    {
      supportedDtos = new EObjectContainmentWithInverseEList<LSupportedDTO>(LSupportedDTO.class, this, LunServicePackage.LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS, LunServicePackage.LSUPPORTED_DTO__PARENT);
    }
    return supportedDtos;
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
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetService((LDTOService)otherEnd, msgs);
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupportedDtos()).basicAdd(otherEnd, msgs);
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
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE:
        return basicSetService(null, msgs);
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS:
        return ((InternalEList<?>)getSupportedDtos()).basicRemove(otherEnd, msgs);
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
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE:
        return eInternalContainer().eInverseRemove(this, LunServicePackage.LDTO_SERVICE__SUPPORTED_DT_OS, LDTOService.class, msgs);
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
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE:
        if (resolve) return getService();
        return basicGetService();
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS:
        return getSupportedDtos();
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
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE:
        setService((LDTOService)newValue);
        return;
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS:
        getSupportedDtos().clear();
        getSupportedDtos().addAll((Collection<? extends LSupportedDTO>)newValue);
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
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE:
        setService((LDTOService)null);
        return;
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS:
        getSupportedDtos().clear();
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
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SERVICE:
        return basicGetService() != null;
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS:
        return supportedDtos != null && !supportedDtos.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LSupportedDTOCollectionImpl

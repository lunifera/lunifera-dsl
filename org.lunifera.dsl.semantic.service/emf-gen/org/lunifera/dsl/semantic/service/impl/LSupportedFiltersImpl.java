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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.lunifera.dsl.semantic.dto.LDtoFeature;

import org.lunifera.dsl.semantic.service.LSupportedDTO;
import org.lunifera.dsl.semantic.service.LSupportedFilters;
import org.lunifera.dsl.semantic.service.LunServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LSupported Filters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LSupportedFiltersImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.impl.LSupportedFiltersImpl#getFilterFeatures <em>Filter Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LSupportedFiltersImpl extends MinimalEObjectImpl.Container implements LSupportedFilters
{
  /**
   * The cached value of the '{@link #getFilterFeatures() <em>Filter Features</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilterFeatures()
   * @generated
   * @ordered
   */
  protected EList<LDtoFeature> filterFeatures;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LSupportedFiltersImpl()
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
    return LunServicePackage.Literals.LSUPPORTED_FILTERS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSupportedDTO getParent()
  {
    if (eContainerFeatureID() != LunServicePackage.LSUPPORTED_FILTERS__PARENT) return null;
    return (LSupportedDTO)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSupportedDTO basicGetParent()
  {
    if (eContainerFeatureID() != LunServicePackage.LSUPPORTED_FILTERS__PARENT) return null;
    return (LSupportedDTO)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(LSupportedDTO newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, LunServicePackage.LSUPPORTED_FILTERS__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(LSupportedDTO newParent)
  {
    if (newParent != eInternalContainer() || (eContainerFeatureID() != LunServicePackage.LSUPPORTED_FILTERS__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, LunServicePackage.LSUPPORTED_DTO__FILTERS, LSupportedDTO.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunServicePackage.LSUPPORTED_FILTERS__PARENT, newParent, newParent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LDtoFeature> getFilterFeatures()
  {
    if (filterFeatures == null)
    {
      filterFeatures = new EObjectResolvingEList<LDtoFeature>(LDtoFeature.class, this, LunServicePackage.LSUPPORTED_FILTERS__FILTER_FEATURES);
    }
    return filterFeatures;
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
      case LunServicePackage.LSUPPORTED_FILTERS__PARENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParent((LSupportedDTO)otherEnd, msgs);
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
      case LunServicePackage.LSUPPORTED_FILTERS__PARENT:
        return basicSetParent(null, msgs);
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
      case LunServicePackage.LSUPPORTED_FILTERS__PARENT:
        return eInternalContainer().eInverseRemove(this, LunServicePackage.LSUPPORTED_DTO__FILTERS, LSupportedDTO.class, msgs);
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
      case LunServicePackage.LSUPPORTED_FILTERS__PARENT:
        if (resolve) return getParent();
        return basicGetParent();
      case LunServicePackage.LSUPPORTED_FILTERS__FILTER_FEATURES:
        return getFilterFeatures();
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
      case LunServicePackage.LSUPPORTED_FILTERS__PARENT:
        setParent((LSupportedDTO)newValue);
        return;
      case LunServicePackage.LSUPPORTED_FILTERS__FILTER_FEATURES:
        getFilterFeatures().clear();
        getFilterFeatures().addAll((Collection<? extends LDtoFeature>)newValue);
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
      case LunServicePackage.LSUPPORTED_FILTERS__PARENT:
        setParent((LSupportedDTO)null);
        return;
      case LunServicePackage.LSUPPORTED_FILTERS__FILTER_FEATURES:
        getFilterFeatures().clear();
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
      case LunServicePackage.LSUPPORTED_FILTERS__PARENT:
        return basicGetParent() != null;
      case LunServicePackage.LSUPPORTED_FILTERS__FILTER_FEATURES:
        return filterFeatures != null && !filterFeatures.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LSupportedFiltersImpl

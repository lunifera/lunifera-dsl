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
package org.lunifera.dsl.semantic.dto.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.lunifera.dsl.semantic.common.types.LMultiplicity;
import org.lunifera.dsl.semantic.common.types.LReference;

import org.lunifera.dsl.semantic.dto.LDtoInheritedReference;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDto Inherited Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoInheritedReferenceImpl#getInheritedFeature <em>Inherited Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDtoInheritedReferenceImpl extends LDtoAbstractReferenceImpl implements LDtoInheritedReference
{
  /**
   * The cached value of the '{@link #getInheritedFeature() <em>Inherited Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInheritedFeature()
   * @generated
   * @ordered
   */
  protected LReference inheritedFeature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LDtoInheritedReferenceImpl()
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
    return LunDtoPackage.Literals.LDTO_INHERITED_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LReference getInheritedFeature()
  {
    if (inheritedFeature != null && inheritedFeature.eIsProxy())
    {
      InternalEObject oldInheritedFeature = (InternalEObject)inheritedFeature;
      inheritedFeature = (LReference)eResolveProxy(oldInheritedFeature);
      if (inheritedFeature != oldInheritedFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunDtoPackage.LDTO_INHERITED_REFERENCE__INHERITED_FEATURE, oldInheritedFeature, inheritedFeature));
      }
    }
    return inheritedFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LReference basicGetInheritedFeature()
  {
    return inheritedFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInheritedFeature(LReference newInheritedFeature)
  {
    LReference oldInheritedFeature = inheritedFeature;
    inheritedFeature = newInheritedFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_INHERITED_REFERENCE__INHERITED_FEATURE, oldInheritedFeature, inheritedFeature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LMultiplicity getInheritedMultiplicity()
  {
    LReference _inheritedFeature = this.getInheritedFeature();
    return _inheritedFeature.getMultiplicity();
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
      case LunDtoPackage.LDTO_INHERITED_REFERENCE__INHERITED_FEATURE:
        if (resolve) return getInheritedFeature();
        return basicGetInheritedFeature();
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
      case LunDtoPackage.LDTO_INHERITED_REFERENCE__INHERITED_FEATURE:
        setInheritedFeature((LReference)newValue);
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
      case LunDtoPackage.LDTO_INHERITED_REFERENCE__INHERITED_FEATURE:
        setInheritedFeature((LReference)null);
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
      case LunDtoPackage.LDTO_INHERITED_REFERENCE__INHERITED_FEATURE:
        return inheritedFeature != null;
    }
    return super.eIsSet(featureID);
  }

} //LDtoInheritedReferenceImpl

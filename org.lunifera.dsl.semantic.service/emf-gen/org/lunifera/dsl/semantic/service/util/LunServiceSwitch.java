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
package org.lunifera.dsl.semantic.service.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.lunifera.dsl.semantic.common.types.LAnnotationTarget;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LType;

import org.lunifera.dsl.semantic.service.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.service.LunServicePackage
 * @generated
 */
public class LunServiceSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LunServicePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LunServiceSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = LunServicePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case LunServicePackage.LSERVICE_MODEL:
      {
        LServiceModel lServiceModel = (LServiceModel)theEObject;
        T result = caseLServiceModel(lServiceModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LunServicePackage.LSERVICE:
      {
        LService lService = (LService)theEObject;
        T result = caseLService(lService);
        if (result == null) result = caseLClass(lService);
        if (result == null) result = caseLType(lService);
        if (result == null) result = caseLAnnotationTarget(lService);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LunServicePackage.LINJECTED_SERVICES:
      {
        LInjectedServices lInjectedServices = (LInjectedServices)theEObject;
        T result = caseLInjectedServices(lInjectedServices);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LunServicePackage.LINJECTED_SERVICE:
      {
        LInjectedService lInjectedService = (LInjectedService)theEObject;
        T result = caseLInjectedService(lInjectedService);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LunServicePackage.LDTO_SERVICE:
      {
        LDTOService ldtoService = (LDTOService)theEObject;
        T result = caseLDTOService(ldtoService);
        if (result == null) result = caseLService(ldtoService);
        if (result == null) result = caseLClass(ldtoService);
        if (result == null) result = caseLType(ldtoService);
        if (result == null) result = caseLAnnotationTarget(ldtoService);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LunServicePackage.LFILTERABLE_ATTRIBUTES:
      {
        LFilterableAttributes lFilterableAttributes = (LFilterableAttributes)theEObject;
        T result = caseLFilterableAttributes(lFilterableAttributes);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LunServicePackage.LSORTABLE_ATTRIBUTES:
      {
        LSortableAttributes lSortableAttributes = (LSortableAttributes)theEObject;
        T result = caseLSortableAttributes(lSortableAttributes);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LunServicePackage.LCHART_SERVICE:
      {
        LChartService lChartService = (LChartService)theEObject;
        T result = caseLChartService(lChartService);
        if (result == null) result = caseLService(lChartService);
        if (result == null) result = caseLClass(lChartService);
        if (result == null) result = caseLType(lChartService);
        if (result == null) result = caseLAnnotationTarget(lChartService);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LunServicePackage.LFREE_SERVICE:
      {
        LFreeService lFreeService = (LFreeService)theEObject;
        T result = caseLFreeService(lFreeService);
        if (result == null) result = caseLService(lFreeService);
        if (result == null) result = caseLClass(lFreeService);
        if (result == null) result = caseLType(lFreeService);
        if (result == null) result = caseLAnnotationTarget(lFreeService);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LService Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LService Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLServiceModel(LServiceModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LService</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LService</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLService(LService object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LInjected Services</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LInjected Services</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLInjectedServices(LInjectedServices object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LInjected Service</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LInjected Service</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLInjectedService(LInjectedService object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LDTO Service</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LDTO Service</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLDTOService(LDTOService object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LFilterable Attributes</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LFilterable Attributes</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLFilterableAttributes(LFilterableAttributes object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LSortable Attributes</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LSortable Attributes</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLSortableAttributes(LSortableAttributes object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LChart Service</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LChart Service</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLChartService(LChartService object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LFree Service</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LFree Service</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLFreeService(LFreeService object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LAnnotation Target</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LAnnotation Target</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLAnnotationTarget(LAnnotationTarget object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LType</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LType</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLType(LType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LClass</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LClass</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLClass(LClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //LunServiceSwitch

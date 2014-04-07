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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.lunifera.dsl.semantic.service.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LunServiceFactoryImpl extends EFactoryImpl implements LunServiceFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LunServiceFactory init()
  {
    try
    {
      LunServiceFactory theLunServiceFactory = (LunServiceFactory)EPackage.Registry.INSTANCE.getEFactory(LunServicePackage.eNS_URI);
      if (theLunServiceFactory != null)
      {
        return theLunServiceFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LunServiceFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LunServiceFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case LunServicePackage.LSERVICE_MODEL: return createLServiceModel();
      case LunServicePackage.LDTO_SERVICE: return createLDTOService();
      case LunServicePackage.LSUPPORTED_DTO_COLLECTION: return createLSupportedDTOCollection();
      case LunServicePackage.LSUPPORTED_DTO: return createLSupportedDTO();
      case LunServicePackage.LSUPPORTED_FILTERS: return createLSupportedFilters();
      case LunServicePackage.LCHART_SERVICE: return createLChartService();
      case LunServicePackage.LFREE_SERVICE: return createLFreeService();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LServiceModel createLServiceModel()
  {
    LServiceModelImpl lServiceModel = new LServiceModelImpl();
    return lServiceModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDTOService createLDTOService()
  {
    LDTOServiceImpl ldtoService = new LDTOServiceImpl();
    return ldtoService;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSupportedDTOCollection createLSupportedDTOCollection()
  {
    LSupportedDTOCollectionImpl lSupportedDTOCollection = new LSupportedDTOCollectionImpl();
    return lSupportedDTOCollection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSupportedDTO createLSupportedDTO()
  {
    LSupportedDTOImpl lSupportedDTO = new LSupportedDTOImpl();
    return lSupportedDTO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSupportedFilters createLSupportedFilters()
  {
    LSupportedFiltersImpl lSupportedFilters = new LSupportedFiltersImpl();
    return lSupportedFilters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LChartService createLChartService()
  {
    LChartServiceImpl lChartService = new LChartServiceImpl();
    return lChartService;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LFreeService createLFreeService()
  {
    LFreeServiceImpl lFreeService = new LFreeServiceImpl();
    return lFreeService;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LunServicePackage getLunServicePackage()
  {
    return (LunServicePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LunServicePackage getPackage()
  {
    return LunServicePackage.eINSTANCE;
  }

} //LunServiceFactoryImpl

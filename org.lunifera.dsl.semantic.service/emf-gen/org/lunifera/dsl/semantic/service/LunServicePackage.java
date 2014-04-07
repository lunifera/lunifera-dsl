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
package org.lunifera.dsl.semantic.service;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.service.LunServiceFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel fileExtensions='services' modelName='Service' prefix='LunService' runtimeVersion='2.9' copyrightText='Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)\n All rights reserved. This program and the accompanying materials \n are made available under the terms of the Eclipse Public License v1.0 \n which accompanies this distribution, and is available at \n http://www.eclipse.org/legal/epl-v10.html \n\n Based on ideas from Xtext, Xtend, Xcore\n   \n Contributors:  \n \t\tFlorian Pirchner - Initial implementation \n ' operationReflection='false' basePackage='org.lunifera.dsl.semantic'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore rootPackage='services'"
 * @generated
 */
public interface LunServicePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "service";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.lunifera.org/dsl/services/v1";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "services";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LunServicePackage eINSTANCE = org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl.init();

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LServiceModelImpl <em>LService Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.service.impl.LServiceModelImpl
   * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLServiceModel()
   * @generated
   */
  int LSERVICE_MODEL = 0;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSERVICE_MODEL__PACKAGES = 0;

  /**
   * The number of structural features of the '<em>LService Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSERVICE_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LServiceImpl <em>LService</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.service.impl.LServiceImpl
   * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLService()
   * @generated
   */
  int LSERVICE = 1;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSERVICE__ANNOTATIONS = LunTypesPackage.LCLASS__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSERVICE__NAME = LunTypesPackage.LCLASS__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSERVICE__ANNOTATION_INFO = LunTypesPackage.LCLASS__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSERVICE__ABSTRACT = LunTypesPackage.LCLASS__ABSTRACT;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSERVICE__SERIALIZABLE = LunTypesPackage.LCLASS__SERIALIZABLE;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSERVICE__SHORT_NAME = LunTypesPackage.LCLASS__SHORT_NAME;

  /**
   * The number of structural features of the '<em>LService</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSERVICE_FEATURE_COUNT = LunTypesPackage.LCLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl <em>LDTO Service</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl
   * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLDTOService()
   * @generated
   */
  int LDTO_SERVICE = 2;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_SERVICE__ANNOTATIONS = LSERVICE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_SERVICE__NAME = LSERVICE__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_SERVICE__ANNOTATION_INFO = LSERVICE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_SERVICE__ABSTRACT = LSERVICE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_SERVICE__SERIALIZABLE = LSERVICE__SERIALIZABLE;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_SERVICE__SHORT_NAME = LSERVICE__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Primary DTO</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_SERVICE__PRIMARY_DTO = LSERVICE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Supported DT Os</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_SERVICE__SUPPORTED_DT_OS = LSERVICE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>LDTO Service</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_SERVICE_FEATURE_COUNT = LSERVICE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LSupportedDTOCollectionImpl <em>LSupported DTO Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.service.impl.LSupportedDTOCollectionImpl
   * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLSupportedDTOCollection()
   * @generated
   */
  int LSUPPORTED_DTO_COLLECTION = 3;

  /**
   * The feature id for the '<em><b>Service</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_DTO_COLLECTION__SERVICE = 0;

  /**
   * The feature id for the '<em><b>Supported Dtos</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS = 1;

  /**
   * The number of structural features of the '<em>LSupported DTO Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_DTO_COLLECTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LSupportedDTOImpl <em>LSupported DTO</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.service.impl.LSupportedDTOImpl
   * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLSupportedDTO()
   * @generated
   */
  int LSUPPORTED_DTO = 4;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_DTO__PARENT = 0;

  /**
   * The feature id for the '<em><b>Dto</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_DTO__DTO = 1;

  /**
   * The feature id for the '<em><b>Filters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_DTO__FILTERS = 2;

  /**
   * The number of structural features of the '<em>LSupported DTO</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_DTO_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LSupportedFiltersImpl <em>LSupported Filters</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.service.impl.LSupportedFiltersImpl
   * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLSupportedFilters()
   * @generated
   */
  int LSUPPORTED_FILTERS = 5;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_FILTERS__PARENT = 0;

  /**
   * The feature id for the '<em><b>Filter Features</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_FILTERS__FILTER_FEATURES = 1;

  /**
   * The number of structural features of the '<em>LSupported Filters</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSUPPORTED_FILTERS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LChartServiceImpl <em>LChart Service</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.service.impl.LChartServiceImpl
   * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLChartService()
   * @generated
   */
  int LCHART_SERVICE = 6;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCHART_SERVICE__ANNOTATIONS = LSERVICE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCHART_SERVICE__NAME = LSERVICE__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCHART_SERVICE__ANNOTATION_INFO = LSERVICE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCHART_SERVICE__ABSTRACT = LSERVICE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCHART_SERVICE__SERIALIZABLE = LSERVICE__SERIALIZABLE;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCHART_SERVICE__SHORT_NAME = LSERVICE__SHORT_NAME;

  /**
   * The number of structural features of the '<em>LChart Service</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCHART_SERVICE_FEATURE_COUNT = LSERVICE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LFreeServiceImpl <em>LFree Service</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.service.impl.LFreeServiceImpl
   * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLFreeService()
   * @generated
   */
  int LFREE_SERVICE = 7;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFREE_SERVICE__ANNOTATIONS = LSERVICE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFREE_SERVICE__NAME = LSERVICE__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFREE_SERVICE__ANNOTATION_INFO = LSERVICE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFREE_SERVICE__ABSTRACT = LSERVICE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFREE_SERVICE__SERIALIZABLE = LSERVICE__SERIALIZABLE;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFREE_SERVICE__SHORT_NAME = LSERVICE__SHORT_NAME;

  /**
   * The number of structural features of the '<em>LFree Service</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFREE_SERVICE_FEATURE_COUNT = LSERVICE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LServiceModel <em>LService Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LService Model</em>'.
   * @see org.lunifera.dsl.semantic.service.LServiceModel
   * @generated
   */
  EClass getLServiceModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.service.LServiceModel#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see org.lunifera.dsl.semantic.service.LServiceModel#getPackages()
   * @see #getLServiceModel()
   * @generated
   */
  EReference getLServiceModel_Packages();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LService <em>LService</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LService</em>'.
   * @see org.lunifera.dsl.semantic.service.LService
   * @generated
   */
  EClass getLService();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LDTOService <em>LDTO Service</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDTO Service</em>'.
   * @see org.lunifera.dsl.semantic.service.LDTOService
   * @generated
   */
  EClass getLDTOService();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getPrimaryDTO <em>Primary DTO</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Primary DTO</em>'.
   * @see org.lunifera.dsl.semantic.service.LDTOService#getPrimaryDTO()
   * @see #getLDTOService()
   * @generated
   */
  EReference getLDTOService_PrimaryDTO();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getSupportedDTOs <em>Supported DT Os</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Supported DT Os</em>'.
   * @see org.lunifera.dsl.semantic.service.LDTOService#getSupportedDTOs()
   * @see #getLDTOService()
   * @generated
   */
  EReference getLDTOService_SupportedDTOs();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LSupportedDTOCollection <em>LSupported DTO Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LSupported DTO Collection</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedDTOCollection
   * @generated
   */
  EClass getLSupportedDTOCollection();

  /**
   * Returns the meta object for the container reference '{@link org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getService <em>Service</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Service</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getService()
   * @see #getLSupportedDTOCollection()
   * @generated
   */
  EReference getLSupportedDTOCollection_Service();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getSupportedDtos <em>Supported Dtos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Supported Dtos</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedDTOCollection#getSupportedDtos()
   * @see #getLSupportedDTOCollection()
   * @generated
   */
  EReference getLSupportedDTOCollection_SupportedDtos();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LSupportedDTO <em>LSupported DTO</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LSupported DTO</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedDTO
   * @generated
   */
  EClass getLSupportedDTO();

  /**
   * Returns the meta object for the container reference '{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedDTO#getParent()
   * @see #getLSupportedDTO()
   * @generated
   */
  EReference getLSupportedDTO_Parent();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getDto <em>Dto</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Dto</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedDTO#getDto()
   * @see #getLSupportedDTO()
   * @generated
   */
  EReference getLSupportedDTO_Dto();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LSupportedDTO#getFilters <em>Filters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Filters</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedDTO#getFilters()
   * @see #getLSupportedDTO()
   * @generated
   */
  EReference getLSupportedDTO_Filters();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LSupportedFilters <em>LSupported Filters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LSupported Filters</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedFilters
   * @generated
   */
  EClass getLSupportedFilters();

  /**
   * Returns the meta object for the container reference '{@link org.lunifera.dsl.semantic.service.LSupportedFilters#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedFilters#getParent()
   * @see #getLSupportedFilters()
   * @generated
   */
  EReference getLSupportedFilters_Parent();

  /**
   * Returns the meta object for the reference list '{@link org.lunifera.dsl.semantic.service.LSupportedFilters#getFilterFeatures <em>Filter Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Filter Features</em>'.
   * @see org.lunifera.dsl.semantic.service.LSupportedFilters#getFilterFeatures()
   * @see #getLSupportedFilters()
   * @generated
   */
  EReference getLSupportedFilters_FilterFeatures();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LChartService <em>LChart Service</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LChart Service</em>'.
   * @see org.lunifera.dsl.semantic.service.LChartService
   * @generated
   */
  EClass getLChartService();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LFreeService <em>LFree Service</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LFree Service</em>'.
   * @see org.lunifera.dsl.semantic.service.LFreeService
   * @generated
   */
  EClass getLFreeService();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LunServiceFactory getLunServiceFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LServiceModelImpl <em>LService Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.service.impl.LServiceModelImpl
     * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLServiceModel()
     * @generated
     */
    EClass LSERVICE_MODEL = eINSTANCE.getLServiceModel();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LSERVICE_MODEL__PACKAGES = eINSTANCE.getLServiceModel_Packages();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LServiceImpl <em>LService</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.service.impl.LServiceImpl
     * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLService()
     * @generated
     */
    EClass LSERVICE = eINSTANCE.getLService();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl <em>LDTO Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl
     * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLDTOService()
     * @generated
     */
    EClass LDTO_SERVICE = eINSTANCE.getLDTOService();

    /**
     * The meta object literal for the '<em><b>Primary DTO</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_SERVICE__PRIMARY_DTO = eINSTANCE.getLDTOService_PrimaryDTO();

    /**
     * The meta object literal for the '<em><b>Supported DT Os</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_SERVICE__SUPPORTED_DT_OS = eINSTANCE.getLDTOService_SupportedDTOs();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LSupportedDTOCollectionImpl <em>LSupported DTO Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.service.impl.LSupportedDTOCollectionImpl
     * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLSupportedDTOCollection()
     * @generated
     */
    EClass LSUPPORTED_DTO_COLLECTION = eINSTANCE.getLSupportedDTOCollection();

    /**
     * The meta object literal for the '<em><b>Service</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LSUPPORTED_DTO_COLLECTION__SERVICE = eINSTANCE.getLSupportedDTOCollection_Service();

    /**
     * The meta object literal for the '<em><b>Supported Dtos</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LSUPPORTED_DTO_COLLECTION__SUPPORTED_DTOS = eINSTANCE.getLSupportedDTOCollection_SupportedDtos();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LSupportedDTOImpl <em>LSupported DTO</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.service.impl.LSupportedDTOImpl
     * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLSupportedDTO()
     * @generated
     */
    EClass LSUPPORTED_DTO = eINSTANCE.getLSupportedDTO();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LSUPPORTED_DTO__PARENT = eINSTANCE.getLSupportedDTO_Parent();

    /**
     * The meta object literal for the '<em><b>Dto</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LSUPPORTED_DTO__DTO = eINSTANCE.getLSupportedDTO_Dto();

    /**
     * The meta object literal for the '<em><b>Filters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LSUPPORTED_DTO__FILTERS = eINSTANCE.getLSupportedDTO_Filters();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LSupportedFiltersImpl <em>LSupported Filters</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.service.impl.LSupportedFiltersImpl
     * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLSupportedFilters()
     * @generated
     */
    EClass LSUPPORTED_FILTERS = eINSTANCE.getLSupportedFilters();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LSUPPORTED_FILTERS__PARENT = eINSTANCE.getLSupportedFilters_Parent();

    /**
     * The meta object literal for the '<em><b>Filter Features</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LSUPPORTED_FILTERS__FILTER_FEATURES = eINSTANCE.getLSupportedFilters_FilterFeatures();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LChartServiceImpl <em>LChart Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.service.impl.LChartServiceImpl
     * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLChartService()
     * @generated
     */
    EClass LCHART_SERVICE = eINSTANCE.getLChartService();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LFreeServiceImpl <em>LFree Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.service.impl.LFreeServiceImpl
     * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLFreeService()
     * @generated
     */
    EClass LFREE_SERVICE = eINSTANCE.getLFreeService();

  }

} //LunServicePackage

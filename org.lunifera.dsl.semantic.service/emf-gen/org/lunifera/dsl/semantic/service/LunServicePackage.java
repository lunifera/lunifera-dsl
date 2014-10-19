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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
public interface LunServicePackage extends EPackage {
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
	 * The feature id for the '<em><b>Injected Services</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LSERVICE__INJECTED_SERVICES = LunTypesPackage.LCLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LSERVICE__OPERATIONS = LunTypesPackage.LCLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>LService</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LSERVICE_FEATURE_COUNT = LunTypesPackage.LCLASS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LInjectedServicesImpl <em>LInjected Services</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.semantic.service.impl.LInjectedServicesImpl
	 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLInjectedServices()
	 * @generated
	 */
	int LINJECTED_SERVICES = 2;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINJECTED_SERVICES__SERVICES = 0;

	/**
	 * The number of structural features of the '<em>LInjected Services</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINJECTED_SERVICES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LInjectedServiceImpl <em>LInjected Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.semantic.service.impl.LInjectedServiceImpl
	 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLInjectedService()
	 * @generated
	 */
	int LINJECTED_SERVICE = 3;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINJECTED_SERVICE__CARDINALITY = 0;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINJECTED_SERVICE__ATTRIBUTE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINJECTED_SERVICE__SERVICE = 2;

	/**
	 * The number of structural features of the '<em>LInjected Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINJECTED_SERVICE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl <em>LDTO Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.semantic.service.impl.LDTOServiceImpl
	 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLDTOService()
	 * @generated
	 */
	int LDTO_SERVICE = 4;

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
	 * The feature id for the '<em><b>Injected Services</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__INJECTED_SERVICES = LSERVICE__INJECTED_SERVICES;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__OPERATIONS = LSERVICE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Dto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__DTO = LSERVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Persistence Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__PERSISTENCE_ID = LSERVICE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Filterable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__FILTERABLE = LSERVICE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sortable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__SORTABLE = LSERVICE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Get Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__GET_EXPRESSION = LSERVICE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Find Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__FIND_EXPRESSION = LSERVICE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Find Expression With Delimiter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER = LSERVICE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Update Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__UPDATE_EXPRESSION = LSERVICE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Delete Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE__DELETE_EXPRESSION = LSERVICE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>LDTO Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDTO_SERVICE_FEATURE_COUNT = LSERVICE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LFilterableAttributesImpl <em>LFilterable Attributes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.semantic.service.impl.LFilterableAttributesImpl
	 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLFilterableAttributes()
	 * @generated
	 */
	int LFILTERABLE_ATTRIBUTES = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LFILTERABLE_ATTRIBUTES__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Filterable Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LFILTERABLE_ATTRIBUTES__FILTERABLE_FEATURES = 1;

	/**
	 * The number of structural features of the '<em>LFilterable Attributes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LFILTERABLE_ATTRIBUTES_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LSortableAttributesImpl <em>LSortable Attributes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.semantic.service.impl.LSortableAttributesImpl
	 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLSortableAttributes()
	 * @generated
	 */
	int LSORTABLE_ATTRIBUTES = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LSORTABLE_ATTRIBUTES__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Sortable Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LSORTABLE_ATTRIBUTES__SORTABLE_FEATURES = 1;

	/**
	 * The number of structural features of the '<em>LSortable Attributes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LSORTABLE_ATTRIBUTES_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.semantic.service.impl.LChartServiceImpl <em>LChart Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.semantic.service.impl.LChartServiceImpl
	 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLChartService()
	 * @generated
	 */
	int LCHART_SERVICE = 7;

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
	 * The feature id for the '<em><b>Injected Services</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LCHART_SERVICE__INJECTED_SERVICES = LSERVICE__INJECTED_SERVICES;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LCHART_SERVICE__OPERATIONS = LSERVICE__OPERATIONS;

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
	int LFREE_SERVICE = 8;

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
	 * The feature id for the '<em><b>Injected Services</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LFREE_SERVICE__INJECTED_SERVICES = LSERVICE__INJECTED_SERVICES;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LFREE_SERVICE__OPERATIONS = LSERVICE__OPERATIONS;

	/**
	 * The number of structural features of the '<em>LFree Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LFREE_SERVICE_FEATURE_COUNT = LSERVICE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.semantic.service.LCardinality <em>LCardinality</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.semantic.service.LCardinality
	 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLCardinality()
	 * @generated
	 */
	int LCARDINALITY = 9;


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
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LService#getInjectedServices <em>Injected Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Injected Services</em>'.
	 * @see org.lunifera.dsl.semantic.service.LService#getInjectedServices()
	 * @see #getLService()
	 * @generated
	 */
	EReference getLService_InjectedServices();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.service.LService#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.lunifera.dsl.semantic.service.LService#getOperations()
	 * @see #getLService()
	 * @generated
	 */
	EReference getLService_Operations();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LInjectedServices <em>LInjected Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LInjected Services</em>'.
	 * @see org.lunifera.dsl.semantic.service.LInjectedServices
	 * @generated
	 */
	EClass getLInjectedServices();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.service.LInjectedServices#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see org.lunifera.dsl.semantic.service.LInjectedServices#getServices()
	 * @see #getLInjectedServices()
	 * @generated
	 */
	EReference getLInjectedServices_Services();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LInjectedService <em>LInjected Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LInjected Service</em>'.
	 * @see org.lunifera.dsl.semantic.service.LInjectedService
	 * @generated
	 */
	EClass getLInjectedService();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.service.LInjectedService#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see org.lunifera.dsl.semantic.service.LInjectedService#getCardinality()
	 * @see #getLInjectedService()
	 * @generated
	 */
	EAttribute getLInjectedService_Cardinality();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.service.LInjectedService#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see org.lunifera.dsl.semantic.service.LInjectedService#getAttributeName()
	 * @see #getLInjectedService()
	 * @generated
	 */
	EAttribute getLInjectedService_AttributeName();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LInjectedService#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see org.lunifera.dsl.semantic.service.LInjectedService#getService()
	 * @see #getLInjectedService()
	 * @generated
	 */
	EReference getLInjectedService_Service();

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
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getDto <em>Dto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dto</em>'.
	 * @see org.lunifera.dsl.semantic.service.LDTOService#getDto()
	 * @see #getLDTOService()
	 * @generated
	 */
	EReference getLDTOService_Dto();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.service.LDTOService#getPersistenceId <em>Persistence Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistence Id</em>'.
	 * @see org.lunifera.dsl.semantic.service.LDTOService#getPersistenceId()
	 * @see #getLDTOService()
	 * @generated
	 */
	EAttribute getLDTOService_PersistenceId();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getFilterable <em>Filterable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filterable</em>'.
	 * @see org.lunifera.dsl.semantic.service.LDTOService#getFilterable()
	 * @see #getLDTOService()
	 * @generated
	 */
	EReference getLDTOService_Filterable();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getSortable <em>Sortable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sortable</em>'.
	 * @see org.lunifera.dsl.semantic.service.LDTOService#getSortable()
	 * @see #getLDTOService()
	 * @generated
	 */
	EReference getLDTOService_Sortable();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getGetExpression <em>Get Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Get Expression</em>'.
	 * @see org.lunifera.dsl.semantic.service.LDTOService#getGetExpression()
	 * @see #getLDTOService()
	 * @generated
	 */
	EReference getLDTOService_GetExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getFindExpression <em>Find Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Find Expression</em>'.
	 * @see org.lunifera.dsl.semantic.service.LDTOService#getFindExpression()
	 * @see #getLDTOService()
	 * @generated
	 */
	EReference getLDTOService_FindExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getFindExpressionWithDelimiter <em>Find Expression With Delimiter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Find Expression With Delimiter</em>'.
	 * @see org.lunifera.dsl.semantic.service.LDTOService#getFindExpressionWithDelimiter()
	 * @see #getLDTOService()
	 * @generated
	 */
	EReference getLDTOService_FindExpressionWithDelimiter();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getUpdateExpression <em>Update Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Update Expression</em>'.
	 * @see org.lunifera.dsl.semantic.service.LDTOService#getUpdateExpression()
	 * @see #getLDTOService()
	 * @generated
	 */
	EReference getLDTOService_UpdateExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.service.LDTOService#getDeleteExpression <em>Delete Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Delete Expression</em>'.
	 * @see org.lunifera.dsl.semantic.service.LDTOService#getDeleteExpression()
	 * @see #getLDTOService()
	 * @generated
	 */
	EReference getLDTOService_DeleteExpression();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LFilterableAttributes <em>LFilterable Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LFilterable Attributes</em>'.
	 * @see org.lunifera.dsl.semantic.service.LFilterableAttributes
	 * @generated
	 */
	EClass getLFilterableAttributes();

	/**
	 * Returns the meta object for the container reference '{@link org.lunifera.dsl.semantic.service.LFilterableAttributes#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.lunifera.dsl.semantic.service.LFilterableAttributes#getParent()
	 * @see #getLFilterableAttributes()
	 * @generated
	 */
	EReference getLFilterableAttributes_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.semantic.service.LFilterableAttributes#getFilterableFeatures <em>Filterable Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Filterable Features</em>'.
	 * @see org.lunifera.dsl.semantic.service.LFilterableAttributes#getFilterableFeatures()
	 * @see #getLFilterableAttributes()
	 * @generated
	 */
	EReference getLFilterableAttributes_FilterableFeatures();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.semantic.service.LSortableAttributes <em>LSortable Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LSortable Attributes</em>'.
	 * @see org.lunifera.dsl.semantic.service.LSortableAttributes
	 * @generated
	 */
	EClass getLSortableAttributes();

	/**
	 * Returns the meta object for the container reference '{@link org.lunifera.dsl.semantic.service.LSortableAttributes#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.lunifera.dsl.semantic.service.LSortableAttributes#getParent()
	 * @see #getLSortableAttributes()
	 * @generated
	 */
	EReference getLSortableAttributes_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.semantic.service.LSortableAttributes#getSortableFeatures <em>Sortable Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sortable Features</em>'.
	 * @see org.lunifera.dsl.semantic.service.LSortableAttributes#getSortableFeatures()
	 * @see #getLSortableAttributes()
	 * @generated
	 */
	EReference getLSortableAttributes_SortableFeatures();

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
	 * Returns the meta object for enum '{@link org.lunifera.dsl.semantic.service.LCardinality <em>LCardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>LCardinality</em>'.
	 * @see org.lunifera.dsl.semantic.service.LCardinality
	 * @generated
	 */
	EEnum getLCardinality();

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
	interface Literals {
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
		 * The meta object literal for the '<em><b>Injected Services</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LSERVICE__INJECTED_SERVICES = eINSTANCE.getLService_InjectedServices();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LSERVICE__OPERATIONS = eINSTANCE.getLService_Operations();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LInjectedServicesImpl <em>LInjected Services</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.semantic.service.impl.LInjectedServicesImpl
		 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLInjectedServices()
		 * @generated
		 */
		EClass LINJECTED_SERVICES = eINSTANCE.getLInjectedServices();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINJECTED_SERVICES__SERVICES = eINSTANCE.getLInjectedServices_Services();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LInjectedServiceImpl <em>LInjected Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.semantic.service.impl.LInjectedServiceImpl
		 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLInjectedService()
		 * @generated
		 */
		EClass LINJECTED_SERVICE = eINSTANCE.getLInjectedService();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINJECTED_SERVICE__CARDINALITY = eINSTANCE.getLInjectedService_Cardinality();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINJECTED_SERVICE__ATTRIBUTE_NAME = eINSTANCE.getLInjectedService_AttributeName();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINJECTED_SERVICE__SERVICE = eINSTANCE.getLInjectedService_Service();

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
		 * The meta object literal for the '<em><b>Dto</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDTO_SERVICE__DTO = eINSTANCE.getLDTOService_Dto();

		/**
		 * The meta object literal for the '<em><b>Persistence Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LDTO_SERVICE__PERSISTENCE_ID = eINSTANCE.getLDTOService_PersistenceId();

		/**
		 * The meta object literal for the '<em><b>Filterable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDTO_SERVICE__FILTERABLE = eINSTANCE.getLDTOService_Filterable();

		/**
		 * The meta object literal for the '<em><b>Sortable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDTO_SERVICE__SORTABLE = eINSTANCE.getLDTOService_Sortable();

		/**
		 * The meta object literal for the '<em><b>Get Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDTO_SERVICE__GET_EXPRESSION = eINSTANCE.getLDTOService_GetExpression();

		/**
		 * The meta object literal for the '<em><b>Find Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDTO_SERVICE__FIND_EXPRESSION = eINSTANCE.getLDTOService_FindExpression();

		/**
		 * The meta object literal for the '<em><b>Find Expression With Delimiter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDTO_SERVICE__FIND_EXPRESSION_WITH_DELIMITER = eINSTANCE.getLDTOService_FindExpressionWithDelimiter();

		/**
		 * The meta object literal for the '<em><b>Update Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDTO_SERVICE__UPDATE_EXPRESSION = eINSTANCE.getLDTOService_UpdateExpression();

		/**
		 * The meta object literal for the '<em><b>Delete Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDTO_SERVICE__DELETE_EXPRESSION = eINSTANCE.getLDTOService_DeleteExpression();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LFilterableAttributesImpl <em>LFilterable Attributes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.semantic.service.impl.LFilterableAttributesImpl
		 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLFilterableAttributes()
		 * @generated
		 */
		EClass LFILTERABLE_ATTRIBUTES = eINSTANCE.getLFilterableAttributes();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LFILTERABLE_ATTRIBUTES__PARENT = eINSTANCE.getLFilterableAttributes_Parent();

		/**
		 * The meta object literal for the '<em><b>Filterable Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LFILTERABLE_ATTRIBUTES__FILTERABLE_FEATURES = eINSTANCE.getLFilterableAttributes_FilterableFeatures();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.impl.LSortableAttributesImpl <em>LSortable Attributes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.semantic.service.impl.LSortableAttributesImpl
		 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLSortableAttributes()
		 * @generated
		 */
		EClass LSORTABLE_ATTRIBUTES = eINSTANCE.getLSortableAttributes();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LSORTABLE_ATTRIBUTES__PARENT = eINSTANCE.getLSortableAttributes_Parent();

		/**
		 * The meta object literal for the '<em><b>Sortable Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LSORTABLE_ATTRIBUTES__SORTABLE_FEATURES = eINSTANCE.getLSortableAttributes_SortableFeatures();

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

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.semantic.service.LCardinality <em>LCardinality</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.semantic.service.LCardinality
		 * @see org.lunifera.dsl.semantic.service.impl.LunServicePackageImpl#getLCardinality()
		 * @generated
		 */
		EEnum LCARDINALITY = eINSTANCE.getLCardinality();

	}

} //LunServicePackage

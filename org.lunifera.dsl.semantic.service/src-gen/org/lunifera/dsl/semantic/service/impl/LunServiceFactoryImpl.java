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
import org.eclipse.emf.ecore.EDataType;
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
public class LunServiceFactoryImpl extends EFactoryImpl implements LunServiceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LunServiceFactory init() {
		try {
			LunServiceFactory theLunServiceFactory = (LunServiceFactory)EPackage.Registry.INSTANCE.getEFactory(LunServicePackage.eNS_URI);
			if (theLunServiceFactory != null) {
				return theLunServiceFactory;
			}
		}
		catch (Exception exception) {
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
	public LunServiceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LunServicePackage.LSERVICE_MODEL: return createLServiceModel();
			case LunServicePackage.LINJECTED_SERVICES: return createLInjectedServices();
			case LunServicePackage.LINJECTED_SERVICE: return createLInjectedService();
			case LunServicePackage.LDTO_SERVICE: return createLDTOService();
			case LunServicePackage.LFILTERABLE_ATTRIBUTES: return createLFilterableAttributes();
			case LunServicePackage.LSORTABLE_ATTRIBUTES: return createLSortableAttributes();
			case LunServicePackage.LCHART_SERVICE: return createLChartService();
			case LunServicePackage.LFREE_SERVICE: return createLFreeService();
			case LunServicePackage.LSERVICE_OPERATION: return createLServiceOperation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case LunServicePackage.LCARDINALITY:
				return createLCardinalityFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case LunServicePackage.LCARDINALITY:
				return convertLCardinalityToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LServiceModel createLServiceModel() {
		LServiceModelImpl lServiceModel = new LServiceModelImpl();
		return lServiceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LInjectedServices createLInjectedServices() {
		LInjectedServicesImpl lInjectedServices = new LInjectedServicesImpl();
		return lInjectedServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LInjectedService createLInjectedService() {
		LInjectedServiceImpl lInjectedService = new LInjectedServiceImpl();
		return lInjectedService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDTOService createLDTOService() {
		LDTOServiceImpl ldtoService = new LDTOServiceImpl();
		return ldtoService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LFilterableAttributes createLFilterableAttributes() {
		LFilterableAttributesImpl lFilterableAttributes = new LFilterableAttributesImpl();
		return lFilterableAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LSortableAttributes createLSortableAttributes() {
		LSortableAttributesImpl lSortableAttributes = new LSortableAttributesImpl();
		return lSortableAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LChartService createLChartService() {
		LChartServiceImpl lChartService = new LChartServiceImpl();
		return lChartService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LFreeService createLFreeService() {
		LFreeServiceImpl lFreeService = new LFreeServiceImpl();
		return lFreeService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LServiceOperation createLServiceOperation() {
		LServiceOperationImpl lServiceOperation = new LServiceOperationImpl();
		return lServiceOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LCardinality createLCardinalityFromString(EDataType eDataType, String initialValue) {
		LCardinality result = LCardinality.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLCardinalityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LunServicePackage getLunServicePackage() {
		return (LunServicePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LunServicePackage getPackage() {
		return LunServicePackage.eINSTANCE;
	}

} //LunServiceFactoryImpl

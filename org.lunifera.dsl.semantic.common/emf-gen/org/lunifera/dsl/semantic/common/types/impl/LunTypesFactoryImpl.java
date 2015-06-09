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
package org.lunifera.dsl.semantic.common.types.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.lunifera.dsl.semantic.common.types.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LunTypesFactoryImpl extends EFactoryImpl implements LunTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LunTypesFactory init() {
		try {
			LunTypesFactory theLunTypesFactory = (LunTypesFactory)EPackage.Registry.INSTANCE.getEFactory(LunTypesPackage.eNS_URI);
			if (theLunTypesFactory != null) {
				return theLunTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LunTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LunTypesFactoryImpl() {
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
			case LunTypesPackage.LCOMMON_MODEL: return createLCommonModel();
			case LunTypesPackage.LLAZY_RESOLVER: return createLLazyResolver();
			case LunTypesPackage.LPACKAGE: return createLPackage();
			case LunTypesPackage.LTYPED_PACKAGE: return createLTypedPackage();
			case LunTypesPackage.LIMPORT: return createLImport();
			case LunTypesPackage.LTYPE: return createLType();
			case LunTypesPackage.LANNOTATION_DEF: return createLAnnotationDef();
			case LunTypesPackage.LANNOTATION_TARGET: return createLAnnotationTarget();
			case LunTypesPackage.LSCALAR_TYPE: return createLScalarType();
			case LunTypesPackage.LDATA_TYPE: return createLDataType();
			case LunTypesPackage.LENUM: return createLEnum();
			case LunTypesPackage.LENUM_LITERAL: return createLEnumLiteral();
			case LunTypesPackage.LCLASS: return createLClass();
			case LunTypesPackage.LKEY_AND_VALUE: return createLKeyAndValue();
			case LunTypesPackage.LOPERATION: return createLOperation();
			case LunTypesPackage.LMODIFIER: return createLModifier();
			case LunTypesPackage.LMULTIPLICITY: return createLMultiplicity();
			case LunTypesPackage.LCONSTRAINTS: return createLConstraints();
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT: return createLAttributeMatchingConstraint();
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
			case LunTypesPackage.LDATE_TYPE:
				return createLDateTypeFromString(eDataType, initialValue);
			case LunTypesPackage.LVISIBILITY:
				return createLVisibilityFromString(eDataType, initialValue);
			case LunTypesPackage.LLOWER_BOUND:
				return createLLowerBoundFromString(eDataType, initialValue);
			case LunTypesPackage.LUPPER_BOUND:
				return createLUpperBoundFromString(eDataType, initialValue);
			case LunTypesPackage.LCOMPARATOR_TYPE:
				return createLComparatorTypeFromString(eDataType, initialValue);
			case LunTypesPackage.OPERATIONS_LIST:
				return createOperationsListFromString(eDataType, initialValue);
			case LunTypesPackage.FEATURES_LIST:
				return createFeaturesListFromString(eDataType, initialValue);
			case LunTypesPackage.ANNOTATION_LIST:
				return createAnnotationListFromString(eDataType, initialValue);
			case LunTypesPackage.INTERNAL_EOBJECT:
				return createInternalEObjectFromString(eDataType, initialValue);
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
			case LunTypesPackage.LDATE_TYPE:
				return convertLDateTypeToString(eDataType, instanceValue);
			case LunTypesPackage.LVISIBILITY:
				return convertLVisibilityToString(eDataType, instanceValue);
			case LunTypesPackage.LLOWER_BOUND:
				return convertLLowerBoundToString(eDataType, instanceValue);
			case LunTypesPackage.LUPPER_BOUND:
				return convertLUpperBoundToString(eDataType, instanceValue);
			case LunTypesPackage.LCOMPARATOR_TYPE:
				return convertLComparatorTypeToString(eDataType, instanceValue);
			case LunTypesPackage.OPERATIONS_LIST:
				return convertOperationsListToString(eDataType, instanceValue);
			case LunTypesPackage.FEATURES_LIST:
				return convertFeaturesListToString(eDataType, instanceValue);
			case LunTypesPackage.ANNOTATION_LIST:
				return convertAnnotationListToString(eDataType, instanceValue);
			case LunTypesPackage.INTERNAL_EOBJECT:
				return convertInternalEObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LCommonModel createLCommonModel() {
		LCommonModelImpl lCommonModel = new LCommonModelImpl();
		return lCommonModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LLazyResolver createLLazyResolver() {
		LLazyResolverImpl lLazyResolver = new LLazyResolverImpl();
		return lLazyResolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LPackage createLPackage() {
		LPackageImpl lPackage = new LPackageImpl();
		return lPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LTypedPackage createLTypedPackage() {
		LTypedPackageImpl lTypedPackage = new LTypedPackageImpl();
		return lTypedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LImport createLImport() {
		LImportImpl lImport = new LImportImpl();
		return lImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LType createLType() {
		LTypeImpl lType = new LTypeImpl();
		return lType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAnnotationDef createLAnnotationDef() {
		LAnnotationDefImpl lAnnotationDef = new LAnnotationDefImpl();
		return lAnnotationDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAnnotationTarget createLAnnotationTarget() {
		LAnnotationTargetImpl lAnnotationTarget = new LAnnotationTargetImpl();
		return lAnnotationTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LScalarType createLScalarType() {
		LScalarTypeImpl lScalarType = new LScalarTypeImpl();
		return lScalarType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDataType createLDataType() {
		LDataTypeImpl lDataType = new LDataTypeImpl();
		return lDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEnum createLEnum() {
		LEnumImpl lEnum = new LEnumImpl();
		return lEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEnumLiteral createLEnumLiteral() {
		LEnumLiteralImpl lEnumLiteral = new LEnumLiteralImpl();
		return lEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LClass createLClass() {
		LClassImpl lClass = new LClassImpl();
		return lClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LKeyAndValue createLKeyAndValue() {
		LKeyAndValueImpl lKeyAndValue = new LKeyAndValueImpl();
		return lKeyAndValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LOperation createLOperation() {
		LOperationImpl lOperation = new LOperationImpl();
		return lOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LModifier createLModifier() {
		LModifierImpl lModifier = new LModifierImpl();
		return lModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LMultiplicity createLMultiplicity() {
		LMultiplicityImpl lMultiplicity = new LMultiplicityImpl();
		return lMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LConstraints createLConstraints() {
		LConstraintsImpl lConstraints = new LConstraintsImpl();
		return lConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAttributeMatchingConstraint createLAttributeMatchingConstraint() {
		LAttributeMatchingConstraintImpl lAttributeMatchingConstraint = new LAttributeMatchingConstraintImpl();
		return lAttributeMatchingConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDateType createLDateTypeFromString(EDataType eDataType, String initialValue) {
		LDateType result = LDateType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLDateTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LVisibility createLVisibilityFromString(EDataType eDataType, String initialValue) {
		LVisibility result = LVisibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLVisibilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LLowerBound createLLowerBoundFromString(EDataType eDataType, String initialValue) {
		LLowerBound result = LLowerBound.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLLowerBoundToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LUpperBound createLUpperBoundFromString(EDataType eDataType, String initialValue) {
		LUpperBound result = LUpperBound.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLUpperBoundToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LComparatorType createLComparatorTypeFromString(EDataType eDataType, String initialValue) {
		LComparatorType result = LComparatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLComparatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<LOperation> createOperationsListFromString(EDataType eDataType, String initialValue) {
		return (List<LOperation>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationsListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<? extends LFeature> createFeaturesListFromString(EDataType eDataType, String initialValue) {
		return (List<? extends LFeature>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeaturesListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<LAnnotationDef> createAnnotationListFromString(EDataType eDataType, String initialValue) {
		return (EList<LAnnotationDef>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAnnotationListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalEObject createInternalEObjectFromString(EDataType eDataType, String initialValue) {
		return (InternalEObject)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInternalEObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LunTypesPackage getLunTypesPackage() {
		return (LunTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LunTypesPackage getPackage() {
		return LunTypesPackage.eINSTANCE;
	}

} //LunTypesFactoryImpl

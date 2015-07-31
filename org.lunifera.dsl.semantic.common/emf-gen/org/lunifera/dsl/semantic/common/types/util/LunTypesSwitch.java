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
package org.lunifera.dsl.semantic.common.types.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.lunifera.dsl.semantic.common.types.*;

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
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage
 * @generated
 */
public class LunTypesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LunTypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LunTypesSwitch() {
		if (modelPackage == null) {
			modelPackage = LunTypesPackage.eINSTANCE;
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
	protected boolean isSwitchFor(EPackage ePackage) {
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
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case LunTypesPackage.LCOMMON_MODEL: {
				LCommonModel lCommonModel = (LCommonModel)theEObject;
				T result = caseLCommonModel(lCommonModel);
				if (result == null) result = caseLLazyResolver(lCommonModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LLAZY_RESOLVER: {
				LLazyResolver lLazyResolver = (LLazyResolver)theEObject;
				T result = caseLLazyResolver(lLazyResolver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LPACKAGE: {
				LPackage lPackage = (LPackage)theEObject;
				T result = caseLPackage(lPackage);
				if (result == null) result = caseLLazyResolver(lPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LTYPED_PACKAGE: {
				LTypedPackage lTypedPackage = (LTypedPackage)theEObject;
				T result = caseLTypedPackage(lTypedPackage);
				if (result == null) result = caseLPackage(lTypedPackage);
				if (result == null) result = caseLLazyResolver(lTypedPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LIMPORT: {
				LImport lImport = (LImport)theEObject;
				T result = caseLImport(lImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LTYPE: {
				LType lType = (LType)theEObject;
				T result = caseLType(lType);
				if (result == null) result = caseLAnnotationTarget(lType);
				if (result == null) result = caseLLazyResolver(lType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LANNOTATION_DEF: {
				LAnnotationDef lAnnotationDef = (LAnnotationDef)theEObject;
				T result = caseLAnnotationDef(lAnnotationDef);
				if (result == null) result = caseLLazyResolver(lAnnotationDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LANNOTATION_TARGET: {
				LAnnotationTarget lAnnotationTarget = (LAnnotationTarget)theEObject;
				T result = caseLAnnotationTarget(lAnnotationTarget);
				if (result == null) result = caseLLazyResolver(lAnnotationTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LSCALAR_TYPE: {
				LScalarType lScalarType = (LScalarType)theEObject;
				T result = caseLScalarType(lScalarType);
				if (result == null) result = caseLType(lScalarType);
				if (result == null) result = caseLAnnotationTarget(lScalarType);
				if (result == null) result = caseLLazyResolver(lScalarType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDATA_TYPE: {
				LDataType lDataType = (LDataType)theEObject;
				T result = caseLDataType(lDataType);
				if (result == null) result = caseLScalarType(lDataType);
				if (result == null) result = caseLType(lDataType);
				if (result == null) result = caseLAnnotationTarget(lDataType);
				if (result == null) result = caseLLazyResolver(lDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LENUM: {
				LEnum lEnum = (LEnum)theEObject;
				T result = caseLEnum(lEnum);
				if (result == null) result = caseLScalarType(lEnum);
				if (result == null) result = caseLType(lEnum);
				if (result == null) result = caseLAnnotationTarget(lEnum);
				if (result == null) result = caseLLazyResolver(lEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LENUM_LITERAL: {
				LEnumLiteral lEnumLiteral = (LEnumLiteral)theEObject;
				T result = caseLEnumLiteral(lEnumLiteral);
				if (result == null) result = caseLLazyResolver(lEnumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LCLASS: {
				LClass lClass = (LClass)theEObject;
				T result = caseLClass(lClass);
				if (result == null) result = caseLType(lClass);
				if (result == null) result = caseLAnnotationTarget(lClass);
				if (result == null) result = caseLLazyResolver(lClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LFEATURES_HOLDER: {
				LFeaturesHolder lFeaturesHolder = (LFeaturesHolder)theEObject;
				T result = caseLFeaturesHolder(lFeaturesHolder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LFEATURE: {
				LFeature lFeature = (LFeature)theEObject;
				T result = caseLFeature(lFeature);
				if (result == null) result = caseLAnnotationTarget(lFeature);
				if (result == null) result = caseLLazyResolver(lFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LREFERENCE: {
				LReference lReference = (LReference)theEObject;
				T result = caseLReference(lReference);
				if (result == null) result = caseLFeature(lReference);
				if (result == null) result = caseLAnnotationTarget(lReference);
				if (result == null) result = caseLLazyResolver(lReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LATTRIBUTE: {
				LAttribute lAttribute = (LAttribute)theEObject;
				T result = caseLAttribute(lAttribute);
				if (result == null) result = caseLFeature(lAttribute);
				if (result == null) result = caseLAnnotationTarget(lAttribute);
				if (result == null) result = caseLLazyResolver(lAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LKEY_AND_VALUE: {
				LKeyAndValue lKeyAndValue = (LKeyAndValue)theEObject;
				T result = caseLKeyAndValue(lKeyAndValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LOPERATION: {
				LOperation lOperation = (LOperation)theEObject;
				T result = caseLOperation(lOperation);
				if (result == null) result = caseLAnnotationTarget(lOperation);
				if (result == null) result = caseLLazyResolver(lOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LMODIFIER: {
				LModifier lModifier = (LModifier)theEObject;
				T result = caseLModifier(lModifier);
				if (result == null) result = caseLLazyResolver(lModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LMULTIPLICITY: {
				LMultiplicity lMultiplicity = (LMultiplicity)theEObject;
				T result = caseLMultiplicity(lMultiplicity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LCONSTRAINT: {
				LConstraint lConstraint = (LConstraint)theEObject;
				T result = caseLConstraint(lConstraint);
				if (result == null) result = caseLLazyResolver(lConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LRESULT_FILTERS: {
				LResultFilters lResultFilters = (LResultFilters)theEObject;
				T result = caseLResultFilters(lResultFilters);
				if (result == null) result = caseLLazyResolver(lResultFilters);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LRESULT_FILTER: {
				LResultFilter lResultFilter = (LResultFilter)theEObject;
				T result = caseLResultFilter(lResultFilter);
				if (result == null) result = caseLConstraint(lResultFilter);
				if (result == null) result = caseLLazyResolver(lResultFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT: {
				LAttributeMatchingConstraint lAttributeMatchingConstraint = (LAttributeMatchingConstraint)theEObject;
				T result = caseLAttributeMatchingConstraint(lAttributeMatchingConstraint);
				if (result == null) result = caseLResultFilter(lAttributeMatchingConstraint);
				if (result == null) result = caseLConstraint(lAttributeMatchingConstraint);
				if (result == null) result = caseLLazyResolver(lAttributeMatchingConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDATATYPE_CONSTRAINT: {
				LDatatypeConstraint lDatatypeConstraint = (LDatatypeConstraint)theEObject;
				T result = caseLDatatypeConstraint(lDatatypeConstraint);
				if (result == null) result = caseLConstraint(lDatatypeConstraint);
				if (result == null) result = caseLLazyResolver(lDatatypeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LSTRING_CONSTRAINT: {
				LStringConstraint lStringConstraint = (LStringConstraint)theEObject;
				T result = caseLStringConstraint(lStringConstraint);
				if (result == null) result = caseLDatatypeConstraint(lStringConstraint);
				if (result == null) result = caseLConstraint(lStringConstraint);
				if (result == null) result = caseLLazyResolver(lStringConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LNUMERIC_CONSTRAINT: {
				LNumericConstraint lNumericConstraint = (LNumericConstraint)theEObject;
				T result = caseLNumericConstraint(lNumericConstraint);
				if (result == null) result = caseLDatatypeConstraint(lNumericConstraint);
				if (result == null) result = caseLConstraint(lNumericConstraint);
				if (result == null) result = caseLLazyResolver(lNumericConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDECIMAL_CONSTRAINT: {
				LDecimalConstraint lDecimalConstraint = (LDecimalConstraint)theEObject;
				T result = caseLDecimalConstraint(lDecimalConstraint);
				if (result == null) result = caseLDatatypeConstraint(lDecimalConstraint);
				if (result == null) result = caseLConstraint(lDecimalConstraint);
				if (result == null) result = caseLLazyResolver(lDecimalConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDATE_CONSTRAINT: {
				LDateConstraint lDateConstraint = (LDateConstraint)theEObject;
				T result = caseLDateConstraint(lDateConstraint);
				if (result == null) result = caseLDatatypeConstraint(lDateConstraint);
				if (result == null) result = caseLConstraint(lDateConstraint);
				if (result == null) result = caseLLazyResolver(lDateConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LBOOLEAN_CONSTRAINT: {
				LBooleanConstraint lBooleanConstraint = (LBooleanConstraint)theEObject;
				T result = caseLBooleanConstraint(lBooleanConstraint);
				if (result == null) result = caseLDatatypeConstraint(lBooleanConstraint);
				if (result == null) result = caseLConstraint(lBooleanConstraint);
				if (result == null) result = caseLLazyResolver(lBooleanConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LBLOB_CONSTRAINT: {
				LBlobConstraint lBlobConstraint = (LBlobConstraint)theEObject;
				T result = caseLBlobConstraint(lBlobConstraint);
				if (result == null) result = caseLDatatypeConstraint(lBlobConstraint);
				if (result == null) result = caseLConstraint(lBlobConstraint);
				if (result == null) result = caseLLazyResolver(lBlobConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CASSERT_FALSE: {
				LDtCAssertFalse lDtCAssertFalse = (LDtCAssertFalse)theEObject;
				T result = caseLDtCAssertFalse(lDtCAssertFalse);
				if (result == null) result = caseLBooleanConstraint(lDtCAssertFalse);
				if (result == null) result = caseLDatatypeConstraint(lDtCAssertFalse);
				if (result == null) result = caseLConstraint(lDtCAssertFalse);
				if (result == null) result = caseLLazyResolver(lDtCAssertFalse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CASSERT_TRUE: {
				LDtCAssertTrue lDtCAssertTrue = (LDtCAssertTrue)theEObject;
				T result = caseLDtCAssertTrue(lDtCAssertTrue);
				if (result == null) result = caseLBooleanConstraint(lDtCAssertTrue);
				if (result == null) result = caseLDatatypeConstraint(lDtCAssertTrue);
				if (result == null) result = caseLConstraint(lDtCAssertTrue);
				if (result == null) result = caseLLazyResolver(lDtCAssertTrue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CDECIMAL_MAX: {
				LDtCDecimalMax lDtCDecimalMax = (LDtCDecimalMax)theEObject;
				T result = caseLDtCDecimalMax(lDtCDecimalMax);
				if (result == null) result = caseLDecimalConstraint(lDtCDecimalMax);
				if (result == null) result = caseLDatatypeConstraint(lDtCDecimalMax);
				if (result == null) result = caseLConstraint(lDtCDecimalMax);
				if (result == null) result = caseLLazyResolver(lDtCDecimalMax);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CDECIMAL_MIN: {
				LDtCDecimalMin lDtCDecimalMin = (LDtCDecimalMin)theEObject;
				T result = caseLDtCDecimalMin(lDtCDecimalMin);
				if (result == null) result = caseLDecimalConstraint(lDtCDecimalMin);
				if (result == null) result = caseLDatatypeConstraint(lDtCDecimalMin);
				if (result == null) result = caseLConstraint(lDtCDecimalMin);
				if (result == null) result = caseLLazyResolver(lDtCDecimalMin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CDIGITS: {
				LDtCDigits lDtCDigits = (LDtCDigits)theEObject;
				T result = caseLDtCDigits(lDtCDigits);
				if (result == null) result = caseLDecimalConstraint(lDtCDigits);
				if (result == null) result = caseLDatatypeConstraint(lDtCDigits);
				if (result == null) result = caseLConstraint(lDtCDigits);
				if (result == null) result = caseLLazyResolver(lDtCDigits);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CFUTURE: {
				LDtCFuture lDtCFuture = (LDtCFuture)theEObject;
				T result = caseLDtCFuture(lDtCFuture);
				if (result == null) result = caseLDateConstraint(lDtCFuture);
				if (result == null) result = caseLDatatypeConstraint(lDtCFuture);
				if (result == null) result = caseLConstraint(lDtCFuture);
				if (result == null) result = caseLLazyResolver(lDtCFuture);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CPAST: {
				LDtCPast lDtCPast = (LDtCPast)theEObject;
				T result = caseLDtCPast(lDtCPast);
				if (result == null) result = caseLDateConstraint(lDtCPast);
				if (result == null) result = caseLDatatypeConstraint(lDtCPast);
				if (result == null) result = caseLConstraint(lDtCPast);
				if (result == null) result = caseLLazyResolver(lDtCPast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CNUMERIC_MAX: {
				LDtCNumericMax lDtCNumericMax = (LDtCNumericMax)theEObject;
				T result = caseLDtCNumericMax(lDtCNumericMax);
				if (result == null) result = caseLNumericConstraint(lDtCNumericMax);
				if (result == null) result = caseLDatatypeConstraint(lDtCNumericMax);
				if (result == null) result = caseLConstraint(lDtCNumericMax);
				if (result == null) result = caseLLazyResolver(lDtCNumericMax);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CNUMERIC_MIN: {
				LDtCNumericMin lDtCNumericMin = (LDtCNumericMin)theEObject;
				T result = caseLDtCNumericMin(lDtCNumericMin);
				if (result == null) result = caseLNumericConstraint(lDtCNumericMin);
				if (result == null) result = caseLDatatypeConstraint(lDtCNumericMin);
				if (result == null) result = caseLConstraint(lDtCNumericMin);
				if (result == null) result = caseLLazyResolver(lDtCNumericMin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CNOT_NULL: {
				LDtCNotNull lDtCNotNull = (LDtCNotNull)theEObject;
				T result = caseLDtCNotNull(lDtCNotNull);
				if (result == null) result = caseLBlobConstraint(lDtCNotNull);
				if (result == null) result = caseLDateConstraint(lDtCNotNull);
				if (result == null) result = caseLStringConstraint(lDtCNotNull);
				if (result == null) result = caseLBooleanConstraint(lDtCNotNull);
				if (result == null) result = caseLDecimalConstraint(lDtCNotNull);
				if (result == null) result = caseLNumericConstraint(lDtCNotNull);
				if (result == null) result = caseLDatatypeConstraint(lDtCNotNull);
				if (result == null) result = caseLConstraint(lDtCNotNull);
				if (result == null) result = caseLLazyResolver(lDtCNotNull);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CNULL: {
				LDtCNull lDtCNull = (LDtCNull)theEObject;
				T result = caseLDtCNull(lDtCNull);
				if (result == null) result = caseLBlobConstraint(lDtCNull);
				if (result == null) result = caseLDateConstraint(lDtCNull);
				if (result == null) result = caseLStringConstraint(lDtCNull);
				if (result == null) result = caseLBooleanConstraint(lDtCNull);
				if (result == null) result = caseLDecimalConstraint(lDtCNull);
				if (result == null) result = caseLNumericConstraint(lDtCNull);
				if (result == null) result = caseLDatatypeConstraint(lDtCNull);
				if (result == null) result = caseLConstraint(lDtCNull);
				if (result == null) result = caseLLazyResolver(lDtCNull);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CREG_EX: {
				LDtCRegEx lDtCRegEx = (LDtCRegEx)theEObject;
				T result = caseLDtCRegEx(lDtCRegEx);
				if (result == null) result = caseLStringConstraint(lDtCRegEx);
				if (result == null) result = caseLDatatypeConstraint(lDtCRegEx);
				if (result == null) result = caseLConstraint(lDtCRegEx);
				if (result == null) result = caseLLazyResolver(lDtCRegEx);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunTypesPackage.LDT_CSIZE: {
				LDtCSize lDtCSize = (LDtCSize)theEObject;
				T result = caseLDtCSize(lDtCSize);
				if (result == null) result = caseLStringConstraint(lDtCSize);
				if (result == null) result = caseLDatatypeConstraint(lDtCSize);
				if (result == null) result = caseLConstraint(lDtCSize);
				if (result == null) result = caseLLazyResolver(lDtCSize);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LCommon Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LCommon Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLCommonModel(LCommonModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LLazy Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LLazy Resolver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLLazyResolver(LLazyResolver object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLPackage(LPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LTyped Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LTyped Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLTypedPackage(LTypedPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LImport</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LImport</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLImport(LImport object) {
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
	public T caseLType(LType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LAnnotation Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LAnnotation Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLAnnotationDef(LAnnotationDef object) {
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
	public T caseLAnnotationTarget(LAnnotationTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LScalar Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LScalar Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLScalarType(LScalarType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LData Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LData Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDataType(LDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEnum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEnum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEnum(LEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEnum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEnum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEnumLiteral(LEnumLiteral object) {
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
	public T caseLClass(LClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LFeatures Holder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LFeatures Holder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLFeaturesHolder(LFeaturesHolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LFeature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LFeature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLFeature(LFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LReference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LReference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLReference(LReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LAttribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LAttribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLAttribute(LAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LKey And Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LKey And Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLKeyAndValue(LKeyAndValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LOperation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LOperation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLOperation(LOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LModifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LModifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLModifier(LModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LMultiplicity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LMultiplicity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLMultiplicity(LMultiplicity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LConstraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LConstraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLConstraint(LConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LResult Filters</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LResult Filters</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLResultFilters(LResultFilters object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LResult Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LResult Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLResultFilter(LResultFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LAttribute Matching Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LAttribute Matching Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLAttributeMatchingConstraint(LAttributeMatchingConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDatatype Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDatatype Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDatatypeConstraint(LDatatypeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LString Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LString Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLStringConstraint(LStringConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LNumeric Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LNumeric Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLNumericConstraint(LNumericConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDecimal Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDecimal Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDecimalConstraint(LDecimalConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDate Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDate Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDateConstraint(LDateConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LBoolean Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LBoolean Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLBooleanConstraint(LBooleanConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LBlob Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LBlob Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLBlobConstraint(LBlobConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CAssert False</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CAssert False</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCAssertFalse(LDtCAssertFalse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CAssert True</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CAssert True</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCAssertTrue(LDtCAssertTrue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CDecimal Max</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CDecimal Max</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCDecimalMax(LDtCDecimalMax object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CDecimal Min</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CDecimal Min</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCDecimalMin(LDtCDecimalMin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CDigits</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CDigits</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCDigits(LDtCDigits object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CFuture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CFuture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCFuture(LDtCFuture object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CPast</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CPast</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCPast(LDtCPast object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CNumeric Max</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CNumeric Max</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCNumericMax(LDtCNumericMax object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CNumeric Min</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CNumeric Min</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCNumericMin(LDtCNumericMin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CNot Null</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CNot Null</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCNotNull(LDtCNotNull object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CNull</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CNull</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCNull(LDtCNull object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CReg Ex</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CReg Ex</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCRegEx(LDtCRegEx object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDt CSize</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDt CSize</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtCSize(LDtCSize object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //LunTypesSwitch

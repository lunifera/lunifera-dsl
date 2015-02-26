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

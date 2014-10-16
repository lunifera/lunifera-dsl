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
package org.lunifera.dsl.semantic.dto.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.lunifera.dsl.semantic.common.types.LAnnotationTarget;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LFeaturesHolder;
import org.lunifera.dsl.semantic.common.types.LOperation;
import org.lunifera.dsl.semantic.common.types.LReference;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.common.types.LType;

import org.lunifera.dsl.semantic.dto.*;

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
 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage
 * @generated
 */
public class LunDtoSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LunDtoPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LunDtoSwitch() {
		if (modelPackage == null) {
			modelPackage = LunDtoPackage.eINSTANCE;
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
			case LunDtoPackage.LDTO_MODEL: {
				LDtoModel lDtoModel = (LDtoModel)theEObject;
				T result = caseLDtoModel(lDtoModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO: {
				LDto lDto = (LDto)theEObject;
				T result = caseLDto(lDto);
				if (result == null) result = caseLClass(lDto);
				if (result == null) result = caseLFeaturesHolder(lDto);
				if (result == null) result = caseLScalarType(lDto);
				if (result == null) result = caseLType(lDto);
				if (result == null) result = caseLAnnotationTarget(lDto);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LAUTO_INHERIT_DTO: {
				LAutoInheritDto lAutoInheritDto = (LAutoInheritDto)theEObject;
				T result = caseLAutoInheritDto(lAutoInheritDto);
				if (result == null) result = caseLDto(lAutoInheritDto);
				if (result == null) result = caseLClass(lAutoInheritDto);
				if (result == null) result = caseLFeaturesHolder(lAutoInheritDto);
				if (result == null) result = caseLScalarType(lAutoInheritDto);
				if (result == null) result = caseLType(lAutoInheritDto);
				if (result == null) result = caseLAnnotationTarget(lAutoInheritDto);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO_MAPPER: {
				LDtoMapper lDtoMapper = (LDtoMapper)theEObject;
				T result = caseLDtoMapper(lDtoMapper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO_FEATURE: {
				LDtoFeature lDtoFeature = (LDtoFeature)theEObject;
				T result = caseLDtoFeature(lDtoFeature);
				if (result == null) result = caseLFeature(lDtoFeature);
				if (result == null) result = caseLAnnotationTarget(lDtoFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO_ABSTRACT_ATTRIBUTE: {
				LDtoAbstractAttribute lDtoAbstractAttribute = (LDtoAbstractAttribute)theEObject;
				T result = caseLDtoAbstractAttribute(lDtoAbstractAttribute);
				if (result == null) result = caseLDtoFeature(lDtoAbstractAttribute);
				if (result == null) result = caseLAttribute(lDtoAbstractAttribute);
				if (result == null) result = caseLFeature(lDtoAbstractAttribute);
				if (result == null) result = caseLAnnotationTarget(lDtoAbstractAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE: {
				LDtoInheritedAttribute lDtoInheritedAttribute = (LDtoInheritedAttribute)theEObject;
				T result = caseLDtoInheritedAttribute(lDtoInheritedAttribute);
				if (result == null) result = caseLDtoAbstractAttribute(lDtoInheritedAttribute);
				if (result == null) result = caseLDtoFeature(lDtoInheritedAttribute);
				if (result == null) result = caseLAttribute(lDtoInheritedAttribute);
				if (result == null) result = caseLFeature(lDtoInheritedAttribute);
				if (result == null) result = caseLAnnotationTarget(lDtoInheritedAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO_ATTRIBUTE: {
				LDtoAttribute lDtoAttribute = (LDtoAttribute)theEObject;
				T result = caseLDtoAttribute(lDtoAttribute);
				if (result == null) result = caseLDtoAbstractAttribute(lDtoAttribute);
				if (result == null) result = caseLDtoFeature(lDtoAttribute);
				if (result == null) result = caseLAttribute(lDtoAttribute);
				if (result == null) result = caseLFeature(lDtoAttribute);
				if (result == null) result = caseLAnnotationTarget(lDtoAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO_ABSTRACT_REFERENCE: {
				LDtoAbstractReference lDtoAbstractReference = (LDtoAbstractReference)theEObject;
				T result = caseLDtoAbstractReference(lDtoAbstractReference);
				if (result == null) result = caseLDtoFeature(lDtoAbstractReference);
				if (result == null) result = caseLReference(lDtoAbstractReference);
				if (result == null) result = caseLFeature(lDtoAbstractReference);
				if (result == null) result = caseLAnnotationTarget(lDtoAbstractReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO_INHERITED_REFERENCE: {
				LDtoInheritedReference lDtoInheritedReference = (LDtoInheritedReference)theEObject;
				T result = caseLDtoInheritedReference(lDtoInheritedReference);
				if (result == null) result = caseLDtoAbstractReference(lDtoInheritedReference);
				if (result == null) result = caseLDtoFeature(lDtoInheritedReference);
				if (result == null) result = caseLReference(lDtoInheritedReference);
				if (result == null) result = caseLFeature(lDtoInheritedReference);
				if (result == null) result = caseLAnnotationTarget(lDtoInheritedReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO_REFERENCE: {
				LDtoReference lDtoReference = (LDtoReference)theEObject;
				T result = caseLDtoReference(lDtoReference);
				if (result == null) result = caseLDtoAbstractReference(lDtoReference);
				if (result == null) result = caseLDtoFeature(lDtoReference);
				if (result == null) result = caseLReference(lDtoReference);
				if (result == null) result = caseLFeature(lDtoReference);
				if (result == null) result = caseLAnnotationTarget(lDtoReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LunDtoPackage.LDTO_OPERATION: {
				LDtoOperation lDtoOperation = (LDtoOperation)theEObject;
				T result = caseLDtoOperation(lDtoOperation);
				if (result == null) result = caseLOperation(lDtoOperation);
				if (result == null) result = caseLDtoFeature(lDtoOperation);
				if (result == null) result = caseLFeature(lDtoOperation);
				if (result == null) result = caseLAnnotationTarget(lDtoOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoModel(LDtoModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDto(LDto object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LAuto Inherit Dto</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LAuto Inherit Dto</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLAutoInheritDto(LAutoInheritDto object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Mapper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Mapper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoMapper(LDtoMapper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoFeature(LDtoFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Abstract Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Abstract Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoAbstractAttribute(LDtoAbstractAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Inherited Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Inherited Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoInheritedAttribute(LDtoInheritedAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoAttribute(LDtoAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Abstract Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Abstract Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoAbstractReference(LDtoAbstractReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Inherited Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Inherited Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoInheritedReference(LDtoInheritedReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoReference(LDtoReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LDto Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LDto Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLDtoOperation(LDtoOperation object) {
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

} //LunDtoSwitch

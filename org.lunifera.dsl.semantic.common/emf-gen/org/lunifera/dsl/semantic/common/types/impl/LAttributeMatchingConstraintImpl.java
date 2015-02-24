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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint;
import org.lunifera.dsl.semantic.common.types.LComparatorType;
import org.lunifera.dsl.semantic.common.types.LEnumLiteral;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LAttribute Matching Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LAttributeMatchingConstraintImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LAttributeMatchingConstraintImpl#getComparatorType <em>Comparator Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LAttributeMatchingConstraintImpl#getMatchingValue <em>Matching Value</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LAttributeMatchingConstraintImpl#getMatchingLiteral <em>Matching Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LAttributeMatchingConstraintImpl extends LLazyResolverImpl implements LAttributeMatchingConstraint {
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected LAttribute attribute;

	/**
	 * The default value of the '{@link #getComparatorType() <em>Comparator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparatorType()
	 * @generated
	 * @ordered
	 */
	protected static final LComparatorType COMPARATOR_TYPE_EDEFAULT = LComparatorType.EQUALS;

	/**
	 * The cached value of the '{@link #getComparatorType() <em>Comparator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparatorType()
	 * @generated
	 * @ordered
	 */
	protected LComparatorType comparatorType = COMPARATOR_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMatchingValue() <em>Matching Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchingValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MATCHING_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMatchingValue() <em>Matching Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchingValue()
	 * @generated
	 * @ordered
	 */
	protected String matchingValue = MATCHING_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMatchingLiteral() <em>Matching Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchingLiteral()
	 * @generated
	 * @ordered
	 */
	protected LEnumLiteral matchingLiteral;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LAttributeMatchingConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunTypesPackage.Literals.LATTRIBUTE_MATCHING_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAttribute getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (LAttribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAttribute basicGetAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(LAttribute newAttribute) {
		LAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LComparatorType getComparatorType() {
		return comparatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComparatorType(LComparatorType newComparatorType) {
		LComparatorType oldComparatorType = comparatorType;
		comparatorType = newComparatorType == null ? COMPARATOR_TYPE_EDEFAULT : newComparatorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__COMPARATOR_TYPE, oldComparatorType, comparatorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMatchingValue() {
		return matchingValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatchingValue(String newMatchingValue) {
		String oldMatchingValue = matchingValue;
		matchingValue = newMatchingValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_VALUE, oldMatchingValue, matchingValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEnumLiteral getMatchingLiteral() {
		if (matchingLiteral != null && matchingLiteral.eIsProxy()) {
			InternalEObject oldMatchingLiteral = (InternalEObject)matchingLiteral;
			matchingLiteral = (LEnumLiteral)eResolveProxy(oldMatchingLiteral);
			if (matchingLiteral != oldMatchingLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_LITERAL, oldMatchingLiteral, matchingLiteral));
			}
		}
		return matchingLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEnumLiteral basicGetMatchingLiteral() {
		return matchingLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatchingLiteral(LEnumLiteral newMatchingLiteral) {
		LEnumLiteral oldMatchingLiteral = matchingLiteral;
		matchingLiteral = newMatchingLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_LITERAL, oldMatchingLiteral, matchingLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__COMPARATOR_TYPE:
				return getComparatorType();
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_VALUE:
				return getMatchingValue();
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_LITERAL:
				if (resolve) return getMatchingLiteral();
				return basicGetMatchingLiteral();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__ATTRIBUTE:
				setAttribute((LAttribute)newValue);
				return;
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__COMPARATOR_TYPE:
				setComparatorType((LComparatorType)newValue);
				return;
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_VALUE:
				setMatchingValue((String)newValue);
				return;
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_LITERAL:
				setMatchingLiteral((LEnumLiteral)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__ATTRIBUTE:
				setAttribute((LAttribute)null);
				return;
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__COMPARATOR_TYPE:
				setComparatorType(COMPARATOR_TYPE_EDEFAULT);
				return;
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_VALUE:
				setMatchingValue(MATCHING_VALUE_EDEFAULT);
				return;
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_LITERAL:
				setMatchingLiteral((LEnumLiteral)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__ATTRIBUTE:
				return attribute != null;
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__COMPARATOR_TYPE:
				return comparatorType != COMPARATOR_TYPE_EDEFAULT;
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_VALUE:
				return MATCHING_VALUE_EDEFAULT == null ? matchingValue != null : !MATCHING_VALUE_EDEFAULT.equals(matchingValue);
			case LunTypesPackage.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_LITERAL:
				return matchingLiteral != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (comparatorType: ");
		result.append(comparatorType);
		result.append(", matchingValue: ");
		result.append(matchingValue);
		result.append(')');
		return result.toString();
	}

} //LAttributeMatchingConstraintImpl

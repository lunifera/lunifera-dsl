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

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.lunifera.dsl.semantic.common.types.LLowerBound;
import org.lunifera.dsl.semantic.common.types.LMultiplicity;
import org.lunifera.dsl.semantic.common.types.LUpperBound;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LMultiplicity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LMultiplicityImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LMultiplicityImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LMultiplicityImpl#getToMultiplicityString <em>To Multiplicity String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LMultiplicityImpl extends MinimalEObjectImpl.Container implements LMultiplicity {
	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final LLowerBound LOWER_EDEFAULT = LLowerBound.NULL;

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected LLowerBound lower = LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final LUpperBound UPPER_EDEFAULT = LUpperBound.NULL;

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected LUpperBound upper = UPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getToMultiplicityString() <em>To Multiplicity String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToMultiplicityString()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_MULTIPLICITY_STRING_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LMultiplicityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunTypesPackage.Literals.LMULTIPLICITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LLowerBound getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(LLowerBound newLower) {
		LLowerBound oldLower = lower;
		lower = newLower == null ? LOWER_EDEFAULT : newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LMULTIPLICITY__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LUpperBound getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(LUpperBound newUpper) {
		LUpperBound oldUpper = upper;
		upper = newUpper == null ? UPPER_EDEFAULT : newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LMULTIPLICITY__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToMultiplicityString() {
		StringBuilder result = new StringBuilder();
		LLowerBound _lower = this.getLower();
		if (_lower != null) {
			switch (_lower) {
				case NULL:
					result.append("0");
					break;
				case MANY:
					result.append("1");
					break;
				case OPTIONAL:
					result.append("0");
					break;
				case ATLEASTONE:
					result.append("1");
					break;
				case ZERO:
					result.append("0");
					break;
				case ONE:
					result.append("1");
					break;
				default:
					result.append("undefined");
					break;
			}
		}
		else {
			result.append("undefined");
		}
		result.append("..");
		LUpperBound _upper = this.getUpper();
		if (_upper != null) {
			switch (_upper) {
				case NULL:
					result.append("0");
					break;
				case MANY:
					result.append("*");
					break;
				case ONE:
					result.append("1");
					break;
				default:
					result.append("undefined");
					break;
			}
		}
		else {
			result.append("undefined");
		}
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LunTypesPackage.LMULTIPLICITY__LOWER:
				return getLower();
			case LunTypesPackage.LMULTIPLICITY__UPPER:
				return getUpper();
			case LunTypesPackage.LMULTIPLICITY__TO_MULTIPLICITY_STRING:
				return getToMultiplicityString();
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
			case LunTypesPackage.LMULTIPLICITY__LOWER:
				setLower((LLowerBound)newValue);
				return;
			case LunTypesPackage.LMULTIPLICITY__UPPER:
				setUpper((LUpperBound)newValue);
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
			case LunTypesPackage.LMULTIPLICITY__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case LunTypesPackage.LMULTIPLICITY__UPPER:
				setUpper(UPPER_EDEFAULT);
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
			case LunTypesPackage.LMULTIPLICITY__LOWER:
				return lower != LOWER_EDEFAULT;
			case LunTypesPackage.LMULTIPLICITY__UPPER:
				return upper != UPPER_EDEFAULT;
			case LunTypesPackage.LMULTIPLICITY__TO_MULTIPLICITY_STRING:
				return TO_MULTIPLICITY_STRING_EDEFAULT == null ? getToMultiplicityString() != null : !TO_MULTIPLICITY_STRING_EDEFAULT.equals(getToMultiplicityString());
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
		result.append(" (lower: ");
		result.append(lower);
		result.append(", upper: ");
		result.append(upper);
		result.append(')');
		return result.toString();
	}

} //LMultiplicityImpl

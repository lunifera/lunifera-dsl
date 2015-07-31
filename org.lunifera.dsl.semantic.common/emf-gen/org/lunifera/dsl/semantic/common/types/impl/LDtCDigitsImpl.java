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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.lunifera.dsl.semantic.common.types.LDtCDigits;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDt CDigits</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDtCDigitsImpl#getIntDigits <em>Int Digits</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDtCDigitsImpl#getFractionDigits <em>Fraction Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDtCDigitsImpl extends LLazyResolverImpl implements LDtCDigits {
	/**
	 * The default value of the '{@link #getIntDigits() <em>Int Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntDigits()
	 * @generated
	 * @ordered
	 */
	protected static final int INT_DIGITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntDigits() <em>Int Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntDigits()
	 * @generated
	 * @ordered
	 */
	protected int intDigits = INT_DIGITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFractionDigits() <em>Fraction Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionDigits()
	 * @generated
	 * @ordered
	 */
	protected static final int FRACTION_DIGITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFractionDigits() <em>Fraction Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionDigits()
	 * @generated
	 * @ordered
	 */
	protected int fractionDigits = FRACTION_DIGITS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LDtCDigitsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunTypesPackage.Literals.LDT_CDIGITS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntDigits() {
		return intDigits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntDigits(int newIntDigits) {
		int oldIntDigits = intDigits;
		intDigits = newIntDigits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDT_CDIGITS__INT_DIGITS, oldIntDigits, intDigits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFractionDigits() {
		return fractionDigits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFractionDigits(int newFractionDigits) {
		int oldFractionDigits = fractionDigits;
		fractionDigits = newFractionDigits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDT_CDIGITS__FRACTION_DIGITS, oldFractionDigits, fractionDigits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isForPrimitives() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LunTypesPackage.LDT_CDIGITS__INT_DIGITS:
				return getIntDigits();
			case LunTypesPackage.LDT_CDIGITS__FRACTION_DIGITS:
				return getFractionDigits();
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
			case LunTypesPackage.LDT_CDIGITS__INT_DIGITS:
				setIntDigits((Integer)newValue);
				return;
			case LunTypesPackage.LDT_CDIGITS__FRACTION_DIGITS:
				setFractionDigits((Integer)newValue);
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
			case LunTypesPackage.LDT_CDIGITS__INT_DIGITS:
				setIntDigits(INT_DIGITS_EDEFAULT);
				return;
			case LunTypesPackage.LDT_CDIGITS__FRACTION_DIGITS:
				setFractionDigits(FRACTION_DIGITS_EDEFAULT);
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
			case LunTypesPackage.LDT_CDIGITS__INT_DIGITS:
				return intDigits != INT_DIGITS_EDEFAULT;
			case LunTypesPackage.LDT_CDIGITS__FRACTION_DIGITS:
				return fractionDigits != FRACTION_DIGITS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LunTypesPackage.LDT_CDIGITS___IS_FOR_PRIMITIVES:
				return isForPrimitives();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (intDigits: ");
		result.append(intDigits);
		result.append(", fractionDigits: ");
		result.append(fractionDigits);
		result.append(')');
		return result.toString();
	}

} //LDtCDigitsImpl

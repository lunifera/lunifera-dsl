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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LDatatypeConstraint;
import org.lunifera.dsl.semantic.common.types.LDateType;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LData Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#getJvmTypeReference <em>Jvm Type Reference</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#isAsPrimitive <em>As Primitive</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#isDate <em>Date</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#isAsBlob <em>As Blob</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#getDateType <em>Date Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#isSyntheticFlag <em>Synthetic Flag</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#getSyntheticSelector <em>Synthetic Selector</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#getSyntheticTypeReference <em>Synthetic Type Reference</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#getSyntheticType <em>Synthetic Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDataTypeImpl extends LScalarTypeImpl implements LDataType {
	/**
	 * The cached value of the '{@link #getJvmTypeReference() <em>Jvm Type Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJvmTypeReference()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference jvmTypeReference;

	/**
	 * The default value of the '{@link #isAsPrimitive() <em>As Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsPrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AS_PRIMITIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAsPrimitive() <em>As Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsPrimitive()
	 * @generated
	 * @ordered
	 */
	protected boolean asPrimitive = AS_PRIMITIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDate()
	 * @generated
	 * @ordered
	 */
	protected boolean date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAsBlob() <em>As Blob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsBlob()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AS_BLOB_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAsBlob() <em>As Blob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsBlob()
	 * @generated
	 * @ordered
	 */
	protected boolean asBlob = AS_BLOB_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final int LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected int length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateType() <em>Date Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateType()
	 * @generated
	 * @ordered
	 */
	protected static final LDateType DATE_TYPE_EDEFAULT = LDateType.DATE;

	/**
	 * The cached value of the '{@link #getDateType() <em>Date Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateType()
	 * @generated
	 * @ordered
	 */
	protected LDateType dateType = DATE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSyntheticFlag() <em>Synthetic Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSyntheticFlag()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYNTHETIC_FLAG_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSyntheticFlag() <em>Synthetic Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSyntheticFlag()
	 * @generated
	 * @ordered
	 */
	protected boolean syntheticFlag = SYNTHETIC_FLAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getSyntheticSelector() <em>Synthetic Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyntheticSelector()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNTHETIC_SELECTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSyntheticSelector() <em>Synthetic Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyntheticSelector()
	 * @generated
	 * @ordered
	 */
	protected String syntheticSelector = SYNTHETIC_SELECTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSyntheticTypeReference() <em>Synthetic Type Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyntheticTypeReference()
	 * @generated
	 * @ordered
	 */
	protected LFeature syntheticTypeReference;

	/**
	 * The cached value of the '{@link #getSyntheticType() <em>Synthetic Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyntheticType()
	 * @generated
	 * @ordered
	 */
	protected LType syntheticType;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<LDatatypeConstraint> constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunTypesPackage.Literals.LDATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getJvmTypeReference() {
		return jvmTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJvmTypeReference(JvmTypeReference newJvmTypeReference, NotificationChain msgs) {
		JvmTypeReference oldJvmTypeReference = jvmTypeReference;
		jvmTypeReference = newJvmTypeReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE, oldJvmTypeReference, newJvmTypeReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJvmTypeReference(JvmTypeReference newJvmTypeReference) {
		if (newJvmTypeReference != jvmTypeReference) {
			NotificationChain msgs = null;
			if (jvmTypeReference != null)
				msgs = ((InternalEObject)jvmTypeReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE, null, msgs);
			if (newJvmTypeReference != null)
				msgs = ((InternalEObject)newJvmTypeReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE, null, msgs);
			msgs = basicSetJvmTypeReference(newJvmTypeReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE, newJvmTypeReference, newJvmTypeReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAsPrimitive() {
		return asPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsPrimitive(boolean newAsPrimitive) {
		boolean oldAsPrimitive = asPrimitive;
		asPrimitive = newAsPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE, oldAsPrimitive, asPrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(boolean newDate) {
		boolean oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAsBlob() {
		return asBlob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsBlob(boolean newAsBlob) {
		boolean oldAsBlob = asBlob;
		asBlob = newAsBlob;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__AS_BLOB, oldAsBlob, asBlob));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(int newLength) {
		int oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDateType getDateType() {
		return dateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateType(LDateType newDateType) {
		LDateType oldDateType = dateType;
		dateType = newDateType == null ? DATE_TYPE_EDEFAULT : newDateType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__DATE_TYPE, oldDateType, dateType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSyntheticFlag() {
		return syntheticFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyntheticFlag(boolean newSyntheticFlag) {
		boolean oldSyntheticFlag = syntheticFlag;
		syntheticFlag = newSyntheticFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__SYNTHETIC_FLAG, oldSyntheticFlag, syntheticFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSyntheticSelector() {
		return syntheticSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyntheticSelector(String newSyntheticSelector) {
		String oldSyntheticSelector = syntheticSelector;
		syntheticSelector = newSyntheticSelector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__SYNTHETIC_SELECTOR, oldSyntheticSelector, syntheticSelector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LFeature getSyntheticTypeReference() {
		if (syntheticTypeReference != null && syntheticTypeReference.eIsProxy()) {
			InternalEObject oldSyntheticTypeReference = (InternalEObject)syntheticTypeReference;
			syntheticTypeReference = (LFeature)eResolveProxy(oldSyntheticTypeReference);
			if (syntheticTypeReference != oldSyntheticTypeReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE_REFERENCE, oldSyntheticTypeReference, syntheticTypeReference));
			}
		}
		return syntheticTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LFeature basicGetSyntheticTypeReference() {
		return syntheticTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyntheticTypeReference(LFeature newSyntheticTypeReference) {
		LFeature oldSyntheticTypeReference = syntheticTypeReference;
		syntheticTypeReference = newSyntheticTypeReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE_REFERENCE, oldSyntheticTypeReference, syntheticTypeReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LType getSyntheticType() {
		if (syntheticType != null && syntheticType.eIsProxy()) {
			InternalEObject oldSyntheticType = (InternalEObject)syntheticType;
			syntheticType = (LType)eResolveProxy(oldSyntheticType);
			if (syntheticType != oldSyntheticType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE, oldSyntheticType, syntheticType));
			}
		}
		return syntheticType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LType basicGetSyntheticType() {
		return syntheticType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyntheticType(LType newSyntheticType) {
		LType oldSyntheticType = syntheticType;
		syntheticType = newSyntheticType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE, oldSyntheticType, syntheticType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LDatatypeConstraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<LDatatypeConstraint>(LDatatypeConstraint.class, this, LunTypesPackage.LDATA_TYPE__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
				return basicSetJvmTypeReference(null, msgs);
			case LunTypesPackage.LDATA_TYPE__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
				return getJvmTypeReference();
			case LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE:
				return isAsPrimitive();
			case LunTypesPackage.LDATA_TYPE__DATE:
				return isDate();
			case LunTypesPackage.LDATA_TYPE__AS_BLOB:
				return isAsBlob();
			case LunTypesPackage.LDATA_TYPE__LENGTH:
				return getLength();
			case LunTypesPackage.LDATA_TYPE__DATE_TYPE:
				return getDateType();
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_FLAG:
				return isSyntheticFlag();
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_SELECTOR:
				return getSyntheticSelector();
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE_REFERENCE:
				if (resolve) return getSyntheticTypeReference();
				return basicGetSyntheticTypeReference();
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE:
				if (resolve) return getSyntheticType();
				return basicGetSyntheticType();
			case LunTypesPackage.LDATA_TYPE__CONSTRAINTS:
				return getConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
				setJvmTypeReference((JvmTypeReference)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE:
				setAsPrimitive((Boolean)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__DATE:
				setDate((Boolean)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__AS_BLOB:
				setAsBlob((Boolean)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__LENGTH:
				setLength((Integer)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__DATE_TYPE:
				setDateType((LDateType)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_FLAG:
				setSyntheticFlag((Boolean)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_SELECTOR:
				setSyntheticSelector((String)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE_REFERENCE:
				setSyntheticTypeReference((LFeature)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE:
				setSyntheticType((LType)newValue);
				return;
			case LunTypesPackage.LDATA_TYPE__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends LDatatypeConstraint>)newValue);
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
			case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
				setJvmTypeReference((JvmTypeReference)null);
				return;
			case LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE:
				setAsPrimitive(AS_PRIMITIVE_EDEFAULT);
				return;
			case LunTypesPackage.LDATA_TYPE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case LunTypesPackage.LDATA_TYPE__AS_BLOB:
				setAsBlob(AS_BLOB_EDEFAULT);
				return;
			case LunTypesPackage.LDATA_TYPE__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case LunTypesPackage.LDATA_TYPE__DATE_TYPE:
				setDateType(DATE_TYPE_EDEFAULT);
				return;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_FLAG:
				setSyntheticFlag(SYNTHETIC_FLAG_EDEFAULT);
				return;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_SELECTOR:
				setSyntheticSelector(SYNTHETIC_SELECTOR_EDEFAULT);
				return;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE_REFERENCE:
				setSyntheticTypeReference((LFeature)null);
				return;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE:
				setSyntheticType((LType)null);
				return;
			case LunTypesPackage.LDATA_TYPE__CONSTRAINTS:
				getConstraints().clear();
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
			case LunTypesPackage.LDATA_TYPE__JVM_TYPE_REFERENCE:
				return jvmTypeReference != null;
			case LunTypesPackage.LDATA_TYPE__AS_PRIMITIVE:
				return asPrimitive != AS_PRIMITIVE_EDEFAULT;
			case LunTypesPackage.LDATA_TYPE__DATE:
				return date != DATE_EDEFAULT;
			case LunTypesPackage.LDATA_TYPE__AS_BLOB:
				return asBlob != AS_BLOB_EDEFAULT;
			case LunTypesPackage.LDATA_TYPE__LENGTH:
				return length != LENGTH_EDEFAULT;
			case LunTypesPackage.LDATA_TYPE__DATE_TYPE:
				return dateType != DATE_TYPE_EDEFAULT;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_FLAG:
				return syntheticFlag != SYNTHETIC_FLAG_EDEFAULT;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_SELECTOR:
				return SYNTHETIC_SELECTOR_EDEFAULT == null ? syntheticSelector != null : !SYNTHETIC_SELECTOR_EDEFAULT.equals(syntheticSelector);
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE_REFERENCE:
				return syntheticTypeReference != null;
			case LunTypesPackage.LDATA_TYPE__SYNTHETIC_TYPE:
				return syntheticType != null;
			case LunTypesPackage.LDATA_TYPE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
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
		result.append(" (asPrimitive: ");
		result.append(asPrimitive);
		result.append(", date: ");
		result.append(date);
		result.append(", asBlob: ");
		result.append(asBlob);
		result.append(", length: ");
		result.append(length);
		result.append(", dateType: ");
		result.append(dateType);
		result.append(", syntheticFlag: ");
		result.append(syntheticFlag);
		result.append(", syntheticSelector: ");
		result.append(syntheticSelector);
		result.append(')');
		return result.toString();
	}

} //LDataTypeImpl

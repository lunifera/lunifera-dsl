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
package org.lunifera.dsl.semantic.dto.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LMultiplicity;
import org.lunifera.dsl.semantic.common.types.LScalarType;

import org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDto Inherited Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoInheritedAttributeImpl#getInheritedFeature <em>Inherited Feature</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoInheritedAttributeImpl#getInheritedFeatureTypeJvm <em>Inherited Feature Type Jvm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDtoInheritedAttributeImpl extends LDtoAbstractAttributeImpl implements LDtoInheritedAttribute {
	/**
	 * The cached value of the '{@link #getInheritedFeature() <em>Inherited Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedFeature()
	 * @generated
	 * @ordered
	 */
	protected LAttribute inheritedFeature;

	/**
	 * The cached value of the '{@link #getInheritedFeatureTypeJvm() <em>Inherited Feature Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedFeatureTypeJvm()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference inheritedFeatureTypeJvm;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LDtoInheritedAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunDtoPackage.Literals.LDTO_INHERITED_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAttribute getInheritedFeature() {
		if (inheritedFeature != null && inheritedFeature.eIsProxy()) {
			InternalEObject oldInheritedFeature = (InternalEObject)inheritedFeature;
			inheritedFeature = (LAttribute)eResolveProxy(oldInheritedFeature);
			if (inheritedFeature != oldInheritedFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE, oldInheritedFeature, inheritedFeature));
			}
		}
		return inheritedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAttribute basicGetInheritedFeature() {
		return inheritedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedFeature(LAttribute newInheritedFeature) {
		LAttribute oldInheritedFeature = inheritedFeature;
		inheritedFeature = newInheritedFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE, oldInheritedFeature, inheritedFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getInheritedFeatureTypeJvm() {
		return inheritedFeatureTypeJvm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInheritedFeatureTypeJvm(JvmTypeReference newInheritedFeatureTypeJvm, NotificationChain msgs) {
		JvmTypeReference oldInheritedFeatureTypeJvm = inheritedFeatureTypeJvm;
		inheritedFeatureTypeJvm = newInheritedFeatureTypeJvm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM, oldInheritedFeatureTypeJvm, newInheritedFeatureTypeJvm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedFeatureTypeJvm(JvmTypeReference newInheritedFeatureTypeJvm) {
		if (newInheritedFeatureTypeJvm != inheritedFeatureTypeJvm) {
			NotificationChain msgs = null;
			if (inheritedFeatureTypeJvm != null)
				msgs = ((InternalEObject)inheritedFeatureTypeJvm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM, null, msgs);
			if (newInheritedFeatureTypeJvm != null)
				msgs = ((InternalEObject)newInheritedFeatureTypeJvm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM, null, msgs);
			msgs = basicSetInheritedFeatureTypeJvm(newInheritedFeatureTypeJvm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM, newInheritedFeatureTypeJvm, newInheritedFeatureTypeJvm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LScalarType getInheritedType() {
		LAttribute _inheritedFeature = this.getInheritedFeature();
		return _inheritedFeature.getType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LMultiplicity getInheritedMultiplicity() {
		LAttribute _inheritedFeature = this.getInheritedFeature();
		return _inheritedFeature.getMultiplicity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM:
				return basicSetInheritedFeatureTypeJvm(null, msgs);
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
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE:
				if (resolve) return getInheritedFeature();
				return basicGetInheritedFeature();
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM:
				return getInheritedFeatureTypeJvm();
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
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE:
				setInheritedFeature((LAttribute)newValue);
				return;
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM:
				setInheritedFeatureTypeJvm((JvmTypeReference)newValue);
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
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE:
				setInheritedFeature((LAttribute)null);
				return;
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM:
				setInheritedFeatureTypeJvm((JvmTypeReference)null);
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
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE:
				return inheritedFeature != null;
			case LunDtoPackage.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE_TYPE_JVM:
				return inheritedFeatureTypeJvm != null;
		}
		return super.eIsSet(featureID);
	}

} //LDtoInheritedAttributeImpl

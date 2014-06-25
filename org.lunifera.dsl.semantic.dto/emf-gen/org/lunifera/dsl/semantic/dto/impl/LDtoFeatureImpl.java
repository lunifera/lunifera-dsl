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

import com.google.common.base.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.lunifera.dsl.semantic.common.types.LAnnotationDef;
import org.lunifera.dsl.semantic.common.types.LAnnotationTarget;
import org.lunifera.dsl.semantic.common.types.LMultiplicity;

import org.lunifera.dsl.semantic.common.types.impl.LAnnotationTargetImpl;

import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.dto.LDtoFeature;
import org.lunifera.dsl.semantic.dto.LDtoMapper;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDto Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoFeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoFeatureImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoFeatureImpl#getAnnotationInfo <em>Annotation Info</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoFeatureImpl#getMapper <em>Mapper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDtoFeatureImpl extends LAnnotationTargetImpl implements LDtoFeature {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected LMultiplicity multiplicity;

	/**
	 * The cached value of the '{@link #getAnnotationInfo() <em>Annotation Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationInfo()
	 * @generated
	 * @ordered
	 */
	protected LAnnotationTarget annotationInfo;

	/**
	 * The cached value of the '{@link #getMapper() <em>Mapper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapper()
	 * @generated
	 * @ordered
	 */
	protected LDtoMapper mapper;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LDtoFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunDtoPackage.Literals.LDTO_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_FEATURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LMultiplicity getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMultiplicity(LMultiplicity newMultiplicity, NotificationChain msgs) {
		LMultiplicity oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_FEATURE__MULTIPLICITY, oldMultiplicity, newMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(LMultiplicity newMultiplicity) {
		if (newMultiplicity != multiplicity) {
			NotificationChain msgs = null;
			if (multiplicity != null)
				msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_FEATURE__MULTIPLICITY, null, msgs);
			if (newMultiplicity != null)
				msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_FEATURE__MULTIPLICITY, null, msgs);
			msgs = basicSetMultiplicity(newMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_FEATURE__MULTIPLICITY, newMultiplicity, newMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAnnotationTarget getAnnotationInfo() {
		return annotationInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotationInfo(LAnnotationTarget newAnnotationInfo, NotificationChain msgs) {
		LAnnotationTarget oldAnnotationInfo = annotationInfo;
		annotationInfo = newAnnotationInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_FEATURE__ANNOTATION_INFO, oldAnnotationInfo, newAnnotationInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotationInfo(LAnnotationTarget newAnnotationInfo) {
		if (newAnnotationInfo != annotationInfo) {
			NotificationChain msgs = null;
			if (annotationInfo != null)
				msgs = ((InternalEObject)annotationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_FEATURE__ANNOTATION_INFO, null, msgs);
			if (newAnnotationInfo != null)
				msgs = ((InternalEObject)newAnnotationInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_FEATURE__ANNOTATION_INFO, null, msgs);
			msgs = basicSetAnnotationInfo(newAnnotationInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_FEATURE__ANNOTATION_INFO, newAnnotationInfo, newAnnotationInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDtoMapper getMapper() {
		return mapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapper(LDtoMapper newMapper, NotificationChain msgs) {
		LDtoMapper oldMapper = mapper;
		mapper = newMapper;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_FEATURE__MAPPER, oldMapper, newMapper);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapper(LDtoMapper newMapper) {
		if (newMapper != mapper) {
			NotificationChain msgs = null;
			if (mapper != null)
				msgs = ((InternalEObject)mapper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_FEATURE__MAPPER, null, msgs);
			if (newMapper != null)
				msgs = ((InternalEObject)newMapper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO_FEATURE__MAPPER, null, msgs);
			msgs = basicSetMapper(newMapper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO_FEATURE__MAPPER, newMapper, newMapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDto getDTO() {
		EObject _eContainer = this.eContainer();
		return ((LDto) _eContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LAnnotationDef> getResolvedAnnotations() {
		EList<LAnnotationDef> _xifexpression = null;
		LAnnotationTarget _annotationInfo = this.getAnnotationInfo();
		boolean _notEquals = (!Objects.equal(_annotationInfo, null));
		if (_notEquals) {
			LAnnotationTarget _annotationInfo_1 = this.getAnnotationInfo();
			_xifexpression = _annotationInfo_1.getAnnotations();
		}
		else {
			_xifexpression = this.getAnnotations();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunDtoPackage.LDTO_FEATURE__MULTIPLICITY:
				return basicSetMultiplicity(null, msgs);
			case LunDtoPackage.LDTO_FEATURE__ANNOTATION_INFO:
				return basicSetAnnotationInfo(null, msgs);
			case LunDtoPackage.LDTO_FEATURE__MAPPER:
				return basicSetMapper(null, msgs);
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
			case LunDtoPackage.LDTO_FEATURE__NAME:
				return getName();
			case LunDtoPackage.LDTO_FEATURE__MULTIPLICITY:
				return getMultiplicity();
			case LunDtoPackage.LDTO_FEATURE__ANNOTATION_INFO:
				return getAnnotationInfo();
			case LunDtoPackage.LDTO_FEATURE__MAPPER:
				return getMapper();
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
			case LunDtoPackage.LDTO_FEATURE__NAME:
				setName((String)newValue);
				return;
			case LunDtoPackage.LDTO_FEATURE__MULTIPLICITY:
				setMultiplicity((LMultiplicity)newValue);
				return;
			case LunDtoPackage.LDTO_FEATURE__ANNOTATION_INFO:
				setAnnotationInfo((LAnnotationTarget)newValue);
				return;
			case LunDtoPackage.LDTO_FEATURE__MAPPER:
				setMapper((LDtoMapper)newValue);
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
			case LunDtoPackage.LDTO_FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LunDtoPackage.LDTO_FEATURE__MULTIPLICITY:
				setMultiplicity((LMultiplicity)null);
				return;
			case LunDtoPackage.LDTO_FEATURE__ANNOTATION_INFO:
				setAnnotationInfo((LAnnotationTarget)null);
				return;
			case LunDtoPackage.LDTO_FEATURE__MAPPER:
				setMapper((LDtoMapper)null);
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
			case LunDtoPackage.LDTO_FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LunDtoPackage.LDTO_FEATURE__MULTIPLICITY:
				return multiplicity != null;
			case LunDtoPackage.LDTO_FEATURE__ANNOTATION_INFO:
				return annotationInfo != null;
			case LunDtoPackage.LDTO_FEATURE__MAPPER:
				return mapper != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LDtoFeatureImpl

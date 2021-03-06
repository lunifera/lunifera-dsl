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

import com.google.common.collect.Iterables;

import java.lang.Iterable;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LType;

import org.lunifera.dsl.semantic.common.types.impl.LClassImpl;

import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute;
import org.lunifera.dsl.semantic.dto.LDtoAbstractReference;
import org.lunifera.dsl.semantic.dto.LDtoFeature;
import org.lunifera.dsl.semantic.dto.LDtoOperation;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDto</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoImpl#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoImpl#getSuperTypeJvm <em>Super Type Jvm</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoImpl#getSuperTypeMapperJvm <em>Super Type Mapper Jvm</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoImpl#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoImpl#getWrappedType <em>Wrapped Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.impl.LDtoImpl#getWrappedTypeJvm <em>Wrapped Type Jvm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LDtoImpl extends LClassImpl implements LDto {
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<LDtoFeature> features;

	/**
	 * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperType()
	 * @generated
	 * @ordered
	 */
	protected LDto superType;

	/**
	 * The cached value of the '{@link #getSuperTypeJvm() <em>Super Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypeJvm()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference superTypeJvm;

	/**
	 * The cached value of the '{@link #getSuperTypeMapperJvm() <em>Super Type Mapper Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypeMapperJvm()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference superTypeMapperJvm;

	/**
	 * The cached value of the '{@link #getSubTypes() <em>Sub Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<LDto> subTypes;

	/**
	 * The cached value of the '{@link #getWrappedType() <em>Wrapped Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWrappedType()
	 * @generated
	 * @ordered
	 */
	protected LType wrappedType;

	/**
	 * The cached value of the '{@link #getWrappedTypeJvm() <em>Wrapped Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWrappedTypeJvm()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference wrappedTypeJvm;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LDtoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LunDtoPackage.Literals.LDTO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LDtoFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<LDtoFeature>(LDtoFeature.class, this, LunDtoPackage.LDTO__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDto getSuperType() {
		if (superType != null && superType.eIsProxy()) {
			InternalEObject oldSuperType = (InternalEObject)superType;
			superType = (LDto)eResolveProxy(oldSuperType);
			if (superType != oldSuperType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunDtoPackage.LDTO__SUPER_TYPE, oldSuperType, superType));
			}
		}
		return superType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LDto basicGetSuperType() {
		return superType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperType(LDto newSuperType, NotificationChain msgs) {
		LDto oldSuperType = superType;
		superType = newSuperType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO__SUPER_TYPE, oldSuperType, newSuperType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperType(LDto newSuperType) {
		if (newSuperType != superType) {
			NotificationChain msgs = null;
			if (superType != null)
				msgs = ((InternalEObject)superType).eInverseRemove(this, LunDtoPackage.LDTO__SUB_TYPES, LDto.class, msgs);
			if (newSuperType != null)
				msgs = ((InternalEObject)newSuperType).eInverseAdd(this, LunDtoPackage.LDTO__SUB_TYPES, LDto.class, msgs);
			msgs = basicSetSuperType(newSuperType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO__SUPER_TYPE, newSuperType, newSuperType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getSuperTypeJvm() {
		return superTypeJvm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperTypeJvm(JvmTypeReference newSuperTypeJvm, NotificationChain msgs) {
		JvmTypeReference oldSuperTypeJvm = superTypeJvm;
		superTypeJvm = newSuperTypeJvm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO__SUPER_TYPE_JVM, oldSuperTypeJvm, newSuperTypeJvm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperTypeJvm(JvmTypeReference newSuperTypeJvm) {
		if (newSuperTypeJvm != superTypeJvm) {
			NotificationChain msgs = null;
			if (superTypeJvm != null)
				msgs = ((InternalEObject)superTypeJvm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO__SUPER_TYPE_JVM, null, msgs);
			if (newSuperTypeJvm != null)
				msgs = ((InternalEObject)newSuperTypeJvm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO__SUPER_TYPE_JVM, null, msgs);
			msgs = basicSetSuperTypeJvm(newSuperTypeJvm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO__SUPER_TYPE_JVM, newSuperTypeJvm, newSuperTypeJvm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getSuperTypeMapperJvm() {
		return superTypeMapperJvm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperTypeMapperJvm(JvmTypeReference newSuperTypeMapperJvm, NotificationChain msgs) {
		JvmTypeReference oldSuperTypeMapperJvm = superTypeMapperJvm;
		superTypeMapperJvm = newSuperTypeMapperJvm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO__SUPER_TYPE_MAPPER_JVM, oldSuperTypeMapperJvm, newSuperTypeMapperJvm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperTypeMapperJvm(JvmTypeReference newSuperTypeMapperJvm) {
		if (newSuperTypeMapperJvm != superTypeMapperJvm) {
			NotificationChain msgs = null;
			if (superTypeMapperJvm != null)
				msgs = ((InternalEObject)superTypeMapperJvm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO__SUPER_TYPE_MAPPER_JVM, null, msgs);
			if (newSuperTypeMapperJvm != null)
				msgs = ((InternalEObject)newSuperTypeMapperJvm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO__SUPER_TYPE_MAPPER_JVM, null, msgs);
			msgs = basicSetSuperTypeMapperJvm(newSuperTypeMapperJvm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO__SUPER_TYPE_MAPPER_JVM, newSuperTypeMapperJvm, newSuperTypeMapperJvm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LDto> getSubTypes() {
		if (subTypes == null) {
			subTypes = new EObjectWithInverseResolvingEList<LDto>(LDto.class, this, LunDtoPackage.LDTO__SUB_TYPES, LunDtoPackage.LDTO__SUPER_TYPE);
		}
		return subTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LType getWrappedType() {
		if (wrappedType != null && wrappedType.eIsProxy()) {
			InternalEObject oldWrappedType = (InternalEObject)wrappedType;
			wrappedType = (LType)eResolveProxy(oldWrappedType);
			if (wrappedType != oldWrappedType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LunDtoPackage.LDTO__WRAPPED_TYPE, oldWrappedType, wrappedType));
			}
		}
		return wrappedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LType basicGetWrappedType() {
		return wrappedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrappedType(LType newWrappedType) {
		LType oldWrappedType = wrappedType;
		wrappedType = newWrappedType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO__WRAPPED_TYPE, oldWrappedType, wrappedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getWrappedTypeJvm() {
		return wrappedTypeJvm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWrappedTypeJvm(JvmTypeReference newWrappedTypeJvm, NotificationChain msgs) {
		JvmTypeReference oldWrappedTypeJvm = wrappedTypeJvm;
		wrappedTypeJvm = newWrappedTypeJvm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO__WRAPPED_TYPE_JVM, oldWrappedTypeJvm, newWrappedTypeJvm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrappedTypeJvm(JvmTypeReference newWrappedTypeJvm) {
		if (newWrappedTypeJvm != wrappedTypeJvm) {
			NotificationChain msgs = null;
			if (wrappedTypeJvm != null)
				msgs = ((InternalEObject)wrappedTypeJvm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO__WRAPPED_TYPE_JVM, null, msgs);
			if (newWrappedTypeJvm != null)
				msgs = ((InternalEObject)newWrappedTypeJvm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LunDtoPackage.LDTO__WRAPPED_TYPE_JVM, null, msgs);
			msgs = basicSetWrappedTypeJvm(newWrappedTypeJvm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LunDtoPackage.LDTO__WRAPPED_TYPE_JVM, newWrappedTypeJvm, newWrappedTypeJvm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<LDtoOperation> getOperations() {
		EList<LDtoFeature> _features = this.getFeatures();
		Iterable<LDtoOperation> _filter = Iterables.<LDtoOperation>filter(_features, LDtoOperation.class);
		return IterableExtensions.<LDtoOperation>toList(_filter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<LDtoAbstractReference> getReferences() {
		EList<LDtoFeature> _features = this.getFeatures();
		Iterable<LDtoAbstractReference> _filter = Iterables.<LDtoAbstractReference>filter(_features, LDtoAbstractReference.class);
		return IterableExtensions.<LDtoAbstractReference>toList(_filter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<LDtoAbstractAttribute> getAttributes() {
		EList<LDtoFeature> _features = this.getFeatures();
		Iterable<LDtoAbstractAttribute> _filter = Iterables.<LDtoAbstractAttribute>filter(_features, LDtoAbstractAttribute.class);
		return IterableExtensions.<LDtoAbstractAttribute>toList(_filter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<? extends LFeature> getAllFeatures() {
		final List<LDtoFeature> result = CollectionLiterals.<LDtoFeature>newArrayList();
		this.collectAllLunFeatures(this, result);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void collectAllLunFeatures(final LDto current, final List<LDtoFeature> result) {
		boolean _equals = Objects.equal(current, null);
		if (_equals) {
			return;
		}
		EList<LDtoFeature> _features = current.getFeatures();
		result.addAll(_features);
		LDto _superType = current.getSuperType();
		this.collectAllLunFeatures(_superType, result);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunDtoPackage.LDTO__SUPER_TYPE:
				if (superType != null)
					msgs = ((InternalEObject)superType).eInverseRemove(this, LunDtoPackage.LDTO__SUB_TYPES, LDto.class, msgs);
				return basicSetSuperType((LDto)otherEnd, msgs);
			case LunDtoPackage.LDTO__SUB_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubTypes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LunDtoPackage.LDTO__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case LunDtoPackage.LDTO__SUPER_TYPE:
				return basicSetSuperType(null, msgs);
			case LunDtoPackage.LDTO__SUPER_TYPE_JVM:
				return basicSetSuperTypeJvm(null, msgs);
			case LunDtoPackage.LDTO__SUPER_TYPE_MAPPER_JVM:
				return basicSetSuperTypeMapperJvm(null, msgs);
			case LunDtoPackage.LDTO__SUB_TYPES:
				return ((InternalEList<?>)getSubTypes()).basicRemove(otherEnd, msgs);
			case LunDtoPackage.LDTO__WRAPPED_TYPE_JVM:
				return basicSetWrappedTypeJvm(null, msgs);
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
			case LunDtoPackage.LDTO__FEATURES:
				return getFeatures();
			case LunDtoPackage.LDTO__SUPER_TYPE:
				if (resolve) return getSuperType();
				return basicGetSuperType();
			case LunDtoPackage.LDTO__SUPER_TYPE_JVM:
				return getSuperTypeJvm();
			case LunDtoPackage.LDTO__SUPER_TYPE_MAPPER_JVM:
				return getSuperTypeMapperJvm();
			case LunDtoPackage.LDTO__SUB_TYPES:
				return getSubTypes();
			case LunDtoPackage.LDTO__WRAPPED_TYPE:
				if (resolve) return getWrappedType();
				return basicGetWrappedType();
			case LunDtoPackage.LDTO__WRAPPED_TYPE_JVM:
				return getWrappedTypeJvm();
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
			case LunDtoPackage.LDTO__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends LDtoFeature>)newValue);
				return;
			case LunDtoPackage.LDTO__SUPER_TYPE:
				setSuperType((LDto)newValue);
				return;
			case LunDtoPackage.LDTO__SUPER_TYPE_JVM:
				setSuperTypeJvm((JvmTypeReference)newValue);
				return;
			case LunDtoPackage.LDTO__SUPER_TYPE_MAPPER_JVM:
				setSuperTypeMapperJvm((JvmTypeReference)newValue);
				return;
			case LunDtoPackage.LDTO__SUB_TYPES:
				getSubTypes().clear();
				getSubTypes().addAll((Collection<? extends LDto>)newValue);
				return;
			case LunDtoPackage.LDTO__WRAPPED_TYPE:
				setWrappedType((LType)newValue);
				return;
			case LunDtoPackage.LDTO__WRAPPED_TYPE_JVM:
				setWrappedTypeJvm((JvmTypeReference)newValue);
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
			case LunDtoPackage.LDTO__FEATURES:
				getFeatures().clear();
				return;
			case LunDtoPackage.LDTO__SUPER_TYPE:
				setSuperType((LDto)null);
				return;
			case LunDtoPackage.LDTO__SUPER_TYPE_JVM:
				setSuperTypeJvm((JvmTypeReference)null);
				return;
			case LunDtoPackage.LDTO__SUPER_TYPE_MAPPER_JVM:
				setSuperTypeMapperJvm((JvmTypeReference)null);
				return;
			case LunDtoPackage.LDTO__SUB_TYPES:
				getSubTypes().clear();
				return;
			case LunDtoPackage.LDTO__WRAPPED_TYPE:
				setWrappedType((LType)null);
				return;
			case LunDtoPackage.LDTO__WRAPPED_TYPE_JVM:
				setWrappedTypeJvm((JvmTypeReference)null);
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
			case LunDtoPackage.LDTO__FEATURES:
				return features != null && !features.isEmpty();
			case LunDtoPackage.LDTO__SUPER_TYPE:
				return superType != null;
			case LunDtoPackage.LDTO__SUPER_TYPE_JVM:
				return superTypeJvm != null;
			case LunDtoPackage.LDTO__SUPER_TYPE_MAPPER_JVM:
				return superTypeMapperJvm != null;
			case LunDtoPackage.LDTO__SUB_TYPES:
				return subTypes != null && !subTypes.isEmpty();
			case LunDtoPackage.LDTO__WRAPPED_TYPE:
				return wrappedType != null;
			case LunDtoPackage.LDTO__WRAPPED_TYPE_JVM:
				return wrappedTypeJvm != null;
		}
		return super.eIsSet(featureID);
	}

} //LDtoImpl

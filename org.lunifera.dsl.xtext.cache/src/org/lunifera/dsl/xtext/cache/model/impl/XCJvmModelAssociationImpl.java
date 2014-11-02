/**
 */
package org.lunifera.dsl.xtext.cache.model.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation;
import org.lunifera.dsl.xtext.cache.model.XCLogicalContainer;
import org.lunifera.dsl.xtext.cache.model.XCSourceToTarget;
import org.lunifera.dsl.xtext.cache.model.XCTargetToSource;
import org.lunifera.dsl.xtext.cache.model.XtextCachePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XC Jvm Model Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.impl.XCJvmModelAssociationImpl#getSourceToTargets <em>Source To Targets</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.impl.XCJvmModelAssociationImpl#getTargetToSources <em>Target To Sources</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.impl.XCJvmModelAssociationImpl#getLocalContainers <em>Local Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XCJvmModelAssociationImpl extends MinimalEObjectImpl.Container implements XCJvmModelAssociation {
	/**
	 * The cached value of the '{@link #getSourceToTargets() <em>Source To Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceToTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<XCSourceToTarget> sourceToTargets;

	/**
	 * The cached value of the '{@link #getTargetToSources() <em>Target To Sources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetToSources()
	 * @generated
	 * @ordered
	 */
	protected EList<XCTargetToSource> targetToSources;

	/**
	 * The cached value of the '{@link #getLocalContainers() <em>Local Containers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<XCLogicalContainer> localContainers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XCJvmModelAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextCachePackage.Literals.XC_JVM_MODEL_ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XCSourceToTarget> getSourceToTargets() {
		if (sourceToTargets == null) {
			sourceToTargets = new EObjectContainmentEList<XCSourceToTarget>(XCSourceToTarget.class, this, XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__SOURCE_TO_TARGETS);
		}
		return sourceToTargets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XCTargetToSource> getTargetToSources() {
		if (targetToSources == null) {
			targetToSources = new EObjectContainmentEList<XCTargetToSource>(XCTargetToSource.class, this, XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__TARGET_TO_SOURCES);
		}
		return targetToSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XCLogicalContainer> getLocalContainers() {
		if (localContainers == null) {
			localContainers = new EObjectContainmentEList<XCLogicalContainer>(XCLogicalContainer.class, this, XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__LOCAL_CONTAINERS);
		}
		return localContainers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__SOURCE_TO_TARGETS:
				return ((InternalEList<?>)getSourceToTargets()).basicRemove(otherEnd, msgs);
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__TARGET_TO_SOURCES:
				return ((InternalEList<?>)getTargetToSources()).basicRemove(otherEnd, msgs);
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__LOCAL_CONTAINERS:
				return ((InternalEList<?>)getLocalContainers()).basicRemove(otherEnd, msgs);
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
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__SOURCE_TO_TARGETS:
				return getSourceToTargets();
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__TARGET_TO_SOURCES:
				return getTargetToSources();
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__LOCAL_CONTAINERS:
				return getLocalContainers();
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
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__SOURCE_TO_TARGETS:
				getSourceToTargets().clear();
				getSourceToTargets().addAll((Collection<? extends XCSourceToTarget>)newValue);
				return;
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__TARGET_TO_SOURCES:
				getTargetToSources().clear();
				getTargetToSources().addAll((Collection<? extends XCTargetToSource>)newValue);
				return;
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__LOCAL_CONTAINERS:
				getLocalContainers().clear();
				getLocalContainers().addAll((Collection<? extends XCLogicalContainer>)newValue);
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
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__SOURCE_TO_TARGETS:
				getSourceToTargets().clear();
				return;
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__TARGET_TO_SOURCES:
				getTargetToSources().clear();
				return;
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__LOCAL_CONTAINERS:
				getLocalContainers().clear();
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
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__SOURCE_TO_TARGETS:
				return sourceToTargets != null && !sourceToTargets.isEmpty();
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__TARGET_TO_SOURCES:
				return targetToSources != null && !targetToSources.isEmpty();
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION__LOCAL_CONTAINERS:
				return localContainers != null && !localContainers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XCJvmModelAssociationImpl

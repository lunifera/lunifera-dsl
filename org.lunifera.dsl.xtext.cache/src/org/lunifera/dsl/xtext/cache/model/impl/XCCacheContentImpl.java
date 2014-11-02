/**
 */
package org.lunifera.dsl.xtext.cache.model.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.lunifera.dsl.xtext.cache.model.XCCacheContent;
import org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation;
import org.lunifera.dsl.xtext.cache.model.XCMemberInfo;
import org.lunifera.dsl.xtext.cache.model.XtextCachePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XC Cache Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.impl.XCCacheContentImpl#getModelAssociation <em>Model Association</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.impl.XCCacheContentImpl#getMembersInfo <em>Members Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XCCacheContentImpl extends MinimalEObjectImpl.Container implements XCCacheContent {
	/**
	 * The cached value of the '{@link #getModelAssociation() <em>Model Association</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelAssociation()
	 * @generated
	 * @ordered
	 */
	protected XCJvmModelAssociation modelAssociation;

	/**
	 * The cached value of the '{@link #getMembersInfo() <em>Members Info</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembersInfo()
	 * @generated
	 * @ordered
	 */
	protected EList<XCMemberInfo> membersInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XCCacheContentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextCachePackage.Literals.XC_CACHE_CONTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCJvmModelAssociation getModelAssociation() {
		return modelAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelAssociation(XCJvmModelAssociation newModelAssociation, NotificationChain msgs) {
		XCJvmModelAssociation oldModelAssociation = modelAssociation;
		modelAssociation = newModelAssociation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextCachePackage.XC_CACHE_CONTENT__MODEL_ASSOCIATION, oldModelAssociation, newModelAssociation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelAssociation(XCJvmModelAssociation newModelAssociation) {
		if (newModelAssociation != modelAssociation) {
			NotificationChain msgs = null;
			if (modelAssociation != null)
				msgs = ((InternalEObject)modelAssociation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextCachePackage.XC_CACHE_CONTENT__MODEL_ASSOCIATION, null, msgs);
			if (newModelAssociation != null)
				msgs = ((InternalEObject)newModelAssociation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextCachePackage.XC_CACHE_CONTENT__MODEL_ASSOCIATION, null, msgs);
			msgs = basicSetModelAssociation(newModelAssociation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextCachePackage.XC_CACHE_CONTENT__MODEL_ASSOCIATION, newModelAssociation, newModelAssociation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XCMemberInfo> getMembersInfo() {
		if (membersInfo == null) {
			membersInfo = new EObjectContainmentEList<XCMemberInfo>(XCMemberInfo.class, this, XtextCachePackage.XC_CACHE_CONTENT__MEMBERS_INFO);
		}
		return membersInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtextCachePackage.XC_CACHE_CONTENT__MODEL_ASSOCIATION:
				return basicSetModelAssociation(null, msgs);
			case XtextCachePackage.XC_CACHE_CONTENT__MEMBERS_INFO:
				return ((InternalEList<?>)getMembersInfo()).basicRemove(otherEnd, msgs);
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
			case XtextCachePackage.XC_CACHE_CONTENT__MODEL_ASSOCIATION:
				return getModelAssociation();
			case XtextCachePackage.XC_CACHE_CONTENT__MEMBERS_INFO:
				return getMembersInfo();
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
			case XtextCachePackage.XC_CACHE_CONTENT__MODEL_ASSOCIATION:
				setModelAssociation((XCJvmModelAssociation)newValue);
				return;
			case XtextCachePackage.XC_CACHE_CONTENT__MEMBERS_INFO:
				getMembersInfo().clear();
				getMembersInfo().addAll((Collection<? extends XCMemberInfo>)newValue);
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
			case XtextCachePackage.XC_CACHE_CONTENT__MODEL_ASSOCIATION:
				setModelAssociation((XCJvmModelAssociation)null);
				return;
			case XtextCachePackage.XC_CACHE_CONTENT__MEMBERS_INFO:
				getMembersInfo().clear();
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
			case XtextCachePackage.XC_CACHE_CONTENT__MODEL_ASSOCIATION:
				return modelAssociation != null;
			case XtextCachePackage.XC_CACHE_CONTENT__MEMBERS_INFO:
				return membersInfo != null && !membersInfo.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XCCacheContentImpl

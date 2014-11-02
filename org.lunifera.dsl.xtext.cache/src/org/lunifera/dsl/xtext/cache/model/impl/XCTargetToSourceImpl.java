/**
 */
package org.lunifera.dsl.xtext.cache.model.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.lunifera.dsl.xtext.cache.model.XCTargetToSource;
import org.lunifera.dsl.xtext.cache.model.XtextCachePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XC Target To Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.impl.XCTargetToSourceImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.impl.XCTargetToSourceImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XCTargetToSourceImpl extends MinimalEObjectImpl.Container implements XCTargetToSource {
	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected EObject key;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XCTargetToSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextCachePackage.Literals.XC_TARGET_TO_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(EObject newKey) {
		EObject oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextCachePackage.XC_TARGET_TO_SOURCE__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getValues() {
		if (values == null) {
			values = new EObjectEList<EObject>(EObject.class, this, XtextCachePackage.XC_TARGET_TO_SOURCE__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XtextCachePackage.XC_TARGET_TO_SOURCE__KEY:
				return getKey();
			case XtextCachePackage.XC_TARGET_TO_SOURCE__VALUES:
				return getValues();
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
			case XtextCachePackage.XC_TARGET_TO_SOURCE__KEY:
				setKey((EObject)newValue);
				return;
			case XtextCachePackage.XC_TARGET_TO_SOURCE__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends EObject>)newValue);
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
			case XtextCachePackage.XC_TARGET_TO_SOURCE__KEY:
				setKey((EObject)null);
				return;
			case XtextCachePackage.XC_TARGET_TO_SOURCE__VALUES:
				getValues().clear();
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
			case XtextCachePackage.XC_TARGET_TO_SOURCE__KEY:
				return key != null;
			case XtextCachePackage.XC_TARGET_TO_SOURCE__VALUES:
				return values != null && !values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XCTargetToSourceImpl

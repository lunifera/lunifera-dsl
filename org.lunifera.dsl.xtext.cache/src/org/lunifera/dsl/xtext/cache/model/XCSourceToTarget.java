/**
 */
package org.lunifera.dsl.xtext.cache.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XC Source To Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCSourceToTarget#getKey <em>Key</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCSourceToTarget#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCSourceToTarget()
 * @model
 * @generated
 */
public interface XCSourceToTarget extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' reference.
	 * @see #setKey(EObject)
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCSourceToTarget_Key()
	 * @model resolveProxies="false"
	 * @generated
	 */
	EObject getKey();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.xtext.cache.model.XCSourceToTarget#getKey <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' reference.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(EObject value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCSourceToTarget_Values()
	 * @model resolveProxies="false"
	 * @generated
	 */
	EList<EObject> getValues();

} // XCSourceToTarget

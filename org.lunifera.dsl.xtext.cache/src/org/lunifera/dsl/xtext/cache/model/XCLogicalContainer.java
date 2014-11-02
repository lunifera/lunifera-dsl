/**
 */
package org.lunifera.dsl.xtext.cache.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XC Logical Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCLogicalContainer#getKey <em>Key</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCLogicalContainer#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCLogicalContainer()
 * @model
 * @generated
 */
public interface XCLogicalContainer extends EObject {
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
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCLogicalContainer_Key()
	 * @model resolveProxies="false"
	 * @generated
	 */
	EObject getKey();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.xtext.cache.model.XCLogicalContainer#getKey <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' reference.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(EObject value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EObject)
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCLogicalContainer_Value()
	 * @model resolveProxies="false"
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.xtext.cache.model.XCLogicalContainer#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

} // XCLogicalContainer

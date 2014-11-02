/**
 */
package org.lunifera.dsl.xtext.cache.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XC Cache Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCCacheContent#getModelAssociation <em>Model Association</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCCacheContent#getMembersInfo <em>Members Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCCacheContent()
 * @model
 * @generated
 */
public interface XCCacheContent extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Association</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Association</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Association</em>' containment reference.
	 * @see #setModelAssociation(XCJvmModelAssociation)
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCCacheContent_ModelAssociation()
	 * @model containment="true"
	 * @generated
	 */
	XCJvmModelAssociation getModelAssociation();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.xtext.cache.model.XCCacheContent#getModelAssociation <em>Model Association</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Association</em>' containment reference.
	 * @see #getModelAssociation()
	 * @generated
	 */
	void setModelAssociation(XCJvmModelAssociation value);

	/**
	 * Returns the value of the '<em><b>Members Info</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members Info</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members Info</em>' containment reference list.
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCCacheContent_MembersInfo()
	 * @model containment="true"
	 * @generated
	 */
	EList<XCMemberInfo> getMembersInfo();

} // XCCacheContent

/**
 */
package org.lunifera.dsl.xtext.cache.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XC Member Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getMember <em>Member</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCMemberInfo()
 * @model
 * @generated
 */
public interface XCMemberInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' reference.
	 * @see #setMember(EObject)
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCMemberInfo_Member()
	 * @model
	 * @generated
	 */
	EObject getMember();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getMember <em>Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member</em>' reference.
	 * @see #getMember()
	 * @generated
	 */
	void setMember(EObject value);

	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documentation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' attribute.
	 * @see #setDocumentation(String)
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCMemberInfo_Documentation()
	 * @model
	 * @generated
	 */
	String getDocumentation();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getDocumentation <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' attribute.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(String value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCMemberInfo_Body()
	 * @model
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

} // XCMemberInfo

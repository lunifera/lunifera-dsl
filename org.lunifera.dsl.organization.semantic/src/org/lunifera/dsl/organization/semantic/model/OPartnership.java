/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OPartnership</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OPartnership#getCompany <em>Company</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OPartnership#getResponsible <em>Responsible</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OPartnership#getAgreement <em>Agreement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOPartnership()
 * @model
 * @generated
 */
public interface OPartnership extends OOrganizationMember, ONamed {
	/**
	 * Returns the value of the '<em><b>Company</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company</em>' reference.
	 * @see #setCompany(OOrganization)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOPartnership_Company()
	 * @model
	 * @generated
	 */
	OOrganization getCompany();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.OPartnership#getCompany <em>Company</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company</em>' reference.
	 * @see #getCompany()
	 * @generated
	 */
	void setCompany(OOrganization value);

	/**
	 * Returns the value of the '<em><b>Responsible</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsible</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsible</em>' reference.
	 * @see #setResponsible(OWorker)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOPartnership_Responsible()
	 * @model
	 * @generated
	 */
	OWorker getResponsible();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.OPartnership#getResponsible <em>Responsible</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsible</em>' reference.
	 * @see #getResponsible()
	 * @generated
	 */
	void setResponsible(OWorker value);

	/**
	 * Returns the value of the '<em><b>Agreement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agreement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agreement</em>' attribute.
	 * @see #setAgreement(String)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOPartnership_Agreement()
	 * @model
	 * @generated
	 */
	String getAgreement();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.OPartnership#getAgreement <em>Agreement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agreement</em>' attribute.
	 * @see #getAgreement()
	 * @generated
	 */
	void setAgreement(String value);

} // OPartnership

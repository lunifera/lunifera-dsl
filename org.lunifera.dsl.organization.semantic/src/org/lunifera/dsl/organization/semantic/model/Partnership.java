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
 * A representation of the model object '<em><b>Partnership</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.Partnership#getName <em>Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.Partnership#getCompany <em>Company</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.Partnership#getResponsible <em>Responsible</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.Partnership#getAgreement <em>Agreement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getPartnership()
 * @model
 * @generated
 */
public interface Partnership extends OrganizationMember {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getPartnership_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.Partnership#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Company</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company</em>' reference.
	 * @see #setCompany(Organization)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getPartnership_Company()
	 * @model
	 * @generated
	 */
	Organization getCompany();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.Partnership#getCompany <em>Company</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company</em>' reference.
	 * @see #getCompany()
	 * @generated
	 */
	void setCompany(Organization value);

	/**
	 * Returns the value of the '<em><b>Responsible</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsible</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsible</em>' reference.
	 * @see #setResponsible(Worker)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getPartnership_Responsible()
	 * @model
	 * @generated
	 */
	Worker getResponsible();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.Partnership#getResponsible <em>Responsible</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsible</em>' reference.
	 * @see #getResponsible()
	 * @generated
	 */
	void setResponsible(Worker value);

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
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getPartnership_Agreement()
	 * @model
	 * @generated
	 */
	String getAgreement();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.Partnership#getAgreement <em>Agreement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agreement</em>' attribute.
	 * @see #getAgreement()
	 * @generated
	 */
	void setAgreement(String value);

} // Partnership

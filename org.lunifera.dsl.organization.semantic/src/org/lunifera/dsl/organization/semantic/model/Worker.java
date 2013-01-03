/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Worker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.Worker#getPerson <em>Person</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.Worker#getAllocationUnit <em>Allocation Unit</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.Worker#getPlayRoles <em>Play Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getWorker()
 * @model
 * @generated
 */
public interface Worker extends OrganizationMember {
	/**
	 * Returns the value of the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' reference.
	 * @see #setPerson(Person)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getWorker_Person()
	 * @model
	 * @generated
	 */
	Person getPerson();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.Worker#getPerson <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(Person value);

	/**
	 * Returns the value of the '<em><b>Allocation Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Unit</em>' reference.
	 * @see #setAllocationUnit(OrganizationUnit)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getWorker_AllocationUnit()
	 * @model
	 * @generated
	 */
	OrganizationUnit getAllocationUnit();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.Worker#getAllocationUnit <em>Allocation Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation Unit</em>' reference.
	 * @see #getAllocationUnit()
	 * @generated
	 */
	void setAllocationUnit(OrganizationUnit value);

	/**
	 * Returns the value of the '<em><b>Play Roles</b></em>' reference list.
	 * The list contents are of type {@link org.lunifera.dsl.organization.semantic.model.BusinessRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Play Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Play Roles</em>' reference list.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getWorker_PlayRoles()
	 * @model
	 * @generated
	 */
	EList<BusinessRole> getPlayRoles();

} // Worker

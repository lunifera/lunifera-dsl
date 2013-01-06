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
 * A representation of the model object '<em><b>OWorker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OWorker#getPerson <em>Person</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OWorker#getAllocationUnit <em>Allocation Unit</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OWorker#getPlayRoles <em>Play Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOWorker()
 * @model
 * @generated
 */
public interface OWorker extends OOrganizationMember {
	/**
	 * Returns the value of the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' reference.
	 * @see #setPerson(OPerson)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOWorker_Person()
	 * @model
	 * @generated
	 */
	OPerson getPerson();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.OWorker#getPerson <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(OPerson value);

	/**
	 * Returns the value of the '<em><b>Allocation Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Unit</em>' reference.
	 * @see #setAllocationUnit(OUnit)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOWorker_AllocationUnit()
	 * @model
	 * @generated
	 */
	OUnit getAllocationUnit();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.OWorker#getAllocationUnit <em>Allocation Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation Unit</em>' reference.
	 * @see #getAllocationUnit()
	 * @generated
	 */
	void setAllocationUnit(OUnit value);

	/**
	 * Returns the value of the '<em><b>Play Roles</b></em>' reference list.
	 * The list contents are of type {@link org.lunifera.dsl.organization.semantic.model.OPersonRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Play Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Play Roles</em>' reference list.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOWorker_PlayRoles()
	 * @model
	 * @generated
	 */
	EList<OPersonRole> getPlayRoles();

} // OWorker

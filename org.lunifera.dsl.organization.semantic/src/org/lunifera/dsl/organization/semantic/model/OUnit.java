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
 * A representation of the model object '<em><b>OUnit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OUnit#getParent <em>Parent</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OUnit#getPlayRoles <em>Play Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOUnit()
 * @model
 * @generated
 */
public interface OUnit extends OOrganizationMember, ONamed, ODescribed {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(OUnit)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOUnit_Parent()
	 * @model
	 * @generated
	 */
	OUnit getParent();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.OUnit#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(OUnit value);

	/**
	 * Returns the value of the '<em><b>Play Roles</b></em>' reference list.
	 * The list contents are of type {@link org.lunifera.dsl.organization.semantic.model.OUnitRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Play Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Play Roles</em>' reference list.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOUnit_PlayRoles()
	 * @model
	 * @generated
	 */
	EList<OUnitRole> getPlayRoles();

} // OUnit

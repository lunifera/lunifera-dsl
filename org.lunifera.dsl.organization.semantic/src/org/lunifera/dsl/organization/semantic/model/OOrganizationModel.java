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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OOrganization Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OOrganizationModel#getBusinessRoles <em>Business Roles</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OOrganizationModel#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOOrganizationModel()
 * @model
 * @generated
 */
public interface OOrganizationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Business Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.organization.semantic.model.OBusinessRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Business Roles</em>' containment reference list.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOOrganizationModel_BusinessRoles()
	 * @model containment="true"
	 * @generated
	 */
	EList<OBusinessRole> getBusinessRoles();

	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(OHierarchyRoot)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOOrganizationModel_Root()
	 * @model containment="true"
	 * @generated
	 */
	OHierarchyRoot getRoot();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.OOrganizationModel#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(OHierarchyRoot value);

} // OOrganizationModel

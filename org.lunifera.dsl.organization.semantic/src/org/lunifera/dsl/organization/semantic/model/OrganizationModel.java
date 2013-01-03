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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OrganizationModel#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OrganizationModel#getOrganizationUnitTypes <em>Organization Unit Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOrganizationModel()
 * @model
 * @generated
 */
public interface OrganizationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Organization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Organization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Organization</em>' containment reference.
	 * @see #setOrganization(Organization)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOrganizationModel_Organization()
	 * @model containment="true"
	 * @generated
	 */
	Organization getOrganization();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.OrganizationModel#getOrganization <em>Organization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organization</em>' containment reference.
	 * @see #getOrganization()
	 * @generated
	 */
	void setOrganization(Organization value);

	/**
	 * Returns the value of the '<em><b>Organization Unit Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.organization.semantic.model.OrganizationUnitType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Organization Unit Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Organization Unit Types</em>' containment reference list.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOrganizationModel_OrganizationUnitTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<OrganizationUnitType> getOrganizationUnitTypes();

} // OrganizationModel

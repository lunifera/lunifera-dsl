/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ODescribed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.ODescribed#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.ODescribed#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getODescribed()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ODescribed extends EObject {
	/**
	 * Returns the value of the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Name</em>' attribute.
	 * @see #setLongName(String)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getODescribed_LongName()
	 * @model
	 * @generated
	 */
	String getLongName();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.ODescribed#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Name</em>' attribute.
	 * @see #getLongName()
	 * @generated
	 */
	void setLongName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getODescribed_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.organization.semantic.model.ODescribed#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // ODescribed

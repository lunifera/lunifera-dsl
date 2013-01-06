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
 * A representation of the model object '<em><b>OGroup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.organization.semantic.model.OGroup#getWorkers <em>Workers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOGroup()
 * @model
 * @generated
 */
public interface OGroup extends OOrganizationMember, ONamed, ODescribed {
	/**
	 * Returns the value of the '<em><b>Workers</b></em>' reference list.
	 * The list contents are of type {@link org.lunifera.dsl.organization.semantic.model.OWorker}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workers</em>' reference list.
	 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage#getOGroup_Workers()
	 * @model
	 * @generated
	 */
	EList<OWorker> getWorkers();

} // OGroup

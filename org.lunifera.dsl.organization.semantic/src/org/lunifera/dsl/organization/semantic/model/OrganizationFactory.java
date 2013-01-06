/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage
 * @generated
 */
public interface OrganizationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OrganizationFactory eINSTANCE = org.lunifera.dsl.organization.semantic.model.impl.OrganizationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>OOrganization Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OOrganization Model</em>'.
	 * @generated
	 */
	OOrganizationModel createOOrganizationModel();

	/**
	 * Returns a new object of class '<em>OHierarchy Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OHierarchy Root</em>'.
	 * @generated
	 */
	OHierarchyRoot createOHierarchyRoot();

	/**
	 * Returns a new object of class '<em>OOrganization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OOrganization</em>'.
	 * @generated
	 */
	OOrganization createOOrganization();

	/**
	 * Returns a new object of class '<em>OUnit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OUnit</em>'.
	 * @generated
	 */
	OUnit createOUnit();

	/**
	 * Returns a new object of class '<em>OPerson Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OPerson Role</em>'.
	 * @generated
	 */
	OPersonRole createOPersonRole();

	/**
	 * Returns a new object of class '<em>OUnit Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OUnit Role</em>'.
	 * @generated
	 */
	OUnitRole createOUnitRole();

	/**
	 * Returns a new object of class '<em>OPerson</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OPerson</em>'.
	 * @generated
	 */
	OPerson createOPerson();

	/**
	 * Returns a new object of class '<em>OWorker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OWorker</em>'.
	 * @generated
	 */
	OWorker createOWorker();

	/**
	 * Returns a new object of class '<em>OGroup</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OGroup</em>'.
	 * @generated
	 */
	OGroup createOGroup();

	/**
	 * Returns a new object of class '<em>OPartnership</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OPartnership</em>'.
	 * @generated
	 */
	OPartnership createOPartnership();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OrganizationPackage getOrganizationPackage();

} //OrganizationFactory

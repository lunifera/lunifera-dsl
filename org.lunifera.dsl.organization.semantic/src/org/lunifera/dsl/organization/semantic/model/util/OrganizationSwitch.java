/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.lunifera.dsl.organization.semantic.model.OBusinessRole;
import org.lunifera.dsl.organization.semantic.model.ODescribed;
import org.lunifera.dsl.organization.semantic.model.OGroup;
import org.lunifera.dsl.organization.semantic.model.OHierarchyRoot;
import org.lunifera.dsl.organization.semantic.model.ONamed;
import org.lunifera.dsl.organization.semantic.model.OOrganization;
import org.lunifera.dsl.organization.semantic.model.OOrganizationMember;
import org.lunifera.dsl.organization.semantic.model.OOrganizationModel;
import org.lunifera.dsl.organization.semantic.model.OPerson;
import org.lunifera.dsl.organization.semantic.model.OPersonRole;
import org.lunifera.dsl.organization.semantic.model.OUnit;
import org.lunifera.dsl.organization.semantic.model.OUnitRole;
import org.lunifera.dsl.organization.semantic.model.OWorker;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage
 * @generated
 */
public class OrganizationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OrganizationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationSwitch() {
		if (modelPackage == null) {
			modelPackage = OrganizationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OrganizationPackage.ONAMED: {
				ONamed oNamed = (ONamed)theEObject;
				T result = caseONamed(oNamed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.ODESCRIBED: {
				ODescribed oDescribed = (ODescribed)theEObject;
				T result = caseODescribed(oDescribed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OORGANIZATION_MODEL: {
				OOrganizationModel oOrganizationModel = (OOrganizationModel)theEObject;
				T result = caseOOrganizationModel(oOrganizationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OHIERARCHY_ROOT: {
				OHierarchyRoot oHierarchyRoot = (OHierarchyRoot)theEObject;
				T result = caseOHierarchyRoot(oHierarchyRoot);
				if (result == null) result = caseONamed(oHierarchyRoot);
				if (result == null) result = caseODescribed(oHierarchyRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OORGANIZATION: {
				OOrganization oOrganization = (OOrganization)theEObject;
				T result = caseOOrganization(oOrganization);
				if (result == null) result = caseONamed(oOrganization);
				if (result == null) result = caseODescribed(oOrganization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OUNIT: {
				OUnit oUnit = (OUnit)theEObject;
				T result = caseOUnit(oUnit);
				if (result == null) result = caseOOrganizationMember(oUnit);
				if (result == null) result = caseONamed(oUnit);
				if (result == null) result = caseODescribed(oUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OBUSINESS_ROLE: {
				OBusinessRole oBusinessRole = (OBusinessRole)theEObject;
				T result = caseOBusinessRole(oBusinessRole);
				if (result == null) result = caseOOrganizationMember(oBusinessRole);
				if (result == null) result = caseONamed(oBusinessRole);
				if (result == null) result = caseODescribed(oBusinessRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OPERSON_ROLE: {
				OPersonRole oPersonRole = (OPersonRole)theEObject;
				T result = caseOPersonRole(oPersonRole);
				if (result == null) result = caseOBusinessRole(oPersonRole);
				if (result == null) result = caseOOrganizationMember(oPersonRole);
				if (result == null) result = caseONamed(oPersonRole);
				if (result == null) result = caseODescribed(oPersonRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OUNIT_ROLE: {
				OUnitRole oUnitRole = (OUnitRole)theEObject;
				T result = caseOUnitRole(oUnitRole);
				if (result == null) result = caseOBusinessRole(oUnitRole);
				if (result == null) result = caseOOrganizationMember(oUnitRole);
				if (result == null) result = caseONamed(oUnitRole);
				if (result == null) result = caseODescribed(oUnitRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OPERSON: {
				OPerson oPerson = (OPerson)theEObject;
				T result = caseOPerson(oPerson);
				if (result == null) result = caseOOrganizationMember(oPerson);
				if (result == null) result = caseONamed(oPerson);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OWORKER: {
				OWorker oWorker = (OWorker)theEObject;
				T result = caseOWorker(oWorker);
				if (result == null) result = caseOOrganizationMember(oWorker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OGROUP: {
				OGroup oGroup = (OGroup)theEObject;
				T result = caseOGroup(oGroup);
				if (result == null) result = caseOOrganizationMember(oGroup);
				if (result == null) result = caseONamed(oGroup);
				if (result == null) result = caseODescribed(oGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OrganizationPackage.OORGANIZATION_MEMBER: {
				OOrganizationMember oOrganizationMember = (OOrganizationMember)theEObject;
				T result = caseOOrganizationMember(oOrganizationMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ONamed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ONamed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseONamed(ONamed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ODescribed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ODescribed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseODescribed(ODescribed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OOrganization Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OOrganization Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOOrganizationModel(OOrganizationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OHierarchy Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OHierarchy Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOHierarchyRoot(OHierarchyRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OOrganization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OOrganization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOOrganization(OOrganization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OUnit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OUnit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOUnit(OUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OBusiness Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OBusiness Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOBusinessRole(OBusinessRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OPerson Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OPerson Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPersonRole(OPersonRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OUnit Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OUnit Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOUnitRole(OUnitRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OPerson</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OPerson</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPerson(OPerson object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OWorker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OWorker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOWorker(OWorker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OGroup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OGroup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOGroup(OGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OOrganization Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OOrganization Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOOrganizationMember(OOrganizationMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //OrganizationSwitch

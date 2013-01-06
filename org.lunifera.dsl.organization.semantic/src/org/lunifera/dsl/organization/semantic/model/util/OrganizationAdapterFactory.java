/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.lunifera.dsl.organization.semantic.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.lunifera.dsl.organization.semantic.model.*;
import org.lunifera.dsl.organization.semantic.model.OBusinessRole;
import org.lunifera.dsl.organization.semantic.model.ODescribed;
import org.lunifera.dsl.organization.semantic.model.OGroup;
import org.lunifera.dsl.organization.semantic.model.OHierarchyRoot;
import org.lunifera.dsl.organization.semantic.model.ONamed;
import org.lunifera.dsl.organization.semantic.model.OOrganization;
import org.lunifera.dsl.organization.semantic.model.OOrganizationMember;
import org.lunifera.dsl.organization.semantic.model.OOrganizationModel;
import org.lunifera.dsl.organization.semantic.model.OPartnership;
import org.lunifera.dsl.organization.semantic.model.OPerson;
import org.lunifera.dsl.organization.semantic.model.OPersonRole;
import org.lunifera.dsl.organization.semantic.model.OUnit;
import org.lunifera.dsl.organization.semantic.model.OUnitRole;
import org.lunifera.dsl.organization.semantic.model.OWorker;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.organization.semantic.model.OrganizationPackage
 * @generated
 */
public class OrganizationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OrganizationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OrganizationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrganizationSwitch<Adapter> modelSwitch =
		new OrganizationSwitch<Adapter>() {
			@Override
			public Adapter caseONamed(ONamed object) {
				return createONamedAdapter();
			}
			@Override
			public Adapter caseODescribed(ODescribed object) {
				return createODescribedAdapter();
			}
			@Override
			public Adapter caseOOrganizationModel(OOrganizationModel object) {
				return createOOrganizationModelAdapter();
			}
			@Override
			public Adapter caseOHierarchyRoot(OHierarchyRoot object) {
				return createOHierarchyRootAdapter();
			}
			@Override
			public Adapter caseOOrganization(OOrganization object) {
				return createOOrganizationAdapter();
			}
			@Override
			public Adapter caseOUnit(OUnit object) {
				return createOUnitAdapter();
			}
			@Override
			public Adapter caseOBusinessRole(OBusinessRole object) {
				return createOBusinessRoleAdapter();
			}
			@Override
			public Adapter caseOPersonRole(OPersonRole object) {
				return createOPersonRoleAdapter();
			}
			@Override
			public Adapter caseOUnitRole(OUnitRole object) {
				return createOUnitRoleAdapter();
			}
			@Override
			public Adapter caseOPerson(OPerson object) {
				return createOPersonAdapter();
			}
			@Override
			public Adapter caseOWorker(OWorker object) {
				return createOWorkerAdapter();
			}
			@Override
			public Adapter caseOGroup(OGroup object) {
				return createOGroupAdapter();
			}
			@Override
			public Adapter caseOPartnership(OPartnership object) {
				return createOPartnershipAdapter();
			}
			@Override
			public Adapter caseOOrganizationMember(OOrganizationMember object) {
				return createOOrganizationMemberAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.ONamed <em>ONamed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.ONamed
	 * @generated
	 */
	public Adapter createONamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.ODescribed <em>ODescribed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.ODescribed
	 * @generated
	 */
	public Adapter createODescribedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OOrganizationModel <em>OOrganization Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganizationModel
	 * @generated
	 */
	public Adapter createOOrganizationModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OHierarchyRoot <em>OHierarchy Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OHierarchyRoot
	 * @generated
	 */
	public Adapter createOHierarchyRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OOrganization <em>OOrganization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganization
	 * @generated
	 */
	public Adapter createOOrganizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OUnit <em>OUnit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OUnit
	 * @generated
	 */
	public Adapter createOUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OBusinessRole <em>OBusiness Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OBusinessRole
	 * @generated
	 */
	public Adapter createOBusinessRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OPersonRole <em>OPerson Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OPersonRole
	 * @generated
	 */
	public Adapter createOPersonRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OUnitRole <em>OUnit Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OUnitRole
	 * @generated
	 */
	public Adapter createOUnitRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OPerson <em>OPerson</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OPerson
	 * @generated
	 */
	public Adapter createOPersonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OWorker <em>OWorker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OWorker
	 * @generated
	 */
	public Adapter createOWorkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OGroup <em>OGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OGroup
	 * @generated
	 */
	public Adapter createOGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OPartnership <em>OPartnership</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OPartnership
	 * @generated
	 */
	public Adapter createOPartnershipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.organization.semantic.model.OOrganizationMember <em>OOrganization Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.organization.semantic.model.OOrganizationMember
	 * @generated
	 */
	public Adapter createOOrganizationMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OrganizationAdapterFactory

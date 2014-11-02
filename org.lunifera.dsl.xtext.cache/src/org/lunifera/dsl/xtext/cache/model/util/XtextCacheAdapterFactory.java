/**
 */
package org.lunifera.dsl.xtext.cache.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.lunifera.dsl.xtext.cache.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage
 * @generated
 */
public class XtextCacheAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XtextCachePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextCacheAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XtextCachePackage.eINSTANCE;
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
	protected XtextCacheSwitch<Adapter> modelSwitch =
		new XtextCacheSwitch<Adapter>() {
			@Override
			public Adapter caseXCCacheContent(XCCacheContent object) {
				return createXCCacheContentAdapter();
			}
			@Override
			public Adapter caseXCJvmModelAssociation(XCJvmModelAssociation object) {
				return createXCJvmModelAssociationAdapter();
			}
			@Override
			public Adapter caseXCSourceToTarget(XCSourceToTarget object) {
				return createXCSourceToTargetAdapter();
			}
			@Override
			public Adapter caseXCTargetToSource(XCTargetToSource object) {
				return createXCTargetToSourceAdapter();
			}
			@Override
			public Adapter caseXCLogicalContainer(XCLogicalContainer object) {
				return createXCLogicalContainerAdapter();
			}
			@Override
			public Adapter caseXCMemberInfo(XCMemberInfo object) {
				return createXCMemberInfoAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.xtext.cache.model.XCCacheContent <em>XC Cache Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.xtext.cache.model.XCCacheContent
	 * @generated
	 */
	public Adapter createXCCacheContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation <em>XC Jvm Model Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation
	 * @generated
	 */
	public Adapter createXCJvmModelAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.xtext.cache.model.XCSourceToTarget <em>XC Source To Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.xtext.cache.model.XCSourceToTarget
	 * @generated
	 */
	public Adapter createXCSourceToTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.xtext.cache.model.XCTargetToSource <em>XC Target To Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.xtext.cache.model.XCTargetToSource
	 * @generated
	 */
	public Adapter createXCTargetToSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.xtext.cache.model.XCLogicalContainer <em>XC Logical Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.xtext.cache.model.XCLogicalContainer
	 * @generated
	 */
	public Adapter createXCLogicalContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo <em>XC Member Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.xtext.cache.model.XCMemberInfo
	 * @generated
	 */
	public Adapter createXCMemberInfoAdapter() {
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

} //XtextCacheAdapterFactory

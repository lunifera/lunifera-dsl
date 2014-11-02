/**
 */
package org.lunifera.dsl.xtext.cache.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.lunifera.dsl.xtext.cache.model.*;

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
 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage
 * @generated
 */
public class XtextCacheSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XtextCachePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextCacheSwitch() {
		if (modelPackage == null) {
			modelPackage = XtextCachePackage.eINSTANCE;
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
			case XtextCachePackage.XC_CACHE_CONTENT: {
				XCCacheContent xcCacheContent = (XCCacheContent)theEObject;
				T result = caseXCCacheContent(xcCacheContent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION: {
				XCJvmModelAssociation xcJvmModelAssociation = (XCJvmModelAssociation)theEObject;
				T result = caseXCJvmModelAssociation(xcJvmModelAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextCachePackage.XC_SOURCE_TO_TARGET: {
				XCSourceToTarget xcSourceToTarget = (XCSourceToTarget)theEObject;
				T result = caseXCSourceToTarget(xcSourceToTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextCachePackage.XC_TARGET_TO_SOURCE: {
				XCTargetToSource xcTargetToSource = (XCTargetToSource)theEObject;
				T result = caseXCTargetToSource(xcTargetToSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextCachePackage.XC_LOGICAL_CONTAINER: {
				XCLogicalContainer xcLogicalContainer = (XCLogicalContainer)theEObject;
				T result = caseXCLogicalContainer(xcLogicalContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextCachePackage.XC_MEMBER_INFO: {
				XCMemberInfo xcMemberInfo = (XCMemberInfo)theEObject;
				T result = caseXCMemberInfo(xcMemberInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XC Cache Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XC Cache Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCCacheContent(XCCacheContent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XC Jvm Model Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XC Jvm Model Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCJvmModelAssociation(XCJvmModelAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XC Source To Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XC Source To Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCSourceToTarget(XCSourceToTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XC Target To Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XC Target To Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCTargetToSource(XCTargetToSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XC Logical Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XC Logical Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCLogicalContainer(XCLogicalContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XC Member Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XC Member Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCMemberInfo(XCMemberInfo object) {
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

} //XtextCacheSwitch

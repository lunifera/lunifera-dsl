/**
 */
package org.lunifera.dsl.xtext.cache.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage
 * @generated
 */
public interface XtextCacheFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtextCacheFactory eINSTANCE = org.lunifera.dsl.xtext.cache.model.impl.XtextCacheFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XC Cache Content</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XC Cache Content</em>'.
	 * @generated
	 */
	XCCacheContent createXCCacheContent();

	/**
	 * Returns a new object of class '<em>XC Jvm Model Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XC Jvm Model Association</em>'.
	 * @generated
	 */
	XCJvmModelAssociation createXCJvmModelAssociation();

	/**
	 * Returns a new object of class '<em>XC Source To Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XC Source To Target</em>'.
	 * @generated
	 */
	XCSourceToTarget createXCSourceToTarget();

	/**
	 * Returns a new object of class '<em>XC Target To Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XC Target To Source</em>'.
	 * @generated
	 */
	XCTargetToSource createXCTargetToSource();

	/**
	 * Returns a new object of class '<em>XC Logical Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XC Logical Container</em>'.
	 * @generated
	 */
	XCLogicalContainer createXCLogicalContainer();

	/**
	 * Returns a new object of class '<em>XC Member Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XC Member Info</em>'.
	 * @generated
	 */
	XCMemberInfo createXCMemberInfo();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XtextCachePackage getXtextCachePackage();

} //XtextCacheFactory

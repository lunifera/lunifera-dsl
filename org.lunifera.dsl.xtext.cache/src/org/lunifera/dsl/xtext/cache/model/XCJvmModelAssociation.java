/**
 */
package org.lunifera.dsl.xtext.cache.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XC Jvm Model Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation#getSourceToTargets <em>Source To Targets</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation#getTargetToSources <em>Target To Sources</em>}</li>
 *   <li>{@link org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation#getLocalContainers <em>Local Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCJvmModelAssociation()
 * @model
 * @generated
 */
public interface XCJvmModelAssociation extends EObject {
	/**
	 * Returns the value of the '<em><b>Source To Targets</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.xtext.cache.model.XCSourceToTarget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source To Targets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source To Targets</em>' containment reference list.
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCJvmModelAssociation_SourceToTargets()
	 * @model containment="true"
	 * @generated
	 */
	EList<XCSourceToTarget> getSourceToTargets();

	/**
	 * Returns the value of the '<em><b>Target To Sources</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.xtext.cache.model.XCTargetToSource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target To Sources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target To Sources</em>' containment reference list.
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCJvmModelAssociation_TargetToSources()
	 * @model containment="true"
	 * @generated
	 */
	EList<XCTargetToSource> getTargetToSources();

	/**
	 * Returns the value of the '<em><b>Local Containers</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.xtext.cache.model.XCLogicalContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Containers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Containers</em>' containment reference list.
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#getXCJvmModelAssociation_LocalContainers()
	 * @model containment="true"
	 * @generated
	 */
	EList<XCLogicalContainer> getLocalContainers();

} // XCJvmModelAssociation

/**
 */
package org.lunifera.dsl.component.semantic.model;

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
 *   <li>{@link org.lunifera.dsl.component.semantic.model.ComponentModel#getName <em>Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.component.semantic.model.ComponentModel#getUnitTypes <em>Unit Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.component.semantic.model.ComponentPackage#getComponentModel()
 * @model
 * @generated
 */
public interface ComponentModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.lunifera.dsl.component.semantic.model.ComponentPackage#getComponentModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.component.semantic.model.ComponentModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Unit Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.component.semantic.model.UnitType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Types</em>' containment reference list.
	 * @see org.lunifera.dsl.component.semantic.model.ComponentPackage#getComponentModel_UnitTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnitType> getUnitTypes();

} // ComponentModel

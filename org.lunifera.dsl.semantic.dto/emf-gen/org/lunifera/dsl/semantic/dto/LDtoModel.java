/**
 */
package org.lunifera.dsl.semantic.dto;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.lunifera.dsl.semantic.common.types.LTypedPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDto Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDtoModel#getPackages <em>Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDtoModel()
 * @model
 * @generated
 */
public interface LDtoModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
   * The list contents are of type {@link org.lunifera.dsl.semantic.common.types.LTypedPackage}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Packages</em>' containment reference list.
   * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDtoModel_Packages()
   * @model containment="true"
   * @generated
   */
  EList<LTypedPackage> getPackages();

} // LDtoModel

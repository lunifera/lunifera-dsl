/**
 */
package org.lunifera.dsl.semantic.common.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LMultiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getLower <em>Lower</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLMultiplicity()
 * @model
 * @generated
 */
public interface LMultiplicity extends EObject
{
  /**
   * Returns the value of the '<em><b>Lower</b></em>' attribute.
   * The literals are from the enumeration {@link org.lunifera.dsl.semantic.common.types.LLowerBound}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower</em>' attribute.
   * @see org.lunifera.dsl.semantic.common.types.LLowerBound
   * @see #setLower(LLowerBound)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLMultiplicity_Lower()
   * @model unique="false"
   * @generated
   */
  LLowerBound getLower();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getLower <em>Lower</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower</em>' attribute.
   * @see org.lunifera.dsl.semantic.common.types.LLowerBound
   * @see #getLower()
   * @generated
   */
  void setLower(LLowerBound value);

  /**
   * Returns the value of the '<em><b>Upper</b></em>' attribute.
   * The literals are from the enumeration {@link org.lunifera.dsl.semantic.common.types.LUpperBound}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper</em>' attribute.
   * @see org.lunifera.dsl.semantic.common.types.LUpperBound
   * @see #setUpper(LUpperBound)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLMultiplicity_Upper()
   * @model unique="false"
   * @generated
   */
  LUpperBound getUpper();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getUpper <em>Upper</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper</em>' attribute.
   * @see org.lunifera.dsl.semantic.common.types.LUpperBound
   * @see #getUpper()
   * @generated
   */
  void setUpper(LUpperBound value);

} // LMultiplicity

/**
 */
package org.lunifera.dsl.semantic.dto;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDto Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDtoReference#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDtoReference()
 * @model
 * @generated
 */
public interface LDtoReference extends LDtoAbstractReference
{
  /**
   * Returns the value of the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opposite</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opposite</em>' reference.
   * @see #setOpposite(LDtoReference)
   * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDtoReference_Opposite()
   * @model
   * @generated
   */
  LDtoReference getOpposite();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDtoReference#getOpposite <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opposite</em>' reference.
   * @see #getOpposite()
   * @generated
   */
  void setOpposite(LDtoReference value);

} // LDtoReference

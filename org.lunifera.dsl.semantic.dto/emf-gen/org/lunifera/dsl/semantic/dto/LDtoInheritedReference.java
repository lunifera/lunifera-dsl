/**
 */
package org.lunifera.dsl.semantic.dto;

import org.lunifera.dsl.semantic.common.types.LMultiplicity;
import org.lunifera.dsl.semantic.common.types.LReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDto Inherited Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDtoInheritedReference#getInheritedFeature <em>Inherited Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDtoInheritedReference()
 * @model
 * @generated
 */
public interface LDtoInheritedReference extends LDtoAbstractReference
{
  /**
   * Returns the value of the '<em><b>Inherited Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inherited Feature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inherited Feature</em>' reference.
   * @see #setInheritedFeature(LReference)
   * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDtoInheritedReference_InheritedFeature()
   * @model
   * @generated
   */
  LReference getInheritedFeature();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDtoInheritedReference#getInheritedFeature <em>Inherited Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inherited Feature</em>' reference.
   * @see #getInheritedFeature()
   * @generated
   */
  void setInheritedFeature(LReference value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.lunifera.dsl.semantic.common.types.LReference%> _inheritedFeature = this.getInheritedFeature();\nreturn _inheritedFeature.getMultiplicity();'"
   * @generated
   */
  LMultiplicity getInheritedMultiplicity();

} // LDtoInheritedReference

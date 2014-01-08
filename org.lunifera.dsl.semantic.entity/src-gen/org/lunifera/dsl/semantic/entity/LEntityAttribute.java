/**
 */
package org.lunifera.dsl.semantic.entity;

import org.lunifera.dsl.semantic.common.types.LAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LEntity Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityAttribute#isUuid <em>Uuid</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLEntityAttribute()
 * @model
 * @generated
 */
public interface LEntityAttribute extends LEntityFeature, LAttribute
{
  /**
   * Returns the value of the '<em><b>Uuid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uuid</em>' attribute.
   * @see #setUuid(boolean)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLEntityAttribute_Uuid()
   * @model unique="false"
   * @generated
   */
  boolean isUuid();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityAttribute#isUuid <em>Uuid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uuid</em>' attribute.
   * @see #isUuid()
   * @generated
   */
  void setUuid(boolean value);

} // LEntityAttribute

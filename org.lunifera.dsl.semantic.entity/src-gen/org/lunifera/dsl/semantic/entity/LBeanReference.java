/**
 */
package org.lunifera.dsl.semantic.entity;

import org.lunifera.dsl.semantic.common.types.LReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LBean Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBeanReference#getType <em>Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBeanReference#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLBeanReference()
 * @model
 * @generated
 */
public interface LBeanReference extends LBeanFeature, LReference
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(LBean)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLBeanReference_Type()
   * @model
   * @generated
   */
  LBean getType();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(LBean value);

  /**
   * Returns the value of the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opposite</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opposite</em>' reference.
   * @see #setOpposite(LBeanReference)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLBeanReference_Opposite()
   * @model
   * @generated
   */
  LBeanReference getOpposite();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getOpposite <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opposite</em>' reference.
   * @see #getOpposite()
   * @generated
   */
  void setOpposite(LBeanReference value);

} // LBeanReference

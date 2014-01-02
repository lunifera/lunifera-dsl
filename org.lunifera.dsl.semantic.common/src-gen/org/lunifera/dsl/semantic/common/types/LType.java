/**
 */
package org.lunifera.dsl.semantic.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LType</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LType#getName <em>Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LType#getAnnotationInfo <em>Annotation Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLType()
 * @model
 * @generated
 */
public interface LType extends LAnnotationTarget
{
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
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLType_Name()
   * @model unique="false"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation Info</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation Info</em>' containment reference.
   * @see #setAnnotationInfo(LAnnotationTarget)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLType_AnnotationInfo()
   * @model containment="true"
   * @generated
   */
  LAnnotationTarget getAnnotationInfo();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LType#getAnnotationInfo <em>Annotation Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotation Info</em>' containment reference.
   * @see #getAnnotationInfo()
   * @generated
   */
  void setAnnotationInfo(LAnnotationTarget value);

} // LType

/**
 */
package org.lunifera.dsl.semantic.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LClass#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LClass#isSerializable <em>Serializable</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LClass#getShortName <em>Short Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLClass()
 * @model
 * @generated
 */
public interface LClass extends LType
{
  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLClass_Abstract()
   * @model unique="false"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LClass#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Serializable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Serializable</em>' attribute.
   * @see #setSerializable(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLClass_Serializable()
   * @model unique="false"
   * @generated
   */
  boolean isSerializable();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LClass#isSerializable <em>Serializable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Serializable</em>' attribute.
   * @see #isSerializable()
   * @generated
   */
  void setSerializable(boolean value);

  /**
   * Returns the value of the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Short Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Short Name</em>' attribute.
   * @see #setShortName(String)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLClass_ShortName()
   * @model unique="false"
   * @generated
   */
  String getShortName();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LClass#getShortName <em>Short Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Short Name</em>' attribute.
   * @see #getShortName()
   * @generated
   */
  void setShortName(String value);

} // LClass

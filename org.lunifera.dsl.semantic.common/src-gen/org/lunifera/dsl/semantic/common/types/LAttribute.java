/**
 */
package org.lunifera.dsl.semantic.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LAttribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isId <em>Id</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isVersion <em>Version</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isLazy <em>Lazy</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isCascading <em>Cascading</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LAttribute extends LFeature
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_Id()
   * @model unique="false"
   * @generated
   */
  boolean isId();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #isId()
   * @generated
   */
  void setId(boolean value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_Version()
   * @model unique="false"
   * @generated
   */
  boolean isVersion();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #isVersion()
   * @generated
   */
  void setVersion(boolean value);

  /**
   * Returns the value of the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lazy</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lazy</em>' attribute.
   * @see #setLazy(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_Lazy()
   * @model unique="false"
   * @generated
   */
  boolean isLazy();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isLazy <em>Lazy</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lazy</em>' attribute.
   * @see #isLazy()
   * @generated
   */
  void setLazy(boolean value);

  /**
   * Returns the value of the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cascading</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cascading</em>' attribute.
   * @see #setCascading(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_Cascading()
   * @model unique="false"
   * @generated
   */
  boolean isCascading();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isCascading <em>Cascading</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cascading</em>' attribute.
   * @see #isCascading()
   * @generated
   */
  void setCascading(boolean value);

  /**
   * Returns the value of the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transient</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transient</em>' attribute.
   * @see #setTransient(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_Transient()
   * @model unique="false"
   * @generated
   */
  boolean isTransient();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isTransient <em>Transient</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transient</em>' attribute.
   * @see #isTransient()
   * @generated
   */
  void setTransient(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(LScalarType)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_Type()
   * @model
   * @generated
   */
  LScalarType getType();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(LScalarType value);

} // LAttribute

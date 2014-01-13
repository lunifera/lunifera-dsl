/**
 */
package org.lunifera.dsl.semantic.common.types;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LData Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDataType#getJvmTypeReference <em>Jvm Type Reference</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDataType#isAsPrimitive <em>As Primitive</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDataType#isDate <em>Date</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDataType#isAsBlob <em>As Blob</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDataType#getLength <em>Length</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDataType#getDateType <em>Date Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDataType#isSyntheticFlag <em>Synthetic Flag</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDataType#getSyntheticType <em>Synthetic Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LDataType#getSyntheticTypeReference <em>Synthetic Type Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType()
 * @model
 * @generated
 */
public interface LDataType extends LScalarType
{
  /**
   * Returns the value of the '<em><b>Jvm Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jvm Type Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jvm Type Reference</em>' containment reference.
   * @see #setJvmTypeReference(JvmTypeReference)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType_JvmTypeReference()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getJvmTypeReference();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDataType#getJvmTypeReference <em>Jvm Type Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Jvm Type Reference</em>' containment reference.
   * @see #getJvmTypeReference()
   * @generated
   */
  void setJvmTypeReference(JvmTypeReference value);

  /**
   * Returns the value of the '<em><b>As Primitive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>As Primitive</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>As Primitive</em>' attribute.
   * @see #setAsPrimitive(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType_AsPrimitive()
   * @model unique="false"
   * @generated
   */
  boolean isAsPrimitive();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDataType#isAsPrimitive <em>As Primitive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>As Primitive</em>' attribute.
   * @see #isAsPrimitive()
   * @generated
   */
  void setAsPrimitive(boolean value);

  /**
   * Returns the value of the '<em><b>Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date</em>' attribute.
   * @see #setDate(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType_Date()
   * @model unique="false"
   * @generated
   */
  boolean isDate();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDataType#isDate <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date</em>' attribute.
   * @see #isDate()
   * @generated
   */
  void setDate(boolean value);

  /**
   * Returns the value of the '<em><b>As Blob</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>As Blob</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>As Blob</em>' attribute.
   * @see #setAsBlob(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType_AsBlob()
   * @model unique="false"
   * @generated
   */
  boolean isAsBlob();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDataType#isAsBlob <em>As Blob</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>As Blob</em>' attribute.
   * @see #isAsBlob()
   * @generated
   */
  void setAsBlob(boolean value);

  /**
   * Returns the value of the '<em><b>Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Length</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Length</em>' attribute.
   * @see #setLength(int)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType_Length()
   * @model unique="false"
   * @generated
   */
  int getLength();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDataType#getLength <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Length</em>' attribute.
   * @see #getLength()
   * @generated
   */
  void setLength(int value);

  /**
   * Returns the value of the '<em><b>Date Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.lunifera.dsl.semantic.common.types.LDateType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Type</em>' attribute.
   * @see org.lunifera.dsl.semantic.common.types.LDateType
   * @see #setDateType(LDateType)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType_DateType()
   * @model unique="false"
   * @generated
   */
  LDateType getDateType();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDataType#getDateType <em>Date Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Type</em>' attribute.
   * @see org.lunifera.dsl.semantic.common.types.LDateType
   * @see #getDateType()
   * @generated
   */
  void setDateType(LDateType value);

  /**
   * Returns the value of the '<em><b>Synthetic Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Attention: synthetic must only be used inside the same resource
   * <!-- end-model-doc -->
   * @return the value of the '<em>Synthetic Flag</em>' attribute.
   * @see #setSyntheticFlag(boolean)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType_SyntheticFlag()
   * @model unique="false"
   * @generated
   */
  boolean isSyntheticFlag();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDataType#isSyntheticFlag <em>Synthetic Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Synthetic Flag</em>' attribute.
   * @see #isSyntheticFlag()
   * @generated
   */
  void setSyntheticFlag(boolean value);

  /**
   * Returns the value of the '<em><b>Synthetic Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Synthetic Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Synthetic Type</em>' attribute.
   * @see #setSyntheticType(String)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType_SyntheticType()
   * @model unique="false"
   * @generated
   */
  String getSyntheticType();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDataType#getSyntheticType <em>Synthetic Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Synthetic Type</em>' attribute.
   * @see #getSyntheticType()
   * @generated
   */
  void setSyntheticType(String value);

  /**
   * Returns the value of the '<em><b>Synthetic Type Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Synthetic Type Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Synthetic Type Reference</em>' reference.
   * @see #setSyntheticTypeReference(LFeature)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLDataType_SyntheticTypeReference()
   * @model
   * @generated
   */
  LFeature getSyntheticTypeReference();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LDataType#getSyntheticTypeReference <em>Synthetic Type Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Synthetic Type Reference</em>' reference.
   * @see #getSyntheticTypeReference()
   * @generated
   */
  void setSyntheticTypeReference(LFeature value);

} // LDataType

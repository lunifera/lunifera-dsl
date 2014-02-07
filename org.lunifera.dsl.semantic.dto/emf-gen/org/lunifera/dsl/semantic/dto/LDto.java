/**
 */
package org.lunifera.dsl.semantic.dto;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LFeaturesHolder;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.common.types.LType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDto</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A bean is an embeddable element that may become added to a entity using the @embedd annotation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDto#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDto#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDto#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDto#getWrappedType <em>Wrapped Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDto()
 * @model
 * @generated
 */
public interface LDto extends LClass, LFeaturesHolder, LScalarType
{
  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.lunifera.dsl.semantic.dto.LDtoFeature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDto_Features()
   * @model containment="true"
   * @generated
   */
  EList<LDtoFeature> getFeatures();

  /**
   * Returns the value of the '<em><b>Super Type</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.dto.LDto#getSubTypes <em>Sub Types</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' reference.
   * @see #setSuperType(LDto)
   * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDto_SuperType()
   * @see org.lunifera.dsl.semantic.dto.LDto#getSubTypes
   * @model opposite="subTypes" resolveProxies="false"
   * @generated
   */
  LDto getSuperType();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDto#getSuperType <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(LDto value);

  /**
   * Returns the value of the '<em><b>Sub Types</b></em>' reference list.
   * The list contents are of type {@link org.lunifera.dsl.semantic.dto.LDto}.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.dto.LDto#getSuperType <em>Super Type</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Types</em>' reference list.
   * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDto_SubTypes()
   * @see org.lunifera.dsl.semantic.dto.LDto#getSuperType
   * @model opposite="superType" transient="true"
   * @generated
   */
  EList<LDto> getSubTypes();

  /**
   * Returns the value of the '<em><b>Wrapped Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Wrapped Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Wrapped Type</em>' reference.
   * @see #setWrappedType(LType)
   * @see org.lunifera.dsl.semantic.dto.DtoPackage#getLDto_WrappedType()
   * @model
   * @generated
   */
  LType getWrappedType();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDto#getWrappedType <em>Wrapped Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Wrapped Type</em>' reference.
   * @see #getWrappedType()
   * @generated
   */
  void setWrappedType(LType value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all features of type LOperation
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.dto.OperationsList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.dto.LDtoFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.dto.LDtoOperation%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.dto.LDtoOperation%>>filter(_features, <%org.lunifera.dsl.semantic.dto.LDtoOperation%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.dto.LDtoOperation%>>toList(_filter);'"
   * @generated
   */
  List<LDtoOperation> getOperations();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all features of type LDtoReference
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.dto.DtoReferenceList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.dto.LDtoFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.dto.LDtoReference%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.dto.LDtoReference%>>filter(_features, <%org.lunifera.dsl.semantic.dto.LDtoReference%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.dto.LDtoReference%>>toList(_filter);'"
   * @generated
   */
  List<LDtoReference> getReferences();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all features of type LDtoAttribute
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.dto.DtoAttributeList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.dto.LDtoFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.dto.LDtoAttribute%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.dto.LDtoAttribute%>>filter(_features, <%org.lunifera.dsl.semantic.dto.LDtoAttribute%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.dto.LDtoAttribute%>>toList(_filter);'"
   * @generated
   */
  List<LDtoAttribute> getAttributes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all features of the holder and from super types
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.common.types.FeaturesList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%java.util.List%><<%org.lunifera.dsl.semantic.dto.LDtoFeature%>> result = <%org.eclipse.xtext.xbase.lib.CollectionLiterals%>.<<%org.lunifera.dsl.semantic.dto.LDtoFeature%>>newArrayList();\nthis.collectAllLunFeatures(this, result);\nreturn result;'"
   * @generated
   */
  List<? extends LFeature> getAllFeatures();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model currentUnique="false" resultDataType="org.lunifera.dsl.semantic.dto.DtoFeatureList" resultUnique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(current, null);\nif (_equals)\n{\n\treturn;\n}\n<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.dto.LDtoFeature%>> _features = current.getFeatures();\nresult.addAll(_features);\n<%org.lunifera.dsl.semantic.dto.LDto%> _superType = current.getSuperType();\nthis.collectAllLunFeatures(_superType, result);'"
   * @generated
   */
  void collectAllLunFeatures(LDto current, List<LDtoFeature> result);

} // LDto

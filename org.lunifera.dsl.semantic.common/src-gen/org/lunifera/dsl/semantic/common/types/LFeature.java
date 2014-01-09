/**
 */
package org.lunifera.dsl.semantic.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LFeature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LFeature#getName <em>Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LFeature#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LFeature#getAnnotationInfo <em>Annotation Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLFeature()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LFeature extends LAnnotationTarget
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
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLFeature_Name()
   * @model unique="false"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LFeature#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' containment reference.
   * @see #setMultiplicity(LMultiplicity)
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLFeature_Multiplicity()
   * @model containment="true"
   * @generated
   */
  LMultiplicity getMultiplicity();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LFeature#getMultiplicity <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' containment reference.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(LMultiplicity value);

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
   * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLFeature_AnnotationInfo()
   * @model containment="true"
   * @generated
   */
  LAnnotationTarget getAnnotationInfo();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LFeature#getAnnotationInfo <em>Annotation Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotation Info</em>' containment reference.
   * @see #getAnnotationInfo()
   * @generated
   */
  void setAnnotationInfo(LAnnotationTarget value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Delegates the annotation request to the target element.
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.common.types.AnnotationList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.common.types.LAnnotationDef%>> _xifexpression = null;\n<%org.lunifera.dsl.semantic.common.types.LAnnotationTarget%> _annotationInfo = this.getAnnotationInfo();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_annotationInfo, null));\nif (_notEquals)\n{\n\t<%org.lunifera.dsl.semantic.common.types.LAnnotationTarget%> _annotationInfo_1 = this.getAnnotationInfo();\n\t<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.common.types.LAnnotationDef%>> _annotations = _annotationInfo_1.getAnnotations();\n\t_xifexpression = _annotations;\n}\nelse\n{\n\t<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.common.types.LAnnotationDef%>> _annotations_1 = this.getAnnotations();\n\t_xifexpression = _annotations_1;\n}\nreturn _xifexpression;'"
   * @generated
   */
  EList<LAnnotationDef> getResolvedAnnotations();

} // LFeature

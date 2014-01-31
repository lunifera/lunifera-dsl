/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
 * 
 *  Based on ideas from Xtext, Xtend, Xcore
 *    
 *  Contributors:  
 *  		Florian Pirchner - Initial implementation 
 *  
 */
package org.lunifera.dsl.semantic.entity;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LFeaturesHolder;
import org.lunifera.dsl.semantic.common.types.LScalarType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LBean</b></em>'.
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
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBean#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBean#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBean#getSubTypes <em>Sub Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBean()
 * @model
 * @generated
 */
public interface LBean extends LClass, LScalarType, LFeaturesHolder
{
  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.lunifera.dsl.semantic.entity.LBeanFeature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBean_Features()
   * @model containment="true"
   * @generated
   */
  EList<LBeanFeature> getFeatures();

  /**
   * Returns the value of the '<em><b>Super Type</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.entity.LBean#getSubTypes <em>Sub Types</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' reference.
   * @see #setSuperType(LBean)
   * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBean_SuperType()
   * @see org.lunifera.dsl.semantic.entity.LBean#getSubTypes
   * @model opposite="subTypes"
   * @generated
   */
  LBean getSuperType();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBean#getSuperType <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(LBean value);

  /**
   * Returns the value of the '<em><b>Sub Types</b></em>' reference list.
   * The list contents are of type {@link org.lunifera.dsl.semantic.entity.LBean}.
   * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.entity.LBean#getSuperType <em>Super Type</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Types</em>' reference list.
   * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBean_SubTypes()
   * @see org.lunifera.dsl.semantic.entity.LBean#getSuperType
   * @model opposite="superType"
   * @generated
   */
  EList<LBean> getSubTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all features of type LOperation
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.OperationsList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.entity.LBeanFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LOperation%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LOperation%>>filter(_features, <%org.lunifera.dsl.semantic.entity.LOperation%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LOperation%>>toList(_filter);'"
   * @generated
   */
  List<LOperation> getOperations();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all features of type LBeanReference
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.BeanReferenceList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.entity.LBeanFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LBeanReference%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LBeanReference%>>filter(_features, <%org.lunifera.dsl.semantic.entity.LBeanReference%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LBeanReference%>>toList(_filter);'"
   * @generated
   */
  List<LBeanReference> getReferences();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all features of type LBeanAttribute
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.BeanAttributeList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.entity.LBeanFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LBeanAttribute%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LBeanAttribute%>>filter(_features, <%org.lunifera.dsl.semantic.entity.LBeanAttribute%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LBeanAttribute%>>toList(_filter);'"
   * @generated
   */
  List<LBeanAttribute> getAttributes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all features of the holder and from super types
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.BeanFeatureList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%java.util.List%><<%org.lunifera.dsl.semantic.entity.LBeanFeature%>> result = <%org.eclipse.xtext.xbase.lib.CollectionLiterals%>.<<%org.lunifera.dsl.semantic.entity.LBeanFeature%>>newArrayList();\nthis.collectAllLunFeatures(this, result);\nreturn result;'"
   * @generated
   */
  List<LBeanFeature> getAllFeatures();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all attributes of the holder and from super types
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.BeanAttributeList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%java.util.List%><<%org.lunifera.dsl.semantic.entity.LBeanFeature%>> result = <%org.eclipse.xtext.xbase.lib.CollectionLiterals%>.<<%org.lunifera.dsl.semantic.entity.LBeanFeature%>>newArrayList();\nthis.collectAllLunFeatures(this, result);\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LBeanAttribute%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LBeanAttribute%>>filter(result, <%org.lunifera.dsl.semantic.entity.LBeanAttribute%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LBeanAttribute%>>toList(_filter);'"
   * @generated
   */
  List<LBeanAttribute> getAllAttributes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * *
   * Returns all references of the holder and from super types
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.BeanReferenceList" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%java.util.List%><<%org.lunifera.dsl.semantic.entity.LBeanFeature%>> result = <%org.eclipse.xtext.xbase.lib.CollectionLiterals%>.<<%org.lunifera.dsl.semantic.entity.LBeanFeature%>>newArrayList();\nthis.collectAllLunFeatures(this, result);\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LBeanReference%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LBeanReference%>>filter(result, <%org.lunifera.dsl.semantic.entity.LBeanReference%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LBeanReference%>>toList(_filter);'"
   * @generated
   */
  List<LBeanReference> getAllReferences();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model currentUnique="false" resultDataType="org.lunifera.dsl.semantic.entity.BeanFeatureList" resultUnique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(current, null);\nif (_equals)\n{\n\treturn;\n}\n<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.entity.LBeanFeature%>> _features = current.getFeatures();\nresult.addAll(_features);\n<%org.lunifera.dsl.semantic.entity.LBean%> _superType = current.getSuperType();\nthis.collectAllLunFeatures(_superType, result);'"
   * @generated
   */
  void collectAllLunFeatures(LBean current, List<LBeanFeature> result);

} // LBean

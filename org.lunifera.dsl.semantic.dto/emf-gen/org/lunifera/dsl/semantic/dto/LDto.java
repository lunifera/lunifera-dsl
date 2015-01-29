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
package org.lunifera.dsl.semantic.dto;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmTypeReference;

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
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDto#getSuperTypeJvm <em>Super Type Jvm</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDto#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDto#getWrappedType <em>Wrapped Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDto#getWrappedTypeJvm <em>Wrapped Type Jvm</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDto()
 * @model
 * @generated
 */
public interface LDto extends LClass, LFeaturesHolder, LScalarType {
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
	 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDto_Features()
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
	 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDto_SuperType()
	 * @see org.lunifera.dsl.semantic.dto.LDto#getSubTypes
	 * @model opposite="subTypes"
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
	 * Returns the value of the '<em><b>Super Type Jvm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Type Jvm</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Type Jvm</em>' containment reference.
	 * @see #setSuperTypeJvm(JvmTypeReference)
	 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDto_SuperTypeJvm()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	JvmTypeReference getSuperTypeJvm();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDto#getSuperTypeJvm <em>Super Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Type Jvm</em>' containment reference.
	 * @see #getSuperTypeJvm()
	 * @generated
	 */
	void setSuperTypeJvm(JvmTypeReference value);

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
	 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDto_SubTypes()
	 * @see org.lunifera.dsl.semantic.dto.LDto#getSuperType
	 * @model opposite="superType"
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
	 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDto_WrappedType()
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
	 * Returns the value of the '<em><b>Wrapped Type Jvm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wrapped Type Jvm</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wrapped Type Jvm</em>' containment reference.
	 * @see #setWrappedTypeJvm(JvmTypeReference)
	 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDto_WrappedTypeJvm()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	JvmTypeReference getWrappedTypeJvm();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDto#getWrappedTypeJvm <em>Wrapped Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wrapped Type Jvm</em>' containment reference.
	 * @see #getWrappedTypeJvm()
	 * @generated
	 */
	void setWrappedTypeJvm(JvmTypeReference value);

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.dto.LDtoFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.dto.LDtoAbstractReference%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.dto.LDtoAbstractReference%>>filter(_features, <%org.lunifera.dsl.semantic.dto.LDtoAbstractReference%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.dto.LDtoAbstractReference%>>toList(_filter);'"
	 * @generated
	 */
	List<LDtoAbstractReference> getReferences();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns all features of type LDtoAttribute
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.lunifera.dsl.semantic.dto.DtoAttributeList" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.dto.LDtoFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute%>>filter(_features, <%org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute%>>toList(_filter);'"
	 * @generated
	 */
	List<LDtoAbstractAttribute> getAttributes();

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

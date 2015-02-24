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

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LDateType;
import org.lunifera.dsl.semantic.common.types.LFeaturesHolder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LEntity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents a JPA entity.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#isCacheable <em>Cacheable</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#isHistorized <em>Historized</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#isTimedependent <em>Timedependent</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#getTimedependentDateType <em>Timedependent Date Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#isMappedSuperclass <em>Mapped Superclass</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#getPersistenceInfo <em>Persistence Info</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#getInheritanceStrategy <em>Inheritance Strategy</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#getSuperTypeJvm <em>Super Type Jvm</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntity#getSubTypes <em>Sub Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity()
 * @model
 * @generated
 */
public interface LEntity extends LClass, LFeaturesHolder {
	/**
	 * Returns the value of the '<em><b>Cacheable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cacheable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cacheable</em>' attribute.
	 * @see #setCacheable(boolean)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_Cacheable()
	 * @model unique="false"
	 * @generated
	 */
	boolean isCacheable();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntity#isCacheable <em>Cacheable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cacheable</em>' attribute.
	 * @see #isCacheable()
	 * @generated
	 */
	void setCacheable(boolean value);

	/**
	 * Returns the value of the '<em><b>Historized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Historized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Historized</em>' attribute.
	 * @see #setHistorized(boolean)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_Historized()
	 * @model unique="false"
	 * @generated
	 */
	boolean isHistorized();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntity#isHistorized <em>Historized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Historized</em>' attribute.
	 * @see #isHistorized()
	 * @generated
	 */
	void setHistorized(boolean value);

	/**
	 * Returns the value of the '<em><b>Timedependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timedependent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timedependent</em>' attribute.
	 * @see #setTimedependent(boolean)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_Timedependent()
	 * @model unique="false"
	 * @generated
	 */
	boolean isTimedependent();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntity#isTimedependent <em>Timedependent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timedependent</em>' attribute.
	 * @see #isTimedependent()
	 * @generated
	 */
	void setTimedependent(boolean value);

	/**
	 * Returns the value of the '<em><b>Timedependent Date Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.lunifera.dsl.semantic.common.types.LDateType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timedependent Date Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timedependent Date Type</em>' attribute.
	 * @see org.lunifera.dsl.semantic.common.types.LDateType
	 * @see #setTimedependentDateType(LDateType)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_TimedependentDateType()
	 * @model unique="false"
	 * @generated
	 */
	LDateType getTimedependentDateType();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntity#getTimedependentDateType <em>Timedependent Date Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timedependent Date Type</em>' attribute.
	 * @see org.lunifera.dsl.semantic.common.types.LDateType
	 * @see #getTimedependentDateType()
	 * @generated
	 */
	void setTimedependentDateType(LDateType value);

	/**
	 * Returns the value of the '<em><b>Mapped Superclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped Superclass</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Superclass</em>' attribute.
	 * @see #setMappedSuperclass(boolean)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_MappedSuperclass()
	 * @model unique="false"
	 * @generated
	 */
	boolean isMappedSuperclass();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntity#isMappedSuperclass <em>Mapped Superclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Superclass</em>' attribute.
	 * @see #isMappedSuperclass()
	 * @generated
	 */
	void setMappedSuperclass(boolean value);

	/**
	 * Returns the value of the '<em><b>Persistence Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistence Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistence Info</em>' containment reference.
	 * @see #setPersistenceInfo(LEntityPersistenceInfo)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_PersistenceInfo()
	 * @model containment="true"
	 * @generated
	 */
	LEntityPersistenceInfo getPersistenceInfo();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntity#getPersistenceInfo <em>Persistence Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistence Info</em>' containment reference.
	 * @see #getPersistenceInfo()
	 * @generated
	 */
	void setPersistenceInfo(LEntityPersistenceInfo value);

	/**
	 * Returns the value of the '<em><b>Inheritance Strategy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inheritance Strategy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inheritance Strategy</em>' containment reference.
	 * @see #setInheritanceStrategy(LEntityInheritanceStrategy)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_InheritanceStrategy()
	 * @model containment="true"
	 * @generated
	 */
	LEntityInheritanceStrategy getInheritanceStrategy();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntity#getInheritanceStrategy <em>Inheritance Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inheritance Strategy</em>' containment reference.
	 * @see #getInheritanceStrategy()
	 * @generated
	 */
	void setInheritanceStrategy(LEntityInheritanceStrategy value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.semantic.entity.LEntityFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<LEntityFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link org.lunifera.dsl.semantic.entity.LIndex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexes</em>' containment reference list.
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_Indexes()
	 * @model containment="true"
	 * @generated
	 */
	EList<LIndex> getIndexes();

	/**
	 * Returns the value of the '<em><b>Super Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.entity.LEntity#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Type</em>' reference.
	 * @see #setSuperType(LEntity)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_SuperType()
	 * @see org.lunifera.dsl.semantic.entity.LEntity#getSubTypes
	 * @model opposite="subTypes"
	 * @generated
	 */
	LEntity getSuperType();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntity#getSuperType <em>Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Type</em>' reference.
	 * @see #getSuperType()
	 * @generated
	 */
	void setSuperType(LEntity value);

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
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_SuperTypeJvm()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	JvmTypeReference getSuperTypeJvm();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntity#getSuperTypeJvm <em>Super Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Type Jvm</em>' containment reference.
	 * @see #getSuperTypeJvm()
	 * @generated
	 */
	void setSuperTypeJvm(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Sub Types</b></em>' reference list.
	 * The list contents are of type {@link org.lunifera.dsl.semantic.entity.LEntity}.
	 * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.entity.LEntity#getSuperType <em>Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Types</em>' reference list.
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntity_SubTypes()
	 * @see org.lunifera.dsl.semantic.entity.LEntity#getSuperType
	 * @model opposite="superType"
	 * @generated
	 */
	EList<LEntity> getSubTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns all features of type LOperation
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.OperationsList" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.entity.LEntityFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LOperation%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LOperation%>>filter(_features, <%org.lunifera.dsl.semantic.entity.LOperation%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LOperation%>>toList(_filter);'"
	 * @generated
	 */
	List<LOperation> getOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns all features of type LEntityReference
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.EntityReferenceList" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.entity.LEntityFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LEntityReference%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LEntityReference%>>filter(_features, <%org.lunifera.dsl.semantic.entity.LEntityReference%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LEntityReference%>>toList(_filter);'"
	 * @generated
	 */
	List<LEntityReference> getReferences();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns all features of type LEntityAttribute
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.EntityAttributeList" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.entity.LEntityFeature%>> _features = this.getFeatures();\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LEntityAttribute%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LEntityAttribute%>>filter(_features, <%org.lunifera.dsl.semantic.entity.LEntityAttribute%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LEntityAttribute%>>toList(_filter);'"
	 * @generated
	 */
	List<LEntityAttribute> getAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns all features of the holder and from super types
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.EntityFeatureList" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%java.util.List%><<%org.lunifera.dsl.semantic.entity.LEntityFeature%>> result = <%org.eclipse.xtext.xbase.lib.CollectionLiterals%>.<<%org.lunifera.dsl.semantic.entity.LEntityFeature%>>newArrayList();\nthis.collectAllLunFeatures(this, result);\nreturn result;'"
	 * @generated
	 */
	List<LEntityFeature> getAllFeatures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns all attributes of the holder and from super types
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.EntityAttributeList" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%java.util.List%><<%org.lunifera.dsl.semantic.entity.LEntityFeature%>> result = <%org.eclipse.xtext.xbase.lib.CollectionLiterals%>.<<%org.lunifera.dsl.semantic.entity.LEntityFeature%>>newArrayList();\nthis.collectAllLunFeatures(this, result);\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LEntityAttribute%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LEntityAttribute%>>filter(result, <%org.lunifera.dsl.semantic.entity.LEntityAttribute%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LEntityAttribute%>>toList(_filter);'"
	 * @generated
	 */
	List<LEntityAttribute> getAllAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns all references of the holder and from super types
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.lunifera.dsl.semantic.entity.EntityReferenceList" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%java.util.List%><<%org.lunifera.dsl.semantic.entity.LEntityFeature%>> result = <%org.eclipse.xtext.xbase.lib.CollectionLiterals%>.<<%org.lunifera.dsl.semantic.entity.LEntityFeature%>>newArrayList();\nthis.collectAllLunFeatures(this, result);\n<%java.lang.Iterable%><<%org.lunifera.dsl.semantic.entity.LEntityReference%>> _filter = <%com.google.common.collect.Iterables%>.<<%org.lunifera.dsl.semantic.entity.LEntityReference%>>filter(result, <%org.lunifera.dsl.semantic.entity.LEntityReference%>.class);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.lunifera.dsl.semantic.entity.LEntityReference%>>toList(_filter);'"
	 * @generated
	 */
	List<LEntityReference> getAllReferences();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model currentUnique="false" resultDataType="org.lunifera.dsl.semantic.entity.EntityFeatureList" resultUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(current, null);\nif (_equals)\n{\n\treturn;\n}\n<%org.eclipse.emf.common.util.EList%><<%org.lunifera.dsl.semantic.entity.LEntityFeature%>> _features = current.getFeatures();\nresult.addAll(_features);\n<%org.lunifera.dsl.semantic.entity.LEntity%> _superType = current.getSuperType();\nthis.collectAllLunFeatures(_superType, result);'"
	 * @generated
	 */
	void collectAllLunFeatures(LEntity current, List<LEntityFeature> result);

} // LEntity

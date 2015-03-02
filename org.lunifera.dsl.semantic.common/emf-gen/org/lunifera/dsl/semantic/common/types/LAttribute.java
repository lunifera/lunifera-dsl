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
package org.lunifera.dsl.semantic.common.types;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LAttribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isId <em>Id</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isUuid <em>Uuid</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isVersion <em>Version</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isLazy <em>Lazy</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isCascading <em>Cascading</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isDirty <em>Dirty</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isDomainKey <em>Domain Key</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#isDomainDescription <em>Domain Description</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#getDerivedGetterExpression <em>Derived Getter Expression</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#getType <em>Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAttribute#getTypeJvm <em>Type Jvm</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LAttribute extends LFeature {
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
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(boolean)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_Uuid()
	 * @model unique="false"
	 * @generated
	 */
	boolean isUuid();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #isUuid()
	 * @generated
	 */
	void setUuid(boolean value);

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
	 * Returns the value of the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' attribute.
	 * @see #setDerived(boolean)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_Derived()
	 * @model unique="false"
	 * @generated
	 */
	boolean isDerived();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isDerived <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived</em>' attribute.
	 * @see #isDerived()
	 * @generated
	 */
	void setDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dirty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dirty</em>' attribute.
	 * @see #setDirty(boolean)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_Dirty()
	 * @model unique="false"
	 * @generated
	 */
	boolean isDirty();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isDirty <em>Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dirty</em>' attribute.
	 * @see #isDirty()
	 * @generated
	 */
	void setDirty(boolean value);

	/**
	 * Returns the value of the '<em><b>Domain Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The domainKey is a human readable value for a dto or entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Key</em>' attribute.
	 * @see #setDomainKey(boolean)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_DomainKey()
	 * @model unique="false"
	 * @generated
	 */
	boolean isDomainKey();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isDomainKey <em>Domain Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Key</em>' attribute.
	 * @see #isDomainKey()
	 * @generated
	 */
	void setDomainKey(boolean value);

	/**
	 * Returns the value of the '<em><b>Domain Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The domainKey is the human readable description for a dto or entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Description</em>' attribute.
	 * @see #setDomainDescription(boolean)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_DomainDescription()
	 * @model unique="false"
	 * @generated
	 */
	boolean isDomainDescription();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isDomainDescription <em>Domain Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Description</em>' attribute.
	 * @see #isDomainDescription()
	 * @generated
	 */
	void setDomainDescription(boolean value);

	/**
	 * Returns the value of the '<em><b>Derived Getter Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Getter Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Getter Expression</em>' containment reference.
	 * @see #setDerivedGetterExpression(XExpression)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_DerivedGetterExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getDerivedGetterExpression();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#getDerivedGetterExpression <em>Derived Getter Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived Getter Expression</em>' containment reference.
	 * @see #getDerivedGetterExpression()
	 * @generated
	 */
	void setDerivedGetterExpression(XExpression value);

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

	/**
	 * Returns the value of the '<em><b>Type Jvm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Jvm</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Jvm</em>' containment reference.
	 * @see #setTypeJvm(JvmTypeReference)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAttribute_TypeJvm()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	JvmTypeReference getTypeJvm();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAttribute#getTypeJvm <em>Type Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Jvm</em>' containment reference.
	 * @see #getTypeJvm()
	 * @generated
	 */
	void setTypeJvm(JvmTypeReference value);

} // LAttribute

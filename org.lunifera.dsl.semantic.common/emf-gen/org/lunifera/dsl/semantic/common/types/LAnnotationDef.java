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

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LAnnotation Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAnnotationDef#isExclude <em>Exclude</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LAnnotationDef#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAnnotationDef()
 * @model
 * @generated
 */
public interface LAnnotationDef extends LLazyResolver {
	/**
	 * Returns the value of the '<em><b>Exclude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclude</em>' attribute.
	 * @see #setExclude(boolean)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAnnotationDef_Exclude()
	 * @model unique="false"
	 * @generated
	 */
	boolean isExclude();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAnnotationDef#isExclude <em>Exclude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exclude</em>' attribute.
	 * @see #isExclude()
	 * @generated
	 */
	void setExclude(boolean value);

	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' containment reference.
	 * @see #setAnnotation(XAnnotation)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLAnnotationDef_Annotation()
	 * @model containment="true"
	 * @generated
	 */
	XAnnotation getAnnotation();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LAnnotationDef#getAnnotation <em>Annotation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation</em>' containment reference.
	 * @see #getAnnotation()
	 * @generated
	 */
	void setAnnotation(XAnnotation value);

} // LAnnotationDef

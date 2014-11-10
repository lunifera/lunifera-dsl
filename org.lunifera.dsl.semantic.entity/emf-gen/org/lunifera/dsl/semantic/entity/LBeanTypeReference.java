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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LBean Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBeanTypeReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanTypeReference()
 * @model
 * @generated
 */
public interface LBeanTypeReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(LBean)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanTypeReference_Type()
	 * @model
	 * @generated
	 */
	LBean getType();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LBeanTypeReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(LBean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%org.lunifera.dsl.semantic.entity.LBean%> _type = this.getType();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_type, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%org.lunifera.dsl.semantic.entity.LBean%> _type_1 = this.getType();\n\tboolean _eIsProxy = _type_1.eIsProxy();\n\t_and = _eIsProxy;\n}\nif (_and)\n{\n\t<%org.lunifera.dsl.semantic.entity.LBean%> _type_2 = this.getType();\n\tfinal <%org.eclipse.emf.ecore.InternalEObject%> oldType = ((<%org.eclipse.emf.ecore.InternalEObject%>) _type_2);\n\t<%org.eclipse.emf.ecore.EObject%> _resolveLazy = <%org.lunifera.dsl.lazyreferences.EcoreUtil3%>.resolveLazy(oldType, this);\n\tthis.setType(((<%org.lunifera.dsl.semantic.entity.LBean%>) _resolveLazy));\n}\nreturn this.getType();'"
	 * @generated
	 */
	LBean getLazyResolved();

} // LBeanTypeReference

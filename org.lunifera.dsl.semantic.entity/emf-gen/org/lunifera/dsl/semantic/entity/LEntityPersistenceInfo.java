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

import org.lunifera.dsl.semantic.common.types.LLazyResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LEntity Persistence Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo#getSchemaName <em>Schema Name</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo#getTableName <em>Table Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntityPersistenceInfo()
 * @model
 * @generated
 */
public interface LEntityPersistenceInfo extends LLazyResolver {
	/**
	 * Returns the value of the '<em><b>Schema Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Name</em>' attribute.
	 * @see #setSchemaName(String)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntityPersistenceInfo_SchemaName()
	 * @model unique="false"
	 * @generated
	 */
	String getSchemaName();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo#getSchemaName <em>Schema Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Name</em>' attribute.
	 * @see #getSchemaName()
	 * @generated
	 */
	void setSchemaName(String value);

	/**
	 * Returns the value of the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Name</em>' attribute.
	 * @see #setTableName(String)
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLEntityPersistenceInfo_TableName()
	 * @model unique="false"
	 * @generated
	 */
	String getTableName();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo#getTableName <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Name</em>' attribute.
	 * @see #getTableName()
	 * @generated
	 */
	void setTableName(String value);

} // LEntityPersistenceInfo

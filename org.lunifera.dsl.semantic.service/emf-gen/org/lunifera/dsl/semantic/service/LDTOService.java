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
package org.lunifera.dsl.semantic.service;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

import org.lunifera.dsl.semantic.dto.LDto;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDTO Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getDto <em>Dto</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getDtoJvm <em>Dto Jvm</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getPersistenceId <em>Persistence Id</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getFilterable <em>Filterable</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getSortable <em>Sortable</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getGetExpression <em>Get Expression</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getFindExpression <em>Find Expression</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getFindExpressionWithDelimiter <em>Find Expression With Delimiter</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getUpdateExpression <em>Update Expression</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.service.LDTOService#getDeleteExpression <em>Delete Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService()
 * @model
 * @generated
 */
public interface LDTOService extends LService {
	/**
	 * Returns the value of the '<em><b>Dto</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dto</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dto</em>' reference.
	 * @see #setDto(LDto)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_Dto()
	 * @model
	 * @generated
	 */
	LDto getDto();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getDto <em>Dto</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dto</em>' reference.
	 * @see #getDto()
	 * @generated
	 */
	void setDto(LDto value);

	/**
	 * Returns the value of the '<em><b>Dto Jvm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dto Jvm</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dto Jvm</em>' containment reference.
	 * @see #setDtoJvm(JvmTypeReference)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_DtoJvm()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getDtoJvm();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getDtoJvm <em>Dto Jvm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dto Jvm</em>' containment reference.
	 * @see #getDtoJvm()
	 * @generated
	 */
	void setDtoJvm(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Persistence Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistence Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistence Id</em>' attribute.
	 * @see #setPersistenceId(String)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_PersistenceId()
	 * @model unique="false"
	 * @generated
	 */
	String getPersistenceId();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getPersistenceId <em>Persistence Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistence Id</em>' attribute.
	 * @see #getPersistenceId()
	 * @generated
	 */
	void setPersistenceId(String value);

	/**
	 * Returns the value of the '<em><b>Filterable</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.service.LFilterableAttributes#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filterable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filterable</em>' containment reference.
	 * @see #setFilterable(LFilterableAttributes)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_Filterable()
	 * @see org.lunifera.dsl.semantic.service.LFilterableAttributes#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	LFilterableAttributes getFilterable();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getFilterable <em>Filterable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filterable</em>' containment reference.
	 * @see #getFilterable()
	 * @generated
	 */
	void setFilterable(LFilterableAttributes value);

	/**
	 * Returns the value of the '<em><b>Sortable</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.lunifera.dsl.semantic.service.LSortableAttributes#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sortable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sortable</em>' containment reference.
	 * @see #setSortable(LSortableAttributes)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_Sortable()
	 * @see org.lunifera.dsl.semantic.service.LSortableAttributes#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	LSortableAttributes getSortable();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getSortable <em>Sortable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sortable</em>' containment reference.
	 * @see #getSortable()
	 * @generated
	 */
	void setSortable(LSortableAttributes value);

	/**
	 * Returns the value of the '<em><b>Get Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Expression</em>' containment reference.
	 * @see #setGetExpression(XExpression)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_GetExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getGetExpression();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getGetExpression <em>Get Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get Expression</em>' containment reference.
	 * @see #getGetExpression()
	 * @generated
	 */
	void setGetExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Find Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Find Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Find Expression</em>' containment reference.
	 * @see #setFindExpression(XExpression)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_FindExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getFindExpression();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getFindExpression <em>Find Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Find Expression</em>' containment reference.
	 * @see #getFindExpression()
	 * @generated
	 */
	void setFindExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Find Expression With Delimiter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Find Expression With Delimiter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Find Expression With Delimiter</em>' containment reference.
	 * @see #setFindExpressionWithDelimiter(XExpression)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_FindExpressionWithDelimiter()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getFindExpressionWithDelimiter();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getFindExpressionWithDelimiter <em>Find Expression With Delimiter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Find Expression With Delimiter</em>' containment reference.
	 * @see #getFindExpressionWithDelimiter()
	 * @generated
	 */
	void setFindExpressionWithDelimiter(XExpression value);

	/**
	 * Returns the value of the '<em><b>Update Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update Expression</em>' containment reference.
	 * @see #setUpdateExpression(XExpression)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_UpdateExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getUpdateExpression();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getUpdateExpression <em>Update Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update Expression</em>' containment reference.
	 * @see #getUpdateExpression()
	 * @generated
	 */
	void setUpdateExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Delete Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete Expression</em>' containment reference.
	 * @see #setDeleteExpression(XExpression)
	 * @see org.lunifera.dsl.semantic.service.LunServicePackage#getLDTOService_DeleteExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getDeleteExpression();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.service.LDTOService#getDeleteExpression <em>Delete Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delete Expression</em>' containment reference.
	 * @see #getDeleteExpression()
	 * @generated
	 */
	void setDeleteExpression(XExpression value);

} // LDTOService

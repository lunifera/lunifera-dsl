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
	 * @model containment="true" transient="true"
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

} // LDTOService

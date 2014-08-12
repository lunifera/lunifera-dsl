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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LOperation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Overwrites LOperation to add bean and entity feature as supertype
 * <!-- end-model-doc -->
 *
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLOperation()
 * @model
 * @generated
 */
public interface LOperation extends org.lunifera.dsl.semantic.common.types.LOperation, LBeanFeature, LEntityFeature {
} // LOperation

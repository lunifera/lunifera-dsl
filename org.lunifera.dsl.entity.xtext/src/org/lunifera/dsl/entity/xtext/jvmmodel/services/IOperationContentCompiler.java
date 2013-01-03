/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.jvmmodel.services;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.lunifera.dsl.entity.semantic.model.LCompilerType;
import org.lunifera.dsl.entity.semantic.model.LContainer;
import org.lunifera.dsl.entity.semantic.model.LContains;
import org.lunifera.dsl.entity.semantic.model.LEntity;
import org.lunifera.dsl.entity.semantic.model.LGenSettings;
import org.lunifera.dsl.entity.semantic.model.LProperty;
import org.lunifera.dsl.entity.semantic.model.LReference;
import org.lunifera.dsl.entity.semantic.model.LRefers;

/**
 * Implementations of that interface have to provide implementations and
 * documentations for the different kind of entity methods.
 */
public interface IOperationContentCompiler {
	
	/**
	 * Is responsible to decide whether the compiler should be used
	 * 
	 * @param compilerType
	 * @return
	 */
	boolean isResponsible(LCompilerType compilerType);

	/**
	 * The documentation for
	 * {@link #get_toOne_Property_OperationContent(LProperty, String, LGenSettings)}
	 * 
	 * @param property
	 * @param fieldName
	 * @param setting
	 * @return
	 */
	CharSequence get_toOne_Property_Documentantion(LProperty property,
			String fieldName, LGenSettings setting);

	/**
	 * The getter for properties with an upper bound of 1.
	 * 
	 * @param property
	 * @param fieldName
	 * @param setting
	 * @return
	 */
	CharSequence get_toOne_Property_OperationContent(LProperty property,
			String fieldName, LGenSettings setting);

	/**
	 * The documentation for
	 * {@link #get_toOne_Reference_OperationContent(LReference, String, String, LGenSettings)}
	 * 
	 * @param ref
	 * @param fieldName
	 * @param setting
	 * @return
	 */
	CharSequence get_toOne_Reference_Documentantion(LReference ref,
			String fieldName, LGenSettings setting);

	/**
	 * The getter for references with an upper bound of 1.
	 * 
	 * @param ref
	 * @param fieldName
	 * @param setting
	 * @return
	 */
	CharSequence get_toOne_Reference_OperationContent(LReference ref,
			String fieldName, LGenSettings setting);
	
	/**
	 * The documentation for
	 * {@link #set_toOne_Property_OperationContent(LProperty, String, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param property
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence set_toOne_Property_Documentantion(LProperty property,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The setter for properties with an upper bound of 1.
	 * 
	 * @param property
	 * @param localVarName
	 * @param fieldName
	 * @param setting
	 * @return
	 */
	CharSequence set_toOne_Property_OperationContent(LProperty property,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The documentation for
	 * {@link #set_toOne_Reference_OperationContent(LReference, String, String, JvmTypeReference, LGenSettings)
	 * , String, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence set_toOne_Refers_Documentantion(LRefers ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The setter for refers references with upper bound 1.
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence set_toOne_Refers_OperationContent(LRefers ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The documentation for
	 * {@link #set_toOne_Container_OperationContent(LContainer, String, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence set_toOne_Container_Documentantion(LContainer ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The setter for container references with upper bound 1.
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence set_toOne_Container_OperationContent(LContainer ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);
	
	/**
	 * The documentation for
	 * {@link #set_toOne_Containment_OperationContent(LContains, String, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence set_toOne_Containment_Documentantion(LContains ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The setter for containment references with upper bound 1.
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence set_toOne_Containment_OperationContent(LContains ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The documentation for
	 * {@link #get_toMany_Reference_OperationContent(LReference, String, JvmTypeReference, LGenSettings)}
	 * <br>
	 * Attention: The given reference can be of type {@link LRefers} or
	 * {@link LContains}.
	 * 
	 * @param ref
	 * @param fieldName
	 * @param setting
	 * @return
	 */
	CharSequence get_toMany_Reference_Documentantion(LReference ref,
			String fieldName, LGenSettings setting);

	/**
	 * The getter for references with upper bound of *.<br>
	 * Attention: The given reference can be of type {@link LRefers} or
	 * {@link LContains}.
	 * 
	 * @param ref
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence get_toMany_Reference_OperationContent(LReference ref,
			String fieldName, JvmTypeReference typeRef, LGenSettings setting);

	/**
	 * The documentation for
	 * {@link #get_toMany_Property_OperationContent(LProperty, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param prop
	 * @param fieldName
	 * @param setting
	 * @return
	 */
	CharSequence get_toMany_Property_Documentantion(LProperty prop,
			String fieldName, LGenSettings setting);

	/**
	 * The getter for properties with upper bound of *.<br>
	 * 
	 * @param prop
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence get_toMany_Property_OperationContent(LProperty prop,
			String fieldName, JvmTypeReference typeRef, LGenSettings setting);

	/**
	 * The documentation for
	 * {@link #add_toMany_Refers_OperationContent(LReference, String, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence add_toMany_Refers_Documentantion(LRefers ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The add method for refers references with upper bound of *.
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence add_toMany_Refers_OperationContent(LRefers ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The documentation for
	 * {@link #add_toMany_Property_OperationContent(LProperty, String, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param prop
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence add_toMany_Property_Documentantion(LProperty prop,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The add method for properties with upper bound of *.
	 * 
	 * @param prop
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence add_toMany_Property_OperationContent(LProperty prop,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The documentation of
	 * {@link #remove_toMany_Reference_OperationContent(LReference, String, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence remove_toMany_Refers_Documentantion(LRefers ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The remove method of refers references with upper bound of *.
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence remove_toMany_Refers_OperationContent(LRefers ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The documentation of
	 * {@link #remove_toMany_Property_OperationContent(LReference, String, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param prop
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence remove_toMany_Property_Documentantion(LProperty prop,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The remove method of refers references with upper bound of *.
	 * 
	 * @param prop
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence remove_toMany_Property_OperationContent(LProperty prop,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The documentation of
	 * {@link #add_toMany_Containmant_OperationContent(LContains, String, String, JvmTypeReference, LGenSettings)}
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence add_toMany_Containmant_Documentantion(LContains ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The add method of containment references with upper bound of *.
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence add_toMany_Containmant_OperationContent(LContains ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The documentation of
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence remove_toMany_Containmant_Documentantion(LContains ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The remove method of containment references with upper bound of *.
	 * 
	 * @param ref
	 * @param localVarName
	 * @param fieldName
	 * @param typeRef
	 * @param setting
	 * @return
	 */
	CharSequence remove_toMany_Containmant_OperationContent(LContains ref,
			String localVarName, String fieldName, JvmTypeReference typeRef,
			LGenSettings setting);

	/**
	 * The documentation of {@link #isDisposed_OperationContent()}
	 * 
	 * @param lEntity
	 * @return
	 */
	CharSequence isDisposed_Documentantion(LEntity lEntity);

	/**
	 * The content of the isDisposed method.
	 * 
	 * @param lEntity
	 * @return
	 */
	CharSequence isDisposed_OperationContent(LEntity lEntity);

	/**
	 * The documentation of {@link #checkDisposed_OperationContent()}
	 * 
	 * @param lEntity
	 * @return
	 */
	CharSequence checkDisposed_Documentantion(LEntity lEntity);

	/**
	 * The content of the checkDisposed() method
	 * 
	 * @param lEntity
	 * @return
	 */
	CharSequence checkDisposed_OperationContent(LEntity lEntity);

	/**
	 * The documentation of {@link #dispose_OperationContent(LEntity)}
	 * 
	 * @param lEntity
	 * @return
	 */
	CharSequence dispose_Documentantion(LEntity lEntity);

	/**
	 * The content of the dispose method.
	 * 
	 * @param entity
	 * @return
	 */
	CharSequence dispose_OperationContent(LEntity entity);
}

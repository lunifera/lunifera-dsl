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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LMultiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getLower <em>Lower</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getToMultiplicityString <em>To Multiplicity String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLMultiplicity()
 * @model
 * @generated
 */
public interface LMultiplicity extends EObject {
	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * The literals are from the enumeration {@link org.lunifera.dsl.semantic.common.types.LLowerBound}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see org.lunifera.dsl.semantic.common.types.LLowerBound
	 * @see #setLower(LLowerBound)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLMultiplicity_Lower()
	 * @model unique="false"
	 * @generated
	 */
	LLowerBound getLower();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see org.lunifera.dsl.semantic.common.types.LLowerBound
	 * @see #getLower()
	 * @generated
	 */
	void setLower(LLowerBound value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * The literals are from the enumeration {@link org.lunifera.dsl.semantic.common.types.LUpperBound}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see org.lunifera.dsl.semantic.common.types.LUpperBound
	 * @see #setUpper(LUpperBound)
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLMultiplicity_Upper()
	 * @model unique="false"
	 * @generated
	 */
	LUpperBound getUpper();

	/**
	 * Sets the value of the '{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see org.lunifera.dsl.semantic.common.types.LUpperBound
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(LUpperBound value);

	/**
	 * Returns the value of the '<em><b>To Multiplicity String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Multiplicity String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Multiplicity String</em>' attribute.
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#getLMultiplicity_ToMultiplicityString()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.lang.StringBuilder%> result = new <%java.lang.StringBuilder%>();\n<%org.lunifera.dsl.semantic.common.types.LLowerBound%> _lower = this.getLower();\nif (_lower != null)\n{\n\tswitch (_lower)\n\t{\n\t\tcase NULL:\n\t\t\tresult.append(\"0\");\n\t\t\tbreak;\n\t\tcase MANY:\n\t\t\tresult.append(\"1\");\n\t\t\tbreak;\n\t\tcase OPTIONAL:\n\t\t\tresult.append(\"0\");\n\t\t\tbreak;\n\t\tcase ATLEASTONE:\n\t\t\tresult.append(\"1\");\n\t\t\tbreak;\n\t\tcase ZERO:\n\t\t\tresult.append(\"0\");\n\t\t\tbreak;\n\t\tcase ONE:\n\t\t\tresult.append(\"1\");\n\t\t\tbreak;\n\t\tdefault:\n\t\t\tresult.append(\"undefined\");\n\t\t\tbreak;\n\t}\n}\nelse\n{\n\tresult.append(\"undefined\");\n}\nresult.append(\"..\");\n<%org.lunifera.dsl.semantic.common.types.LUpperBound%> _upper = this.getUpper();\nif (_upper != null)\n{\n\tswitch (_upper)\n\t{\n\t\tcase NULL:\n\t\t\tresult.append(\"0\");\n\t\t\tbreak;\n\t\tcase MANY:\n\t\t\tresult.append(\"*\");\n\t\t\tbreak;\n\t\tcase ONE:\n\t\t\tresult.append(\"1\");\n\t\t\tbreak;\n\t\tdefault:\n\t\t\tresult.append(\"undefined\");\n\t\t\tbreak;\n\t}\n}\nelse\n{\n\tresult.append(\"undefined\");\n}\nreturn result.toString();'"
	 * @generated
	 */
	String getToMultiplicityString();

} // LMultiplicity

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

import org.lunifera.dsl.semantic.common.types.LAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LBean Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LBeanAttribute#getTypedName <em>Typed Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanAttribute()
 * @model
 * @generated
 */
public interface LBeanAttribute extends LBeanFeature, LAttribute {
	/**
	 * Returns the value of the '<em><b>Typed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Name</em>' attribute.
	 * @see org.lunifera.dsl.semantic.entity.LunEntityPackage#getLBeanAttribute_TypedName()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.lang.StringBuilder%> result = new <%java.lang.StringBuilder%>();\n<%java.lang.String%> _name = this.getName();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_name, null));\nif (_notEquals)\n{\n\t<%java.lang.String%> _name_1 = this.getName();\n\tresult.append(_name_1);\n}\nelse\n{\n\tresult.append(\"empty\");\n}\nresult.append(\" : \");\n<%org.lunifera.dsl.semantic.common.types.LScalarType%> _type = this.getType();\nboolean _notEquals_1 = (!<%com.google.common.base.Objects%>.equal(_type, null));\nif (_notEquals_1)\n{\n\t<%org.lunifera.dsl.semantic.common.types.LScalarType%> _type_1 = this.getType();\n\t<%java.lang.String%> _name_2 = _type_1.getName();\n\tresult.append(_name_2);\n}\nelse\n{\n\tresult.append(\"undefined\");\n}\nreturn result.toString();'"
	 * @generated
	 */
	String getTypedName();

} // LBeanAttribute

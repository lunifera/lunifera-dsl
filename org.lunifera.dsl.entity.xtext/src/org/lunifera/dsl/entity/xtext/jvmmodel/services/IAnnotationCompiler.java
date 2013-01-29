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

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.lunifera.dsl.entity.semantic.model.LClass;
import org.lunifera.dsl.entity.semantic.model.LGenSettings;
import org.lunifera.dsl.entity.semantic.model.LOperation;
import org.lunifera.dsl.entity.semantic.model.LProperty;

/**
 * Implementations of that interface have to provide annotations.
 */
public interface IAnnotationCompiler {

	/**
	 * This method can be used to add annotations to the given jvmType.
	 */
	void processAnnotation(LClass lClass, JvmGenericType jvmType, LGenSettings setting);

	/**
	 * This method can be used to add annotations to the given jvmField.
	 */
	void processAnnotation(LProperty member, JvmField jvmField, LGenSettings setting);
	
	/**
	 * This method can be used to add annotations to the given jvmField.
	 */
	void processAnnotation(LOperation member, JvmOperation jvmOperation, LGenSettings setting);

}

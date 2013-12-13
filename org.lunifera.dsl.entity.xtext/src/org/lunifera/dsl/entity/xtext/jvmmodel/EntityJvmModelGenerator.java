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
package org.lunifera.dsl.entity.xtext.jvmmodel;

import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.semantic.entity.LEntityModel;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class EntityJvmModelGenerator extends JvmModelGenerator {

	@Inject
	private IJvmModelAssociations associations;
	@Inject ModelExtensions extensions;

	/**
	 * Returns true, if no source should be generated.
	 * 
	 * @param lmodel
	 * @return
	 */
	private boolean isNoSource(LEntityModel lmodel) {
		return false;
	}
}

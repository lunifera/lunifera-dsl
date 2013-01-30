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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.lunifera.dsl.entity.semantic.model.LClass;
import org.lunifera.dsl.entity.semantic.model.LEntityModel;
import org.lunifera.dsl.entity.semantic.model.LEnum;
import org.lunifera.dsl.entity.xtext.util.Util;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class EntityJvmModelGenerator extends JvmModelGenerator {

	@Inject
	private IJvmModelAssociations associations;

	public void internalDoGenerate(final EObject type, final IFileSystemAccess fsa) {
		if (type instanceof JvmEnumerationType) {
			LEnum lenum = (LEnum) associations.getPrimarySourceElement(type);
			LEntityModel lmodel = (LEntityModel) Util.toPackageS(lenum).eContainer();
			if (isNoSource(lmodel)) {
				return;
			}
		} else if (type instanceof JvmGenericType) {
			LClass lClass = (LClass) associations.getPrimarySourceElement(type);
			LEntityModel lmodel = (LEntityModel) Util.toPackageS(lClass).eContainer();
			if (isNoSource(lmodel)) {
				return;
			}
		}

		super.internalDoGenerate(type, fsa);
	}

	/**
	 * Returns true, if no source should be generated.
	 * 
	 * @param lmodel
	 * @return
	 */
	private boolean isNoSource(LEntityModel lmodel) {
		return lmodel.getGenSettings() != null
				&& lmodel.getGenSettings().isNoSource();
	}
}

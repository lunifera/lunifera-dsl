/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Hans Georg Glöckler - Initial implementation
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.valueconverter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;
import org.lunifera.dsl.entity.semantic.model.LAnnotationDef;
import org.lunifera.dsl.entity.semantic.model.LClass;
import org.lunifera.dsl.entity.semantic.model.LCompilerType;
import org.lunifera.dsl.entity.semantic.model.LEnum;
import org.lunifera.dsl.entity.semantic.model.LPackage;
import org.lunifera.dsl.entity.xtext.util.Util;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class EntityQualifiedNameProvider extends XbaseQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj == null) {
			return QualifiedName.create("");
		}

		if (obj instanceof LClass) {
			LPackage pkg = Util.toPackageS((LClass) obj);
			if (pkg != null) {
				final String qualifiedName = String.format("%s.%s",
						pkg.getName(), ((LClass) obj).getName());
				if (qualifiedName == null)
					return null;
				return qualifiedNameConverter.toQualifiedName(qualifiedName);
			} else {
				return QualifiedName.create("");
			}
		} else if (obj instanceof LEnum) {
			LPackage pkg = Util.toPackageS((LEnum) obj);
			if (pkg != null) {
				final String qualifiedName = String.format("%s.%s",
						pkg.getName(), ((LEnum) obj).getName());
				if (qualifiedName == null)
					return null;
				return qualifiedNameConverter.toQualifiedName(qualifiedName);
			} else {
				return QualifiedName.create("");
			}
		} else if (obj instanceof LCompilerType) {
			LPackage pkg = (LPackage) ((LCompilerType) obj).eContainer();
			if (pkg != null) {
				final String qualifiedName = String.format("%s.%s",
						pkg.getName(), ((LCompilerType) obj).getName());
				if (qualifiedName == null)
					return null;
				return qualifiedNameConverter.toQualifiedName(qualifiedName);
			} else {
				return QualifiedName.create("");
			}
		} else if (obj instanceof LAnnotationDef) {
			return super.getFullyQualifiedName(((LAnnotationDef) obj)
					.getAnnotation());
		}
		return super.getFullyQualifiedName(obj);
	}
}

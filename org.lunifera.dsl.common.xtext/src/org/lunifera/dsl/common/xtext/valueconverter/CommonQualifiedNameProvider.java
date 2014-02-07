/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.common.xtext.valueconverter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;
import org.lunifera.dsl.common.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.semantic.common.types.LAnnotationDef;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LEnum;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LPackage;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class CommonQualifiedNameProvider extends XbaseQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private ModelExtensions extensions;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj == null) {
			return QualifiedName.create("");
		}

		if (obj instanceof LClass) {
			LPackage pkg = extensions.getPackage((LClass) obj);
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
			LPackage pkg = extensions.getPackage((LEnum) obj);
			if (pkg != null) {
				final String qualifiedName = String.format("%s.%s",
						pkg.getName(), ((LEnum) obj).getName());
				if (qualifiedName == null)
					return null;
				return qualifiedNameConverter.toQualifiedName(qualifiedName);
			} else {
				return QualifiedName.create("");
			}
		} else if (obj instanceof LFeature) {
			LFeature prop = (LFeature) obj;
			String name = prop.getName();
			return name != null ? qualifiedNameConverter.toQualifiedName(name)
					: null;
		} else if (obj instanceof LDataType) {
			LPackage pkg = extensions.getPackage((LDataType) obj);
			if (pkg != null) {
				final String qualifiedName = String.format("%s.%s",
						pkg.getName(), ((LDataType) obj).getName());
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

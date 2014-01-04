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
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions;
import org.lunifera.dsl.entity.xtext.extensions.NamingExtensions;
import org.lunifera.dsl.semantic.common.types.LAnnotationDef;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LEnum;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LPackage;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo;
import org.lunifera.dsl.semantic.entity.LEntityFeature;
import org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class EntityQualifiedNameProvider extends XbaseQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private ModelExtensions extensions;
	@Inject
	private NamingExtensions naming;

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
			return prop.getName() != null ? qualifiedNameConverter
					.toQualifiedName(prop.getName()) : null;
		} else if (obj instanceof LDataType) {
			LDataType dtd = (LDataType) obj;
			if(dtd.getName() == null){
				return QualifiedName.create();
			}
			return qualifiedNameConverter.toQualifiedName(dtd.getName());
		} else if (obj instanceof LAnnotationDef) {
			return super.getFullyQualifiedName(((LAnnotationDef) obj)
					.getAnnotation());
		} else if (obj instanceof LEntityPersistenceInfo) {
			LEntityPersistenceInfo info = (LEntityPersistenceInfo) obj;
			LEntity entity = (LEntity) info.eContainer();
			String schemaName = naming
					.toSchemaName(entity.getPersistenceInfo());
			if (schemaName == null || schemaName.equals("")) {
				schemaName = "DEFAULT";
			}
			String tableName = naming.toTableName(entity);
			return QualifiedName.create(schemaName, tableName);
		} else if (obj instanceof LEntityColumnPersistenceInfo) {
			LEntityColumnPersistenceInfo info = (LEntityColumnPersistenceInfo) obj;
			LEntityFeature feature = (LEntityFeature) info.eContainer();
			LEntity entity = feature.getEntity();
			QualifiedName parentFQN = getFullyQualifiedName(entity
					.getPersistenceInfo());
			String columnName = naming.toColumnName(feature);
			return parentFQN.append(columnName);
		}
		return super.getFullyQualifiedName(obj);
	}
}

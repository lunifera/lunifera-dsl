/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.lunifera.dsl.entity.xtext.typesystem;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareBatchTypeResolver;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.entity.LEntityModel;

import com.google.common.collect.Lists;

@NonNullByDefault
public class TypeDeclarationAwareBatchTypeResolver extends
		LogicalContainerAwareBatchTypeResolver {

	@Override
	protected List<EObject> getEntryPoints(EObject object) {
		List<EObject> result = super.getEntryPoints(object);
//		EObject rootContainer = EcoreUtil.getRootContainer(object);
//		if (rootContainer instanceof LEntityModel) {
//			List<EObject> resultIncludingXtendTypes = Lists
//					.newArrayList(result);
//			for (LTypedPackage pkg : ((LEntityModel) rootContainer)
//					.getPackages()) {
//				resultIncludingXtendTypes.addAll(pkg.getTypes());
//			}
//			return resultIncludingXtendTypes;
//		}
		return result;
	}
}

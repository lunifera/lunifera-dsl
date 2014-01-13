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
package org.lunifera.dsl.entity.xtext.scope;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.lunifera.dsl.common.xtext.scope.CommonScopeProvider;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.entity.EntityPackage;
import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityReference;

import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
@SuppressWarnings("restriction")
public class EntityScopeProvider extends CommonScopeProvider {
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public IScope getScope(final EObject context, EReference reference) {
		if (reference == EntityPackage.Literals.LENTITY_REFERENCE__OPPOSITE) {
			return getScope_LFeature_Opposite((LEntityReference) context);
		} else if (reference == EntityPackage.Literals.LBEAN_REFERENCE__OPPOSITE) {
			return getScope_LFeature_Opposite((LBeanReference) context);
		}
		return super.getScope(context, reference);
	}

	private IScope getScope_LFeature_Opposite(final LEntityReference prop) {
		return new AbstractScope(IScope.NULLSCOPE, false) {
			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
				if (prop.getType() != null) {
					LEntity propClass = prop.getEntity();
					LEntity type = prop.getType();
					for (LEntityReference oppositeProp : type.getReferences()) {
						if (oppositeProp.getType() == propClass) {
							String name = oppositeProp.getName();
							if (name != null) {
								result.add(new EObjectDescription(
										qualifiedNameConverter
												.toQualifiedName(name),
										oppositeProp, null));
							}
						}
					}
				}
				return result;
			}
		};
	}

	private IScope getScope_LFeature_Opposite(final LBeanReference prop) {
		return new AbstractScope(IScope.NULLSCOPE, false) {
			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
				if (prop.getType() != null && prop.getType() instanceof LClass) {
					LBean propClass = prop.getBean();
					LBean type = prop.getType();
					for (LBeanReference oppositeProp : type.getReferences()) {
						if (oppositeProp.getType() == propClass) {
							String name = oppositeProp.getName();
							if (name != null) {
								result.add(new EObjectDescription(
										qualifiedNameConverter
												.toQualifiedName(name),
										oppositeProp, null));
							}
						}
					}
				}
				return result;
			}
		};
	}
}

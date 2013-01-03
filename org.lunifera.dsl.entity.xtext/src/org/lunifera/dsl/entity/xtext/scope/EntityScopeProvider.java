/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Sources partially based on org.eclipse.emf.ecore.xcore.scoping.XcoreScopeProvider
 * 
 * Contributors:
 * 		Hans Georg Glöckler - Initial implementation
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
import org.eclipse.xtext.xbase.annotations.scoping.XbaseWithAnnotationsScopeProvider;
import org.lunifera.dsl.entity.semantic.model.EntityPackage;
import org.lunifera.dsl.entity.semantic.model.LContainer;
import org.lunifera.dsl.entity.semantic.model.LContains;
import org.lunifera.dsl.entity.semantic.model.LEntity;
import org.lunifera.dsl.entity.semantic.model.LEntityMember;
import org.lunifera.dsl.entity.semantic.model.LRefers;
import org.lunifera.dsl.entity.xtext.extensions.ModelExtensions;

import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
@SuppressWarnings("restriction")
public class EntityScopeProvider extends XbaseWithAnnotationsScopeProvider {
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private ModelExtensions modelExtensions;

	@Override
	public IScope getScope(final EObject context, EReference reference) {
		if (reference == EntityPackage.Literals.LCONTAINS__OPPOSITE) {
			return getScope_LContains_Opposite((LContains) context);
		} else if (reference == EntityPackage.Literals.LCONTAINER__OPPOSITE) {
			return getScope_LContainer_Opposite((LContainer) context);
		} else if (reference == EntityPackage.Literals.LREFERS__OPPOSITE) {
			return getScope_LReference_Opposite((LRefers) context);
		} else {
			return super.getScope(context, reference);
		}
	}

	/**
	 * Returns the scope for the opposite reference of LReference
	 * 
	 * @param a_refers
	 * @return
	 */
	private IScope getScope_LReference_Opposite(final LRefers a_refers) {
		return new AbstractScope(IScope.NULLSCOPE, false) {
			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
				LEntity a_type = a_refers.getType();
				if (a_type != null) {
					LEntity a_containingRefersType = (LEntity) a_refers
							.eContainer();
					// iterate all memeber in the opposite type
					for (LEntityMember member : a_type.getEntityMembers()) {
						if (member instanceof LRefers) {
							LRefers x_otherRefers = (LRefers) member;
							LEntity x_otherRefersType = x_otherRefers.getType();
							// test if the name of the
							// a_refers-eContainer (==
							// LEntity)
							// matches the name of the
							// x_otherRefers-type from the
							// iterated members
							if (modelExtensions.nameEquals(x_otherRefersType,
									a_containingRefersType)) {
								String name = x_otherRefers.getName();
								if (name != null) {
									result.add(new EObjectDescription(
											qualifiedNameConverter
													.toQualifiedName(name),
											member, null));
								}
							}
						}
					}
				}
				return result;
			}
		};
	}

	/**
	 * Returns the scope for the opposite reference of LContainer
	 * 
	 * @param a_container
	 * @return
	 */
	private IScope getScope_LContainer_Opposite(final LContainer a_container) {
		return new AbstractScope(IScope.NULLSCOPE, false) {
			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
				LEntity a_type = a_container.getType();
				if (a_type != null) {
					LEntity a_containingContainerType = (LEntity) a_container
							.eContainer();
					// iterate all memeber in the opposite type
					for (LEntityMember member : a_type.getEntityMembers()) {
						if (member instanceof LContains) {
							LContains x_contains = (LContains) member;
							LEntity x_containsType = x_contains.getType();
							// test if the name of the
							// a_container-eContainer (==
							// LEntity)
							// matches the name of the
							// x_contains-type from the
							// iterated members
							if (modelExtensions.nameEquals(x_containsType,
									a_containingContainerType)) {
								String name = x_contains.getName();
								if (name != null) {
									result.add(new EObjectDescription(
											qualifiedNameConverter
													.toQualifiedName(name),
											member, null));
								}
							}
						}
					}
				}
				return result;
			}
		};
	}

	/**
	 * Returns the scope for the opposite reference of LContains
	 * 
	 * @param containes
	 * @return
	 */
	private IScope getScope_LContains_Opposite(final LContains containes) {
		return new AbstractScope(IScope.NULLSCOPE, false) {
			@Override
			// springt zu EntityProposalProvider
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
				LEntity type = containes.getType();
				if (type != null) {
					for (LEntityMember opposite : type.getEntityMembers()) {
						if (opposite instanceof LContainer) {
							String name = ((LContainer) opposite).getName();
							if (name != null) {
								result.add(new EObjectDescription(
										qualifiedNameConverter
												.toQualifiedName(name),
										opposite, null));
							}
						}
					}
				}
				return result;
			}
		};
	}

}

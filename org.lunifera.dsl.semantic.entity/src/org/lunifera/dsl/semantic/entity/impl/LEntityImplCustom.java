/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.semantic.entity.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.lunifera.dsl.semantic.common.types.LAnnotationDef;
import org.lunifera.dsl.semantic.common.types.LAnnotationTarget;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;
import org.lunifera.dsl.xtext.lazyresolver.api.EcoreUtil3;

public class LEntityImplCustom extends LEntityImpl {

	/**
	 * Overrides super type to ensure bidirectional proxy resolving
	 */
	@Override
	public LEntity getSuperType() {
		if (superType != null && superType.eIsProxy()) {
			InternalEObject oldSuperType = (InternalEObject) superType;
			LEntity oldSuperEntity = (LEntity) oldSuperType;
			superType = (LEntity) eResolveProxy(oldSuperType);
			if (superType != oldSuperType) {
				// ATENTION: inverse add must be called since bidirectional
				// references uses proxy resolution for lazy linking. And the
				// sub_types added to proxy must be added to new superType
				for (LEntity subType : oldSuperEntity.getSubTypes()) {
					((InternalEObject) superType).eInverseAdd(
							(InternalEObject) subType,
							LunEntityPackage.LENTITY__SUB_TYPES, LEntity.class,
							null);
				}

				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							LunEntityPackage.LENTITY__SUPER_TYPE, oldSuperType,
							superType));
			}
		}
		return superType;
	}

	@Override
	public EList<LAnnotationDef> getAnnotations() {
		LAnnotationTarget info = getAnnotationInfo();
		if (info != null) {
			return info.getAnnotations();
		}
		return new BasicEList<LAnnotationDef>();
	}

	public EObject eResolveProxy(InternalEObject proxy) {
		return EcoreUtil3.resolve(proxy, this.eResource().getResourceSet());
	}

}

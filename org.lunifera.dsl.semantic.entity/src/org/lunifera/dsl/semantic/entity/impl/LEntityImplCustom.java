package org.lunifera.dsl.semantic.entity.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.lunifera.dsl.semantic.entity.EntityPackage;
import org.lunifera.dsl.semantic.entity.LEntity;

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
							EntityPackage.LENTITY__SUB_TYPES, LEntity.class,
							null);
				}

				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EntityPackage.LENTITY__SUPER_TYPE, oldSuperType,
							superType));
			}
		}
		return superType;
	}

}

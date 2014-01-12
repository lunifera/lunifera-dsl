package org.lunifera.dsl.semantic.entity.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.lunifera.dsl.semantic.entity.EntityPackage;
import org.lunifera.dsl.semantic.entity.LBean;

public class LBeanImplCustom extends LBeanImpl {

	/**
	 * Overrides super type to ensure bidirectional proxy resolving
	 */
	@Override
	public LBean getSuperType() {
		if (superType != null && superType.eIsProxy()) {
			InternalEObject oldSuperType = (InternalEObject) superType;
			superType = (LBean) eResolveProxy(oldSuperType);
			if (superType != oldSuperType) {

				// ATENTION: inverse add must be called since bidirectional
				// references uses proxy resolution for lazy linking
				(((InternalEObject) superType)).eInverseAdd(
						(InternalEObject) this, EntityPackage.LBEAN__SUB_TYPES,
						LBean.class, null);

				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EntityPackage.LBEAN__SUPER_TYPE, oldSuperType,
							superType));
			}
		}
		return superType;
	}

}

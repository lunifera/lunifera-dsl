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
package org.lunifera.dsl.xtext.lazyresolver;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.linking.XbaseLazyLinker;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper.IJvmTypeRefFinisher;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class LazyJvmTypeLinker extends XbaseLazyLinker {

	@Inject
	private LazyJvmTypeLinkingHelper linkingHelper;

	@Override
	protected void clearReference(EObject obj, EReference ref) {
		if (linkingHelper.isJvmLink((EReference) obj.eContainingFeature())) {
			// do not clear this reference
			return;
		}

		super.clearReference(obj, ref);
	}

	@SuppressWarnings("unchecked")
	protected void createAndSetProxy(EObject obj, INode node, EReference eRef) {
		if (linkingHelper.isJvmLink(eRef)) {
			return;
		}

		final EObject proxy = createProxy(obj, node, eRef);
		if (eRef.isMany()) {
			((InternalEList<EObject>) obj.eGet(eRef, false)).addUnique(proxy);
		} else {
			obj.eSet(eRef, proxy);
		}

		if (linkingHelper.needsJvmLinking(eRef)) {
			for (EReference jvmLinkReference : linkingHelper
					.getJvmLinkingReferences(eRef)) {
				final JvmParameterizedTypeReference typeRef = TypesFactory.eINSTANCE
						.createJvmParameterizedTypeReference();
				if (eRef.isMany()) {
					((InternalEList<EObject>) obj.eGet(jvmLinkReference, false))
							.addUnique(typeRef);
				} else {
					obj.eSet(jvmLinkReference, typeRef);
				}

				final JvmType jvmProxy = (JvmType) createProxy(
						typeRef,
						node,
						TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
				typeRef.setType(jvmProxy);

				IJvmTypeRefFinisher finisher = linkingHelper
						.getFinisher(jvmLinkReference);
				if (finisher != null) {
					finisher.finish(jvmLinkReference, typeRef);
				}
			}
		}
	}
}

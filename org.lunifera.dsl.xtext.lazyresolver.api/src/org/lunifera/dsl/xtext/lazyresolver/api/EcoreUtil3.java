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
package org.lunifera.dsl.xtext.lazyresolver.api;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * A helper class that uses the {@link ISemanticLoadingResource} to resolve the
 * semantic element without installing the derived state.
 */
public class EcoreUtil3 {

	public static EObject resolve(EObject proxy, ResourceSet resourceSet) {
		URI proxyURI = ((InternalEObject) proxy).eProxyURI();
		if (proxyURI != null) {
			try {
				EObject resolvedObject = null;
				if (resourceSet != null) {
					try {
						Resource resource = resourceSet.getResource(
								proxyURI.trimFragment(), true);
						if (resource instanceof ISemanticLoadingResource) {
							ISemanticLoadingResource castedResource = (ISemanticLoadingResource) resource;
							resolvedObject = castedResource
									.getSemanticElement(proxyURI.fragment());
						} else {
							EcoreUtil.resolve(proxy, resourceSet);
						}
					} catch (RuntimeException exception) {
						resolvedObject = resourceSet
								.getEObject(proxyURI, false);
					}
				} else {
					EPackage ePackage = EPackage.Registry.INSTANCE
							.getEPackage(proxyURI.trimFragment().toString());
					if (ePackage != null) {
						Resource resource = ePackage.eResource();
						if (resource != null) {
							resolvedObject = resource.getEObject(proxyURI
									.fragment().toString());
						}
					}
				}

				if (resolvedObject != null && resolvedObject != proxy) {
					return resolve(resolvedObject, resourceSet);
				}
			} catch (RuntimeException exception) {
				// Failure to resolve is ignored.
			}
		}
		return proxy;
	}

}

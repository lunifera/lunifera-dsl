/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.xtext.lazyresolver.hook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.lunifera.dsl.xtext.lazyresolver.api.hook.IInferrerDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Delegates inferring to registered extensions. See extensionpoint
 * "org.lunifera.dsl.xtext.lazyresolver.inferrerDelegate"
 */
public class ExtensionsInferrerDelegate implements IInferrerDelegate {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ExtensionsInferrerDelegate.class);

	private static final String ATTR_GRAMMAR = "grammarName"; //$NON-NLS-1$
	private static final String ATTR_INFERRERHOOK = "inferrerDelegateClass"; //$NON-NLS-1$
	private static final String INFERRER_HOOK_EXTPT = "inferrerDelegate"; //$NON-NLS-1$

	@Inject
	private LanguageInfo languageInfo;
	@Inject
	private Injector injector;

	@Override
	public void inferTypesOnly(EObject semanticElement,
			IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {

		for (IInferrerDelegate hook : readExtentions(languageInfo
				.getLanguageName())) {
			hook.inferTypesOnly(semanticElement, acceptor, preIndexingPhase);
		}
	}

	@Override
	public void inferFullState(JvmDeclaredType jvmType, EObject semanticElement,
			IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase,
			String selector) {

		for (IInferrerDelegate hook : readExtentions(languageInfo
				.getLanguageName())) {
			hook.inferFullState(jvmType, semanticElement, acceptor,
					preIndexingPhase, selector);
		}
	}

	/**
	 * Extensions are being processed new for each request, since each call
	 * needs a new instance of inferrer.
	 * 
	 * @param grammarName
	 * @return
	 */
	private List<IInferrerDelegate> readExtentions(String grammarName) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(
				"org.lunifera.dsl.xtext.lazyresolver", INFERRER_HOOK_EXTPT);
		if (point == null) {
			return Collections.emptyList();
		}

		List<IInferrerDelegate> delegates = new ArrayList<IInferrerDelegate>(1);
		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i]
					.getConfigurationElements();
			for (int j = 0; j < elements.length; j++) {
				String _grammarName = elements[j].getAttribute(ATTR_GRAMMAR);
				if (_grammarName != null && _grammarName.equals(grammarName)) {
					try {
						IInferrerDelegate delegate = (IInferrerDelegate) elements[j]
								.createExecutableExtension(ATTR_INFERRERHOOK);
						injector.injectMembers(delegate);
						delegates.add(delegate);
					} catch (CoreException e) {
						LOGGER.error("{}", e);
					}
				}
			}
		}
		return delegates;
	}
}

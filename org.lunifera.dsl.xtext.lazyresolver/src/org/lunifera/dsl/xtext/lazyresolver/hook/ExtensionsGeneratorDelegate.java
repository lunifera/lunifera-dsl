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
package org.lunifera.dsl.xtext.lazyresolver.hook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.lunifera.dsl.xtext.lazyresolver.api.hook.IGeneratorDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Delegates generation to registered extensions. See extensionpoint
 * "org.lunifera.dsl.xtext.lazyresolver.generatorDelegate"
 */
public class ExtensionsGeneratorDelegate implements IGeneratorDelegate {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ExtensionsGeneratorDelegate.class);

	private static final String ATTR_GRAMMAR = "grammarName"; //$NON-NLS-1$
	private static final String ATTR_INFERRERHOOK = "generatorDelegateClass"; //$NON-NLS-1$
	private static final String INFERRER_HOOK_EXTPT = "generatorDelegate"; //$NON-NLS-1$

	@Inject
	private LanguageInfo languageInfo;
	@Inject
	private Injector injector;

	@Override
	public void generate(Resource input, IFileSystemAccess fsa) {
		for (IGeneratorDelegate hook : readExtentions(languageInfo
				.getLanguageName())) {
			hook.generate(input, fsa);
		}
	}

	@Override
	public Set<OutputConfiguration> getOutputConfigurations() {
		Set<OutputConfiguration> result = new HashSet<OutputConfiguration>();
		for (IGeneratorDelegate hook : readExtentions(languageInfo
				.getLanguageName())) {
			result.addAll(hook.getOutputConfigurations());
		}
		return result;
	}

	/**
	 * Extensions are being processed new for each request, since each call
	 * needs a new instance of inferrer.
	 * 
	 * @param grammarName
	 * @return
	 */
	private List<IGeneratorDelegate> readExtentions(String grammarName) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(
				"org.lunifera.dsl.xtext.lazyresolver", INFERRER_HOOK_EXTPT);
		if (point == null) {
			return Collections.emptyList();
		}

		List<IGeneratorDelegate> delegates = new ArrayList<IGeneratorDelegate>(
				1);
		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i]
					.getConfigurationElements();
			for (int j = 0; j < elements.length; j++) {
				String _grammarName = elements[j].getAttribute(ATTR_GRAMMAR);
				if (_grammarName != null && _grammarName.equals(grammarName)) {
					try {
						IGeneratorDelegate delegate = (IGeneratorDelegate) elements[j]
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

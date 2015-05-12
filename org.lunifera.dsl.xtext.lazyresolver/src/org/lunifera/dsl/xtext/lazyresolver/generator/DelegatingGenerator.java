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
package org.lunifera.dsl.xtext.lazyresolver.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.lunifera.dsl.xtext.lazyresolver.hook.ExtensionsGeneratorDelegate;

import com.google.inject.Inject;

/**
 * Delegates generator calls to extensions.
 */
@SuppressWarnings("restriction")
public class DelegatingGenerator extends JvmModelGenerator {

	private @Inject ExtensionsGeneratorDelegate generatorDelegate;

	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa);

		generatorDelegate.generate(input, fsa);
	}

}

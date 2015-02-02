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
package org.lunifera.dsl.xtext.lazyresolver.api.hook;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;

public interface IGeneratorDelegate {

	/**
	 * Returns a set of output configurations that should be registered with the
	 * grammar. Must NEVER return <code>null</code>.
	 * 
	 * @return
	 */
	Set<OutputConfiguration> getOutputConfigurations();

	/**
	 * Delegates can implement their own generator that will be called during
	 * the main generation.
	 * 
	 * @param input
	 * @param fsa
	 */
	void generate(Resource input, IFileSystemAccess fsa);

}

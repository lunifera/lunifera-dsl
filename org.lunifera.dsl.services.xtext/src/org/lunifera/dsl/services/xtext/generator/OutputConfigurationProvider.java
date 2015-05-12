

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


package org.lunifera.dsl.services.xtext.generator;

import java.util.Set;

import org.eclipse.xtext.generator.OutputConfiguration;
import org.lunifera.dsl.xtext.lazyresolver.generator.DelegatingOutputConfigurationProvider;

public class OutputConfigurationProvider extends
		DelegatingOutputConfigurationProvider {

	/**
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	public Set<OutputConfiguration> getOutputConfigurations() {
		Set<OutputConfiguration> configs = super.getOutputConfigurations();

		OutputConfiguration servicesOutput = new OutputConfiguration("OSGI-INF");
		servicesOutput.setDescription("Output Folder");
		servicesOutput.setOutputDirectory("./OSGI-INF");
		servicesOutput.setOverrideExistingResources(true);
		servicesOutput.setCreateOutputDirectory(true);
		servicesOutput.setCleanUpDerivedResources(true);
		servicesOutput.setSetDerivedProperty(true);
		servicesOutput.setKeepLocalHistory(true);
		configs.add(servicesOutput);

		return configs;
	}

}

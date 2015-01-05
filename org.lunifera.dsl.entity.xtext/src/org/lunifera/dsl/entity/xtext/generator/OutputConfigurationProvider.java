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

package org.lunifera.dsl.entity.xtext.generator;

import java.util.Set;

import org.eclipse.xtext.generator.OutputConfiguration;

public class OutputConfigurationProvider extends
		org.eclipse.xtext.generator.OutputConfigurationProvider {

	/**
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	public Set<OutputConfiguration> getOutputConfigurations() {
		Set<OutputConfiguration> configs = super.getOutputConfigurations();

		OutputConfiguration servicesOutput = new OutputConfiguration("DTOs");
		servicesOutput.setDescription("derived DTOs");
		servicesOutput.setOutputDirectory("./dto-models");
		servicesOutput.setOverrideExistingResources(false);
		servicesOutput.setCreateOutputDirectory(true);
		servicesOutput.setCleanUpDerivedResources(false);
		servicesOutput.setSetDerivedProperty(false);
		servicesOutput.setKeepLocalHistory(true);
		configs.add(servicesOutput);

		return configs;
	}

}

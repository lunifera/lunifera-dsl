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

package org.lunifera.dsl.dto.xtext.generator;

import java.util.Set;

import org.eclipse.xtext.generator.OutputConfiguration;

public class OutputConfigurationProvider extends
		org.eclipse.xtext.generator.OutputConfigurationProvider {

	/**
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	public Set<OutputConfiguration> getOutputConfigurations() {
		Set<OutputConfiguration> configs = super.getOutputConfigurations();

		OutputConfiguration componentOutput = new OutputConfiguration("OSGI-INF");
		componentOutput.setDescription("OSGi-Services");
		componentOutput.setOutputDirectory("./OSGI-INF");
		componentOutput.setOverrideExistingResources(true);
		componentOutput.setCreateOutputDirectory(true);
		componentOutput.setCleanUpDerivedResources(true);
		componentOutput.setSetDerivedProperty(true);
		componentOutput.setKeepLocalHistory(true);
		configs.add(componentOutput);
		
		OutputConfiguration dtoMapperOutput = new OutputConfiguration("Dto-Mappers");
		dtoMapperOutput.setDescription("Dto Mappers");
		dtoMapperOutput.setOutputDirectory("./src-gen");
		dtoMapperOutput.setOverrideExistingResources(true);
		dtoMapperOutput.setCreateOutputDirectory(true);
		dtoMapperOutput.setCleanUpDerivedResources(true);
		dtoMapperOutput.setSetDerivedProperty(true);
		dtoMapperOutput.setKeepLocalHistory(true);
		configs.add(dtoMapperOutput);
		
		OutputConfiguration servicesOutput = new OutputConfiguration("Services-DSL");
		servicesOutput.setDescription("Services-DSL");
		servicesOutput.setOutputDirectory("./service-models");
		servicesOutput.setOverrideExistingResources(false);
		servicesOutput.setCreateOutputDirectory(true);
		servicesOutput.setCleanUpDerivedResources(false);
		servicesOutput.setSetDerivedProperty(false);
		servicesOutput.setKeepLocalHistory(true);
		configs.add(servicesOutput);

		return configs;
	}

}

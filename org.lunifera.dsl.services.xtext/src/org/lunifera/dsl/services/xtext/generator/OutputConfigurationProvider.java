package org.lunifera.dsl.services.xtext.generator;

import java.util.Set;

import org.eclipse.xtext.generator.OutputConfiguration;

public class OutputConfigurationProvider extends
		org.eclipse.xtext.generator.OutputConfigurationProvider {

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

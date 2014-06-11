package org.lunifera.dsl.metadata.services;

import java.net.URL;
import java.util.List;

import org.osgi.framework.Bundle;

/**
 * Builder participants can participate to the model builder.
 */
public interface IBuilderParticipant {

	/**
	 * Implementors need to setup their xtext grammars.
	 */
	void setupGrammars();

	/**
	 * Returns a list with all models that should be loaded into the builder.
	 * 
	 * @param suspect
	 *            The bundle which might contain model files.
	 * 
	 * @return urls - never <code>null</code>
	 */
	List<URL> getModels(Bundle suspect);

	/**
	 * Should register OSGi services for the different types of metadata.
	 * 
	 * @param service
	 */
	void registerServices(IMetadataBuilderService service);

	/**
	 * Called to notify the participant about the deactivation of the builder.
	 */
	void builderDeactivated();

}

package org.lunifera.dsl.metadata.services;

import java.net.URL;
import java.util.List;

import org.lunifera.dsl.metadata.services.impl.BuilderParticipant;
import org.lunifera.dsl.metadata.services.impl.StandaloneGrammarsSetup;
import org.lunifera.dsl.xtext.types.bundles.BundleSpaceTypeProvider;
import org.osgi.framework.Bundle;

/**
 * Builder participants can participate to the model builder.
 */
@SuppressWarnings("restriction")
public interface IBuilderParticipant {

	/**
	 * Implementors need to setup their xtext grammars.<br>
	 * Attention: The runtime builder needs to use the
	 * {@link BundleSpaceTypeProvider}. Attached {@link BuilderParticipant} or
	 * {@link StandaloneGrammarsSetup} for implementation details.
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

package org.lunifera.dsl.metadata.services.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

import org.lunifera.dsl.metadata.services.IBuilderParticipant;
import org.lunifera.dsl.metadata.services.IDatatypesMetadataService;
import org.lunifera.dsl.metadata.services.IDtoMetadataService;
import org.lunifera.dsl.metadata.services.IEntityMetadataService;
import org.lunifera.dsl.metadata.services.IMetadataBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component(property = { "service.ranking=1" })
public class BuilderParticipant implements IBuilderParticipant {

	private ComponentContext context;
	private ServiceRegistration<IDatatypesMetadataService> datatypesServiceRegistration;
	private ServiceRegistration<IEntityMetadataService> entityServiceRegistration;
	private ServiceRegistration<IDtoMetadataService> dtoServiceRegistration;

	@Activate
	protected void activate(ComponentContext context) {
		this.context = context;
	}

	@Deactivate
	protected void deactivate(ComponentContext context) {
		if (datatypesServiceRegistration != null) {
			datatypesServiceRegistration.unregister();
			datatypesServiceRegistration = null;
		}
		if (entityServiceRegistration != null) {
			entityServiceRegistration.unregister();
			entityServiceRegistration = null;
		}
		if (dtoServiceRegistration != null) {
			dtoServiceRegistration.unregister();
			dtoServiceRegistration = null;
		}

		this.context = null;
	}

	@Override
	public void setupGrammars() {
		StandaloneGrammarsSetup.setup();
	}

	@Override
	public List<URL> getModels(Bundle suspect) {

		boolean keyFound = false;
		String path = "";
		Dictionary<String, String> headers = suspect.getHeaders();
		Enumeration<String> elements = headers.keys();
		while (elements.hasMoreElements()) {
			String key = elements.nextElement();
			if (key.equals("Lun-models")) {
				path = headers.get(key);
				keyFound = true;
				break;
			}
		}

		if (!keyFound) {
			return Collections.emptyList();
		}

		BundleWiring wiring = suspect.adapt(BundleWiring.class);
		List<URL> result = new ArrayList<URL>();
		result.addAll(wiring.findEntries(path, "*.datatypes",
				BundleWiring.FINDENTRIES_RECURSE));
		result.addAll(wiring.findEntries(path, "*.entitymodel",
				BundleWiring.FINDENTRIES_RECURSE));
		result.addAll(wiring.findEntries(path, "*.dtos",
				BundleWiring.FINDENTRIES_RECURSE));
		return result;
	}

	@Override
	public void registerServices(IMetadataBuilderService service) {
		BundleContext bc = context.getBundleContext();
		datatypesServiceRegistration = bc.registerService(
				IDatatypesMetadataService.class, new DatatypesMetadataService(
						service), null);
		entityServiceRegistration = bc.registerService(
				IEntityMetadataService.class,
				new EntityMetadataService(service), null);
		dtoServiceRegistration = bc.registerService(IDtoMetadataService.class,
				new DtoMetadataService(service), null);

	}

	@Override
	public void builderDeactivated() {
		// if the builder was deactivated, then deactivate this participant too.
		deactivate(context);
	}
}

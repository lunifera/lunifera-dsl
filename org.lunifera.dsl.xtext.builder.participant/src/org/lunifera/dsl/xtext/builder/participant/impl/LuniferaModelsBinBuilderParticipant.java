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
package org.lunifera.dsl.xtext.builder.participant.impl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.lunifera.dsl.semantic.common.types.LCommonModel;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.dto.LDtoModel;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityModel;
import org.lunifera.dsl.xtext.builder.participant.IDatatypesMetadataService;
import org.lunifera.dsl.xtext.builder.participant.IDtoMetadataService;
import org.lunifera.dsl.xtext.builder.participant.IEntityMetadataService;
import org.lunifera.xtext.builder.metadata.services.AbstractBuilderParticipant;
import org.lunifera.xtext.builder.metadata.services.IBuilderParticipant;
import org.lunifera.xtext.builder.metadata.services.IMetadataBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.google.inject.Inject;

@Component(service = { IBuilderParticipant.class })
public class LuniferaModelsBinBuilderParticipant extends
		AbstractBuilderParticipant {

	private static final String DATATYPES_BIN = ".datatypes_bin";

	private static final String DTOS_BIN = ".dtos_bin";

	private static final String ENTITIES_BIN = ".entities_bin";

	@Inject
	private IMetadataBuilderService metadataBuilderService;

	private ResourceSet resourceSet;

	private ComponentContext context;
	private ServiceRegistration<IDatatypesMetadataService> datatypesServiceRegister;
	private ServiceRegistration<IEntityMetadataService> entityServiceRegister;
	private ServiceRegistration<IDtoMetadataService> dtoServiceRegister;

	private Map<String, URI> datatypesMap = new HashMap<String, URI>();
	private Map<String, URI> entitiesMap = new HashMap<String, URI>();
	private Map<String, URI> dtosMap = new HashMap<String, URI>();

	public LuniferaModelsBinBuilderParticipant() {

	}

	@Activate
	protected void activate(ComponentContext context) {
		this.context = context;
		resourceSet = new ResourceSetImpl();
	}

	@Deactivate
	protected void deactivate(ComponentContext context) {
		metadataBuilderService.removeFromBundleSpace(context.getBundleContext()
				.getBundle());

		this.context = null;
	}

	@Override
	public List<URL> getModels(Bundle suspect) {

		registerModels(suspect);

		return Collections.emptyList();
	}

	/**
	 * Searches for all ECView translations in the given bundle.
	 * 
	 * @param bundle
	 * @return
	 */
	private List<URL> internalFindURLs(Bundle bundle) {
		List<URL> results = new ArrayList<URL>();
		BundleWiring wiring = bundle.adapt(BundleWiring.class);
		results.addAll(wiring.findEntries("/", "*.entities_bin",
				BundleWiring.LISTRESOURCES_RECURSE));
		results.addAll(wiring.findEntries("/", "*.dtos_bin",
				BundleWiring.LISTRESOURCES_RECURSE));
		results.addAll(wiring.findEntries("/", "*.datatypes_bin",
				BundleWiring.LISTRESOURCES_RECURSE));

		Set<String> fragments = new HashSet<String>();
		for (Iterator<URL> iterator = results.iterator(); iterator.hasNext();) {
			URL url = iterator.next();
			URI uri = URI.createURI(url.toString());
			if (fragments.contains(uri.lastSegment())) {
				iterator.remove();
			}
			fragments.add(uri.lastSegment());
		}

		return results;
	}

	/**
	 * Register transations at the ecviews registry
	 * 
	 * @param bundle
	 */
	private void registerModels(Bundle bundle) {
		List<URL> results = internalFindURLs(bundle);

		for (URL url : results) {
			URI modelURI = URI.createURI(url.toString());
			URI platformURL = toPlatformURI(findReplacedURI(modelURI, bundle));
			resourceSet.getURIConverter().getURIMap()
					.put(platformURL, modelURI);
			resourceSet.createResource(URI.createURI(url.toString()));
		}
	}

	private URI toPlatformURI(URI replacedURI) {
		String auth = replacedURI.authority();
		String bundleId = auth.substring(0, auth.indexOf("."));
		Bundle bundle = context.getBundleContext().getBundle(
				Long.valueOf(bundleId));

		String template = "platform:/resource/%s%s";
		String platformURL = String.format(template, bundle.getSymbolicName(),
				replacedURI.path());

		return URI.createURI(platformURL);
	}

	private URI findReplacedURI(URI modelURI, Bundle bundle) {
		String segment = modelURI.lastSegment();
		String toFind = null;
		if (segment.endsWith(ENTITIES_BIN)) {
			toFind = segment.replace(ENTITIES_BIN, "");
		} else if (segment.endsWith(DTOS_BIN)) {
			toFind = segment.replace(DTOS_BIN, "");
		} else if (segment.endsWith(DATATYPES_BIN)) {
			toFind = segment.replace(DATATYPES_BIN, "");
		}

		BundleWiring wiring = bundle.adapt(BundleWiring.class);
		List<URL> entries = wiring.findEntries("/", toFind,
				BundleWiring.LISTRESOURCES_RECURSE);
		if (!entries.isEmpty()) {
			return URI.createURI(entries.get(0).toString());
		}

		return null;
	}

	@Override
	public void notifyLifecyle(LifecycleEvent event) {
		if (event.getState() == IBuilderParticipant.LifecycleEvent.INITIALIZE) {
			initialize();
		} else if (event.getState() == IBuilderParticipant.LifecycleEvent.BUNDLES_SCANNED) {
			buildCache();
		} else if (event.getState() == IBuilderParticipant.LifecycleEvent.ACTIVATED) {
			DatatypesService datatypesService = new DatatypesService();
			datatypesServiceRegister = context.getBundleContext()
					.registerService(IDatatypesMetadataService.class,
							datatypesService, null);

			EntityService entityService = new EntityService();
			entityServiceRegister = context.getBundleContext().registerService(
					IEntityMetadataService.class, entityService, null);

			DtoService dtoService = new DtoService();
			dtoServiceRegister = context.getBundleContext().registerService(
					IDtoMetadataService.class, dtoService, null);
		} else {
			if (datatypesServiceRegister != null) {
				datatypesServiceRegister.unregister();
				datatypesServiceRegister = null;
			}

			if (entityServiceRegister != null) {
				entityServiceRegister.unregister();
				entityServiceRegister = null;
			}

			if (dtoServiceRegister != null) {
				dtoServiceRegister.unregister();
				dtoServiceRegister = null;
			}

			if (metadataBuilderService != null) {
				metadataBuilderService.removeFromBundleSpace(context
						.getBundleContext().getBundle());
			}
		}
	}

	/**
	 * Creates the internal cache.
	 */
	protected void buildCache() {
		for (Resource resource : new ArrayList<Resource>(
				resourceSet.getResources())) {
			try {
				resource.load(null);
				registerFqn(resource.getContents().get(0));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (Resource resource : new ArrayList<Resource>(
				resourceSet.getResources())) {
			resource.unload();
		}
	}

	private void registerFqn(EObject eObject) {
		if (eObject instanceof LCommonModel) {
			registerDatatypes((LCommonModel) eObject);
		} else if (eObject instanceof LEntityModel) {
			registerEntities((LEntityModel) eObject);
		} else if (eObject instanceof LDtoModel) {
			registerDtos((LDtoModel) eObject);
		}
	}

	private void registerDtos(LDtoModel eObject) {
		for (LTypedPackage lPkg : eObject.getPackages()) {
			for (LType lType : lPkg.getTypes()) {
				dtosMap.put(
						String.format("%s.%s", lPkg.getName(), lType.getName()),
						EcoreUtil.getURI(lType));
			}
		}
	}

	private void registerEntities(LEntityModel eObject) {
		for (LTypedPackage lPkg : eObject.getPackages()) {
			for (LType lType : lPkg.getTypes()) {
				entitiesMap
						.put(String.format("%s.%s", lPkg.getName(),
								lType.getName()), EcoreUtil.getURI(lType));
			}
		}
	}

	private void registerDatatypes(LCommonModel eObject) {
		for (LTypedPackage lPkg : eObject.getPackages()) {
			for (LType lType : lPkg.getTypes()) {
				datatypesMap
						.put(String.format("%s.%s", lPkg.getName(),
								lType.getName()), EcoreUtil.getURI(lType));
			}
		}
	}

	private void initialize() {
		metadataBuilderService.addToBundleSpace(context.getBundleContext()
				.getBundle());
	}

	/**
	 * Provided as an OSGi service to return {@link LDataType LDataTypes} for
	 * the given qualified name.
	 */
	private class DatatypesService implements IDatatypesMetadataService {

		@Override
		public LDataType getMetadata(String datatypeName) {
			return (LDataType) resourceSet.getEObject(
					datatypesMap.get(datatypeName), true);
		}

	}

	/**
	 * Provided as an OSGi service to return {@link LEntity LEntities} for the
	 * given qualified name.
	 */
	private class EntityService implements IEntityMetadataService {

		@Override
		public LEntity getMetadata(Class<?> entityClass) {
			return getMetadata(entityClass.getCanonicalName());
		}

		@Override
		public LEntity getMetadata(String className) {
			URI uri = entitiesMap.get(className);
			if (uri == null) {
				return null;
			}

			EObject result = resourceSet.getEObject(uri, true);
			return (result instanceof LEntity) ? (LEntity) result : null;
		}
	}

	/**
	 * Provided as an OSGi service to return {@link LDto LDtos} for the given
	 * qualified name.
	 */
	private class DtoService implements IDtoMetadataService {

		@Override
		public LDto getMetadata(Class<?> entityClass) {
			return getMetadata(entityClass.getCanonicalName());
		}

		@Override
		public LDto getMetadata(String className) {
			URI uri = dtosMap.get(className);
			if (uri == null) {
				return null;
			}

			EObject result = resourceSet.getEObject(uri, true);
			return (result instanceof LDto) ? (LDto) result : null;
		}

	}

}

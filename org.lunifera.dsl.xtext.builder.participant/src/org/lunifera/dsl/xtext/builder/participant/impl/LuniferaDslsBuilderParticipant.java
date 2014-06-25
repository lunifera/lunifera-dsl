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

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;
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
public class LuniferaDslsBuilderParticipant extends AbstractBuilderParticipant {

	@Inject
	private IMetadataBuilderService metadataBuilderService;

	private ComponentContext context;
	private ServiceRegistration<IDatatypesMetadataService> datatypesServiceRegister;
	private ServiceRegistration<IEntityMetadataService> entityServiceRegister;
	private ServiceRegistration<IDtoMetadataService> dtoServiceRegister;

	public LuniferaDslsBuilderParticipant() {

	}

	@Activate
	protected void activate(ComponentContext context) {
		this.context = context;
	}

	@Deactivate
	protected void deactivate(ComponentContext context) {
		metadataBuilderService.removeFromBundleSpace(context.getBundleContext()
				.getBundle());

		this.context = null;
	}

	@Override
	public List<URL> getModels(Bundle suspect) {

		List<URL> results = new ArrayList<URL>();
		BundleWiring wiring = suspect.adapt(BundleWiring.class);
		results.addAll(wiring.findEntries("/", "*.entitymodel",
				BundleWiring.LISTRESOURCES_RECURSE));
		results.addAll(wiring.findEntries("/", "*.dtos",
				BundleWiring.LISTRESOURCES_RECURSE));
		results.addAll(wiring.findEntries("/", "*.datatypes",
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

	@Override
	public void notifyLifecyle(LifecycleEvent event) {
		if (event.getState() == IBuilderParticipant.LifecycleEvent.INITIALIZE) {
			initialize();
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

	private void initialize() {
		StandaloneGrammarsSetup.setup();
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
			return (LDataType) metadataBuilderService.getMetadata(datatypeName,
					LunTypesPackage.Literals.LDATA_TYPE);
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
			return (LEntity) metadataBuilderService.getMetadata(className,
					LunEntityPackage.Literals.LENTITY);
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
			return (LDto) metadataBuilderService.getMetadata(className,
					LunDtoPackage.Literals.LDTO);
		}

	}

}

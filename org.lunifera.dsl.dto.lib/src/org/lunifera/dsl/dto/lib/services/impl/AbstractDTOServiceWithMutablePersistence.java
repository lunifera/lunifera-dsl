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
package org.lunifera.dsl.dto.lib.services.impl;

import javax.persistence.EntityManagerFactory;

import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public abstract class AbstractDTOServiceWithMutablePersistence<DTO, ENTITY>
		extends AbstractDTOService<DTO, ENTITY>
		implements
		org.lunifera.dsl.dto.lib.services.IDTOServiceWithMutablePersistence<DTO>,
		ServiceTrackerCustomizer<EntityManagerFactory, EntityManagerFactory> {

	private static final String FILTER__EMF = "(objectClass=javax.persistence.EntityManagerFactory)";
	private static final String FILTER__EMF_WITH_PERSISTENCE = "(&(objectClass=javax.persistence.EntityManagerFactory)(osgi.unit.name=%s))";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AbstractDTOServiceWithMutablePersistence.class);

	private ServiceTracker<EntityManagerFactory, EntityManagerFactory> emfTracker;
	private ComponentContext context;
	private String persistenceId;

	public String getPersistenceId() {
		return persistenceId;
	}

	public void setPersistenceId(String persistenceId) {
		this.persistenceId = persistenceId;

		if (context != null) {
			internalReset();
		}
	}

	//
	// OSGI Infrastructure
	//

	/**
	 * Called by OSGi-DS to activate the service.
	 * 
	 * @param context
	 */
	protected void activate(ComponentContext context) throws Exception {
		this.context = context;

		internalActivate();
	}

	protected void internalActivate() throws InvalidSyntaxException {
		if (emfTracker == null) {
			emfTracker = new ServiceTracker<EntityManagerFactory, EntityManagerFactory>(
					context.getBundleContext(), createEMFFilter(), this);
			emfTracker.open();
		}
	}

	/**
	 * Create the filter to find the proper service.
	 * 
	 * @return
	 * @throws InvalidSyntaxException
	 */
	protected Filter createEMFFilter() throws InvalidSyntaxException {
		if (getPersistenceId() == null || getPersistenceId().equals("")) {
			return context.getBundleContext().createFilter(FILTER__EMF);
		} else {
			return context.getBundleContext().createFilter(
					String.format(FILTER__EMF_WITH_PERSISTENCE,
							getPersistenceId()));
		}
	}

	/**
	 * Called by OSGi-DS to deactivate the service.
	 * 
	 * @param context
	 */
	protected void deactivate(ComponentContext context) {
		internalDeactivate();
		this.context = null;
	}

	/**
	 * Resets the internal state.
	 */
	protected void internalReset() {
		internalDeactivate();
		if (context != null) {
			try {
				internalActivate();
			} catch (InvalidSyntaxException e) {
				LOGGER.error("{}", e);
			}
		}
	}

	protected void internalDeactivate() {
		if (emfTracker != null) {
			emfTracker.close();
			emfTracker = null;
		}
	}

	@Override
	public EntityManagerFactory addingService(
			ServiceReference<EntityManagerFactory> reference) {
		EntityManagerFactory emf = context.getBundleContext().getService(
				reference);
		if (getEmf() == null) {
			bindEmf(emf);
		}
		return emf;
	}

	@Override
	public void modifiedService(
			ServiceReference<EntityManagerFactory> reference,
			EntityManagerFactory service) {
		// nothing to do
	}

	@Override
	public void removedService(
			ServiceReference<EntityManagerFactory> reference,
			EntityManagerFactory service) {
		if (getEmf() == service) {
			unbindEmf(getEmf());
		}
	}
}

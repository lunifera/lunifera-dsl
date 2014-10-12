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
package org.lunifera.dsl.dto.lib.impl;

import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.IMapperAccess;
import org.lunifera.dsl.dto.lib.services.IDTOService;
import org.osgi.framework.Bundle;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.component.annotations.Component;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Is responsible to return mappers for the given types.
 */
@Component(immediate = true)
public class DtoServiceAccess {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DtoServiceAccess.class);

	/**
	 * Returns a proper mapper for the dto and entity.
	 * 
	 * @param dto
	 * @param entity
	 */
	public static <D> IDTOService<D> getService(Class<D> dto) {
		Bundle bundle = FrameworkUtil.getBundle(DtoServiceAccess.class);

		String filterString = String.format("&((objectClass=%s)(dto=%s)",
				IDTOService.class.getCanonicalName(), dto.getCanonicalName());
		try {
			Filter filter = FrameworkUtil.createFilter(filterString);
			ServiceTracker<IDTOService<D>, IDTOService<D>> tracker = new ServiceTracker<IDTOService<D>, IDTOService<D>>(
					bundle.getBundleContext(), filter, null);
			tracker.open();

			IDTOService<D> service = tracker.waitForService(5000);
			tracker.close();
			return service;
		} catch (InvalidSyntaxException e) {
			LOGGER.error("{}", e);
		} catch (InterruptedException e) {
			LOGGER.error("{}", e);
		}

		LOGGER.error("No dtoService available for dto: {}", dto);

		return null;
	}
}

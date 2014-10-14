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
public class MapperAccess implements IMapperAccess {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapperAccess.class);

	/**
	 * Returns a proper mapper for the dto and entity.
	 * @param dto
	 * @param entity
	 */
	@Override
	public <D, E> IMapper<D, E> getMapper(Class<D> dto, Class<E> entity) {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		String filterString = String.format("(&(&(objectClass=%s)(dto=%s))(entity=%s))",
				IMapper.class.getCanonicalName(), dto.getCanonicalName(),
				entity.getCanonicalName());
		try {
			Filter filter = FrameworkUtil.createFilter(filterString);
			ServiceTracker<IMapper<D, E>, IMapper<D, E>> tracker = new ServiceTracker<IMapper<D, E>, IMapper<D, E>>(
					bundle.getBundleContext(), filter, null);
			tracker.open();
			
			IMapper<D, E> mapper = tracker.waitForService(1000);
			tracker.close();
			return mapper;
		} catch (InvalidSyntaxException e) {
			LOGGER.error("{}", e);
		} catch (InterruptedException e) {
			LOGGER.error("{}", e);
		}

		LOGGER.error("No mapper available for dto: {} and entity: {}", dto, entity);
		
		return null;
	}
}

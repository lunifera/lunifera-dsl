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

import java.util.Collection;

import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.IMapperAccess;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Is responsible to return mappers for the given types.
 */
@Component(immediate = true)
public class MapperAccess implements IMapperAccess {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MapperAccess.class);

	/**
	 * Returns a proper mapper for the dto and entity.
	 * 
	 * @param dto
	 * @param entity
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <D, E> IMapper<D, E> getMapper(Class<D> dto, Class<E> entity) {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		String filterString = String.format(
				"(&(&(objectClass=%s)(dto=%s))(entity=%s))",
				IMapper.class.getCanonicalName(), dto.getCanonicalName(),
				entity.getCanonicalName());
		try {
			BundleContext context = bundle.getBundleContext();
			Collection<ServiceReference<IMapper>> references = context
					.getServiceReferences(IMapper.class, filterString);
			if (!references.isEmpty()) {
				ServiceReference<IMapper> reference = references.iterator()
						.next();
				IMapper<D, E> mapper = context.getService(reference);
				return mapper;
			}

		} catch (InvalidSyntaxException e) {
			LOGGER.error("{}", e);
		}

		LOGGER.error("No mapper available for dto: {} and entity: {}", dto,
				entity);

		return null;
	}
}

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

import org.lunifera.dsl.dto.lib.services.IDTOService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Is responsible to return mappers for the given types.
 */
public class DtoServiceAccess {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DtoServiceAccess.class);

	/**
	 * Returns a proper mapper for the dto.
	 * 
	 * @param dto
	 * @param entity
	 */
	public static <D> IDTOService<D> getService(Class<D> dto) {
		return getService(dto.getCanonicalName());
	}

	/**
	 * Returns a proper mapper for the dto.
	 * 
	 * @param dto
	 * @param entity
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <D> IDTOService<D> getService(String dtoName) {
		Bundle bundle = FrameworkUtil.getBundle(DtoServiceAccess.class);

		String filterString = String.format("(&(objectClass=%s)(dto=%s))",
				IDTOService.class.getCanonicalName(), dtoName);
		try {
			BundleContext context = bundle.getBundleContext();
			Collection<ServiceReference<IDTOService>> references = context
					.getServiceReferences(IDTOService.class, filterString);
			if (!references.isEmpty()) {
				ServiceReference<IDTOService> reference = references.iterator()
						.next();
				IDTOService<D> service = context.getService(reference);
				return service;
			}
		} catch (InvalidSyntaxException e) {
			LOGGER.error("{}", e);
		}

		LOGGER.error("No dtoService available for dto: {}", dtoName);

		return null;
	}
}

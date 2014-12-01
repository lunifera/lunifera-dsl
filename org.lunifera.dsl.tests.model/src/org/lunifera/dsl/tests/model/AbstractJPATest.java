/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.tests.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceProviderResolver;
import javax.persistence.spi.PersistenceProviderResolverHolder;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class AbstractJPATest {

	protected Map<String, Object> properties = new HashMap<String, Object>();

	public void setUp() throws Exception {
		PersistenceProviderResolverHolder
				.setPersistenceProviderResolver(new PersistenceProviderResolver() {
					private List<PersistenceProvider> providers = new ArrayList<PersistenceProvider>();

					@Override
					public List<PersistenceProvider> getPersistenceProviders() {
						org.eclipse.persistence.jpa.PersistenceProvider provider = new org.eclipse.persistence.jpa.PersistenceProvider();
						providers.add(provider);
						return providers;
					}

					@Override
					public void clearCachedProviders() {
						providers.clear();
					}
				});
		properties.put(PersistenceUnitProperties.CLASSLOADER, getClass()
				.getClassLoader());

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"testCarstore", properties);
		Bundle bundle = FrameworkUtil.getBundle(AbstractJPATest.class);
		bundle.getBundleContext().registerService(EntityManagerFactory.class,
				emf, null);
	}

}

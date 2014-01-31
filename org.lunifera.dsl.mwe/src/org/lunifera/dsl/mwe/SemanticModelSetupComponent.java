/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Based on Xtext mwe
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.mwe;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;

public class SemanticModelSetupComponent extends AbstractWorkflowComponent2 {

	private Log log = LogFactory.getLog(getClass());

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
	}

	public void addEPackage(PackageMapping mapping) {
		try {
			System.getProperties();
			
			EPackage.Registry.INSTANCE.getEPackage(mapping.getNsURI());
			if (!EPackage.Registry.INSTANCE.containsKey(mapping.getNsURI())) {
				Class<?> clazz = ResourceLoaderFactory.createResourceLoader()
						.loadClass(mapping.getPackageClass());
				if (clazz == null)
					throw new ConfigurationException(
							"Couldn't find an interface "
									+ mapping.getPackageClass());

				EPackage pack = (EPackage) clazz.getDeclaredField("eINSTANCE")
						.get(null);
				EPackage.Registry.INSTANCE.put(pack.getNsURI(), pack);
				log.info("Adding generated EPackage '"
						+ mapping.getPackageClass() + "'");

				@SuppressWarnings("unchecked")
				Class<EFactory> factoryClazz = (Class<EFactory>) ResourceLoaderFactory
						.createResourceLoader().loadClass(
								mapping.getFactoryClass());
				if (factoryClazz != null) {
					pack.setEFactoryInstance(factoryClazz.newInstance());
					log.info("Set EFactory " + mapping.getFactoryClass()
							+ " to package " + mapping.getPackageClass());
				}
			}

		} catch (Exception e) {
			throw new ConfigurationException("Couldn't register "
					+ mapping.getPackageClass()
					+ ". Is it the generated EPackage interface? : "
					+ e.getMessage());
		}
	}

}

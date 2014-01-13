/**
 * Copyright (c) 2011 - 2014, Cristiano Gaviao (Brazil), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Cristiano Gaviao - Initial implementation
 */
package org.lunifera.dsl.eclipse.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.util.Modules2;
import org.lunifera.dsl.eclipse.ui.internal.guice.LuniferaUiCommonModule;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class LuniferaUiActivator extends AbstractUIPlugin implements IStartup {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.lunifera.dsl.eclipse.ui"; //$NON-NLS-1$

	// The shared instance
	private static LuniferaUiActivator plugin;

	private Injector childInjector;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		getInjector();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		childInjector = null;
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */

	public static LuniferaUiActivator getInstance() {
		return plugin;
	}

	public Injector getInjector() {
		if (childInjector == null) {

			Module module = new LuniferaUiCommonModule(LuniferaUiActivator.getInstance());
			Module sharedStateModule = new org.eclipse.xtext.ui.shared.SharedStateModule();
			Module mergedModule = Modules2.mixin(module, sharedStateModule);
			childInjector = Guice.createInjector(mergedModule);
		}
		return childInjector;
	}

	@Override
	public void earlyStartup() {
		
		getInjector();
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}

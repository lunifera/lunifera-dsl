/*******************************************************************************
 * Copyright (c) 2011, 2012 Cristiano Gavião - Lunifera.org.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cristiano Gavião - initial API and implementation
 *******************************************************************************/
package org.lunifera.dsl.eclipse.ui.internal.guice;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.lunifera.dsl.eclipse.ui.wizards.LuniferaCommonProjectCreator;

import com.google.inject.Binder;
import com.google.inject.name.Names;


/**
 * Use this class to register components to be used within the IDE.
 */
public class LuniferaUiCommonModule extends AbstractGenericModule {

	private final AbstractUIPlugin plugin;

	public LuniferaUiCommonModule(AbstractUIPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractUIPlugin.class).toInstance(plugin);
		binder.bind(IDialogSettings.class).toInstance(plugin.getDialogSettings());
	}
	
	public Class<? extends IProjectCreator> bindIProjectCreator() {
		return LuniferaCommonProjectCreator.class;
	}

	public java.lang.ClassLoader bindClassLoaderToInstance() {
		return getClass().getClassLoader();
	}


	public Class<? extends IImageHelper> bindIImageHelper() {
		return PluginImageHelper.class;
	}
	
	public void configureFileExtensions(Binder binder) {
		
		binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("lunifera");
	}

}

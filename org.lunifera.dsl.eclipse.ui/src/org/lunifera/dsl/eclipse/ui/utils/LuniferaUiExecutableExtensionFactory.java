/*******************************************************************************
 * Copyright (c) 2011, 2014 Cristiano Gavião (Brazil), Loetz KG (Heidelberg).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cristiano Gavião - initial API and implementation
 *******************************************************************************/
package org.lunifera.dsl.eclipse.ui.utils;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.lunifera.dsl.eclipse.ui.LuniferaUiActivator;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

public class LuniferaUiExecutableExtensionFactory extends
		AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return LuniferaUiActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return LuniferaUiActivator.getInstance().getInjector();
	}

}

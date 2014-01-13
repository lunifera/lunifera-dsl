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
package org.lunifera.dsl.organization.xtext.tests.utils;

import org.lunifera.dsl.organization.xtext.OrganizationGrammarInjectorProvider;
import org.lunifera.dsl.organization.xtext.OrganizationGrammarStandaloneSetup;

import com.google.inject.Injector;

public class CustomInjectorProvider extends OrganizationGrammarInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		OrganizationGrammarStandaloneSetup.doSetup();
		return super.internalCreateInjector();
	}
}

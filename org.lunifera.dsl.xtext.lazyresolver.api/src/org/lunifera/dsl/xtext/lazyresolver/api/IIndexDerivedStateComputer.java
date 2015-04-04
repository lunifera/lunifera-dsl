/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.xtext.lazyresolver.api;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;

public interface IIndexDerivedStateComputer extends IDerivedStateComputer{

	/**
	 * Installs the derived state for the given type.
	 * @param resource
	 * @param type
	 * @param preLinkingPhase
	 */
	void installDerivedState(DerivedStateAwareResource resource, JvmDeclaredType type, boolean preLinkingPhase);
	
}

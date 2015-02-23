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
package org.lunifera.dsl.dto.lib;

/**
 * Objects implementing this interface can be copied using a copy context.
 */
public interface ICopyable<A> {

	/**
	 * Creates a copy of the current object. If a copy of current object is
	 * already registered in the context, this element needs to be returned.
	 * Otherwise the object needs to be copied and registered in the context.
	 * 
	 * @param context
	 * @return
	 */
	A copy(MappingContext context);

}

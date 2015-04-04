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
package org.lunifera.dsl.dto.lib.services;

import javax.persistence.EntityManagerFactory;

/**
 * This DTO service allows to specify a deviating persistence ID.
 *
 * @param <A>
 */
public interface IDTOServiceWithMutablePersistence<A> extends IDTOService<A> {

	/**
	 * Returns the persistence Id which is used to find the proper
	 * {@link EntityManagerFactory},
	 * 
	 * @return
	 */
	String getPersistenceId();

	/**
	 * Sets the persistence Id which is used to find the proper
	 * {@link EntityManagerFactory},
	 * 
	 * @param persistenceId
	 */
	void setPersistenceId(String persistenceId);

}

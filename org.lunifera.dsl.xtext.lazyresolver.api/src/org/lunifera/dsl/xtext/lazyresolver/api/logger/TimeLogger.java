/**
 * Copyright (c) 2012 Committers of lunifera.org.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Florian Pirchner - initial API and implementation
 */
package org.lunifera.dsl.xtext.lazyresolver.api.logger;

import java.util.Date;

import org.slf4j.Logger;

public class TimeLogger {

	private final Class<?> clazz;
	private final long start;

	public static TimeLogger start(Class<?> clazz) {
		return new TimeLogger(clazz);
	}

	private TimeLogger(Class<?> clazz) {
		this.clazz = clazz;
		start = new Date().getTime();
	}

	/**
	 * 
	 * @param message
	 */
	public void stop(Logger logger, String message) {
		long stop = new Date().getTime();
		logger.debug((stop - start)
				+ "ms : " + message);
	}

}

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
package org.lunifera.dsl.dto.lib.services.impl;

import java.sql.SQLException;

import org.lunifera.dsl.dto.lib.services.DtoServiceException;

/**
 * Converts SQLExceptions.
 * <p>
 * TODO make it an OSGi service and support XOPEN SQLstate conventions and the
 * SQL:2003 conventions
 */
public class ExceptionConverter {

	/**
	 * Converts SQL Exceptions.
	 * 
	 * @param e
	 * @return
	 */
	protected DtoServiceException convertException(Exception e) {
		Throwable cause = e.getCause();
		if (cause instanceof RuntimeException) {
			Throwable innercause = cause.getCause();
			if (innercause instanceof SQLException) {
				SQLException sqlEx = (SQLException) innercause;
				String state = sqlEx.getSQLState();
				if (state.equals("23503")) {
					return new DtoServiceException(state,
							"Delete not possible. The record is used.", e);
				}
			}
		}
		return new DtoServiceException("unknown", e.getMessage(), e);
	}
}

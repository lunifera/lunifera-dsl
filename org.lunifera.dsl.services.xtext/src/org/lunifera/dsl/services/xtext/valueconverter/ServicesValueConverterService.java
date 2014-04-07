/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Hans Georg Gl??ckler - Initial implementation
 */
package org.lunifera.dsl.services.xtext.valueconverter;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.lunifera.dsl.common.xtext.valueconverter.CommonValueConverterService;

import com.google.inject.Singleton;

/**
 * Adds a value conversion for the QualifiedNameWithWildCard rule.
 */
@SuppressWarnings("restriction")
@Singleton
public class ServicesValueConverterService extends CommonValueConverterService {

	@ValueConverter(rule = "QualifiedNameWithWildCard")
	public IValueConverter<String> getQualifiedNameWithWildCard() {
		return getQualifiedNameValueConverter();
	}

}

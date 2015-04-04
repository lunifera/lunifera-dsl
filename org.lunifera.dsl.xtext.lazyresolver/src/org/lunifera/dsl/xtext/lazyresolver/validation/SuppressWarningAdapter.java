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
package org.lunifera.dsl.xtext.lazyresolver.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * Can be used to mark {@link JvmTypeReference} that warnings of different types
 * will be suppressed.
 */
public class SuppressWarningAdapter extends AdapterImpl {

	public static final String RAW_TYPE = "rawTypes";

	private Set<String> types = new HashSet<String>();

	public SuppressWarningAdapter(String... types) {
		this.types.addAll(Arrays.asList(types));
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == SuppressWarningAdapter.class;
	}

	/**
	 * Returns true, if the type is suppressed.
	 * 
	 * @param type
	 * @return
	 */
	public boolean isSuppressed(String type) {
		return types.contains(type);
	}

}

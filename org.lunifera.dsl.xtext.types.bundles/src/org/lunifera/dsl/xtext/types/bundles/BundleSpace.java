/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 * 
 * Based on Xtext org.eclipse.xtext.common.types.access.impl.ClassFinder
 * 
 */
package org.lunifera.dsl.xtext.types.bundles;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.access.impl.ClassNameUtil;
import org.eclipse.xtext.common.types.access.impl.Primitives;
import org.osgi.framework.Bundle;

@SuppressWarnings("restriction")
public class BundleSpace {

	protected static final ClassNotFoundException CACHED_EXCEPTION = new ClassNotFoundException();
	private static final Class<?> NULL_CLASS;

	static {
		class Null {
		}
		NULL_CLASS = Null.class;
	}

	private final Set<Bundle> bundles;
	private final ClassNameUtil classNameUtil;
	private final Class<?> nullValue;
	private final Map<String, Class<?>> cache;

	public BundleSpace(Set<Bundle> bundles) {
		this.bundles = bundles;
		this.nullValue = NULL_CLASS;
		this.cache = new Cache();
		this.classNameUtil = new ClassNameUtil();
	}

	public Class<?> forName(String name) throws ClassNotFoundException {
		Class<?> result = cache.get(name);
		if (result != null) {
			if (result == nullValue)
				throw CACHED_EXCEPTION;
			return result;
		}

		for (Bundle bundle : bundles) {
			try {
				result = bundle.loadClass(classNameUtil
						.normalizeClassName(name));
				if (result != null) {
					break;
				}
			} catch (ClassNotFoundException e) {
				// nothing to do
			}
		}

		if (result != null) {
			cache.put(name, result);
		} else {
			cache.put(name, NULL_CLASS);
			throw CACHED_EXCEPTION;
		}
		return result;
	}

	@SuppressWarnings("serial")
	private static class Cache extends HashMap<String, Class<?>> {
		public Cache() {
			super(500);
			for (Class<?> primitiveType : Primitives.ALL_PRIMITIVE_TYPES) {
				put(primitiveType.getName(), primitiveType);
			}
		}
	}
}

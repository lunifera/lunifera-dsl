/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Mark Christiaens
 * 
 * @since 2.3
 */
public class AlwaysMissCache implements ICache {
	public Resource load(ResourceSet resourceSet, URI uri, boolean addNodeModel) {
		return null;
	}

	public void clear() {
	}

	public void init(File cacheLocation) throws IOException {
	}

	public ICacheEntry load(XtextResource xr, byte[] content, String encoding, boolean addNodeModel)
			throws IOException {
		return null;
	}

	public ICacheEntry add(XtextResource xr, byte[] content, String encoding) throws IOException {
		return null;
	}

	@Override
	public ICacheEntry addDerivedState(XtextResource xr, ICacheEntry changeEntry) throws IOException {
		return null;
	}

	@Override
	public XtextResource loadDS(XtextResource xr, ICacheEntry cacheEntry,
			String completeContent, boolean requireNodeModel)
			throws IOException {
		return null;
	}
}

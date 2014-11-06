/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import java.io.File;
import java.io.IOException;

import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * A cache for EMF and INode models. Creating the EMF and INode models for a
 * resource requires lexing, parsing, building the models ... and can be quite
 * time consuming. An ICache can cache the resulting EMF and INode models so
 * that, when a resource is loaded again, the EMF and INode models can be
 * reconstructed considerably faster.
 * 
 * @author Mark Christiaens - Initial contribution
 * @since 2.3
 */

@ImplementedBy(AlwaysMissCache.class)
public interface ICache {
	/**
	 * Load option for a resource set so that only the EMF model is loaded for a
	 * resource. The backing INode model underneath the EMF model is not
	 * installed. Results in faster load times but reduced functionality. Use
	 * with caution.
	 */
	final public static String OMIT_NODE_MODEL = "org.lunifera.dsl.xtext.cache.ICache.OMIT_NODE_MODEL";

	/**
	 * Load option for a resource set so that the cache is skipped and resources
	 * are constructed from the content of the resource and not from the cache's
	 * content.
	 */
	final public static String DO_NOT_CONSULT_CACHE = "org.lunifera.dsl.xtext.cache.ICache.DO_NOT_CONSULT_CACHE";

	/**
	 * Load the content of a resource from cache
	 * 
	 * @param xr
	 *            Resource to load content into
	 * 
	 * @param content
	 *            Bytes representing content
	 * 
	 * @param encoding
	 *            Encoding used to interpret above bytes
	 * 
	 * @param addNodeModel
	 *            Also load the INode model and properly interconnect it with
	 *            the EMF resource.
	 * 
	 * @return The resource that was loaded.
	 * 
	 * @throws IOException
	 *             when reading data from the cache caused an IO exception.
	 * */
	ICacheEntry load(XtextResource xr, byte[] content, String encoding,
			boolean addNodeModel) throws IOException;

	XtextResource loadDS(XtextResource xr, ICacheEntry cacheEntry,
			String completeContent, boolean requireNodeModel)
			throws IOException;

	/**
	 * Present a resource to the cache for optional inclusion. This may result
	 * in the removal of other resources from the cache.
	 * 
	 * @param xr
	 *            Resource to cache
	 * 
	 * @param content
	 *            Bytes from which this resource was constructed
	 * 
	 * @param encoding
	 *            The encoding used to interpret the content
	 * 
	 * @throws IOException
	 *             when storing the content of the resource failed.
	 */

	ICacheEntry add(XtextResource xr, byte[] content, String encoding)
			throws IOException;

	/**
	 * Refreshes the serialized entries.
	 * 
	 * @param xr
	 * @param changeEntry
	 * @param content
	 * @param encoding
	 * @throws IOException
	 */
	ICacheEntry addDerivedState(XtextResource xr, ICacheEntry changeEntry)
			throws IOException;

	/**
	 * Empty the content of the cache.
	 */
	void clear() throws IOException;

	/**
	 * Point the cache to a certain directory for holding its backing storage.
	 * 
	 * @param cacheLocation
	 *            The directory where the content of the cache will be stored.
	 * 
	 * @throws IOException
	 *             when IO goes wrong when accessing the cache.
	 */
	public void init(File cacheLocation) throws IOException;
}

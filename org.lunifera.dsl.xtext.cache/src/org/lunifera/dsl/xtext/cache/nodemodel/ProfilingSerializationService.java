/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.nodemodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.xtext.nodemodel.serialization.SerializationUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @author Mark Christiaens - Initial contribution 
 * 
 * @since 2.3
 */ 
public class ProfilingSerializationService extends DefaultSerializationService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProfilingSerializationService.class);
	
	@Override
	public XtextResource loadResource(XtextResource xr, InputStream emfIn, InputStream nodeModelIn, String completeContent)
			throws IOException {
		long loadEMFStart = System.nanoTime();
		xr = loadEMFModel(xr, emfIn);
		long loadEMFDone = System.nanoTime();
		LOGGER.info("Loading EMF model for " + xr.getURI() + ": " + SerializationUtil.milliDiff(loadEMFStart, loadEMFDone) + " ms");
		augmentWithNodeModel(xr, nodeModelIn, completeContent);
		long augmentWithNodeModelDone = System.nanoTime();

		if (nodeModelIn != null) {
			LOGGER.info("Loading node model for " + xr.getURI() + ": " + SerializationUtil.milliDiff(loadEMFDone, augmentWithNodeModelDone)
					+ " ms");
		}

		return xr;
	}

	@Override
	protected void serializeEMF(XtextResource resource, OutputStream out) throws IOException {
		long saveStart = System.nanoTime();
		super.serializeEMF(resource, out);
		long saveDone = System.nanoTime();

		LOGGER.info("Writing EMF model for " + resource.getURI() + ": " + SerializationUtil.milliDiff(saveStart, saveDone) + " ms");
	}

	@Override
	protected void serializeNodeModel(XtextResource resource, OutputStream out) throws IOException {
		long saveStart = System.nanoTime();
		super.serializeNodeModel(resource, out);
		long saveDone = System.nanoTime();

		LOGGER.info("Writing node model for " + resource.getURI() + ": " + SerializationUtil.milliDiff(saveStart, saveDone) + " ms");
	}
}

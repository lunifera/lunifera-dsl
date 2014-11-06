/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.nodemodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.xtext.resource.XtextResource;
import org.lunifera.dsl.xtext.cache.nodemodel.DefaultSerializationService.SerializeVetoException;

import com.google.inject.ImplementedBy;

/**
 * @author Mark Christiaens - Initial contribution
 * 
 * @since 2.3
 */

@ImplementedBy(DefaultSerializationService.class)
public interface ISerializationService {

	void write(XtextResource resource, OutputStream emfOut,
			OutputStream nodeModelOut) throws IOException,
			SerializeVetoException;

	void writeDerivedState(XtextResource resource, OutputStream emfOut)
			throws IOException, SerializeVetoException;

	XtextResource loadResource(XtextResource xr, InputStream emfIn,
			InputStream nodeModelIn, String completeContent) throws IOException;

	XtextResource loadDerivedState(XtextResource xr, InputStream dsIn,
			String completeContent) throws IOException;
}
/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;

/**
 * @author mark.christiaens - Initial contribution and API
 */
public interface IReadLockedCacheIndex extends ICacheIndex {
	public Iterator<ICacheEntry> getEntriesByAge();
	
	public long getTotalOrigContentSize();

	public void write(DataOutputStream stream) throws IOException;

	public ICacheEntry get(BigInteger digest);
}

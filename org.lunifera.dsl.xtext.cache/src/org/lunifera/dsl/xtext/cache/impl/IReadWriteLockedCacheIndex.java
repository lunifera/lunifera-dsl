/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import java.math.BigInteger;

/**
 * @author mark.christiaens - Initial contribution and API
 */
public interface IReadWriteLockedCacheIndex extends IReadLockedCacheIndex {
	public void remove(BigInteger digest);

	public void add(ICacheEntry entry);
}

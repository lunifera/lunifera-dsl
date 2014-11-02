/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import org.eclipse.xtext.util.concurrent.IReadAccess;
import org.eclipse.xtext.util.concurrent.IWriteAccess;

/**
 * @author Mark Christiaens - Initial contribution
 * 
 * @since 2.1
 */

public interface ICacheIndex extends IReadAccess<IReadLockedCacheIndex>, IWriteAccess<IReadWriteLockedCacheIndex> {
	/**
	 * Create an immutable ICacheEntry object corresponding to the provided digest. This ICacheEntry contains a
	 * reference to the actual ICacheIndex that created it. This factory function does not add the entry to the cache
	 * yet.
	 * 
	 * @param digestInfo
	 *            Digest info used to index into the cache.
	 * 
	 * @return ICacheEntry corresponding to the digestInfo
	 */
	public ICacheEntry createNewEntry(DigestInfo digestInfo);

	public int getVersion();
}
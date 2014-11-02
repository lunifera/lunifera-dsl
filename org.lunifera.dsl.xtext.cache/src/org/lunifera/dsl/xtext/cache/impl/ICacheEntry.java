/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

/**
 * @author Mark Christiaens - Initial contribution
 * 
 * @since 2.3
 */

public interface ICacheEntry {
	public BigInteger getDigest();

	public int getVersion();

	public long getOrigContentSize();

	public long getCreationTime();

	public long getLastUsageTime();

	public void updateUsageTime();

	/* Relative paths into which files are stored (exclusively).  The absolute 
	 * path is obtained by combining this relative path with the absolute path provided
	 * by the cache*/

	public File getRelativeCacheEntryDirPath();

	public File getRelativeEMFFilePath();

	public File getRelativeNodeModelFilePath();

	public void write(DataOutputStream out) throws IOException;
}
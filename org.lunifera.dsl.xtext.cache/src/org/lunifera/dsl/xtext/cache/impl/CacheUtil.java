/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.zip.GZIPOutputStream;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark Christiaens - Initial contribution
 * 
 * @since 2.3
 */

public class CacheUtil {
	public static final int KIB = 1024;
	public static final int MIB = 1024 * KIB;
	public static final int GIB = 1024 * MIB;
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(CacheUtil.class);

	static public void deleteFileOrDirectory(File fileOrDir) throws IOException {
		if (fileOrDir.exists()) {
			if (fileOrDir.isDirectory()) {
				File[] files = fileOrDir.listFiles();
				for (File file : files) {
					deleteFileOrDirectory(file);
				}
			}

			boolean deleted = fileOrDir.delete();

			if (!deleted) {
				throw new IOException("Could not delete directory: " + fileOrDir.toString());
			}
		}
	}

	static public void mkdir(File dir) throws IOException {
		if (!dir.mkdir()) {
			throw new IOException("Could not create directory: " + dir.toString());
		}
	}

	public static class AgeComparator implements Comparator<ICacheEntry> {
		public static final AgeComparator AGE_COMPARATOR = new AgeComparator();

		public int compare(ICacheEntry o1, ICacheEntry o2) {
			if (o1 != null && o2 != null) {
				long time1 = o1.getLastUsageTime();
				long time2 = o2.getLastUsageTime();

				return Long.signum(time1 - time2);
			}

			throw new IllegalArgumentException("Comparing null ICacheEntries");
		}
	}

	public static DigestInfo calcDigestInfo(InputStream in, String encoding) throws IOException {
		final String DIGEST_ALGORITHM = "MD5";
		MessageDigest md = null;
		long totalBytesRead = 0;

		try {
			md = MessageDigest.getInstance(DIGEST_ALGORITHM);
			byte[] buffer = new byte[128 * 1024];

			int bytesRead = in.read(buffer);

			while (bytesRead != -1) {
				md.update(buffer, 0, bytesRead);
				totalBytesRead += bytesRead;
				bytesRead = in.read(buffer);
			}

			md.update(encoding.getBytes());

			return new DigestInfo(new BigInteger(1, md.digest()), totalBytesRead);
		} catch (NoSuchAlgorithmException e) {
			/* Should be impossible */
			e.printStackTrace();
			return null;
		}
	}

	public static void tryClose(Closeable stream, Logger logger) throws IOException {
		if (stream != null) {
			try {
				stream.close();
			} catch (Exception e) {
				if (logger != null) {
					logger.error("Could not close an stream for a cache entry: " + e, e);
				}
			}
		}
	}

	public static void write(ICacheIndex index, final File indexLocation, final Logger logger) throws IOException {
		IUnitOfWork<Object, IReadLockedCacheIndex> writeEntryWork = new IUnitOfWork<Object, IReadLockedCacheIndex>() {
			public Object exec(IReadLockedCacheIndex rlIndex) throws Exception {
				DataOutputStream dos = null;
				try {
					if (indexLocation.exists()) {
						deleteFileOrDirectory(indexLocation);
					}

					dos = CacheUtil.getIndexStream(indexLocation, logger);

					rlIndex.write(dos);

				} finally {
					tryClose(dos, logger);
				}

				return null;
			}
		};

		try {
			index.readOnly(writeEntryWork);
		} catch (WrappedException e) {
			if (e.exception() instanceof IOException) {
				throw (IOException) e.exception();
			}

			throw e;
		}
	}

	private static DataOutputStream getIndexStream(File indexLocation, Logger logger) throws FileNotFoundException,
			IOException {
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(indexLocation);
			GZIPOutputStream gos = new GZIPOutputStream(fos, 8192);
			DataOutputStream dos = new DataOutputStream(gos);
			return dos;
		} catch (IOException e) {
			tryClose(fos, logger);
			throw e;
		}
	}
}

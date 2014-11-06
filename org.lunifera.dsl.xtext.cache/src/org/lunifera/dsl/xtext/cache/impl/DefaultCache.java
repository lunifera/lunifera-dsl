/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import static org.lunifera.dsl.xtext.cache.impl.CacheUtil.calcDigestInfo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.serialization.SerializationUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.lunifera.dsl.xtext.cache.nodemodel.DefaultSerializationService.SerializeVetoException;
import org.lunifera.dsl.xtext.cache.nodemodel.ISerializationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * @author Mark Christiaens - Initial contribution
 * 
 * @since 2.3
 */

public class DefaultCache implements ICache {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DefaultCache.class);

	private ICacheIndex index;
	private final ISerializationService serializationService;
	private final IReplacementStrategy replacementStrategy;

	/** Directory into which the entire cache will live */
	private File cacheLocation;

	@Inject
	public DefaultCache(ISerializationService serializationService,
			IReplacementStrategy replacementStrategy) {
		this.serializationService = serializationService;
		this.replacementStrategy = replacementStrategy;
	}

	public ICacheEntry load(XtextResource xr, byte[] content, String encoding,
			boolean requireNodeModel) throws IOException {
		checkProperlyInitialized();

		try {
			return loadResourceFromCache(xr, content, encoding,
					requireNodeModel);
		} catch (IOException e) {
			LOGGER.error("Could not load " + xr.getURI()
					+ " from cache: clearing resource cache", e);
			try {
				clear();
				return null;
			} catch (IOException ee) {
				LOGGER.error("Could not clear resource cache", e);
				throw ee;
			}
		}
	}

	protected void checkProperlyInitialized() {
		if (cacheLocation == null) {
			throw new IllegalStateException(
					"The cache's location has not yet been configured.");
		}
	}

	public ICacheEntry add(final XtextResource xr, byte[] content,
			String encoding) throws IOException {
		checkProperlyInitialized();

		if (xr == null) {
			LOGGER.error("Received a null resource to add to cache");
			return null;
		}

		if (!xr.isLoaded()) {
			LOGGER.error("Ignoring request to add a a resource to the cache but the resource is not yet loaded: "
					+ xr.getURI());
			return null;
		}

		if (xr.getParseResult().getRootNode() == null) {
			LOGGER.error("Unable to add resource with uri: " + xr.getURI()
					+ " since it has no node model");
		}

		final DigestInfo digestInfo = CacheUtil.calcDigestInfo(
				new ByteArrayInputStream(content), encoding);

		IUnitOfWork<ICacheEntry, IReadWriteLockedCacheIndex> addEntryWork = new IUnitOfWork<ICacheEntry, IReadWriteLockedCacheIndex>() {
			public ICacheEntry exec(IReadWriteLockedCacheIndex rwlIndex)
					throws Exception {
				ICacheEntry temp = rwlIndex.get(digestInfo.getDigest());
				if (temp != null) {
					return temp;
				}

				ICacheEntry cacheEntry = rwlIndex.createNewEntry(digestInfo);
				try {
					if (replacementStrategy.canFit(cacheEntry)) {
						ImmutableList<ICacheEntry> toRemove = replacementStrategy
								.selectReplacementCandidates(index, cacheEntry);
						removeEntries(rwlIndex, toRemove);
						writeEntryContent(xr, cacheEntry);
						rwlIndex.add(cacheEntry);
						CacheUtil.write(rwlIndex, getIndexFile(), LOGGER);
					}
				} catch (Exception e) {
					CacheUtil.deleteFileOrDirectory(getEntryDir(cacheEntry));
					rwlIndex.remove(cacheEntry.getDigest());
					LOGGER.error("Could not add an entry to the cache: " + e);
					throw e;
				}

				return cacheEntry;
			}
		};

		return index.modify(addEntryWork);
	}

	@Override
	public ICacheEntry addDerivedState(final XtextResource xr,
			final ICacheEntry cacheEntry) throws IOException {

		checkProperlyInitialized();

		if (xr == null) {
			LOGGER.error("Received a null resource to add to cache");
			return null;
		}

		if (!xr.isLoaded()) {
			LOGGER.error("Ignoring request to add a a resource to the cache but the resource is not yet loaded: "
					+ xr.getURI());
			return null;
		}

		if (cacheEntry == null) {
			LOGGER.error("Unable to add resource with uri: " + xr.getURI()
					+ " since it has no node model");
		}

		IUnitOfWork<ICacheEntry, IReadWriteLockedCacheIndex> addEntryWork = new IUnitOfWork<ICacheEntry, IReadWriteLockedCacheIndex>() {
			public ICacheEntry exec(IReadWriteLockedCacheIndex rwlIndex)
					throws Exception {
				try {
					if (replacementStrategy.canFit(cacheEntry)) {
						ImmutableList<ICacheEntry> toRemove = replacementStrategy
								.selectReplacementCandidates(index, cacheEntry);
						removeEntries(rwlIndex, toRemove);
						writeDSEntryContent(xr, cacheEntry);
						rwlIndex.add(cacheEntry);
						CacheUtil.write(rwlIndex, getIndexFile(), LOGGER);
					}
				} catch (Exception e) {
					CacheUtil.deleteFileOrDirectory(getEntryDir(cacheEntry));
					rwlIndex.remove(cacheEntry.getDigest());
					LOGGER.error("Could not add an entry to the cache: " + e);
					throw e;
				}

				return cacheEntry;
			}
		};

		return index.modify(addEntryWork);
	}

	public void clear() throws IOException {
		checkProperlyInitialized();

		LOGGER.info("Clearing resource cache");

		CacheUtil.deleteFileOrDirectory(cacheLocation);
		CacheUtil.mkdir(cacheLocation);
		CacheUtil.mkdir(getContentDirectory());
		index = new DefaultCacheIndex();
		CacheUtil.write(index, getIndexFile(), LOGGER);
	}

	public void init(File cacheLocation) throws IOException {
		this.cacheLocation = cacheLocation;

		try {
			readData();
		} catch (Throwable e) {
			clear();
		}
	}

	protected void readData() throws IOException {
		DataInputStream dis = null;
		try {
			dis = getIndexStream();
			index = DefaultCacheIndex.read(dis);
		} finally {
			CacheUtil.tryClose(dis, DefaultCache.LOGGER);
		}

		if (!getContentDirectory().exists()) {
			throw new IOException(
					"There is no content directory for the model cache");
		}
	}

	protected DataInputStream getIndexStream() throws FileNotFoundException,
			IOException {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(getIndexFile());
			GZIPInputStream gis = new GZIPInputStream(fis, 8192);
			DataInputStream dis = new DataInputStream(gis);

			return dis;
		} catch (IOException e) {
			CacheUtil.tryClose(fis, LOGGER);
			throw e;
		}
	}

	protected File getContentDirectory() {
		return new File(cacheLocation, "content");
	}

	protected File getIndexFile() {
		return new File(cacheLocation, "index.ser");
	}

	protected ICacheEntry loadResourceFromCache(final XtextResource xr,
			final byte[] content, final String encoding,
			final boolean requireNodeModel) throws IOException {
		final DigestInfo digestInfo = calcDigestInfo(new ByteArrayInputStream(
				content), encoding);

		IUnitOfWork<ICacheEntry, IReadLockedCacheIndex> loadResourceWork = new IUnitOfWork<ICacheEntry, IReadLockedCacheIndex>() {
			@SuppressWarnings("restriction")
			public ICacheEntry exec(IReadLockedCacheIndex rlIndex)
					throws Exception {
				ICacheEntry cacheEntry = rlIndex.get(digestInfo.getDigest());
				if (cacheEntry != null) {
					ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
							content);
					String completeContent = SerializationUtil
							.getCompleteContent(encoding, byteArrayInputStream);

					handleHit(xr, cacheEntry, completeContent, requireNodeModel);
				}
				return cacheEntry;
			}
		};

		return index.readOnly(loadResourceWork);
	}

	private void removeEntries(IReadWriteLockedCacheIndex rwlIndex,
			ImmutableList<ICacheEntry> toRemove) throws IOException {
		for (ICacheEntry entry : toRemove) {
			LOGGER.info("Removing entry for digest " + entry.getDigest());
			rwlIndex.remove(entry.getDigest());
			CacheUtil.deleteFileOrDirectory(getEntryDir(entry));
		}
	}

	protected void writeEntryContent(XtextResource resource,
			final ICacheEntry cacheEntry) throws IOException,
			FileNotFoundException, SerializeVetoException {
		File entryDir = getEntryDir(cacheEntry);
		File emfFile = getEMFFile(cacheEntry);
		File nodeModelFile = getNodeModelFile(cacheEntry);

		CacheUtil.deleteFileOrDirectory(entryDir);
		CacheUtil.mkdir(entryDir);

		OutputStream emfOut = null;
		OutputStream nodeOut = null;

		try {
			emfOut = getOutputStream(emfFile);
			nodeOut = getOutputStream(nodeModelFile);

			serializationService.write(resource, emfOut, nodeOut);

		} finally {
			CacheUtil.tryClose(emfOut, LOGGER);
			CacheUtil.tryClose(nodeOut, LOGGER);
		}
	}

	protected void writeDSEntryContent(XtextResource resource,
			final ICacheEntry cacheEntry) throws IOException,
			FileNotFoundException, SerializeVetoException {
		File entryDir = getEntryDir(cacheEntry);
		File dsFile = getDSFile(cacheEntry);

		try {
			CacheUtil.mkdir(entryDir);
		} catch (Exception e) {
		}

		OutputStream dsOut = null;

		try {
			dsOut = getOutputStream(dsFile);

			serializationService.writeDerivedState(resource, dsOut);
		} finally {
			CacheUtil.tryClose(dsOut, LOGGER);
		}
	}

	protected OutputStream getOutputStream(File emfFile) throws IOException {
		final FileOutputStream out = new FileOutputStream(emfFile);

		try {
			return new GZIPOutputStream(out, 8192);
		} catch (IOException e) {
			out.close();
			throw e;
		}
	}

	protected File getNodeModelFile(ICacheEntry cacheEntry) {
		return combinePaths(getContentDirectory(),
				cacheEntry.getRelativeNodeModelFilePath());
	}

	protected File getEMFFile(ICacheEntry cacheEntry) {
		return combinePaths(getContentDirectory(),
				cacheEntry.getRelativeEMFFilePath());
	}

	protected File getDSFile(ICacheEntry cacheEntry) {
		return combinePaths(getContentDirectory(),
				cacheEntry.getRelativeDSFilePath());
	}

	protected File getEntryDir(ICacheEntry cacheEntry) {
		return combinePaths(getContentDirectory(),
				cacheEntry.getRelativeCacheEntryDirPath());
	}

	protected XtextResource handleHit(XtextResource xr, ICacheEntry cacheEntry,
			String completeContent, boolean requireNodeModel)
			throws IOException {
		return loadResource(xr, cacheEntry, completeContent, requireNodeModel);
	}

	protected XtextResource loadResource(XtextResource xr,
			ICacheEntry cacheEntry, String completeContent,
			boolean requireNodeModel) throws IOException {
		File emfFile = getEMFFile(cacheEntry);
		File nodeFile = getNodeModelFile(cacheEntry);

		InputStream emfIn = null;
		InputStream nodeIn = null;

		try {
			emfIn = getInputStream(emfFile);
			nodeIn = requireNodeModel ? getInputStream(nodeFile) : null;

			XtextResource resource = serializationService.loadResource(xr,
					emfIn, nodeIn, completeContent);

			return resource;
		} finally {
			CacheUtil.tryClose(emfIn, LOGGER);
			CacheUtil.tryClose(nodeIn, LOGGER);
		}
	}

	public XtextResource loadDS(XtextResource xr, ICacheEntry cacheEntry,
			String completeContent, boolean requireNodeModel)
			throws IOException {
		File dsFile = getDSFile(cacheEntry);

		InputStream dsIn = null;

		try {
			dsIn = getInputStream(dsFile);

			XtextResource resource = serializationService.loadDerivedState(xr,
					dsIn, completeContent);

			return resource;
		} catch (IOException e) {
			LOGGER.error("Could not load " + xr.getURI()
					+ " from cache: clearing resource cache");
		}
		return xr;
	}

	protected InputStream getInputStream(File emfFile) throws IOException {
		return new GZIPInputStream(new FileInputStream(emfFile), 8192);
	}

	static public File combinePaths(File absolutePath, File relativePath) {
		return new File(absolutePath, relativePath.getPath());
	}

}

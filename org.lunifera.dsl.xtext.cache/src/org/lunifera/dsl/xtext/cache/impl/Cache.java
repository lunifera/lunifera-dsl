package org.lunifera.dsl.xtext.cache.impl;

import java.io.File;
import java.io.IOException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Cache extends ReadWriteLockedCache {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ReadWriteLockedCache.class);

	@Inject
	public Cache(DefaultCache delegate) {
		super(initDelegate(delegate));
	}

	private static ICache initDelegate(DefaultCache delegate) {
		try {
			final File cacheLocation = calcCacheLocation(getBundle());

			if (cacheLocation == null) {
				throw new IOException(
						"Could not establish the location for the resource cache");
			}

			delegate.init(cacheLocation);
		} catch (IOException e) {
			LOGGER.error("Could not initialize the resource cache", e);
			return new AlwaysMissCache();
		}

		return delegate;
	}

	private static Bundle getBundle() {
		return FrameworkUtil.getBundle(Cache.class);
	}

	public static File calcCacheLocation(Bundle bundle) {
		String cacheBasePath = calcCacheBasePath();

		if (cacheBasePath == null || cacheBasePath.equals("")) {
			return null;
		}

		Version version = bundle.getVersion();
		String versionString = version.toString();
		String cacheLocation = cacheBasePath + versionString;

		return bundle.getDataFile(cacheLocation);
	}

	public static String calcCacheBasePath() {
		return "resource.cache";
	}
}

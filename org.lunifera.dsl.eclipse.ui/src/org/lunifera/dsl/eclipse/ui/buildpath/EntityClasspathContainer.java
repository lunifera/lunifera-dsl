/*******************************************************************************
 * Copyright (c) 2011, 2014 Lunifera GmbH (Austria) and Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Florian Pirchner - copied source from Xtend and adjusted to EntityDSL
 * 
 * Original source from org.eclipse.xtend.ide.buildpath.XtendsClasspathContainer
 * 
 *******************************************************************************/
package org.lunifera.dsl.eclipse.ui.buildpath;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final public class EntityClasspathContainer implements IClasspathContainer {

	private static final String XTEXT_XBASE_LIB_BUNDLE_ID = "org.eclipse.xtext.xbase.lib";
	private static final String XTEND_LIB_BUNDLE_ID = "org.eclipse.xtend.lib";
	private static final String PERSISTENCE_BUNDLE_ID = "javax.persistence";
	private static final String DATATYPES_BUNDLE_ID = "org.lunifera.dsl.datatype.lib";
	private static final String DTO_BUNDLE_ID = "org.lunifera.dsl.dto.lib";
	private static final String UI_GRAMMAR_BUNDLE_ID = "org.lunifera.ecview.dsl.lib";
	private static final String RUNTIME_COMMON_BUNDLE_ID = "org.lunifera.runtime.common";
	private static final String ECVIEW_COMMON_BUNDLE_ID = "org.lunifera.ecview.core.common";
	private static final String OSGI_SERVICES_BUNDLE_ID = "org.eclipse.osgi.services";
	private static final String OSGI_BUNDLE_ID = "org.eclipse.osgi";
	private static final String SLF4J_API = "org.slf4j.api";

	public static final String[] BUNDLE_IDS_TO_INCLUDE = new String[] {
			"com.google.guava", XTEXT_XBASE_LIB_BUNDLE_ID, XTEND_LIB_BUNDLE_ID,
			PERSISTENCE_BUNDLE_ID, OSGI_BUNDLE_ID, OSGI_SERVICES_BUNDLE_ID,
			DATATYPES_BUNDLE_ID, DTO_BUNDLE_ID, ECVIEW_COMMON_BUNDLE_ID,
			UI_GRAMMAR_BUNDLE_ID, RUNTIME_COMMON_BUNDLE_ID, SLF4J_API };

	private static final String SOURCE_SUFIX = ".source"; //$NON-NLS-1$
	private static final Logger LOG = LoggerFactory
			.getLogger(EntityClasspathContainer.class);

	private final IPath containerPath;
	private IClasspathEntry[] classPathEnries;

	EntityClasspathContainer(IPath containerPath) {
		this.containerPath = containerPath;
	}

	/**
	 * {@inheritDoc}
	 */
	public IClasspathEntry[] getClasspathEntries() {
		if (classPathEnries == null) {
			List<IClasspathEntry> cpEntries = new ArrayList<IClasspathEntry>();
			for (String bundleId : EntityClasspathContainer.BUNDLE_IDS_TO_INCLUDE) {
				addEntry(cpEntries, bundleId);
			}
			classPathEnries = cpEntries.toArray(new IClasspathEntry[] {});
		}
		return classPathEnries;
	}

	private void addEntry(final List<IClasspathEntry> cpEntries,
			final String bundleId) {
		Bundle bundle = Platform.getBundle(bundleId);
		if (bundle != null) {
			IPath bundlePath = bundlePath(bundle);
			IPath sourceBundlePath = calculateSourceBundlePath(bundle,
					bundlePath);
			IClasspathAttribute[] extraAttributes = null;

			cpEntries.add(JavaCore.newLibraryEntry(bundlePath,
					sourceBundlePath, null, new IAccessRule[] {},
					extraAttributes, false));
		}
	}

	private IPath bundlePath(Bundle bundle) {
		IPath path = binFolderPath(bundle);
		if (path == null) {
			// common jar file case, no bin folder
			try {
				path = new Path(FileLocator.getBundleFile(bundle)
						.getAbsolutePath());
			} catch (IOException e) {
				LOG.error(
						"Can't resolve path '" + bundle.getSymbolicName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return path;

	}

	private IPath binFolderPath(Bundle bundle) {
		URL binFolderURL = FileLocator.find(bundle, new Path("bin"), null);
		if (binFolderURL != null) {
			try {
				URL binFolderFileURL = FileLocator.toFileURL(binFolderURL);
				return new Path(binFolderFileURL.getPath()).makeAbsolute();
			} catch (IOException e) {
				LOG.error(
						"Can't resolve path '" + bundle.getSymbolicName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return null;
	}

	/**
	 * <p>
	 * We can't use P2Utils and we can't use SimpleConfiguratorManipulator
	 * because of API breakage between 3.5 and 4.2. So we do a bit EDV (Computer
	 * data processing) ;-)
	 * </p>
	 */
	private IPath calculateSourceBundlePath(Bundle bundle, IPath bundleLocation) {
		IPath sourcesPath = null;
		// Not an essential functionality, make it robust
		try {
			IPath binFolderPath = binFolderPath(bundle);
			if (binFolderPath == null) {
				// common case, jar file.
				IPath bundlesParentFolder = bundleLocation
						.removeLastSegments(1);
				String binaryJarName = bundleLocation.lastSegment();
				String symbolicName = bundle.getSymbolicName();
				String sourceJarName = binaryJarName.replace(symbolicName,
						symbolicName.concat(SOURCE_SUFIX));
				IPath potentialSourceJar = bundlesParentFolder
						.append(sourceJarName);
				if (potentialSourceJar.toFile().exists())
					sourcesPath = potentialSourceJar;
			} else {
				sourcesPath = binFolderPath.removeLastSegments(1);
			}
		} catch (Throwable t) {
			LOG.debug("Exception during source bundle inverstigation.", t);
		}
		return sourcesPath;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return "Lunifera modeling container";
	}

	/**
	 * {@inheritDoc}
	 */
	public int getKind() {
		return IClasspathContainer.K_APPLICATION;
	}

	/**
	 * {@inheritDoc}
	 */
	public IPath getPath() {
		return containerPath;
	}
}
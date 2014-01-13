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
 * Original source from org.eclipse.xtend.ide.buildpath.XtendsContainerInitializer
 * 
 *******************************************************************************/
package org.lunifera.dsl.eclipse.ui.buildpath;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

public class EntityContainerInitializer extends ClasspathContainerInitializer {

	public static final Path ENTITY_LIBRARY_PATH = new Path("org.lunifera.dsl.entity.ENTITY_CONTAINER"); //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(final IPath containerPath, final IJavaProject project) throws CoreException {
		if (isEntityPath(containerPath)) {
			IClasspathContainer container = new EntityClasspathContainer(containerPath);
			JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
					new IClasspathContainer[] { container }, null);
		}
	}

	/**
	 * Allows users to manually add source bundles
	 */
	@Override
	public boolean canUpdateClasspathContainer(IPath containerPath, IJavaProject project) {
		return true;
	}

	@Override
	public void requestClasspathContainerUpdate(final IPath containerPath, final IJavaProject project,
			final IClasspathContainer containerSuggestion) throws CoreException {
		super.requestClasspathContainerUpdate(containerPath, project, containerSuggestion);
		new Job("Classpath container update") { //$NON-NLS-1$
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
							new IClasspathContainer[] { containerSuggestion }, null);
				} catch (CoreException ex) {
					return new Status(IStatus.ERROR, "org.lunifera.dsl.entity.xtext", 0,
							"Classpath container update failed", ex); //$NON-NLS-1$
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	private boolean isEntityPath(final IPath containerPath) {
		return ENTITY_LIBRARY_PATH.equals(containerPath);
	}

}

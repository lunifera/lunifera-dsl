/*******************************************************************************
 * Copyright (c) 2011, 2014 Cristiano Gavião (Brazil), Loetz KG (Heidelberg).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cristiano Gavião - initial API and implementation
 *******************************************************************************/
package org.lunifera.dsl.eclipse.ui.utils;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.ui.util.PluginProjectFactory;

public class LuniferaBundleProjectFactory extends PluginProjectFactory {

	public LuniferaBundleProjectFactory() {
	}

	protected void createBuildProperties(IProject project,
			IProgressMonitor progressMonitor) {
		final StringBuilder content = new StringBuilder("source.. = ");
		for (final Iterator<String> iterator = folders.iterator(); iterator
				.hasNext();) {
			content.append(iterator.next()).append('/');
			if (iterator.hasNext()) {
				content.append(",\\\n");
				// source.. =
				content.append("          ");
			}
		}
		content.append("\n");
		content.append("bin.includes = META-INF/,\\\n");
		content.append("               .\n");

		createFile("build.properties", project, content.toString(),
				progressMonitor);
	}

}

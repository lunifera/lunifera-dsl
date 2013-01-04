/*******************************************************************************
 * Copyright (c) 2011, 2012 Cristiano Gavião - Lunifera.org.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cristiano Gavião - initial API and implementation
 *******************************************************************************/
package org.lunifera.dsl.eclipse.ui.wizards;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator;
import org.lunifera.dsl.eclipse.ui.utils.LuniferaBundleProjectFactory;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class LuniferaCommonProjectCreator extends AbstractPluginProjectCreator {

	protected static final String SRC_ROOT = "src";
	protected static final String SRC_GEN_ROOT = "src-gen";
	protected final List<String> SRC_FOLDER_LIST = ImmutableList.of(SRC_ROOT,
			SRC_GEN_ROOT);

	@Inject
	private Provider<LuniferaBundleProjectFactory> projectFactoryProvider;

	@Override
	protected ProjectFactory configureProjectFactory(ProjectFactory factory) {
		LuniferaBundleProjectFactory result = (LuniferaBundleProjectFactory) super
				.configureProjectFactory(factory);

		result.addRequiredBundles(getRequiredBundles());
		result.addExportedPackages(getExportedPackages());
		result.addImportedPackages(getImportedPackages());
		result.setActivatorClassName(getActivatorClassName());

		return result;
	}

	@Override
	protected PluginProjectFactory createProjectFactory() {
		return projectFactoryProvider.get();
	}

	protected void enhanceProject(final IProject project,
			final IProgressMonitor monitor) throws CoreException {
		OutputImpl output = new OutputImpl();
		output.addOutlet(new Outlet(false, getEncoding(), null, true, project
				.getLocation().makeAbsolute().toOSString()));

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(
				output, null);
		execCtx.getResourceManager().setFileEncoding("UTF-8");
		execCtx.registerMetaModel(new JavaBeansMetaModel());

		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate(
				"org::lunifera::eclipse::ui::wizards::LuniferaNewProject::main",
				getProjectInfo());

		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

	@Override
	protected List<String> getAllFolders() {
		return SRC_FOLDER_LIST;
	}

	protected String getModelFolderName() {
		return SRC_ROOT;
	}

	@Override
	protected LuniferaMainProjectInfo getProjectInfo() {
		return (LuniferaMainProjectInfo) super.getProjectInfo();
	}

}
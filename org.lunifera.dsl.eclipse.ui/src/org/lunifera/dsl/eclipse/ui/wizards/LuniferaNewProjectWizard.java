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

import org.eclipse.ui.INewWizard;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;

import com.google.inject.Inject;

public class LuniferaNewProjectWizard extends XtextNewProjectWizard implements
		INewWizard {

	private WizardNewProjectCreationPage mainPage;

	@Inject
	public LuniferaNewProjectWizard(IProjectCreator projectCreator) {
		super(projectCreator);
		setWindowTitle("New Lunifera Project");
	}

	/**
	 * Use this method to add pages to the wizard. The one-time generated
	 * version of this class will add a default new project page to the wizard.
	 */
	public void addPages() {
		mainPage = new WizardNewProjectCreationPage("basicNewProjectPage");
		mainPage.setTitle("Lunifera Modeling Project");
		mainPage.setDescription("Create a new Lunifera modeling project.");
		addPage(mainPage);
	}

	/**
	 * Use this method to read the project settings from the wizard pages and
	 * feed them into the project info class.
	 */
	@Override
	protected IProjectInfo getProjectInfo() {
		LuniferaMainProjectInfo projectInfo = new LuniferaMainProjectInfo();
		projectInfo.setProjectName(mainPage.getProjectName());
		return projectInfo;
	}

}

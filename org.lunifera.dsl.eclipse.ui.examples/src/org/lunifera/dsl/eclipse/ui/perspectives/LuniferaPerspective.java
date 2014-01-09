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
package org.lunifera.dsl.eclipse.ui.perspectives;

import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

/**
 * This class is meant to serve as an example for how various contributions are
 * made to a perspective. Note that some of the extension point id's are
 * referred to as API constants while others are hardcoded and may be subject to
 * change.
 */
public class LuniferaPerspective implements IPerspectiveFactory {

	private IPageLayout pageLayout;

	public LuniferaPerspective() {
		super();
	}

	public void createInitialLayout(IPageLayout layout) {
		this.pageLayout = layout;
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		addViews();
		addActionSets();
		addNewWizardShortcuts();
		addPerspectiveShortcuts();
		addViewShortcuts();
		layout.addStandaloneView("example.view", true /* show title */,
				IPageLayout.LEFT, 1.0f, editorArea);
	}

	private void addViews() {
		// Creates the overall folder layout.
		// Note that each new Folder uses a percentage of the remaining
		// EditorArea.

		IFolderLayout bottom = pageLayout.createFolder("bottomRight", // NON-NLS-1
				IPageLayout.BOTTOM, 0.75f, pageLayout.getEditorArea());
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottom.addView("org.eclipse.team.ui.GenericHistoryView"); // NON-NLS-1
		bottom.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);

		IFolderLayout topLeft = pageLayout.createFolder("topLeft", // NON-NLS-1
				IPageLayout.LEFT, 0.25f, pageLayout.getEditorArea());
		topLeft.addView("org.eclipse.jdt.junit.ResultView"); // NON-NLS-1

		pageLayout.addFastView("org.eclipse.team.ccvs.ui.RepositoriesView", 0.50f); // NON-NLS-1
		pageLayout.addFastView("org.eclipse.team.sync.views.SynchronizeView",
				0.50f); // NON-NLS-1
	}

	private void addActionSets() {
		pageLayout.addActionSet("org.eclipse.debug.ui.launchActionSet"); // NON-NLS-1
		pageLayout.addActionSet("org.eclipse.debug.ui.debugActionSet"); // NON-NLS-1
		pageLayout.addActionSet("org.eclipse.debug.ui.profileActionSet"); // NON-NLS-1
		pageLayout.addActionSet("org.eclipse.jdt.debug.ui.JDTDebugActionSet"); // NON-NLS-1
		pageLayout.addActionSet("org.eclipse.jdt.junit.JUnitActionSet"); // NON-NLS-1
		pageLayout.addActionSet("org.eclipse.team.ui.actionSet"); // NON-NLS-1
		pageLayout.addActionSet("org.eclipse.team.cvs.ui.CVSActionSet"); // NON-NLS-1
		pageLayout.addActionSet("org.eclipse.ant.ui.actionSet.presentation"); // NON-NLS-1
		pageLayout.addActionSet(JavaUI.ID_ACTION_SET);
		pageLayout.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
		pageLayout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET); // NON-NLS-1
	}

	private void addPerspectiveShortcuts() {
		pageLayout.addPerspectiveShortcut("org.eclipse.team.ui.TeamSynchronizingPerspective"); // NON-NLS-1
		pageLayout.addPerspectiveShortcut("org.eclipse.team.cvs.ui.cvsPerspective"); // NON-NLS-1
		pageLayout.addPerspectiveShortcut("org.eclipse.ui.resourcePerspective"); // NON-NLS-1
	}

	private void addNewWizardShortcuts() {
		pageLayout.addNewWizardShortcut("org.eclipse.team.cvs.ui.newProjectCheckout");// NON-NLS-1
		pageLayout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");// NON-NLS-1
		pageLayout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");// NON-NLS-1
	}

	private void addViewShortcuts() {
		pageLayout.addShowViewShortcut("org.eclipse.ant.ui.views.AntView"); // NON-NLS-1
		pageLayout.addShowViewShortcut("org.eclipse.team.ccvs.ui.AnnotateView"); // NON-NLS-1
		pageLayout.addShowViewShortcut("org.eclipse.pde.ui.DependenciesView"); // NON-NLS-1
		pageLayout.addShowViewShortcut("org.eclipse.jdt.junit.ResultView"); // NON-NLS-1
		pageLayout.addShowViewShortcut("org.eclipse.team.ui.GenericHistoryView"); // NON-NLS-1
		pageLayout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);
		pageLayout.addShowViewShortcut(JavaUI.ID_PACKAGES);
		pageLayout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		pageLayout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
	}

}

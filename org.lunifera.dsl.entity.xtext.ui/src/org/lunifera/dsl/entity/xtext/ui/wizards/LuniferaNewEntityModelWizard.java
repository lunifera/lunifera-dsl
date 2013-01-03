package org.lunifera.dsl.entity.xtext.ui.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.DialogUtil;
import org.eclipse.ui.internal.wizards.newresource.ResourceMessages;
import org.eclipse.ui.wizards.newresource.BasicNewFileResourceWizard;


@SuppressWarnings("restriction")
public class LuniferaNewEntityModelWizard extends BasicNewFileResourceWizard {
	private LuniferaNewEntityModelWizardPage mainPage;

	public LuniferaNewEntityModelWizard() {
		super();
	}

	public void addPages() {
		mainPage = new LuniferaNewEntityModelWizardPage(getSelection());
		addPage(mainPage);
	}
	
	public boolean canFinish() {
		boolean result = super.canFinish();

		if (result) {
			final String containerName = mainPage.getContainerFullPath().toString();
			final String fileName = mainPage.getFileName();

			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IResource resource = root.findMember(new Path(containerName));
			if (!resource.exists() || !(resource instanceof IContainer)) {
				result = false;
			}
			IContainer container = (IContainer) resource;
			final IFile file = container.getFile(new Path(fileName));
			if (file.exists()) {
				result = false;
			}
		}
		return result;
	}

	public boolean performFinish() {
		IFile file = mainPage.createNewFile();
		if (file == null) {
			return false;
		}

		selectAndReveal(file);

		// Open editor on new file.
		IWorkbenchWindow dw = getWorkbench().getActiveWorkbenchWindow();
		try {
			if (dw != null) {
				IWorkbenchPage page = dw.getActivePage();
				if (page != null) {
					IDE.openEditor(page, file, true);
				}
			}
		} catch (PartInitException e) {
			DialogUtil.openError(dw.getShell(),
					ResourceMessages.FileResource_errorMessage, e.getMessage(),
					e);
		}

		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
	}

	protected void initializeDefaultPageImageDescriptor() {
		super.initializeDefaultPageImageDescriptor();
	}
}
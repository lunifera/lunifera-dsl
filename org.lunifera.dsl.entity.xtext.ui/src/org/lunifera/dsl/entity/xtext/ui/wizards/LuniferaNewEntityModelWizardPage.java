package org.lunifera.dsl.entity.xtext.ui.wizards;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.lunifera.dsl.entity.xtext.ui.internal.EntityGrammarActivator;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (organization).
 */
public class LuniferaNewEntityModelWizardPage extends WizardNewFileCreationPage {

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public LuniferaNewEntityModelWizardPage(IStructuredSelection selection) {
		super("Lunifera", selection);
		setTitle("Entity Model File");
		setFileName("new_entity_model");
		setFileExtension("entitymodel");
		setDescription("This wizard creates a new file with *.entityModel extension that can be opened by a multi-page editor.");
	}

	@Override
	protected InputStream getInitialContents() {
		try {
			return EntityGrammarActivator.getInstance().getBundle()
					.getEntry("/resources/initialmodel.entitymodel").openStream();
		} catch (IOException e) {
			return null; // ignore and create empty comments
		}
	}
}
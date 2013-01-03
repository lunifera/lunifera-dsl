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
package org.lunifera.dsl.organization.xtext.ui.hover;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.lunifera.dsl.organization.semantic.model.Organization;
import org.lunifera.dsl.organization.semantic.model.Partnership;
import org.lunifera.dsl.organization.semantic.model.Person;
import org.lunifera.dsl.organization.semantic.model.Worker;

public class OrganizationGrammarEObjectHoverProvider extends
		DefaultEObjectHoverProvider {
	public final static String HTML_TAG_OPEN_BOLD = "<b>";
	public final static String HTML_TAG_CLOSE_BOLD = "</b>";

	public final static String HTML_TAG_NL = "<br>";
	public final static String HTML_TAG_OPEN_ITALIC = "<i>";
	public final static String HTML_TAG_CLOSE_ITALIC = "</i>";
	public final static String HTML_TAG_ULIST_BLOCK_OPEN = "<UL>";
	public final static String HTML_TAG_ULIST_BLOCK_CLOSE = "</UL>";
	public final static String HTML_TAG_ULIST_OPEN_HEADER = "<LH>";
	public final static String HTML_TAG_ULIST_CLOSE_HEADER = "</LH>";
	public final static String HTML_TAG_ULIST_ITEM_OPEN = "<LI>";
	public final static String HTML_TAG_ULIST_ITEM_CLOSE = "</LI>";
	public final static String HTML_TAG_TABLE_BLOCK_OPEN = "<Table>";
	public final static String HTML_TAG_TABLE_BLOCK_CLOSE = "</Table>";
	public final static String HTML_TAG_TABLE_OPEN_HEADER = "<TH>";
	public final static String HTML_TAG_TABLE_CLOSE_HEADER = "</TH>";
	public final static String HTML_TAG_TABLE_ROW_OPEN = "<TR>";
	public final static String HTML_TAG_TABLE_ROW_CLOSE = "</TR>";
	public final static String HTML_TAG_TABLE_COL_OPEN = "<TD>";
	public final static String HTML_TAG_TABLE_COL_CLOSE = "</TD>";
	public final static String HTML_TAG_IMG_OPEN = "<img src=";
	public final static String HTML_TAG_IMG_CLOSE = "/>";
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Override
	protected String getFirstLine(EObject o) {

		String label = qualifiedNameProvider.getFullyQualifiedName(o)
				.toString();

		if (o instanceof Organization) {

			return retrieveHoverFirstLineOrganization((Organization) o, label);
		}

		if (o instanceof Worker) {

			return retrieveHoverFirstLineWorker((Worker) o, label);
		}

		if (o instanceof Person) {

			return retrieveHoverFirstLinePerson((Person) o, label);
		}

		if (o instanceof Partnership) {

			return retrieveHoverFirstLinePartnership((Partnership) o, label);
		}

		return super.getFirstLine(o);
	}

	public String retrieveHoverFirstLineOrganization(Organization o,
			String label) {
		StringBuilder documentation = new StringBuilder();
		documentation.append(HTML_TAG_OPEN_BOLD).append(HTML_TAG_OPEN_ITALIC)
				.append(label).append(HTML_TAG_CLOSE_ITALIC).append(" - ")
				.append(o.getLongName()).append(HTML_TAG_CLOSE_BOLD)
				.append(" :: ");

		if (label != null) {
			documentation.append(HTML_TAG_OPEN_ITALIC)
					.append(o.eClass().getName()).append(HTML_TAG_CLOSE_ITALIC);
		}
		return documentation.toString();
	}

	public String retrieveHoverFirstLineWorker(Worker o, String label) {
		StringBuilder documentation = new StringBuilder();
		documentation.append(HTML_TAG_OPEN_BOLD).append(HTML_TAG_OPEN_ITALIC)
				.append(label).append(HTML_TAG_CLOSE_ITALIC).append(" - ")
				.append(o.getPerson().getFirstName()).append(" ")
				.append(o.getPerson().getLastName())
				.append(HTML_TAG_CLOSE_BOLD).append(" :: ");

		if (label != null) {
			documentation.append(HTML_TAG_OPEN_ITALIC)
					.append(o.eClass().getName()).append(HTML_TAG_CLOSE_ITALIC);
		}
		return documentation.toString();
	}

	public String retrieveHoverFirstLinePartnership(Partnership o, String label) {
		StringBuilder documentation = new StringBuilder();
		documentation.append(HTML_TAG_OPEN_BOLD).append(HTML_TAG_OPEN_ITALIC)
				.append(label).append(HTML_TAG_CLOSE_ITALIC).append(" - ")
				.append(o.getCompany().getLongName())
				.append(HTML_TAG_CLOSE_BOLD).append(" :: ");

		if (label != null) {
			documentation.append(HTML_TAG_OPEN_ITALIC)
					.append(o.eClass().getName()).append(HTML_TAG_CLOSE_ITALIC);
		}
		return documentation.toString();
	}

	public String retrieveHoverFirstLinePerson(Person o, String label) {
		StringBuilder documentation = new StringBuilder();
		documentation.append(HTML_TAG_OPEN_BOLD).append(HTML_TAG_OPEN_ITALIC)
				.append(label).append(HTML_TAG_CLOSE_ITALIC).append(" - ")
				.append(o.getFirstName()).append(" ").append(o.getLastName())
				.append(HTML_TAG_CLOSE_BOLD).append(" :: ");

		if (label != null) {
			documentation.append(HTML_TAG_OPEN_ITALIC)
					.append(o.eClass().getName()).append(HTML_TAG_CLOSE_ITALIC);
		}
		return documentation.toString();
	}
}

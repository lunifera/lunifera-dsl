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
import org.lunifera.dsl.organization.semantic.model.OOrganization;
import org.lunifera.dsl.organization.semantic.model.OPerson;
import org.lunifera.dsl.organization.semantic.model.OWorker;

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

		if (o instanceof OOrganization) {

			return retrieveHoverFirstLineOrganization((OOrganization) o, label);
		}

		if (o instanceof OWorker) {

			return retrieveHoverFirstLineWorker((OWorker) o, label);
		}

		if (o instanceof OPerson) {

			return retrieveHoverFirstLinePerson((OPerson) o, label);
		}

		// if (o instanceof OPartnership) {
		//
		// return retrieveHoverFirstLinePartnership((OPartnership) o, label);
		// }

		return super.getFirstLine(o);
	}

	public String retrieveHoverFirstLineOrganization(OOrganization o,
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

	public String retrieveHoverFirstLineWorker(OWorker o, String label) {
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

	// public String retrieveHoverFirstLinePartnership(OPartnership o, String
	// label) {
	// StringBuilder documentation = new StringBuilder();
	// documentation.append(HTML_TAG_OPEN_BOLD).append(HTML_TAG_OPEN_ITALIC)
	// .append(label).append(HTML_TAG_CLOSE_ITALIC).append(" - ")
	// .append(o.getCompany().getLongName())
	// .append(HTML_TAG_CLOSE_BOLD).append(" :: ");
	//
	// if (label != null) {
	// documentation.append(HTML_TAG_OPEN_ITALIC)
	// .append(o.eClass().getName()).append(HTML_TAG_CLOSE_ITALIC);
	// }
	// return documentation.toString();
	// }

	public String retrieveHoverFirstLinePerson(OPerson o, String label) {
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

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
package org.lunifera.dsl.organization.xtext.naming;

import java.util.List;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.lunifera.dsl.organization.semantic.model.OWorker;
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage;
import org.lunifera.dsl.organization.semantic.model.util.OrganizationUtil;

import com.google.inject.Inject;

public class OrganizationGrammarQualifiedNameProvider extends
		DefaultDeclarativeQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter converter;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private OrganizationUtil util;

	protected QualifiedName qualifiedName(OWorker e) {

		String name = null;

		List<INode> nodes = NodeModelUtils.findNodesForFeature(e,
				OrganizationPackage.Literals.OWORKER__PERSON);

		if (!nodes.isEmpty()) {
			INode first = nodes.get(0);
			name = NodeModelUtils.getTokenText(first);
			QualifiedName qualifiedNameFromConverter = converter
					.toQualifiedName(name);

			if (e.eContainer() != null) {
				QualifiedName parentsQualifiedName = getFullyQualifiedName(e
						.eContainer());
				if (parentsQualifiedName != null) {
					return parentsQualifiedName
							.append(qualifiedNameFromConverter.getLastSegment());
				} else
					return qualifiedNameFromConverter;
			}
		}
		return super.qualifiedName(e);
	}

	// protected QualifiedName qualifiedName(OPartnership e) {
	//
	// String name = null;
	//
	// List<INode> nodes = NodeModelUtils.findNodesForFeature(e,
	// OrganizationPackage.Literals.OPARTNERSHIP__COMPANY);
	//
	// if (!nodes.isEmpty()) {
	// INode first = nodes.get(0);
	// name = NodeModelUtils.getTokenText(first);
	// QualifiedName qualifiedNameFromConverter = converter
	// .toQualifiedName(name);
	//
	// if (e.eContainer() != null) {
	// QualifiedName parentsQualifiedName = getFullyQualifiedName(e
	// .eContainer());
	// if (parentsQualifiedName != null) {
	// return parentsQualifiedName
	// .append(qualifiedNameFromConverter);
	// } else
	// return qualifiedNameFromConverter;
	// }
	// }
	// return super.qualifiedName(e);
	// }

}

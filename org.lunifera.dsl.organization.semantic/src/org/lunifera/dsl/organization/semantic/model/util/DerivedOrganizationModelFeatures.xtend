/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.organization.semantic.model.util

import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.lunifera.dsl.organization.semantic.model.OOrganizationModel
import org.lunifera.dsl.organization.semantic.model.OPersonRole
import org.lunifera.dsl.organization.semantic.model.OUnitRole

class DerivedOrganizationModelFeatures {

	OOrganizationModel model

	new(OOrganizationModel model) {
		this.model = model
	}

	def EList<OPersonRole> getPersonRoles() {
		return new BasicEList(model.businessRoles.filter(typeof(OPersonRole)).toList)
	}

	def EList<OUnitRole> getUnitRoles() {
		return new BasicEList(model.businessRoles.filter(typeof(OUnitRole)).toList)
	}

}

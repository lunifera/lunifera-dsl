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
import org.lunifera.dsl.organization.semantic.model.OGroup
import org.lunifera.dsl.organization.semantic.model.OOrganization
import org.lunifera.dsl.organization.semantic.model.OPartnership
import org.lunifera.dsl.organization.semantic.model.OPerson
import org.lunifera.dsl.organization.semantic.model.OPersonRole
import org.lunifera.dsl.organization.semantic.model.OUnit
import org.lunifera.dsl.organization.semantic.model.OWorker

class DerivedReferenceHelper {
 
	OOrganization organization

	new(OOrganization organization) {
		this.organization = organization
	}

	def EList<OUnit> getOrganizationUnits() {
		return new BasicEList(organization.elements.filter(typeof(OUnit)).toList)
	}

	def EList<OPersonRole> getBusinessRoles() {
		return new BasicEList(organization.elements.filter(typeof(OPersonRole)).toList)
	}

	def EList<OGroup> getGroups() {
		return new BasicEList(organization.elements.filter(typeof(OGroup)).toList)
	}

	def EList<OPartnership> getPartnerships() {
		return new BasicEList(organization.elements.filter(typeof(OPartnership)).toList)
	}

	def EList<OPerson> getPersons() {
		return new BasicEList(organization.elements.filter(typeof(OPerson)).toList)
	}

	def EList<OWorker> getWorkers() {
		return new BasicEList(organization.elements.filter(typeof(OWorker)).toList)
	}

}

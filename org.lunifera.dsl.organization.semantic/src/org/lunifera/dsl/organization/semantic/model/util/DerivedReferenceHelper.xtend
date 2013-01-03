/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.organization.semantic.model.util

import org.eclipse.emf.common.util.EList
import org.lunifera.dsl.organization.semantic.model.BusinessRole
import org.lunifera.dsl.organization.semantic.model.Group
import org.lunifera.dsl.organization.semantic.model.Organization
import org.lunifera.dsl.organization.semantic.model.OrganizationUnit
import org.lunifera.dsl.organization.semantic.model.Partnership
import org.lunifera.dsl.organization.semantic.model.Person
import org.lunifera.dsl.organization.semantic.model.Worker
import org.eclipse.emf.common.util.BasicEList

class DerivedReferenceHelper {

	Organization organization

	new(Organization organization) {
		this.organization = organization
	}

	def EList<OrganizationUnit> getOrganizationUnits() {
		return new BasicEList(organization.elements.filter(typeof(OrganizationUnit)).toList)
	}

	def EList<BusinessRole> getBusinessRoles() {
		return new BasicEList(organization.elements.filter(typeof(BusinessRole)).toList)
	}

	def EList<Group> getGroups() {
		return new BasicEList(organization.elements.filter(typeof(Group)).toList)
	}

	def EList<Partnership> getPartnerships() {
		return new BasicEList(organization.elements.filter(typeof(Partnership)).toList)
	}

	def EList<Person> getPersons() {
		return new BasicEList(organization.elements.filter(typeof(Person)).toList)
	}

	def EList<Worker> getWorkers() {
		return new BasicEList(organization.elements.filter(typeof(Worker)).toList)
	}

}

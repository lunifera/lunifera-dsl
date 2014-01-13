/*******************************************************************************
 * Copyright (c) 2011, 2014 Cristiano Gavião (Brazil), Loetz KG (Heidelberg).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cristiano Gavião - initial API and implementation
 *******************************************************************************/
package org.lunifera.dsl.organization.xtext.tests

import javax.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.lunifera.dsl.organization.semantic.model.BusinessRole
import org.lunifera.dsl.organization.semantic.model.Organization
import org.lunifera.dsl.organization.semantic.model.OrganizationUnit
import org.lunifera.dsl.organization.semantic.model.Partnership
import org.lunifera.dsl.organization.semantic.model.Person
import org.lunifera.dsl.organization.semantic.model.Worker
import org.lunifera.dsl.organization.xtext.OrganizationGrammarInjectorProvider
import org.lunifera.dsl.organization.xtext.tests.utils.CustomParseHelper

import static org.junit.Assert.*

@InjectWith(typeof(OrganizationGrammarInjectorProvider))
@RunWith(typeof(XtextRunner))
/**
 * Test 
 */
class OrganizationModelParsingTests extends AbstractXtextCommonTest {

	@Inject
	CustomParseHelper<Organization> parser

	private Organization orgModel1
	private Organization orgModel2

	def parseTestFile(String name, ResourceSet resourceSet) {
		val cl = Thread::currentThread().getContextClassLoader()
		val in = cl.getResourceAsStream(name)

		assertNotNull("Couldn't find the resource file in classpath.", in)

		val uri = URI::createFileURI(name)

		return parser.parse(in, uri, null, resourceSet);
	}

	@Before
	override void before() {

		super.before()

		orgModel2 = parseTestFile("tests/data/lunifera.organization", resourceSet)
		assertNotNull(orgModel2)
		orgModel1 = parseTestFile("tests/data/c4biz.organization", resourceSet)
		assertNotNull(orgModel1)
	}

	@Test
	// ensure that Organization is being populated rightly.
	def void ensureOrganizationFileAreBeingParsed() {

		// important: model2 should  be added first because the references
		assertEquals("Lunifera", orgModel2.name)
		assertEquals("C4Biz", orgModel1.name)
		assertEquals("C4Biz Information Technologies Consulting", orgModel1.longName)

		// assert Roles
		assertEquals(2, orgModel1.elements.filter(typeof(BusinessRole)).size)

		var role1 = orgModel1.elements.filter(typeof(BusinessRole)).head
		assertEquals("systemAnalyst", role1.name)
		assertEquals("System Analyst", role1.longName)

		var role2 = orgModel1.elements.filter(typeof(BusinessRole)).toList.get(1)
		assertEquals("javaProgrammer", role2.name)
		assertEquals("Java Programmer", role2.longName)

		// assert Units
		assertEquals(orgModel1.elements.filter(typeof(OrganizationUnit)).size, 1)

		var unit1 = orgModel1.elements.filter(typeof(OrganizationUnit)).head
		assertEquals("IT", unit1.name)
		assertEquals("IT Department", unit1.longName)

		// assert Persons
		assertEquals(orgModel1.elements.filter(typeof(Person)).size, 1)

		var person1 = orgModel1.elements.filter(typeof(Person)).head
		assertEquals("cvgaviao", person1.name)
		assertEquals("Cristiano", person1.firstName)
		assertEquals("Gavião", person1.lastName)
		assertEquals("cvgaviao@gmail.com", person1.email)

		// assert Workers
		assertEquals(orgModel1.elements.filter(typeof(Worker)).size, 1)

		var worker1 = orgModel1.elements.filter(typeof(Worker)).head
		assertEquals(worker1.person, person1)
		assertEquals(worker1.allocationUnit, unit1)

		// assert Partnerships
		assertEquals(orgModel1.elements.filter(typeof(Partnership)).size, 1)

		var partnership = orgModel1.elements.filter(typeof(Partnership)).head
		var partner = partnership.company

		assertEquals(partner.name, orgModel2.name)
		assertEquals(orgModel1.elements.filter(typeof(Partnership)).head.responsible, worker1)

		assertNotNull(partner)

		// assert model2
		assertEquals(partner.name, "Lunifera")

		assertEquals("Lunifera", orgModel2.name)
		assertEquals("Lunifera.org", orgModel2.longName)
	}

}

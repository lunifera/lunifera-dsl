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
package org.lunifera.dsl.organization.xtext.tests

import javax.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.lunifera.dsl.organization.semantic.model.OBusinessRole
import org.lunifera.dsl.organization.semantic.model.OOrganization
import org.lunifera.dsl.organization.semantic.model.OPartnership
import org.lunifera.dsl.organization.semantic.model.OPerson
import org.lunifera.dsl.organization.semantic.model.OUnit
import org.lunifera.dsl.organization.semantic.model.OWorker
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
	CustomParseHelper<OOrganization> parser

	private OOrganization orgModel1
	private OOrganization orgModel2

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
		assertEquals(2, orgModel1.elements.filter(typeof(OBusinessRole)).size)

		var role1 = orgModel1.elements.filter(typeof(OBusinessRole)).head
		assertEquals("systemAnalyst", role1.name)
		assertEquals("System Analyst", role1.longName)

		var role2 = orgModel1.elements.filter(typeof(OBusinessRole)).toList.get(1)
		assertEquals("javaProgrammer", role2.name)
		assertEquals("Java Programmer", role2.longName)

		// assert Units
		assertEquals(orgModel1.elements.filter(typeof(OUnit)).size, 1)

		var unit1 = orgModel1.elements.filter(typeof(OUnit)).head
		assertEquals("IT", unit1.name)
		assertEquals("IT Department", unit1.longName)

		// assert Persons
		assertEquals(orgModel1.elements.filter(typeof(OPerson)).size, 1)

		var person1 = orgModel1.elements.filter(typeof(OPerson)).head
		assertEquals("cvgaviao", person1.name)
		assertEquals("Cristiano", person1.firstName)
		assertEquals("Gavião", person1.lastName)
		assertEquals("cvgaviao@gmail.com", person1.email)

		// assert Workers
		assertEquals(orgModel1.elements.filter(typeof(OWorker)).size, 1)

		var worker1 = orgModel1.elements.filter(typeof(OWorker)).head
		assertEquals(worker1.person, person1)
		assertEquals(worker1.allocationUnit, unit1)

		// assert Partnerships
		assertEquals(orgModel1.elements.filter(typeof(OPartnership)).size, 1)

		var partnership = orgModel1.elements.filter(typeof(OPartnership)).head
		var partner = partnership.company

		assertEquals(partner.name, orgModel2.name)
		assertEquals(orgModel1.elements.filter(typeof(OPartnership)).head.responsible, worker1)

		assertNotNull(partner)

		// assert model2
		assertEquals(partner.name, "Lunifera")

		assertEquals("Lunifera", orgModel2.name)
		assertEquals("Lunifera.org", orgModel2.longName)
	}

}

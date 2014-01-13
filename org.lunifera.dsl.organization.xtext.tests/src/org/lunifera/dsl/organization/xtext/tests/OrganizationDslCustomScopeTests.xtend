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
import org.eclipse.xtext.scoping.IScopeProvider
import org.junit.Before
import org.junit.Test
import org.lunifera.dsl.organization.semantic.model.Organization
import org.lunifera.dsl.organization.semantic.model.OrganizationPackage
import org.lunifera.dsl.organization.semantic.model.Partnership
import org.lunifera.dsl.organization.semantic.model.Worker
import org.lunifera.dsl.organization.xtext.tests.utils.CustomParseHelper

import static org.junit.Assert.*

class OrganizationDslFormattingTests extends AbstractXtextCommonTest{
	
	
	@Inject CustomParseHelper<Organization> parser
	
	@Inject IScopeProvider scopeProvider
	
	private Organization orgModel1
	private Organization orgModel2

	@Before
	override void before(){
		
		super.before()
		
		orgModel2 = parseTestFile("tests/data/lunifera.organization", resourceSet)
		assertNotNull(orgModel2)
		orgModel1 = parseTestFile("tests/data/c4biz.organization", resourceSet)
		assertNotNull(orgModel1)
	}
	
	
	def parseTestFile (String name, ResourceSet resourceSet) {
    	val cl = Thread::currentThread().getContextClassLoader()
    	val in = cl.getResourceAsStream(name)
 		
 		assertNotNull("Couldn't find the resource file in classpath.", in)
 		
    	val uri = URI::createFileURI(name)
    	
    	return parser.parse(in, uri, null, resourceSet);
}
	/**
	 * Only workers coming from same model resource are allowed.
	 */
	@Test
	def void ensureOnlyInternalWorkersProposalsForPartnershipResponsible(){
		
		val reference = OrganizationPackage::eINSTANCE.partnership_Responsible
		val partner = orgModel1.elements.filter(typeof(Partnership)).head
		assertNotNull(partner)
		
		var scope = scopeProvider.getScope(partner, reference)
		
		var actualProposals = scope.allElements.map[name.toString].join(", ")
		
		assertEquals("c4biz.workers.cvgaviao", actualProposals)				
	}
	
	/**
	 * Only units coming from same model resource are allowed.
	 */
	@Test
	def void ensureOnlyInternalUnitProposalsForWorker(){
		
		val reference = OrganizationPackage::eINSTANCE.worker_AllocationUnit
		val worker = orgModel1.elements.filter(typeof(Worker)).head
		assertNotNull(worker)
		
		var scope = scopeProvider.getScope(worker, reference)
		
		var actualProposals = scope.allElements.map[name.toString].join(", ")
		
		assertEquals("c4biz.units.IT", actualProposals)				
	}

	/**
	 * Only roles coming from same model resource are allowed.
	 */
	@Test
	def void ensureOnlyInternalRolesProposalsForWorker(){

		val reference = OrganizationPackage::eINSTANCE.worker_PlayRoles
		val worker = orgModel1.elements.filter(typeof(Worker)).head
		assertNotNull(worker)
		
		var scope = scopeProvider.getScope(worker, reference)
		
		var actualProposals = scope.allElements.map[name.toString].join(", ")
		
		assertEquals("c4biz.roles.systemAnalyst, c4biz.roles.javaProgrammer", actualProposals)				
	}
	
	/**
	 * Only persons coming from same model resource are allowed.
	 */
	@Test
	def void ensureOnlyInternalPersonProposalsForWorker(){
		
		val reference = OrganizationPackage::eINSTANCE.worker_Person
		val worker = orgModel1.elements.filter(typeof(Worker)).head
		assertNotNull(worker)
		
		var scope = scopeProvider.getScope(worker, reference)
		
		var actualProposals = scope.allElements.map[name.toString].join(", ")
		
		assertEquals("c4biz.people.cvgaviao", actualProposals)				
	}
	
	/**
	 * Only companies coming from other models can be considered valid in proposals for a partner company.
	 */
	@Test
	def void ensureOnlyExternalCompaniesProposalsForPartnerCompany(){
		
		val reference = OrganizationPackage::eINSTANCE.partnership_Company
		val partner = orgModel1.elements.filter(typeof(Worker)).head
		assertNotNull(partner)
		
		var scope = scopeProvider.getScope(partner, reference)
		
		var actualProposals = scope.allElements.map[name.toString].join(", ")
		
		assertEquals("Lunifera", actualProposals)		
	}
	
}
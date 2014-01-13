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
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.serializer.ISerializer
import org.junit.Test
import org.lunifera.dsl.organization.semantic.model.Organization
import org.lunifera.dsl.organization.xtext.tests.utils.CustomParseHelper

import static org.junit.Assert.*

class OrganizationDslFormattingTests extends AbstractXtextCommonTest{
	
	
	@Inject extension CustomParseHelper<Organization>
	
	@Inject extension ISerializer
	
	@Test
	def void testFormattingForComments() {
		// todo neeed to improve comments formatting, include alignment of *
		val storyIn = 
		'''
		 /*
		 * Specification of a company/organization that are involved in the software solution being developed.
		 */
		 code Kwiee name "Kwiee Trading"
		'''.parse.serialize(SaveOptions::newBuilder.format().getOptions())
		
		val storyExpected = 
			'''
			/*
			* Specification of a company/organization that are involved in the software solution being developed.
			*/
			code Kwiee
			name "Kwiee Trading"'''.toString

		assertEquals(storyExpected, storyIn)
	}
	
	
	@Test
	def void testFormattingForOrganizationAttributes() {

		val storyIn = 
		'''
		/*
		* Specification of a company/organization that are involved in the software solution being developed.
		*/
		code Kwiee name "Kwiee Trading" description "An description."
		'''.parse.serialize(SaveOptions::newBuilder.format().getOptions())
		
		val storyExpected = 
			'''
			/*
			* Specification of a company/organization that are involved in the software solution being developed.
			*/
			code Kwiee
			name "Kwiee Trading"
			description "An description."'''.toString

		assertEquals(storyExpected, storyIn)
	}

	@Test
	def void testFormattingForOrganizationUnit() {

		val storyIn = 
		'''
		code Kwiee name "Kwiee Trading"
		
		/**
		* The units that are part of the main organization.
		*/
		Units{
			unit id IT
			unit id financial
			{
				name "Financial Department"
			}		
			unit id payment
			{
				parent financial
			}
			unit id accounting
			{
				parent financial
			}
			unit id receiving
			{
				parent financial
			}}
		'''.parse.serialize(SaveOptions::newBuilder.format().getOptions())
		
		val storyExpected = 
		'''
		code Kwiee
		name "Kwiee Trading"
		
		/**
		* The units that are part of the main organization.
		*/
		Units {
		
			unit id IT
		
			unit id financial {
				name "Financial Department"
			}
		
			unit id payment {
				parent financial
			}
		
			unit id accounting {
				parent financial
			}
		
			unit id receiving {
				parent financial
			}
		}'''.toString

		assertEquals(storyExpected, storyIn)
	}
	
	@Test
	def void testFormattingForPersons() {

		val storyIn = 
		'''
		code Kwiee  name "Kwiee Trading"
		
		/**
		* The people that is in any form related to the company and have some importance in the software solution.
		*/
		People{
		person id jonhD
		{first name "John"  last name "Done"
		}
		person id debbyT 
		{ first name "Deborah"  last name "Tender"
		}
		person id peterP
		{ first name "Peter"  last name "Parking"
		}
		}
		'''.parse.serialize(SaveOptions::newBuilder.format().getOptions())
		
		val storyExpected = 
		'''
		code Kwiee
		name "Kwiee Trading"

		/**
		* The people that is in any form related to the company and have some importance in the software solution.
		*/
		People {
		
			person id jonhD {
				first name "John"
				last name "Done"
			}
		
			person id debbyT {
				first name "Deborah"
				last name "Tender"
			}
		
			person id peterP {
				first name "Peter"
				last name "Parking"
			}
		}'''.toString

		assertEquals(storyExpected, storyIn)
	}
	@Test
	def void testFormattingForRoles() {

		val storyIn = 
		'''
		code Kwiee name "Kwiee Trading"
		
		/**
		* The roles played by the people involved in the business processes of the company.
		* Roles a related to people through the Worker.
		*/
		Business Roles{
		// teste
		role id financial.Worker
		{
			name "Financial Worker" description "Any employee or partner that works on the financial department."
		}
		
		/**
		* The roles
		*/
		role id financial.Manager
		{
			name "Financial Worker"
			description "Any employee or partner that works on the financial department."
		}}'''.parse.serialize(SaveOptions::newBuilder.format().getOptions())
		
		val storyExpected = 
		'''
		code Kwiee
		name "Kwiee Trading"
		
		/**
		* The roles played by the people involved in the business processes of the company.
		* Roles a related to people through the Worker.
		*/
		Business Roles {
		// teste
			role id financial.Worker {
				name "Financial Worker"
				description "Any employee or partner that works on the financial department."
			}
		
			/**
		* The roles
		*/
			role id financial.Manager {
				name "Financial Worker"
				description "Any employee or partner that works on the financial department."
			}
		}'''.toString

		assertEquals(storyExpected, storyIn)
	}
	
	
	@Test
	def void testFormattingForPartnership() {

		val storyIn = 
	'''
	         code Kwiee
	name "Kwiee Trading"
	
	/*
	* The partnership maden by the company with other organizations that probably will participate of processes and use part of the systems. 
	*/
	Partnerships
	{
	partnership company org.lunifera{
	//responsible
	agreement "one text"}}
	'''.parse.serialize(SaveOptions::newBuilder.format().getOptions())
		
		val storyExpected = 
		'''
		code Kwiee
		name "Kwiee Trading"

		/*
		* The partnership maden by the company with other organizations that probably will participate of processes and use part of the systems. 
		*/
		Partnerships {

			partnership company org.lunifera {
			//responsible

				agreement "one text"
			}
		}'''.toString

		assertEquals(storyExpected, storyIn)
	}


	@Test
	def void testFormattingForWorker() {

		val storyIn = 
		'''
		code Kwiee
		name "Kwiee Trading"
		Units {
			unit id IT
		}	
		Business Roles: {
			role id financial.Worker
			{
			name "Financial Worker"
			description "Any employee or partner that works on the financial department."
			}
		}
		People
		{
			person id peterP
			{
				first name "Peter"
				last name "Parking"
				email "peterp@kwiee.com"
			}
		}
		Workers {worker person kwiee.people.peterP{
		allocatedOn kwiee.units.IT
			playRoles kwiee.roles.financial.Worker
		}}
		'''.parse.serialize(SaveOptions::newBuilder.format().getOptions())
		
		val storyExpected = 
		'''
		code Kwiee
		name "Kwiee Trading"
		
		Units {
		
			unit id IT
		}
		
		Business Roles {
		
			role id financial.Worker {
				name "Financial Worker"
				description "Any employee or partner that works on the financial department."
			}
		}
		
		People {
		
			person id peterP {
				first name "Peter"
				last name "Parking"
				email "peterp@kwiee.com"
			}
		}
		
		Workers {
		
			worker person kwiee.people.peterP {
				allocatedOn kwiee.units.IT
				playRoles ( kwiee.roles.financial.Worker )
			}
		}'''.toString

		assertEquals(storyExpected, storyIn)
	}

}
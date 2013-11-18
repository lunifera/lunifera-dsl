/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Sources based on {@link org.eclipse.xtext.xbase.compiler.CompilationTestHelper}
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith
import org.lunifera.dsl.entity.semantic.model.LEntityModel
import org.lunifera.dsl.entity.xtext.EntityGrammarInjectorProvider
import org.lunifera.dsl.entity.xtext.EntityGrammarStandaloneSetup
import org.lunifera.dsl.entity.xtext.validation.EntityJavaValidator

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(EntityGrammarInjectorProvider))
class ValidatorTest extends AbstractXtextTests {

	@Inject
	private ParseHelper<LEntityModel> parseHelper;

	private ValidatorTester<EntityJavaValidator> tester;

	override void setUp() {
		super.setUp

		with(typeof(EntityGrammarStandaloneSetup));
		val EntityJavaValidator validator = get(typeof(EntityJavaValidator));
		tester = new ValidatorTester<EntityJavaValidator>(validator, injector);
	}

	@Test
	def void checkDuplicateType_InProject() {
		val LEntityModel lModel = parseHelper.parse(
			'''
				package my.test { 
					entity Library { 
						var id long id
					}
					entity Library { 
						var id long id
					}
				}
			''')

		tester.validator.checkDuplicateType_InProject(lModel.packages.get(0).types.get(0))
		tester.diagnose.assertError(EntityJavaValidator::CODE__DUPLICATE_LTYPE_IN_PROJECT)
	}

	@Test
	def void checkDuplicatePackages_InFile() {
		val LEntityModel lModel = parseHelper.parse(
			'''
				package my.test { 
				}
				
				package my.test { 
				}
			''')

		tester.validator.checkDuplicatePackages_InFile(lModel)
		tester.diagnose.assertError(EntityJavaValidator::CODE__DUPLICATE_LPACKAGE_IN_FILE)
	}
}

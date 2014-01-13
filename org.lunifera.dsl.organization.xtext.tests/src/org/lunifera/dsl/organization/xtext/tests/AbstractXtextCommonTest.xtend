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

import com.google.inject.Provider
import javax.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.lunifera.dsl.organization.xtext.tests.utils.CustomInjectorProvider
import org.lunifera.dsl.organization.xtext.tests.utils.CustomParseHelper

@InjectWith(typeof(CustomInjectorProvider))
@RunWith(typeof(XtextRunner))
abstract class AbstractXtextCommonTest {
	
	protected static XtextResourceSet resourceSet
	
	@Inject
    protected Provider<XtextResourceSet> resourceSetProvider
	
	@Before
	def void before(){
		if(resourceSet == null)
			resourceSet = resourceSetProvider.get
	}
	
	
	def <T extends EObject> parseTestFile (String name, CustomParseHelper<T> parseHelper) {
    	val cl = Thread::currentThread().getContextClassLoader()
    	val in = cl?.getResourceAsStream(name)
 		
 		assertNotNull("Couldn't find the resource file in classpath.", in)
 		
    	val uri = URI::createFileURI(name)
    	
    	val readObj = parseHelper?.parse(in, uri, null, resourceSet)
	
    	return readObj
	}

	def <T extends EObject> parseText (CharSequence name, CustomParseHelper<T> parseHelper) {
    	
    	val readObj = parseHelper?.parse(name, resourceSet)
	
    	return readObj
	}
	
	@After
	def void after(){
		resourceSet = null
	}
}
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

package org.lunifera.dsl.entity.xtext.tests;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.junit.Assert;

@SuppressWarnings("restriction")
public class MultiFilesCompilationTestHelper extends CompilationTestHelper {

	/**
	 * Asserts that the expected code is generated for the given source. Assumes
	 * that
	 * 
	 * @param source
	 *            some valid source code written in the language under test
	 * @param expected
	 *            the expected Java source code.
	 * @throws IOException
	 */
	public void assertCompilesToMultiple(CharSequence source,
			final Map<String, CharSequence> expected) throws IOException {
		final boolean[] called = { false };
		compile(source, new IAcceptor<CompilationTestHelper.Result>() {
			public void accept(Result r) {
				for (Entry<String, CharSequence> entry : expected.entrySet()) {
					Assert.assertEquals(entry.getValue().toString(), r
							.getGeneratedCode(entry.getKey().replace('/', '.')));
					called[0] = true;
				}
			}
		});
		Assert.assertTrue("Nothing was generated but the expectation was :\n"
				+ expected, called[0]);
	}
}

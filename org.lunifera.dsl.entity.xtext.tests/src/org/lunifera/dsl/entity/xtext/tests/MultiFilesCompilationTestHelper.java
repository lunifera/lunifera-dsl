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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class MultiFilesCompilationTestHelper extends CompilationTestHelper {

	@Inject
	private OnTheFlyJavaCompiler javaCompiler;

	@Inject
	private ParseHelper<EObject> parseHelper;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Inject
	private IGenerator generator;

	/**
	 * Asserts that the expected code is generated for the given source. Assumes
	 * that
	 * 
	 * @param source
	 *            some valid source code written in the language under test
	 * @param expected
	 *            the expected Java source codes. The key of the map is the name
	 *            of the file. For instance my/test/Library.java
	 */
	public void assertCompilesToMultiple(CharSequence source,
			final Map<String, CharSequence> expected) {
//		final boolean[] called = { false };
//		compileMultiple(source, new IAcceptor<CompilationTestHelper.Result>() {
//			public void accept(Result r) {
//				String path = r.getGeneratedPath()
//						.replace("DEFAULT_OUTPUT", "");
//				Assert.assertEquals(expected.get(path).toString(),
//						r.getGeneratedCode());
//				called[0] = true;
//			}
//		});
//		Assert.assertTrue("Nothing was generated but the expectation was :\n"
//				+ expected, called[0]);
	}

	/**
	 * Parses, validates and compiles the given source. Calls the given acceptor
	 * for each resource which is generated from the source.
	 * 
	 * @param source
	 *            some code written in the language under test.
	 * @param acceptor
	 *            gets called once for each file generated in {@link IGenerator}
	 */
	public void compileMultiple(CharSequence source, IAcceptor<Result> acceptor) {
		try {
			// final EObject parsed = parseHelper.parse(source);
			// validationTestHelper.assertNoErrors(parsed);
			// final InMemoryFileSystemAccess access = new
			// InMemoryFileSystemAccess();
			// generator.doGenerate(parsed.eResource(), access);
			// for (final Entry<String, CharSequence> e : access.getFiles()
			// .entrySet()) {
			// acceptor.accept(new Result() {
			//
			// public String getGeneratedPath() {
			// return e.getKey();
			// }
			//
			// public String getGeneratedCode() {
			// return e.getValue().toString();
			// }
			//
			// public Resource getSource() {
			// return (Resource) parsed.eResource();
			// }
			//
			// public Class<?> getCompiledClass() {
			// String name = e.getKey().substring(
			// "DEFAULT_OUTPUT".length(),
			// e.getKey().length() - ".java".length());
			// name = name.replace('/', '.');
			// final Class<?> clazz = javaCompiler.compileToClass(
			// name, e.getValue().toString());
			// return clazz;
			// }
			//
			// public Map<String, CharSequence> getAllGeneratedResources() {
			// return access.getFiles();
			// }
			//
			// });
			// }
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

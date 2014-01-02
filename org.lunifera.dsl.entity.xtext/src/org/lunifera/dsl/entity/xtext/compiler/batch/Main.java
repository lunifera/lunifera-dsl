/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.lunifera.dsl.entity.xtext.compiler.batch;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.lunifera.dsl.entity.xtext.EntityGrammarInjectorSingleton;

import com.google.common.base.Joiner;
import com.google.inject.Injector;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Injector injector = EntityGrammarInjectorSingleton.INJECTOR;
		EntityGrammarBatchCompiler entityGrammarBatchCompiler = injector.getInstance(EntityGrammarBatchCompiler.class);
		if ((args == null) || (args.length == 0)) {
			printUsage();
			return;
		}
		Iterator<String> arguments = Arrays.asList(args).iterator();
		while (arguments.hasNext()) {
			String argument = arguments.next();
			if ("-d".equals(argument.trim())) {
				entityGrammarBatchCompiler.setOutputPath(arguments.next().trim());
			} else if ("-classpath".equals(argument.trim()) || "-cp".equals(argument.trim())) {
				entityGrammarBatchCompiler.setClassPath(arguments.next().trim());
			} else if ("-tempdir".equals(argument.trim()) || "-td".equals(argument.trim())) {
				entityGrammarBatchCompiler.setTempDirectory(arguments.next().trim());
			} else if ("-encoding".equals(argument.trim())) {
				entityGrammarBatchCompiler.setFileEncoding(arguments.next().trim());
			} else if ("-useCurrentClassLoader".equals(argument.trim())) {
				entityGrammarBatchCompiler.setUseCurrentClassLoaderAsParent(true);
			} else {
				List<String> existingDirs = new ArrayList<String>(entityGrammarBatchCompiler.getSourcePathDirectories());
				existingDirs.add(argument);
				String pathes = Joiner.on(File.pathSeparator).join(existingDirs);
				entityGrammarBatchCompiler.setSourcePath(pathes);
			}
		}
		if (!entityGrammarBatchCompiler.compile()) {
			System.exit(1);
		}
	}
	
	private static void printUsage() {
		System.out.println("Usage: Main <options> <source directories>");
		System.out.println("where possible options include:");
		System.out
				.println("-d <directory>             Specify where to place generated entityGrammar files");
		System.out.println("-tp <path>                 Temp directory to hold generated stubs and classes");
		System.out.println("-cp <path>                 Specify where to find user class files");
		System.out.println("-encoding <encoding>       Specify character encoding used by source files");
		System.out.println("-useCurrentClassLoader	   Use current classloader as parent classloader");
	}

}

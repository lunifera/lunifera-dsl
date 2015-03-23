/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.datatype.xtext.generator

import java.io.StringWriter
import java.io.Writer
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl
import org.eclipse.xtext.generator.IFileSystemAccess
import org.lunifera.dsl.semantic.common.types.LCommonModel
import org.lunifera.dsl.xtext.lazyresolver.generator.DelegatingGenerator

class Generator extends DelegatingGenerator {

	override doGenerate(Resource input, IFileSystemAccess fsa) {

		super.doGenerate(input, fsa)

		val XMLResource outputRes = new XMLResourceImpl
		val LCommonModel lModel = input.contents.get(0) as LCommonModel
		outputRes.contents += EcoreUtil.copy(lModel)

		val Writer writer = new StringWriter
		outputRes.save(writer, null)

		fsa.generateFile(input.URI.lastSegment + ".datatypes_bin", "ModelBin", writer.toString)
	}

}

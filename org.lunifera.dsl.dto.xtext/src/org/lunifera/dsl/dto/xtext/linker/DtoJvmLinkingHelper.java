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
package org.lunifera.dsl.dto.xtext.linker;

import org.lunifera.dsl.semantic.dto.LunDtoPackage;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper;

public class DtoJvmLinkingHelper extends LazyJvmTypeLinkingHelper {

	public DtoJvmLinkingHelper() {
		register(LunDtoPackage.Literals.LDTO__SUPER_TYPE,
				LunDtoPackage.Literals.LDTO__SUPER_TYPE_JVM);
		register(LunDtoPackage.Literals.LDTO_ABSTRACT_REFERENCE__TYPE,
				LunDtoPackage.Literals.LDTO_ABSTRACT_REFERENCE__TYPE_JVM);
		register(LunDtoPackage.Literals.LDTO__WRAPPED_TYPE,
				LunDtoPackage.Literals.LDTO__WRAPPED_TYPE_JVM);
	}
}

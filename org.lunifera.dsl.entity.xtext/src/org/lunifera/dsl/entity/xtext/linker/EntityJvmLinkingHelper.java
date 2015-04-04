/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.linker;

import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;
import org.lunifera.dsl.xtext.lazyresolver.LazyJvmTypeLinkingHelper;

public class EntityJvmLinkingHelper extends LazyJvmTypeLinkingHelper {

	public EntityJvmLinkingHelper() {
		register(LunEntityPackage.Literals.LENTITY__SUPER_TYPE,
				LunEntityPackage.Literals.LENTITY__SUPER_TYPE_JVM);
		register(LunEntityPackage.Literals.LENTITY_REFERENCE__TYPE,
				LunEntityPackage.Literals.LENTITY_REFERENCE__TYPE_JVM); 
		register(LunTypesPackage.Literals.LATTRIBUTE__TYPE,
				LunTypesPackage.Literals.LATTRIBUTE__TYPE_JVM);
		register(LunEntityPackage.Literals.LBEAN__SUPER_TYPE,
				LunEntityPackage.Literals.LBEAN__SUPER_TYPE_JVM);
		register(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE,
				LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM);
	}

}

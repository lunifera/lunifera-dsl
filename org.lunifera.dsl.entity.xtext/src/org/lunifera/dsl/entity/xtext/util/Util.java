/**
 * Copyright (c) 2011 - 2013, Committers of lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Hans Georg Glöckler - Initial implementation
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.util;

import org.eclipse.emf.ecore.EObject;
import org.lunifera.dsl.entity.semantic.model.LPackage;
import org.lunifera.dsl.entity.semantic.model.LType;

public class Util {

	/**
	 * Returns the {@link LPackage} for the given type.
	 * 
	 * @param lType
	 * @return
	 */
	public static LPackage toPackageS(LType lType) {
		EObject current = lType;
		while (current != null && !(current instanceof LPackage)) {
			current = current.eContainer();
		}
		return (LPackage) current;
	}

	/**
	 * Returns the {@link LPackage} for the given type.
	 * 
	 * @param lType
	 * @return
	 */
	public LPackage toPackage(LType lType) {
		return toPackageS(lType);
	}
}

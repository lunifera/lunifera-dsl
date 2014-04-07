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
package org.lunifera.dsl.services.xtext.scope;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.lunifera.dsl.common.xtext.scope.CommonBatchScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
@SuppressWarnings("restriction")
public class ServicesBatchScopeProvider extends CommonBatchScopeProvider {

	@Override
	public IScope getScope(final EObject context, EReference reference) {
		// if (reference == LunServicePackage.Literals.LSER) {
		// return new ServicesInheritedReferenceScope(
		// (LDtoInheritedReference) context);
		// } else if (reference ==
		// LunServicePackage.Literals.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE)
		// {
		// return new ServicesInheritedAttributeScope(
		// (LDtoInheritedAttribute) context);
		// } else if (reference == LunServicePackage.Literals.LDTO__SUPER_TYPE)
		// {
		// return new InheritTypesFilterScope((LType) context, super.getScope(
		// context, reference));
		// }
		return super.getScope(context, reference);
	}

}

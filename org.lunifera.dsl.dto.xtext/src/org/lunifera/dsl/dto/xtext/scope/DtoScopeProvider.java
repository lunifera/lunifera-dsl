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
package org.lunifera.dsl.dto.xtext.scope;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.lunifera.dsl.common.xtext.scope.CommonScopeProvider;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute;
import org.lunifera.dsl.semantic.dto.LDtoInheritedReference;
import org.lunifera.dsl.semantic.dto.LDtoReference;
import org.lunifera.dsl.semantic.dto.LunDtoPackage;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
@SuppressWarnings("restriction")
public class DtoScopeProvider extends CommonScopeProvider {

	@Override
	public IScope getScope(final EObject context, EReference reference) {
		if (reference == LunDtoPackage.Literals.LDTO_INHERITED_REFERENCE__INHERITED_FEATURE) {
			return new DtoInheritedReferenceScope(
					(LDtoInheritedReference) context);
		} else if (reference == LunDtoPackage.Literals.LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE) {
			return new DtoInheritedAttributeScope(
					(LDtoInheritedAttribute) context);
		} else if (reference == LunDtoPackage.Literals.LDTO_REFERENCE__OPPOSITE) {
			return new DtoRefOppositeScope((LDtoReference) context);
		} else if (reference == LunDtoPackage.Literals.LDTO__WRAPPED_TYPE) {
			return new WrappedTypeFilterScope(
					super.getScope(context, reference));
		} else if (reference == LunDtoPackage.Literals.LDTO__SUPER_TYPE) {
			return new InheritTypesFilterScope((LType) context, super.getScope(
					context, reference));
		} else if (reference == LunTypesPackage.Literals.LATTRIBUTE__TYPE) {
			LAttribute att = (LAttribute) context;
			if (att.isId() || att.isVersion() || att.isUuid()) {
				return new DatatypesFilterScope(super.getScope(context,
						reference));
			} else if (att.isUuid()) {
				return new UUIdFilterScope(super.getScope(context, reference));
			}
		}
		return super.getScope(context, reference);
	}
}

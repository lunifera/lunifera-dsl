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
package org.lunifera.dsl.entity.xtext.scope;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.lunifera.dsl.common.xtext.scope.CommonScopeProvider;
import org.lunifera.dsl.common.xtext.scope.ConstraintEnumMatchingLiteralScope;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint;
import org.lunifera.dsl.semantic.common.types.LConstraints;
import org.lunifera.dsl.semantic.common.types.LReference;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityReference;
import org.lunifera.dsl.semantic.entity.LIndex;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
@SuppressWarnings("restriction")
public class EntityScopeProvider extends CommonScopeProvider {
	@Override
	public IScope getScope(final EObject context, EReference reference) {
		if (reference == LunEntityPackage.Literals.LENTITY_REFERENCE__OPPOSITE) {
			return new EntityRefOppositeScope((LEntityReference) context);
		} else if (reference == LunEntityPackage.Literals.LENTITY_ATTRIBUTE__OPPOSITE) {
			return new EntityAttOppositeScope((LEntityAttribute) context);
		} else if (reference == LunEntityPackage.Literals.LBEAN_REFERENCE__OPPOSITE) {
			return new BeanRefOppositeScope((LBeanReference) context);
		} else if (reference == LunTypesPackage.Literals.LATTRIBUTE__TYPE) {
			return new DatatypesScope(super.getScope(context, reference),
					(LAttribute) context, reference);
		} else if (reference == LunEntityPackage.Literals.LINDEX__FEATURES) {
			return new IndexScope((LIndex) context);
		} else if (reference == LunTypesPackage.Literals.LATTRIBUTE_MATCHING_CONSTRAINT__ATTRIBUTE) {
			if (context instanceof LConstraints) {
				return new EntityConstraintAttributeScope(
						(LReference) context.eContainer());
			} else {
				return new EntityConstraintAttributeScope((LReference) context
						.eContainer().eContainer());
			}
		} else if (reference == LunTypesPackage.Literals.LATTRIBUTE_MATCHING_CONSTRAINT__MATCHING_LITERAL) {
			return new ConstraintEnumMatchingLiteralScope((LAttributeMatchingConstraint) context);
		}
		return super.getScope(context, reference);
	}
}

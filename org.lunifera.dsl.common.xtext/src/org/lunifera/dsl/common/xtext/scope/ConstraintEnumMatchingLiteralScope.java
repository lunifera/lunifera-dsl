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
package org.lunifera.dsl.common.xtext.scope;

import java.util.ArrayList;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint;
import org.lunifera.dsl.semantic.common.types.LEnum;
import org.lunifera.dsl.semantic.common.types.LEnumLiteral;
import org.lunifera.dsl.semantic.common.types.LType;

public class ConstraintEnumMatchingLiteralScope extends AbstractScope {
	private final LAttributeMatchingConstraint constraint;

	public ConstraintEnumMatchingLiteralScope(
			LAttributeMatchingConstraint constraint) {
		super(IScope.NULLSCOPE, true);
		this.constraint = constraint;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {

		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		LAttribute att = constraint.getAttribute();
		if (att != null) {
			LType type = att.getType();
			if (type instanceof LEnum) {
				LEnum enumx = (LEnum) type;

				for (LEnumLiteral literal : enumx.getLiterals()) {
					result.add(new EObjectDescription(QualifiedName
							.create(literal.getName()), literal, null));
				}
			}
		}
		return result;
	}
}
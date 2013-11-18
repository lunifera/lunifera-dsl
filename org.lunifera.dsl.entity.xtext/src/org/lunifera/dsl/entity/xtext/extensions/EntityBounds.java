/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.extensions;

import org.lunifera.dsl.entity.semantic.model.LMultiplicity;
import org.lunifera.dsl.entity.semantic.model.LProperty;
import org.lunifera.dsl.entity.semantic.model.LowerBound;
import org.lunifera.dsl.entity.semantic.model.UpperBound;

/**
 * Keeps lower and upper bound
 */
public class EntityBounds {

	private final LowerBound lower;
	private final UpperBound upper;

	public static EntityBounds createFor(LProperty prop) {
		if (prop == null || prop.getType() == null) {
			return new EntityBounds(LowerBound.ZERO, UpperBound.ONE);
		}

		LMultiplicity multiplicity = prop.getMultiplicity();
		
		LowerBound lb = null;
		UpperBound ub = null;
		
		if(multiplicity != null){
			lb = multiplicity.getLower();
			ub = multiplicity.getUpper();
		}

		LowerBound lower = LowerBound.ZERO;
		UpperBound upper = UpperBound.ONE;

//		// Set the defaults by type.
//		if (prop.getType() instanceof LScalarType) {
//		} else if (prop.getType() instanceof LClass) {
//			// ###
//		} else {
//			throw new IllegalArgumentException("Unsupported type " + prop.getType() + " of " + prop);
//		}

		if (lb != null) {
			if (ub != null && ub != UpperBound.NULL) {
				// Lower and upper bound [x..y] where x = 0/1/?/+/* and y = 1/*
				switch (lb) {
				case ZERO: // [0..]
				case OPTIONAL: // [?..] -> same as [0..] -> should be warning
					lower = LowerBound.ZERO;
					break;
				case ONE: // [1..]
				case ATLEASTONE: // [+..] -> same as [1..] -> should be warning
					lower = LowerBound.ONE;
					break;
				case MANY: // [*..]
					lower = LowerBound.MANY;
					// [*..*]
					// [*..1] -> error: upper must be greather than lower bound!
					break;
				case NULL:
					throw new IllegalArgumentException("unexpected NULL value");
				}
				upper = ub;
			} else {
				// No upper bound.
				switch (lb) {
				case ZERO: // [0] -> makes only sense with upper bound
				case OPTIONAL: // [?]
					lower = LowerBound.ZERO;
					upper = UpperBound.ONE;
					break;
				case ONE: // [1] -> implies notnull
				case ATLEASTONE: // [+]
					lower = LowerBound.ONE;
					upper = UpperBound.ONE;
					break;
				case MANY: // [*]
					lower = LowerBound.ZERO;
					upper = UpperBound.MANY;
					break;
				case NULL:
					throw new IllegalArgumentException("unexpected NULL value");
				}
			}
		}

		return new EntityBounds(lower, upper);
	}

	public EntityBounds(LowerBound lower, UpperBound upper) {
		super();
		this.lower = lower;
		this.upper = upper;
	}

	public LowerBound getLower() {
		return lower;
	}

	public UpperBound getUpper() {
		return upper;
	}

	/**
	 * Returns true if the upper bound is many.
	 * 
	 * @return
	 */
	public boolean isToMany() {
		return upper == UpperBound.MANY;
	}

	/**
	 * Returns true if the lower bound is one.
	 * 
	 * @return
	 */
	public boolean isRequired() {
		return lower == LowerBound.ONE;
	}

	/**
	 * Returns true if the lower bound is zero.
	 * 
	 * @return
	 */
	public boolean isOptional() {
		return lower == LowerBound.ZERO;
	}
}

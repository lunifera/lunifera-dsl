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
package org.lunifera.dsl.semantic.common.helper;

import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LLowerBound;
import org.lunifera.dsl.semantic.common.types.LMultiplicity;
import org.lunifera.dsl.semantic.common.types.LUpperBound;

/**
 * Keeps lower and upper bound
 */
public class Bounds {

	private final LLowerBound lower;
	private final LUpperBound upper;

	public static Bounds createFor(LFeature prop) {
		if (prop == null) {
			return new Bounds(LLowerBound.ZERO, LUpperBound.ONE);
		}

		LMultiplicity multiplicity = prop.getMultiplicity();

		LLowerBound lb = null;
		LUpperBound ub = null;

		if (multiplicity != null) {
			lb = multiplicity.getLower();
			ub = multiplicity.getUpper();
		}

		LLowerBound lower = LLowerBound.ZERO;
		LUpperBound upper = LUpperBound.ONE;

		// // Set the defaults by type.
		// if (prop.getType() instanceof LScalarType) {
		// } else if (prop.getType() instanceof LClass) {
		// // ###
		// } else {
		// throw new IllegalArgumentException("Unsupported type " +
		// prop.getType() + " of " + prop);
		// }

		if (lb != null) {
			if (ub != null && ub != LUpperBound.NULL) {
				// Lower and upper bound [x..y] where x = 0/1/?/+/* and y = 1/*
				switch (lb) {
				case ZERO: // [0..]
				case OPTIONAL: // [?..] -> same as [0..] -> should be warning
					lower = LLowerBound.ZERO;
					break;
				case ONE: // [1..]
				case ATLEASTONE: // [+..] -> same as [1..] -> should be warning
					lower = LLowerBound.ONE;
					break;
				case MANY: // [*..]
					lower = LLowerBound.MANY;
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
					lower = LLowerBound.ZERO;
					upper = LUpperBound.ONE;
					break;
				case ONE: // [1] -> implies notnull
				case ATLEASTONE: // [+]
					lower = LLowerBound.ONE;
					upper = LUpperBound.ONE;
					break;
				case MANY: // [*]
					lower = LLowerBound.ZERO;
					upper = LUpperBound.MANY;
					break;
				case NULL:
					lower = LLowerBound.ZERO;
					upper = LUpperBound.MANY;
					break;
				}
			}
		}

		return new Bounds(lower, upper);
	}

	public Bounds(LLowerBound lower, LUpperBound upper) {
		super();
		this.lower = lower;
		this.upper = upper;
	}

	public LLowerBound getLower() {
		return lower;
	}

	public LUpperBound getUpper() {
		return upper;
	}

	/**
	 * Returns true if the upper bound is many.
	 * 
	 * @return
	 */
	public boolean isToMany() {
		return upper == LUpperBound.MANY;
	}

	/**
	 * Returns true if the lower bound is one.
	 * 
	 * @return
	 */
	public boolean isRequired() {
		return lower == LLowerBound.ONE;
	}

	/**
	 * Returns true if the lower bound is zero.
	 * 
	 * @return
	 */
	public boolean isOptional() {
		return lower == LLowerBound.ZERO;
	}
}

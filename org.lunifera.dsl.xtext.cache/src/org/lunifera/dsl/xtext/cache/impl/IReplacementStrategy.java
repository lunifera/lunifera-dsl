/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import com.google.common.collect.ImmutableList;
import com.google.inject.ImplementedBy;

/**
 * @author Mark Christiaens - Initial contribution
 * 
 * @since 2.3
 */

@ImplementedBy(LRUReplacementStrategy.class)
public interface IReplacementStrategy {
	/** Returns entries of cache that should be replaced */
	ImmutableList<ICacheEntry> selectReplacementCandidates(ICacheIndex index, ICacheEntry entry);

	boolean canFit(ICacheEntry entry);
}

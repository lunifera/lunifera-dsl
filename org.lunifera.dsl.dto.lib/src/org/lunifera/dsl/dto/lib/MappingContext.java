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
package org.lunifera.dsl.dto.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.lunifera.runtime.common.coordination.CoordinationManager;
import org.lunifera.runtime.common.state.IDataState;
import org.lunifera.runtime.common.state.ISharedStateContext;

/**
 * A common context for mappings. The registered entries will be reused. If an
 * object for a given key is available, this instance will be returned.
 * <p>
 * At the end of the mapping process, the cached objects will be forwarded to
 * the {@link ISharedStateContext}. The user needs to call {@link #flush()}.
 * Calls to {@link #flush()} during the mapping process has no effect, if the
 * current level is greater zero.
 */
public class MappingContext {

	private int level = 0;

	private Map<Object, Object> cache;
	private Map<Object, Object> mappingRootCache;
	private ISharedStateContext sharedState;
	private IDataState dirtyAwareGlobalDataState;

	public MappingContext() {
		this(true);
	}

	public MappingContext(boolean useSharedState) {
		cache = new HashMap<Object, Object>();
		if (useSharedState) {
			ISharedStateContext sharedState = (ISharedStateContext) CoordinationManager
					.getPropertyFromCurrentCoordination(ISharedStateContext.class);
			this.sharedState = sharedState;
			if (sharedState != null) {
				this.dirtyAwareGlobalDataState = sharedState
						.getDirtyAwareGlobalState();
			}
		}
	}

	public ISharedStateContext getSharedState() {
		return sharedState;
	}

	protected boolean isUseSharedState() {
		return sharedState != null;
	}

	/**
	 * Increases the level of the mapping process.
	 */
	public void increaseLevel() {
		level++;
	}

	/**
	 * Decreases the level of the mapping process.
	 */
	public void decreaseLevel() {
		level--;
	}

	/**
	 * For later use.
	 * 
	 * @return
	 */
	public boolean isMaxLevel() {
		return false;
	}

	/**
	 * Registers the object in the temporary internal cache. If {@link #flush()}
	 * is called, the internal cache will be cleared and objects are forwarded
	 * to the {@link ISharedStateContext}.
	 * 
	 * @param key
	 * @param target
	 */
	public void register(Object key, Object target) {
		cache.put(key, target);
	}

	/**
	 * Registers the object that was used as a template to map the cached
	 * object.
	 * 
	 * @param key
	 * @param target
	 */
	public void registerMappingRoot(Object key, Object target) {
		if (mappingRootCache == null) {
			mappingRootCache = new HashMap<Object, Object>();
		}
		mappingRootCache.put(key, target);
	}

	@SuppressWarnings("unchecked")
	public <A> A get(Object key) {
		A result = (A) cache.get(key);
		if (result == null) {
			if (isUseSharedState()) {
				result = (A) dirtyAwareGlobalDataState.get(key);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public <A> A getMappingRoot(Object key) {
		return (A) mappingRootCache.get(key);
	}

	/**
	 * This method flushes the cached entries into the
	 * {@link ISharedStateContext} if available. The cache will only become
	 * flushed, if the level is zero.
	 */
	public void flush() {
		if (level > 0) {
			return;
		}
		if (isUseSharedState()) {
			IDataState globalState = sharedState.getGlobalDataState();
			for (Entry<Object, Object> entry : cache.entrySet()) {
				globalState.register(entry.getKey(), entry.getValue());
			}
		}
		cache.clear();
	}
}

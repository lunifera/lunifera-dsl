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

public class Context {

	public static final int MAX_LEVEL = 3;

	private int level = 0;

	private Map<Object, Object> sourceToTarget = new HashMap<Object, Object>();
	private Map<Object, Object> targetToSource = new HashMap<Object, Object>();

	public void increaseLevel() {
		level++;
	}

	public void decreaseLevel() {
		level--;
	}

	public boolean isMaxLevel() {
		return level >= MAX_LEVEL;
	}

	public void register(Object source, Object target) {
		sourceToTarget.put(source, target);
		targetToSource.put(target, source);
	}

	@SuppressWarnings("unchecked")
	public <A> A getSource(Object entity) {
		return (A) targetToSource.get(entity);
	}

	@SuppressWarnings("unchecked")
	public <A> A getTarget(Object dto) {
		return (A) sourceToTarget.get(dto);
	}
}

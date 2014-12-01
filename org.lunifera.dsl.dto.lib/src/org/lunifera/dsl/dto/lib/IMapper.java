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

public interface IMapper<D, E> {

	void mapToDTO(D dto, E entity, Context context);

	void mapToEntity(D dto, E entity, Context context);
	
	
	public static class Context {
		
		private Map<Object, Object> dtos = new HashMap<Object, Object>();
		private Map<Object, Object> entities = new HashMap<Object, Object>();
		
		public void register(Object entity, Object dto) {
			dtos.put(entity, dto);
			entities.put(dto, entity);
		}
		
		@SuppressWarnings("unchecked")
		public <A> A getDto(Object entity){
			return (A) dtos.get(entity);
		}
		
		@SuppressWarnings("unchecked")
		public <A> A getEntity(Object dto){
			return (A) entities.get(dto);
		}
	}
}

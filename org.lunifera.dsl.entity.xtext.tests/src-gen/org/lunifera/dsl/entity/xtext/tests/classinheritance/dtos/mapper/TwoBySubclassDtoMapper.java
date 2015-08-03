/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.mapper;

import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoBySubclass;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.TwoBySubclassDto;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.mapper.OneBySubclassDtoMapper;

/**
 * This class maps the dto {@link TwoBySubclassDto} to and from the entity {@link TwoBySubclass}.
 * 
 */
@SuppressWarnings("all")
public class TwoBySubclassDtoMapper<DTO extends TwoBySubclassDto, ENTITY extends TwoBySubclass> extends OneBySubclassDtoMapper<DTO, ENTITY> {
  /**
   * Creates a new instance of the entity
   */
  public TwoBySubclass createEntity() {
    return new TwoBySubclass();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public TwoBySubclassDto createDto() {
    return new TwoBySubclassDto();
  }
  
  /**
   * Maps the entity {@link TwoBySubclass} to the dto {@link TwoBySubclassDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final TwoBySubclassDto dto, final TwoBySubclass entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    super.mapToDTO(dto, entity, context);
    
    dto.setStuff(toDto_stuff(entity, context));
  }
  
  /**
   * Maps the dto {@link TwoBySubclassDto} to the entity {@link TwoBySubclass}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final TwoBySubclassDto dto, final TwoBySubclass entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    super.mapToEntity(dto, entity, context);
    
    entity.setStuff(toEntity_stuff(dto, context));
  }
  
  /**
   * Maps the property stuff from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Long toDto_stuff(final TwoBySubclass in, final MappingContext context) {
    return in.getStuff();
  }
  
  /**
   * Maps the property stuff from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Long toEntity_stuff(final TwoBySubclassDto in, final MappingContext context) {
    return in.getStuff();
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(TwoBySubclassDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(TwoBySubclass.class, in);
  }
}

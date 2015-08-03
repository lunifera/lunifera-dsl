/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.mapper;

import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.OneBySubclass;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.OneBySubclassDto;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.mapper.BaseBySubclassDtoMapper;

/**
 * This class maps the dto {@link OneBySubclassDto} to and from the entity {@link OneBySubclass}.
 * 
 */
@SuppressWarnings("all")
public class OneBySubclassDtoMapper<DTO extends OneBySubclassDto, ENTITY extends OneBySubclass> extends BaseBySubclassDtoMapper<DTO, ENTITY> {
  /**
   * Creates a new instance of the entity
   */
  public OneBySubclass createEntity() {
    return new OneBySubclass();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public OneBySubclassDto createDto() {
    return new OneBySubclassDto();
  }
  
  /**
   * Maps the entity {@link OneBySubclass} to the dto {@link OneBySubclassDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final OneBySubclassDto dto, final OneBySubclass entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    super.mapToDTO(dto, entity, context);
    
    dto.setName(toDto_name(entity, context));
  }
  
  /**
   * Maps the dto {@link OneBySubclassDto} to the entity {@link OneBySubclass}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final OneBySubclassDto dto, final OneBySubclass entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    super.mapToEntity(dto, entity, context);
    
    entity.setName(toEntity_name(dto, context));
  }
  
  /**
   * Maps the property name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_name(final OneBySubclass in, final MappingContext context) {
    return in.getName();
  }
  
  /**
   * Maps the property name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_name(final OneBySubclassDto in, final MappingContext context) {
    return in.getName();
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(OneBySubclassDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(OneBySubclass.class, in);
  }
}

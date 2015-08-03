/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.entitydsl.documentation.demo.dtos.mapper;

import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.entitydsl.documentation.demo.Bar;
import org.lunifera.entitydsl.documentation.demo.dtos.BarDto;
import org.lunifera.entitydsl.documentation.demo.dtos.mapper.FooDtoMapper;

/**
 * This class maps the dto {@link BarDto} to and from the entity {@link Bar}.
 * 
 */
@SuppressWarnings("all")
public class BarDtoMapper<DTO extends BarDto, ENTITY extends Bar> extends FooDtoMapper<DTO, ENTITY> {
  /**
   * Creates a new instance of the entity
   */
  public Bar createEntity() {
    return new Bar();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public BarDto createDto() {
    return new BarDto();
  }
  
  /**
   * Maps the entity {@link Bar} to the dto {@link BarDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final BarDto dto, final Bar entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    super.mapToDTO(dto, entity, context);
    
    dto.setNumber(toDto_number(entity, context));
  }
  
  /**
   * Maps the dto {@link BarDto} to the entity {@link Bar}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final BarDto dto, final Bar entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    super.mapToEntity(dto, entity, context);
    
    entity.setNumber(toEntity_number(dto, context));
  }
  
  /**
   * Maps the property number from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Long toDto_number(final Bar in, final MappingContext context) {
    return in.getNumber();
  }
  
  /**
   * Maps the property number from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Long toEntity_number(final BarDto in, final MappingContext context) {
    return in.getNumber();
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(BarDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(Bar.class, in);
  }
}

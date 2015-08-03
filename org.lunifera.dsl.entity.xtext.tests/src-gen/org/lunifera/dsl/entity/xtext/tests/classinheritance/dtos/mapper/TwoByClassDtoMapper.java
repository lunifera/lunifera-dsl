/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.mapper;

import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoByClass;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.TwoByClassDto;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.mapper.OneByClassDtoMapper;

/**
 * This class maps the dto {@link TwoByClassDto} to and from the entity {@link TwoByClass}.
 * 
 */
@SuppressWarnings("all")
public class TwoByClassDtoMapper<DTO extends TwoByClassDto, ENTITY extends TwoByClass> extends OneByClassDtoMapper<DTO, ENTITY> {
  /**
   * Creates a new instance of the entity
   */
  public TwoByClass createEntity() {
    return new TwoByClass();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public TwoByClassDto createDto() {
    return new TwoByClassDto();
  }
  
  /**
   * Maps the entity {@link TwoByClass} to the dto {@link TwoByClassDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final TwoByClassDto dto, final TwoByClass entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    super.mapToDTO(dto, entity, context);
    
    dto.setStuff(toDto_stuff(entity, context));
  }
  
  /**
   * Maps the dto {@link TwoByClassDto} to the entity {@link TwoByClass}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final TwoByClassDto dto, final TwoByClass entity, final MappingContext context) {
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
  protected Long toDto_stuff(final TwoByClass in, final MappingContext context) {
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
  protected Long toEntity_stuff(final TwoByClassDto in, final MappingContext context) {
    return in.getStuff();
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(TwoByClassDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(TwoByClass.class, in);
  }
}

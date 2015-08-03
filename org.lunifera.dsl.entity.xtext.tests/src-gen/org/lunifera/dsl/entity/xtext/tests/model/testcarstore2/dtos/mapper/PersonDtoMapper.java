/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.mapper;

import java.util.Date;
import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.IMapperAccess;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Person;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.PersonDto;

/**
 * This class maps the dto {@link PersonDto} to and from the entity {@link Person}.
 * 
 */
@SuppressWarnings("all")
public class PersonDtoMapper<DTO extends PersonDto, ENTITY extends Person> implements IMapper<DTO, ENTITY> {
  private IMapperAccess mapperAccess;
  
  /**
   * Returns the mapper instance that may map between the given dto and entity. Or <code>null</code> if no mapper is available.
   * 
   * @param dtoClass - the class of the dto that should be mapped
   * @param entityClass - the class of the entity that should be mapped
   * @return the mapper instance or <code>null</code>
   */
  protected <D, E> IMapper<D, E> getToDtoMapper(final Class<D> dtoClass, final Class<E> entityClass) {
    return mapperAccess.getToDtoMapper(dtoClass, entityClass);
  }
  
  /**
   * Returns the mapper instance that may map between the given dto and entity. Or <code>null</code> if no mapper is available.
   * 
   * @param dtoClass - the class of the dto that should be mapped
   * @param entityClass - the class of the entity that should be mapped
   * @return the mapper instance or <code>null</code>
   */
  protected <D, E> IMapper<D, E> getToEntityMapper(final Class<D> dtoClass, final Class<E> entityClass) {
    return mapperAccess.getToEntityMapper(dtoClass, entityClass);
  }
  
  /**
   * Called by OSGi-DS. Binds the mapper access service.
   * 
   * @param service - The mapper access service
   * 
   */
  protected void bindMapperAccess(final IMapperAccess mapperAccess) {
    this.mapperAccess = mapperAccess;
  }
  
  /**
   * Called by OSGi-DS. Binds the mapper access service.
   * 
   * @param service - The mapper access service
   * 
   */
  protected void unbindMapperAccess(final IMapperAccess mapperAccess) {
    this.mapperAccess = null;
  }
  
  /**
   * Creates a new instance of the entity
   */
  public Person createEntity() {
    return new Person();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public PersonDto createDto() {
    return new PersonDto();
  }
  
  /**
   * Maps the entity {@link Person} to the dto {@link PersonDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final PersonDto dto, final Person entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    dto.setId(toDto_id(entity, context));
    dto.setFirstname(toDto_firstname(entity, context));
    dto.setLastname(toDto_lastname(entity, context));
    dto.setBirthdate(toDto_birthdate(entity, context));
  }
  
  /**
   * Maps the dto {@link PersonDto} to the entity {@link Person}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final PersonDto dto, final Person entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    
    entity.setId(toEntity_id(dto, context));
    entity.setFirstname(toEntity_firstname(dto, context));
    entity.setLastname(toEntity_lastname(dto, context));
    entity.setBirthdate(toEntity_birthdate(dto, context));
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected long toDto_id(final Person in, final MappingContext context) {
    return in.getId();
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected long toEntity_id(final PersonDto in, final MappingContext context) {
    return in.getId();
  }
  
  /**
   * Maps the property firstname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_firstname(final Person in, final MappingContext context) {
    return in.getFirstname();
  }
  
  /**
   * Maps the property firstname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_firstname(final PersonDto in, final MappingContext context) {
    return in.getFirstname();
  }
  
  /**
   * Maps the property lastname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_lastname(final Person in, final MappingContext context) {
    return in.getLastname();
  }
  
  /**
   * Maps the property lastname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_lastname(final PersonDto in, final MappingContext context) {
    return in.getLastname();
  }
  
  /**
   * Maps the property birthdate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Date toDto_birthdate(final Person in, final MappingContext context) {
    return in.getBirthdate();
  }
  
  /**
   * Maps the property birthdate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Date toEntity_birthdate(final PersonDto in, final MappingContext context) {
    return in.getBirthdate();
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(PersonDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(Person.class, in);
  }
}

/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.mapper;

import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.IMapperAccess;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Address;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto;

/**
 * This class maps the dto {@link AddressDto} to and from the entity {@link Address}.
 * 
 */
@SuppressWarnings("all")
public class AddressDtoMapper<DTO extends AddressDto, ENTITY extends Address> implements IMapper<DTO, ENTITY> {
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
  public Address createEntity() {
    return new Address();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public AddressDto createDto() {
    return new AddressDto();
  }
  
  /**
   * Maps the entity {@link Address} to the dto {@link AddressDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final AddressDto dto, final Address entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    dto.setStreetname(toDto_streetname(entity, context));
    dto.setHousenumber(toDto_housenumber(entity, context));
    dto.setCity(toDto_city(entity, context));
    dto.setZipcode(toDto_zipcode(entity, context));
  }
  
  /**
   * Maps the dto {@link AddressDto} to the entity {@link Address}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final AddressDto dto, final Address entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    
    entity.setStreetname(toEntity_streetname(dto, context));
    entity.setHousenumber(toEntity_housenumber(dto, context));
    entity.setCity(toEntity_city(dto, context));
    entity.setZipcode(toEntity_zipcode(dto, context));
  }
  
  /**
   * Maps the property streetname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_streetname(final Address in, final MappingContext context) {
    return in.getStreetname();
  }
  
  /**
   * Maps the property streetname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_streetname(final AddressDto in, final MappingContext context) {
    return in.getStreetname();
  }
  
  /**
   * Maps the property housenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toDto_housenumber(final Address in, final MappingContext context) {
    return in.getHousenumber();
  }
  
  /**
   * Maps the property housenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toEntity_housenumber(final AddressDto in, final MappingContext context) {
    return in.getHousenumber();
  }
  
  /**
   * Maps the property city from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_city(final Address in, final MappingContext context) {
    return in.getCity();
  }
  
  /**
   * Maps the property city from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_city(final AddressDto in, final MappingContext context) {
    return in.getCity();
  }
  
  /**
   * Maps the property zipcode from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toDto_zipcode(final Address in, final MappingContext context) {
    return in.getZipcode();
  }
  
  /**
   * Maps the property zipcode from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toEntity_zipcode(final AddressDto in, final MappingContext context) {
    return in.getZipcode();
  }
  
  public String createDtoHash(final Object in) {
    throw new UnsupportedOperationException("No id attribute available");
  }
  
  public String createEntityHash(final Object in) {
    throw new UnsupportedOperationException("No id attribute available");
  }
}

/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.mapper;

import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Address;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.AddressDto;

/**
 * This class maps the dto {@link AddressDto} to and from the entity {@link Address}.
 * 
 */
@SuppressWarnings("all")
public class AddressDtoMapper implements org.lunifera.dsl.dto.lib.IMapper {
  private org.lunifera.dsl.dto.lib.IMapperAccess mapperAccess;
  
  /**
   * Returns the mapper instance that may map between the given dto and entity. Or <code>null</code> if no mapper is available.
   * 
   * @param dtoClass - the class of the dto that should be mapped
   * @param entityClass - the class of the entity that should be mapped
   * @return the mapper instance or <code>null</code>
   */
  protected <D, E> org.lunifera.dsl.dto.lib.IMapper getMapper(final Class<D> dtoClass, final Class<E> entityClass) {
    return mapperAccess.getMapper(dtoClass, entityClass);
  }
  
  /**
   * Called by OSGi-DS. Binds the mapper access service.
   * 
   * @param service - The mapper access service
   * 
   */
  protected void bindMapperAccess(final org.lunifera.dsl.dto.lib.IMapperAccess mapperAccess) {
    this.mapperAccess = mapperAccess;
  }
  
  /**
   * Called by OSGi-DS. Binds the mapper access service.
   * 
   * @param service - The mapper access service
   * 
   */
  protected void unbindMapperAccess(final org.lunifera.dsl.dto.lib.IMapperAccess mapperAccess) {
    this.mapperAccess = null;
  }
  
  /**
   * Maps the entity {@link Address} to the dto {@link AddressDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final AddressDto dto, final Address entity) {
    
    dto.setStreetname(toDto_streetname(entity));
    dto.setHousenumber(toDto_housenumber(entity));
    dto.setCity(toDto_city(entity));
    dto.setZipcode(toDto_zipcode(entity));
  }
  
  /**
   * Maps the dto {@link AddressDto} to the entity {@link Address}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final AddressDto dto, final Address entity) {
    
    entity.setStreetname(toEntity_streetname(dto));
    
    entity.setHousenumber(toEntity_housenumber(dto));
    
    entity.setCity(toEntity_city(dto));
    
    entity.setZipcode(toEntity_zipcode(dto));
    
  }
  
  /**
   * Maps the property streetname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_streetname(final Address in) {
    return in.getStreetname();
  }
  
  /**
   * Maps the property streetname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_streetname(final AddressDto in) {
    return in.getStreetname();
  }
  
  /**
   * Maps the property housenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toDto_housenumber(final Address in) {
    return in.getHousenumber();
  }
  
  /**
   * Maps the property housenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toEntity_housenumber(final AddressDto in) {
    return in.getHousenumber();
  }
  
  /**
   * Maps the property city from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_city(final Address in) {
    return in.getCity();
  }
  
  /**
   * Maps the property city from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_city(final AddressDto in) {
    return in.getCity();
  }
  
  /**
   * Maps the property zipcode from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toDto_zipcode(final Address in) {
    return in.getZipcode();
  }
  
  /**
   * Maps the property zipcode from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toEntity_zipcode(final AddressDto in) {
    return in.getZipcode();
  }
}

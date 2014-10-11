/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.mapper;

import java.util.Date;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Car;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.CarDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Manufacturer;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.ManufacturerDto;

/**
 * This class maps the dto {@link CarDto} to and from the entity {@link Car}.
 * 
 */
@SuppressWarnings("all")
public class CarDtoMapper implements org.lunifera.dsl.dto.lib.IMapper {
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
   * Maps the entity {@link Car} to the dto {@link CarDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final CarDto dto, final Car entity) {
    
    dto.setId(toDto_id(entity));
    dto.setModelname(toDto_modelname(entity));
    dto.setConstructiondate(toDto_constructiondate(entity));
    dto.setPrice(toDto_price(entity));
    dto.setManufacturer(toDto_manufacturer(entity));
  }
  
  /**
   * Maps the dto {@link CarDto} to the entity {@link Car}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final CarDto dto, final Car entity) {
    
    entity.setId(toEntity_id(dto));
    
    entity.setModelname(toEntity_modelname(dto));
    
    entity.setConstructiondate(toEntity_constructiondate(dto));
    
    entity.setPrice(toEntity_price(dto));
    
    entity.setManufacturer(toEntity_manufacturer(dto));
    
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toDto_id(final Car in) {
    return in.getId();
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toEntity_id(final CarDto in) {
    return in.getId();
  }
  
  /**
   * Maps the property modelname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_modelname(final Car in) {
    return in.getModelname();
  }
  
  /**
   * Maps the property modelname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_modelname(final CarDto in) {
    return in.getModelname();
  }
  
  /**
   * Maps the property constructiondate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Date toDto_constructiondate(final Car in) {
    return in.getConstructiondate();
  }
  
  /**
   * Maps the property constructiondate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Date toEntity_constructiondate(final CarDto in) {
    return in.getConstructiondate();
  }
  
  /**
   * Maps the property price from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toDto_price(final Car in) {
    return in.getPrice();
  }
  
  /**
   * Maps the property price from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toEntity_price(final CarDto in) {
    return in.getPrice();
  }
  
  /**
   * Maps the property manufacturer from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return the mapped dto
   * 
   */
  protected ManufacturerDto toDto_manufacturer(final Car in) {
    org.lunifera.dsl.dto.lib.IMapper<ManufacturerDto, Manufacturer> mapper = getMapper(ManufacturerDto.class, Manufacturer.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    ManufacturerDto dto = new ManufacturerDto();
    mapper.mapToDTO(dto, in.getManufacturer());	
    
    return dto;
  }
  
  /**
   * Maps the property manufacturer from the given dto to the entity.
   * 
   * @param in - The source dto
   * @return the mapped entity
   * 
   */
  protected Manufacturer toEntity_manufacturer(final CarDto in) {
    org.lunifera.dsl.dto.lib.IMapper<ManufacturerDto, Manufacturer> mapper = getMapper(ManufacturerDto.class, Manufacturer.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    Manufacturer entity = new Manufacturer();
    mapper.mapToEntity(in.getManufacturer(), entity);	
    
    return entity;
  }
}

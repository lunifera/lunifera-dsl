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
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Car;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Manufacturer;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CarDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.ManufacturerDto;

/**
 * This class maps the dto {@link CarDto} to and from the entity {@link Car}.
 * 
 */
@SuppressWarnings("all")
public class CarDtoMapper<DTO extends CarDto, ENTITY extends Car> implements IMapper<DTO, ENTITY> {
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
  public Car createEntity() {
    return new Car();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public CarDto createDto() {
    return new CarDto();
  }
  
  /**
   * Maps the entity {@link Car} to the dto {@link CarDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final CarDto dto, final Car entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    dto.setId(toDto_id(entity, context));
    dto.setModelname(toDto_modelname(entity, context));
    dto.setConstructiondate(toDto_constructiondate(entity, context));
    dto.setPrice(toDto_price(entity, context));
    if(dto.getManufacturer() == null) {
    	// manufacturer is container property. So check for null to avoid looping
    	dto.setManufacturer(toDto_manufacturer(entity, context));
    }
  }
  
  /**
   * Maps the dto {@link CarDto} to the entity {@link Car}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final CarDto dto, final Car entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    
    entity.setId(toEntity_id(dto, context));
    entity.setModelname(toEntity_modelname(dto, context));
    entity.setConstructiondate(toEntity_constructiondate(dto, context));
    entity.setPrice(toEntity_price(dto, context));
    if(entity.getManufacturer() == null) {
    	// manufacturer is container property. So check for null to avoid looping
    	entity.setManufacturer(toEntity_manufacturer(dto, context));
    }
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected long toDto_id(final Car in, final MappingContext context) {
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
  protected long toEntity_id(final CarDto in, final MappingContext context) {
    return in.getId();
  }
  
  /**
   * Maps the property modelname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_modelname(final Car in, final MappingContext context) {
    return in.getModelname();
  }
  
  /**
   * Maps the property modelname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_modelname(final CarDto in, final MappingContext context) {
    return in.getModelname();
  }
  
  /**
   * Maps the property constructiondate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Date toDto_constructiondate(final Car in, final MappingContext context) {
    return in.getConstructiondate();
  }
  
  /**
   * Maps the property constructiondate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Date toEntity_constructiondate(final CarDto in, final MappingContext context) {
    return in.getConstructiondate();
  }
  
  /**
   * Maps the property price from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toDto_price(final Car in, final MappingContext context) {
    return in.getPrice();
  }
  
  /**
   * Maps the property price from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toEntity_price(final CarDto in, final MappingContext context) {
    return in.getPrice();
  }
  
  /**
   * Maps the property manufacturer from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped dto
   * 
   */
  protected ManufacturerDto toDto_manufacturer(final Car in, final MappingContext context) {
    if(in.getManufacturer() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<ManufacturerDto, Manufacturer> mapper = (org.lunifera.dsl.dto.lib.IMapper<ManufacturerDto, Manufacturer>) getToDtoMapper(ManufacturerDto.class, in.getManufacturer().getClass());
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    	ManufacturerDto dto = null;
    	dto = context.get(mapper.createDtoHash(in.getManufacturer()));
    	if(dto != null) {
    		if(context.isRefresh()){
    			mapper.mapToDTO(dto, in.getManufacturer(), context);
    		}
    		return dto;
    	}
    	
    	dto = mapper.createDto();
    	mapper.mapToDTO(dto, in.getManufacturer(), context);
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property manufacturer from the given dto to the entity.
   * 
   * @param in - The source dto
   * @param context - The context to get information about depth,...
   * @return the mapped entity
   * 
   */
  protected Manufacturer toEntity_manufacturer(final CarDto in, final MappingContext context) {
    if(in.getManufacturer() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<ManufacturerDto, Manufacturer> mapper = (org.lunifera.dsl.dto.lib.IMapper<ManufacturerDto, Manufacturer>) getToEntityMapper(in.getManufacturer().getClass(), Manufacturer.class);
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    
    	Manufacturer entity = null;
    	entity = context.get(mapper.createEntityHash(in.getManufacturer()));
    	if(entity != null) {
    		return entity;
    	}
    
    	entity = mapper.createEntity();
    	mapper.mapToEntity(in.getManufacturer(), entity, context);	
    	return entity;
    } else {
    	return null;
    }	
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(CarDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(Car.class, in);
  }
}

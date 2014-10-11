/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.mapper;

import java.util.List;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Address;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Car;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.CarDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Manufacturer;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.ManufacturerDto;

/**
 * This class maps the dto {@link ManufacturerDto} to and from the entity {@link Manufacturer}.
 * 
 */
@SuppressWarnings("all")
public class ManufacturerDtoMapper implements org.lunifera.dsl.dto.lib.IMapper {
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
   * Maps the entity {@link Manufacturer} to the dto {@link ManufacturerDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final ManufacturerDto dto, final Manufacturer entity) {
    
    dto.setId(toDto_id(entity));
    dto.setName(toDto_name(entity));
    dto.setAddress(toDto_address(entity));
    for(CarDto _dtoValue : toDto_cars(entity)) {
    	dto.addToCars(_dtoValue);
    }
  }
  
  /**
   * Maps the dto {@link ManufacturerDto} to the entity {@link Manufacturer}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final ManufacturerDto dto, final Manufacturer entity) {
    
    entity.setId(toEntity_id(dto));
    
    entity.setName(toEntity_name(dto));
    
    entity.setAddress(toEntity_address(dto));
    
    for(Car _entityValue : toEntity_cars(dto)) {
    	entity.addToCars(_entityValue);
    }
    
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toDto_id(final Manufacturer in) {
    return in.getId();
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toEntity_id(final ManufacturerDto in) {
    return in.getId();
  }
  
  /**
   * Maps the property name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_name(final Manufacturer in) {
    return in.getName();
  }
  
  /**
   * Maps the property name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_name(final ManufacturerDto in) {
    return in.getName();
  }
  
  /**
   * Maps the property address from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto toDto_address(final Manufacturer in) {
    org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = getMapper(AddressDto.class, Address.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    AddressDto dto = new AddressDto();
    mapper.mapToDTO(dto, in.getAddress());	
    
    return dto;
  }
  
  /**
   * Maps the property address from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Address toEntity_address(final ManufacturerDto in) {
    org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = getMapper(AddressDto.class, Address.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    Address entity = new Address();
    mapper.mapToEntity(in.getAddress(), entity);	
    
    return entity;
  }
  
  /**
   * Maps the property cars from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return A list of mapped dtos
   * 
   */
  protected List<CarDto> toDto_cars(final Manufacturer in) {
    org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getMapper(CarDto.class, Car.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<CarDto> results = new java.util.ArrayList<CarDto>();
    for (Car _entity : in.getCars()) {
    	CarDto _dto = new CarDto();
    	mapper.mapToDTO(_dto, _entity);
    	results.add(_dto);
    }
    return results;
  }
  
  /**
   * Maps the property cars from the given dto to the entity.
   * 
   * @param in - The source dto
   * @return A list of mapped entities
   * 
   */
  protected List<Car> toEntity_cars(final ManufacturerDto in) {
    org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getMapper(CarDto.class, Car.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<Car> results = new java.util.ArrayList<Car>();
    for (CarDto _dto : in.getCars()) {
    	Car _entity = new Car();
    	mapper.mapToEntity(_dto, _entity);
    	results.add(_entity);
    }
    return results;
  }
}

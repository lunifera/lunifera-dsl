/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.mapper;

import java.util.List;
import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.IMapperAccess;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Address;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Car;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Manufacturer;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CarDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.ManufacturerDto;

/**
 * This class maps the dto {@link ManufacturerDto} to and from the entity {@link Manufacturer}.
 * 
 */
@SuppressWarnings("all")
public class ManufacturerDtoMapper<DTO extends ManufacturerDto, ENTITY extends Manufacturer> implements IMapper<DTO, ENTITY> {
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
  public Manufacturer createEntity() {
    return new Manufacturer();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public ManufacturerDto createDto() {
    return new ManufacturerDto();
  }
  
  /**
   * Maps the entity {@link Manufacturer} to the dto {@link ManufacturerDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final ManufacturerDto dto, final Manufacturer entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    dto.setId(toDto_id(entity, context));
    dto.setName(toDto_name(entity, context));
    dto.setAddress(toDto_address(entity, context));
    if(dto.getCars().isEmpty()) {
    	for(org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CarDto _dtoValue : toDto_cars(entity, context)) {
    		dto.addToCars(_dtoValue);
    	}
    }
  }
  
  /**
   * Maps the dto {@link ManufacturerDto} to the entity {@link Manufacturer}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final ManufacturerDto dto, final Manufacturer entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    
    entity.setId(toEntity_id(dto, context));
    entity.setName(toEntity_name(dto, context));
    entity.setAddress(toEntity_address(dto, context));
    if(entity.getCars().isEmpty()) {
    	List<Car> cars_entities = new java.util.ArrayList<Car>();
    	for(Car _entityValue : toEntity_cars(dto, context)) {
    		cars_entities.add(_entityValue);
    	}
    	entity.setCars(cars_entities);
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
  protected long toDto_id(final Manufacturer in, final MappingContext context) {
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
  protected long toEntity_id(final ManufacturerDto in, final MappingContext context) {
    return in.getId();
  }
  
  /**
   * Maps the property name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_name(final Manufacturer in, final MappingContext context) {
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
  protected String toEntity_name(final ManufacturerDto in, final MappingContext context) {
    return in.getName();
  }
  
  /**
   * Maps the property address from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected AddressDto toDto_address(final Manufacturer in, final MappingContext context) {
    if(in.getAddress() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = (org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address>) getToDtoMapper(AddressDto.class, in.getAddress().getClass());
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    
    	AddressDto dto = null;
    	dto = mapper.createDto();
    	mapper.mapToDTO(dto, in.getAddress(), context);
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property address from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Address toEntity_address(final ManufacturerDto in, final MappingContext context) {
    if(in.getAddress() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = (org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address>) getToEntityMapper(in.getAddress().getClass(), Address.class);
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    
    	Address entity = mapper.createEntity();
    	mapper.mapToEntity(in.getAddress(), entity, context);
    	return entity;							
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property cars from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return A list of mapped dtos
   * 
   */
  protected List<CarDto> toDto_cars(final Manufacturer in, final MappingContext context) {
    org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getToDtoMapper(CarDto.class, Car.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<CarDto> results = new java.util.ArrayList<CarDto>();
    for (Car _entity : in.getCars()) {
    	CarDto _dto = context.get(mapper.createDtoHash(_entity));
    	if (_dto == null) {
    		_dto = mapper.createDto();
    		mapper.mapToDTO(_dto, _entity, context);
    	} else {
    		if(context.isRefresh()){
    			mapper.mapToDTO(_dto, _entity, context);
    		}
    	}
    	results.add(_dto);
    }
    return results;
  }
  
  /**
   * Maps the property cars from the given dto to the entity.
   * 
   * @param in - The source dto
   * @param context - The context to get information about depth,...
   * @return A list of mapped entities
   * 
   */
  protected List<Car> toEntity_cars(final ManufacturerDto in, final MappingContext context) {
    org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getToEntityMapper(CarDto.class, Car.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<Car> results = new java.util.ArrayList<Car>();
    for (CarDto _dto : in.getCars()) {
    	Car _entity = context.get(mapper.createEntityHash(_dto));
    	if(_entity == null) {
    		_entity = mapper.createEntity();
    		mapper.mapToEntity(_dto, _entity, context);
    	}
    	results.add(_entity);
    }
    return results;
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(ManufacturerDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(Manufacturer.class, in);
  }
}

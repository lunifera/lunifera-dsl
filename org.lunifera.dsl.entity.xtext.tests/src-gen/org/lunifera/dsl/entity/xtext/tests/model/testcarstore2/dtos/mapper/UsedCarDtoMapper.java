/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.mapper;

import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Customer;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.UsedCar;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CustomerDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.UsedCarDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.mapper.CarDtoMapper;

/**
 * This class maps the dto {@link UsedCarDto} to and from the entity {@link UsedCar}.
 * 
 */
@SuppressWarnings("all")
public class UsedCarDtoMapper<DTO extends UsedCarDto, ENTITY extends UsedCar> extends CarDtoMapper<DTO, ENTITY> {
  /**
   * Creates a new instance of the entity
   */
  public UsedCar createEntity() {
    return new UsedCar();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public UsedCarDto createDto() {
    return new UsedCarDto();
  }
  
  /**
   * Maps the entity {@link UsedCar} to the dto {@link UsedCarDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final UsedCarDto dto, final UsedCar entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    super.mapToDTO(dto, entity, context);
    
    dto.setState(toDto_state(entity, context));
    dto.setMileage(toDto_mileage(entity, context));
    dto.setSeller(toDto_seller(entity, context));
  }
  
  /**
   * Maps the dto {@link UsedCarDto} to the entity {@link UsedCar}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final UsedCarDto dto, final UsedCar entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    super.mapToEntity(dto, entity, context);
    
    entity.setState(toEntity_state(dto, context));
    entity.setMileage(toEntity_mileage(dto, context));
    entity.setSeller(toEntity_seller(dto, context));
  }
  
  /**
   * Maps the property state from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_state(final UsedCar in, final MappingContext context) {
    return in.getState();
  }
  
  /**
   * Maps the property state from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_state(final UsedCarDto in, final MappingContext context) {
    return in.getState();
  }
  
  /**
   * Maps the property mileage from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toDto_mileage(final UsedCar in, final MappingContext context) {
    return in.getMileage();
  }
  
  /**
   * Maps the property mileage from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toEntity_mileage(final UsedCarDto in, final MappingContext context) {
    return in.getMileage();
  }
  
  /**
   * Maps the property seller from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped dto
   * 
   */
  protected CustomerDto toDto_seller(final UsedCar in, final MappingContext context) {
    if(in.getSeller() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<CustomerDto, Customer> mapper = (org.lunifera.dsl.dto.lib.IMapper<CustomerDto, Customer>) getToDtoMapper(CustomerDto.class, in.getSeller().getClass());
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    	CustomerDto dto = null;
    	dto = context.get(mapper.createDtoHash(in.getSeller()));
    	if(dto != null) {
    		if(context.isRefresh()){
    			mapper.mapToDTO(dto, in.getSeller(), context);
    		}
    		return dto;
    	}
    	
    	dto = mapper.createDto();
    	mapper.mapToDTO(dto, in.getSeller(), context);
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property seller from the given dto to the entity.
   * 
   * @param in - The source dto
   * @param context - The context to get information about depth,...
   * @return the mapped entity
   * 
   */
  protected Customer toEntity_seller(final UsedCarDto in, final MappingContext context) {
    if(in.getSeller() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<CustomerDto, Customer> mapper = (org.lunifera.dsl.dto.lib.IMapper<CustomerDto, Customer>) getToEntityMapper(in.getSeller().getClass(), Customer.class);
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    
    	Customer entity = null;
    	entity = context.get(mapper.createEntityHash(in.getSeller()));
    	if(entity != null) {
    		return entity;
    	}
    
    	entity = mapper.createEntity();
    	mapper.mapToEntity(in.getSeller(), entity, context);	
    	return entity;
    } else {
    	return null;
    }	
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(UsedCarDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(UsedCar.class, in);
  }
}

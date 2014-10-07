/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.mapper;

import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Customer;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.CustomerDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.UsedCar;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.UsedCarDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.mapper.CarDtoMapper;

/**
 * This class maps the dto {@link UsedCarDto} to and from the entity {@link UsedCar}.
 * 
 */
@SuppressWarnings("all")
public class UsedCarDtoMapper extends CarDtoMapper {
  /**
   * Maps the entity {@link UsedCar} to the dto {@link UsedCarDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final UsedCarDto dto, final UsedCar entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setState(toDto_state(entity));
    dto.setMileage(toDto_mileage(entity));
    dto.setSeller(toDto_seller(entity));
  }
  
  /**
   * Maps the dto {@link UsedCarDto} to the entity {@link UsedCar}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final UsedCarDto dto, final UsedCar entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setState(toEntity_state(dto));
    
    entity.setMileage(toEntity_mileage(dto));
    
    entity.setSeller(toEntity_seller(dto));
    
  }
  
  /**
   * Maps the property state from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_state(final UsedCar in) {
    return in.getState();
  }
  
  /**
   * Maps the property state from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_state(final UsedCarDto in) {
    return in.getState();
  }
  
  /**
   * Maps the property mileage from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toDto_mileage(final UsedCar in) {
    return in.getMileage();
  }
  
  /**
   * Maps the property mileage from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toEntity_mileage(final UsedCarDto in) {
    return in.getMileage();
  }
  
  /**
   * Maps the property seller from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return the mapped dto
   * 
   */
  protected CustomerDto toDto_seller(final UsedCar in) {
    org.lunifera.dsl.dto.lib.IMapper<CustomerDto, Customer> mapper = getMapper(CustomerDto.class, Customer.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    CustomerDto dto = new CustomerDto();
    mapper.mapToDTO(dto, in.getSeller());	
    
    return dto;
  }
  
  /**
   * Maps the property seller from the given dto to the entity.
   * 
   * @param in - The source dto
   * @return the mapped entity
   * 
   */
  protected Customer toEntity_seller(final UsedCarDto in) {
    org.lunifera.dsl.dto.lib.IMapper<CustomerDto, Customer> mapper = getMapper(CustomerDto.class, Customer.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    Customer entity = new Customer();
    mapper.mapToEntity(in.getSeller(), entity);	
    
    return entity;
  }
}

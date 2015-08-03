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
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CustomerDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.mapper.PersonDtoMapper;

/**
 * This class maps the dto {@link CustomerDto} to and from the entity {@link Customer}.
 * 
 */
@SuppressWarnings("all")
public class CustomerDtoMapper<DTO extends CustomerDto, ENTITY extends Customer> extends PersonDtoMapper<DTO, ENTITY> {
  /**
   * Creates a new instance of the entity
   */
  public Customer createEntity() {
    return new Customer();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public CustomerDto createDto() {
    return new CustomerDto();
  }
  
  /**
   * Maps the entity {@link Customer} to the dto {@link CustomerDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final CustomerDto dto, final Customer entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    super.mapToDTO(dto, entity, context);
    
    dto.setIsseller(toDto_isseller(entity, context));
    dto.setIsbuyer(toDto_isbuyer(entity, context));
    dto.setPhonenumber(toDto_phonenumber(entity, context));
    dto.setIban(toDto_iban(entity, context));
    dto.setDiscount(toDto_discount(entity, context));
  }
  
  /**
   * Maps the dto {@link CustomerDto} to the entity {@link Customer}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final CustomerDto dto, final Customer entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    super.mapToEntity(dto, entity, context);
    
    entity.setIsseller(toEntity_isseller(dto, context));
    entity.setIsbuyer(toEntity_isbuyer(dto, context));
    entity.setPhonenumber(toEntity_phonenumber(dto, context));
    entity.setIban(toEntity_iban(dto, context));
    entity.setDiscount(toEntity_discount(dto, context));
  }
  
  /**
   * Maps the property isseller from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected boolean toDto_isseller(final Customer in, final MappingContext context) {
    return in.getIsseller();
  }
  
  /**
   * Maps the property isseller from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected boolean toEntity_isseller(final CustomerDto in, final MappingContext context) {
    return in.getIsseller();
  }
  
  /**
   * Maps the property isbuyer from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected boolean toDto_isbuyer(final Customer in, final MappingContext context) {
    return in.getIsbuyer();
  }
  
  /**
   * Maps the property isbuyer from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected boolean toEntity_isbuyer(final CustomerDto in, final MappingContext context) {
    return in.getIsbuyer();
  }
  
  /**
   * Maps the property phonenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_phonenumber(final Customer in, final MappingContext context) {
    return in.getPhonenumber();
  }
  
  /**
   * Maps the property phonenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_phonenumber(final CustomerDto in, final MappingContext context) {
    return in.getPhonenumber();
  }
  
  /**
   * Maps the property iban from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_iban(final Customer in, final MappingContext context) {
    return in.getIban();
  }
  
  /**
   * Maps the property iban from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_iban(final CustomerDto in, final MappingContext context) {
    return in.getIban();
  }
  
  /**
   * Maps the property discount from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toDto_discount(final Customer in, final MappingContext context) {
    return in.getDiscount();
  }
  
  /**
   * Maps the property discount from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toEntity_discount(final CustomerDto in, final MappingContext context) {
    return in.getDiscount();
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(CustomerDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(Customer.class, in);
  }
}

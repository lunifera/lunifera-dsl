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
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.mapper.PersonDtoMapper;

/**
 * This class maps the dto {@link CustomerDto} to and from the entity {@link Customer}.
 * 
 */
@SuppressWarnings("all")
public class CustomerDtoMapper extends PersonDtoMapper {
  /**
   * Maps the entity {@link Customer} to the dto {@link CustomerDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final CustomerDto dto, final Customer entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setIsseller(toDto_isseller(entity));
    dto.setIsbuyer(toDto_isbuyer(entity));
    dto.setPhonenumber(toDto_phonenumber(entity));
    dto.setIban(toDto_iban(entity));
    dto.setDiscount(toDto_discount(entity));
  }
  
  /**
   * Maps the dto {@link CustomerDto} to the entity {@link Customer}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final CustomerDto dto, final Customer entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setIsseller(toEntity_isseller(dto));
    
    entity.setIsbuyer(toEntity_isbuyer(dto));
    
    entity.setPhonenumber(toEntity_phonenumber(dto));
    
    entity.setIban(toEntity_iban(dto));
    
    entity.setDiscount(toEntity_discount(dto));
    
  }
  
  /**
   * Maps the property isseller from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected boolean toDto_isseller(final Customer in) {
    return in.isIsseller();
  }
  
  /**
   * Maps the property isseller from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected boolean toEntity_isseller(final CustomerDto in) {
    return in.isIsseller();
  }
  
  /**
   * Maps the property isbuyer from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected boolean toDto_isbuyer(final Customer in) {
    return in.isIsbuyer();
  }
  
  /**
   * Maps the property isbuyer from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected boolean toEntity_isbuyer(final CustomerDto in) {
    return in.isIsbuyer();
  }
  
  /**
   * Maps the property phonenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_phonenumber(final Customer in) {
    return in.getPhonenumber();
  }
  
  /**
   * Maps the property phonenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_phonenumber(final CustomerDto in) {
    return in.getPhonenumber();
  }
  
  /**
   * Maps the property iban from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_iban(final Customer in) {
    return in.getIban();
  }
  
  /**
   * Maps the property iban from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_iban(final CustomerDto in) {
    return in.getIban();
  }
  
  /**
   * Maps the property discount from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toDto_discount(final Customer in) {
    return in.getDiscount();
  }
  
  /**
   * Maps the property discount from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toEntity_discount(final CustomerDto in) {
    return in.getDiscount();
  }
}

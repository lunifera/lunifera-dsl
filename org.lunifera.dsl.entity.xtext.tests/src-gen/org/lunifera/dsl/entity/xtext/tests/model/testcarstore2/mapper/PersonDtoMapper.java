/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.mapper;

import java.util.Date;
import java.util.List;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Address;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Person;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.PersonDto;

/**
 * This class maps the dto {@link PersonDto} to and from the entity {@link Person}.
 * 
 */
@SuppressWarnings("all")
public class PersonDtoMapper implements org.lunifera.dsl.dto.lib.IMapper {
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
   * Maps the entity {@link Person} to the dto {@link PersonDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final PersonDto dto, final Person entity) {
    
    dto.setId(toDto_id(entity));
    dto.setFirstname(toDto_firstname(entity));
    dto.setLastname(toDto_lastname(entity));
    dto.setBirthdate(toDto_birthdate(entity));
    for(Address _dtoValue : toDto_address(entity)) {
    	dto.addToAddress(_dtoValue);
    }
  }
  
  /**
   * Maps the dto {@link PersonDto} to the entity {@link Person}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final PersonDto dto, final Person entity) {
    
    entity.setId(toEntity_id(dto));
    
    entity.setFirstname(toEntity_firstname(dto));
    
    entity.setLastname(toEntity_lastname(dto));
    
    entity.setBirthdate(toEntity_birthdate(dto));
    
    for(Address _entityValue : toEntity_address(dto)) {
    	entity.addToAddress(_entityValue);
    }
    
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toDto_id(final Person in) {
    return in.getId();
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toEntity_id(final PersonDto in) {
    return in.getId();
  }
  
  /**
   * Maps the property firstname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_firstname(final Person in) {
    return in.getFirstname();
  }
  
  /**
   * Maps the property firstname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_firstname(final PersonDto in) {
    return in.getFirstname();
  }
  
  /**
   * Maps the property lastname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_lastname(final Person in) {
    return in.getLastname();
  }
  
  /**
   * Maps the property lastname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_lastname(final PersonDto in) {
    return in.getLastname();
  }
  
  /**
   * Maps the property birthdate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Date toDto_birthdate(final Person in) {
    return in.getBirthdate();
  }
  
  /**
   * Maps the property birthdate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Date toEntity_birthdate(final PersonDto in) {
    return in.getBirthdate();
  }
  
  /**
   * Maps the property address from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected /* List<org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto> */Object toDto_address(final Person in) {
    org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = getMapper(AddressDto.class, Address.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<AddressDto> results = new java.util.ArrayList<AddressDto>();
    for (Address _entity : in.getAddress()) {
    	 _dto = new ();
    	mapper.mapToDTO(_dto, _entity);
    	results.add(_dto);
    }
    return results;
  }
  
  /**
   * Maps the property address from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected List<Address> toEntity_address(final PersonDto in) {
    org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = getMapper(AddressDto.class, Address.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<Address> results = new java.util.ArrayList<Address>();
    for (AddressDto _dto : in.getAddressDto()) {
    	Address _entity = new Address();
    	mapper.mapToEntity(_dto, _entity);
    	results.add(_entity);
    }
    return results;
  }
}

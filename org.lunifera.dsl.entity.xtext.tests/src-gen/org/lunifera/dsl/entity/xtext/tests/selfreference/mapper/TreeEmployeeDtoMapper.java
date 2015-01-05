/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.selfreference.mapper;

import java.util.List;

/**
 * This class maps the dto {@link TreeEmployeeDto} to and from the entity {@link TreeEmployee}.
 * 
 */
@SuppressWarnings("all")
public class TreeEmployeeDtoMapper implements org.lunifera.dsl.dto.lib.IMapper {
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
   * Maps the entity {@link TreeEmployee} to the dto {@link TreeEmployeeDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto dto, final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee entity) {
    
    dto.setId(toDto_id(entity));
    dto.setName(toDto_Name(entity));
    for(TreeEmployeeDto _dtoValue : toDto_subordinates(entity)) {
    	dto.addToSubordinates(_dtoValue);
    }
    dto.setBoss(toDto_boss(entity));
  }
  
  /**
   * Maps the dto {@link TreeEmployeeDto} to the entity {@link TreeEmployee}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto dto, final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee entity) {
    
    entity.setId(toEntity_id(dto));
    
    entity.setName(toEntity_Name(dto));
    
    for(TreeEmployee _entityValue : toEntity_subordinates(dto)) {
    	entity.addToSubordinates(_entityValue);
    }
    
    entity.setBoss(toEntity_boss(dto));
    
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toDto_id(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee in) {
    return in.getId();
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toEntity_id(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto in) {
    return in.getId();
  }
  
  /**
   * Maps the property Name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_Name(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee in) {
    return in.getName();
  }
  
  /**
   * Maps the property Name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_Name(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto in) {
    return in.getName();
  }
  
  /**
   * Maps the property subordinates from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return A list of mapped dtos
   * 
   */
  protected /* List<org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto> */Object toDto_subordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee in) {
    org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee> mapper = getMapper(TreeEmployeeDto.class, TreeEmployee.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<TreeEmployeeDto> results = new java.util.ArrayList<TreeEmployeeDto>();
    for (TreeEmployee _entity : in.getSubordinates()) {
    	TreeEmployeeDto _dto = new TreeEmployeeDto();
    	mapper.mapToDTO(_dto, _entity);
    	results.add(_dto);
    }
    return results;
  }
  
  /**
   * Maps the property subordinates from the given dto to the entity.
   * 
   * @param in - The source dto
   * @return A list of mapped entities
   * 
   */
  protected /* List<org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee> */Object toEntity_subordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto in) {
    org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee> mapper = getMapper(TreeEmployeeDto.class, TreeEmployee.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<TreeEmployee> results = new java.util.ArrayList<TreeEmployee>();
    for (TreeEmployeeDto _dto : in.getSubordinates()) {
    	TreeEmployee _entity = new TreeEmployee();
    	mapper.mapToEntity(_dto, _entity);
    	results.add(_entity);
    }
    return results;
  }
  
  /**
   * Maps the property boss from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return the mapped dto
   * 
   */
  protected org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto toDto_boss(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee in) {
    org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee> mapper = getMapper(TreeEmployeeDto.class, TreeEmployee.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    TreeEmployeeDto dto = new TreeEmployeeDto();
    mapper.mapToDTO(dto, in.getBoss());	
    
    return dto;
  }
  
  /**
   * Maps the property boss from the given dto to the entity.
   * 
   * @param in - The source dto
   * @return the mapped entity
   * 
   */
  protected org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee toEntity_boss(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto in) {
    org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee> mapper = getMapper(TreeEmployeeDto.class, TreeEmployee.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    TreeEmployee entity = new TreeEmployee();
    mapper.mapToEntity(in.getBoss(), entity);	
    
    return entity;
  }
}

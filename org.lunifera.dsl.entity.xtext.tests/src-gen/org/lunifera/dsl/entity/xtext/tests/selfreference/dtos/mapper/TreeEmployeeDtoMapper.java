/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.selfreference.dtos.mapper;

import java.util.List;
import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.IMapperAccess;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee;
import org.lunifera.dsl.entity.xtext.tests.selfreference.dtos.TreeEmployeeDto;

/**
 * This class maps the dto {@link TreeEmployeeDto} to and from the entity {@link TreeEmployee}.
 * 
 */
@SuppressWarnings("all")
public class TreeEmployeeDtoMapper<DTO extends TreeEmployeeDto, ENTITY extends TreeEmployee> implements IMapper<DTO, ENTITY> {
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
  public TreeEmployee createEntity() {
    return new TreeEmployee();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public TreeEmployeeDto createDto() {
    return new TreeEmployeeDto();
  }
  
  /**
   * Maps the entity {@link TreeEmployee} to the dto {@link TreeEmployeeDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final TreeEmployeeDto dto, final TreeEmployee entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    dto.setId(toDto_id(entity, context));
    dto.setName(toDto_Name(entity, context));
    if(dto.getSubordinates().isEmpty()) {
    	for(org.lunifera.dsl.entity.xtext.tests.selfreference.dtos.TreeEmployeeDto _dtoValue : toDto_subordinates(entity, context)) {
    		dto.addToSubordinates(_dtoValue);
    	}
    }
    dto.setBoss(toDto_boss(entity, context));
  }
  
  /**
   * Maps the dto {@link TreeEmployeeDto} to the entity {@link TreeEmployee}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final TreeEmployeeDto dto, final TreeEmployee entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    
    entity.setId(toEntity_id(dto, context));
    entity.setName(toEntity_Name(dto, context));
    if(entity.getSubordinates().isEmpty()) {
    	List<TreeEmployee> subordinates_entities = new java.util.ArrayList<TreeEmployee>();
    	for(TreeEmployee _entityValue : toEntity_subordinates(dto, context)) {
    		subordinates_entities.add(_entityValue);
    	}
    	entity.setSubordinates(subordinates_entities);
    }
    entity.setBoss(toEntity_boss(dto, context));
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected long toDto_id(final TreeEmployee in, final MappingContext context) {
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
  protected long toEntity_id(final TreeEmployeeDto in, final MappingContext context) {
    return in.getId();
  }
  
  /**
   * Maps the property Name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_Name(final TreeEmployee in, final MappingContext context) {
    return in.getName();
  }
  
  /**
   * Maps the property Name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_Name(final TreeEmployeeDto in, final MappingContext context) {
    return in.getName();
  }
  
  /**
   * Maps the property subordinates from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return A list of mapped dtos
   * 
   */
  protected List<TreeEmployeeDto> toDto_subordinates(final TreeEmployee in, final MappingContext context) {
    org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee> mapper = getToDtoMapper(TreeEmployeeDto.class, TreeEmployee.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<TreeEmployeeDto> results = new java.util.ArrayList<TreeEmployeeDto>();
    for (TreeEmployee _entity : in.getSubordinates()) {
    	TreeEmployeeDto _dto = context.get(mapper.createDtoHash(_entity));
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
   * Maps the property subordinates from the given dto to the entity.
   * 
   * @param in - The source dto
   * @param context - The context to get information about depth,...
   * @return A list of mapped entities
   * 
   */
  protected List<TreeEmployee> toEntity_subordinates(final TreeEmployeeDto in, final MappingContext context) {
    org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee> mapper = getToEntityMapper(TreeEmployeeDto.class, TreeEmployee.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<TreeEmployee> results = new java.util.ArrayList<TreeEmployee>();
    for (TreeEmployeeDto _dto : in.getSubordinates()) {
    	TreeEmployee _entity = context.get(mapper.createEntityHash(_dto));
    	if(_entity == null) {
    		_entity = mapper.createEntity();
    		mapper.mapToEntity(_dto, _entity, context);
    	}
    	results.add(_entity);
    }
    return results;
  }
  
  /**
   * Maps the property boss from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped dto
   * 
   */
  protected TreeEmployeeDto toDto_boss(final TreeEmployee in, final MappingContext context) {
    if(in.getBoss() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee> mapper = (org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee>) getToDtoMapper(TreeEmployeeDto.class, in.getBoss().getClass());
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    	TreeEmployeeDto dto = null;
    	dto = context.get(mapper.createDtoHash(in.getBoss()));
    	if(dto != null) {
    		if(context.isRefresh()){
    			mapper.mapToDTO(dto, in.getBoss(), context);
    		}
    		return dto;
    	}
    	
    	dto = mapper.createDto();
    	mapper.mapToDTO(dto, in.getBoss(), context);
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property boss from the given dto to the entity.
   * 
   * @param in - The source dto
   * @param context - The context to get information about depth,...
   * @return the mapped entity
   * 
   */
  protected TreeEmployee toEntity_boss(final TreeEmployeeDto in, final MappingContext context) {
    if(in.getBoss() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee> mapper = (org.lunifera.dsl.dto.lib.IMapper<TreeEmployeeDto, TreeEmployee>) getToEntityMapper(in.getBoss().getClass(), TreeEmployee.class);
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    
    	TreeEmployee entity = null;
    	entity = context.get(mapper.createEntityHash(in.getBoss()));
    	if(entity != null) {
    		return entity;
    	}
    
    	entity = mapper.createEntity();
    	mapper.mapToEntity(in.getBoss(), entity, context);	
    	return entity;
    } else {
    	return null;
    }	
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(TreeEmployeeDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(TreeEmployee.class, in);
  }
}

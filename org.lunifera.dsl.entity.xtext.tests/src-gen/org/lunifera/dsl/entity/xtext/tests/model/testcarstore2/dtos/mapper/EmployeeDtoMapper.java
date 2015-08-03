/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.mapper;

import java.util.Date;
import java.util.List;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Employee;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.EmployeeDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.mapper.PersonDtoMapper;

/**
 * This class maps the dto {@link EmployeeDto} to and from the entity {@link Employee}.
 * 
 */
@SuppressWarnings("all")
public class EmployeeDtoMapper<DTO extends EmployeeDto, ENTITY extends Employee> extends PersonDtoMapper<DTO, ENTITY> {
  /**
   * Creates a new instance of the entity
   */
  public Employee createEntity() {
    return new Employee();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public EmployeeDto createDto() {
    return new EmployeeDto();
  }
  
  /**
   * Maps the entity {@link Employee} to the dto {@link EmployeeDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final EmployeeDto dto, final Employee entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    context.register(createDtoHash(entity), dto);
    
    super.mapToDTO(dto, entity, context);
    
    dto.setEmployeenumber(toDto_employeenumber(entity, context));
    dto.setEmployeesince(toDto_employeesince(entity, context));
    dto.setSalary(toDto_salary(entity, context));
    dto.setJobdescription(toDto_jobdescription(entity, context));
    if(dto.getBoss() == null) {
    	// boss is container property. So check for null to avoid looping
    	dto.setBoss(toDto_boss(entity, context));
    }
    if(dto.getSubordinates().isEmpty()) {
    	for(org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.EmployeeDto _dtoValue : toDto_subordinates(entity, context)) {
    		dto.addToSubordinates(_dtoValue);
    	}
    }
  }
  
  /**
   * Maps the dto {@link EmployeeDto} to the entity {@link Employee}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final EmployeeDto dto, final Employee entity, final MappingContext context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(createEntityHash(dto), entity);
    context.registerMappingRoot(createEntityHash(dto), dto);
    super.mapToEntity(dto, entity, context);
    
    entity.setEmployeenumber(toEntity_employeenumber(dto, context));
    entity.setEmployeesince(toEntity_employeesince(dto, context));
    entity.setSalary(toEntity_salary(dto, context));
    entity.setJobdescription(toEntity_jobdescription(dto, context));
    if(entity.getBoss() == null) {
    	// boss is container property. So check for null to avoid looping
    	entity.setBoss(toEntity_boss(dto, context));
    }
    if(entity.getSubordinates().isEmpty()) {
    	List<Employee> subordinates_entities = new java.util.ArrayList<Employee>();
    	for(Employee _entityValue : toEntity_subordinates(dto, context)) {
    		subordinates_entities.add(_entityValue);
    	}
    	entity.setSubordinates(subordinates_entities);
    }
  }
  
  /**
   * Maps the property employeenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected long toDto_employeenumber(final Employee in, final MappingContext context) {
    return in.getEmployeenumber();
  }
  
  /**
   * Maps the property employeenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected long toEntity_employeenumber(final EmployeeDto in, final MappingContext context) {
    return in.getEmployeenumber();
  }
  
  /**
   * Maps the property employeesince from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Date toDto_employeesince(final Employee in, final MappingContext context) {
    return in.getEmployeesince();
  }
  
  /**
   * Maps the property employeesince from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Date toEntity_employeesince(final EmployeeDto in, final MappingContext context) {
    return in.getEmployeesince();
  }
  
  /**
   * Maps the property salary from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toDto_salary(final Employee in, final MappingContext context) {
    return in.getSalary();
  }
  
  /**
   * Maps the property salary from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected int toEntity_salary(final EmployeeDto in, final MappingContext context) {
    return in.getSalary();
  }
  
  /**
   * Maps the property jobdescription from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toDto_jobdescription(final Employee in, final MappingContext context) {
    return in.getJobdescription();
  }
  
  /**
   * Maps the property jobdescription from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected String toEntity_jobdescription(final EmployeeDto in, final MappingContext context) {
    return in.getJobdescription();
  }
  
  /**
   * Maps the property boss from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped dto
   * 
   */
  protected EmployeeDto toDto_boss(final Employee in, final MappingContext context) {
    if(in.getBoss() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee> mapper = (org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee>) getToDtoMapper(EmployeeDto.class, in.getBoss().getClass());
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    	EmployeeDto dto = null;
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
  protected Employee toEntity_boss(final EmployeeDto in, final MappingContext context) {
    if(in.getBoss() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee> mapper = (org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee>) getToEntityMapper(in.getBoss().getClass(), Employee.class);
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    
    	Employee entity = null;
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
  
  /**
   * Maps the property subordinates from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return A list of mapped dtos
   * 
   */
  protected List<EmployeeDto> toDto_subordinates(final Employee in, final MappingContext context) {
    org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee> mapper = getToDtoMapper(EmployeeDto.class, Employee.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<EmployeeDto> results = new java.util.ArrayList<EmployeeDto>();
    for (Employee _entity : in.getSubordinates()) {
    	EmployeeDto _dto = context.get(mapper.createDtoHash(_entity));
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
  protected List<Employee> toEntity_subordinates(final EmployeeDto in, final MappingContext context) {
    org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee> mapper = getToEntityMapper(EmployeeDto.class, Employee.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<Employee> results = new java.util.ArrayList<Employee>();
    for (EmployeeDto _dto : in.getSubordinates()) {
    	Employee _entity = context.get(mapper.createEntityHash(_dto));
    	if(_entity == null) {
    		_entity = mapper.createEntity();
    		mapper.mapToEntity(_dto, _entity, context);
    	}
    	results.add(_entity);
    }
    return results;
  }
  
  public String createDtoHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(EmployeeDto.class, in);
  }
  
  public String createEntityHash(final Object in) {
    return org.lunifera.runtime.common.hash.HashUtil.createObjectWithIdHash(Employee.class, in);
  }
}

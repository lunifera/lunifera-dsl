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
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Employee;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.EmployeeDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.mapper.PersonDtoMapper;

/**
 * This class maps the dto {@link EmployeeDto} to and from the entity {@link Employee}.
 * 
 */
@SuppressWarnings("all")
public class EmployeeDtoMapper extends PersonDtoMapper {
  /**
   * Maps the entity {@link Employee} to the dto {@link EmployeeDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final EmployeeDto dto, final Employee entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setEmployeenumber(toDto_employeenumber(entity));
    dto.setEmployeesince(toDto_employeesince(entity));
    dto.setSalary(toDto_salary(entity));
    dto.setJobdescription(toDto_jobdescription(entity));
    dto.setBoss(toDto_boss(entity));
    for(EmployeeDto _dtoValue : toDto_subordinates(entity)) {
    	dto.addToSubordinates(_dtoValue);
    }
  }
  
  /**
   * Maps the dto {@link EmployeeDto} to the entity {@link Employee}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final EmployeeDto dto, final Employee entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setEmployeenumber(toEntity_employeenumber(dto));
    
    entity.setEmployeesince(toEntity_employeesince(dto));
    
    entity.setSalary(toEntity_salary(dto));
    
    entity.setJobdescription(toEntity_jobdescription(dto));
    
    entity.setBoss(toEntity_boss(dto));
    
    for(Employee _entityValue : toEntity_subordinates(dto)) {
    	entity.addToSubordinates(_entityValue);
    }
    
  }
  
  /**
   * Maps the property employeenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toDto_employeenumber(final Employee in) {
    return in.getEmployeenumber();
  }
  
  /**
   * Maps the property employeenumber from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected long toEntity_employeenumber(final EmployeeDto in) {
    return in.getEmployeenumber();
  }
  
  /**
   * Maps the property employeesince from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Date toDto_employeesince(final Employee in) {
    return in.getEmployeesince();
  }
  
  /**
   * Maps the property employeesince from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Date toEntity_employeesince(final EmployeeDto in) {
    return in.getEmployeesince();
  }
  
  /**
   * Maps the property salary from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toDto_salary(final Employee in) {
    return in.getSalary();
  }
  
  /**
   * Maps the property salary from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toEntity_salary(final EmployeeDto in) {
    return in.getSalary();
  }
  
  /**
   * Maps the property jobdescription from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_jobdescription(final Employee in) {
    return in.getJobdescription();
  }
  
  /**
   * Maps the property jobdescription from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_jobdescription(final EmployeeDto in) {
    return in.getJobdescription();
  }
  
  /**
   * Maps the property boss from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return the mapped dto
   * 
   */
  protected EmployeeDto toDto_boss(final Employee in) {
    org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee> mapper = getMapper(EmployeeDto.class, Employee.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    EmployeeDto dto = new EmployeeDto();
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
  protected Employee toEntity_boss(final EmployeeDto in) {
    org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee> mapper = getMapper(EmployeeDto.class, Employee.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    Employee entity = new Employee();
    mapper.mapToEntity(in.getBoss(), entity);	
    
    return entity;
  }
  
  /**
   * Maps the property subordinates from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return A list of mapped dtos
   * 
   */
  protected List<EmployeeDto> toDto_subordinates(final Employee in) {
    org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee> mapper = getMapper(EmployeeDto.class, Employee.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<EmployeeDto> results = new java.util.ArrayList<EmployeeDto>();
    for (Employee _entity : in.getSubordinates()) {
    	EmployeeDto _dto = new EmployeeDto();
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
  protected List<Employee> toEntity_subordinates(final EmployeeDto in) {
    org.lunifera.dsl.dto.lib.IMapper<EmployeeDto, Employee> mapper = getMapper(EmployeeDto.class, Employee.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<Employee> results = new java.util.ArrayList<Employee>();
    for (EmployeeDto _dto : in.getSubordinates()) {
    	Employee _entity = new Employee();
    	mapper.mapToEntity(_dto, _entity);
    	results.add(_entity);
    }
    return results;
  }
}

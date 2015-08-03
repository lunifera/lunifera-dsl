package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Employee;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.EmployeeDto;

@SuppressWarnings("all")
public class EmployeeService extends AbstractDTOServiceWithMutablePersistence<EmployeeDto, Employee> {
  public EmployeeService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<EmployeeDto> getDtoClass() {
    return EmployeeDto.class;
  }
  
  public EmployeeDto createDto() {
    return new EmployeeDto();
  }
  
  public Employee createEntity() {
    return new Employee();
  }
  
  public Class<Employee> getEntityClass() {
    return Employee.class;
  }
  
  public Object getId(final EmployeeDto dto) {
    return dto.getId();
  }
}

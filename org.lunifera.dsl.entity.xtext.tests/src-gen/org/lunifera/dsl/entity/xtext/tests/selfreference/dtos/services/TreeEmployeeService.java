package org.lunifera.dsl.entity.xtext.tests.selfreference.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee;
import org.lunifera.dsl.entity.xtext.tests.selfreference.dtos.TreeEmployeeDto;

@SuppressWarnings("all")
public class TreeEmployeeService extends AbstractDTOServiceWithMutablePersistence<TreeEmployeeDto, TreeEmployee> {
  public TreeEmployeeService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<TreeEmployeeDto> getDtoClass() {
    return TreeEmployeeDto.class;
  }
  
  public TreeEmployeeDto createDto() {
    return new TreeEmployeeDto();
  }
  
  public TreeEmployee createEntity() {
    return new TreeEmployee();
  }
  
  public Class<TreeEmployee> getEntityClass() {
    return TreeEmployee.class;
  }
  
  public Object getId(final TreeEmployeeDto dto) {
    return dto.getId();
  }
}

package org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseBySubclass;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.BaseBySubclassDto;

@SuppressWarnings("all")
public class BaseBySubclassService extends AbstractDTOServiceWithMutablePersistence<BaseBySubclassDto, BaseBySubclass> {
  public BaseBySubclassService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<BaseBySubclassDto> getDtoClass() {
    return BaseBySubclassDto.class;
  }
  
  public BaseBySubclassDto createDto() {
    return new BaseBySubclassDto();
  }
  
  public BaseBySubclass createEntity() {
    return new BaseBySubclass();
  }
  
  public Class<BaseBySubclass> getEntityClass() {
    return BaseBySubclass.class;
  }
  
  public Object getId(final BaseBySubclassDto dto) {
    return dto.getId();
  }
}

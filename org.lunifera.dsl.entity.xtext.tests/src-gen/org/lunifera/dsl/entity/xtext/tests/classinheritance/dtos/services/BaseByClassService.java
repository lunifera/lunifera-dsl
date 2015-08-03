package org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseByClass;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.BaseByClassDto;

@SuppressWarnings("all")
public class BaseByClassService extends AbstractDTOServiceWithMutablePersistence<BaseByClassDto, BaseByClass> {
  public BaseByClassService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<BaseByClassDto> getDtoClass() {
    return BaseByClassDto.class;
  }
  
  public BaseByClassDto createDto() {
    return new BaseByClassDto();
  }
  
  public BaseByClass createEntity() {
    return new BaseByClass();
  }
  
  public Class<BaseByClass> getEntityClass() {
    return BaseByClass.class;
  }
  
  public Object getId(final BaseByClassDto dto) {
    return dto.getId();
  }
}

package org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.OneBySubclass;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.OneBySubclassDto;

@SuppressWarnings("all")
public class OneBySubclassService extends AbstractDTOServiceWithMutablePersistence<OneBySubclassDto, OneBySubclass> {
  public OneBySubclassService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<OneBySubclassDto> getDtoClass() {
    return OneBySubclassDto.class;
  }
  
  public OneBySubclassDto createDto() {
    return new OneBySubclassDto();
  }
  
  public OneBySubclass createEntity() {
    return new OneBySubclass();
  }
  
  public Class<OneBySubclass> getEntityClass() {
    return OneBySubclass.class;
  }
  
  public Object getId(final OneBySubclassDto dto) {
    return dto.getId();
  }
}

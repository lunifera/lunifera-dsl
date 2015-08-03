package org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.OneByClass;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.OneByClassDto;

@SuppressWarnings("all")
public class OneByClassService extends AbstractDTOServiceWithMutablePersistence<OneByClassDto, OneByClass> {
  public OneByClassService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<OneByClassDto> getDtoClass() {
    return OneByClassDto.class;
  }
  
  public OneByClassDto createDto() {
    return new OneByClassDto();
  }
  
  public OneByClass createEntity() {
    return new OneByClass();
  }
  
  public Class<OneByClass> getEntityClass() {
    return OneByClass.class;
  }
  
  public Object getId(final OneByClassDto dto) {
    return dto.getId();
  }
}

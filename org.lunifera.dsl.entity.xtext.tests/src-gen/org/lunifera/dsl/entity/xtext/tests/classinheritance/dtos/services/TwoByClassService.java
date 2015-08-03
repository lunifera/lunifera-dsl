package org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoByClass;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.TwoByClassDto;

@SuppressWarnings("all")
public class TwoByClassService extends AbstractDTOServiceWithMutablePersistence<TwoByClassDto, TwoByClass> {
  public TwoByClassService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<TwoByClassDto> getDtoClass() {
    return TwoByClassDto.class;
  }
  
  public TwoByClassDto createDto() {
    return new TwoByClassDto();
  }
  
  public TwoByClass createEntity() {
    return new TwoByClass();
  }
  
  public Class<TwoByClass> getEntityClass() {
    return TwoByClass.class;
  }
  
  public Object getId(final TwoByClassDto dto) {
    return dto.getId();
  }
}

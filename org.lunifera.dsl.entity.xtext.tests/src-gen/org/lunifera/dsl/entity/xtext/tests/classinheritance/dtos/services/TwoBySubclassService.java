package org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoBySubclass;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.dtos.TwoBySubclassDto;

@SuppressWarnings("all")
public class TwoBySubclassService extends AbstractDTOServiceWithMutablePersistence<TwoBySubclassDto, TwoBySubclass> {
  public TwoBySubclassService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<TwoBySubclassDto> getDtoClass() {
    return TwoBySubclassDto.class;
  }
  
  public TwoBySubclassDto createDto() {
    return new TwoBySubclassDto();
  }
  
  public TwoBySubclass createEntity() {
    return new TwoBySubclass();
  }
  
  public Class<TwoBySubclass> getEntityClass() {
    return TwoBySubclass.class;
  }
  
  public Object getId(final TwoBySubclassDto dto) {
    return dto.getId();
  }
}

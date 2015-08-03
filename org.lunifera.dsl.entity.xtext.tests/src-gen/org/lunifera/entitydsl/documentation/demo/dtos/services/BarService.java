package org.lunifera.entitydsl.documentation.demo.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.entitydsl.documentation.demo.Bar;
import org.lunifera.entitydsl.documentation.demo.dtos.BarDto;

@SuppressWarnings("all")
public class BarService extends AbstractDTOServiceWithMutablePersistence<BarDto, Bar> {
  public BarService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<BarDto> getDtoClass() {
    return BarDto.class;
  }
  
  public BarDto createDto() {
    return new BarDto();
  }
  
  public Bar createEntity() {
    return new Bar();
  }
  
  public Class<Bar> getEntityClass() {
    return Bar.class;
  }
  
  public Object getId(final BarDto dto) {
    return dto.getId();
  }
}

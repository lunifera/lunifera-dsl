package org.lunifera.dsl.entity.xtext.tests.blobtests.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.blobtests.Foobar;
import org.lunifera.dsl.entity.xtext.tests.blobtests.dtos.FoobarDto;

@SuppressWarnings("all")
public class FoobarService extends AbstractDTOServiceWithMutablePersistence<FoobarDto, Foobar> {
  public FoobarService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<FoobarDto> getDtoClass() {
    return FoobarDto.class;
  }
  
  public FoobarDto createDto() {
    return new FoobarDto();
  }
  
  public Foobar createEntity() {
    return new Foobar();
  }
  
  public Class<Foobar> getEntityClass() {
    return Foobar.class;
  }
  
  public Object getId(final FoobarDto dto) {
    return dto.getId();
  }
}

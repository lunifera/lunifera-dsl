package org.lunifera.entitydsl.documentation.demo.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.entitydsl.documentation.demo.Foo;
import org.lunifera.entitydsl.documentation.demo.dtos.FooDto;

@SuppressWarnings("all")
public class FooService extends AbstractDTOServiceWithMutablePersistence<FooDto, Foo> {
  public FooService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<FooDto> getDtoClass() {
    return FooDto.class;
  }
  
  public FooDto createDto() {
    return new FooDto();
  }
  
  public Foo createEntity() {
    return new Foo();
  }
  
  public Class<Foo> getEntityClass() {
    return Foo.class;
  }
  
  public Object getId(final FooDto dto) {
    return dto.getId();
  }
}

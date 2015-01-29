package org.lunifera.dsl.tests.carstore.entities.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOService;
import org.lunifera.dsl.tests.carstore.entities.Base;
import org.lunifera.dsl.tests.carstore.entities.dtos.BaseDto;

@SuppressWarnings("all")
public class BaseService extends AbstractDTOService<BaseDto, Base> {
  public Class<BaseDto> getDtoClass() {
    return BaseDto.class;
  }
  
  public BaseDto createDto() {
    return new BaseDto();
  }
  
  public Base createEntity() {
    return new Base();
  }
  
  public Class<Base> getEntityClass() {
    return Base.class;
  }
  
  public Object getId(final BaseDto dto) {
    return dto.getUuid();
  }
}

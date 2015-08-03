package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.UsedCar;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.UsedCarDto;

@SuppressWarnings("all")
public class UsedCarService extends AbstractDTOServiceWithMutablePersistence<UsedCarDto, UsedCar> {
  public UsedCarService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<UsedCarDto> getDtoClass() {
    return UsedCarDto.class;
  }
  
  public UsedCarDto createDto() {
    return new UsedCarDto();
  }
  
  public UsedCar createEntity() {
    return new UsedCar();
  }
  
  public Class<UsedCar> getEntityClass() {
    return UsedCar.class;
  }
  
  public Object getId(final UsedCarDto dto) {
    return dto.getId();
  }
}

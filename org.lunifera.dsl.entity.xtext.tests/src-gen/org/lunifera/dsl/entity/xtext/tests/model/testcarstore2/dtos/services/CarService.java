package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Car;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CarDto;

@SuppressWarnings("all")
public class CarService extends AbstractDTOServiceWithMutablePersistence<CarDto, Car> {
  public CarService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<CarDto> getDtoClass() {
    return CarDto.class;
  }
  
  public CarDto createDto() {
    return new CarDto();
  }
  
  public Car createEntity() {
    return new Car();
  }
  
  public Class<Car> getEntityClass() {
    return Car.class;
  }
  
  public Object getId(final CarDto dto) {
    return dto.getId();
  }
}

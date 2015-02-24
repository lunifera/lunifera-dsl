package org.lunifera.dsl.tests.carstore.entities.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOService;
import org.lunifera.dsl.tests.carstore.entities.Car;
import org.lunifera.dsl.tests.carstore.entities.dtos.CarDto;

@SuppressWarnings("all")
public class CarService extends AbstractDTOService<CarDto, Car> {
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
    return dto.getUuid();
  }
}

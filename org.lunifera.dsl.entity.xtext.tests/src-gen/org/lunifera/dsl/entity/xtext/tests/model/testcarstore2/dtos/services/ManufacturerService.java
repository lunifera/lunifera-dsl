package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Manufacturer;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.ManufacturerDto;

@SuppressWarnings("all")
public class ManufacturerService extends AbstractDTOServiceWithMutablePersistence<ManufacturerDto, Manufacturer> {
  public ManufacturerService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<ManufacturerDto> getDtoClass() {
    return ManufacturerDto.class;
  }
  
  public ManufacturerDto createDto() {
    return new ManufacturerDto();
  }
  
  public Manufacturer createEntity() {
    return new Manufacturer();
  }
  
  public Class<Manufacturer> getEntityClass() {
    return Manufacturer.class;
  }
  
  public Object getId(final ManufacturerDto dto) {
    return dto.getId();
  }
}

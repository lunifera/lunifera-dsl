package org.lunifera.entitydsl.documentation.common.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.entitydsl.documentation.common.ABar;
import org.lunifera.entitydsl.documentation.common.dtos.ABarDto;

@SuppressWarnings("all")
public class ABarService extends AbstractDTOServiceWithMutablePersistence<ABarDto, ABar> {
  public ABarService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<ABarDto> getDtoClass() {
    return ABarDto.class;
  }
  
  public ABarDto createDto() {
    return new ABarDto();
  }
  
  public ABar createEntity() {
    return new ABar();
  }
  
  public Class<ABar> getEntityClass() {
    return ABar.class;
  }
  
  public Object getId(final ABarDto dto) {
    return dto.getId();
  }
}

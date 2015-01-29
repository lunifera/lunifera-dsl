package org.lunifera.dsl.tests.carstore.entities.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOService;
import org.lunifera.dsl.tests.carstore.entities.Addon;
import org.lunifera.dsl.tests.carstore.entities.dtos.AddonDto;

@SuppressWarnings("all")
public class AddonService extends AbstractDTOService<AddonDto, Addon> {
  public Class<AddonDto> getDtoClass() {
    return AddonDto.class;
  }
  
  public AddonDto createDto() {
    return new AddonDto();
  }
  
  public Addon createEntity() {
    return new Addon();
  }
  
  public Class<Addon> getEntityClass() {
    return Addon.class;
  }
  
  public Object getId(final AddonDto dto) {
    return dto.getUuid();
  }
}

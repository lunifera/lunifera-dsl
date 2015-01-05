package org.lunifera.dsl.tests.carstore.entities.dtos.mapper;

import org.lunifera.dsl.dto.lib.Context;
import org.lunifera.dsl.tests.carstore.entities.Addon;
import org.lunifera.dsl.tests.carstore.entities.Car;
import org.lunifera.dsl.tests.carstore.entities.dtos.AddonDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.CarDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.mapper.BaseDtoMapper;

/**
 * This class maps the dto {@link AddonDto} to and from the entity {@link Addon}.
 * 
 */
@SuppressWarnings("all")
public class AddonDtoMapper<DTO extends AddonDto, ENTITY extends Addon> extends BaseDtoMapper<DTO, ENTITY> {
  /**
   * Maps the entity {@link Addon} to the dto {@link AddonDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final AddonDto dto, final Addon entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setDescription(toDto_description(entity));
    dto.setCar(toDto_car(entity));
  }
  
  /**
   * Maps the dto {@link AddonDto} to the entity {@link Addon}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final AddonDto dto, final Addon entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setDescription(toEntity_description(dto));
    
    entity.setCar(toEntity_car(dto));
    
  }
  
  /**
   * Maps the property description from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_description(final Addon in) {
    return in.getDescription();
  }
  
  /**
   * Maps the property description from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_description(final AddonDto in) {
    return in.getDescription();
  }
  
  /**
   * Maps the property car from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return the mapped dto
   * 
   */
  protected CarDto toDto_car(final Addon in) {
    org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getMapper(CarDto.class, Car.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    if(in.getCar() != null) {
    	CarDto dto = new CarDto();
    	mapper.mapToDTO(dto, in.getCar());
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property car from the given dto to the entity.
   * 
   * @param in - The source dto
   * @return the mapped entity
   * 
   */
  protected Car toEntity_car(final AddonDto in) {
    org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getMapper(CarDto.class, Car.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    if(in.getCar() != null) {
    	Car entity = new Car();
    	mapper.mapToEntity(in.getCar(), entity);	
    	return entity;
    } else {
    	return null;
    }	
  }
  
  public AddonDtoMapper createDto() {
    return new AddonDto();
  }
  
  public AddonDtoMapper copy(final AddonDtoMapper dto, final Context context) {
    this.context = context;
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    AddonDto newDto = createDto();
    context.register(dto, newDto);
    
    copyContainments(dto, newDto);
    copyCrossReferences(dto, newDto);
    
    return newDto;
  }
  
  public void copyContainments(final AddonDtoMapper dto, final AddonDtoMapper newDto, final Context context) {
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyContainments(dto, newDto, context);
    
  }
  
  public void copyCrossReferences(final AddonDtoMapper dto, final AddonDtoMapper newDto, final org.lunifera.dsl.dto.lib.Context context) {
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyCrossReferences(dto, newDto, context);
  }
}

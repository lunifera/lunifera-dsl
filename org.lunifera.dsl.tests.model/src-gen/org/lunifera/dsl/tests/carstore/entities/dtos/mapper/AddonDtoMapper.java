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
   * Creates a new instance of the entity
   */
  public Addon createEntity() {
    return new Addon();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public AddonDto createDto() {
    return new AddonDto();
  }
  
  /**
   * Maps the entity {@link Addon} to the dto {@link AddonDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final AddonDto dto, final Addon entity, final Context context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(entity, dto);
    
    super.mapToDTO(dto, entity, context);
    
    dto.setDescription(toDto_description(entity, context));
  }
  
  /**
   * Maps the dto {@link AddonDto} to the entity {@link Addon}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final AddonDto dto, final Addon entity, final Context context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(entity, dto);
    
    super.mapToEntity(dto, entity, context);
    
    
    entity.setDescription(toEntity_description(dto, context));
    
    
  }
  
  /**
   * Maps the property description from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toDto_description(final Addon in, final Context context) {
    return in.getDescription();
  }
  
  /**
   * Maps the property description from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toEntity_description(final AddonDto in, final Context context) {
    return in.getDescription();
  }
  
  /**
   * Maps the property car from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped dto
   * 
   */
  protected CarDto toDto_car(final Addon in, final Context context) {
    CarDto dto = context.getTarget(in.getCar());
    if(dto != null) {
    	return dto;
    }
    
    if(in.getCar() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = (org.lunifera.dsl.dto.lib.IMapper<CarDto, Car>) getMapper(CarDto.class, in.getCar().getClass());
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    
    	dto = mapper.createDto();
    	mapper.mapToDTO(dto, in.getCar(), context);
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property car from the given dto to the entity.
   * 
   * @param in - The source dto
   * @param context - The context to get information about depth,...
   * @return the mapped entity
   * 
   */
  protected Car toEntity_car(final AddonDto in, final Context context) {
    Car entity = context.getTarget(in.getCar());
    if(entity != null) {
    	return entity;
    }
    
    if(in.getCar() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = (org.lunifera.dsl.dto.lib.IMapper<CarDto, Car>) getMapper(in.getCar().getClass(), Car.class);
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
    
    	entity = mapper.createEntity();
    	mapper.mapToEntity(in.getCar(), entity, context);	
    	return entity;
    } else {
    	return null;
    }	
  }
}

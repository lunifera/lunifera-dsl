package org.lunifera.dsl.tests.carstore.entities.dtos.mapper;

import java.util.List;
import org.lunifera.dsl.dto.lib.Context;
import org.lunifera.dsl.tests.carstore.entities.Addon;
import org.lunifera.dsl.tests.carstore.entities.Car;
import org.lunifera.dsl.tests.carstore.entities.Person;
import org.lunifera.dsl.tests.carstore.entities.dtos.AddonDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.CarDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.PersonDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.mapper.BaseDtoMapper;

/**
 * This class maps the dto {@link CarDto} to and from the entity {@link Car}.
 * 
 */
@SuppressWarnings("all")
public class CarDtoMapper<DTO extends CarDto, ENTITY extends Car> extends BaseDtoMapper<DTO, ENTITY> {
  /**
   * Maps the entity {@link Car} to the dto {@link CarDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final CarDto dto, final Car entity, final Context context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    super.mapToDTO(dto, entity, context);
    
    dto.setNumber(toDto_number(entity, context));
    dto.setFinishingDate(toDto_finishingDate(entity, context));
    for(org.lunifera.dsl.tests.carstore.entities.dtos.AddonDto _dtoValue : toDto_addons(entity, context)) {
    	dto.addToAddons(_dtoValue);
    }
    dto.setOwner(toDto_owner(entity, context));
  }
  
  /**
   * Maps the dto {@link CarDto} to the entity {@link Car}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final CarDto dto, final Car entity, final Context context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    super.mapToEntity(dto, entity, context);
    
    
    entity.setNumber(toEntity_number(dto, context));
    
    entity.setFinishingDate(toEntity_finishingDate(dto, context));
    
    List<Addon> addons_entities = new java.util.ArrayList<Addon>();
    for(Addon _entityValue : toEntity_addons(dto, context)) {
    	addons_entities.add(_entityValue);
    }
    entity.setAddons(addons_entities);
    
    entity.setOwner(toEntity_owner(dto, context));
    
  }
  
  /**
   * Maps the property number from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toDto_number(final Car in, final Context context) {
    return in.getNumber();
  }
  
  /**
   * Maps the property number from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toEntity_number(final CarDto in, final Context context) {
    return in.getNumber();
  }
  
  /**
   * Maps the property finishingDate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toDto_finishingDate(final Car in, final Context context) {
    return in.getFinishingDate();
  }
  
  /**
   * Maps the property finishingDate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toEntity_finishingDate(final CarDto in, final Context context) {
    return in.getFinishingDate();
  }
  
  /**
   * Maps the property addons from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return A list of mapped dtos
   * 
   */
  protected List<AddonDto> toDto_addons(final Car in, final Context context) {
    org.lunifera.dsl.dto.lib.IMapper<AddonDto, Addon> mapper = getMapper(AddonDto.class, Addon.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<AddonDto> results = new java.util.ArrayList<AddonDto>();
    for (Addon _entity : in.getAddons()) {
    	AddonDto _dto = new AddonDto();
    	mapper.mapToDTO(_dto, _entity, context);
    	results.add(_dto);
    }
    return results;
  }
  
  /**
   * Maps the property addons from the given dto to the entity.
   * 
   * @param in - The source dto
   * @param context - The context to get information about depth,...
   * @return A list of mapped entities
   * 
   */
  protected List<Addon> toEntity_addons(final CarDto in, final Context context) {
    org.lunifera.dsl.dto.lib.IMapper<AddonDto, Addon> mapper = getMapper(AddonDto.class, Addon.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<Addon> results = new java.util.ArrayList<Addon>();
    for (AddonDto _dto : in.getAddons()) {
    	Addon _entity = new Addon();
    	mapper.mapToEntity(_dto, _entity, context);
    	results.add(_entity);
    }
    return results;
  }
  
  /**
   * Maps the property owner from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped dto
   * 
   */
  protected PersonDto toDto_owner(final Car in, final Context context) {
    org.lunifera.dsl.dto.lib.IMapper<PersonDto, Person> mapper = getMapper(PersonDto.class, Person.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    if(in.getOwner() != null) {
    	PersonDto dto = new PersonDto();
    	mapper.mapToDTO(dto, in.getOwner(), context);
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property owner from the given dto to the entity.
   * 
   * @param in - The source dto
   * @param context - The context to get information about depth,...
   * @return the mapped entity
   * 
   */
  protected Person toEntity_owner(final CarDto in, final Context context) {
    org.lunifera.dsl.dto.lib.IMapper<PersonDto, Person> mapper = getMapper(PersonDto.class, Person.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    if(in.getOwner() != null) {
    	Person entity = new Person();
    	mapper.mapToEntity(in.getOwner(), entity, context);	
    	return entity;
    } else {
    	return null;
    }	
  }
}

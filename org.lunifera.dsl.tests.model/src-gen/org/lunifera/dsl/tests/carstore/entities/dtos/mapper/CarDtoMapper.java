package org.lunifera.dsl.tests.carstore.entities.dtos.mapper;

import java.util.Date;
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
   * 
   */
  public void mapToDTO(final CarDto dto, final Car entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setNumber(toDto_number(entity));
    dto.setFinishingDate(toDto_finishingDate(entity));
    for(org.lunifera.dsl.tests.carstore.entities.dtos.AddonDto _dtoValue : toDto_addons(entity)) {
    	dto.addToAddons(_dtoValue);
    }
    dto.setOwner(toDto_owner(entity));
  }
  
  /**
   * Maps the dto {@link CarDto} to the entity {@link Car}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final CarDto dto, final Car entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setNumber(toEntity_number(dto));
    
    entity.setFinishingDate(toEntity_finishingDate(dto));
    
    List<Addon> addons_entities = new java.util.ArrayList<Addon>();
    for(Addon _entityValue : toEntity_addons(dto)) {
    	addons_entities.add(_entityValue);
    }
    entity.setAddons(addons_entities);
    
    entity.setOwner(toEntity_owner(dto));
    
  }
  
  /**
   * Maps the property number from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_number(final Car in) {
    return in.getNumber();
  }
  
  /**
   * Maps the property number from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_number(final CarDto in) {
    return in.getNumber();
  }
  
  /**
   * Maps the property finishingDate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Date toDto_finishingDate(final Car in) {
    return in.getFinishingDate();
  }
  
  /**
   * Maps the property finishingDate from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Date toEntity_finishingDate(final CarDto in) {
    return in.getFinishingDate();
  }
  
  /**
   * Maps the property addons from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return A list of mapped dtos
   * 
   */
  protected List<AddonDto> toDto_addons(final Car in) {
    org.lunifera.dsl.dto.lib.IMapper<AddonDto, Addon> mapper = getMapper(AddonDto.class, Addon.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<AddonDto> results = new java.util.ArrayList<AddonDto>();
    for (Addon _entity : in.getAddons()) {
    	AddonDto _dto = new AddonDto();
    	mapper.mapToDTO(_dto, _entity);
    	results.add(_dto);
    }
    return results;
  }
  
  /**
   * Maps the property addons from the given dto to the entity.
   * 
   * @param in - The source dto
   * @return A list of mapped entities
   * 
   */
  protected List<Addon> toEntity_addons(final CarDto in) {
    org.lunifera.dsl.dto.lib.IMapper<AddonDto, Addon> mapper = getMapper(AddonDto.class, Addon.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<Addon> results = new java.util.ArrayList<Addon>();
    for (AddonDto _dto : in.getAddons()) {
    	Addon _entity = new Addon();
    	mapper.mapToEntity(_dto, _entity);
    	results.add(_entity);
    }
    return results;
  }
  
  /**
   * Maps the property owner from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return the mapped dto
   * 
   */
  protected PersonDto toDto_owner(final Car in) {
    org.lunifera.dsl.dto.lib.IMapper<PersonDto, Person> mapper = getMapper(PersonDto.class, Person.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    if(in.getOwner() != null) {
    	PersonDto dto = new PersonDto();
    	mapper.mapToDTO(dto, in.getOwner());
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property owner from the given dto to the entity.
   * 
   * @param in - The source dto
   * @return the mapped entity
   * 
   */
  protected Person toEntity_owner(final CarDto in) {
    org.lunifera.dsl.dto.lib.IMapper<PersonDto, Person> mapper = getMapper(PersonDto.class, Person.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    if(in.getOwner() != null) {
    	Person entity = new Person();
    	mapper.mapToEntity(in.getOwner(), entity);	
    	return entity;
    } else {
    	return null;
    }	
  }
  
  public CarDtoMapper createDto() {
    return new CarDto();
  }
  
  public CarDtoMapper copy(final CarDtoMapper dto, final Context context) {
    this.context = context;
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    CarDto newDto = createDto();
    context.register(dto, newDto);
    
    copyContainments(dto, newDto);
    copyCrossReferences(dto, newDto);
    
    return newDto;
  }
  
  public void copyContainments(final CarDtoMapper dto, final CarDtoMapper newDto, final Context context) {
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyContainments(dto, newDto, context);
    
  }
  
  public void copyCrossReferences(final CarDtoMapper dto, final CarDtoMapper newDto, final org.lunifera.dsl.dto.lib.Context context) {
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyCrossReferences(dto, newDto, context);
  }
}

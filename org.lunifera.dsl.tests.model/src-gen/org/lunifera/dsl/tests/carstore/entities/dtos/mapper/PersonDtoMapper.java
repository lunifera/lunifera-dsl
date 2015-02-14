package org.lunifera.dsl.tests.carstore.entities.dtos.mapper;

import java.util.List;
import org.lunifera.dsl.dto.lib.Context;
import org.lunifera.dsl.tests.carstore.entities.Address;
import org.lunifera.dsl.tests.carstore.entities.Car;
import org.lunifera.dsl.tests.carstore.entities.Person;
import org.lunifera.dsl.tests.carstore.entities.dtos.CarDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.PersonDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.mapper.BaseDtoMapper;

/**
 * This class maps the dto {@link PersonDto} to and from the entity {@link Person}.
 * 
 */
@SuppressWarnings("all")
public class PersonDtoMapper<DTO extends PersonDto, ENTITY extends Person> extends BaseDtoMapper<DTO, ENTITY> {
  /**
   * Creates a new instance of the entity
   */
  public Person createEntity() {
    return new Person();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public PersonDto createDto() {
    return new PersonDto();
  }
  
  /**
   * Maps the entity {@link Person} to the dto {@link PersonDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final PersonDto dto, final Person entity, final Context context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(entity, dto);
    
    super.mapToDTO(dto, entity, context);
    
    dto.setFirstname(toDto_firstname(entity, context));
    dto.setLastname(toDto_lastname(entity, context));
    for(org.lunifera.dsl.tests.carstore.entities.dtos.CarDto _dtoValue : toDto_ownsCars(entity, context)) {
    	dto.addToOwnsCars(_dtoValue);
    }
    dto.setHomeAddress(toDto_homeAddress(entity, context));
    dto.setWorkAddress(toDto_workAddress(entity, context));
  }
  
  /**
   * Maps the dto {@link PersonDto} to the entity {@link Person}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final PersonDto dto, final Person entity, final Context context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(entity, dto);
    
    super.mapToEntity(dto, entity, context);
    
    
    entity.setFirstname(toEntity_firstname(dto, context));
    
    entity.setLastname(toEntity_lastname(dto, context));
    
    List<Car> ownsCars_entities = new java.util.ArrayList<Car>();
    for(Car _entityValue : toEntity_ownsCars(dto, context)) {
    	ownsCars_entities.add(_entityValue);
    }
    entity.setOwnsCars(ownsCars_entities);
    
    entity.setHomeAddress(toEntity_homeAddress(dto, context));
    
    entity.setWorkAddress(toEntity_workAddress(dto, context));
    
  }
  
  /**
   * Maps the property firstname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toDto_firstname(final Person in, final Context context) {
    return in.getFirstname();
  }
  
  /**
   * Maps the property firstname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toEntity_firstname(final PersonDto in, final Context context) {
    return in.getFirstname();
  }
  
  /**
   * Maps the property lastname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toDto_lastname(final Person in, final Context context) {
    return in.getLastname();
  }
  
  /**
   * Maps the property lastname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toEntity_lastname(final PersonDto in, final Context context) {
    return in.getLastname();
  }
  
  /**
   * Maps the property ownsCars from the given entity to the dto.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return A list of mapped dtos
   * 
   */
  protected List<CarDto> toDto_ownsCars(final Person in, final Context context) {
    org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getMapper(CarDto.class, Car.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    } 
    
    List<CarDto> results = new java.util.ArrayList<CarDto>();
    for (Car _entity : in.getOwnsCars()) {
    	CarDto _dto = context.getTarget(_entity);
    	if (_dto == null) {
    		_dto = mapper.createDto();
    		context.register(_entity, _dto);
    		mapper.mapToDTO(_dto, _entity, context);
    	}
    	results.add(_dto);
    }
    return results;
  }
  
  /**
   * Maps the property ownsCars from the given dto to the entity.
   * 
   * @param in - The source dto
   * @param context - The context to get information about depth,...
   * @return A list of mapped entities
   * 
   */
  protected List<Car> toEntity_ownsCars(final PersonDto in, final Context context) {
    org.lunifera.dsl.dto.lib.IMapper<CarDto, Car> mapper = getMapper(CarDto.class, Car.class);
    if(mapper == null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    List<Car> results = new java.util.ArrayList<Car>();
    for (CarDto _dto : in.getOwnsCars()) {
    	Car _entity = mapper.createEntity();
    	mapper.mapToEntity(_dto, _entity, context);
    	results.add(_entity);
    }
    return results;
  }
  
  /**
   * Maps the property homeAddress from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected org.lunifera.dsl.tests.carstore.dtos.AddressDto toDto_homeAddress(final Person in, final Context context) {
    AddressDto dto = context.getTarget(in.getHomeAddress());
    if(dto != null) {
    	return dto;
    }
    
    if(in.getHomeAddress() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = (org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address>) getMapper(AddressDto.class, in.getHomeAddress().getClass());
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
     
    	dto = mapper.createDto();
    	mapper.mapToDTO(dto, in.getHomeAddress(), context);
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property homeAddress from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Address toEntity_homeAddress(final PersonDto in, final Context context) {
    Address entity = context.getTarget(in.getHomeAddress());
    if(entity != null) {
    	return entity;
    }
    
    if(in.getHomeAddress() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = (org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address>) getMapper(in.getHomeAddress().getClass(), Address.class);
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
     
    	entity = mapper.createEntity();
    	mapper.mapToEntity(in.getHomeAddress(), entity, context);
    	return entity;							
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property workAddress from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected org.lunifera.dsl.tests.carstore.dtos.AddressDto toDto_workAddress(final Person in, final Context context) {
    AddressDto dto = context.getTarget(in.getWorkAddress());
    if(dto != null) {
    	return dto;
    }
    
    if(in.getWorkAddress() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = (org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address>) getMapper(AddressDto.class, in.getWorkAddress().getClass());
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
     
    	dto = mapper.createDto();
    	mapper.mapToDTO(dto, in.getWorkAddress(), context);
    	return dto;
    } else {
    	return null;
    }
  }
  
  /**
   * Maps the property workAddress from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Address toEntity_workAddress(final PersonDto in, final Context context) {
    Address entity = context.getTarget(in.getWorkAddress());
    if(entity != null) {
    	return entity;
    }
    
    if(in.getWorkAddress() != null) {
    	// find a mapper that knows how to map the concrete input type.
    	org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address> mapper = (org.lunifera.dsl.dto.lib.IMapper<AddressDto, Address>) getMapper(in.getWorkAddress().getClass(), Address.class);
    	if(mapper == null) {
    		throw new IllegalStateException("Mapper must not be null!");
    	}
     
    	entity = mapper.createEntity();
    	mapper.mapToEntity(in.getWorkAddress(), entity, context);
    	return entity;							
    } else {
    	return null;
    }
  }
}

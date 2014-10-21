package org.lunifera.dsl.xtext.builder.participant.tests.other.dtos.mapper;

/**
 * This class maps the dto {@link OtherDto} to and from the entity {@link OtherEntity}.
 * 
 */
@SuppressWarnings("all")
public class OtherDtoMapper implements org.lunifera.dsl.xtext.builder.participant.tests.dtos.mapper.SuperDtoMapper {
  /**
   * Maps the entity {@link OtherEntity} to the dto {@link OtherDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final org.lunifera.dsl.xtext.builder.participant.tests.other.dtos.OtherDto dto, final org.lunifera.dsl.xtext.builder.participant.tests.other.OtherEntity entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setMyEntity(toDto_myEntity(entity));
    dto.setSomeValue(toDto_someValue(entity));
  }
  
  /**
   * Maps the dto {@link OtherDto} to the entity {@link OtherEntity}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final org.lunifera.dsl.xtext.builder.participant.tests.other.dtos.OtherDto dto, final org.lunifera.dsl.xtext.builder.participant.tests.other.OtherEntity entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setMyEntity(toEntity_myEntity(dto));
    
    entity.setSomeValue(toEntity_someValue(dto));
    
  }
  
  /**
   * Maps the property myEntity from the given entity to the dto.
   * 
   * @param in - The source entity
   * @return the mapped dto
   * 
   */
  protected org.lunifera.dsl.xtext.builder.participant.tests.dtos.MyEntityDto toDto_myEntity(final org.lunifera.dsl.xtext.builder.participant.tests.other.OtherEntity in) {
    org.lunifera.dsl.dto.lib.IMapper<MyEntityDto, MyEntity> mapper = getMapper(MyEntityDto.class, MyEntity.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    MyEntityDto dto = new MyEntityDto();
    mapper.mapToDTO(dto, in.getMyEntity());	
    
    return dto;
  }
  
  /**
   * Maps the property myEntity from the given dto to the entity.
   * 
   * @param in - The source dto
   * @return the mapped entity
   * 
   */
  protected org.lunifera.dsl.xtext.builder.participant.tests.MyEntity toEntity_myEntity(final org.lunifera.dsl.xtext.builder.participant.tests.other.dtos.OtherDto in) {
    org.lunifera.dsl.dto.lib.IMapper<MyEntityDto, MyEntity> mapper = getMapper(MyEntityDto.class, MyEntity.class);
    if(mapper != null) {
    	throw new IllegalStateException("Mapper must not be null!");
    }
    
    MyEntity entity = new MyEntity();
    mapper.mapToEntity(in.getMyEntity(), entity);	
    
    return entity;
  }
  
  /**
   * Maps the property someValue from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected /*  */Object toDto_someValue(final org.lunifera.dsl.xtext.builder.participant.tests.other.OtherEntity in) {
    return in.getSomeValue();
  }
  
  /**
   * Maps the property someValue from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected /*  */Object toEntity_someValue(final org.lunifera.dsl.xtext.builder.participant.tests.other.dtos.OtherDto in) {
    return in.getSomeValue();
  }
}

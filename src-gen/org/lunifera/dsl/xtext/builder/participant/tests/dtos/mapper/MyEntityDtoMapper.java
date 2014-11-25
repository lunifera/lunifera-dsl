package org.lunifera.dsl.xtext.builder.participant.tests.dtos.mapper;

/**
 * This class maps the dto {@link MyEntityDto} to and from the entity {@link MyEntity}.
 * 
 */
@SuppressWarnings("all")
public class MyEntityDtoMapper implements org.lunifera.dsl.xtext.builder.participant.tests.dtos.mapper.SuperDtoMapper {
  /**
   * Maps the entity {@link MyEntity} to the dto {@link MyEntityDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final org.lunifera.dsl.xtext.builder.participant.tests.dtos.MyEntityDto dto, final org.lunifera.dsl.xtext.builder.participant.tests.MyEntity entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setSomeValue(toDto_someValue(entity));
  }
  
  /**
   * Maps the dto {@link MyEntityDto} to the entity {@link MyEntity}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final org.lunifera.dsl.xtext.builder.participant.tests.dtos.MyEntityDto dto, final org.lunifera.dsl.xtext.builder.participant.tests.MyEntity entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setSomeValue(toEntity_someValue(dto));
    
  }
  
  /**
   * Maps the property someValue from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected /*  */Object toDto_someValue(final org.lunifera.dsl.xtext.builder.participant.tests.MyEntity in) {
    return in.getSomeValue();
  }
  
  /**
   * Maps the property someValue from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected /*  */Object toEntity_someValue(final org.lunifera.dsl.xtext.builder.participant.tests.dtos.MyEntityDto in) {
    return in.getSomeValue();
  }
}

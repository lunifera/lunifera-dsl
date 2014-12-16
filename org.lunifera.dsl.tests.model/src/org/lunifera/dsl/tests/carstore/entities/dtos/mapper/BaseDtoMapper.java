package org.lunifera.dsl.tests.carstore.entities.dtos.mapper;

import org.lunifera.dsl.dto.lib.Context;
import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.IMapperAccess;
import org.lunifera.dsl.tests.carstore.entities.Base;
import org.lunifera.dsl.tests.carstore.entities.dtos.BaseDto;

/**
 * This class maps the dto {@link BaseDto} to and from the entity {@link Base}.
 * 
 */
@SuppressWarnings("all")
public class BaseDtoMapper<DTO extends BaseDto, ENTITY extends Base> implements IMapper<DTO, ENTITY> {
  private IMapperAccess mapperAccess;
  
  /**
   * Returns the mapper instance that may map between the given dto and entity. Or <code>null</code> if no mapper is available.
   * 
   * @param dtoClass - the class of the dto that should be mapped
   * @param entityClass - the class of the entity that should be mapped
   * @return the mapper instance or <code>null</code>
   */
  protected <D, E> IMapper<D, E> getMapper(final Class<D> dtoClass, final Class<E> entityClass) {
    return mapperAccess.getMapper(dtoClass, entityClass);
  }
  
  /**
   * Called by OSGi-DS. Binds the mapper access service.
   * 
   * @param service - The mapper access service
   * 
   */
  protected void bindMapperAccess(final IMapperAccess mapperAccess) {
    this.mapperAccess = mapperAccess;
  }
  
  /**
   * Called by OSGi-DS. Binds the mapper access service.
   * 
   * @param service - The mapper access service
   * 
   */
  protected void unbindMapperAccess(final IMapperAccess mapperAccess) {
    this.mapperAccess = null;
  }
  
  /**
   * Maps the entity {@link Base} to the dto {@link BaseDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final BaseDto dto, final Base entity, Context context) {
    
    dto.setUuid(toDto_uuid(entity));
  }
  
  /**
   * Maps the dto {@link BaseDto} to the entity {@link Base}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final BaseDto dto, final Base entity, Context context) {
    
    entity.setUuid(toEntity_uuid(dto));
    
  }
  
  /**
   * Maps the property uuid from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_uuid(final Base in) {
    return in.getUuid();
  }
  
  /**
   * Maps the property uuid from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_uuid(final BaseDto in) {
    return in.getUuid();
  }
}

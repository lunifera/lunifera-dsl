package org.lunifera.dsl.tests.carstore.entities.dtos.mapper;

import org.lunifera.dsl.dto.lib.IMapper;
import org.lunifera.dsl.dto.lib.IMapperAccess;
import org.lunifera.dsl.tests.carstore.entities.Address;
import org.lunifera.dsl.tests.carstore.entities.dtos.AddressDto;

/**
 * This class maps the dto {@link AddressDto} to and from the entity {@link Address}.
 * 
 */
@SuppressWarnings("all")
public class AddressDtoMapper<DTO extends AddressDto, ENTITY extends Address> implements IMapper<DTO, ENTITY> {
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
   * Creates a new instance of the entity
   */
  public Address createEntity() {
    return new Address();
  }
  
  /**
   * Creates a new instance of the dto
   */
  public AddressDto createDto() {
    return new AddressDto();
  }
  
  /**
   * Maps the entity {@link Address} to the dto {@link AddressDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToDTO(final AddressDto dto, final Address entity, final org.lunifera.dsl.dto.lib.Context context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(entity, dto);
    
    
    dto.setStreetname(toDto_streetname(entity, context));
    dto.setPostalcode(toDto_postalcode(entity, context));
  }
  
  /**
   * Maps the dto {@link AddressDto} to the entity {@link Address}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * @param context - The context to get information about depth,...
   * 
   */
  public void mapToEntity(final AddressDto dto, final Address entity, final org.lunifera.dsl.dto.lib.Context context) {
    if(context == null){
    	throw new IllegalArgumentException("Please pass a context!");
    }
    
    context.register(entity, dto);
    
    
    entity.setStreetname(toEntity_streetname(dto, context));
    
    entity.setPostalcode(toEntity_postalcode(dto, context));
    
  }
  
  /**
   * Maps the property streetname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toDto_streetname(final Address in, final org.lunifera.dsl.dto.lib.Context context) {
    return in.getStreetname();
  }
  
  /**
   * Maps the property streetname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toEntity_streetname(final AddressDto in, final org.lunifera.dsl.dto.lib.Context context) {
    return in.getStreetname();
  }
  
  /**
   * Maps the property postalcode from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toDto_postalcode(final Address in, final org.lunifera.dsl.dto.lib.Context context) {
    return in.getPostalcode();
  }
  
  /**
   * Maps the property postalcode from the given entity to dto property.
   * 
   * @param in - The source entity
   * @param context - The context to get information about depth,...
   * @return the mapped value
   * 
   */
  protected Object toEntity_postalcode(final AddressDto in, final org.lunifera.dsl.dto.lib.Context context) {
    return in.getPostalcode();
  }
}

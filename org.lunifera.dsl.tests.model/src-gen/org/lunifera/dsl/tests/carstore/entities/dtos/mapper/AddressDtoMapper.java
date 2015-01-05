package org.lunifera.dsl.tests.carstore.entities.dtos.mapper;

import org.lunifera.dsl.dto.lib.Context;
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
   * Maps the entity {@link Address} to the dto {@link AddressDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final AddressDto dto, final Address entity) {
    
    dto.setStreetname(toDto_streetname(entity));
    dto.setPostalcode(toDto_postalcode(entity));
  }
  
  /**
   * Maps the dto {@link AddressDto} to the entity {@link Address}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final AddressDto dto, final Address entity) {
    
    entity.setStreetname(toEntity_streetname(dto));
    
    entity.setPostalcode(toEntity_postalcode(dto));
    
  }
  
  /**
   * Maps the property streetname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_streetname(final Address in) {
    return in.getStreetname();
  }
  
  /**
   * Maps the property streetname from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_streetname(final AddressDto in) {
    return in.getStreetname();
  }
  
  /**
   * Maps the property postalcode from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_postalcode(final Address in) {
    return in.getPostalcode();
  }
  
  /**
   * Maps the property postalcode from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_postalcode(final AddressDto in) {
    return in.getPostalcode();
  }
  
  public AddressDtoMapper createDto() {
    return new AddressDto();
  }
  
  public AddressDtoMapper copy(final AddressDtoMapper dto, final Context context) {
    this.context = context;
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    AddressDto newDto = createDto();
    context.register(dto, newDto);
    
    copyContainments(dto, newDto);
    copyCrossReferences(dto, newDto);
    
    return newDto;
  }
  
  public void copyContainments(final AddressDtoMapper dto, final AddressDtoMapper newDto, final Context context) {
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyContainments(dto, newDto, context);
    
  }
  
  public void copyCrossReferences(final AddressDtoMapper dto, final AddressDtoMapper newDto, final org.lunifera.dsl.dto.lib.Context context) {
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyCrossReferences(dto, newDto, context);
  }
}

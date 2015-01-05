/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.classinheritance.mapper;

/**
 * This class maps the dto {@link BaseByClassDto} to and from the entity {@link BaseByClass}.
 * 
 */
@SuppressWarnings("all")
public class BaseByClassDtoMapper implements org.lunifera.dsl.dto.lib.IMapper {
  private org.lunifera.dsl.dto.lib.IMapperAccess mapperAccess;
  
  /**
   * Returns the mapper instance that may map between the given dto and entity. Or <code>null</code> if no mapper is available.
   * 
   * @param dtoClass - the class of the dto that should be mapped
   * @param entityClass - the class of the entity that should be mapped
   * @return the mapper instance or <code>null</code>
   */
  protected <D, E> org.lunifera.dsl.dto.lib.IMapper getMapper(final Class<D> dtoClass, final Class<E> entityClass) {
    return mapperAccess.getMapper(dtoClass, entityClass);
  }
  
  /**
   * Called by OSGi-DS. Binds the mapper access service.
   * 
   * @param service - The mapper access service
   * 
   */
  protected void bindMapperAccess(final org.lunifera.dsl.dto.lib.IMapperAccess mapperAccess) {
    this.mapperAccess = mapperAccess;
  }
  
  /**
   * Called by OSGi-DS. Binds the mapper access service.
   * 
   * @param service - The mapper access service
   * 
   */
  protected void unbindMapperAccess(final org.lunifera.dsl.dto.lib.IMapperAccess mapperAccess) {
    this.mapperAccess = null;
  }
  
  /**
   * Maps the entity {@link BaseByClass} to the dto {@link BaseByClassDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseByClassDto dto, final org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseByClass entity) {
    
    dto.setId(toDto_id(entity));
    dto.setVersion(toDto_version(entity));
  }
  
  /**
   * Maps the dto {@link BaseByClassDto} to the entity {@link BaseByClass}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseByClassDto dto, final org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseByClass entity) {
    
    entity.setId(toEntity_id(dto));
    
    entity.setVersion(toEntity_version(dto));
    
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Long toDto_id(final org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseByClass in) {
    return in.getId();
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Long toEntity_id(final org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseByClassDto in) {
    return in.getId();
  }
  
  /**
   * Maps the property version from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toDto_version(final org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseByClass in) {
    return in.getVersion();
  }
  
  /**
   * Maps the property version from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected int toEntity_version(final org.lunifera.dsl.entity.xtext.tests.classinheritance.BaseByClassDto in) {
    return in.getVersion();
  }
}

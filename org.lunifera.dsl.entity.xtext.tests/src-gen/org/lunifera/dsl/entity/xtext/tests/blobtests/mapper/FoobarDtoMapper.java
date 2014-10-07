/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.tests.blobtests.mapper;

/**
 * This class maps the dto {@link FoobarDto} to and from the entity {@link Foobar}.
 * 
 */
@SuppressWarnings("all")
public class FoobarDtoMapper implements org.lunifera.dsl.dto.lib.IMapper {
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
   * Maps the entity {@link Foobar} to the dto {@link FoobarDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final org.lunifera.dsl.entity.xtext.tests.blobtests.FoobarDto dto, final org.lunifera.dsl.entity.xtext.tests.blobtests.Foobar entity) {
    
    dto.setId(toDto_id(entity));
    dto.setName(toDto_name(entity));
    dto.setMyblob(toDto_myblob(entity));
  }
  
  /**
   * Maps the dto {@link FoobarDto} to the entity {@link Foobar}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final org.lunifera.dsl.entity.xtext.tests.blobtests.FoobarDto dto, final org.lunifera.dsl.entity.xtext.tests.blobtests.Foobar entity) {
    
    entity.setId(toEntity_id(dto));
    
    entity.setName(toEntity_name(dto));
    
    entity.setMyblob(toEntity_myblob(dto));
    
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_id(final org.lunifera.dsl.entity.xtext.tests.blobtests.Foobar in) {
    return in.getId();
  }
  
  /**
   * Maps the property id from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_id(final org.lunifera.dsl.entity.xtext.tests.blobtests.FoobarDto in) {
    return in.getId();
  }
  
  /**
   * Maps the property name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_name(final org.lunifera.dsl.entity.xtext.tests.blobtests.Foobar in) {
    return in.getName();
  }
  
  /**
   * Maps the property name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_name(final org.lunifera.dsl.entity.xtext.tests.blobtests.FoobarDto in) {
    return in.getName();
  }
  
  /**
   * Maps the property myblob from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected byte[] toDto_myblob(final org.lunifera.dsl.entity.xtext.tests.blobtests.Foobar in) {
    return in.getMyblob();
  }
  
  /**
   * Maps the property myblob from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected byte[] toEntity_myblob(final org.lunifera.dsl.entity.xtext.tests.blobtests.FoobarDto in) {
    return in.getMyblob();
  }
}

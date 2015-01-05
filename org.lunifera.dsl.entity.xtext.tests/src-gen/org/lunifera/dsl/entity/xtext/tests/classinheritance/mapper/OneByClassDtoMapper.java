/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.classinheritance.mapper;

/**
 * This class maps the dto {@link OneByClassDto} to and from the entity {@link OneByClass}.
 * 
 */
@SuppressWarnings("all")
public class OneByClassDtoMapper implements org.lunifera.dsl.entity.xtext.tests.classinheritance.mapper.BaseByClassDtoMapper {
  /**
   * Maps the entity {@link OneByClass} to the dto {@link OneByClassDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final org.lunifera.dsl.entity.xtext.tests.classinheritance.OneByClassDto dto, final org.lunifera.dsl.entity.xtext.tests.classinheritance.OneByClass entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setName(toDto_name(entity));
  }
  
  /**
   * Maps the dto {@link OneByClassDto} to the entity {@link OneByClass}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final org.lunifera.dsl.entity.xtext.tests.classinheritance.OneByClassDto dto, final org.lunifera.dsl.entity.xtext.tests.classinheritance.OneByClass entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setName(toEntity_name(dto));
    
  }
  
  /**
   * Maps the property name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toDto_name(final org.lunifera.dsl.entity.xtext.tests.classinheritance.OneByClass in) {
    return in.getName();
  }
  
  /**
   * Maps the property name from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected String toEntity_name(final org.lunifera.dsl.entity.xtext.tests.classinheritance.OneByClassDto in) {
    return in.getName();
  }
}

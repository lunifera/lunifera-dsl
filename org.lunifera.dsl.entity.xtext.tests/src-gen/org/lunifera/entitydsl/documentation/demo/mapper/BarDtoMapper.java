/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.entitydsl.documentation.demo.mapper;

/**
 * This class maps the dto {@link BarDto} to and from the entity {@link Bar}.
 * 
 */
@SuppressWarnings("all")
public class BarDtoMapper implements org.lunifera.entitydsl.documentation.demo.mapper.FooDtoMapper {
  /**
   * Maps the entity {@link Bar} to the dto {@link BarDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final org.lunifera.entitydsl.documentation.demo.BarDto dto, final org.lunifera.entitydsl.documentation.demo.Bar entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setNumber(toDto_number(entity));
  }
  
  /**
   * Maps the dto {@link BarDto} to the entity {@link Bar}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final org.lunifera.entitydsl.documentation.demo.BarDto dto, final org.lunifera.entitydsl.documentation.demo.Bar entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setNumber(toEntity_number(dto));
    
  }
  
  /**
   * Maps the property number from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Long toDto_number(final org.lunifera.entitydsl.documentation.demo.Bar in) {
    return in.getNumber();
  }
  
  /**
   * Maps the property number from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Long toEntity_number(final org.lunifera.entitydsl.documentation.demo.BarDto in) {
    return in.getNumber();
  }
}

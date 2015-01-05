/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.classinheritance.mapper;

/**
 * This class maps the dto {@link TwoByClassDto} to and from the entity {@link TwoByClass}.
 * 
 */
@SuppressWarnings("all")
public class TwoByClassDtoMapper implements org.lunifera.dsl.entity.xtext.tests.classinheritance.mapper.OneByClassDtoMapper {
  /**
   * Maps the entity {@link TwoByClass} to the dto {@link TwoByClassDto}.
   * 
   * @param dto - The target dto
   * @param entity - The source entity
   * 
   */
  public void mapToDTO(final org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoByClassDto dto, final org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoByClass entity) {
    super.mapToDTO(dto, entity);
    
    
    dto.setStuff(toDto_stuff(entity));
  }
  
  /**
   * Maps the dto {@link TwoByClassDto} to the entity {@link TwoByClass}.
   * 
   * @param dto - The source dto
   * @param entity - The target entity
   * 
   */
  public void mapToEntity(final org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoByClassDto dto, final org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoByClass entity) {
    super.mapToEntity(dto, entity);
    
    
    entity.setStuff(toEntity_stuff(dto));
    
  }
  
  /**
   * Maps the property stuff from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Long toDto_stuff(final org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoByClass in) {
    return in.getStuff();
  }
  
  /**
   * Maps the property stuff from the given entity to dto property.
   * 
   * @param in - The source entity
   * @return the mapped value
   * 
   */
  protected Long toEntity_stuff(final org.lunifera.dsl.entity.xtext.tests.classinheritance.TwoByClassDto in) {
    return in.getStuff();
  }
}

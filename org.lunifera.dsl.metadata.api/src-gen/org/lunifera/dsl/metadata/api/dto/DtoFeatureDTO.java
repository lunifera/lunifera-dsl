package org.lunifera.dsl.metadata.api.dto;

import java.io.Serializable;

@SuppressWarnings("all")
public class DtoFeatureDTO implements org.lunifera.dsl.metadata.api.types.FeatureDTO, Serializable {
  private org.lunifera.dsl.metadata.api.dto.DtoDTO dto;
  
  private org.lunifera.dsl.metadata.api.dto.DtoMapperDTO mapper;
  
  /**
   * Checks whether the object is disposed.
   * @throws RuntimeException if the object is disposed.
   */
  private void checkDisposed() {
    if (isDisposed()) {
      throw new RuntimeException("Object already disposed: " + this);
    }
  }
  
  /**
   * Calling dispose will destroy that instance. The internal state will be 
   * set to 'disposed' and methods of that object must not be used anymore. 
   * Each call will result in runtime exceptions.<br/>
   * If this object keeps composition containments, these will be disposed too. 
   * So the whole composition containment tree will be disposed on calling this method.
   */
  public void dispose() {
    if (isDisposed()) {
      return;
    }
    try {
      // Dispose all the composition references.
      if (this.mapper != null) {
        this.mapper.dispose();
        this.mapper = null;
      }
      
    }
    finally {
      super.dispose();
    }
    
  }
  
  /**
   * Returns the dto property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.dto.DtoDTO getDto() {
    checkDisposed();
    return this.dto;
  }
  
  /**
   * Sets the <code>dto</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>DtoDTO#
   * features</code> of the <code>dto</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link DtoDTO#setFeatures(DtoDTO)
   * 
   * @param dto - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setDto(final org.lunifera.dsl.metadata.api.dto.DtoDTO dto) {
    checkDisposed();
    if (this.dto != null) {
      this.dto.internalRemoveFromFeatures(this);
    }
    internalSetDto(dto);
    if (this.dto != null) {
      this.dto.internalAddToFeatures(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetDto(final org.lunifera.dsl.metadata.api.dto.DtoDTO dto) {
    firePropertyChange("dto", this.dto, this.dto = dto);
  }
  
  /**
   * Returns the mapper property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.dto.DtoMapperDTO getMapper() {
    checkDisposed();
    return this.mapper;
  }
  
  /**
   * Sets the <code>mapper</code> property to this instance.
   * 
   * @param mapper - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setMapper(final org.lunifera.dsl.metadata.api.dto.DtoMapperDTO mapper) {
    checkDisposed();
    firePropertyChange("mapper", this.mapper, this.mapper = mapper);
  }
  
  /**
   * For internal use only!
   */
  void internalSetMapper(final org.lunifera.dsl.metadata.api.dto.DtoMapperDTO mapper) {
    firePropertyChange("mapper", this.mapper, this.mapper = mapper);
  }
}

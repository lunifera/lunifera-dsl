package org.lunifera.dsl.metadata.api.dto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class DtoDTO implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private /* List<org.lunifera.dsl.metadata.api.dto.DtoFeatureDTO> */Object features;
  
  private org.lunifera.dsl.metadata.api.dto.DtoDTO superType;
  
  private /* List<org.lunifera.dsl.metadata.api.dto.DtoDTO> */Object subTypes;
  
  private org.lunifera.dsl.metadata.api.types.TypeDTO wrappedType;
  
  /**
   * Returns true, if the object is disposed. 
   * Disposed means, that it is prepared for garbage collection and may not be used anymore. 
   * Accessing objects that are already disposed will cause runtime exceptions.
   */
  public boolean isDisposed() {
    return this.disposed;
  }
  
  /**
   * @see PropertyChangeSupport#addPropertyChangeListener(PropertyChangeListener)
   */
  public void addPropertyChangeListener(final PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }
  
  /**
   * @see PropertyChangeSupport#addPropertyChangeListener(String, PropertyChangeListener)
   */
  public void addPropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
  }
  
  /**
   * @see PropertyChangeSupport#removePropertyChangeListener(PropertyChangeListener)
   */
  public void removePropertyChangeListener(final PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }
  
  /**
   * @see PropertyChangeSupport#removePropertyChangeListener(String, PropertyChangeListener)
   */
  public void removePropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
  }
  
  /**
   * @see PropertyChangeSupport#firePropertyChange(String, Object, Object)
   */
  public void firePropertyChange(final String propertyName, final Object oldValue, final Object newValue) {
    propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
  }
  
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
      if (this.features != null) {
        for (DtoFeatureDTO dtoFeatureDTO : this.features) {
          dtoFeatureDTO.dispose();
        }
        this.features = null;
      }
      
    }
    finally {
      disposed = true;
    }
    
  }
  
  /**
   * Returns an unmodifiable list of features.
   */
  public /* List<org.lunifera.dsl.metadata.api.dto.DtoFeatureDTO> */Object getFeatures() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetFeatures());
  }
  
  /**
   * Returns the list of <code>DtoFeatureDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private /* List<org.lunifera.dsl.metadata.api.dto.DtoFeatureDTO> */Object internalGetFeatures() {
    if (this.features == null) {
      this.features = new java.util.ArrayList<DtoFeatureDTO>();
    }
    return this.features;
  }
  
  /**
   * Adds the given dtoFeatureDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>DtoFeatureDTO#^dto</code> of the <code>dtoFeatureDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link DtoFeatureDTO#setDto(DtoFeatureDTO)}.
   * 
   * @param dtoFeatureDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToFeatures(final org.lunifera.dsl.metadata.api.dto.DtoFeatureDTO dtoFeatureDTO) {
    checkDisposed();
    dtoFeatureDTO.setDto(this);
  }
  
  /**
   * Removes the given dtoFeatureDTO from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (DtoFeatureDTO.^dto)
   * of the dtoFeatureDTO will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link DtoFeatureDTO#setDto(DtoFeatureDTO)}.
   * 
   * @param dtoFeatureDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromFeatures(final org.lunifera.dsl.metadata.api.dto.DtoFeatureDTO dtoFeatureDTO) {
    checkDisposed();
    dtoFeatureDTO.setDto(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToFeatures(final org.lunifera.dsl.metadata.api.dto.DtoFeatureDTO dtoFeatureDTO) {
    internalGetFeatures().add(dtoFeatureDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromFeatures(final org.lunifera.dsl.metadata.api.dto.DtoFeatureDTO dtoFeatureDTO) {
    internalGetFeatures().remove(dtoFeatureDTO);
  }
  
  /**
   * Returns the superType property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.dto.DtoDTO getSuperType() {
    checkDisposed();
    return this.superType;
  }
  
  /**
   * Sets the <code>superType</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>DtoDTO#
   * subTypes</code> of the <code>superType</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link DtoDTO#setSubTypes(DtoDTO)
   * 
   * @param superType - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSuperType(final org.lunifera.dsl.metadata.api.dto.DtoDTO superType) {
    checkDisposed();
    if (this.superType != null) {
      this.superType.internalRemoveFromSubTypes(this);
    }
    internalSetSuperType(superType);
    if (this.superType != null) {
      this.superType.internalAddToSubTypes(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetSuperType(final org.lunifera.dsl.metadata.api.dto.DtoDTO superType) {
    firePropertyChange("superType", this.superType, this.superType = superType);
  }
  
  /**
   * Returns an unmodifiable list of subTypes.
   */
  public /* List<org.lunifera.dsl.metadata.api.dto.DtoDTO> */Object getSubTypes() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetSubTypes());
  }
  
  /**
   * Returns the list of <code>DtoDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private /* List<org.lunifera.dsl.metadata.api.dto.DtoDTO> */Object internalGetSubTypes() {
    if (this.subTypes == null) {
      this.subTypes = new java.util.ArrayList<DtoDTO>();
    }
    return this.subTypes;
  }
  
  /**
   * Adds the given dtoDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>DtoDTO#superType</code> of the <code>dtoDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link DtoDTO#setSuperType(DtoDTO)}.
   * 
   * @param dtoDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToSubTypes(final org.lunifera.dsl.metadata.api.dto.DtoDTO dtoDTO) {
    checkDisposed();
    dtoDTO.setSuperType(this);
  }
  
  /**
   * Removes the given dtoDTO from this object. <p>
   * 
   * @param dtoDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromSubTypes(final org.lunifera.dsl.metadata.api.dto.DtoDTO dtoDTO) {
    checkDisposed();
    dtoDTO.setSuperType(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToSubTypes(final org.lunifera.dsl.metadata.api.dto.DtoDTO dtoDTO) {
    internalGetSubTypes().add(dtoDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromSubTypes(final org.lunifera.dsl.metadata.api.dto.DtoDTO dtoDTO) {
    internalGetSubTypes().remove(dtoDTO);
  }
  
  /**
   * Returns the wrappedType property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.TypeDTO getWrappedType() {
    checkDisposed();
    return this.wrappedType;
  }
  
  /**
   * Sets the <code>wrappedType</code> property to this instance.
   * 
   * @param wrappedType - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setWrappedType(final org.lunifera.dsl.metadata.api.types.TypeDTO wrappedType) {
    checkDisposed();
    firePropertyChange("wrappedType", this.wrappedType, this.wrappedType = wrappedType);
  }
}

package org.lunifera.dsl.metadata.api.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.lunifera.dsl.metadata.api.entity.BeanFeatureDTO;

@SuppressWarnings("all")
public class BeanDTO implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private boolean abstractFlag;
  
  private boolean serializableFlag;
  
  private String shortName;
  
  private List<BeanFeatureDTO> features;
  
  private BeanDTO superType;
  
  private List<BeanDTO> subTypes;
  
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
        for (BeanFeatureDTO beanFeatureDTO : this.features) {
          beanFeatureDTO.dispose();
        }
        this.features = null;
      }
      
    }
    finally {
      disposed = true;
    }
    
  }
  
  /**
   * Returns the abstractFlag property or <code>null</code> if not present.
   */
  public boolean isAbstractFlag() {
    checkDisposed();
    return this.abstractFlag;
  }
  
  /**
   * Sets the <code>abstractFlag</code> property to this instance.
   * 
   * @param abstractFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setAbstractFlag(final boolean abstractFlag) {
    firePropertyChange("abstractFlag", this.abstractFlag, this.abstractFlag = abstractFlag );
  }
  
  /**
   * Returns the serializableFlag property or <code>null</code> if not present.
   */
  public boolean isSerializableFlag() {
    checkDisposed();
    return this.serializableFlag;
  }
  
  /**
   * Sets the <code>serializableFlag</code> property to this instance.
   * 
   * @param serializableFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSerializableFlag(final boolean serializableFlag) {
    firePropertyChange("serializableFlag", this.serializableFlag, this.serializableFlag = serializableFlag );
  }
  
  /**
   * Returns the shortName property or <code>null</code> if not present.
   */
  public String getShortName() {
    checkDisposed();
    return this.shortName;
  }
  
  /**
   * Sets the <code>shortName</code> property to this instance.
   * 
   * @param shortName - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setShortName(final String shortName) {
    firePropertyChange("shortName", this.shortName, this.shortName = shortName );
  }
  
  /**
   * Returns an unmodifiable list of features.
   */
  public List<BeanFeatureDTO> getFeatures() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetFeatures());
  }
  
  /**
   * Returns the list of <code>BeanFeatureDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private List<BeanFeatureDTO> internalGetFeatures() {
    if (this.features == null) {
      this.features = new java.util.ArrayList<BeanFeatureDTO>();
    }
    return this.features;
  }
  
  /**
   * Adds the given beanFeatureDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>BeanFeatureDTO#bean</code> of the <code>beanFeatureDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link BeanFeatureDTO#setBean(BeanFeatureDTO)}.
   * 
   * @param beanFeatureDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToFeatures(final BeanFeatureDTO beanFeatureDTO) {
    checkDisposed();
    beanFeatureDTO.setBean(this);
  }
  
  /**
   * Removes the given beanFeatureDTO from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (BeanFeatureDTO.bean)
   * of the beanFeatureDTO will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link BeanFeatureDTO#setBean(BeanFeatureDTO)}.
   * 
   * @param beanFeatureDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromFeatures(final BeanFeatureDTO beanFeatureDTO) {
    checkDisposed();
    beanFeatureDTO.setBean(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToFeatures(final BeanFeatureDTO beanFeatureDTO) {
    internalGetFeatures().add(beanFeatureDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromFeatures(final BeanFeatureDTO beanFeatureDTO) {
    internalGetFeatures().remove(beanFeatureDTO);
  }
  
  /**
   * Returns the superType property or <code>null</code> if not present.
   */
  public BeanDTO getSuperType() {
    checkDisposed();
    return this.superType;
  }
  
  /**
   * Sets the <code>superType</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>BeanDTO#
   * subTypes</code> of the <code>superType</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link BeanDTO#setSubTypes(BeanDTO)
   * 
   * @param superType - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSuperType(final BeanDTO superType) {
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
  void internalSetSuperType(final BeanDTO superType) {
    firePropertyChange("superType", this.superType, this.superType = superType);
  }
  
  /**
   * Returns an unmodifiable list of subTypes.
   */
  public List<BeanDTO> getSubTypes() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetSubTypes());
  }
  
  /**
   * Returns the list of <code>BeanDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private List<BeanDTO> internalGetSubTypes() {
    if (this.subTypes == null) {
      this.subTypes = new java.util.ArrayList<BeanDTO>();
    }
    return this.subTypes;
  }
  
  /**
   * Adds the given beanDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>BeanDTO#superType</code> of the <code>beanDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link BeanDTO#setSuperType(BeanDTO)}.
   * 
   * @param beanDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToSubTypes(final BeanDTO beanDTO) {
    checkDisposed();
    beanDTO.setSuperType(this);
  }
  
  /**
   * Removes the given beanDTO from this object. <p>
   * 
   * @param beanDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromSubTypes(final BeanDTO beanDTO) {
    checkDisposed();
    beanDTO.setSuperType(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToSubTypes(final BeanDTO beanDTO) {
    internalGetSubTypes().add(beanDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromSubTypes(final BeanDTO beanDTO) {
    internalGetSubTypes().remove(beanDTO);
  }
}

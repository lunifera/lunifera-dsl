package org.lunifera.dsl.metadata.api.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.lunifera.dsl.metadata.api.entity.EntityDTO;
import org.lunifera.dsl.metadata.api.entity.EntityFeatureDTO;

@SuppressWarnings("all")
public class IndexDTO implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private EntityDTO entity;
  
  private boolean uniqueFlag;
  
  private String name;
  
  private List<EntityFeatureDTO> features;
  
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
    disposed = true;
  }
  
  /**
   * Returns the entity property or <code>null</code> if not present.
   */
  public EntityDTO getEntity() {
    checkDisposed();
    return this.entity;
  }
  
  /**
   * Sets the <code>entity</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>EntityDTO#
   * indexes</code> of the <code>entity</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link EntityDTO#setIndexes(EntityDTO)
   * 
   * @param entity - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setEntity(final EntityDTO entity) {
    checkDisposed();
    if (this.entity != null) {
      this.entity.internalRemoveFromIndexes(this);
    }
    internalSetEntity(entity);
    if (this.entity != null) {
      this.entity.internalAddToIndexes(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetEntity(final EntityDTO entity) {
    firePropertyChange("entity", this.entity, this.entity = entity);
  }
  
  /**
   * Returns the uniqueFlag property or <code>null</code> if not present.
   */
  public boolean isUniqueFlag() {
    checkDisposed();
    return this.uniqueFlag;
  }
  
  /**
   * Sets the <code>uniqueFlag</code> property to this instance.
   * 
   * @param uniqueFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setUniqueFlag(final boolean uniqueFlag) {
    firePropertyChange("uniqueFlag", this.uniqueFlag, this.uniqueFlag = uniqueFlag );
  }
  
  /**
   * Returns the name property or <code>null</code> if not present.
   */
  public String getName() {
    checkDisposed();
    return this.name;
  }
  
  /**
   * Sets the <code>name</code> property to this instance.
   * 
   * @param name - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setName(final String name) {
    firePropertyChange("name", this.name, this.name = name );
  }
  
  /**
   * Returns an unmodifiable list of features.
   */
  public List<EntityFeatureDTO> getFeatures() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetFeatures());
  }
  
  /**
   * Returns the list of <code>EntityFeatureDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private List<EntityFeatureDTO> internalGetFeatures() {
    if (this.features == null) {
      this.features = new java.util.ArrayList<EntityFeatureDTO>();
    }
    return this.features;
  }
  
  /**
   * Adds the given entityFeatureDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>EntityFeatureDTO#index</code> of the <code>entityFeatureDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link EntityFeatureDTO#setIndex(EntityFeatureDTO)}.
   * 
   * @param entityFeatureDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToFeatures(final EntityFeatureDTO entityFeatureDTO) {
    checkDisposed();
    entityFeatureDTO.setIndex(this);
  }
  
  /**
   * Removes the given entityFeatureDTO from this object. <p>
   * 
   * @param entityFeatureDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromFeatures(final EntityFeatureDTO entityFeatureDTO) {
    checkDisposed();
    entityFeatureDTO.setIndex(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToFeatures(final EntityFeatureDTO entityFeatureDTO) {
    internalGetFeatures().add(entityFeatureDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromFeatures(final EntityFeatureDTO entityFeatureDTO) {
    internalGetFeatures().remove(entityFeatureDTO);
  }
}

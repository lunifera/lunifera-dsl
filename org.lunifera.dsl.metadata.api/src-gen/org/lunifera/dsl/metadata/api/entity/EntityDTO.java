package org.lunifera.dsl.metadata.api.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.lunifera.dsl.metadata.api.entity.EntityFeatureDTO;
import org.lunifera.dsl.metadata.api.entity.EntityInheritanceStrategyDTO;
import org.lunifera.dsl.metadata.api.entity.EntityPersistenceInfoDTO;
import org.lunifera.dsl.metadata.api.entity.IndexDTO;
import org.lunifera.dsl.metadata.api.types.DateType;

@SuppressWarnings("all")
public class EntityDTO implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private boolean abstractFlag;
  
  private boolean serializableFlag;
  
  private String shortName;
  
  private boolean cacheableFlag;
  
  private boolean historizedFlag;
  
  private boolean timedependentFlag;
  
  private DateType timedependentDateType;
  
  private boolean mappedSuperclassFlag;
  
  private EntityPersistenceInfoDTO persistenceInfo;
  
  private EntityInheritanceStrategyDTO inheritanceStrategy;
  
  private List<EntityFeatureDTO> features;
  
  private List<IndexDTO> indexes;
  
  private EntityDTO superType;
  
  private List<EntityDTO> subTypes;
  
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
      if (this.persistenceInfo != null) {
        this.persistenceInfo.dispose();
        this.persistenceInfo = null;
      }
      if (this.inheritanceStrategy != null) {
        this.inheritanceStrategy.dispose();
        this.inheritanceStrategy = null;
      }
      if (this.features != null) {
        for (EntityFeatureDTO entityFeatureDTO : this.features) {
          entityFeatureDTO.dispose();
        }
        this.features = null;
      }
      if (this.indexes != null) {
        for (IndexDTO indexDTO : this.indexes) {
          indexDTO.dispose();
        }
        this.indexes = null;
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
   * Returns the cacheableFlag property or <code>null</code> if not present.
   */
  public boolean isCacheableFlag() {
    checkDisposed();
    return this.cacheableFlag;
  }
  
  /**
   * Sets the <code>cacheableFlag</code> property to this instance.
   * 
   * @param cacheableFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setCacheableFlag(final boolean cacheableFlag) {
    firePropertyChange("cacheableFlag", this.cacheableFlag, this.cacheableFlag = cacheableFlag );
  }
  
  /**
   * Returns the historizedFlag property or <code>null</code> if not present.
   */
  public boolean isHistorizedFlag() {
    checkDisposed();
    return this.historizedFlag;
  }
  
  /**
   * Sets the <code>historizedFlag</code> property to this instance.
   * 
   * @param historizedFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setHistorizedFlag(final boolean historizedFlag) {
    firePropertyChange("historizedFlag", this.historizedFlag, this.historizedFlag = historizedFlag );
  }
  
  /**
   * Returns the timedependentFlag property or <code>null</code> if not present.
   */
  public boolean isTimedependentFlag() {
    checkDisposed();
    return this.timedependentFlag;
  }
  
  /**
   * Sets the <code>timedependentFlag</code> property to this instance.
   * 
   * @param timedependentFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setTimedependentFlag(final boolean timedependentFlag) {
    firePropertyChange("timedependentFlag", this.timedependentFlag, this.timedependentFlag = timedependentFlag );
  }
  
  /**
   * Returns the timedependentDateType property or <code>null</code> if not present.
   */
  public DateType getTimedependentDateType() {
    checkDisposed();
    return this.timedependentDateType;
  }
  
  /**
   * Sets the <code>timedependentDateType</code> property to this instance.
   * 
   * @param timedependentDateType - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setTimedependentDateType(final DateType timedependentDateType) {
    firePropertyChange("timedependentDateType", this.timedependentDateType, this.timedependentDateType = timedependentDateType );
  }
  
  /**
   * Returns the mappedSuperclassFlag property or <code>null</code> if not present.
   */
  public boolean isMappedSuperclassFlag() {
    checkDisposed();
    return this.mappedSuperclassFlag;
  }
  
  /**
   * Sets the <code>mappedSuperclassFlag</code> property to this instance.
   * 
   * @param mappedSuperclassFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setMappedSuperclassFlag(final boolean mappedSuperclassFlag) {
    firePropertyChange("mappedSuperclassFlag", this.mappedSuperclassFlag, this.mappedSuperclassFlag = mappedSuperclassFlag );
  }
  
  /**
   * Returns the persistenceInfo property or <code>null</code> if not present.
   */
  public EntityPersistenceInfoDTO getPersistenceInfo() {
    checkDisposed();
    return this.persistenceInfo;
  }
  
  /**
   * Sets the <code>persistenceInfo</code> property to this instance.
   * 
   * @param persistenceInfo - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setPersistenceInfo(final EntityPersistenceInfoDTO persistenceInfo) {
    checkDisposed();
    firePropertyChange("persistenceInfo", this.persistenceInfo, this.persistenceInfo = persistenceInfo);
  }
  
  /**
   * For internal use only!
   */
  void internalSetPersistenceInfo(final EntityPersistenceInfoDTO persistenceInfo) {
    firePropertyChange("persistenceInfo", this.persistenceInfo, this.persistenceInfo = persistenceInfo);
  }
  
  /**
   * Returns the inheritanceStrategy property or <code>null</code> if not present.
   */
  public EntityInheritanceStrategyDTO getInheritanceStrategy() {
    checkDisposed();
    return this.inheritanceStrategy;
  }
  
  /**
   * Sets the <code>inheritanceStrategy</code> property to this instance.
   * 
   * @param inheritanceStrategy - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setInheritanceStrategy(final EntityInheritanceStrategyDTO inheritanceStrategy) {
    checkDisposed();
    firePropertyChange("inheritanceStrategy", this.inheritanceStrategy, this.inheritanceStrategy = inheritanceStrategy);
  }
  
  /**
   * For internal use only!
   */
  void internalSetInheritanceStrategy(final EntityInheritanceStrategyDTO inheritanceStrategy) {
    firePropertyChange("inheritanceStrategy", this.inheritanceStrategy, this.inheritanceStrategy = inheritanceStrategy);
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
   * Since the reference is a composition reference, the opposite reference <code>EntityFeatureDTO#entity</code> of the <code>entityFeatureDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link EntityFeatureDTO#setEntity(EntityFeatureDTO)}.
   * 
   * @param entityFeatureDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToFeatures(final EntityFeatureDTO entityFeatureDTO) {
    checkDisposed();
    entityFeatureDTO.setEntity(this);
  }
  
  /**
   * Removes the given entityFeatureDTO from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (EntityFeatureDTO.entity)
   * of the entityFeatureDTO will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link EntityFeatureDTO#setEntity(EntityFeatureDTO)}.
   * 
   * @param entityFeatureDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromFeatures(final EntityFeatureDTO entityFeatureDTO) {
    checkDisposed();
    entityFeatureDTO.setEntity(null);
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
  
  /**
   * Returns an unmodifiable list of indexes.
   */
  public List<IndexDTO> getIndexes() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetIndexes());
  }
  
  /**
   * Returns the list of <code>IndexDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private List<IndexDTO> internalGetIndexes() {
    if (this.indexes == null) {
      this.indexes = new java.util.ArrayList<IndexDTO>();
    }
    return this.indexes;
  }
  
  /**
   * Adds the given indexDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>IndexDTO#entity</code> of the <code>indexDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link IndexDTO#setEntity(IndexDTO)}.
   * 
   * @param indexDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToIndexes(final IndexDTO indexDTO) {
    checkDisposed();
    indexDTO.setEntity(this);
  }
  
  /**
   * Removes the given indexDTO from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (IndexDTO.entity)
   * of the indexDTO will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link IndexDTO#setEntity(IndexDTO)}.
   * 
   * @param indexDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromIndexes(final IndexDTO indexDTO) {
    checkDisposed();
    indexDTO.setEntity(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToIndexes(final IndexDTO indexDTO) {
    internalGetIndexes().add(indexDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromIndexes(final IndexDTO indexDTO) {
    internalGetIndexes().remove(indexDTO);
  }
  
  /**
   * Returns the superType property or <code>null</code> if not present.
   */
  public EntityDTO getSuperType() {
    checkDisposed();
    return this.superType;
  }
  
  /**
   * Sets the <code>superType</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>EntityDTO#
   * subTypes</code> of the <code>superType</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link EntityDTO#setSubTypes(EntityDTO)
   * 
   * @param superType - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSuperType(final EntityDTO superType) {
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
  void internalSetSuperType(final EntityDTO superType) {
    firePropertyChange("superType", this.superType, this.superType = superType);
  }
  
  /**
   * Returns an unmodifiable list of subTypes.
   */
  public List<EntityDTO> getSubTypes() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetSubTypes());
  }
  
  /**
   * Returns the list of <code>EntityDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private List<EntityDTO> internalGetSubTypes() {
    if (this.subTypes == null) {
      this.subTypes = new java.util.ArrayList<EntityDTO>();
    }
    return this.subTypes;
  }
  
  /**
   * Adds the given entityDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>EntityDTO#superType</code> of the <code>entityDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link EntityDTO#setSuperType(EntityDTO)}.
   * 
   * @param entityDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToSubTypes(final EntityDTO entityDTO) {
    checkDisposed();
    entityDTO.setSuperType(this);
  }
  
  /**
   * Removes the given entityDTO from this object. <p>
   * 
   * @param entityDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromSubTypes(final EntityDTO entityDTO) {
    checkDisposed();
    entityDTO.setSuperType(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToSubTypes(final EntityDTO entityDTO) {
    internalGetSubTypes().add(entityDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromSubTypes(final EntityDTO entityDTO) {
    internalGetSubTypes().remove(entityDTO);
  }
}

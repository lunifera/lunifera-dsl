package org.lunifera.dsl.metadata.api.entity;

import java.io.Serializable;
import org.lunifera.dsl.metadata.api.entity.EntityColumnPersistenceInfoDTO;
import org.lunifera.dsl.metadata.api.entity.EntityDTO;
import org.lunifera.dsl.metadata.api.entity.IndexDTO;
import org.lunifera.dsl.metadata.api.types.FeatureDTO;

@SuppressWarnings("all")
public class EntityFeatureDTO extends FeatureDTO implements Serializable {
  private EntityDTO entity;
  
  private IndexDTO index;
  
  private EntityColumnPersistenceInfoDTO persistenceInfo;
  
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
      
    }
    finally {
      super.dispose();
    }
    
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
   * features</code> of the <code>entity</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link EntityDTO#setFeatures(EntityDTO)
   * 
   * @param entity - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setEntity(final EntityDTO entity) {
    checkDisposed();
    if (this.entity != null) {
      this.entity.internalRemoveFromFeatures(this);
    }
    internalSetEntity(entity);
    if (this.entity != null) {
      this.entity.internalAddToFeatures(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetEntity(final EntityDTO entity) {
    firePropertyChange("entity", this.entity, this.entity = entity);
  }
  
  /**
   * Returns the index property or <code>null</code> if not present.
   */
  public IndexDTO getIndex() {
    checkDisposed();
    return this.index;
  }
  
  /**
   * Sets the <code>index</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>IndexDTO#
   * features</code> of the <code>index</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link IndexDTO#setFeatures(IndexDTO)
   * 
   * @param index - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setIndex(final IndexDTO index) {
    checkDisposed();
    if (this.index != null) {
      this.index.internalRemoveFromFeatures(this);
    }
    internalSetIndex(index);
    if (this.index != null) {
      this.index.internalAddToFeatures(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetIndex(final IndexDTO index) {
    firePropertyChange("index", this.index, this.index = index);
  }
  
  /**
   * Returns the persistenceInfo property or <code>null</code> if not present.
   */
  public EntityColumnPersistenceInfoDTO getPersistenceInfo() {
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
  public void setPersistenceInfo(final EntityColumnPersistenceInfoDTO persistenceInfo) {
    checkDisposed();
    firePropertyChange("persistenceInfo", this.persistenceInfo, this.persistenceInfo = persistenceInfo);
  }
  
  /**
   * For internal use only!
   */
  void internalSetPersistenceInfo(final EntityColumnPersistenceInfoDTO persistenceInfo) {
    firePropertyChange("persistenceInfo", this.persistenceInfo, this.persistenceInfo = persistenceInfo);
  }
}

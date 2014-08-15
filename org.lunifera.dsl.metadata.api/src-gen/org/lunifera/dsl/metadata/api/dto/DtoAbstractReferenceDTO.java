package org.lunifera.dsl.metadata.api.dto;

import java.io.Serializable;

@SuppressWarnings("all")
public class DtoAbstractReferenceDTO implements org.lunifera.dsl.metadata.api.dto.DtoFeatureDTO, Serializable {
  private org.lunifera.dsl.metadata.api.dto.DtoDTO type;
  
  private boolean lazyFlag;
  
  private boolean cascadingFlag;
  
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
    super.dispose();
  }
  
  /**
   * Returns the type property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.dto.DtoDTO getType() {
    checkDisposed();
    return this.type;
  }
  
  /**
   * Sets the <code>type</code> property to this instance.
   * 
   * @param type - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setType(final org.lunifera.dsl.metadata.api.dto.DtoDTO type) {
    checkDisposed();
    firePropertyChange("type", this.type, this.type = type);
  }
  
  /**
   * Returns the lazyFlag property or <code>null</code> if not present.
   */
  public boolean isLazyFlag() {
    checkDisposed();
    return this.lazyFlag;
  }
  
  /**
   * Sets the <code>lazyFlag</code> property to this instance.
   * 
   * @param lazyFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setLazyFlag(final boolean lazyFlag) {
    firePropertyChange("lazyFlag", this.lazyFlag, this.lazyFlag = lazyFlag );
  }
  
  /**
   * Returns the cascadingFlag property or <code>null</code> if not present.
   */
  public boolean isCascadingFlag() {
    checkDisposed();
    return this.cascadingFlag;
  }
  
  /**
   * Sets the <code>cascadingFlag</code> property to this instance.
   * 
   * @param cascadingFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setCascadingFlag(final boolean cascadingFlag) {
    firePropertyChange("cascadingFlag", this.cascadingFlag, this.cascadingFlag = cascadingFlag );
  }
}

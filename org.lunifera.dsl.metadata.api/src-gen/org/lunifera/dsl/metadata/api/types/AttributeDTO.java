package org.lunifera.dsl.metadata.api.types;

import java.io.Serializable;

@SuppressWarnings("all")
public class AttributeDTO implements org.lunifera.dsl.metadata.api.types.FeatureDTO, Serializable {
  private boolean idFlag;
  
  private boolean uuidFlag;
  
  private boolean versionFlag;
  
  private boolean lazyFlag;
  
  private boolean cascadingFlag;
  
  private boolean transientFlag;
  
  private boolean derivedFlag;
  
  private org.lunifera.dsl.metadata.api.types.ScalarTypeDTO type;
  
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
   * Returns the idFlag property or <code>null</code> if not present.
   */
  public boolean isIdFlag() {
    checkDisposed();
    return this.idFlag;
  }
  
  /**
   * Sets the <code>idFlag</code> property to this instance.
   * 
   * @param idFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setIdFlag(final boolean idFlag) {
    firePropertyChange("idFlag", this.idFlag, this.idFlag = idFlag );
  }
  
  /**
   * Returns the uuidFlag property or <code>null</code> if not present.
   */
  public boolean isUuidFlag() {
    checkDisposed();
    return this.uuidFlag;
  }
  
  /**
   * Sets the <code>uuidFlag</code> property to this instance.
   * 
   * @param uuidFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setUuidFlag(final boolean uuidFlag) {
    firePropertyChange("uuidFlag", this.uuidFlag, this.uuidFlag = uuidFlag );
  }
  
  /**
   * Returns the versionFlag property or <code>null</code> if not present.
   */
  public boolean isVersionFlag() {
    checkDisposed();
    return this.versionFlag;
  }
  
  /**
   * Sets the <code>versionFlag</code> property to this instance.
   * 
   * @param versionFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setVersionFlag(final boolean versionFlag) {
    firePropertyChange("versionFlag", this.versionFlag, this.versionFlag = versionFlag );
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
  
  /**
   * Returns the transientFlag property or <code>null</code> if not present.
   */
  public boolean isTransientFlag() {
    checkDisposed();
    return this.transientFlag;
  }
  
  /**
   * Sets the <code>transientFlag</code> property to this instance.
   * 
   * @param transientFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setTransientFlag(final boolean transientFlag) {
    firePropertyChange("transientFlag", this.transientFlag, this.transientFlag = transientFlag );
  }
  
  /**
   * Returns the derivedFlag property or <code>null</code> if not present.
   */
  public boolean isDerivedFlag() {
    checkDisposed();
    return this.derivedFlag;
  }
  
  /**
   * Sets the <code>derivedFlag</code> property to this instance.
   * 
   * @param derivedFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setDerivedFlag(final boolean derivedFlag) {
    firePropertyChange("derivedFlag", this.derivedFlag, this.derivedFlag = derivedFlag );
  }
  
  /**
   * Returns the type property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.ScalarTypeDTO getType() {
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
  public void setType(final org.lunifera.dsl.metadata.api.types.ScalarTypeDTO type) {
    checkDisposed();
    firePropertyChange("type", this.type, this.type = type);
  }
}

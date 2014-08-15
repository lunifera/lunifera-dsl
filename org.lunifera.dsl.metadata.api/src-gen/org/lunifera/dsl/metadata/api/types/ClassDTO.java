package org.lunifera.dsl.metadata.api.types;

import java.io.Serializable;

@SuppressWarnings("all")
public class ClassDTO implements org.lunifera.dsl.metadata.api.types.TypeDTO, Serializable {
  private boolean abstractFlag;
  
  private boolean serializableFlag;
  
  private String shortName;
  
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
}

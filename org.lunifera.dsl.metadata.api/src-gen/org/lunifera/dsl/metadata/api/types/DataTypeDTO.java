package org.lunifera.dsl.metadata.api.types;

import java.io.Serializable;

@SuppressWarnings("all")
public class DataTypeDTO implements org.lunifera.dsl.metadata.api.types.ScalarTypeDTO, Serializable {
  private Class<?> jvmTypeReference;
  
  private boolean asPrimitiveFlag;
  
  private boolean dateFlag;
  
  private boolean asBlobFlag;
  
  private int length;
  
  private org.lunifera.dsl.metadata.api.types.DateType dateType;
  
  private boolean syntheticFlag;
  
  private String syntheticSelector;
  
  private org.lunifera.dsl.metadata.api.types.FeatureDTO syntheticTypeReference;
  
  private org.lunifera.dsl.metadata.api.types.TypeDTO syntheticType;
  
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
   * Returns the jvmTypeReference property or <code>null</code> if not present.
   */
  public Class<?> getJvmTypeReference() {
    checkDisposed();
    return this.jvmTypeReference;
  }
  
  /**
   * Sets the <code>jvmTypeReference</code> property to this instance.
   * 
   * @param jvmTypeReference - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setJvmTypeReference(final Class<?> jvmTypeReference) {
    firePropertyChange("jvmTypeReference", this.jvmTypeReference, this.jvmTypeReference = jvmTypeReference );
  }
  
  /**
   * Returns the asPrimitiveFlag property or <code>null</code> if not present.
   */
  public boolean isAsPrimitiveFlag() {
    checkDisposed();
    return this.asPrimitiveFlag;
  }
  
  /**
   * Sets the <code>asPrimitiveFlag</code> property to this instance.
   * 
   * @param asPrimitiveFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setAsPrimitiveFlag(final boolean asPrimitiveFlag) {
    firePropertyChange("asPrimitiveFlag", this.asPrimitiveFlag, this.asPrimitiveFlag = asPrimitiveFlag );
  }
  
  /**
   * Returns the dateFlag property or <code>null</code> if not present.
   */
  public boolean isDateFlag() {
    checkDisposed();
    return this.dateFlag;
  }
  
  /**
   * Sets the <code>dateFlag</code> property to this instance.
   * 
   * @param dateFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setDateFlag(final boolean dateFlag) {
    firePropertyChange("dateFlag", this.dateFlag, this.dateFlag = dateFlag );
  }
  
  /**
   * Returns the asBlobFlag property or <code>null</code> if not present.
   */
  public boolean isAsBlobFlag() {
    checkDisposed();
    return this.asBlobFlag;
  }
  
  /**
   * Sets the <code>asBlobFlag</code> property to this instance.
   * 
   * @param asBlobFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setAsBlobFlag(final boolean asBlobFlag) {
    firePropertyChange("asBlobFlag", this.asBlobFlag, this.asBlobFlag = asBlobFlag );
  }
  
  /**
   * Returns the length property or <code>null</code> if not present.
   */
  public int getLength() {
    checkDisposed();
    return this.length;
  }
  
  /**
   * Sets the <code>length</code> property to this instance.
   * 
   * @param length - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setLength(final int length) {
    firePropertyChange("length", this.length, this.length = length );
  }
  
  /**
   * Returns the dateType property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.DateType getDateType() {
    checkDisposed();
    return this.dateType;
  }
  
  /**
   * Sets the <code>dateType</code> property to this instance.
   * 
   * @param dateType - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setDateType(final org.lunifera.dsl.metadata.api.types.DateType dateType) {
    firePropertyChange("dateType", this.dateType, this.dateType = dateType );
  }
  
  /**
   * Returns the syntheticFlag property or <code>null</code> if not present.
   */
  public boolean isSyntheticFlag() {
    checkDisposed();
    return this.syntheticFlag;
  }
  
  /**
   * Sets the <code>syntheticFlag</code> property to this instance.
   * 
   * @param syntheticFlag - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSyntheticFlag(final boolean syntheticFlag) {
    firePropertyChange("syntheticFlag", this.syntheticFlag, this.syntheticFlag = syntheticFlag );
  }
  
  /**
   * Returns the syntheticSelector property or <code>null</code> if not present.
   */
  public String getSyntheticSelector() {
    checkDisposed();
    return this.syntheticSelector;
  }
  
  /**
   * Sets the <code>syntheticSelector</code> property to this instance.
   * 
   * @param syntheticSelector - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSyntheticSelector(final String syntheticSelector) {
    firePropertyChange("syntheticSelector", this.syntheticSelector, this.syntheticSelector = syntheticSelector );
  }
  
  /**
   * Returns the syntheticTypeReference property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.FeatureDTO getSyntheticTypeReference() {
    checkDisposed();
    return this.syntheticTypeReference;
  }
  
  /**
   * Sets the <code>syntheticTypeReference</code> property to this instance.
   * 
   * @param syntheticTypeReference - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSyntheticTypeReference(final org.lunifera.dsl.metadata.api.types.FeatureDTO syntheticTypeReference) {
    checkDisposed();
    firePropertyChange("syntheticTypeReference", this.syntheticTypeReference, this.syntheticTypeReference = syntheticTypeReference);
  }
  
  /**
   * Returns the syntheticType property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.TypeDTO getSyntheticType() {
    checkDisposed();
    return this.syntheticType;
  }
  
  /**
   * Sets the <code>syntheticType</code> property to this instance.
   * 
   * @param syntheticType - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSyntheticType(final org.lunifera.dsl.metadata.api.types.TypeDTO syntheticType) {
    checkDisposed();
    firePropertyChange("syntheticType", this.syntheticType, this.syntheticType = syntheticType);
  }
}

package org.lunifera.dsl.metadata.api.dto;

import java.io.Serializable;

@SuppressWarnings("all")
public class DtoInheritedAttributeDTO implements org.lunifera.dsl.metadata.api.dto.DtoAbstractAttributeDTO, Serializable {
  private org.lunifera.dsl.metadata.api.types.AttributeDTO inheritedFeature;
  
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
   * Returns the inheritedFeature property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.AttributeDTO getInheritedFeature() {
    checkDisposed();
    return this.inheritedFeature;
  }
  
  /**
   * Sets the <code>inheritedFeature</code> property to this instance.
   * 
   * @param inheritedFeature - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setInheritedFeature(final org.lunifera.dsl.metadata.api.types.AttributeDTO inheritedFeature) {
    checkDisposed();
    firePropertyChange("inheritedFeature", this.inheritedFeature, this.inheritedFeature = inheritedFeature);
  }
}

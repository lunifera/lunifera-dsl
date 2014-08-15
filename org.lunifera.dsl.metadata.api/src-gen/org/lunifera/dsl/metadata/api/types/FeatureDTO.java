package org.lunifera.dsl.metadata.api.types;

import java.io.Serializable;

@SuppressWarnings("all")
public class FeatureDTO implements org.lunifera.dsl.metadata.api.types.AnnotationTargetDTO, Serializable {
  private String name;
  
  private org.lunifera.dsl.metadata.api.types.MultiplicityDTO multiplicity;
  
  private org.lunifera.dsl.metadata.api.types.AnnotationTargetDTO annotationInfo;
  
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
      if (this.multiplicity != null) {
        this.multiplicity.dispose();
        this.multiplicity = null;
      }
      if (this.annotationInfo != null) {
        this.annotationInfo.dispose();
        this.annotationInfo = null;
      }
      
    }
    finally {
      super.dispose();
    }
    
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
   * Returns the multiplicity property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.MultiplicityDTO getMultiplicity() {
    checkDisposed();
    return this.multiplicity;
  }
  
  /**
   * Sets the <code>multiplicity</code> property to this instance.
   * 
   * @param multiplicity - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setMultiplicity(final org.lunifera.dsl.metadata.api.types.MultiplicityDTO multiplicity) {
    checkDisposed();
    firePropertyChange("multiplicity", this.multiplicity, this.multiplicity = multiplicity);
  }
  
  /**
   * For internal use only!
   */
  void internalSetMultiplicity(final org.lunifera.dsl.metadata.api.types.MultiplicityDTO multiplicity) {
    firePropertyChange("multiplicity", this.multiplicity, this.multiplicity = multiplicity);
  }
  
  /**
   * Returns the annotationInfo property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.AnnotationTargetDTO getAnnotationInfo() {
    checkDisposed();
    return this.annotationInfo;
  }
  
  /**
   * Sets the <code>annotationInfo</code> property to this instance.
   * 
   * @param annotationInfo - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setAnnotationInfo(final org.lunifera.dsl.metadata.api.types.AnnotationTargetDTO annotationInfo) {
    checkDisposed();
    firePropertyChange("annotationInfo", this.annotationInfo, this.annotationInfo = annotationInfo);
  }
  
  /**
   * For internal use only!
   */
  void internalSetAnnotationInfo(final org.lunifera.dsl.metadata.api.types.AnnotationTargetDTO annotationInfo) {
    firePropertyChange("annotationInfo", this.annotationInfo, this.annotationInfo = annotationInfo);
  }
}

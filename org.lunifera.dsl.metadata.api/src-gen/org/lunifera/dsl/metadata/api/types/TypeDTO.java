package org.lunifera.dsl.metadata.api.types;

import java.io.Serializable;

@SuppressWarnings("all")
public class TypeDTO implements org.lunifera.dsl.metadata.api.types.AnnotationTargetDTO, Serializable {
  private org.lunifera.dsl.metadata.api.types.TypedPackageDTO parentPackage;
  
  private String name;
  
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
   * Returns the parentPackage property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.TypedPackageDTO getParentPackage() {
    checkDisposed();
    return this.parentPackage;
  }
  
  /**
   * Sets the <code>parentPackage</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>TypedPackageDTO#
   * types</code> of the <code>parentPackage</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link TypedPackageDTO#setTypes(TypedPackageDTO)
   * 
   * @param parentPackage - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setParentPackage(final org.lunifera.dsl.metadata.api.types.TypedPackageDTO parentPackage) {
    checkDisposed();
    if (this.parentPackage != null) {
      this.parentPackage.internalRemoveFromTypes(this);
    }
    internalSetParentPackage(parentPackage);
    if (this.parentPackage != null) {
      this.parentPackage.internalAddToTypes(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetParentPackage(final org.lunifera.dsl.metadata.api.types.TypedPackageDTO parentPackage) {
    firePropertyChange("parentPackage", this.parentPackage, this.parentPackage = parentPackage);
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

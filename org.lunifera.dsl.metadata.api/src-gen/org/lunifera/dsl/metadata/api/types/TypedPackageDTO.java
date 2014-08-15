package org.lunifera.dsl.metadata.api.types;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class TypedPackageDTO implements org.lunifera.dsl.metadata.api.types.PackageDTO, Serializable {
  private org.lunifera.dsl.metadata.api.types.CommonModelDTO commonmodel;
  
  private /* List<org.lunifera.dsl.metadata.api.types.TypeDTO> */Object types;
  
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
      if (this.types != null) {
        for (TypeDTO typeDTO : this.types) {
          typeDTO.dispose();
        }
        this.types = null;
      }
      
    }
    finally {
      super.dispose();
    }
    
  }
  
  /**
   * Returns the commonmodel property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.CommonModelDTO getCommonmodel() {
    checkDisposed();
    return this.commonmodel;
  }
  
  /**
   * Sets the <code>commonmodel</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>CommonModelDTO#
   * packages</code> of the <code>commonmodel</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link CommonModelDTO#setPackages(CommonModelDTO)
   * 
   * @param commonmodel - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setCommonmodel(final org.lunifera.dsl.metadata.api.types.CommonModelDTO commonmodel) {
    checkDisposed();
    if (this.commonmodel != null) {
      this.commonmodel.internalRemoveFromPackages(this);
    }
    internalSetCommonmodel(commonmodel);
    if (this.commonmodel != null) {
      this.commonmodel.internalAddToPackages(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetCommonmodel(final org.lunifera.dsl.metadata.api.types.CommonModelDTO commonmodel) {
    firePropertyChange("commonmodel", this.commonmodel, this.commonmodel = commonmodel);
  }
  
  /**
   * Returns an unmodifiable list of types.
   */
  public /* List<org.lunifera.dsl.metadata.api.types.TypeDTO> */Object getTypes() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetTypes());
  }
  
  /**
   * Returns the list of <code>TypeDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private /* List<org.lunifera.dsl.metadata.api.types.TypeDTO> */Object internalGetTypes() {
    if (this.types == null) {
      this.types = new java.util.ArrayList<TypeDTO>();
    }
    return this.types;
  }
  
  /**
   * Adds the given typeDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>TypeDTO#parentPackage</code> of the <code>typeDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link TypeDTO#setParentPackage(TypeDTO)}.
   * 
   * @param typeDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToTypes(final org.lunifera.dsl.metadata.api.types.TypeDTO typeDTO) {
    checkDisposed();
    typeDTO.setParentPackage(this);
  }
  
  /**
   * Removes the given typeDTO from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (TypeDTO.parentPackage)
   * of the typeDTO will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link TypeDTO#setParentPackage(TypeDTO)}.
   * 
   * @param typeDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromTypes(final org.lunifera.dsl.metadata.api.types.TypeDTO typeDTO) {
    checkDisposed();
    typeDTO.setParentPackage(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToTypes(final org.lunifera.dsl.metadata.api.types.TypeDTO typeDTO) {
    internalGetTypes().add(typeDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromTypes(final org.lunifera.dsl.metadata.api.types.TypeDTO typeDTO) {
    internalGetTypes().remove(typeDTO);
  }
}

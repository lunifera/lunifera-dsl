package org.lunifera.dsl.metadata.api.types;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class CommonModelDTO implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private /* List<org.lunifera.dsl.metadata.api.types.TypedPackageDTO> */Object packages;
  
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
      if (this.packages != null) {
        for (TypedPackageDTO typedPackageDTO : this.packages) {
          typedPackageDTO.dispose();
        }
        this.packages = null;
      }
      
    }
    finally {
      disposed = true;
    }
    
  }
  
  /**
   * Returns an unmodifiable list of packages.
   */
  public /* List<org.lunifera.dsl.metadata.api.types.TypedPackageDTO> */Object getPackages() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetPackages());
  }
  
  /**
   * Returns the list of <code>TypedPackageDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private /* List<org.lunifera.dsl.metadata.api.types.TypedPackageDTO> */Object internalGetPackages() {
    if (this.packages == null) {
      this.packages = new java.util.ArrayList<TypedPackageDTO>();
    }
    return this.packages;
  }
  
  /**
   * Adds the given typedPackageDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>TypedPackageDTO#commonmodel</code> of the <code>typedPackageDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link TypedPackageDTO#setCommonmodel(TypedPackageDTO)}.
   * 
   * @param typedPackageDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToPackages(final org.lunifera.dsl.metadata.api.types.TypedPackageDTO typedPackageDTO) {
    checkDisposed();
    typedPackageDTO.setCommonmodel(this);
  }
  
  /**
   * Removes the given typedPackageDTO from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (TypedPackageDTO.commonmodel)
   * of the typedPackageDTO will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link TypedPackageDTO#setCommonmodel(TypedPackageDTO)}.
   * 
   * @param typedPackageDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromPackages(final org.lunifera.dsl.metadata.api.types.TypedPackageDTO typedPackageDTO) {
    checkDisposed();
    typedPackageDTO.setCommonmodel(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToPackages(final org.lunifera.dsl.metadata.api.types.TypedPackageDTO typedPackageDTO) {
    internalGetPackages().add(typedPackageDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromPackages(final org.lunifera.dsl.metadata.api.types.TypedPackageDTO typedPackageDTO) {
    internalGetPackages().remove(typedPackageDTO);
  }
}

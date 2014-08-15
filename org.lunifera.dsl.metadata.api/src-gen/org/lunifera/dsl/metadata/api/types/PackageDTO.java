package org.lunifera.dsl.metadata.api.types;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class PackageDTO implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private String name;
  
  private /* List<org.lunifera.dsl.metadata.api.types.ImportDTO> */Object imports;
  
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
      if (this.imports != null) {
        for (ImportDTO importDTO : this.imports) {
          importDTO.dispose();
        }
        this.imports = null;
      }
      
    }
    finally {
      disposed = true;
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
   * Returns an unmodifiable list of imports.
   */
  public /* List<org.lunifera.dsl.metadata.api.types.ImportDTO> */Object getImports() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetImports());
  }
  
  /**
   * Returns the list of <code>ImportDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private /* List<org.lunifera.dsl.metadata.api.types.ImportDTO> */Object internalGetImports() {
    if (this.imports == null) {
      this.imports = new java.util.ArrayList<ImportDTO>();
    }
    return this.imports;
  }
  
  /**
   * Adds the given importDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>ImportDTO#parentPackage</code> of the <code>importDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link ImportDTO#setParentPackage(ImportDTO)}.
   * 
   * @param importDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToImports(final org.lunifera.dsl.metadata.api.types.ImportDTO importDTO) {
    checkDisposed();
    importDTO.setParentPackage(this);
  }
  
  /**
   * Removes the given importDTO from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (ImportDTO.parentPackage)
   * of the importDTO will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link ImportDTO#setParentPackage(ImportDTO)}.
   * 
   * @param importDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromImports(final org.lunifera.dsl.metadata.api.types.ImportDTO importDTO) {
    checkDisposed();
    importDTO.setParentPackage(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToImports(final org.lunifera.dsl.metadata.api.types.ImportDTO importDTO) {
    internalGetImports().add(importDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromImports(final org.lunifera.dsl.metadata.api.types.ImportDTO importDTO) {
    internalGetImports().remove(importDTO);
  }
}

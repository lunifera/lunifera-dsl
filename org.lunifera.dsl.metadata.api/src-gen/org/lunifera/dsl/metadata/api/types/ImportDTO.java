package org.lunifera.dsl.metadata.api.types;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

@SuppressWarnings("all")
public class ImportDTO implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private org.lunifera.dsl.metadata.api.types.PackageDTO parentPackage;
  
  private String importedNamespace;
  
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
    disposed = true;
  }
  
  /**
   * Returns the parentPackage property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.PackageDTO getParentPackage() {
    checkDisposed();
    return this.parentPackage;
  }
  
  /**
   * Sets the <code>parentPackage</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>PackageDTO#
   * imports</code> of the <code>parentPackage</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link PackageDTO#setImports(PackageDTO)
   * 
   * @param parentPackage - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setParentPackage(final org.lunifera.dsl.metadata.api.types.PackageDTO parentPackage) {
    checkDisposed();
    if (this.parentPackage != null) {
      this.parentPackage.internalRemoveFromImports(this);
    }
    internalSetParentPackage(parentPackage);
    if (this.parentPackage != null) {
      this.parentPackage.internalAddToImports(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetParentPackage(final org.lunifera.dsl.metadata.api.types.PackageDTO parentPackage) {
    firePropertyChange("parentPackage", this.parentPackage, this.parentPackage = parentPackage);
  }
  
  /**
   * Returns the importedNamespace property or <code>null</code> if not present.
   */
  public String getImportedNamespace() {
    checkDisposed();
    return this.importedNamespace;
  }
  
  /**
   * Sets the <code>importedNamespace</code> property to this instance.
   * 
   * @param importedNamespace - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setImportedNamespace(final String importedNamespace) {
    firePropertyChange("importedNamespace", this.importedNamespace, this.importedNamespace = importedNamespace );
  }
}

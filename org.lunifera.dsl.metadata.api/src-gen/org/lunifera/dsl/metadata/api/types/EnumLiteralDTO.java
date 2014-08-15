package org.lunifera.dsl.metadata.api.types;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

@SuppressWarnings("all")
public class EnumLiteralDTO implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private org.lunifera.dsl.metadata.api.types.EnumDTO parentEnum;
  
  private String name;
  
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
   * Returns the parentEnum property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.EnumDTO getParentEnum() {
    checkDisposed();
    return this.parentEnum;
  }
  
  /**
   * Sets the <code>parentEnum</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>EnumDTO#
   * literals</code> of the <code>parentEnum</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link EnumDTO#setLiterals(EnumDTO)
   * 
   * @param parentEnum - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setParentEnum(final org.lunifera.dsl.metadata.api.types.EnumDTO parentEnum) {
    checkDisposed();
    if (this.parentEnum != null) {
      this.parentEnum.internalRemoveFromLiterals(this);
    }
    internalSetParentEnum(parentEnum);
    if (this.parentEnum != null) {
      this.parentEnum.internalAddToLiterals(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetParentEnum(final org.lunifera.dsl.metadata.api.types.EnumDTO parentEnum) {
    firePropertyChange("parentEnum", this.parentEnum, this.parentEnum = parentEnum);
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
}

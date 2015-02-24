package org.lunifera.dsl.tests.carstore.entities.dtos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

@SuppressWarnings("all")
public class AddressDto implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private Object streetname;
  
  private Object postalcode;
  
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
   * Returns the streetname property or <code>null</code> if not present.
   */
  public Object getStreetname() {
    checkDisposed();
    return this.streetname;
  }
  
  /**
   * Sets the <code>streetname</code> property to this instance.
   * 
   * @param streetname - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setStreetname(final  streetname) {
    firePropertyChange("streetname", this.streetname, this.streetname = streetname );
  }
  
  /**
   * Returns the postalcode property or <code>null</code> if not present.
   */
  public Object getPostalcode() {
    checkDisposed();
    return this.postalcode;
  }
  
  /**
   * Sets the <code>postalcode</code> property to this instance.
   * 
   * @param postalcode - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setPostalcode(final  postalcode) {
    firePropertyChange("postalcode", this.postalcode, this.postalcode = postalcode );
  }
  
  public AddressDto createDto() {
    return new AddressDto();
  }
  
  public AddressDto copy(final org.lunifera.dsl.dto.lib.Context context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    if(context.isMaxLevel()){
    	return null;
    }
    
    // if context contains a copied instance of this object
    // then return it
    AddressDto newDto = context.getTarget(this);
    if(newDto != null){
    	return newDto;
    }
    
    try{
    	context.increaseLevel();
    	
    	newDto = createDto();
    	context.register(this, newDto);
    	
    	// first copy the containments and attributes
    	copyContainments(this, newDto, context);
    	
    	// then copy cross references to ensure proper
    	// opposite references are copied too.
    	copyCrossReferences(this, newDto, context);
    } finally {
    	context.decreaseLevel();
    }
    
    return newDto;
  }
  
  public void copyContainments(final AddressDto dto, final AddressDto newDto, final org.lunifera.dsl.dto.lib.Context context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    
    // copy attributes and beans (beans if derived from entity model)
    // copy streetname
    newDto.setStreetname(getStreetname());
    // copy postalcode
    newDto.setPostalcode(getPostalcode());
    
    // copy containment references (cascading is true)
  }
  
  public void copyCrossReferences(final AddressDto dto, final AddressDto newDto, final org.lunifera.dsl.dto.lib.Context context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    
    // copy cross references (cascading is false)
  }
}

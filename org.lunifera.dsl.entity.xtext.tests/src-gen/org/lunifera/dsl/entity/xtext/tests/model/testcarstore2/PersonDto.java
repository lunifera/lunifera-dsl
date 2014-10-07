/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class PersonDto implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private long id;
  
  private String firstname;
  
  private String lastname;
  
  private Date birthdate;
  
  private /* List<org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto> */Object address;
  
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
   * Returns the id property or <code>null</code> if not present.
   */
  public long getId() {
    checkDisposed();
    return this.id;
  }
  
  /**
   * Sets the <code>id</code> property to this instance.
   * 
   * @param id - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setId(final long id) {
    firePropertyChange("id", this.id, this.id = id );
  }
  
  /**
   * Returns the firstname property or <code>null</code> if not present.
   */
  public String getFirstname() {
    checkDisposed();
    return this.firstname;
  }
  
  /**
   * Sets the <code>firstname</code> property to this instance.
   * 
   * @param firstname - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setFirstname(final String firstname) {
    firePropertyChange("firstname", this.firstname, this.firstname = firstname );
  }
  
  /**
   * Returns the lastname property or <code>null</code> if not present.
   */
  public String getLastname() {
    checkDisposed();
    return this.lastname;
  }
  
  /**
   * Sets the <code>lastname</code> property to this instance.
   * 
   * @param lastname - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setLastname(final String lastname) {
    firePropertyChange("lastname", this.lastname, this.lastname = lastname );
  }
  
  /**
   * Returns the birthdate property or <code>null</code> if not present.
   */
  public Date getBirthdate() {
    checkDisposed();
    return this.birthdate;
  }
  
  /**
   * Sets the <code>birthdate</code> property to this instance.
   * 
   * @param birthdate - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setBirthdate(final Date birthdate) {
    firePropertyChange("birthdate", this.birthdate, this.birthdate = birthdate );
  }
  
  /**
   * Returns an unmodifiable list of address.
   */
  public /* List<org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto> */Object getAddress() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetAddress());
  }
  
  /**
   * Returns the list of <code>Address</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private /* List<org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto> */Object internalGetAddress() {
    if (this.address == null) {
      this.address = new java.util.ArrayList<Address>();
    }
    return this.address;
  }
  
  /**
   * Adds the given address to this object. <p>
   * 
   * @param address - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToAddress(final org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto address) {
    checkDisposed();
    if (!getAddress().contains(address)){
      getAddress().add(address);
    }
    
  }
  
  public void removeFromAddress(final org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto address) {
    checkDisposed();
    getAddress().remove(address);
  }
}

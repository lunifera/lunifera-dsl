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

@SuppressWarnings("all")
public class AddressDto implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private String streetname;
  
  private int housenumber;
  
  private String city;
  
  private int zipcode;
  
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
  public String getStreetname() {
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
  public void setStreetname(final String streetname) {
    firePropertyChange("streetname", this.streetname, this.streetname = streetname );
  }
  
  /**
   * Returns the housenumber property or <code>null</code> if not present.
   */
  public int getHousenumber() {
    checkDisposed();
    return this.housenumber;
  }
  
  /**
   * Sets the <code>housenumber</code> property to this instance.
   * 
   * @param housenumber - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setHousenumber(final int housenumber) {
    firePropertyChange("housenumber", this.housenumber, this.housenumber = housenumber );
  }
  
  /**
   * Returns the city property or <code>null</code> if not present.
   */
  public String getCity() {
    checkDisposed();
    return this.city;
  }
  
  /**
   * Sets the <code>city</code> property to this instance.
   * 
   * @param city - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setCity(final String city) {
    firePropertyChange("city", this.city, this.city = city );
  }
  
  /**
   * Returns the zipcode property or <code>null</code> if not present.
   */
  public int getZipcode() {
    checkDisposed();
    return this.zipcode;
  }
  
  /**
   * Sets the <code>zipcode</code> property to this instance.
   * 
   * @param zipcode - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setZipcode(final int zipcode) {
    firePropertyChange("zipcode", this.zipcode, this.zipcode = zipcode );
  }
}

/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
@SuppressWarnings("all")
public class Address implements Serializable {
  private boolean disposed;
  
  @Basic
  private String streetname;
  
  @Basic
  private int housenumber;
  
  @Basic
  private String city;
  
  @Basic
  private int zipcode;
  
  /**
   * Returns true, if the object is disposed. 
   * Disposed means, that it is prepared for garbage collection and may not be used anymore. 
   * Accessing objects that are already disposed will cause runtime exceptions.
   */
  @Transient
  public boolean isDisposed() {
    return this.disposed;
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
   * Sets the streetname property to this instance.
   */
  public void setStreetname(final String streetname) {
    checkDisposed();
    this.streetname = streetname;
  }
  
  /**
   * Returns the housenumber property or <code>null</code> if not present.
   */
  public int getHousenumber() {
    checkDisposed();
    return this.housenumber;
  }
  
  /**
   * Sets the housenumber property to this instance.
   */
  public void setHousenumber(final int housenumber) {
    checkDisposed();
    this.housenumber = housenumber;
  }
  
  /**
   * Returns the city property or <code>null</code> if not present.
   */
  public String getCity() {
    checkDisposed();
    return this.city;
  }
  
  /**
   * Sets the city property to this instance.
   */
  public void setCity(final String city) {
    checkDisposed();
    this.city = city;
  }
  
  /**
   * Returns the zipcode property or <code>null</code> if not present.
   */
  public int getZipcode() {
    checkDisposed();
    return this.zipcode;
  }
  
  /**
   * Sets the zipcode property to this instance.
   */
  public void setZipcode(final int zipcode) {
    checkDisposed();
    this.zipcode = zipcode;
  }
}

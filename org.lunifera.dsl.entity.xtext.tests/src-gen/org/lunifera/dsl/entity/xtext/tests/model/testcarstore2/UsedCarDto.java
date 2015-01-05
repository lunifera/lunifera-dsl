/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2;

import java.io.Serializable;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.CarDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.CustomerDto;

@SuppressWarnings("all")
public class UsedCarDto extends CarDto implements Serializable {
  private String state;
  
  private int mileage;
  
  private CustomerDto seller;
  
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
    super.dispose();
  }
  
  /**
   * Returns the state property or <code>null</code> if not present.
   */
  public String getState() {
    checkDisposed();
    return this.state;
  }
  
  /**
   * Sets the <code>state</code> property to this instance.
   * 
   * @param state - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setState(final String state) {
    firePropertyChange("state", this.state, this.state = state );
  }
  
  /**
   * Returns the mileage property or <code>null</code> if not present.
   */
  public int getMileage() {
    checkDisposed();
    return this.mileage;
  }
  
  /**
   * Sets the <code>mileage</code> property to this instance.
   * 
   * @param mileage - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setMileage(final int mileage) {
    firePropertyChange("mileage", this.mileage, this.mileage = mileage );
  }
  
  /**
   * Returns the <em>required</em> seller property.
   */
  public CustomerDto getSeller() {
    checkDisposed();
    return this.seller;
  }
  
  /**
   * Sets the <code>seller</code> property to this instance.
   * 
   * @param seller - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSeller(final CustomerDto seller) {
    checkDisposed();
    firePropertyChange("seller", this.seller, this.seller = seller);
  }
}

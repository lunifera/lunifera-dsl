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
import java.util.List;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.CarDto;

@SuppressWarnings("all")
public class ManufacturerDto implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private long id;
  
  private String name;
  
  private org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto address;
  
  private List<CarDto> cars;
  
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
      if (this.cars != null) {
        for (CarDto carDto : this.cars) {
          carDto.dispose();
        }
        this.cars = null;
      }
      
    }
    finally {
      disposed = true;
    }
    
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
   * Returns the address property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto getAddress() {
    checkDisposed();
    return this.address;
  }
  
  /**
   * Sets the <code>address</code> property to this instance.
   * 
   * @param address - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setAddress(final org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto address) {
    firePropertyChange("address", this.address, this.address = address );
  }
  
  /**
   * Returns an unmodifiable list of cars.
   */
  public List<CarDto> getCars() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetCars());
  }
  
  /**
   * Returns the list of <code>CarDto</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private List<CarDto> internalGetCars() {
    if (this.cars == null) {
      this.cars = new java.util.ArrayList<CarDto>();
    }
    return this.cars;
  }
  
  /**
   * Adds the given carDto to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>CarDto#manufacturer</code> of the <code>carDto</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link CarDto#setManufacturer(CarDto)}.
   * 
   * @param carDto - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToCars(final CarDto carDto) {
    checkDisposed();
    carDto.setManufacturer(this);
  }
  
  /**
   * Removes the given carDto from this object. <p>
   * 
   * @param carDto - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromCars(final CarDto carDto) {
    checkDisposed();
    carDto.setManufacturer(null);
  }
  
  /**
   * For internal use only!
   */
  public void internalAddToCars(final CarDto carDto) {
    internalGetCars().add(carDto);
  }
  
  /**
   * For internal use only!
   */
  public void internalRemoveFromCars(final CarDto carDto) {
    internalGetCars().remove(carDto);
  }
}

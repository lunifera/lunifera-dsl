/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.lunifera.dsl.common.datatypes.IEntity;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Address;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Car;
import org.lunifera.runtime.common.annotations.Dispose;

@Entity
@Table(name = "MANUFACTURER")
@DiscriminatorValue(value = "MANUFACTURER")
@SuppressWarnings("all")
public class Manufacturer implements IEntity {
  @Transient
  @Dispose
  private boolean disposed;
  
  @Id
  @GeneratedValue
  private long id;
  
  @Column(name = "NAME")
  private String name;
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "streetname", column = @Column(name = "ADDRESS_STREETNAME")), @AttributeOverride(name = "housenumber", column = @Column(name = "ADDRESS_HOUSENUMBER")), @AttributeOverride(name = "city", column = @Column(name = "ADDRESS_CITY")), @AttributeOverride(name = "zipcode", column = @Column(name = "ADDRESS_ZIPCODE")) })
  @Column(name = "ADDRESS")
  private Address address;
  
  @JoinColumn(name = "CARS")
  @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Car> cars;
  
  /**
   * Returns true, if the object is disposed. 
   * Disposed means, that it is prepared for garbage collection and may not be used anymore. 
   * Accessing objects that are already disposed will cause runtime exceptions.
   */
  @Dispose
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
  @Dispose
  public void dispose() {
    if (isDisposed()) {
      return;
    }
    try {
      // Dispose all the composition references.
      if (this.cars != null) {
        for (Car car : this.cars) {
          car.dispose();
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
   * Sets the id property to this instance.
   */
  public void setId(final long id) {
    checkDisposed();
    this.id = id;
  }
  
  /**
   * Returns the name property or <code>null</code> if not present.
   */
  public String getName() {
    checkDisposed();
    return this.name;
  }
  
  /**
   * Sets the name property to this instance.
   */
  public void setName(final String name) {
    checkDisposed();
    this.name = name;
  }
  
  /**
   * Returns the address property or <code>null</code> if not present.
   */
  public Address getAddress() {
    checkDisposed();
    return this.address;
  }
  
  /**
   * Sets the address property to this instance.
   */
  public void setAddress(final Address address) {
    checkDisposed();
    this.address = address;
  }
  
  /**
   * Returns an unmodifiable list of cars.
   */
  public List<Car> getCars() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetCars());
  }
  
  /**
   * Sets the given cars to the object. Currently contained cars instances will be removed.
   * 
   * @param cars the list of new instances
   */
  public void setCars(final List<Car> cars) {
    // remove the old car
    for(Car oldElement : new ArrayList<Car>(this.internalGetCars())){
      removeFromCars(oldElement);
    }
    
    // add the new car
    for(Car newElement : cars){
      addToCars(newElement);
    }
  }
  
  /**
   * Returns the list of <code>Car</code>s thereby lazy initializing it.
   */
  private List<Car> internalGetCars() {
    if (this.cars == null) {
      this.cars = new ArrayList<Car>();
    }
    return this.cars;
  }
  
  /**
   * Adds the given car to this object. <p>
   * Since the reference is a composition reference, the opposite reference (Car.manufacturer)
   * of the car will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Car#setManufacturer(Car)}.
   * 
   */
  public void addToCars(final Car car) {
    checkDisposed();
    car.setManufacturer(this);
  }
  
  /**
   * Removes the given car from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (Car.manufacturer)
   * of the car will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Car#setManufacturer(Car)}.
   * 
   */
  public void removeFromCars(final Car car) {
    checkDisposed();
    car.setManufacturer(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToCars(final Car car) {
    internalGetCars().add(car);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromCars(final Car car) {
    internalGetCars().remove(car);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Manufacturer other = (Manufacturer) obj;
    if (other.id != this.id)
      return false;
    return true;
  }
  
  @Override
  public int hashCode() {
     int prime = 31;
    int result = 1;
    result = prime * result + (int) (this.id ^ (this.id >>> 32));
    return result;
  }
}

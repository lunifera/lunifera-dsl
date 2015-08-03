/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.lunifera.dsl.common.datatypes.IDto;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.AddressDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CarDto;
import org.lunifera.runtime.common.annotations.Dispose;
import org.lunifera.runtime.common.annotations.DomainReference;

@SuppressWarnings("all")
public class ManufacturerDto implements IDto, Serializable, PropertyChangeListener {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  @Dispose
  private boolean disposed;
  
  private long id;
  
  private String name;
  
  private AddressDto address;
  
  @DomainReference
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
  @Dispose
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
      firePropertyChange("disposed", this.disposed, this.disposed = true);
    }
    
  }
  
  /**
   * Returns the id property or <code>null</code> if not present.
   */
  public long getId() {
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
   * Returns the address property.
   */
  public AddressDto getAddress() {
    if(this.address== null){
      this.address = new AddressDto();
    }
    return this.address;
  }
  
  /**
   * Sets the <code>address</code> property to this instance.
   * 
   * @param address - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setAddress(final AddressDto address) {
    // ensure that embedded beans will notify their parent about changes
    // so their dirty state can be handled properly
    if (this.address != null) {
    	this.address.removePropertyChangeListener(this);
    }
    
    firePropertyChange("address", this.address, this.address = address );
    
    if (this.address != null) {
    	this.address.addPropertyChangeListener(this);
    }
  }
  
  /**
   * Returns an unmodifiable list of cars.
   */
  public List<CarDto> getCars() {
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
  
  /**
   * Sets the <code>cars</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>CarDto#
   * manufacturer</code> of the <code>cars</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link CarDto#setManufacturer(CarDto)
   * 
   * @param cars - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setCars(final List<CarDto> cars) {
    checkDisposed();
    for (CarDto dto : internalGetCars().toArray(new CarDto[this.cars.size()])) {
    	removeFromCars(dto);
    }
    
    if(cars == null) {
    	return;
    }
    
    for (CarDto dto : cars) {
    	addToCars(dto);
    }
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ManufacturerDto other = (ManufacturerDto) obj;
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
  
  public ManufacturerDto createDto() {
    return new ManufacturerDto();
  }
  
  public ManufacturerDto copy(final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    if(context.isMaxLevel()){
    	return null;
    }
    
    // if context contains a copied instance of this object
    // then return it
    ManufacturerDto newDto = context.get(this);
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
  
  public void copyContainments(final ManufacturerDto dto, final ManufacturerDto newDto, final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    
    // copy attributes and beans (beans if derived from entity model)
    // copy id
    newDto.setId(getId());
    // copy name
    newDto.setName(getName());
    // copy dto address
    if(getAddress() != null) {
    	newDto.setAddress(getAddress().copy(context));
    }
    
    // copy containment references (cascading is true)
    // copy list of cars dtos
    for(org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CarDto _dto : getCars()) {
    	newDto.addToCars(_dto.copy(context));
    }
  }
  
  public void copyCrossReferences(final ManufacturerDto dto, final ManufacturerDto newDto, final org.lunifera.dsl.dto.lib.MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    
    // copy cross references (cascading is false)
  }
  
  public void propertyChange(final java.beans.PropertyChangeEvent event) {
    Object source = event.getSource();
    
    // forward the event from embeddable beans to all listeners. So the parent of the embeddable
    // bean will become notified and its dirty state can be handled properly
    if(source == address){
    	firePropertyChange("address" + "_" + event.getPropertyName(), event.getOldValue(), event.getNewValue());
    } else 
    { 
    	// no super class available to forward event
    }
  }
}

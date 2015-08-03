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
import java.util.Date;
import org.lunifera.dsl.common.datatypes.IDto;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.ManufacturerDto;
import org.lunifera.runtime.common.annotations.Dispose;
import org.lunifera.runtime.common.annotations.DomainReference;

@SuppressWarnings("all")
public class CarDto implements IDto, Serializable, PropertyChangeListener {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  @Dispose
  private boolean disposed;
  
  private long id;
  
  private String modelname;
  
  private Date constructiondate;
  
  private int price;
  
  @DomainReference
  private ManufacturerDto manufacturer;
  
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
    firePropertyChange("disposed", this.disposed, this.disposed = true);
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
   * Returns the modelname property or <code>null</code> if not present.
   */
  public String getModelname() {
    return this.modelname;
  }
  
  /**
   * Sets the <code>modelname</code> property to this instance.
   * 
   * @param modelname - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setModelname(final String modelname) {
    firePropertyChange("modelname", this.modelname, this.modelname = modelname );
  }
  
  /**
   * Returns the constructiondate property or <code>null</code> if not present.
   */
  public Date getConstructiondate() {
    return this.constructiondate;
  }
  
  /**
   * Sets the <code>constructiondate</code> property to this instance.
   * 
   * @param constructiondate - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setConstructiondate(final Date constructiondate) {
    firePropertyChange("constructiondate", this.constructiondate, this.constructiondate = constructiondate );
  }
  
  /**
   * Returns the price property or <code>null</code> if not present.
   */
  public int getPrice() {
    return this.price;
  }
  
  /**
   * Sets the <code>price</code> property to this instance.
   * 
   * @param price - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setPrice(final int price) {
    firePropertyChange("price", this.price, this.price = price );
  }
  
  /**
   * Returns the <em>required</em> manufacturer property.
   */
  public ManufacturerDto getManufacturer() {
    return this.manufacturer;
  }
  
  /**
   * Sets the <code>manufacturer</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>ManufacturerDto#
   * cars</code> of the <code>manufacturer</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link ManufacturerDto#setCars(ManufacturerDto)
   * 
   * @param manufacturer - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setManufacturer(final ManufacturerDto manufacturer) {
    checkDisposed();
    if (this.manufacturer != null) {
    	this.manufacturer.internalRemoveFromCars(this);
    }
    
    internalSetManufacturer(manufacturer);
    
    if (this.manufacturer != null) {
    	this.manufacturer.internalAddToCars(this);
    }
  }
  
  /**
   * For internal use only!
   */
  public void internalSetManufacturer(final ManufacturerDto manufacturer) {
    firePropertyChange("manufacturer", this.manufacturer, this.manufacturer = manufacturer);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CarDto other = (CarDto) obj;
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
  
  public CarDto createDto() {
    return new CarDto();
  }
  
  public CarDto copy(final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    if(context.isMaxLevel()){
    	return null;
    }
    
    // if context contains a copied instance of this object
    // then return it
    CarDto newDto = context.get(this);
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
  
  public void copyContainments(final CarDto dto, final CarDto newDto, final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    
    // copy attributes and beans (beans if derived from entity model)
    // copy id
    newDto.setId(getId());
    // copy modelname
    newDto.setModelname(getModelname());
    // copy constructiondate
    newDto.setConstructiondate(getConstructiondate());
    // copy price
    newDto.setPrice(getPrice());
    
    // copy containment references (cascading is true)
  }
  
  public void copyCrossReferences(final CarDto dto, final CarDto newDto, final org.lunifera.dsl.dto.lib.MappingContext context) {
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
    { 
    	// no super class available to forward event
    }
  }
}

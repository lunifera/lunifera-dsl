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
import org.lunifera.dsl.common.datatypes.IDto;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.runtime.common.annotations.Dispose;

@SuppressWarnings("all")
public class AddressDto implements IDto, Serializable, PropertyChangeListener {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  @Dispose
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
  @Dispose
  public void dispose() {
    if (isDisposed()) {
      return;
    }
    firePropertyChange("disposed", this.disposed, this.disposed = true);
  }
  
  /**
   * Returns the streetname property or <code>null</code> if not present.
   */
  public String getStreetname() {
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
  
  public AddressDto createDto() {
    return new AddressDto();
  }
  
  public AddressDto copy(final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    if(context.isMaxLevel()){
    	return null;
    }
    
    // if context contains a copied instance of this object
    // then return it
    AddressDto newDto = context.get(this);
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
  
  public void copyContainments(final AddressDto dto, final AddressDto newDto, final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    
    // copy attributes and beans (beans if derived from entity model)
    // copy streetname
    newDto.setStreetname(getStreetname());
    // copy housenumber
    newDto.setHousenumber(getHousenumber());
    // copy city
    newDto.setCity(getCity());
    // copy zipcode
    newDto.setZipcode(getZipcode());
    
    // copy containment references (cascading is true)
  }
  
  public void copyCrossReferences(final AddressDto dto, final AddressDto newDto, final org.lunifera.dsl.dto.lib.MappingContext context) {
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

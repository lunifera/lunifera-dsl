/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import org.lunifera.dsl.common.datatypes.IDto;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CarDto;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CustomerDto;
import org.lunifera.runtime.common.annotations.Dispose;
import org.lunifera.runtime.common.annotations.DomainReference;

@SuppressWarnings("all")
public class UsedCarDto extends CarDto implements IDto, Serializable, PropertyChangeListener {
  private String state;
  
  private int mileage;
  
  @DomainReference
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
  @Dispose
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
  
  public UsedCarDto createDto() {
    return new UsedCarDto();
  }
  
  public UsedCarDto copy(final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    if(context.isMaxLevel()){
    	return null;
    }
    
    // if context contains a copied instance of this object
    // then return it
    UsedCarDto newDto = context.get(this);
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
  
  public void copyContainments(final UsedCarDto dto, final UsedCarDto newDto, final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyContainments(dto, newDto, context);
    
    // copy attributes and beans (beans if derived from entity model)
    // copy state
    newDto.setState(getState());
    // copy mileage
    newDto.setMileage(getMileage());
    
    // copy containment references (cascading is true)
  }
  
  public void copyCrossReferences(final UsedCarDto dto, final UsedCarDto newDto, final org.lunifera.dsl.dto.lib.MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyCrossReferences(dto, newDto, context);
    
    // copy cross references (cascading is false)
    // copy dto seller
    if(getSeller() != null) {
    	newDto.setSeller(getSeller().copy(context));
    }
  }
  
  public void propertyChange(final java.beans.PropertyChangeEvent event) {
    Object source = event.getSource();
    
    // forward the event from embeddable beans to all listeners. So the parent of the embeddable
    // bean will become notified and its dirty state can be handled properly
    { 
    	super.propertyChange(event);
    }
  }
}

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
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.PersonDto;
import org.lunifera.runtime.common.annotations.Dispose;

@SuppressWarnings("all")
public class CustomerDto extends PersonDto implements IDto, Serializable, PropertyChangeListener {
  private boolean isseller;
  
  private boolean isbuyer;
  
  private String phonenumber;
  
  private String iban;
  
  private int discount;
  
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
   * Returns the isseller property or <code>null</code> if not present.
   */
  public boolean getIsseller() {
    return this.isseller;
  }
  
  /**
   * Sets the <code>isseller</code> property to this instance.
   * 
   * @param isseller - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setIsseller(final boolean isseller) {
    firePropertyChange("isseller", this.isseller, this.isseller = isseller );
  }
  
  /**
   * Returns the isbuyer property or <code>null</code> if not present.
   */
  public boolean getIsbuyer() {
    return this.isbuyer;
  }
  
  /**
   * Sets the <code>isbuyer</code> property to this instance.
   * 
   * @param isbuyer - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setIsbuyer(final boolean isbuyer) {
    firePropertyChange("isbuyer", this.isbuyer, this.isbuyer = isbuyer );
  }
  
  /**
   * Returns the phonenumber property or <code>null</code> if not present.
   */
  public String getPhonenumber() {
    return this.phonenumber;
  }
  
  /**
   * Sets the <code>phonenumber</code> property to this instance.
   * 
   * @param phonenumber - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setPhonenumber(final String phonenumber) {
    firePropertyChange("phonenumber", this.phonenumber, this.phonenumber = phonenumber );
  }
  
  /**
   * Returns the iban property or <code>null</code> if not present.
   */
  public String getIban() {
    return this.iban;
  }
  
  /**
   * Sets the <code>iban</code> property to this instance.
   * 
   * @param iban - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setIban(final String iban) {
    firePropertyChange("iban", this.iban, this.iban = iban );
  }
  
  /**
   * Returns the discount property or <code>null</code> if not present.
   */
  public int getDiscount() {
    return this.discount;
  }
  
  /**
   * Sets the <code>discount</code> property to this instance.
   * 
   * @param discount - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setDiscount(final int discount) {
    firePropertyChange("discount", this.discount, this.discount = discount );
  }
  
  public CustomerDto createDto() {
    return new CustomerDto();
  }
  
  public CustomerDto copy(final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    if(context.isMaxLevel()){
    	return null;
    }
    
    // if context contains a copied instance of this object
    // then return it
    CustomerDto newDto = context.get(this);
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
  
  public void copyContainments(final CustomerDto dto, final CustomerDto newDto, final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyContainments(dto, newDto, context);
    
    // copy attributes and beans (beans if derived from entity model)
    // copy isseller
    newDto.setIsseller(getIsseller());
    // copy isbuyer
    newDto.setIsbuyer(getIsbuyer());
    // copy phonenumber
    newDto.setPhonenumber(getPhonenumber());
    // copy iban
    newDto.setIban(getIban());
    // copy discount
    newDto.setDiscount(getDiscount());
    
    // copy containment references (cascading is true)
  }
  
  public void copyCrossReferences(final CustomerDto dto, final CustomerDto newDto, final org.lunifera.dsl.dto.lib.MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    super.copyCrossReferences(dto, newDto, context);
    
    // copy cross references (cascading is false)
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

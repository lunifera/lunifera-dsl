/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.lunifera.dsl.common.datatypes.IEntity;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Person;
import org.lunifera.runtime.common.annotations.Dispose;

@Entity
@Table(name = "CUSTOMER")
@DiscriminatorValue(value = "CUSTOMER")
@SuppressWarnings("all")
public class Customer extends Person implements IEntity {
  @Column(name = "ISSELLER")
  private boolean isseller;
  
  @Column(name = "ISBUYER")
  private boolean isbuyer;
  
  @Column(name = "PHONENUMBER")
  private String phonenumber;
  
  @Column(name = "IBAN")
  private String iban;
  
  @Column(name = "DISCOUNT")
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
    checkDisposed();
    return this.isseller;
  }
  
  /**
   * Sets the isseller property to this instance.
   */
  public void setIsseller(final boolean isseller) {
    checkDisposed();
    this.isseller = isseller;
  }
  
  /**
   * Returns the isbuyer property or <code>null</code> if not present.
   */
  public boolean getIsbuyer() {
    checkDisposed();
    return this.isbuyer;
  }
  
  /**
   * Sets the isbuyer property to this instance.
   */
  public void setIsbuyer(final boolean isbuyer) {
    checkDisposed();
    this.isbuyer = isbuyer;
  }
  
  /**
   * Returns the phonenumber property or <code>null</code> if not present.
   */
  public String getPhonenumber() {
    checkDisposed();
    return this.phonenumber;
  }
  
  /**
   * Sets the phonenumber property to this instance.
   */
  public void setPhonenumber(final String phonenumber) {
    checkDisposed();
    this.phonenumber = phonenumber;
  }
  
  /**
   * Returns the iban property or <code>null</code> if not present.
   */
  public String getIban() {
    checkDisposed();
    return this.iban;
  }
  
  /**
   * Sets the iban property to this instance.
   */
  public void setIban(final String iban) {
    checkDisposed();
    this.iban = iban;
  }
  
  /**
   * Returns the discount property or <code>null</code> if not present.
   */
  public int getDiscount() {
    checkDisposed();
    return this.discount;
  }
  
  /**
   * Sets the discount property to this instance.
   */
  public void setDiscount(final int discount) {
    checkDisposed();
    this.discount = discount;
  }
}

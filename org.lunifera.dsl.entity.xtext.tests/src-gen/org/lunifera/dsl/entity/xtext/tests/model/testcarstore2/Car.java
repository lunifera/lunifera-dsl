/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "CAR")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISC", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "CAR")
@SuppressWarnings("all")
public class Car {
  @Transient
  private boolean disposed;
  
  @Id
  @GeneratedValue
  private long id;
  
  @Column(name = "MODELNAME")
  private String modelname;
  
  @Column(name = "CONSTRUCTIONDATE")
  @Temporal(value = TemporalType.TIME)
  private Date constructiondate;
  
  @Column(name = "PRICE")
  private int price;
  
  @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "MANUFACTURER", nullable = false)
  private org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Manufacturer manufacturer;
  
  /**
   * Returns true, if the object is disposed. 
   * Disposed means, that it is prepared for garbage collection and may not be used anymore. 
   * Accessing objects that are already disposed will cause runtime exceptions.
   */
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
    try {
      // Dispose all the composition references.
      if (this.manufacturer != null) {
        this.manufacturer.dispose();
        this.manufacturer = null;
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
   * Returns the modelname property or <code>null</code> if not present.
   */
  public String getModelname() {
    checkDisposed();
    return this.modelname;
  }
  
  /**
   * Sets the modelname property to this instance.
   */
  public void setModelname(final String modelname) {
    checkDisposed();
    this.modelname = modelname;
  }
  
  /**
   * Returns the constructiondate property or <code>null</code> if not present.
   */
  public Date getConstructiondate() {
    checkDisposed();
    return this.constructiondate;
  }
  
  /**
   * Sets the constructiondate property to this instance.
   */
  public void setConstructiondate(final Date constructiondate) {
    checkDisposed();
    this.constructiondate = constructiondate;
  }
  
  /**
   * Returns the price property or <code>null</code> if not present.
   */
  public int getPrice() {
    checkDisposed();
    return this.price;
  }
  
  /**
   * Sets the price property to this instance.
   */
  public void setPrice(final int price) {
    checkDisposed();
    this.price = price;
  }
  
  /**
   * Returns the <em>required</em> manufacturer property.
   */
  public org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Manufacturer getManufacturer() {
    checkDisposed();
    return this.manufacturer;
  }
  
  /**
   * Sets the manufacturer property to this instance.
   * Since the reference is a container reference, the opposite reference (Manufacturer.cars)
   * of the manufacturer will be handled automatically and no further coding is required to keep them in sync.
   * See {@link Manufacturer#setCars(Manufacturer)}.
   */
  public void setManufacturer(final org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Manufacturer manufacturer) {
    checkDisposed();
    if (this.manufacturer != null) {
      this.manufacturer.internalRemoveFromCars(this);
    }
    this.manufacturer = manufacturer;
    if (this.manufacturer != null) {
      this.manufacturer.internalAddToCars(this);
    }
    
  }
  
  void internalSetManufacturer(final org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }
}

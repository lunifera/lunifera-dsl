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
import java.util.Date;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.ManufacturerDto;

@SuppressWarnings("all")
public class CarDto implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private long id;
  
  private String modelname;
  
  private Date constructiondate;
  
  private int price;
  
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
  public void dispose() {
    if (isDisposed()) {
      return;
    }
    disposed = true;
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
   * Returns the modelname property or <code>null</code> if not present.
   */
  public String getModelname() {
    checkDisposed();
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
    checkDisposed();
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
    checkDisposed();
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
    checkDisposed();
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
}

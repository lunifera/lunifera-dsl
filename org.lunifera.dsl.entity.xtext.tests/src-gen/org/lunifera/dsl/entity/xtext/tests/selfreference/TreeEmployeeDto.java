/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.selfreference;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class TreeEmployeeDto implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private long id;
  
  private String Name;
  
  private /* List<org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto> */Object subordinates;
  
  private org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto boss;
  
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
      if (this.subordinates != null) {
        for (TreeEmployeeDto treeEmployeeDto : this.subordinates) {
          treeEmployeeDto.dispose();
        }
        this.subordinates = null;
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
   * Returns the Name property or <code>null</code> if not present.
   */
  public String getName() {
    checkDisposed();
    return this.Name;
  }
  
  /**
   * Sets the <code>Name</code> property to this instance.
   * 
   * @param Name - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setName(final String Name) {
    firePropertyChange("Name", this.Name, this.Name = Name );
  }
  
  /**
   * Returns an unmodifiable list of subordinates.
   */
  public /* List<org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto> */Object getSubordinates() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetSubordinates());
  }
  
  /**
   * Returns the list of <code>TreeEmployeeDto</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private /* List<org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto> */Object internalGetSubordinates() {
    if (this.subordinates == null) {
      this.subordinates = new java.util.ArrayList<TreeEmployeeDto>();
    }
    return this.subordinates;
  }
  
  /**
   * Adds the given treeEmployeeDto to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>TreeEmployeeDto#boss</code> of the <code>treeEmployeeDto</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link TreeEmployeeDto#setBoss(TreeEmployeeDto)}.
   * 
   * @param treeEmployeeDto - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToSubordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto treeEmployeeDto) {
    checkDisposed();
    treeEmployeeDto.setBoss(this);
  }
  
  /**
   * Removes the given treeEmployeeDto from this object. <p>
   * 
   * @param treeEmployeeDto - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromSubordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto treeEmployeeDto) {
    checkDisposed();
    treeEmployeeDto.setBoss(null);
  }
  
  /**
   * For internal use only!
   */
  public void internalAddToSubordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto treeEmployeeDto) {
    internalGetSubordinates().add(treeEmployeeDto);
  }
  
  /**
   * For internal use only!
   */
  public void internalRemoveFromSubordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto treeEmployeeDto) {
    internalGetSubordinates().remove(treeEmployeeDto);
  }
  
  /**
   * Returns the <em>required</em> boss property.
   */
  public org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto getBoss() {
    checkDisposed();
    return this.boss;
  }
  
  /**
   * Sets the <code>boss</code> property to this instance.
   * 
   * @param boss - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setBoss(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployeeDto boss) {
    checkDisposed();
    firePropertyChange("boss", this.boss, this.boss = boss);
  }
}

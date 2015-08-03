/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.selfreference.dtos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.lunifera.dsl.common.datatypes.IDto;
import org.lunifera.dsl.dto.lib.MappingContext;
import org.lunifera.runtime.common.annotations.Dispose;
import org.lunifera.runtime.common.annotations.DomainReference;

@SuppressWarnings("all")
public class TreeEmployeeDto implements IDto, Serializable, PropertyChangeListener {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  @Dispose
  private boolean disposed;
  
  private long id;
  
  private String Name;
  
  @DomainReference
  private List<TreeEmployeeDto> subordinates;
  
  @DomainReference
  private TreeEmployeeDto boss;
  
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
      if (this.subordinates != null) {
        for (TreeEmployeeDto treeEmployeeDto : this.subordinates) {
          treeEmployeeDto.dispose();
        }
        this.subordinates = null;
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
   * Returns the Name property or <code>null</code> if not present.
   */
  public String getName() {
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
  public List<TreeEmployeeDto> getSubordinates() {
    return Collections.unmodifiableList(internalGetSubordinates());
  }
  
  /**
   * Returns the list of <code>TreeEmployeeDto</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private List<TreeEmployeeDto> internalGetSubordinates() {
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
  public void addToSubordinates(final TreeEmployeeDto treeEmployeeDto) {
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
  public void removeFromSubordinates(final TreeEmployeeDto treeEmployeeDto) {
    checkDisposed();
    
    treeEmployeeDto.setBoss(null);
  }
  
  /**
   * For internal use only!
   */
  public void internalAddToSubordinates(final TreeEmployeeDto treeEmployeeDto) {
    internalGetSubordinates().add(treeEmployeeDto);
  }
  
  /**
   * For internal use only!
   */
  public void internalRemoveFromSubordinates(final TreeEmployeeDto treeEmployeeDto) {
    internalGetSubordinates().remove(treeEmployeeDto);
  }
  
  /**
   * Sets the <code>subordinates</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>TreeEmployeeDto#
   * boss</code> of the <code>subordinates</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link TreeEmployeeDto#setBoss(TreeEmployeeDto)
   * 
   * @param subordinates - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSubordinates(final List<TreeEmployeeDto> subordinates) {
    checkDisposed();
    for (TreeEmployeeDto dto : internalGetSubordinates().toArray(new TreeEmployeeDto[this.subordinates.size()])) {
    	removeFromSubordinates(dto);
    }
    
    if(subordinates == null) {
    	return;
    }
    
    for (TreeEmployeeDto dto : subordinates) {
    	addToSubordinates(dto);
    }
  }
  
  /**
   * Returns the <em>required</em> boss property.
   */
  public TreeEmployeeDto getBoss() {
    return this.boss;
  }
  
  /**
   * Sets the <code>boss</code> property to this instance.
   * 
   * @param boss - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setBoss(final TreeEmployeeDto boss) {
    checkDisposed();
    firePropertyChange("boss", this.boss, this.boss = boss);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TreeEmployeeDto other = (TreeEmployeeDto) obj;
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
  
  public TreeEmployeeDto createDto() {
    return new TreeEmployeeDto();
  }
  
  public TreeEmployeeDto copy(final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    if(context.isMaxLevel()){
    	return null;
    }
    
    // if context contains a copied instance of this object
    // then return it
    TreeEmployeeDto newDto = context.get(this);
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
  
  public void copyContainments(final TreeEmployeeDto dto, final TreeEmployeeDto newDto, final MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    
    // copy attributes and beans (beans if derived from entity model)
    // copy id
    newDto.setId(getId());
    // copy Name
    newDto.setName(getName());
    
    // copy containment references (cascading is true)
    // copy list of subordinates dtos
    for(org.lunifera.dsl.entity.xtext.tests.selfreference.dtos.TreeEmployeeDto _dto : getSubordinates()) {
    	newDto.addToSubordinates(_dto.copy(context));
    }
  }
  
  public void copyCrossReferences(final TreeEmployeeDto dto, final TreeEmployeeDto newDto, final org.lunifera.dsl.dto.lib.MappingContext context) {
    checkDisposed();
    
    if (context == null) {
    	throw new IllegalArgumentException("Context must not be null!");
    }
    
    
    // copy cross references (cascading is false)
    // copy dto boss
    if(getBoss() != null) {
    	newDto.setBoss(getBoss().copy(context));
    }
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

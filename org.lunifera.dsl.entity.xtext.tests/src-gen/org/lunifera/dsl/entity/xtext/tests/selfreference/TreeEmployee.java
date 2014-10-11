/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.selfreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TREE_EMPLOYEE")
@DiscriminatorValue(value = "TREE_EMPLOYEE")
@SuppressWarnings("all")
public class TreeEmployee {
  @Transient
  private boolean disposed;
  
  @Id
  @GeneratedValue
  private long id;
  
  @Column(name = "NAME")
  private String Name;
  
  /**
   * Reference to children
   */
  @JoinColumn(name = "SUBORDINATES")
  @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL, orphanRemoval = true)
  private /* List<org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee> */Object subordinates;
  
  /**
   * Reference to parent
   */
  @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "BOSS", nullable = false)
  private org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee boss;
  
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
      if (this.subordinates != null) {
        for (TreeEmployee treeEmployee : this.subordinates) {
          treeEmployee.dispose();
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
   * Sets the id property to this instance.
   */
  public void setId(final long id) {
    checkDisposed();
    this.id = id;
  }
  
  /**
   * Returns the Name property or <code>null</code> if not present.
   */
  public String getName() {
    checkDisposed();
    return this.Name;
  }
  
  /**
   * Sets the Name property to this instance.
   */
  public void setName(final String Name) {
    checkDisposed();
    this.Name = Name;
  }
  
  /**
   * Returns an unmodifiable list of subordinates.
   */
  public /* List<org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee> */Object getSubordinates() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetSubordinates());
  }
  
  /**
   * Sets the given subordinates to the object. Currently contained subordinates instances will be removed.
   * 
   * @param subordinates the list of new instances
   */
  public void setSubordinates(final /* List<org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee> */Object subordinates) {
    // remove the old treeEmployee
    for(TreeEmployee oldElement : new ArrayList<TreeEmployee>(this.internalGetSubordinates())){
      removeFromSubordinates(oldElement);
    }
    
    // add the new treeEmployee
    for(TreeEmployee newElement : subordinates){
      addToSubordinates(newElement);
    }
  }
  
  /**
   * Returns the list of <code>TreeEmployee</code>s thereby lazy initializing it.
   */
  private /* List<org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee> */Object internalGetSubordinates() {
    if (this.subordinates == null) {
      this.subordinates = new ArrayList<TreeEmployee>();
    }
    return this.subordinates;
  }
  
  /**
   * Adds the given treeEmployee to this object. <p>
   * Since the reference is a composition reference, the opposite reference (TreeEmployee.boss)
   * of the treeEmployee will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link TreeEmployee#setBoss(TreeEmployee)}.
   * 
   */
  public void addToSubordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee treeEmployee) {
    checkDisposed();
    treeEmployee.setBoss(this);
  }
  
  /**
   * Removes the given treeEmployee from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (TreeEmployee.boss)
   * of the treeEmployee will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link TreeEmployee#setBoss(TreeEmployee)}.
   * 
   */
  public void removeFromSubordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee treeEmployee) {
    checkDisposed();
    treeEmployee.setBoss(null);
  }
  
  void internalAddToSubordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee treeEmployee) {
    internalGetSubordinates().add(treeEmployee);
  }
  
  void internalRemoveFromSubordinates(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee treeEmployee) {
    internalGetSubordinates().remove(treeEmployee);
  }
  
  /**
   * Returns the <em>required</em> boss property.
   */
  public org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee getBoss() {
    checkDisposed();
    return this.boss;
  }
  
  /**
   * Sets the boss property to this instance.
   * Since the reference is a container reference, the opposite reference (TreeEmployee.subordinates)
   * of the boss will be handled automatically and no further coding is required to keep them in sync.
   * See {@link TreeEmployee#setSubordinates(TreeEmployee)}.
   */
  public void setBoss(final org.lunifera.dsl.entity.xtext.tests.selfreference.TreeEmployee boss) {
    checkDisposed();
    if (this.boss != null) {
      this.boss.internalRemoveFromSubordinates(this);
    }
    this.boss = boss;
    if (this.boss != null) {
      this.boss.internalAddToSubordinates(this);
    }
    
  }
}

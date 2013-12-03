package org.lunifera.dsl.entity.xtext.tests.test7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.lunifera.dsl.entity.xtext.tests.test7.BaseEntity;
import org.lunifera.dsl.entity.xtext.tests.test7.House;

@Entity
@SuppressWarnings("all")
public class Room extends BaseEntity {
  @Column
  private String name;
  
  @Column
  private int floor;
  
  @OneToOne
  @JoinColumn(name = "parent")
  private House parent;
  
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
      if (this.parent != null) {
        this.parent.dispose();
        this.parent = null;
      }
      
    }
    finally {
      super.dispose();
    }
    
  }
  
  /**
   * Returns the name property or <code>null</code> if not present.
   */
  public String getName() {
    checkDisposed();
    return this.name;
  }
  
  /**
   * Sets the name property to this instance.
   */
  public void setName(final String name) {
    checkDisposed();
    this.name = name;
  }
  
  /**
   * Returns the floor property or <code>null</code> if not present.
   */
  public int getFloor() {
    checkDisposed();
    return this.floor;
  }
  
  /**
   * Sets the floor property to this instance.
   */
  public void setFloor(final int floor) {
    checkDisposed();
    this.floor = floor;
  }
  
  /**
   * Returns the parent property or <code>null</code> if not present.
   */
  public House getParent() {
    checkDisposed();
    return this.parent;
  }
  
  /**
   * Sets the parent property to this instance.
   * Since the reference is a container reference, the opposite reference (House.room)
   * of the parent will be handled automatically and no further coding is required to keep them in sync.
   * See {@link House#setRoom(House)}.
   */
  public void setParent(final House parent) {
    checkDisposed();
    if (this.parent != null) {
      this.parent.internalSetRoom(null);
    }
    this.parent = parent;
    if (this.parent != null) {
      this.parent.internalSetRoom(this);
    }
    
  }
  
  void internalSetParent(final House parent) {
    this.parent = parent;
  }
}

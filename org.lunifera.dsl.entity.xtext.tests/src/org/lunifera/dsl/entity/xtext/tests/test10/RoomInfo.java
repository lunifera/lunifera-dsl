package org.lunifera.dsl.entity.xtext.tests.test10;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("all")
public class RoomInfo {
  private boolean disposed;
  
  @Basic
  private String name;
  
  @Basic
  private int price;
  
  @Basic
  private boolean occupied;
  
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
    disposed = true;
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
   * Returns the occupied property or <code>null</code> if not present.
   */
  public boolean getOccupied() {
    checkDisposed();
    return this.occupied;
  }
  
  /**
   * Sets the occupied property to this instance.
   */
  public void setOccupied(final boolean occupied) {
    checkDisposed();
    this.occupied = occupied;
  }
}

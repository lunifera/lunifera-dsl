package org.lunifera.dsl.tests.carstore.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.lunifera.dsl.dto.lib.Context;

@MappedSuperclass
@SuppressWarnings("all")
public class Base {
  @Transient
  private boolean disposed;
  
  @Id
  private String uuid = java.util.UUID.randomUUID().toString();
  
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
   * Returns the uuid property or <code>null</code> if not present.
   */
  public String getUuid() {
    checkDisposed();
    return this.uuid;
  }
  
  /**
   * Sets the uuid property to this instance.
   */
  public void setUuid(final String uuid) {
    checkDisposed();
    this.uuid = uuid;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Base other = (Base) obj;
    if (this.uuid == null) {
      if (other.uuid != null)
        return false;
    } else if (!this.uuid.equals(other.uuid))
      return false;
    return true;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.uuid== null) ? 0 : this.uuid.hashCode());
    return result;
  }

}

package org.lunifera.dsl.entity.xtext.tests.test3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuppressWarnings("all")
public class BaseEntity {
  @Transient
  private boolean disposed;
  
  @Id
  private long id;
  
  @Version
  private int version;
  
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
   * Returns the version property or <code>null</code> if not present.
   */
  public int getVersion() {
    checkDisposed();
    return this.version;
  }
  
  /**
   * Sets the version property to this instance.
   */
  public void setVersion(final int version) {
    checkDisposed();
    this.version = version;
  }
}

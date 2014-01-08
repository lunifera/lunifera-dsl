package org.lunifera.dsl.entity.xtext.tests.blobtests;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import org.lunifera.dsl.entity.xtext.tests.blobtests.Bean1;

@Embeddable
@SuppressWarnings("all")
public class Bean implements Serializable {
  private boolean disposed;
  
  @Basic
  private String name;
  
  @Basic
  @Embedded
  private Bean1 info;
  
  @Basic
  private String huhu;
  
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
   * Returns the info property or <code>null</code> if not present.
   */
  public Bean1 getInfo() {
    checkDisposed();
    return this.info;
  }
  
  /**
   * Sets the info property to this instance.
   */
  public void setInfo(final Bean1 info) {
    checkDisposed();
    this.info = info;
  }
  
  /**
   * Returns the huhu property or <code>null</code> if not present.
   */
  public String getHuhu() {
    checkDisposed();
    return this.huhu;
  }
  
  /**
   * Sets the huhu property to this instance.
   */
  public void setHuhu(final String huhu) {
    checkDisposed();
    this.huhu = huhu;
  }
}

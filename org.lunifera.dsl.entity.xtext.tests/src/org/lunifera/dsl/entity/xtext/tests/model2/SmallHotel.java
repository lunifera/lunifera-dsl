package org.lunifera.dsl.entity.xtext.tests.model2;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.lunifera.dsl.entity.xtext.tests.model2.Hotel;

@Entity
@DiscriminatorValue(value = "SMALL_HOTEL")
@SuppressWarnings("all")
public class SmallHotel extends Hotel {
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
    super.dispose();
  }
}

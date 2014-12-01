package org.lunifera.dsl.tests.carstore.entities.dtos;

import java.io.Serializable;
import org.lunifera.dsl.tests.carstore.entities.dtos.BaseDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.CarDto;
import org.lunifera.runtime.common.annotations.DomainReference;

@SuppressWarnings("all")
public class AddonDto extends BaseDto implements Serializable {
  private String description;
  
  @DomainReference
  private CarDto car;
  
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
  
  /**
   * Returns the description property or <code>null</code> if not present.
   */
  public String getDescription() {
    checkDisposed();
    return this.description;
  }
  
  /**
   * Sets the <code>description</code> property to this instance.
   * 
   * @param description - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setDescription(final String description) {
    firePropertyChange("description", this.description, this.description = description );
  }
  
  /**
   * Returns the car property or <code>null</code> if not present.
   */
  public CarDto getCar() {
    checkDisposed();
    return this.car;
  }
  
  /**
   * Sets the <code>car</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>CarDto#
   * addons</code> of the <code>car</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link CarDto#setAddons(CarDto)
   * 
   * @param car - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setCar(final CarDto car) {
    checkDisposed();
    if (this.car != null) {
      this.car.internalRemoveFromAddons(this);
    }
    internalSetCar(car);
    if (this.car != null) {
      this.car.internalAddToAddons(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  public void internalSetCar(final CarDto car) {
    firePropertyChange("car", this.car, this.car = car);
  }
}

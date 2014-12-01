package org.lunifera.dsl.tests.carstore.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.lunifera.dsl.tests.carstore.entities.Address;
import org.lunifera.dsl.tests.carstore.entities.Base;
import org.lunifera.dsl.tests.carstore.entities.Car;

@Entity
@Table(name = "PERSON")
@SuppressWarnings("all")
public class Person extends Base {
  @Column(name = "FIRSTNAME")
  private String firstname;
  
  @Column(name = "LASTNAME")
  private String lastname;
  
  @JoinColumn(name = "OWNS_CARS")
  @OneToMany(mappedBy = "owner")
  private List<Car> ownsCars;
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "streetname", column = @Column(name = "HOMEADDRESS_STREETNAME")), @AttributeOverride(name = "postalcode", column = @Column(name = "HOMEADDRESS_POSTALCODE")) })
  @Column(name = "HOME_ADDRESS")
  private Address homeAddress;
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "streetname", column = @Column(name = "WORKADDRESS_STREETNAME")), @AttributeOverride(name = "postalcode", column = @Column(name = "WORKADDRESS_POSTALCODE")) })
  @Column(name = "WORK_ADDRESS")
  private Address workAddress;
  
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
   * Returns the firstname property or <code>null</code> if not present.
   */
  public String getFirstname() {
    checkDisposed();
    return this.firstname;
  }
  
  /**
   * Sets the firstname property to this instance.
   */
  public void setFirstname(final String firstname) {
    checkDisposed();
    this.firstname = firstname;
  }
  
  /**
   * Returns the lastname property or <code>null</code> if not present.
   */
  public String getLastname() {
    checkDisposed();
    return this.lastname;
  }
  
  /**
   * Sets the lastname property to this instance.
   */
  public void setLastname(final String lastname) {
    checkDisposed();
    this.lastname = lastname;
  }
  
  /**
   * Returns an unmodifiable list of ownsCars.
   */
  public List<Car> getOwnsCars() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetOwnsCars());
  }
  
  /**
   * Sets the given ownsCars to the object. Currently contained ownsCars instances will be removed.
   * 
   * @param ownsCars the list of new instances
   */
  public void setOwnsCars(final List<Car> ownsCars) {
    // remove the old car
    for(Car oldElement : new ArrayList<Car>(this.internalGetOwnsCars())){
      removeFromOwnsCars(oldElement);
    }
    
    // add the new car
    for(Car newElement : ownsCars){
      addToOwnsCars(newElement);
    }
  }
  
  /**
   * Returns the list of <code>Car</code>s thereby lazy initializing it.
   */
  private List<Car> internalGetOwnsCars() {
    if (this.ownsCars == null) {
      this.ownsCars = new ArrayList<Car>();
    }
    return this.ownsCars;
  }
  
  /**
   * Adds the given car to this object. <p>
   * Since the reference is a composition reference, the opposite reference (Car.owner)
   * of the car will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Car#setOwner(Car)}.
   * 
   */
  public void addToOwnsCars(final Car car) {
    checkDisposed();
    car.setOwner(this);
  }
  
  /**
   * Removes the given car from this object. <p>
   * 
   */
  public void removeFromOwnsCars(final Car car) {
    checkDisposed();
    car.setOwner(null);
  }
  
  void internalAddToOwnsCars(final Car car) {
    internalGetOwnsCars().add(car);
  }
  
  void internalRemoveFromOwnsCars(final Car car) {
    internalGetOwnsCars().remove(car);
  }
  
  /**
   * Returns the homeAddress property or <code>null</code> if not present.
   */
  public Address getHomeAddress() {
    checkDisposed();
    return this.homeAddress;
  }
  
  /**
   * Sets the homeAddress property to this instance.
   */
  public void setHomeAddress(final Address homeAddress) {
    checkDisposed();
    this.homeAddress = homeAddress;
  }
  
  /**
   * Returns the workAddress property or <code>null</code> if not present.
   */
  public Address getWorkAddress() {
    checkDisposed();
    return this.workAddress;
  }
  
  /**
   * Sets the workAddress property to this instance.
   */
  public void setWorkAddress(final Address workAddress) {
    checkDisposed();
    this.workAddress = workAddress;
  }
}

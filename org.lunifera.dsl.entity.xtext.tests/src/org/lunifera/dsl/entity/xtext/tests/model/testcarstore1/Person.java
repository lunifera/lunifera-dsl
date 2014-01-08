package org.lunifera.dsl.entity.xtext.tests.model.testcarstore1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore1.Address;

@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISC", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "PERSON")
@SuppressWarnings("all")
public class Person {
  @Transient
  private boolean disposed;
  
  @Id
  @GeneratedValue
  private long id;
  
  @Column(name = "FIRSTNAME")
  private String firstname;
  
  @Column(name = "LASTNAME")
  private String lastname;
  
  @Column(name = "BIRTHDATE")
  @Temporal(value = TemporalType.DATE)
  private Date birthdate;
  
  @ElementCollection
  @Column(name = "ADDRESS", nullable = false)
  private List<Address> address;
  
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
   * Returns the birthdate property or <code>null</code> if not present.
   */
  public Date getBirthdate() {
    checkDisposed();
    return this.birthdate;
  }
  
  /**
   * Sets the birthdate property to this instance.
   */
  public void setBirthdate(final Date birthdate) {
    checkDisposed();
    this.birthdate = birthdate;
  }
  
  /**
   * Returns an unmodifiable list of address.
   */
  public List<Address> getAddress() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetAddress());
  }
  
  /**
   * Returns the list of <code>Address</code>s thereby lazy initializing it.
   */
  private List<Address> internalGetAddress() {
    if (this.address == null) {
      this.address = new ArrayList<Address>();
    }
    return this.address;
  }
  
  /**
   * Adds the given address to this object. <p>
   * ATTENTION:<br>
   * The reference is a composition reference, but no opposite is available.
   * So the opposite will NOT be handled. Therefore you have to ensure that the parent of the reference
   * is set properly.
   * 
   */
  public void addToAddress(final Address address) {
    checkDisposed();
    if (!getAddress().contains(address)){
      getAddress().add(address);
    }
    
  }
  
  public void removeFromAddress(final Address address) {
    checkDisposed();
    getAddress().remove(address);
  }
}

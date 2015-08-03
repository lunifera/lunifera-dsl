/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.lunifera.dsl.common.datatypes.IEntity;
import org.lunifera.runtime.common.annotations.Dispose;

@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISC", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "PERSON")
@SuppressWarnings("all")
public class Person implements IEntity {
  @Transient
  @Dispose
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
  
  /**
   * Returns true, if the object is disposed. 
   * Disposed means, that it is prepared for garbage collection and may not be used anymore. 
   * Accessing objects that are already disposed will cause runtime exceptions.
   */
  @Dispose
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
  @Dispose
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
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (other.id != this.id)
      return false;
    return true;
  }
  
  @Override
  public int hashCode() {
     int prime = 31;
    int result = 1;
    result = prime * result + (int) (this.id ^ (this.id >>> 32));
    return result;
  }
}

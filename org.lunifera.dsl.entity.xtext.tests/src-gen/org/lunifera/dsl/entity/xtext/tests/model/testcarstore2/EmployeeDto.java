/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.PersonDto;

@SuppressWarnings("all")
public class EmployeeDto extends PersonDto implements Serializable {
  private long employeenumber;
  
  private Date employeesince;
  
  private int salary;
  
  private String jobdescription;
  
  private EmployeeDto boss;
  
  private List<EmployeeDto> subordinates;
  
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
      if (this.subordinates != null) {
        for (EmployeeDto employeeDto : this.subordinates) {
          employeeDto.dispose();
        }
        this.subordinates = null;
      }
      
    }
    finally {
      super.dispose();
    }
    
  }
  
  /**
   * Returns the employeenumber property or <code>null</code> if not present.
   */
  public long getEmployeenumber() {
    checkDisposed();
    return this.employeenumber;
  }
  
  /**
   * Sets the <code>employeenumber</code> property to this instance.
   * 
   * @param employeenumber - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setEmployeenumber(final long employeenumber) {
    firePropertyChange("employeenumber", this.employeenumber, this.employeenumber = employeenumber );
  }
  
  /**
   * Returns the employeesince property or <code>null</code> if not present.
   */
  public Date getEmployeesince() {
    checkDisposed();
    return this.employeesince;
  }
  
  /**
   * Sets the <code>employeesince</code> property to this instance.
   * 
   * @param employeesince - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setEmployeesince(final Date employeesince) {
    firePropertyChange("employeesince", this.employeesince, this.employeesince = employeesince );
  }
  
  /**
   * Returns the salary property or <code>null</code> if not present.
   */
  public int getSalary() {
    checkDisposed();
    return this.salary;
  }
  
  /**
   * Sets the <code>salary</code> property to this instance.
   * 
   * @param salary - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setSalary(final int salary) {
    firePropertyChange("salary", this.salary, this.salary = salary );
  }
  
  /**
   * Returns the jobdescription property or <code>null</code> if not present.
   */
  public String getJobdescription() {
    checkDisposed();
    return this.jobdescription;
  }
  
  /**
   * Sets the <code>jobdescription</code> property to this instance.
   * 
   * @param jobdescription - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setJobdescription(final String jobdescription) {
    firePropertyChange("jobdescription", this.jobdescription, this.jobdescription = jobdescription );
  }
  
  /**
   * Returns the <em>required</em> boss property.
   */
  public EmployeeDto getBoss() {
    checkDisposed();
    return this.boss;
  }
  
  /**
   * Sets the <code>boss</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>EmployeeDto#
   * subordinates</code> of the <code>boss</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link EmployeeDto#setSubordinates(EmployeeDto)
   * 
   * @param boss - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setBoss(final EmployeeDto boss) {
    checkDisposed();
    if (this.boss != null) {
      this.boss.internalRemoveFromSubordinates(this);
    }
    internalSetBoss(boss);
    if (this.boss != null) {
      this.boss.internalAddToSubordinates(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  public void internalSetBoss(final EmployeeDto boss) {
    firePropertyChange("boss", this.boss, this.boss = boss);
  }
  
  /**
   * Returns an unmodifiable list of subordinates.
   */
  public List<EmployeeDto> getSubordinates() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetSubordinates());
  }
  
  /**
   * Returns the list of <code>EmployeeDto</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private List<EmployeeDto> internalGetSubordinates() {
    if (this.subordinates == null) {
      this.subordinates = new java.util.ArrayList<EmployeeDto>();
    }
    return this.subordinates;
  }
  
  /**
   * Adds the given employeeDto to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>EmployeeDto#boss</code> of the <code>employeeDto</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link EmployeeDto#setBoss(EmployeeDto)}.
   * 
   * @param employeeDto - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToSubordinates(final EmployeeDto employeeDto) {
    checkDisposed();
    employeeDto.setBoss(this);
  }
  
  /**
   * Removes the given employeeDto from this object. <p>
   * 
   * @param employeeDto - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromSubordinates(final EmployeeDto employeeDto) {
    checkDisposed();
    employeeDto.setBoss(null);
  }
  
  /**
   * For internal use only!
   */
  public void internalAddToSubordinates(final EmployeeDto employeeDto) {
    internalGetSubordinates().add(employeeDto);
  }
  
  /**
   * For internal use only!
   */
  public void internalRemoveFromSubordinates(final EmployeeDto employeeDto) {
    internalGetSubordinates().remove(employeeDto);
  }
}

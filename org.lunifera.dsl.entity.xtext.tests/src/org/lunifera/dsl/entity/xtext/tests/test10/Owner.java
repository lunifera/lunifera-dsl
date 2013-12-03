package org.lunifera.dsl.entity.xtext.tests.test10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.lunifera.dsl.entity.xtext.tests.test10.BaseEntity;
import org.lunifera.dsl.entity.xtext.tests.test10.House;

@Entity
@SuppressWarnings("all")
public class Owner extends BaseEntity {
  @Column
  private String name;
  
  @Column
  private Date Birthday;
  
  @OneToMany(mappedBy = "owner")
  private List<House> houses;
  
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
   * Returns the Birthday property or <code>null</code> if not present.
   */
  public Date getBirthday() {
    checkDisposed();
    return this.Birthday;
  }
  
  /**
   * Sets the Birthday property to this instance.
   */
  public void setBirthday(final Date Birthday) {
    checkDisposed();
    this.Birthday = Birthday;
  }
  
  /**
   * Returns an unmodifiable list of houses.
   */
  public List<House> getHouses() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetHouses());
  }
  
  /**
   * Returns the list of <code>House</code>s thereby lazy initializing it.
   */
  private List<House> internalGetHouses() {
    if (this.houses == null) {
      this.houses = new ArrayList<House>();
    }
    return this.houses;
  }
  
  /**
   * Adds the given house to this object. <p>
   * Since the reference is a composition reference, the opposite reference (House.owner)
   * of the house will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link House#setOwner(House)}.
   * 
   */
  public void addToHouses(final House house) {
    checkDisposed();
    house.setOwner(this);
  }
  
  /**
   * Removes the given house from this object. <p>
   * 
   */
  public void removeFromHouses(final House house) {
    checkDisposed();
    house.setOwner(null);
  }
  
  void internalAddToHouses(final House house) {
    internalGetHouses().add(house);
  }
  
  void internalRemoveFromHouses(final House house) {
    internalGetHouses().remove(house);
  }
}

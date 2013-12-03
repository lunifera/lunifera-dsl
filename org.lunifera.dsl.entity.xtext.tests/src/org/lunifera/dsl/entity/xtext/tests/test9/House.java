package org.lunifera.dsl.entity.xtext.tests.test9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.lunifera.dsl.entity.xtext.tests.test9.Address;
import org.lunifera.dsl.entity.xtext.tests.test9.BaseEntity;
import org.lunifera.dsl.entity.xtext.tests.test9.Owner;
import org.lunifera.dsl.entity.xtext.tests.test9.Room;

@Entity
@SuppressWarnings("all")
public class House extends BaseEntity {
  @Column
  private String name;
  
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "owner")
  private Owner owner;
  
  @OneToMany(mappedBy = "parent")
  private List<Room> rooms;
  
  @Embedded
  @Column
  private Address address;
  
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
   * Returns the <em>required</em> owner property.
   */
  public Owner getOwner() {
    checkDisposed();
    return this.owner;
  }
  
  /**
   * Sets the owner property to this instance.
   * Since the reference is a container reference, the opposite reference (Owner.houses)
   * of the owner will be handled automatically and no further coding is required to keep them in sync.
   * See {@link Owner#setHouses(Owner)}.
   */
  public void setOwner(final Owner owner) {
    checkDisposed();
    if (this.owner != null) {
      this.owner.internalRemoveFromHouses(this);
    }
    this.owner = owner;
    if (this.owner != null) {
      this.owner.internalAddToHouses(this);
    }
    
  }
  
  /**
   * Returns an unmodifiable list of rooms.
   */
  public List<Room> getRooms() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetRooms());
  }
  
  /**
   * Returns the list of <code>Room</code>s thereby lazy initializing it.
   */
  private List<Room> internalGetRooms() {
    if (this.rooms == null) {
      this.rooms = new ArrayList<Room>();
    }
    return this.rooms;
  }
  
  /**
   * Adds the given room to this object. <p>
   * Since the reference is a composition reference, the opposite reference (Room.parent)
   * of the room will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Room#setParent(Room)}.
   * 
   */
  public void addToRooms(final Room room) {
    checkDisposed();
    room.setParent(this);
  }
  
  /**
   * Removes the given room from this object. <p>
   * 
   */
  public void removeFromRooms(final Room room) {
    checkDisposed();
    room.setParent(null);
  }
  
  void internalAddToRooms(final Room room) {
    internalGetRooms().add(room);
  }
  
  void internalRemoveFromRooms(final Room room) {
    internalGetRooms().remove(room);
  }
  
  /**
   * Returns the address property or <code>null</code> if not present.
   */
  public Address getAddress() {
    checkDisposed();
    return this.address;
  }
  
  /**
   * Sets the address property to this instance.
   */
  public void setAddress(final Address address) {
    checkDisposed();
    this.address = address;
  }
}

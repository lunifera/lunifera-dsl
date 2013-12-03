package org.lunifera.dsl.entity.xtext.tests.test7;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.lunifera.dsl.entity.xtext.tests.test7.BaseEntity;
import org.lunifera.dsl.entity.xtext.tests.test7.Room;

@Entity
@SuppressWarnings("all")
public class House extends BaseEntity {
  @Column
  private String name;
  
  @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
  private Room room;
  
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
      if (this.room != null) {
        this.room.dispose();
        this.room = null;
      }
      
    }
    finally {
      super.dispose();
    }
    
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
   * Returns the room property or <code>null</code> if not present.
   */
  public Room getRoom() {
    checkDisposed();
    return this.room;
  }
  
  /**
   * Sets the room property to this instance.
   * Since the reference is a container reference, the opposite reference (Room.parent)
   * of the room will be handled automatically and no further coding is required to keep them in sync.
   * See {@link Room#setParent(Room)}.
   */
  public void setRoom(final Room room) {
    checkDisposed();
    if (this.room != null) {
      this.room.internalSetParent(null);
    }
    this.room = room;
    if (this.room != null) {
      this.room.internalSetParent(this);
    }
    
  }
  
  void internalSetRoom(final Room room) {
    this.room = room;
  }
}

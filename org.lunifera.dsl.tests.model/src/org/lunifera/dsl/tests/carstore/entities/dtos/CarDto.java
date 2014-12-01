package org.lunifera.dsl.tests.carstore.entities.dtos;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.lunifera.dsl.tests.carstore.entities.dtos.AddonDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.BaseDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.PersonDto;
import org.lunifera.runtime.common.annotations.DomainReference;

@SuppressWarnings("all")
public class CarDto extends BaseDto implements Serializable {
  private String number;
  
  private Date finishingDate;
  
  @DomainReference
  private List<AddonDto> addons;
  
  @DomainReference
  private PersonDto owner;
  
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
      if (this.addons != null) {
        for (AddonDto addonDto : this.addons) {
          addonDto.dispose();
        }
        this.addons = null;
      }
      
    }
    finally {
      super.dispose();
    }
    
  }
  
  /**
   * Returns the number property or <code>null</code> if not present.
   */
  public String getNumber() {
    checkDisposed();
    return this.number;
  }
  
  /**
   * Sets the <code>number</code> property to this instance.
   * 
   * @param number - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setNumber(final String number) {
    firePropertyChange("number", this.number, this.number = number );
  }
  
  /**
   * Returns the finishingDate property or <code>null</code> if not present.
   */
  public Date getFinishingDate() {
    checkDisposed();
    return this.finishingDate;
  }
  
  /**
   * Sets the <code>finishingDate</code> property to this instance.
   * 
   * @param finishingDate - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setFinishingDate(final Date finishingDate) {
    firePropertyChange("finishingDate", this.finishingDate, this.finishingDate = finishingDate );
  }
  
  /**
   * Returns an unmodifiable list of addons.
   */
  public List<AddonDto> getAddons() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetAddons());
  }
  
  /**
   * Returns the list of <code>AddonDto</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private List<AddonDto> internalGetAddons() {
    if (this.addons == null) {
      this.addons = new java.util.ArrayList<AddonDto>();
    }
    return this.addons;
  }
  
  /**
   * Adds the given addonDto to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>AddonDto#car</code> of the <code>addonDto</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link AddonDto#setCar(AddonDto)}.
   * 
   * @param addonDto - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToAddons(final AddonDto addonDto) {
    checkDisposed();
    addonDto.setCar(this);
  }
  
  /**
   * Removes the given addonDto from this object. <p>
   * 
   * @param addonDto - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromAddons(final AddonDto addonDto) {
    checkDisposed();
    addonDto.setCar(null);
  }
  
  /**
   * For internal use only!
   */
  public void internalAddToAddons(final AddonDto addonDto) {
    internalGetAddons().add(addonDto);
  }
  
  /**
   * For internal use only!
   */
  public void internalRemoveFromAddons(final AddonDto addonDto) {
    internalGetAddons().remove(addonDto);
  }
  
  /**
   * Sets the <code>addons</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>AddonDto#
   * car</code> of the <code>addons</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link AddonDto#setCar(AddonDto)
   * 
   * @param addons - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setAddons(final List<AddonDto> addons) {
    checkDisposed();
    for (AddonDto dto : internalGetAddons().toArray(new AddonDto[this.addons.size()])) {
      removeFromAddons(dto);
    }
    if(addons == null){
      return;
    }
    for (AddonDto dto : addons) {
      addToAddons(dto);
    }
    
  }
  
  /**
   * Returns the owner property or <code>null</code> if not present.
   */
  public PersonDto getOwner() {
    checkDisposed();
    return this.owner;
  }
  
  /**
   * Sets the <code>owner</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>PersonDto#
   * ownsCars</code> of the <code>owner</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link PersonDto#setOwnsCars(PersonDto)
   * 
   * @param owner - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setOwner(final PersonDto owner) {
    checkDisposed();
    if (this.owner != null) {
      this.owner.internalRemoveFromOwnsCars(this);
    }
    internalSetOwner(owner);
    if (this.owner != null) {
      this.owner.internalAddToOwnsCars(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  public void internalSetOwner(final PersonDto owner) {
    firePropertyChange("owner", this.owner, this.owner = owner);
  }
}

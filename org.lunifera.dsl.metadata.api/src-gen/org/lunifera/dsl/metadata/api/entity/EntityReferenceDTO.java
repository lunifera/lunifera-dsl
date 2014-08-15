package org.lunifera.dsl.metadata.api.entity;

import java.io.Serializable;
import org.lunifera.dsl.metadata.api.entity.EntityDTO;
import org.lunifera.dsl.metadata.api.entity.EntityFeatureDTO;

@SuppressWarnings("all")
public class EntityReferenceDTO extends EntityFeatureDTO implements Serializable {
  private EntityDTO type;
  
  private EntityReferenceDTO opposite;
  
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
   * Returns the type property or <code>null</code> if not present.
   */
  public EntityDTO getType() {
    checkDisposed();
    return this.type;
  }
  
  /**
   * Sets the <code>type</code> property to this instance.
   * 
   * @param type - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setType(final EntityDTO type) {
    checkDisposed();
    firePropertyChange("type", this.type, this.type = type);
  }
  
  /**
   * Returns the opposite property or <code>null</code> if not present.
   */
  public EntityReferenceDTO getOpposite() {
    checkDisposed();
    return this.opposite;
  }
  
  /**
   * Sets the <code>opposite</code> property to this instance.
   * 
   * @param opposite - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setOpposite(final EntityReferenceDTO opposite) {
    checkDisposed();
    firePropertyChange("opposite", this.opposite, this.opposite = opposite);
  }
}

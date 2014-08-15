package org.lunifera.dsl.metadata.api.entity;

import java.io.Serializable;
import org.lunifera.dsl.metadata.api.entity.DiscriminatorType;
import org.lunifera.dsl.metadata.api.entity.EntityInheritanceStrategyDTO;

@SuppressWarnings("all")
public class TablePerSubclassStrategyDTO extends EntityInheritanceStrategyDTO implements Serializable {
  private String discriminatorColumn;
  
  private DiscriminatorType discriminatorType;
  
  private String discriminatorValue;
  
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
   * Returns the discriminatorColumn property or <code>null</code> if not present.
   */
  public String getDiscriminatorColumn() {
    checkDisposed();
    return this.discriminatorColumn;
  }
  
  /**
   * Sets the <code>discriminatorColumn</code> property to this instance.
   * 
   * @param discriminatorColumn - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setDiscriminatorColumn(final String discriminatorColumn) {
    firePropertyChange("discriminatorColumn", this.discriminatorColumn, this.discriminatorColumn = discriminatorColumn );
  }
  
  /**
   * Returns the discriminatorType property or <code>null</code> if not present.
   */
  public DiscriminatorType getDiscriminatorType() {
    checkDisposed();
    return this.discriminatorType;
  }
  
  /**
   * Sets the <code>discriminatorType</code> property to this instance.
   * 
   * @param discriminatorType - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setDiscriminatorType(final DiscriminatorType discriminatorType) {
    firePropertyChange("discriminatorType", this.discriminatorType, this.discriminatorType = discriminatorType );
  }
  
  /**
   * Returns the discriminatorValue property or <code>null</code> if not present.
   */
  public String getDiscriminatorValue() {
    checkDisposed();
    return this.discriminatorValue;
  }
  
  /**
   * Sets the <code>discriminatorValue</code> property to this instance.
   * 
   * @param discriminatorValue - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setDiscriminatorValue(final String discriminatorValue) {
    firePropertyChange("discriminatorValue", this.discriminatorValue, this.discriminatorValue = discriminatorValue );
  }
}

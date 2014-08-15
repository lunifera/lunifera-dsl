package org.lunifera.dsl.metadata.api.entity;

import java.io.Serializable;
import org.lunifera.dsl.metadata.api.entity.BeanDTO;
import org.lunifera.dsl.metadata.api.types.FeatureDTO;

@SuppressWarnings("all")
public class BeanFeatureDTO extends FeatureDTO implements Serializable {
  private BeanDTO bean;
  
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
   * Returns the bean property or <code>null</code> if not present.
   */
  public BeanDTO getBean() {
    checkDisposed();
    return this.bean;
  }
  
  /**
   * Sets the <code>bean</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>BeanDTO#
   * features</code> of the <code>bean</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link BeanDTO#setFeatures(BeanDTO)
   * 
   * @param bean - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setBean(final BeanDTO bean) {
    checkDisposed();
    if (this.bean != null) {
      this.bean.internalRemoveFromFeatures(this);
    }
    internalSetBean(bean);
    if (this.bean != null) {
      this.bean.internalAddToFeatures(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetBean(final BeanDTO bean) {
    firePropertyChange("bean", this.bean, this.bean = bean);
  }
}

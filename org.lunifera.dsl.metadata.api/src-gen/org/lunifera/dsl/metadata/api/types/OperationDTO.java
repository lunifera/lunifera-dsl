package org.lunifera.dsl.metadata.api.types;

import java.io.Serializable;

@SuppressWarnings("all")
public class OperationDTO implements org.lunifera.dsl.metadata.api.types.AnnotationTargetDTO, Serializable {
  private org.lunifera.dsl.metadata.api.types.ModifierDTO modifier;
  
  private Class<?> type;
  
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
      if (this.modifier != null) {
        this.modifier.dispose();
        this.modifier = null;
      }
      
    }
    finally {
      super.dispose();
    }
    
  }
  
  /**
   * Returns the modifier property or <code>null</code> if not present.
   */
  public org.lunifera.dsl.metadata.api.types.ModifierDTO getModifier() {
    checkDisposed();
    return this.modifier;
  }
  
  /**
   * Sets the <code>modifier</code> property to this instance.
   * Since the reference has an opposite reference, the opposite <code>ModifierDTO#
   * operation</code> of the <code>modifier</code> will be handled automatically and no 
   * further coding is required to keep them in sync.<p>
   * See {@link ModifierDTO#setOperation(ModifierDTO)
   * 
   * @param modifier - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setModifier(final org.lunifera.dsl.metadata.api.types.ModifierDTO modifier) {
    checkDisposed();
    if (this.modifier != null) {
      this.modifier.internalSetOperation(null);
    }
    internalSetModifier(modifier);
    if (this.modifier != null) {
      this.modifier.internalSetOperation(this);
    }
    
  }
  
  /**
   * For internal use only!
   */
  void internalSetModifier(final org.lunifera.dsl.metadata.api.types.ModifierDTO modifier) {
    firePropertyChange("modifier", this.modifier, this.modifier = modifier);
  }
  
  /**
   * Returns the type property or <code>null</code> if not present.
   */
  public Class<?> getType() {
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
  public void setType(final Class<?> type) {
    firePropertyChange("type", this.type, this.type = type );
  }
}

package org.lunifera.dsl.metadata.api.types;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class EnumDTO implements org.lunifera.dsl.metadata.api.types.ScalarTypeDTO, Serializable {
  private /* List<org.lunifera.dsl.metadata.api.types.EnumLiteralDTO> */Object literals;
  
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
      if (this.literals != null) {
        for (EnumLiteralDTO enumLiteralDTO : this.literals) {
          enumLiteralDTO.dispose();
        }
        this.literals = null;
      }
      
    }
    finally {
      super.dispose();
    }
    
  }
  
  /**
   * Returns an unmodifiable list of literals.
   */
  public /* List<org.lunifera.dsl.metadata.api.types.EnumLiteralDTO> */Object getLiterals() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetLiterals());
  }
  
  /**
   * Returns the list of <code>EnumLiteralDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private /* List<org.lunifera.dsl.metadata.api.types.EnumLiteralDTO> */Object internalGetLiterals() {
    if (this.literals == null) {
      this.literals = new java.util.ArrayList<EnumLiteralDTO>();
    }
    return this.literals;
  }
  
  /**
   * Adds the given enumLiteralDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>EnumLiteralDTO#parentEnum</code> of the <code>enumLiteralDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link EnumLiteralDTO#setParentEnum(EnumLiteralDTO)}.
   * 
   * @param enumLiteralDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToLiterals(final org.lunifera.dsl.metadata.api.types.EnumLiteralDTO enumLiteralDTO) {
    checkDisposed();
    enumLiteralDTO.setParentEnum(this);
  }
  
  /**
   * Removes the given enumLiteralDTO from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (EnumLiteralDTO.parentEnum)
   * of the enumLiteralDTO will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link EnumLiteralDTO#setParentEnum(EnumLiteralDTO)}.
   * 
   * @param enumLiteralDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromLiterals(final org.lunifera.dsl.metadata.api.types.EnumLiteralDTO enumLiteralDTO) {
    checkDisposed();
    enumLiteralDTO.setParentEnum(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToLiterals(final org.lunifera.dsl.metadata.api.types.EnumLiteralDTO enumLiteralDTO) {
    internalGetLiterals().add(enumLiteralDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromLiterals(final org.lunifera.dsl.metadata.api.types.EnumLiteralDTO enumLiteralDTO) {
    internalGetLiterals().remove(enumLiteralDTO);
  }
}

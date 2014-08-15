package org.lunifera.dsl.metadata.api.types;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class AnnotationTargetDTO implements Serializable {
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  
  private boolean disposed;
  
  private /* List<org.lunifera.dsl.metadata.api.types.AnnotationDefDTO> */Object annotations;
  
  /**
   * Returns true, if the object is disposed. 
   * Disposed means, that it is prepared for garbage collection and may not be used anymore. 
   * Accessing objects that are already disposed will cause runtime exceptions.
   */
  public boolean isDisposed() {
    return this.disposed;
  }
  
  /**
   * @see PropertyChangeSupport#addPropertyChangeListener(PropertyChangeListener)
   */
  public void addPropertyChangeListener(final PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }
  
  /**
   * @see PropertyChangeSupport#addPropertyChangeListener(String, PropertyChangeListener)
   */
  public void addPropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
  }
  
  /**
   * @see PropertyChangeSupport#removePropertyChangeListener(PropertyChangeListener)
   */
  public void removePropertyChangeListener(final PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }
  
  /**
   * @see PropertyChangeSupport#removePropertyChangeListener(String, PropertyChangeListener)
   */
  public void removePropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
  }
  
  /**
   * @see PropertyChangeSupport#firePropertyChange(String, Object, Object)
   */
  public void firePropertyChange(final String propertyName, final Object oldValue, final Object newValue) {
    propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
  }
  
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
      if (this.annotations != null) {
        for (AnnotationDefDTO annotationDefDTO : this.annotations) {
          annotationDefDTO.dispose();
        }
        this.annotations = null;
      }
      
    }
    finally {
      disposed = true;
    }
    
  }
  
  /**
   * Returns an unmodifiable list of annotations.
   */
  public /* List<org.lunifera.dsl.metadata.api.types.AnnotationDefDTO> */Object getAnnotations() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetAnnotations());
  }
  
  /**
   * Returns the list of <code>AnnotationDefDTO</code>s thereby lazy initializing it. For internal use only!
   * 
   * @return list - the resulting list
   * 
   */
  private /* List<org.lunifera.dsl.metadata.api.types.AnnotationDefDTO> */Object internalGetAnnotations() {
    if (this.annotations == null) {
      this.annotations = new java.util.ArrayList<AnnotationDefDTO>();
    }
    return this.annotations;
  }
  
  /**
   * Adds the given annotationDefDTO to this object. <p>
   * Since the reference is a composition reference, the opposite reference <code>AnnotationDefDTO#target</code> of the <code>annotationDefDTO</code> will be handled automatically and no further coding is required to keep them in sync.<p>
   * See {@link AnnotationDefDTO#setTarget(AnnotationDefDTO)}.
   * 
   * @param annotationDefDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void addToAnnotations(final org.lunifera.dsl.metadata.api.types.AnnotationDefDTO annotationDefDTO) {
    checkDisposed();
    annotationDefDTO.setTarget(this);
  }
  
  /**
   * Removes the given annotationDefDTO from this object. <p>
   * Since the reference is a cascading reference, the opposite reference (AnnotationDefDTO.target)
   * of the annotationDefDTO will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link AnnotationDefDTO#setTarget(AnnotationDefDTO)}.
   * 
   * @param annotationDefDTO - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void removeFromAnnotations(final org.lunifera.dsl.metadata.api.types.AnnotationDefDTO annotationDefDTO) {
    checkDisposed();
    annotationDefDTO.setTarget(null);
  }
  
  /**
   * For internal use only!
   */
  void internalAddToAnnotations(final org.lunifera.dsl.metadata.api.types.AnnotationDefDTO annotationDefDTO) {
    internalGetAnnotations().add(annotationDefDTO);
  }
  
  /**
   * For internal use only!
   */
  void internalRemoveFromAnnotations(final org.lunifera.dsl.metadata.api.types.AnnotationDefDTO annotationDefDTO) {
    internalGetAnnotations().remove(annotationDefDTO);
  }
}

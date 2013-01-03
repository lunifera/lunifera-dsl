package org.lunifera.dsl.entity.xtext.tests.testmodel.model;

public class Info {
  private boolean disposed;
  
  private String shortText;
  
  private String longText;
  
  /**
   * Returns true, if the object is disposed. Disposed means, that it is
   * prepared for garbage collection and may not be used anymore. Accessing
   * objects that are already disposed will cause runtime exceptions.
   * 
   * @return true if the object is disposed and false otherwise
   */
  public boolean isDisposed() {
    return this.disposed;
  }
  
  /**
   * Checks whether the object is disposed.
   * 
   * @throws RuntimeException if the object is disposed.
   * 
   */
  private void checkDisposed() {
    if (isDisposed()) {
    	throw new RuntimeException(String.format(
    			"Object already disposed: {}", this.toString()));
    }
    
  }
  
  /**
   * Calling dispose will destroy that instance. The internal state will be 
   * set to 'disposed' and methods of that object must not be used anymore. 
   * Each call will result in runtime exceptions.<br>
   * If this object keeps containment references, these will be disposed too. 
   * So the whole containment tree will be disposed on calling this method.
   * 
   */
  public void dispose() {
    if(isDisposed()){
    	return;
    }
    
    disposed = true;
    
  }
  
  /**
   * Returns the shortText property or <code>null</code> if not present.
   * 
   * @return shortText
   */
  public String getShortText() {
    checkDisposed();
    
    return this.shortText;
  }
  
  /**
   * Sets the shortText property to this instance.
   * 
   * @param shortText
   */
  public void setShortText(final String shortText) {
    checkDisposed();
    
    this.shortText = shortText;
  }
  
  /**
   * Returns the longText property or <code>null</code> if not present.
   * 
   * @return longText
   */
  public String getLongText() {
    checkDisposed();
    
    return this.longText;
  }
  
  /**
   * Sets the longText property to this instance.
   * 
   * @param longText
   */
  public void setLongText(final String longText) {
    checkDisposed();
    
    this.longText = longText;
  }
}

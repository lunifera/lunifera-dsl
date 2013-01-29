package org.lunifera.dsl.entity.xtext.tests.testmodel.model;

import org.lunifera.dsl.entity.xtext.tests.testmodel.model.Library;

public class Book {
  private boolean disposed;
  
  private String name;
  
  private boolean settingLibrary;
  
  private Library library;
  
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
   * Returns the name property or <code>null</code> if not present.
   * 
   * @return name
   */
  public String getName() {
    checkDisposed();
    
    return this.name;
  }
  
  /**
   * Sets the name property to this instance.
   * 
   * @param name
   */
  public void setName(final String name) {
    checkDisposed();
    
    this.name = name;
  }
  
  /**
   * Returns the library reference or <code>null</code> if not present.
   * 
   * @return library
   */
  public Library getLibrary() {
    checkDisposed();
    
    return this.library;
  }
  
  /**
   * Sets the library reference to this instance.
   * 
   * Since the reference is a container reference, the opposite reference (Library.books) 
   * of the library will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Library#setBooks(Library)}.
   * 
   * @param library
   */
  public void setLibrary(final Library library) {
    checkDisposed();
    
    if (settingLibrary) {
    	// avoid loops
    	return;
    }
    
    Library oldLibrary = this.library;
    
    // if the parent does not change, we can leave
    if (oldLibrary == library) {
    	return;
    }
    
    try {
    // avoid loops
    settingLibrary = true;
    	// First remove the element
    	if (oldLibrary != null) {
    		oldLibrary.removeBooks(this);
    	}
    	
    	// Then assign the new value
    	this.library = library;
    	
    	// Then add 'this' to the new value
    	if (this.library != null) {
    		this.library.addBooks(this);
    	}
    } finally {
    	settingLibrary = false;
    }
    
  }
}

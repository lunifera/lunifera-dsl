package org.lunifera.dsl.entity.xtext.tests.testmodel.model;

import java.util.List;

import org.lunifera.dsl.entity.xtext.tests.testmodel.model.Book;
import org.lunifera.dsl.entity.xtext.tests.testmodel.model.BookIndex;

/**
 * Test 112233
 */
public class Library {
  private boolean disposed;
  
  private String name;
  
  private List<String> manyNames;
  
  private List<List<String>> manymanyNames;
  
  private boolean settingIndex;
  
  private BookIndex index;
  
  private boolean settingBooks;
  
  private List<Book> books;
  
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
    
    try{
    	// dispose all the containment references
    	if(this.index != null){
    		this.index.dispose();
    		this.index = null;
    	}
    	if(this.books != null){
    		for(Book book : this.books){
    			book.dispose();
    		}
    		this.books = null;
    	}
    } finally {
    	disposed = true;
    }
    
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
   * Returns an unmodifiable list of manyNames.
   * 
   * @return manyNames
   */
  public List<String> getManyNames() {
    checkDisposed();
    
    ensureManyNames();
    return java.util.Collections.unmodifiableList(this.manyNames);
  }
  
  /**
   * Adds the given manyNames to this object. <p>
   * 
   * @param manyNames
   */
  public void addManyNames(final String manyNames) {
    checkDisposed();
    
    // If manyNames is null, we do not add it
    if(manyNames==null){
    	return;
    }
    
    ensureManyNames();
    
    // Adds the parameter to the list
    if(!this.manyNames.contains(manyNames)){
    	this.manyNames.add(manyNames);
    }
  }
  
  /**
   * Removes the given manyNames from this object.
   * 
   * @param manyNames
   */
  public void removeManyNames(final String manyNames) {
    checkDisposed();
    
    // If manyNames or the manyNames are null, we can leave
    if(manyNames==null || this.manyNames==null){
    	return;
    }
    
    this.manyNames.remove(manyNames);
  }
  
  /**
   * Ensures that the list of manyNames is created. It will be instantiated 
   * lazy.
   */
  private void ensureManyNames() {
    if (this.manyNames == null) {
    	this.manyNames = new java.util.ArrayList<String>();
    }
  }
  
  /**
   * Returns an unmodifiable list of manymanyNames.
   * 
   * @return manymanyNames
   */
  public List<List<String>> getManymanyNames() {
    checkDisposed();
    
    ensureManymanyNames();
    return java.util.Collections.unmodifiableList(this.manymanyNames);
  }
  
  /**
   * Adds the given manymanyNames to this object. <p>
   * 
   * @param manymanyNames
   */
  public void addManymanyNames(final List<String> manymanyNames) {
    checkDisposed();
    
    // If manymanyNames is null, we do not add it
    if(manymanyNames==null){
    	return;
    }
    
    ensureManymanyNames();
    
    // Adds the parameter to the list
    if(!this.manymanyNames.contains(manymanyNames)){
    	this.manymanyNames.add(manymanyNames);
    }
  }
  
  /**
   * Removes the given manymanyNames from this object.
   * 
   * @param manymanyNames
   */
  public void removeManymanyNames(final List<String> manymanyNames) {
    checkDisposed();
    
    // If manymanyNames or the manymanyNames are null, we can leave
    if(manymanyNames==null || this.manymanyNames==null){
    	return;
    }
    
    this.manymanyNames.remove(manymanyNames);
  }
  
  /**
   * Ensures that the list of manymanyNames is created. It will be instantiated 
   * lazy.
   */
  private void ensureManymanyNames() {
    if (this.manymanyNames == null) {
    	this.manymanyNames = new java.util.ArrayList<List<String>>();
    }
  }
  
  /**
   * Returns the index reference or <code>null</code> if not present.
   * 
   * @return index
   */
  public BookIndex getIndex() {
    checkDisposed();
    
    return this.index;
  }
  
  /**
   * Sets the index reference to this instance.
   * 
   * Since the reference is a containment reference, the opposite reference (BookIndex.library) 
   * of the bookIndex will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link BookIndex#setLibrary(BookIndex)}.
   * 
   * @param bookIndex
   */
  public void setIndex(final BookIndex bookIndex) {
    checkDisposed();
    
    if (settingIndex) {
    	// avoid loops
    	return;
    }
    
    BookIndex oldIndex = this.index;
    
    // if the parent does not change, we can leave
    if (oldIndex == bookIndex) {
    	return;
    }
    
    try {
    	// avoid loops
    	settingIndex = true;
    
    	// First remove the element
    	if (oldIndex != null) {
    		oldIndex.setLibrary(null);
    	}
    	
    	// Then assign the new value
    	this.index = bookIndex;
    	
    	// Then add 'this' to the new value
    	if (this.index != null) {
    		this.index.setLibrary(this);
    	}
    } finally {
    	settingIndex = false;
    }
    
  }
  
  /**
   * Returns an unmodifiable list of books.
   * 
   * @return books
   */
  public List<Book> getBooks() {
    checkDisposed();
    
    ensureBooks();
    return java.util.Collections.unmodifiableList(this.books);
  }
  
  /**
   * Adds the given book to this object. <p>
   * Since the reference is a containment reference, the opposite reference (Book.library) 
   * of the book will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Book#setLibrary(Book)}.
   * 
   * @param book
   */
  public void addBooks(final Book book) {
    checkDisposed();
    
    if (settingBooks) {
    	// avoid loops
    	return;
    }
    
    // If book is null, we do not add it
    if(book==null){
        return;
    }
    
    try{
    	settingBooks = true;
    
    	ensureBooks();
    
    	// Adds the parameter to the list
    	if(!this.books.contains(book)){
        	this.books.add(book);
    
    		// Set 'this' as the parent of the containment reference to the book
    		book.setLibrary(this);
    	}
    } finally {
    	settingBooks = false;
    }
    
  }
  
  /**
   * Removes the given book from this object. <p>
   * Since the reference is a containment reference, the opposite reference (Book.library) 
   * of the book will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Book#setLibrary(Book)}.
   * 
   * @param book
   */
  public void removeBooks(final Book book) {
    checkDisposed();
    
    // If the parameter or the field are null, we can leave
    if (book == null || this.books == null) {
    	return;
    }
    
    // if the book is not contained, then we can leave
    if (!this.books.contains(book)) {
    	return;
    }
    
    // Removes the parameter from the field
    this.books.remove(book);
    // Unset the parent of the containment reference from the book
    book.setLibrary(null);
    
  }
  
  /**
   * Ensures that the list of books is created. It will be instantiated 
   * lazy.
   */
  private void ensureBooks() {
    if (this.books == null) {
    	this.books = new java.util.ArrayList<Book>();
    }
  }
}

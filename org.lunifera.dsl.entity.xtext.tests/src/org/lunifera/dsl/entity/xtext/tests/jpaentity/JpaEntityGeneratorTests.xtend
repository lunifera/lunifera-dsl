/**************************************************************************
 * Copyright (c) 2011, 2012 Committers of lunifera.org - Lunifera.org.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 **************************************************************************/
package org.lunifera.dsl.entity.xtext.tests.jpaentity

import com.google.inject.Inject
import java.util.HashMap
import java.util.Map
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.lunifera.dsl.entity.xtext.EntityGrammarInjectorProvider
import org.lunifera.dsl.entity.xtext.tests.MultiFilesCompilationTestHelper

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(EntityGrammarInjectorProvider))
class JpaEntityGeneratorTest {

	@Inject extension MultiFilesCompilationTestHelper

	@Test
	def void compareEntity() {
		'''
			package my.test {
			    entity Library {
			    }
			}
		'''.assertCompilesTo(
			'''
				package my.test;
				
				import javax.persistence.Entity;
				
				@Entity
				public class Library {
				}
			''')
	}

	@Test
	def void compareInheritance() {
		'''
			package my.test {
			    entity Person {
			    }
			    entity Customer extends Person {
			    }
			}
		'''.assertCompilesTo(
			'''
				package my.test;
				
				import javax.persistence.Entity;
				
				@Entity
				public class Library {
				}
			''')
	}

	def String defaultDatatypes() {
		'''
			package org.lunifera.platformDataTypes {
			    datatype String           jvmType String
			    datatype Long             jvmType Long
			    datatype PrimitiveLong    jvmType long
			    datatype Decimal          jvmType java.math.BigDecimal
			    datatype Boolean          jvmType Boolean
			    datatype PrimitiveBoolean jvmType boolean
			    datatype DateTime         jvmType java.util.Date
			    datatype Binary           jvmType byte[]
			}
		'''
	}

	@Test
	def void compareEntityJPA() {
		'''«defaultDatatypes»
			package my.test {
			    import org.lunifera.platformDataTypes.*
			    entity Library {
			        var id PrimitiveLong id
			    }
			}
        '''.
			assertCompilesTo(
				'''
					package my.test;

					import javax.persistence.Column;
					import javax.persistence.Entity;
					import javax.persistence.GeneratedValue;
					import javax.persistence.GenerationType;
					import javax.persistence.Id;
					
					@Entity
					public class Library {
					  @Column
					  @Id
					  @GeneratedValue(strategy = GenerationType.IDENTITY)
					  private long id;
					  
					  /**
					   * Returns the id property or <code>null</code> if not present.
					   * 
					   * @return id
					   */
					  public long getId() {
					    return this.id;
					  }
					  
					  /**
					   * Sets the id property to this instance.
					   * 
					   * @param id
					   */
					  public void setId(final long id) {
					    this.id = id;
					  }
					}
				''')
	}

	@Test
	def void compare_Single_Property() {
		''' «defaultDatatypes»
            package my.test {
                import org.lunifera.platformDataTypes.*
                entity Library {
                    var String name
                }
            }
        '''.
			assertCompilesTo(
				'''
					package my.test;

					import javax.persistence.Column;
					import javax.persistence.Entity;
					
					@Entity
					public class Library {
					  @Column
					  private String name;
					  
					  /**
					   * Returns the name property or <code>null</code> if not present.
					   */
					  public String getName() {
					    return this.name;
					  }
					  
					  /**
					   * Sets the name property to this instance.
					   */
					  public void setName(final String name) {
					    this.name = name;
					  }
					}
				''')
	}

	@Test
	def void compare_Single_TransientProperty() {
		''' «defaultDatatypes»
            package my.test {
                import org.lunifera.platformDataTypes.*
                entity Library {
                    transient String name
                }
            }
        '''.
			assertCompilesTo(
				'''
					package my.test;

					import javax.persistence.Entity;
					
					@Entity
					public class Library {
					  private String name;
					  
					  /**
					   * Returns the name property or <code>null</code> if not present.
					   */
					  public String getName() {
					    return this.name;
					  }
					  
					  /**
					   * Sets the name property to this instance.
					   */
					  public void setName(final String name) {
					    this.name = name;
					  }
					}
				''')
	}

	@Test
	def void compare_Single_NotnullProperty() {
		''' «defaultDatatypes»
            package my.test {
                import org.lunifera.platformDataTypes.*
                entity Library {
                    var String name notnull
                }
            }
        '''.
			assertCompilesTo(
				'''
					package my.test;

					import javax.persistence.Column;
					import javax.persistence.Entity;
					
					@Entity
					public class Library {
					  @Column(nullable = false)
					  private String name;
					  
					  /**
					   * Returns the <em>required</em> name property.
					   */
					  public String getName() {
					    return this.name;
					  }
					  
					  /**
					   * Sets the name property to this instance.
					   */
					  public void setName(final String name) {
					    this.name = name;
					  }
					}
				''')
	}

	@Ignore("do we really need to support var-collections???")
	def void compare_Multiple_Property() {
		'''
			package my.test {
			    entity Library {
			        var String[*] names
			    }
			}
		'''.assertCompilesTo(
			'''
				package my.test;
				
				import java.util.List;
				
				public class Library {
				  private List<String> names;
				  
				  /**
				   * Returns an unmodifiable list of names.
				   * 
				   * @return names
				   */
				  public List<String> getNames() {
				    return java.util.Collections.unmodifiableList(internalGetNames());
				  }
				  
				  /**
				   * Ensures that the list of names is created. It will be instantiated 
				   * lazy.
				   */
				  private void internalGetNames() {
				    if (this.names == null) {
				        this.names = new java.util.ArrayList<String>();
				    }
				    return this.names;
				  }
				  
				  /**
				   * Adds the given names to this object. <p>
				   * 
				   * @param names
				   */
				  public void addToNames(final String names) {
				    // If names is null, we do not add it
				    if(names==null){
				        return;
				    }
				    
				    ensureNames();
				    
				    // Adds the parameter to the list
				    if(!this.names.contains(names)){
				        this.names.add(names);
				    }
				  }
				  
				  /**
				   * Removes the given names from this object.
				   * 
				   * @param names
				   */
				  public void removeFromNames(final String names) {
				    // If names or the names are null, we can leave
				    if(names==null || this.names==null){
				        return;
				    }
				    
				    this.names.remove(names);
				  }
				}
			''')
	}

	@Ignore("do we really need to support var-collections???")
	def void compare_Multiple_List_Property() {
		'''
			package my.test {
			    entity Library {
			        var List<String>[*] values
			    }
			}
		'''.assertCompilesTo(
			'''
				package my.test;
				
				import java.util.List;
				
				public class Library {
				  private List<List<String>> values;
				  
				  /**
				   * Returns an unmodifiable list of values.
				   * 
				   * @return values
				   */
				  public List<List<String>> getValues() {
				    return java.util.Collections.unmodifiableList(internalGetValues());
				  }
				  
				  /**
				   * Ensures that the list of values is created. It will be instantiated 
				   * lazy.
				   */
				  private List<List<String>> internalGetValues() {
				    if (this.values == null) {
				        this.values = new java.util.ArrayList<List<String>>();
				    }
				    return this.values;
				  }
				  
				  /**
				   * Adds the given values to this object. <p>
				   * 
				   * @param values
				   */
				  public void addToValues(final List<String> values) {
				    // If values is null, we do not add it
				    if(values==null){
				        return;
				    }
				    
				    ensureValues();
				    
				    // Adds the parameter to the list
				    if(!this.values.contains(values)){
				        this.values.add(values);
				    }
				  }
				  
				  /**
				   * Removes the given values from this object.
				   * 
				   * @param values
				   */
				  public void removeFromValues(final List<String> values) {
				    // If values or the values are null, we can leave
				    if(values==null || this.values==null){
				        return;
				    }
				    
				    this.values.remove(values);
				  }
				}
			''')
	}

	@Test
	def void compareReference_Single() {
		val Map<String, CharSequence> expected = new HashMap<String, CharSequence>();
		expected.put("my.test.Library",
			'''
				package my.test;
				
				import javax.persistence.Entity;
				import javax.persistence.FetchType;
				import javax.persistence.JoinColumn;
				import javax.persistence.ManyToOne;
				import my.test.Book;
				
				@Entity
				public class Library {
				  @ManyToOne(fetch = FetchType.LAZY)
				  @JoinColumn(name = "LAST_BORROWED_BOOK")
				  private Book lastBorrowedBook;
				  
				  /**
				   * Returns the lastBorrowedBook property or <code>null</code> if not present.
				   */
				  public Book getLastBorrowedBook() {
				    return this.lastBorrowedBook;
				  }
				  
				  /**
				   * Sets the lastBorrowedBook property to this instance.
				   */
				  public void setLastBorrowedBook(final Book lastBorrowedBook) {
				    this.lastBorrowedBook = lastBorrowedBook;
				  }
				}
			            ''');

		expected.put("my.test.Book",
			'''
				package my.test;
				
				import javax.persistence.Entity;
				
				@Entity
				public class Book {
				}
			''');

		expected.assertCompilesFrom('''
			package my.test {
			    entity Library {
			        refers Book lastBorrowedBook
			    }
			    
			    entity Book {
			    }
			}
		''')
	}

	@Test
	def void compareReference_Multi() {
		val Map<String, CharSequence> expected = new HashMap<String, CharSequence>();
		expected.put("my.test.Library",
			'''
				package my.test;
				
				import java.util.ArrayList;
				import java.util.List;
				import my.test.Book;
				
				public class Library {
				  private List<Book> allBorrowedBooks;
				  
				  /**
				   * Returns an unmodifiable list of allBorrowedBooks.
				   * 
				   * @return allBorrowedBooks
				   */
				  public List<Book> getAllBorrowedBooks() {
				    return java.util.Collections.unmodifiableList(internalGetAllBorrowedBooks());
				  }
				  
				  /**
				   * Returns the list of <code>Book</code>s thereby lazy initializing it.
				   */
				  private List<Book> internalGetAllBorrowedBooks() {
				    if (this.allBorrowedBooks == null) {
				      this.allBorrowedBooks = new ArrayList<Book>();
				    }
				    return this.allBorrowedBooks;
				  }
				  
				  /**
				   * Adds the given book to this object. <p>
				   * 
				   * @param book
				   */
				  public void addToAllBorrowedBooks(final Book book) {
				    // If book is null, we do not add it
				    if (book==null) {
				      return;
				    }
				    
				    internalGetAllBorrowedBooks();
				    
				    // Adds the parameter to the list
				    if (!this.allBorrowedBooks.contains(book)) {
				      this.allBorrowedBooks.add(book);
				    }
				  }
				  
				  /**
				   * Removes the given book from this object.
				   * 
				   * @param book
				   */
				  public void removeFromAllBorrowedBooks(final Book book) {
				    // If book or the allBorrowedBooks are null, we can leave
				    if (book==null || this.allBorrowedBooks==null) {
				      return;
				    }
				    
				    this.allBorrowedBooks.remove(book);
				  }
				  
				  void internalAddToAllBorrowedBooks(final Book book) {
				    internalGetAllBorrowedBooks().add(book);
				  }
				  
				  void internalRemoveFromAllBorrowedBooks(final Book book) {
				    internalGetAllBorrowedBooks().remove(book);
				  }
				}
			            ''');

		expected.put("my.test.Book",
			'''
				package my.test;
				
				public class Book {
				}
			''');

		expected.assertCompilesFrom('''
			package my.test {
			    entity Library {
			        refers Book[*] allBorrowedBooks
			    }
			    
			    entity Book {
			    }
			}
		''')
	}

	@Ignore("containment without opposite should be error")
	def void compareContains_Single_withContainer() {
		val Map<String, CharSequence> expected = new HashMap<String, CharSequence>();
		expected.put("my.test.Library",
			'''
				package my.test;
				
				import my.test.Book;
				
				public class Library {
				  private Book containedBook;
				  
				  /**
				   * Returns the containedBook reference or <code>null</code> if not present.
				   * 
				   * @return containedBook
				   */
				  public Book getContainedBook() {
				    return this.containedBook;
				  }
				  
				  /**
				   * Sets the containedBook reference to this instance.
				   * 
				   * ATTENTION:<br>
				   * The reference is a containment reference, but no opposite is available.
				   * So the opposite will NOT be handled. Therefore you have to ensure that the parent of the reference
				   * is set properly.
				   * 
				   * @param book
				   */
				  public void setContainedBook(final Book book) {
				    
				    Book oldContainedBook = this.containedBook;
				    
				    // if the parent does not change, we can leave
				    if (oldContainedBook == book) {
				        return;
				    }
				    
				    // Assign the new value
				    this.containedBook = book;
				    
				  }
				}
			            ''');

		expected.put("my/test/Book.java",
			'''
				package my.test;
				
				import my.test.Library;
				
				public class Book {
				  private Library library;
				  
				  /**
				   * Returns the library reference or <code>null</code> if not present.
				   * 
				   * @return library
				   */
				  public Library getLibrary() {
				    return this.library;
				  }
				  
				  /**
				   * Sets the library reference to this instance.
				   * 
				   * ATTENTION:<br>
				   * The reference is a container reference, but no opposite is available.
				   * So the opposite will NOT be handled. Therefore you have to ensure that the parent of the reference
				   * is set properly.
				   * 
				   * @param library
				   */
				  public void setLibrary(final Library library) {
				    
				    Library oldLibrary = this.library;
				    
				    // if the parent does not change, we can leave
				    if (oldLibrary == library) {
				        return;
				    }
				    
				    // Assign the new value
				    this.library = library;
				    
				  }
				}
			            ''');

		expected.assertCompilesFrom('''
			package my.test {
			    entity Library {
			        contains Book containedBook
			    }
			    
			    entity Book {
			        container Library library
			    }
			}
		''')
	}

	@Test
	def void compareContains_Single_withContainerAndOpposite() {
		val Map<String, CharSequence> expected = new HashMap<String, CharSequence>();
		expected.put("my.test.Library",
			'''
				package my.test;
				
				import my.test.Book;
				
				public class Library {
				  private Book containedBook;
				  
				  /**
				   * Returns the containedBook reference or <code>null</code> if not present.
				   * 
				   * @return containedBook
				   */
				  public Book getContainedBook() {
				    return this.containedBook;
				  }
				  
				  /**
				   * Sets the containedBook reference to this instance.
				   * 
				   * Since the reference is a containment reference, the opposite reference (Book.library) 
				   * of the book will be handled automatically and no further coding is required to keep them in sync. 
				   * See {@link Book#setLibrary(Book)}.
				   * 
				   * @param book
				   */
				  public void setContainedBook(final Book book) {
				    if (this.containedBook != null) {
				        this.containedBook.setLibrary(null);
				    }
				    this.containedBook = book;
				    if (this.containedBook != null) {
				        this.containedBook.setLibrary(this);
				    }
				    
				  }
				  
				  void internalSetContainedBook(final Book book) {
				    this.containedBook = book;
				  }
				}
			''');

		expected.put("my/test/Book.java",
			'''
				package my.test;
				
				import my.test.Library;
				
				public class Book {
				  private Library library;
				  
				  /**
				   * Returns the library reference or <code>null</code> if not present.
				   * 
				   * @return library
				   */
				  public Library getLibrary() {
				    return this.library;
				  }
				  
				  /**
				   * Sets the library reference to this instance.
				   * 
				   * Since the reference is a container reference, the opposite reference (Library.containedBook) 
				   * of the library will be handled automatically and no further coding is required to keep them in sync. 
				   * See {@link Library#setContainedBook(Library)}.
				   * 
				   * @param library
				   */
				  public void setLibrary(final Library library) {
				    if (this.library != null) {
				      this.library.internalSetContainedBook(null);
				    }
				    this.library = library;
				    if (this.library != null) {
				      this.library.internalSetContainedBook(this);
				    }
				    
				  }
				}
			''');

		expected.assertCompilesFrom('''
			package my.test {
			    entity Library {
			        contains Book containedBook opposite library
			    }
			    
			    entity Book {
			        container Library library opposite containedBook
			    }
			}
		''')
	}

	@Ignore("containment without opposite should be error")
	def void compareContains_Multiple_withContainer() {
		val Map<String, CharSequence> expected = new HashMap<String, CharSequence>();
		expected.put("my.test.Library",
			'''
				package my.test;
				
				import java.util.List;
				import my.test.Book;
				
				public class Library {
				  private List<Book> containedBooks;
				  
				  /**
				   * Returns an unmodifiable list of containedBooks.
				   * 
				   * @return containedBooks
				   */
				  public List<Book> getContainedBooks() {
				    ensureContainedBooks();
				    return java.util.Collections.unmodifiableList(this.containedBooks);
				  }
				  
				  /**
				   * Adds the given book to this object. <p>
				   * ATTENTION:<br>
				   * The reference is a containment reference, but no opposite is available.
				   * So the opposite will NOT be handled. Therefore you have to ensure that the parent of the reference
				   * is set properly.
				   * 
				   * @param book
				   */
				  public void addContainedBooks(final Book book) {
				    
				    // If book is null, we do not add it
				    if(book==null){
				        return;
				    }
				    
				    ensureContainedBooks();
				    
				    // Adds the parameter to the list
				    if(!this.containedBooks.contains(book)){
				        this.containedBooks.add(book);
				    }
				    
				  }
				  
				  /**
				   * Removes the given book from this object. <p>
				   * ATTENTION:<br>
				   * The reference is a containment reference, but no opposite is available.
				   * So the opposite will NOT be handled. Therefore you have to ensure that the parent of the reference
				   * is set properly.
				   * 
				   * @param book
				   */
				  public void removeContainedBooks(final Book book) {
				    // If the parameter or the field are null, we can leave
				    if (book == null || this.containedBooks == null) {
				        return;
				    }
				    
				    // if the book is not contained, then we can leave
				    if (!this.containedBooks.contains(book)) {
				        return;
				    }
				    
				    // Removes the parameter from the field
				    this.containedBooks.remove(book);
				    
				  }
				  
				  /**
				   * Ensures that the list of containedBooks is created. It will be instantiated 
				   * lazy.
				   */
				  private void ensureContainedBooks() {
				    if (this.containedBooks == null) {
				        this.containedBooks = new java.util.ArrayList<Book>();
				    }
				  }
				}
			            ''');

		expected.put("my/test/Book.java",
			'''
				package my.test;
				
				import my.test.Library;
				
				public class Book {
				  private Library library;
				  
				  /**
				   * Returns the library reference or <code>null</code> if not present.
				   * 
				   * @return library
				   */
				  public Library getLibrary() {
				    return this.library;
				  }
				  
				  /**
				   * Sets the library reference to this instance.
				   * 
				   * ATTENTION:<br>
				   * The reference is a container reference, but no opposite is available.
				   * So the opposite will NOT be handled. Therefore you have to ensure that the parent of the reference
				   * is set properly.
				   * 
				   * @param library
				   */
				  public void setLibrary(final Library library) {
				    
				    Library oldLibrary = this.library;
				    
				    // if the parent does not change, we can leave
				    if (oldLibrary == library) {
				        return;
				    }
				    
				    // Assign the new value
				    this.library = library;
				    
				  }
				}
			''');

		expected.assertCompilesFrom('''
			package my.test {
			    entity Library {
			        contains Book[*] containedBooks
			    }
			    
			    entity Book {
			        container Library library
			    }
			}
		''')
	}

	@Test
	def void compareContains_Multiple_withContainerAndOpposite() {
		val Map<String, CharSequence> expected = new HashMap<String, CharSequence>();
		expected.put("my.test.Library",
			'''
				package my.test;
				
				import java.util.ArrayList;
				import java.util.List;
				import my.test.Book;
				
				public class Library {
				  private List<Book> containedBooks;
				  
				  /**
				   * Returns an unmodifiable list of containedBooks.
				   * 
				   * @return containedBooks
				   */
				  public List<Book> getContainedBooks() {
				    return java.util.Collections.unmodifiableList(internalGetContainedBooks());
				  }
				  
				  /**
				   * Returns the list of <code>Book</code>s thereby lazy initializing it.
				   */
				  private List<Book> internalGetContainedBooks() {
				    if (this.containedBooks == null) {
				      this.containedBooks = new ArrayList<Book>();
				    }
				    return this.containedBooks;
				  }
				  
				  /**
				   * Adds the given book to this object. <p>
				   * Since the reference is a containment reference, the opposite reference (Book.library) 
				   * of the book will be handled automatically and no further coding is required to keep them in sync. 
				   * See {@link Book#setLibrary(Book)}.
				   * 
				   * @param book
				   */
				  public void addToContainedBooks(final Book book) {
				    book.setLibrary(this);
				    
				  }
				  
				  /**
				   * Removes the given book from this object. <p>
				   * Since the reference is a containment reference, the opposite reference (Book.library) 
				   * of the book will be handled automatically and no further coding is required to keep them in sync. 
				   * See {@link Book#setLibrary(Book)}.
				   * 
				   * @param book
				   */
				  public void removeFromContainedBooks(final Book book) {
				    book.setLibrary(null);
				    
				  }
				  
				  void internalAddToContainedBooks(final Book book) {
				    internalGetContainedBooks().add(book);
				  }
				  
				  void internalRemoveFromContainedBooks(final Book book) {
				    internalGetContainedBooks().remove(book);
				  }
				}
			''');

		expected.put("my/test/Book.java",
			'''
				package my.test;
				
				import my.test.Library;
				
				public class Book {
				  private Library library;
				  
				  /**
				   * Returns the library reference or <code>null</code> if not present.
				   * 
				   * @return library
				   */
				  public Library getLibrary() {
				    return this.library;
				  }
				  
				  /**
				   * Sets the library reference to this instance.
				   * 
				   * Since the reference is a container reference, the opposite reference (Library.containedBooks) 
				   * of the library will be handled automatically and no further coding is required to keep them in sync. 
				   * See {@link Library#setContainedBooks(Library)}.
				   * 
				   * @param library
				   */
				  public void setLibrary(final Library library) {
				    if (this.library != null) {
				      this.library.internalRemoveFromContainedBooks(this);
				    }
				    this.library = library;
				    if (this.library != null) {
				      this.library.internalAddToContainedBooks(this);
				    }
				    
				  }
				}
			''');

		expected.assertCompilesFrom('''
			package my.test {
			    entity Library {
			        contains Book[*] containedBooks opposite library
			    }
			    
			    entity Book {
			        container Library library opposite containedBooks
			    }
			}
		''')
	}

	@Ignore("embedds will be desupported")
	def void compareEmbedds() {
		val Map<String, CharSequence> expected = new HashMap<String, CharSequence>();
		expected.put("my.test.Library",
			'''
				package my.test;
				
				import java.util.List;
				import my.test.Address;
				
				public class Library {
				  private String address_street;
				  
				  private Address address_otherAddress;
				  
				  private List<Address> address_moreAddresses;
				  
				  /**
				   * Returns the address_street property or <code>null</code> if not present.
				   * 
				   * @return address_street
				   */
				  public String getAddress_street() {
				    return this.address_street;
				  }
				  
				  /**
				   * Sets the street property to this instance.
				   * 
				   * @param street
				   */
				  public void setAddress_street(final String street) {
				    this.address_street = street;
				  }
				  
				  /**
				   * Returns the address_otherAddress reference or <code>null</code> if not present.
				   * 
				   * @return address_otherAddress
				   */
				  public Address getAddress_otherAddress() {
				    return this.address_otherAddress;
				  }
				  
				  /**
				   * Sets the address reference to this instance.
				   * 
				   * @param address
				   */
				  public void setAddress_otherAddress(final Address address) {
				    this.address_otherAddress = address;
				  }
				  
				  /**
				   * Returns an unmodifiable list of address_moreAddresses.
				   * 
				   * @return address_moreAddresses
				   */
				  public List<Address> getAddress_moreAddresses() {
				    ensureAddress_moreAddresses();
				    return java.util.Collections.unmodifiableList(this.address_moreAddresses);
				  }
				  
				  /**
				   * Adds the given address to this object. <p>
				   * 
				   * @param address
				   */
				  public void addAddress_moreAddresses(final Address address) {
				    // If address is null, we do not add it
				    if(address==null){
				        return;
				    }
				    
				    ensureAddress_moreAddresses();
				    
				    // Adds the parameter to the list
				    if(!this.address_moreAddresses.contains(address)){
				        this.address_moreAddresses.add(address);
				    }
				  }
				  
				  /**
				   * Removes the given address from this object.
				   * 
				   * @param address
				   */
				  public void removeAddress_moreAddresses(final Address address) {
				    // If address or the address_moreAddresses are null, we can leave
				    if(address==null || this.address_moreAddresses==null){
				        return;
				    }
				    
				    this.address_moreAddresses.remove(address);
				  }
				  
				  /**
				   * Ensures that the list of moreAddresses is created. It will be instantiated 
				   * lazy.
				   */
				  private void ensureAddress_moreAddresses() {
				    if (this.address_moreAddresses == null) {
				        this.address_moreAddresses = new java.util.ArrayList<Address>();
				    }
				  }
				}
			''');

		expected.put("my.test.Address",
			'''
				package my.test;
				
				import java.util.List;
				
				public class Address {
				  private String street;
				  
				  private Address otherAddress;
				  
				  private List<Address> moreAddresses;
				  
				  /**
				   * Returns the street property or <code>null</code> if not present.
				   * 
				   * @return street
				   */
				  public String getStreet() {
				    return this.street;
				  }
				  
				  /**
				   * Sets the street property to this instance.
				   * 
				   * @param street
				   */
				  public void setStreet(final String street) {
				    this.street = street;
				  }
				  
				  /**
				   * Returns the otherAddress reference or <code>null</code> if not present.
				   * 
				   * @return otherAddress
				   */
				  public Address getOtherAddress() {
				    return this.otherAddress;
				  }
				  
				  /**
				   * Sets the address reference to this instance.
				   * 
				   * @param address
				   */
				  public void setOtherAddress(final Address address) {
				    this.otherAddress = address;
				  }
				  
				  /**
				   * Returns an unmodifiable list of moreAddresses.
				   * 
				   * @return moreAddresses
				   */
				  public List<Address> getMoreAddresses() {
				    ensureMoreAddresses();
				    return java.util.Collections.unmodifiableList(this.moreAddresses);
				  }
				  
				  /**
				   * Adds the given address to this object. <p>
				   * 
				   * @param address
				   */
				  public void addMoreAddresses(final Address address) {
				    // If address is null, we do not add it
				    if(address==null){
				        return;
				    }
				    
				    ensureMoreAddresses();
				    
				    // Adds the parameter to the list
				    if(!this.moreAddresses.contains(address)){
				        this.moreAddresses.add(address);
				    }
				  }
				  
				  /**
				   * Removes the given address from this object.
				   * 
				   * @param address
				   */
				  public void removeMoreAddresses(final Address address) {
				    // If address or the moreAddresses are null, we can leave
				    if(address==null || this.moreAddresses==null){
				        return;
				    }
				    
				    this.moreAddresses.remove(address);
				  }
				  
				  /**
				   * Ensures that the list of moreAddresses is created. It will be instantiated 
				   * lazy.
				   */
				  private void ensureMoreAddresses() {
				    if (this.moreAddresses == null) {
				        this.moreAddresses = new java.util.ArrayList<Address>();
				    }
				  }
				}
			            ''');

		expected.assertCompilesFrom('''
			package my.test {
			    entity Library {
			        embedds Address address
			    }
			    
			    entity Address {
			        var String street
			        refers Address otherAddress
			        refers Address[*] moreAddresses
			    }
			}
		''')
	}

	@Ignore("too many test cases in one test")
	def void compareSingluarName() {
		val Map<String, CharSequence> expected = new HashMap<String, CharSequence>();
		expected.put("org.lunifera.demo.Library",
			'''
				package org.lunifera.demo;
				
				import java.util.List;
				import org.lunifera.demo.Book;
				
				/**
				 * Test 112233
				 */
				public class Library {
				  private String name;
				  
				  private List<String> manyNames;
				  
				  private List<List<String>> manymanyNames;
				  
				  private boolean settingSimpleContains;
				  
				  private Book simpleContains;
				  
				  private boolean settingBooks;
				  
				  private List<Book> books;
				  
				  private Book lastLendedBook;
				  
				  private List<Book> allLendedBooks;
				  
				  /**
				   * Returns the name property or <code>null</code> if not present.
				   * 
				   * @return name
				   */
				  public String getName() {
				    return this.name;
				  }
				  
				  /**
				   * Sets the name property to this instance.
				   * 
				   * @param name
				   */
				  public void setName(final String name) {
				    this.name = name;
				  }
				  
				  /**
				   * Returns an unmodifiable list of manyNames.
				   * 
				   * @return manyNames
				   */
				  public List<String> getManyNames() {
				    ensureManyNames();
				    return java.util.Collections.unmodifiableList(this.manyNames);
				  }
				  
				  /**
				   * Adds the given name to this object. <p>
				   * 
				   * @param name
				   */
				  public void addManyNames(final String name) {
				    // If name is null, we do not add it
				    if(name==null){
				        return;
				    }
				    
				    ensureManyNames();
				    
				    // Adds the parameter to the list
				    if(!this.manyNames.contains(name)){
				        this.manyNames.add(name);
				    }
				  }
				  
				  /**
				   * Removes the given name from this object.
				   * 
				   * @param name
				   */
				  public void removeManyNames(final String name) {
				    // If name or the manyNames are null, we can leave
				    if(name==null || this.manyNames==null){
				        return;
				    }
				    
				    this.manyNames.remove(name);
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
				    ensureManymanyNames();
				    return java.util.Collections.unmodifiableList(this.manymanyNames);
				  }
				  
				  /**
				   * Adds the given name to this object. <p>
				   * 
				   * @param name
				   */
				  public void addManymanyNames(final List<String> name) {
				    // If name is null, we do not add it
				    if(name==null){
				        return;
				    }
				    
				    ensureManymanyNames();
				    
				    // Adds the parameter to the list
				    if(!this.manymanyNames.contains(name)){
				        this.manymanyNames.add(name);
				    }
				  }
				  
				  /**
				   * Removes the given name from this object.
				   * 
				   * @param name
				   */
				  public void removeManymanyNames(final List<String> name) {
				    // If name or the manymanyNames are null, we can leave
				    if(name==null || this.manymanyNames==null){
				        return;
				    }
				    
				    this.manymanyNames.remove(name);
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
				   * Returns the simpleContains reference or <code>null</code> if not present.
				   * 
				   * @return simpleContains
				   */
				  public Book getSimpleContains() {
				    return this.simpleContains;
				  }
				  
				  /**
				   * Sets the simpleContains reference to this instance.
				   * 
				   * Since the reference is a containment reference, the opposite reference (Book.library) 
				   * of the book will be handled automatically and no further coding is required to keep them in sync. 
				   * See {@link Book#setLibrary(Book)}.
				   * 
				   * @param book
				   */
				  public void setSimpleContains(final Book book) {
				    if (settingSimpleContains) {
				        // avoid loops
				        return;
				    }
				    
				    Book oldSimpleContains = this.simpleContains;
				    
				    // if the parent does not change, we can leave
				    if (oldSimpleContains == book) {
				        return;
				    }
				    
				    try {
				        // avoid loops
				        settingSimpleContains = true;
				    
				        // First remove the element
				        if (oldSimpleContains != null) {
				            oldSimpleContains.setLibrary(null);
				        }
				        
				        // Then assign the new value
				        this.simpleContains = book;
				        
				        // Then add 'this' to the new value
				        if (this.simpleContains != null) {
				            this.simpleContains.setLibrary(this);
				        }
				    } finally {
				        settingSimpleContains = false;
				    }
				    
				  }
				  
				  /**
				   * Returns an unmodifiable list of books.
				   * 
				   * @return books
				   */
				  public List<Book> getBooks() {
				    ensureBooks();
				    return java.util.Collections.unmodifiableList(this.books);
				  }
				  
				  /**
				   * Adds the given aBookOfLibrary to this object. <p>
				   * Since the reference is a containment reference, the opposite reference (Book.library) 
				   * of the aBookOfLibrary will be handled automatically and no further coding is required to keep them in sync. 
				   * See {@link Book#setLibrary(Book)}.
				   * 
				   * @param aBookOfLibrary
				   */
				  public void addBooks(final Book aBookOfLibrary) {
				    if (settingBooks) {
				        // avoid loops
				        return;
				    }
				    
				    // If aBookOfLibrary is null, we do not add it
				    if(aBookOfLibrary==null){
				        return;
				    }
				    
				    try{
				        settingBooks = true;
				    
				        ensureBooks();
				    
				        // Adds the parameter to the list
				        if(!this.books.contains(aBookOfLibrary)){
				            this.books.add(aBookOfLibrary);
				    
				            // Set 'this' as the parent of the containment reference to the aBookOfLibrary
				            aBookOfLibrary.setLibrary(this);
				    }
				    } finally {
				        settingBooks = false;
				    }
				    
				  }
				  
				  /**
				   * Removes the given aBookOfLibrary from this object. <p>
				   * Since the reference is a containment reference, the opposite reference (Book.library) 
				   * of the aBookOfLibrary will be handled automatically and no further coding is required to keep them in sync. 
				   * See {@link Book#setLibrary(Book)}.
				   * 
				   * @param aBookOfLibrary
				   */
				  public void removeBooks(final Book aBookOfLibrary) {
				    // If the parameter or the field are null, we can leave
				    if (aBookOfLibrary == null || this.books == null) {
				        return;
				    }
				    
				    // if the aBookOfLibrary is not contained, then we can leave
				    if (!this.books.contains(aBookOfLibrary)) {
				        return;
				    }
				    
				    // Removes the parameter from the field
				    this.books.remove(aBookOfLibrary);
				    // Unset the parent of the containment reference from the aBookOfLibrary
				    aBookOfLibrary.setLibrary(null);
				    
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
				  
				  /**
				   * Returns the lastLendedBook reference or <code>null</code> if not present.
				   * 
				   * @return lastLendedBook
				   */
				  public Book getLastLendedBook() {
				    return this.lastLendedBook;
				  }
				  
				  /**
				   * Sets the book reference to this instance.
				   * 
				   * @param book
				   */
				  public void setLastLendedBook(final Book book) {
				    this.lastLendedBook = book;
				  }
				  
				  /**
				   * Returns an unmodifiable list of allLendedBooks.
				   * 
				   * @return allLendedBooks
				   */
				  public List<Book> getAllLendedBooks() {
				    ensureAllLendedBooks();
				    return java.util.Collections.unmodifiableList(this.allLendedBooks);
				  }
				  
				  /**
				   * Adds the given aLendedBook to this object. <p>
				   * 
				   * @param aLendedBook
				   */
				  public void addAllLendedBooks(final Book aLendedBook) {
				    // If aLendedBook is null, we do not add it
				    if(aLendedBook==null){
				        return;
				    }
				    
				    ensureAllLendedBooks();
				    
				    // Adds the parameter to the list
				    if(!this.allLendedBooks.contains(aLendedBook)){
				        this.allLendedBooks.add(aLendedBook);
				    }
				  }
				  
				  /**
				   * Removes the given aLendedBook from this object.
				   * 
				   * @param aLendedBook
				   */
				  public void removeAllLendedBooks(final Book aLendedBook) {
				    // If aLendedBook or the allLendedBooks are null, we can leave
				    if(aLendedBook==null || this.allLendedBooks==null){
				        return;
				    }
				    
				    this.allLendedBooks.remove(aLendedBook);
				  }
				  
				  /**
				   * Ensures that the list of allLendedBooks is created. It will be instantiated 
				   * lazy.
				   */
				  private void ensureAllLendedBooks() {
				    if (this.allLendedBooks == null) {
				        this.allLendedBooks = new java.util.ArrayList<Book>();
				    }
				  }
				}
			            ''');

		expected.put("org.lunifera.demo.Book",
			'''
				package org.lunifera.demo;
				
				import org.lunifera.demo.Library;
				
				public class Book {
				  private String name;
				  
				  private boolean settingLibrary;
				  
				  private Library library;
				  
				  /**
				   * Returns the name property or <code>null</code> if not present.
				   * 
				   * @return name
				   */
				  public String getName() {
				    return this.name;
				  }
				  
				  /**
				   * Sets the name property to this instance.
				   * 
				   * @param name
				   */
				  public void setName(final String name) {
				    this.name = name;
				  }
				  
				  /**
				   * Returns the library reference or <code>null</code> if not present.
				   * 
				   * @return library
				   */
				  public Library getLibrary() {
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
			            ''');

		expected.assertCompilesFrom('''
			package org.lunifera.demo {
			    /**
			     * Test 112233
			     */
			    entity Library {
			        // properties       
			        var String name
			        var String[*] manyNames(name)
			        var List<String>[*] manymanyNames(name)
			    
			        // contains 0:1 and 0:n
			        contains Book simpleContains opposite library
			        contains Book[*] books(aBookOfLibrary) opposite library
			        // simple references
			        refers Book lastLendedBook
			        refers Book[*] allLendedBooks(aLendedBook)
			    }
			    
			    entity Book {
			        var String name
			        container Library library opposite books
			    }
			}
		''')
	}
}

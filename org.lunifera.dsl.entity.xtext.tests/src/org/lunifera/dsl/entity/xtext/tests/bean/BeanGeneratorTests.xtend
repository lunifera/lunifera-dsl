/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Sources based on {@link org.eclipse.xtext.xbase.compiler.CompilationTestHelper}
 * 
 * Contributors:
 *      Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.tests.bean

import com.google.inject.Inject
import java.util.HashMap
import java.util.Map
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.lunifera.dsl.entity.xtext.EntityGrammarInjectorProvider
import org.lunifera.dsl.entity.xtext.tests.MultiFilesCompilationTestHelper

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(EntityGrammarInjectorProvider))
class BeanGeneratorTest {

	@Inject extension MultiFilesCompilationTestHelper

	@Test
	def void compareEmptyBeanType() {
		'''
			package my.test {
			    /*
			     * Kept comment.
			     */
			    bean Library {
			    }
			}
		'''.assertCompilesTo(
			'''
				package my.test;
				
				import javax.persistence.Embeddable;

				/**
				 * Kept comment.
				 */
				@Embeddable
				public class Library {
				}
			''')
	}

	@Test
	def void compareExcludedAnnotation() {
		'''
			package my.test {
			    import javax.persistence.*
			    
			    exclude @Embeddable
			    @Override
			    bean Library {
			    }
			}
		'''.assertCompilesTo(
			'''
				package my.test;
				
				@Override
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
	def void compare_Single_Property() {
		''' «defaultDatatypes»
            package my.test {
                import org.lunifera.platformDataTypes.*
                
                datatype String jvmType java.lang.String
                
                bean Library {
                    var String name
                }
            }
        '''.
			assertCompilesTo(
				'''
					package my.test;

					import javax.persistence.Embeddable;
					
					@Embeddable
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
	def void compare_Single_TransientProperty() {
		''' «defaultDatatypes»
            package my.test {
                import java.math.*
                bean Library {
                    transient BigDecimal amount
                }
            }
        '''.
			assertCompilesTo(
				'''
					package my.test;

					import java.math.BigDecimal;
					import javax.persistence.Embeddable;
					
					@Embeddable
					public class Library {
					  private BigDecimal amount;
					  
					  /**
					   * Returns the amount property or <code>null</code> if not present.
					   */
					  public BigDecimal getAmount() {
					    return this.amount;
					  }
					  
					  /**
					   * Sets the amount property to this instance.
					   */
					  public void setAmount(final BigDecimal amount) {
					    this.amount = amount;
					  }
					}
				''')
	}

	@Test
	def void compare_Single_NotnullProperty() {
		''' «defaultDatatypes»
            package my.test {
                import org.lunifera.platformDataTypes.*
                
                datatype String jvmType java.lang.String
                
                bean Library {
                    var String name notnull
                }
            }
        '''.
			assertCompilesTo(
				'''
					package my.test;

					import javax.persistence.Embeddable;
					
					@Embeddable
					public class Library {
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

		'''
			package my.test {
				entity Book {
			    }
			    entity Library {
			        refers Book lastBorrowedBook
			    }
			    
			}
		'''.assertCompilesToMultiple(expected)
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

		'''
			package my.test {
				entity Book {
			    }
			    entity Library {
			        refers Book lastBorrowedBook
			    }
			}
		'''.assertCompilesToMultiple(expected)
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

		expected.put("my.test.Book",
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

		'''
			package my.test {
			    entity Library {
			        contains Book containedBook opposite library
			    }
			    
			    entity Book {
			        container Library library opposite containedBook
			    }
			}
		'''.assertCompilesToMultiple(expected)
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

		expected.put("my.test.Book",
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

		'''
			package my.test {
			    entity Library {
			        contains Book[*] containedBooks opposite library
			    }
			    
			    entity Book {
			        container Library library opposite containedBooks
			    }
			}
		'''.assertCompilesToMultiple(expected)
	}

}

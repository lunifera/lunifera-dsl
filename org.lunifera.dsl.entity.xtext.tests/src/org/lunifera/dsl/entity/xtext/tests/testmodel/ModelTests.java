/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.tests.testmodel;

import junit.framework.Assert;

import org.junit.Test;
import org.lunifera.dsl.entity.xtext.tests.testmodel.model.Book;
import org.lunifera.dsl.entity.xtext.tests.testmodel.model.BookIndex;
import org.lunifera.dsl.entity.xtext.tests.testmodel.model.Country;
import org.lunifera.dsl.entity.xtext.tests.testmodel.model.ExtendedLibrary;
import org.lunifera.dsl.entity.xtext.tests.testmodel.model.Library;
import org.lunifera.dsl.entity.xtext.tests.testmodel.model.PostBox;
import org.lunifera.dsl.entity.xtext.tests.testmodel.model.Province;
import org.lunifera.dsl.entity.xtext.tests.testmodel.model.SomeEnum;

public class ModelTests {

	/**
	 * Tests the 0:*-containment reference.<br>
	 * Using the add / remove methods of containment references have to add the
	 * reference to the object, but also has to ensure, that the reference to
	 * the parent of the added element is set properly.<br>
	 * In that test case changing the parent of the containment reference is
	 * ignored. See {@link #test_containmentMany_move()} to handle changed
	 * parents.
	 */
	@Test
	public void test_containmentMany_add_remove() {
		Library lib = new Library();

		Book book1 = new Book();
		Book book2 = new Book();
		Assert.assertNull(book1.getLibrary());
		Assert.assertNull(book2.getLibrary());

		// add books
		lib.addBooks(book1);
		Assert.assertNotNull(book1.getLibrary());
		Assert.assertTrue(lib.getBooks().contains(book1));
		Assert.assertFalse(lib.getBooks().contains(book2));

		lib.addBooks(book2);
		Assert.assertNotNull(book2.getLibrary());
		Assert.assertTrue(lib.getBooks().contains(book1));
		Assert.assertTrue(lib.getBooks().contains(book2));

		// remove books
		lib.removeBooks(book1);
		Assert.assertNull(book1.getLibrary());
		Assert.assertFalse(lib.getBooks().contains(book1));
		Assert.assertTrue(lib.getBooks().contains(book2));

		lib.removeBooks(book2);
		Assert.assertNull(book1.getLibrary());
		Assert.assertFalse(lib.getBooks().contains(book1));
		Assert.assertFalse(lib.getBooks().contains(book2));
	}

	/**
	 * Tests the 0:*-containment reference.<br>
	 * Using the add / remove methods of containment references have to add the
	 * reference to the object, but also has to ensure, that the reference to
	 * the parent of the added element is set properly.
	 */
	@Test
	public void test_containmentMany_move() {
		//
		// lib1
		//
		Library lib1 = new Library();
		lib1.setName("lib1");
		Book book11 = new Book();
		book11.setName("book11");
		Book book12 = new Book();
		book12.setName("book12");

		// add books
		lib1.addBooks(book11);
		lib1.addBooks(book12);

		//
		// lib2
		//
		Library lib2 = new Library();
		lib2.setName("lib2");
		Book book21 = new Book();
		book21.setName("book21");
		Book book22 = new Book();
		book22.setName("book22");

		// add books
		lib2.addBooks(book21);
		lib2.addBooks(book22);

		//
		// move a book from lib1 to lib2
		//
		lib2.addBooks(book11);
		// parent did change
		Assert.assertSame(lib2, book11.getLibrary());
		Assert.assertFalse(lib1.getBooks().contains(book11));
		Assert.assertTrue(lib2.getBooks().contains(book11));

		// move it back
		lib1.addBooks(book11);
		// parent did change
		Assert.assertSame(lib1, book11.getLibrary());
		Assert.assertTrue(lib1.getBooks().contains(book11));
		Assert.assertFalse(lib2.getBooks().contains(book11));
	}

	/**
	 * Thats that elements are only added once to a list.
	 */
	@Test
	public void test_containmentMany__addDuplicate() {
		Library lib = new Library();
		Book book = new Book();
		Assert.assertTrue(lib.getBooks().size() == 0);

		lib.addBooks(book);
		Assert.assertTrue(lib.getBooks().size() == 1);

		lib.addBooks(book);
		Assert.assertTrue(lib.getBooks().size() == 1);

		lib.removeBooks(book);
		Assert.assertTrue(lib.getBooks().size() == 0);

		lib.removeBooks(book);
		Assert.assertTrue(lib.getBooks().size() == 0);
	}

	/**
	 * Tests the 0:*-container reference.<br>
	 * Using the setter of a container references has to add the reference to
	 * the object, but also has to ensure, that the reference to the parent of
	 * the added element is set properly.
	 */
	@Test
	public void test_containerMany_setLibrary() {
		//
		// lib1
		//
		Library lib1 = new Library();
		Book book11 = new Book();
		Book book12 = new Book();

		// set the library
		book11.setLibrary(lib1);
		Assert.assertSame(book11.getLibrary(), lib1);
		Assert.assertTrue(lib1.getBooks().contains(book11));
		Assert.assertFalse(lib1.getBooks().contains(book12));

		book12.setLibrary(lib1);
		Assert.assertSame(book12.getLibrary(), lib1);
		Assert.assertTrue(lib1.getBooks().contains(book11));
		Assert.assertTrue(lib1.getBooks().contains(book12));

		//
		// lib2
		//
		Library lib2 = new Library();
		Book book21 = new Book();
		// add book
		lib2.addBooks(book21);

		//
		// move a book from lib2 to lib1
		//
		book21.setLibrary(lib1);
		// parent did change
		Assert.assertSame(book21.getLibrary(), lib1);
		Assert.assertTrue(lib1.getBooks().contains(book21));
		Assert.assertFalse(lib2.getBooks().contains(book21));

		// move it back
		book21.setLibrary(lib2);
		// parent did change
		Assert.assertSame(book21.getLibrary(), lib2);
		Assert.assertFalse(lib1.getBooks().contains(book21));
		Assert.assertTrue(lib2.getBooks().contains(book21));
	}

	/**
	 * Tests the 0:1-containment reference.<br>
	 * Using the set method of containment reference has to set the reference to
	 * the object, but also has to ensure, that the reference to the parent of
	 * the set element is also set properly.<br>
	 * In that test case changing the parent of the containment reference is
	 * ignored. See {@link #test_containmentSingle_move()} to handle changed
	 * parents.
	 */
	@Test
	public void test_containmentSingle_set_unset() {
		Library lib = new Library();
		lib.setName("lib");

		BookIndex bookIndex1 = new BookIndex();
		bookIndex1.setName("bookIndex1");
		BookIndex bookIndex2 = new BookIndex();
		bookIndex2.setName("bookIndex2");
		Assert.assertNull(bookIndex1.getLibrary());
		Assert.assertNull(bookIndex2.getLibrary());

		// set index
		lib.setIndex(bookIndex1);
		Assert.assertSame(lib, bookIndex1.getLibrary());
		Assert.assertSame(bookIndex1, lib.getIndex());
		Assert.assertNull(bookIndex2.getLibrary());

		lib.setIndex(bookIndex2);
		Assert.assertSame(lib, bookIndex2.getLibrary());
		Assert.assertSame(bookIndex2, lib.getIndex());
		Assert.assertNull(bookIndex1.getLibrary());

		lib.setIndex(null);
		Assert.assertNull(bookIndex2.getLibrary());
		Assert.assertNull(lib.getIndex());
	}

	/**
	 * Tests the 0:1-containment reference.<br>
	 * Using the set method of containment reference has to set the reference to
	 * the object, but also has to ensure, that the reference to the parent of
	 * the set element is also set properly.
	 */
	@Test
	public void test_containmentSingle_move() {
		Library lib = new Library();
		Library otherLib = new Library();

		BookIndex bookIndex = new BookIndex();

		// set index
		lib.setIndex(bookIndex);
		Assert.assertSame(lib, bookIndex.getLibrary());
		Assert.assertSame(bookIndex, lib.getIndex());
		Assert.assertNull(otherLib.getIndex());

		// set index to otherLib
		otherLib.setIndex(bookIndex);
		Assert.assertSame(otherLib, bookIndex.getLibrary());
		Assert.assertSame(bookIndex, otherLib.getIndex());
		Assert.assertNull(lib.getIndex());
	}

	/**
	 * Tests the 0:1-container reference.<br>
	 * Using the setter of a container references has to add the reference to
	 * the object, but also has to ensure, that the reference to the parent of
	 * the set element is also set properly.
	 */
	@Test
	public void test_containerSingle_setLibrary() {
		Library lib = new Library();
		Library otherLib = new Library();

		BookIndex bookIndex = new BookIndex();

		// sets the lib to the index
		bookIndex.setLibrary(lib);
		Assert.assertSame(lib, bookIndex.getLibrary());
		Assert.assertSame(bookIndex, lib.getIndex());
		Assert.assertNull(otherLib.getIndex());

		// sets the otherLib to the index
		bookIndex.setLibrary(otherLib);
		Assert.assertSame(otherLib, bookIndex.getLibrary());
		Assert.assertSame(bookIndex, otherLib.getIndex());
		Assert.assertNull(lib.getIndex());

		// sets null as library to the index
		bookIndex.setLibrary(null);
		Assert.assertNull(lib.getIndex());
		Assert.assertNull(otherLib.getIndex());
		Assert.assertNull(bookIndex.getLibrary());
	}

	/**
	 * Tests a 0:1 relation.
	 */
	@Test
	public void test_referenceSingle() {
		ExtendedLibrary lib = new ExtendedLibrary();
		ExtendedLibrary lib2 = new ExtendedLibrary();

		Book book1 = new Book();
		Book book2 = new Book();

		lib.addBooks(book1);
		lib.addBooks(book2);

		Assert.assertNull(lib.getLastLendedBook());

		lib.setLastLendedBook(book1);
		Assert.assertSame(book1, lib.getLastLendedBook());
		Assert.assertNull(lib2.getLastLendedBook());

		lib2.setLastLendedBook(book1);
		Assert.assertSame(book1, lib.getLastLendedBook());
		Assert.assertSame(book1, lib2.getLastLendedBook());

		lib.setLastLendedBook(book2);
		Assert.assertSame(book2, lib.getLastLendedBook());
		Assert.assertSame(book1, lib2.getLastLendedBook());

		lib2.setLastLendedBook(book2);
		Assert.assertSame(book2, lib.getLastLendedBook());
		Assert.assertSame(book2, lib2.getLastLendedBook());

		lib.setLastLendedBook(null);
		Assert.assertNull(lib.getLastLendedBook());
		Assert.assertSame(book2, lib2.getLastLendedBook());
		lib2.setLastLendedBook(null);
		Assert.assertNull(lib2.getLastLendedBook());
		Assert.assertNull(lib2.getLastLendedBook());

	}

	/**
	 * Tests a 0:1 relation.
	 */
	@Test
	public void test_referenceMany() {
		ExtendedLibrary lib = new ExtendedLibrary();

		Book book1 = new Book();
		book1.setName("book1");
		Book book2 = new Book();
		book1.setName("book2");

		lib.addBooks(book1);
		lib.addBooks(book2);

		lib.addAllLendedBooks(book1);
		Assert.assertTrue(lib.getAllLendedBooks().contains(book1));
		Assert.assertFalse(lib.getAllLendedBooks().contains(book2));

		lib.addAllLendedBooks(book2);
		Assert.assertTrue(lib.getAllLendedBooks().contains(book1));
		Assert.assertTrue(lib.getAllLendedBooks().contains(book2));

		lib.removeAllLendedBooks(book2);
		Assert.assertTrue(lib.getAllLendedBooks().contains(book1));
		Assert.assertFalse(lib.getAllLendedBooks().contains(book2));

		lib.removeAllLendedBooks(book1);
		Assert.assertFalse(lib.getAllLendedBooks().contains(book1));
		Assert.assertFalse(lib.getAllLendedBooks().contains(book2));
	}

	/**
	 * Thats that elements are only added once to a list.
	 */
	@Test
	public void test_referenceMany__addDuplicate() {
		ExtendedLibrary lib = new ExtendedLibrary();
		Book book = new Book();
		lib.addBooks(book);
		Assert.assertTrue(lib.getAllLendedBooks().size() == 0);

		lib.addAllLendedBooks(book);
		Assert.assertTrue(lib.getAllLendedBooks().size() == 1);

		lib.addAllLendedBooks(book);
		Assert.assertTrue(lib.getAllLendedBooks().size() == 1);

		lib.removeAllLendedBooks(book);
		Assert.assertTrue(lib.getAllLendedBooks().size() == 0);

		lib.removeAllLendedBooks(book);
		Assert.assertTrue(lib.getAllLendedBooks().size() == 0);
	}

	/**
	 * Tests the operation.
	 */
	@Test
	public void test_determineLendedBooksCount() {
		ExtendedLibrary lib = new ExtendedLibrary();

		Book book1 = new Book();
		book1.setName("book1");
		Book book2 = new Book();
		book1.setName("book2");

		lib.addBooks(book1);
		lib.addBooks(book2);

		Assert.assertEquals(0, (int) lib.determineLendedBooksCount());

		lib.addAllLendedBooks(book1);
		Assert.assertEquals(1, (int) lib.determineLendedBooksCount());

		lib.addAllLendedBooks(book2);
		Assert.assertEquals(2, (int) lib.determineLendedBooksCount());

		lib.removeAllLendedBooks(book2);
		Assert.assertEquals(1, (int) lib.determineLendedBooksCount());

		lib.removeAllLendedBooks(book1);
		Assert.assertEquals(0, (int) lib.determineLendedBooksCount());
	}

	/**
	 * Tests the embedded elements.
	 */
	@Test
	public void test_embedded_simple() {
		ExtendedLibrary lib = new ExtendedLibrary();

		lib.setAddress_number(112233);
		lib.setAddress_postalcode("test_postalcode");
		lib.setAddress_street("test_street");

		lib.setAddress_info_longText("test_longText");
		lib.setAddress_info_shortText("test_shortText");

		Assert.assertEquals(112233, lib.getAddress_number());
		Assert.assertEquals("test_postalcode", lib.getAddress_postalcode());
		Assert.assertEquals("test_street", lib.getAddress_street());
		Assert.assertEquals("test_longText", lib.getAddress_info_longText());
		Assert.assertEquals("test_shortText", lib.getAddress_info_shortText());
	}

	/**
	 * Tests the embedded elements.
	 */
	@Test
	public void test_enum() {
		ExtendedLibrary lib = new ExtendedLibrary();

		lib.setAnEnum(SomeEnum.ONE);
		Assert.assertEquals(SomeEnum.ONE, lib.getAnEnum());

		lib.setAnEnum(SomeEnum.TWO);
		Assert.assertEquals(SomeEnum.TWO, lib.getAnEnum());
	}

	/**
	 * Tests the embedded 0:1 references.
	 */
	@Test
	public void test_embedded_referenceSingle() {
		ExtendedLibrary lib = new ExtendedLibrary();

		Country country = new Country();

		lib.setAddress_country(country);
		Assert.assertSame(country, lib.getAddress_country());

		lib.setAddress_country(null);
		Assert.assertNull(lib.getAddress_country());
	}

	/**
	 * Tests the embedded 0:* references.
	 */
	@Test
	public void test_embedded_referenceMany() {
		ExtendedLibrary lib = new ExtendedLibrary();

		PostBox postbox1 = new PostBox();
		PostBox postbox2 = new PostBox();

		lib.addAddress_postBoxes(postbox1);
		Assert.assertTrue(lib.getAddress_postBoxes().contains(postbox1));
		Assert.assertFalse(lib.getAddress_postBoxes().contains(postbox2));

		lib.addAddress_postBoxes(postbox2);
		Assert.assertTrue(lib.getAddress_postBoxes().contains(postbox1));
		Assert.assertTrue(lib.getAddress_postBoxes().contains(postbox2));

		lib.removeAddress_postBoxes(postbox2);
		Assert.assertTrue(lib.getAddress_postBoxes().contains(postbox1));
		Assert.assertFalse(lib.getAddress_postBoxes().contains(postbox2));

		lib.removeAddress_postBoxes(postbox1);
		Assert.assertFalse(lib.getAddress_postBoxes().contains(postbox1));
		Assert.assertFalse(lib.getAddress_postBoxes().contains(postbox2));
	}

	/**
	 * Tests containment references that are contained in references of embedded
	 * elements. <br>
	 * For instance:<br>
	 * <ul>
	 * <li>ExtendedLibrary embedds Address</li>
	 * <li>Address references Country</li>
	 * <li>Country contains Provinces</li>
	 * </ul>
	 */
	@Test
	public void test_embedded__containment_in_reference() {
		ExtendedLibrary lib = new ExtendedLibrary();

		Country country = new Country();

		lib.setAddress_country(country);

		Province province1 = new Province();
		Province province2 = new Province();

		country.addProvinces(province1);
		Assert.assertTrue(country.getProvinces().contains(province1));
		Assert.assertFalse(country.getProvinces().contains(province2));
		Assert.assertSame(country, province1.getCountry());
		Assert.assertNull(province2.getCountry());

		country.addProvinces(province2);
		Assert.assertTrue(country.getProvinces().contains(province1));
		Assert.assertTrue(country.getProvinces().contains(province2));
		Assert.assertSame(country, province1.getCountry());
		Assert.assertSame(country, province2.getCountry());

		country.removeProvinces(province2);
		Assert.assertTrue(country.getProvinces().contains(province1));
		Assert.assertFalse(country.getProvinces().contains(province2));
		Assert.assertSame(country, province1.getCountry());
		Assert.assertNull(province2.getCountry());

		country.removeProvinces(province1);
		Assert.assertFalse(country.getProvinces().contains(province1));
		Assert.assertFalse(country.getProvinces().contains(province2));
		Assert.assertNull(province1.getCountry());
		Assert.assertNull(province2.getCountry());
	}

	@Test
	public void test_disposed_throwsExceptionOnAccess() {
		ExtendedLibrary lib = new ExtendedLibrary();
		// property
		lib.getName();
		// single reference
		lib.getLastLendedBook();
		// multi reference
		lib.getAllLendedBooks();
		// single containment
		lib.getIndex();
		// multi containment
		lib.getBooks();

		// dipose the lib
		lib.dispose();

		try {
			// property
			lib.getName();
			Assert.fail();
		} catch (Exception e) {
		}
		try {
			// single reference
			lib.getLastLendedBook();
			Assert.fail();
		} catch (Exception e) {
		}
		try {
			// multi reference
			lib.getAllLendedBooks();
			Assert.fail();
		} catch (Exception e) {
		}
		try {
			// single containment
			lib.getIndex();
			Assert.fail();
		} catch (Exception e) {
		}
		try {
			// multi containment
			lib.getBooks();
			Assert.fail();
		} catch (Exception e) {
		}
	}

	@Test
	public void test_disposed_delegateToContainment() {
		ExtendedLibrary lib = new ExtendedLibrary();

		Book contained1 = new Book();
		Book contained2 = new Book();

		lib.addBooks(contained1);
		lib.addBooks(contained2);

		BookIndex index = new BookIndex();
		lib.setIndex(index);

		Book allLended1 = new Book();
		Book allLended2 = new Book();
		lib.addAllLendedBooks(allLended1);
		lib.addAllLendedBooks(allLended2);

		Book lastLended = new Book();
		lib.setLastLendedBook(lastLended);

		Assert.assertFalse(contained1.isDisposed());
		Assert.assertFalse(contained2.isDisposed());
		Assert.assertFalse(index.isDisposed());
		Assert.assertFalse(allLended1.isDisposed());
		Assert.assertFalse(allLended2.isDisposed());
		Assert.assertFalse(lastLended.isDisposed());

		// dipose the lib
		lib.dispose();

		Assert.assertTrue(lib.isDisposed());
		Assert.assertTrue(contained1.isDisposed());
		Assert.assertTrue(contained2.isDisposed());
		Assert.assertTrue(index.isDisposed());
		Assert.assertFalse(allLended1.isDisposed());
		Assert.assertFalse(allLended2.isDisposed());
		Assert.assertFalse(lastLended.isDisposed());
	}

	@Test
	public void test_call_disposed_after_dispose() {
		ExtendedLibrary lib = new ExtendedLibrary();

		// dipose the lib
		lib.dispose();

		// nothing happens
		lib.dispose();
	}
}

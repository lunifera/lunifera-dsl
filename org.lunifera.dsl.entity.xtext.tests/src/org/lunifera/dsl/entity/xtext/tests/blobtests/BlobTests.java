/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Klemens Edler - Initial implementation
 */
package org.lunifera.dsl.entity.xtext.tests.blobtests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lunifera.dsl.entity.xtext.tests.AbstractJPATest;

public class BlobTests extends AbstractJPATest {

	private static final String PERSISTENCE_UNIT_NAME = "blobtests";
	private static EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Foobar foobar1 = new Foobar();
		Foobar foobar2 = new Foobar();
		Foobar foobar3 = new Foobar();

		foobar1.setMyblob("asdfasdf".getBytes());
		foobar2.setMyblob("qwerqwerq".getBytes());
		foobar3.setMyblob("yxcvyxcvyx".getBytes());
		

		foobar1.setName("Aaa");
		foobar2.setName("Bbb");
		foobar3.setName("Ccc");

		txn.begin();
		em.persist(foobar1);
		em.persist(foobar2);
		em.persist(foobar3);
		txn.commit();

	}

	
	/**
	 * Check that UUIDS are strings and unique
	 */
	@Test
	public void test01() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		Foobar aaaFoobar = new Foobar();
		Foobar bbbFoobar = new Foobar();
		Foobar cccFoobar = new Foobar();

		
		txn.begin();

		Query q = em.createQuery("select x from Foobar x where x.name='Aaa'");
		List<Foobar> list = q.getResultList();
		assertEquals(1, list.size());
		for (Foobar f : list) {
			if (f.getName().equals("Aaa")){
				aaaFoobar = f;
				assertTrue(f.getId() instanceof String);
			}
		}
		q = em.createQuery("select x from Foobar x where x.name='Bbb'");
		list = q.getResultList();
		assertEquals(1, list.size());
		for (Foobar f : list) {
			if (f.getName().equals("Bbb")){
				bbbFoobar = f;
				assertTrue(f.getId() instanceof String);
			}
		}
		q = em.createQuery("select x from Foobar x where x.name='Bbb'");
		list = q.getResultList();
		assertEquals(1, list.size());
		for (Foobar f : list) {
			if (f.getName().equals("Ccc")){
				bbbFoobar = f;
				assertTrue(f.getId() instanceof String);
				
			}
		}
		
		String aaaUuid = aaaFoobar.getId();
		String bbbUuid = bbbFoobar.getId();
		String cccUuid = cccFoobar.getId();
		assertNotEquals(aaaUuid, bbbUuid);
		assertNotEquals(aaaUuid, cccUuid);
		assertNotEquals(cccUuid, bbbUuid);

		txn.commit();
	}

	/**
	 * Check that all entities have been persisted in a single table
	 */
	@Test
	public void test02() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select x from Foobar x");
		List<Foobar> list = q.getResultList();
		assertEquals(3, list.size());

		txn.commit();
	}
	
	/**
	 * Check that blob length has been preserved
	 */
	@Test
	public void test03() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select x from Foobar x");
		List<Foobar> list = q.getResultList();
		for(Foobar f: list) {
			if(f.getName().equals("Aaa")){
				assertEquals(8, f.getMyblob().length);
			}
			if(f.getName().equals("Bbb")){
				assertEquals(9, f.getMyblob().length);
			}
			if(f.getName().equals("Ccc")){
				assertEquals(10, f.getMyblob().length);
			}
		}

		txn.commit();
	}
	
	/**
	 * Check that blobs can be read correctly from database
	 */
	@Test
	public void test04() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select x from Foobar x");
		List<Foobar> list = q.getResultList();
		for(Foobar f: list) {
			if(f.getName().equals("Aaa")){
				assertArrayEquals("asdfasdf".getBytes(), f.getMyblob());
			}
			if(f.getName().equals("Bbb")){
				assertArrayEquals("qwerqwerq".getBytes(), f.getMyblob());
			}
			if(f.getName().equals("Ccc")){
				assertArrayEquals("yxcvyxcvyx".getBytes(), f.getMyblob());
			}
		}

		txn.commit();
	}

	@After
	public void tearDown() throws Exception {
		emf.close();
	}

}

package org.lunifera.dsl.entity.xtext.tests.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lunifera.dsl.entity.xtext.tests.model1.House;

public class Model1Tests {

	private static final String PERSISTENCE_UNIT_NAME = "model1";
	private static EntityManagerFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	@After
	public void tearDown() throws Exception {
		factory.close();
	}

	@Test
	public void test() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		
		org.lunifera.dsl.entity.xtext.tests.model1.House house = new House();
		house.setName("Model1");
		em.persist(house);
		txn.commit();
	}

}

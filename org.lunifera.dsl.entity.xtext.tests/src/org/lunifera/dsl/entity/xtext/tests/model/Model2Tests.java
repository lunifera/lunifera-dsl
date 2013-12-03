package org.lunifera.dsl.entity.xtext.tests.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lunifera.dsl.entity.xtext.tests.model2.BigHotel;
import org.lunifera.dsl.entity.xtext.tests.model2.Hotel;
import org.lunifera.dsl.entity.xtext.tests.model2.House;
import org.lunifera.dsl.entity.xtext.tests.model2.SmallHotel;

public class Model2Tests {

	private static final String PERSISTENCE_UNIT_NAME = "model2";
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

		org.lunifera.dsl.entity.xtext.tests.model2.House house = new House();
		org.lunifera.dsl.entity.xtext.tests.model2.Hotel hotel = new Hotel();
		org.lunifera.dsl.entity.xtext.tests.model2.BigHotel bh = new BigHotel();
		org.lunifera.dsl.entity.xtext.tests.model2.SmallHotel sh = new SmallHotel();
		em.persist(house);
		em.persist(hotel);
		em.persist(bh);
		em.persist(sh);
		txn.commit();

		assertEquals(1, house.getId());
		assertEquals(2, hotel.getId());
		assertEquals(3, bh.getId());
		assertEquals(4, sh.getId());
		
		
		List<House> list = em.createQuery("select house from House as house")
				.getResultList();
		for (House h : list) {
			System.out.println(h.getClass().getName());
		}
	}

	@Test
	public void test2() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		List<House> list = em.createQuery("select house from House as house")
				.getResultList();
		for (House h : list) {
			System.out.println(h);
		}

	}

}

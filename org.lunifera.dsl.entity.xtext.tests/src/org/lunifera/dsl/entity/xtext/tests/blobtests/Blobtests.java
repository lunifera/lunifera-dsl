package org.lunifera.dsl.entity.xtext.tests.blobtests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Blobtests {

	private static final String PERSISTENCE_UNIT_NAME = "blobtests";
	private static EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = emf.createEntityManager();

	}

	@Test
	public void test1() throws Exception {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		txn.begin();
		Base base = new Base();
		Bean bean = new Bean();
		Bean1 bean1 = new Bean1();
		Bean2 bean2 = new Bean2();
		try {
			base.setName("Huhu");
			bean.setName("Huhu");
			bean1.setName("Huhu");
			bean2.setName("Huhu");

			base.setOther(bean);
			bean.setInfo(bean1);
			bean1.setAddon(bean2);
			
			em.persist(base);
			txn.commit();
		} catch (Exception e) {
			txn.rollback();
			throw e;
		}
	}

	@After
	public void tearDown() throws Exception {
		emf.close();
	}

}

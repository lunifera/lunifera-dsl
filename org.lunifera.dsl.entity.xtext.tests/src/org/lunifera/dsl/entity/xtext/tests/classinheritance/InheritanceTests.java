package org.lunifera.dsl.entity.xtext.tests.classinheritance;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InheritanceTests {

	private static final String PERSISTENCE_UNIT_NAME = "classinheritance";
	private static EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		BaseByClass bbc = new BaseByClass();
		BaseBySubclass bbs = new BaseBySubclass();
		OneByClass obc = new OneByClass();
		OneBySubclass obs = new OneBySubclass();
		TwoByClass tbc = new TwoByClass();
		TwoBySubclass tbs = new TwoBySubclass();
		
		txn.begin();
		em.persist(bbc);
		em.persist(bbs);
		em.persist(obc);
		em.persist(obs);
		em.persist(tbc);
		em.persist(tbs);
		txn.commit();
	
	}
	
	@Test
	public void test01() {
	EntityManager em = emf.createEntityManager();
	EntityTransaction txn = em.getTransaction();
	txn.begin();

	Query q = em.createQuery("select x from TwoByClass x");
	List<TwoByClass> list = q.getResultList();
	assertEquals(1, list.size());
	
	q = em.createQuery("select x from TwoBySubclass x");
	list = q.getResultList();
	assertEquals(1, list.size());
	
	txn.commit();
	}

	

	@After
	public void tearDown() throws Exception {
		emf.close();
	}
	

	
}

package org.lunifera.dsl.entity.xtext.tests.selfreference;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore1.Customer;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore1.Person;

import com.google.inject.matcher.Matchers;

public class SelfreferenceTests {

	private static final String PERSISTENCE_UNIT_NAME = "selfreftests";
	private static EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		TreeEmployee bigboss = new TreeEmployee();
		TreeEmployee boss = new TreeEmployee();
		TreeEmployee employee1 = new TreeEmployee();
		TreeEmployee employee2 = new TreeEmployee();
		TreeEmployee tinyhelper = new TreeEmployee();

		tinyhelper.setBoss(employee1);
		employee1.setBoss(boss);
		employee2.setBoss(boss);
		boss.setBoss(bigboss);
		bigboss.setBoss(bigboss);

		tinyhelper.setName("Mini");
		employee1.setName("Em1");
		employee2.setName("Em2");
		boss.setName("Boss");
		bigboss.setName("BigBoss");

		txn.begin();
		em.persist(bigboss);
		em.persist(boss);
		em.persist(employee1);
		em.persist(employee2);
		em.persist(tinyhelper);

		assertEquals(3L, employee1.getId());

		txn.commit();

	}

	@After
	public void tearDown() throws Exception {
		emf.close();
	}

	/**
	 * Check if everyone is persisted
	 */
	@Test
	public void test01() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select x from TreeEmployee x");
		List<TreeEmployee> list = q.getResultList();
		assertEquals(5, list.size());
		txn.commit();
	}

	/**
	 * Check if everyone's boss is set and persisted correctly
	 */
	@Test
	public void test02() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select x from TreeEmployee x");
		List<TreeEmployee> list = q.getResultList();

		for (TreeEmployee t : list) {
			if (t.getName().equals("Mini")) {
				assertEquals("Em1", t.getBoss().getName());
			}
			if (t.getName().equals("Em1")) {
				assertEquals("Boss", t.getBoss().getName());
			}
			if (t.getName().equals("Em2")) {
				assertEquals("Boss", t.getBoss().getName());
			}
			if (t.getName().equals("Boss")) {
				assertEquals("BigBoss", t.getBoss().getName());
			}
			if (t.getName().equals("BigBoss")) {
				assertEquals("BigBoss", t.getBoss().getName());
			}
		}
		txn.commit();
	}

	/**
	 * Check if everyone's subordinates are set and persisted correctly
	 */
	@Test
	public void test03() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select x from TreeEmployee x");
		List<TreeEmployee> list = q.getResultList();
		assertEquals(5, list.size());

		for (TreeEmployee t : list) {
			if (t.getName().equals("Mini")) {
				assertEquals(0, t.getSubordinates().size());
			}
			if (t.getName().equals("Em1")) {
				List<TreeEmployee> sublist = t.getSubordinates();
				assertEquals(1, sublist.size());
				for (TreeEmployee subt : sublist) {
					assertEquals(subt.getBoss(), t);
					System.out.println(t.getName() + " is boss of "
							+ subt.getName());
				}
			}
			if (t.getName().equals("Em2")) {
				assertEquals(0, t.getSubordinates().size());
			}
			if (t.getName().equals("Boss")) {
				List<TreeEmployee> sublist = t.getSubordinates();
				assertEquals(2, sublist.size());
				for (TreeEmployee subt : sublist) {
					assertEquals(subt.getBoss(), t);
					System.out.println(t.getName() + " is boss of "
							+ subt.getName());
				}
			}
			if (t.getName().equals("BigBoss")) {
				List<TreeEmployee> sublist = t.getSubordinates();
				assertEquals(2, sublist.size());
				for (TreeEmployee subt : sublist) {
					assertEquals(subt.getBoss(), t);
					System.out.println(t.getName() + " is boss of "
							+ subt.getName());
				}
			}
		}
		txn.commit();
	}

	/**
	 * Test cascading deletion
	 */
	@Test
	public void test04() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		/**
		 * Removing employee1 should remove tinyhelper as well
		 */
		TreeEmployee employee1 = em.find(TreeEmployee.class, 3L);
		em.remove(employee1);
		txn.commit();

		Query q = em.createQuery("select x from TreeEmployee x");
		List<TreeEmployee> list = q.getResultList();
		assertEquals(3, list.size());
	}
	
	/**
	 * Test cascading disposal
	 */
	@Test
	public void test05() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		
		/**
		 * Load entities from database
		 */
		
		TreeEmployee bigboss = new TreeEmployee();
		TreeEmployee boss = new TreeEmployee();
		TreeEmployee employee1 = new TreeEmployee();
		TreeEmployee employee2 = new TreeEmployee();
		TreeEmployee tinyhelper = new TreeEmployee();
		
		Query q = em.createQuery("select t from TreeEmployee t");
		List<TreeEmployee> list = q.getResultList();
		assertEquals(5, list.size());
		for (TreeEmployee t : list) {
			if (t.getName().equals("BigBoss")) {
				bigboss = t;
			}
			if (t.getName().equals("Boss")) {
				boss = t;
			}
			if (t.getName().equals("Em1")) {
				employee1 = t;
			}
			if (t.getName().equals("Em2")) {
				employee2 = t;
			}
			if (t.getName().equals("Mini")) {
				tinyhelper = t;
			}
		}

		/**
		 * Disposing employee1 should remove tinyhelper as well,
		 * but not employee2, boss and bigboss.
		 */
		
		assertEquals(employee1, tinyhelper.getBoss());
		
		employee1.dispose();
		
		assertFalse(bigboss.isDisposed());
		assertFalse(boss.isDisposed());
		assertTrue(employee1.isDisposed());
		assertFalse(employee2.isDisposed());
		assertTrue(tinyhelper.isDisposed());
	}

}

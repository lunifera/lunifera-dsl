package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.jpa.jpql.Assert.AssertException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Carstore2Test {

	private static final String PERSISTENCE_UNIT_NAME = "carstore2test";
	private static EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Customer buyer = new Customer();
		Customer seller = new Customer();
		Employee boss = new Employee();
		Employee employee = new Employee();
		Address buyeraddr = new Address();
		Address manufactureraddr = new Address();
		Manufacturer manufacturer = new Manufacturer();
		Manufacturer manufacturer2 = new Manufacturer();
		Car car = new Car();
		Car car2 = new Car();
		Car car3 = new Car();

		buyer.setFirstname("Bertie");
		buyer.setLastname("Bowser");
		buyer.setBirthdate(new Date(1980, 1, 1));
		seller.setFirstname("Sammy");
		seller.setLastname("Stevenson");
		seller.setBirthdate(new Date(1960, 1, 1));
		employee.setFirstname("Emily");
		employee.setLastname("Ericsson");
		employee.setBirthdate(new Date(1990, 1, 1));
		employee.setBoss(boss);
		boss.setFirstname("Charles");
		boss.setLastname("Chiefer");
		boss.setBirthdate(new Date(1955, 5, 5));
		boss.setBoss(boss);
		buyeraddr.setCity("Wien");
		buyeraddr.setZipcode(1010);
		buyeraddr.setStreetname("Walfischgasse");
		buyeraddr.setHousenumber(12);
		manufacturer.setName("Lunifera Racecars");
//		manufacturer.setAddress(manufactureraddr);
		manufacturer2.setName("Crashcars");
		manufactureraddr.setCity("Torino");
		manufactureraddr.setZipcode(23456);
		manufactureraddr.setStreetname("Tivoli");
		manufactureraddr.setHousenumber(34);
//		buyer.addToAddress(buyeraddr);
//		manufacturer.setAddress(manufactureraddr);
		car.setConstructiondate(new Date(2012, 4, 4));
		car.setModelname("Beta Romeo");
		car.setManufacturer(manufacturer);
		car2.setModelname("Wreckcar");
		car2.setManufacturer(manufacturer2);
		car3.setModelname("Crashcar");
		car3.setManufacturer(manufacturer2);

		txn.begin();
		em.persist(buyer);
		em.persist(seller);
		em.persist(boss);
		em.persist(employee);
		em.persist(manufacturer);
		em.persist(manufacturer2);
		txn.commit();

		assertEquals(1, buyer.getId());
		assertEquals(2, seller.getId());
		assertEquals(3, boss.getId());
		assertEquals(4, employee.getId());
		assertEquals(5, manufacturer.getId());
		assertEquals(7, manufacturer2.getId());
		assertEquals("Bertie", buyer.getFirstname());
		assertEquals("Bowser", buyer.getLastname());
		assertEquals("Bertie", buyer.getFirstname());

		List<Employee> elist = em.createQuery(
				"select e from Employee e where e.id = 4").getResultList();
		assertEquals(1, elist.size());

	
	}

	@After
	public void tearDown() throws Exception {
		emf.close();
	}
	
	/**
	 * Read from database
	 */
	@Test
	public void test02() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select e from Employee e");
		List<Employee> elist = q.getResultList();
		assertEquals(2, elist.size());
	}

	/**
	 * Select specific object from db
	 */
	@Test
	public void test03() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select e from Employee e where e.id = 4");
		List<Employee> elist = q.getResultList();
		assertEquals(1, elist.size());
	}

	/**
	 * Check some values stored in db
	 */
	@Test
	public void test04() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select e from Employee e");
		List<Employee> elist = q.getResultList();
		assertEquals(2, elist.size());
		for (Employee e : elist) {
			if (e.getId() == 3) {
				assertEquals("Charles", e.getFirstname());
				assertEquals("Chiefer", e.getLastname());
				assertEquals(1955, e.getBirthdate().getYear());
				List<Employee> elist2 = e.getSubordinates();
				assertEquals(2, elist2.size());
				for (Employee e2 : elist2) {
					assertEquals(e2.getBoss(), e);  // check bidirectional reference
				}
			}
			if (e.getId() == 4) {
				assertEquals("Emily", e.getFirstname());
				assertEquals("Ericsson", e.getLastname());
				assertEquals(1990, e.getBirthdate().getYear());
				assertEquals("Charles", e.getBoss().getFirstname());
			}
		}
	}

	/** 
	 * Check different object
	 */
	@Test
	public void test05() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select c from Car c");
		List<Car> clist = q.getResultList();
		assertEquals(3, clist.size());
		for (Car c : clist) {
			if (c.getId() == 7) {
				assertEquals("Beta Romeo", c.getModelname());
				assertEquals(2012, c.getConstructiondate().getYear());
				assertEquals("Lunifera Racecars", c.getManufacturer().getName());
			}
		}
	}
	
	/**
	 * Add value to db and read it back
	 */
	@Test
	public void test06() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select c from Customer c");
		List<Customer> list = q.getResultList();
		assertEquals(2, list.size());
		for (Customer c : list) {
			if (c.getId() == 1) {
				assertEquals("Bertie", c.getFirstname());
				c.setIban("AT12345678901234567890");
				em.persist(c);
				txn.commit();
			}
		}
		q = em.createQuery("select c from Customer c where c.id = 1");
		list = q.getResultList();
		assertEquals(1, list.size());
		for (Customer c : list) {
			if (c.getId() == 1) {
				assertEquals("AT12345678901234567890", c.getIban());
			}
		}
	}
	
	/**
	 * Change value in db and read it back
	 */
	@Test
	public void test07() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select c from Customer c");
		List<Customer> list = q.getResultList();
		assertEquals(2, list.size());
		for (Customer c : list) {
			if (c.getId() == 1) {
				assertEquals("Bertie", c.getFirstname());
				c.setIban("DE0987654321");
				em.persist(c);
				txn.commit();
			}
		}
		q = em.createQuery("select c from Customer c where c.id = 1");
		list = q.getResultList();
		assertEquals(1, list.size());
		for (Customer c : list) {
			if (c.getId() == 1) {
				assertEquals("DE0987654321", c.getIban());
			}
		}
	}

	/**
	 * Load supertype from db
	 */
	@Test
	public void test08() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select p from Person p");
		List<Person> list = q.getResultList();
		assertEquals(4, list.size());
	}
	
	/**
	 * Access a type via query for supertype (with strategy joined)
	 */
	@Test
	public void test09() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select p from Person p");
		List<Person> list = q.getResultList();
		assertEquals(4, list.size());
		for (Person p : list) {
			if (p instanceof Employee) {
				assertNotNull(((Employee) p).getBoss());
			};
		}
	}
	
	/**
	 * Delete operation
	 */
	@Test
	public void test10() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("delete from Person p where p.firstname = 'Bertie'");
		int deletedCount = q.executeUpdate();
		assertEquals(1, deletedCount);
		txn.commit();
		q = em.createQuery("select p from Person p");
		List<Person> list = q.getResultList();
		assertEquals(3, list.size());
	}
	
	/**
	 * Check bidirectional one-to-many
	 */
	@Test
	public void test11() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select c from Car c where c.manufacturer.id = 7");
		List<Car> list = q.getResultList();
		for (Car c: list) {
			System.out.println("Car " + c.getModelname() + ", Manufacturer: " + c.getManufacturer().getId());
		}
		assertEquals(2, list.size());
		
	}
	
	/**
	 * Delete cascade operation
	 */
	@Test
	public void test12() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Query q = em.createQuery("select c from Car c");
		List<Car> list = q.getResultList();
		assertEquals(3, list.size());
		for (Car c: list) {
			System.out.println("Car " + c.getModelname() + ", Manufacturer: " + c.getManufacturer().getId());
		}
		
		Manufacturer m = em.find(Manufacturer.class, 7L);
		em.remove(m);
		txn.commit();
		
		q = em.createQuery("select c from Car c");
		list = q.getResultList();
		assertEquals(1, list.size());
		for (Car c: list) {
			System.out.println("Car " + c.getModelname() + ", Manufacturer: " + c.getManufacturer().getId());
		}
	}
}

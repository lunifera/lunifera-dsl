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
package org.lunifera.dsl.entity.xtext.tests.jpa;

import junit.framework.Assert;

import org.junit.Test;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Client;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Contract;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Developer;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Manager;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Project;

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
		Client client = new Client();

		Contract contract1 = new Contract();
		Contract contract2 = new Contract();
		Assert.assertNull(contract1.getClient());

		Assert.assertNull(contract2.getClient());

		// add books
		client.addToContracts(contract1);
		Assert.assertNotNull(contract1.getClient());
		Assert.assertTrue(client.getContracts().contains(contract1));
		Assert.assertFalse(client.getContracts().contains(contract2));

		client.addToContracts(contract2);
		Assert.assertNotNull(contract2.getClient());
		Assert.assertTrue(client.getContracts().contains(contract1));
		Assert.assertTrue(client.getContracts().contains(contract2));

		// remove books
		client.removeFromContracts(contract1);
		Assert.assertNull(contract1.getClient());
		Assert.assertFalse(client.getContracts().contains(contract1));
		Assert.assertTrue(client.getContracts().contains(contract2));

		client.removeFromContracts(contract2);
		Assert.assertNull(contract1.getClient());
		Assert.assertFalse(client.getContracts().contains(contract1));
		Assert.assertFalse(client.getContracts().contains(contract2));
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
		Client lib1 = new Client();
		lib1.setName("lib1");
		Contract contract11 = new Contract();
		contract11.setName("book11");
		Contract contract12 = new Contract();
		contract12.setName("book12");

		// add books
		lib1.addToContracts(contract11);
		lib1.addToContracts(contract12);

		//
		// lib2
		//
		Client lib2 = new Client();
		lib2.setName("lib2");
		Contract contract21 = new Contract();
		contract21.setName("book21");
		Contract contract22 = new Contract();
		contract22.setName("book22");

		// add books
		lib2.addToContracts(contract21);
		lib2.addToContracts(contract22);

		//
		// move a book from lib1 to lib2
		//
		lib2.addToContracts(contract11);
		// parent did change
		Assert.assertSame(lib2, contract11.getClient());
		Assert.assertFalse(lib1.getContracts().contains(contract11));
		Assert.assertTrue(lib2.getContracts().contains(contract11));

		// move it back
		lib1.addToContracts(contract11);
		// parent did change
		Assert.assertSame(lib1, contract11.getClient());
		Assert.assertTrue(lib1.getContracts().contains(contract11));
		Assert.assertFalse(lib2.getContracts().contains(contract11));
	}

	/**
	 * Thats that elements are only added once to a list.
	 */
	@Test
	public void test_containmentMany__addDuplicate() {
		Client client = new Client();
		Contract contract = new Contract();
		Assert.assertTrue(client.getContracts().size() == 0);

		client.addToContracts(contract);
		Assert.assertTrue(client.getContracts().size() == 1);

		client.addToContracts(contract);
		Assert.assertTrue(client.getContracts().size() == 1);

		client.removeFromContracts(contract);
		Assert.assertTrue(client.getContracts().size() == 0);

		client.removeFromContracts(contract);
		Assert.assertTrue(client.getContracts().size() == 0);
	}

	/**
	 * Tests the 0:*-container reference.<br>
	 * Using the setter of a container references has to add the reference to
	 * the object, but also has to ensure, that the reference to the parent of
	 * the added element is set properly.
	 */
	@Test
	public void test_containerMany_setClient() {
		//
		// client1
		//
		Client client1 = new Client();
		Contract contract1 = new Contract();
		Contract contract12 = new Contract();

		// set the client
		contract1.setClient(client1);
		Assert.assertSame(contract1.getClient(), client1);
		Assert.assertTrue(client1.getContracts().contains(contract1));
		Assert.assertFalse(client1.getContracts().contains(contract12));

		contract12.setClient(client1);
		Assert.assertSame(contract12.getClient(), client1);
		Assert.assertTrue(client1.getContracts().contains(contract1));
		Assert.assertTrue(client1.getContracts().contains(contract12));

		//
		// client2
		//
		Client client2 = new Client();
		Contract contract21 = new Contract();
		// add book
		client2.addToContracts(contract21);

		//
		// move a book from client2 to client1
		//
		contract21.setClient(client1);
		// parent did change
		Assert.assertSame(contract21.getClient(), client1);
		Assert.assertTrue(client1.getContracts().contains(contract21));
		Assert.assertFalse(client2.getContracts().contains(contract21));

		// move it back
		contract21.setClient(client2);
		// parent did change
		Assert.assertSame(contract21.getClient(), client2);
		Assert.assertFalse(client1.getContracts().contains(contract21));
		Assert.assertTrue(client2.getContracts().contains(contract21));
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
		Contract lib = new Contract();
		lib.setName("lib");

		Project p1 = new Project();
		p1.setName("bookIndex1");
		Project p2 = new Project();
		p2.setName("bookIndex2");
		Assert.assertNull(p1.getContract());
		Assert.assertNull(p2.getContract());

		// set index
		lib.setProject(p1);
		Assert.assertSame(lib, p1.getContract());
		Assert.assertSame(p1, lib.getProject());
		Assert.assertNull(p2.getContract());

		lib.setProject(p2);
		Assert.assertSame(lib, p2.getContract());
		Assert.assertSame(p2, lib.getProject());
		Assert.assertNull(p1.getContract());

		lib.setProject(null);
		Assert.assertNull(p2.getContract());
		Assert.assertNull(lib.getProject());
	}

	/**
	 * Tests the 0:1-containment reference.<br>
	 * Using the set method of containment reference has to set the reference to
	 * the object, but also has to ensure, that the reference to the parent of
	 * the set element is also set properly.
	 */
	@Test
	public void test_containmentSingle_move() {
		Contract contract = new Contract();
		Contract otherContract = new Contract();

		Project project = new Project();

		// set index
		contract.setProject(project);
		Assert.assertSame(contract, project.getContract());
		Assert.assertSame(project, contract.getProject());
		Assert.assertNull(otherContract.getProject());

		// set index to otherLib
		otherContract.setProject(project);
		Assert.assertSame(otherContract, project.getContract());
		Assert.assertSame(project, otherContract.getProject());
		Assert.assertNull(contract.getProject());
	}

	/**
	 * Tests the 0:1-container reference.<br>
	 * Using the setter of a container references has to add the reference to
	 * the object, but also has to ensure, that the reference to the parent of
	 * the set element is also set properly.
	 */
	@Test
	public void test_containerSingle_setContract() {
		Contract contract = new Contract();
		Contract otherContract = new Contract();

		Project project = new Project();

		// sets the lib to the index
		project.setContract(contract);
		Assert.assertSame(contract, project.getContract());
		Assert.assertSame(project, contract.getProject());
		Assert.assertNull(otherContract.getProject());

		// sets the otherLib to the index
		project.setContract(otherContract);
		Assert.assertSame(otherContract, project.getContract());
		Assert.assertSame(project, otherContract.getProject());
		Assert.assertNull(contract.getProject());

		// sets null as library to the index
		project.setContract(null);
		Assert.assertNull(contract.getProject());
		Assert.assertNull(otherContract.getProject());
		Assert.assertNull(project.getContract());
	}

	/**
	 * Tests a 0:1 relation.
	 */
	@Test
	public void test_referenceSingle() {
		Developer dev1 = new Developer();
		Developer dev2 = new Developer();

		Project project1 = new Project();
		Project project2 = new Project();

		Assert.assertNull(dev1.getProject());

		dev1.setProject(project1);
		Assert.assertSame(project1, dev1.getProject());
		Assert.assertNull(dev2.getProject());

		dev2.setProject(project1);
		Assert.assertSame(project1, dev1.getProject());
		Assert.assertSame(project1, dev2.getProject());

		dev1.setProject(project2);
		Assert.assertSame(project2, dev1.getProject());
		Assert.assertSame(project1, dev2.getProject());

		dev2.setProject(project2);
		Assert.assertSame(project2, dev1.getProject());
		Assert.assertSame(project2, dev2.getProject());

		dev1.setProject(null);
		Assert.assertNull(dev1.getProject());
		Assert.assertSame(project2, dev2.getProject());

		dev2.setProject(null);
		Assert.assertNull(dev2.getProject());
		Assert.assertNull(dev2.getProject());

	}

	/**
	 * Tests a 0:1 relation.
	 */
	@Test
	public void test_referenceMany() {
		Manager manager = new Manager();

		Project project1 = new Project();
		project1.setName("book1");
		Project project2 = new Project();
		project1.setName("book2");

		manager.addToProjects(project1);
		Assert.assertTrue(manager.getProjects().contains(project1));
		Assert.assertFalse(manager.getProjects().contains(project2));

		manager.addToProjects(project2);
		Assert.assertTrue(manager.getProjects().contains(project1));
		Assert.assertTrue(manager.getProjects().contains(project2));

		manager.removeFromProjects(project2);
		Assert.assertTrue(manager.getProjects().contains(project1));
		Assert.assertFalse(manager.getProjects().contains(project2));

		manager.removeFromProjects(project1);
		Assert.assertFalse(manager.getProjects().contains(project1));
		Assert.assertFalse(manager.getProjects().contains(project2));
	}

	/**
	 * Thats that elements are only added once to a list.
	 */
	@Test
	public void test_referenceMany__addDuplicate() {
		Manager manager = new Manager();
		Project project1 = new Project();
		Assert.assertTrue(manager.getProjects().size() == 0);

		manager.addToProjects(project1);
		Assert.assertTrue(manager.getProjects().size() == 1);

		manager.addToProjects(project1);
		Assert.assertTrue(manager.getProjects().size() == 1);

		manager.removeFromProjects(project1);
		Assert.assertTrue(manager.getProjects().size() == 0);

		manager.removeFromProjects(project1);
		Assert.assertTrue(manager.getProjects().size() == 0);
	}

	/**
	 * Tests the operation.
	 */
	@Test
	public void test_getProjectsCount() {
		Manager manager = new Manager();

		Project project1 = new Project();
		project1.setName("project1");
		Project project2 = new Project();
		project1.setName("project2");

		Assert.assertEquals(0, (int) manager.getProjectsCount());

		manager.addToProjects(project1);
		Assert.assertEquals(1, (int) manager.getProjectsCount());

		manager.addToProjects(project2);
		Assert.assertEquals(2, (int) manager.getProjectsCount());

		manager.removeFromProjects(project2);
		Assert.assertEquals(1, (int) manager.getProjectsCount());

		manager.removeFromProjects(project1);
		Assert.assertEquals(0, (int) manager.getProjectsCount());
	}

	@Test
	public void test_disposed_throwsExceptionOnAccess() {
		Project project = new Project();
		Client client = new Client();
		Contract contract = new Contract();

		project.getDevelopers();
		project.getManager();
		project.getContract();

		// property
		project.getId();
		// single reference
		project.getManager();
		// multi reference
		project.getDevelopers();
		// container reference
		project.getContract();
		// single containment
		contract.getProject();
		// multi containment
		client.getContracts();

		// dipose
		project.dispose();
		client.dispose();
		contract.dispose();

		try {
			// property
			project.getId();
			Assert.fail();
		} catch (Exception e) {
		}
		try {
			// single reference
			project.getManager();
			Assert.fail();
		} catch (Exception e) {
		}
		try {
			// multi reference
			project.getDevelopers();
			Assert.fail();
		} catch (Exception e) {
		}
		try {
			// container reference
			project.getContract();
			Assert.fail();
		} catch (Exception e) {
		}
		try {
			// single containment
			project.getContract();
			Assert.fail();
		} catch (Exception e) {
		}
		try {
			// multi containment
			client.getContracts();
			Assert.fail();
		} catch (Exception e) {
		}
	}

	@Test
	public void test_disposed_delegateToContainment_toMany() {
		Client client = new Client();

		Contract contained1 = new Contract();
		Contract contained2 = new Contract();

		client.addToContracts(contained1);
		client.addToContracts(contained2);

		Assert.assertFalse(contained1.isDisposed());
		Assert.assertFalse(contained2.isDisposed());

		// dipose the lib
		client.dispose();

		Assert.assertTrue(client.isDisposed());
		Assert.assertTrue(contained1.isDisposed());
		Assert.assertTrue(contained2.isDisposed());
	}

	@Test
	public void test_disposed_delegateToContainment_toSingle() {
		Contract contract = new Contract();
		Project contained = new Project();
		contract.setProject(contained);

		Assert.assertFalse(contained.isDisposed());

		// dipose the lib
		contract.dispose();

		Assert.assertTrue(contract.isDisposed());
		Assert.assertTrue(contained.isDisposed());
	}

	@Test
	public void test_disposed_nodelegateToReference() {
		Project contract = new Project();
		Developer ref1 = new Developer();
		contract.addToDevelopers(ref1);
		Developer ref2 = new Developer();
		contract.addToDevelopers(ref2);
		Manager ref3 = new Manager();
		contract.setManager(ref3);

		Assert.assertFalse(contract.isDisposed());
		Assert.assertFalse(ref1.isDisposed());
		Assert.assertFalse(ref2.isDisposed());
		Assert.assertFalse(ref3.isDisposed());

		// dipose the contract
		contract.dispose();

		Assert.assertTrue(contract.isDisposed());
		Assert.assertFalse(ref1.isDisposed());
		Assert.assertFalse(ref2.isDisposed());
		Assert.assertFalse(ref3.isDisposed());
	}

	@Test
	public void test_call_disposed_after_dispose() {
		Project project = new Project();

		// dipose the lib
		project.dispose();

		// nothing happens
		project.dispose();
	}
}

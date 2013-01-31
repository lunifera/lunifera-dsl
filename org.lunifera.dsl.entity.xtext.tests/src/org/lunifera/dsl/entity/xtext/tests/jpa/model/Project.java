package org.lunifera.dsl.entity.xtext.tests.jpa.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Contract;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Developer;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Manager;

@Entity
public class Project {
  private boolean disposed;
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private Long id;
  
  @Column
  private String name;
  
  @OneToOne
  @JoinColumn(name = "CONTRACT")
  private Contract contract;
  
  @OneToMany(mappedBy = "project")
  private List<Developer> developers;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MANAGER")
  private Manager manager;
  
  /**
   * Returns true, if the object is disposed. 
   * Disposed means, that it is prepared for garbage collection and may not be used anymore. 
   * Accessing objects that are already disposed will cause runtime exceptions.
   */
  public boolean isDisposed() {
    return this.disposed;
  }
  
  /**
   * Checks whether the object is disposed.
   * @throws RuntimeException if the object is disposed.
   */
  private void checkDisposed() {
    if (isDisposed()) {
      throw new RuntimeException("Object already disposed: " + this);
    }
  }
  
  /**
   * Calling dispose will destroy that instance. The internal state will be 
   * set to 'disposed' and methods of that object must not be used anymore. 
   * Each call will result in runtime exceptions.<br/>
   * If this object keeps composition containments, these will be disposed too. 
   * So the whole composition containment tree will be disposed on calling this method.
   */
  public void dispose() {
    if (isDisposed()) {
      return;
    }
    try {
      // Dispose all the composition references.
      if (this.contract != null) {
        this.contract.dispose();
        this.contract = null;
      }
      
    }
    finally {
      disposed = true;
    }
    
  }
  
  /**
   * Returns the id property or <code>null</code> if not present.
   */
  public Long getId() {
    checkDisposed();
    return this.id;
  }
  
  /**
   * Sets the id property to this instance.
   */
  public void setId(final Long id) {
    checkDisposed();
    this.id = id;
  }
  
  /**
   * Returns the name property or <code>null</code> if not present.
   */
  public String getName() {
    checkDisposed();
    return this.name;
  }
  
  /**
   * Sets the name property to this instance.
   */
  public void setName(final String name) {
    checkDisposed();
    this.name = name;
  }
  
  /**
   * Returns the contract property or <code>null</code> if not present.
   */
  public Contract getContract() {
    checkDisposed();
    return this.contract;
  }
  
  /**
   * Sets the contract property to this instance.
   * Since the reference is a container reference, the opposite reference (Contract.project)
   * of the contract will be handled automatically and no further coding is required to keep them in sync.
   * See {@link Contract#setProject(Contract)}.
   */
  public void setContract(final Contract contract) {
    checkDisposed();
    if (this.contract != null) {
      this.contract.internalSetProject(null);
    }
    this.contract = contract;
    if (this.contract != null) {
      this.contract.internalSetProject(this);
    }
    
  }
  
  void internalSetContract(final Contract contract) {
    this.contract = contract;
  }
  
  /**
   * Returns an unmodifiable list of developers.
   */
  public List<Developer> getDevelopers() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetDevelopers());
  }
  
  /**
   * Returns the list of <code>Developer</code>s thereby lazy initializing it.
   */
  private List<Developer> internalGetDevelopers() {
    if (this.developers == null) {
      this.developers = new ArrayList<Developer>();
    }
    return this.developers;
  }
  
  /**
   * Adds the given developer to this object. <p>
   * Since the reference is a composition reference, the opposite reference (Developer.project)
   * of the developer will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Developer#setProject(Developer)}.
   * 
   */
  public void addToDevelopers(final Developer developer) {
    checkDisposed();
    developer.setProject(this);
  }
  
  /**
   * Removes the given developer from this object. <p>
   * 
   */
  public void removeFromDevelopers(final Developer developer) {
    checkDisposed();
    developer.setProject(null);
  }
  
  void internalAddToDevelopers(final Developer developer) {
    internalGetDevelopers().add(developer);
  }
  
  void internalRemoveFromDevelopers(final Developer developer) {
    internalGetDevelopers().remove(developer);
  }
  
  /**
   * Returns the manager property or <code>null</code> if not present.
   */
  public Manager getManager() {
    checkDisposed();
    return this.manager;
  }
  
  /**
   * Sets the manager property to this instance.
   * Since the reference is a container reference, the opposite reference (Manager.projects)
   * of the manager will be handled automatically and no further coding is required to keep them in sync.
   * See {@link Manager#setProjects(Manager)}.
   */
  public void setManager(final Manager manager) {
    checkDisposed();
    if (this.manager != null) {
      this.manager.internalRemoveFromProjects(this);
    }
    this.manager = manager;
    if (this.manager != null) {
      this.manager.internalAddToProjects(this);
    }
    
  }
}

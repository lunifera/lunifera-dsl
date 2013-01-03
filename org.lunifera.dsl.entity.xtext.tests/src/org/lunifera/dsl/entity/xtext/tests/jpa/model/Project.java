package org.lunifera.dsl.entity.xtext.tests.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project {
  private boolean disposed;
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  @Id
  private long id;
  
  @Column
  private String name;
  
  private boolean settingContract;
  
  @JoinColumn
  @OneToOne(optional = false)
  private Contract contract;
  
  @JoinColumn
  @OneToMany(mappedBy = "project")
  private List<Developer> developers;
  
  @JoinColumn
  @ManyToOne
  private Manager manager;
  
  /**
   * Returns true, if the object is disposed. Disposed means, that it is
   * prepared for garbage collection and may not be used anymore. Accessing
   * objects that are already disposed will cause runtime exceptions.
   * 
   * @return true if the object is disposed and false otherwise
   */
  public boolean isDisposed() {
    return this.disposed;
  }
  
  /**
   * Checks whether the object is disposed.
   * 
   * @throws RuntimeException if the object is disposed.
   * 
   */
  private void checkDisposed() {
    if (isDisposed()) {
    	throw new RuntimeException(String.format(
    			"Object already disposed: {}", this.toString()));
    }
    
  }
  
  /**
   * Calling dispose will destroy that instance. The internal state will be 
   * set to 'disposed' and methods of that object must not be used anymore. 
   * Each call will result in runtime exceptions.<br>
   * If this object keeps containment references, these will be disposed too. 
   * So the whole containment tree will be disposed on calling this method.
   * 
   */
  public void dispose() {
    if(isDisposed()){
    	return;
    }
    
    disposed = true;
    
  }
  
  /**
   * Returns the id property or <code>null</code> if not present.
   * 
   * @return id
   */
  public long getId() {
    checkDisposed();
    
    return this.id;
  }
  
  /**
   * Sets the id property to this instance.
   * 
   * @param id
   */
  public void setId(final long id) {
    checkDisposed();
    
    this.id = id;
  }
  
  /**
   * Returns the name property or <code>null</code> if not present.
   * 
   * @return name
   */
  public String getName() {
    checkDisposed();
    
    return this.name;
  }
  
  /**
   * Sets the name property to this instance.
   * 
   * @param name
   */
  public void setName(final String name) {
    checkDisposed();
    
    this.name = name;
  }
  
  /**
   * Returns the contract reference or <code>null</code> if not present.
   * 
   * @return contract
   */
  public Contract getContract() {
    checkDisposed();
    
    return this.contract;
  }
  
  /**
   * Sets the contract reference to this instance.
   * 
   * Since the reference is a container reference, the opposite reference (Contract.project) 
   * of the contract will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Contract#setProject(Contract)}.
   * 
   * @param contract
   */
  public void setContract(final Contract contract) {
    checkDisposed();
    
    if (settingContract) {
    	// avoid loops
    	return;
    }
    
    Contract oldContract = this.contract;
    
    // if the parent does not change, we can leave
    if (oldContract == contract) {
    	return;
    }
    
    try {
    // avoid loops
    settingContract = true;
    	// First remove the element
    	if (oldContract != null) {
    		oldContract.setProject(null);
    	}
    	
    	// Then assign the new value
    	this.contract = contract;
    	
    	// Then add 'this' to the new value
    	if (this.contract != null) {
    		this.contract.setProject(this);
    	}
    } finally {
    	settingContract = false;
    }
    
  }
  
  /**
   * Returns an unmodifiable list of developers.
   * 
   * @return developers
   */
  public List<Developer> getDevelopers() {
    checkDisposed();
    
    ensureDevelopers();
    return java.util.Collections.unmodifiableList(this.developers);
  }
  
  /**
   * Adds the given developer to this object. <p>
   * 
   * @param developer
   */
  public void addDevelopers(final Developer developer) {
    checkDisposed();
    
    // If developer is null, we do not add it
    if(developer==null){
    	return;
    }
    
    ensureDevelopers();
    
    // Adds the parameter to the list
    if(!this.developers.contains(developer)){
    	this.developers.add(developer);
    }
  }
  
  /**
   * Removes the given developer from this object.
   * 
   * @param developer
   */
  public void removeDevelopers(final Developer developer) {
    checkDisposed();
    
    // If developer or the developers are null, we can leave
    if(developer==null || this.developers==null){
    	return;
    }
    
    this.developers.remove(developer);
  }
  
  /**
   * Ensures that the list of developers is created. It will be instantiated 
   * lazy.
   */
  private void ensureDevelopers() {
    if (this.developers == null) {
    	this.developers = new java.util.ArrayList<Developer>();
    }
  }
  
  /**
   * Returns the manager reference or <code>null</code> if not present.
   * 
   * @return manager
   */
  public Manager getManager() {
    checkDisposed();
    
    return this.manager;
  }
  
  /**
   * Sets the manager reference to this instance.
   * 
   * @param manager
   */
  public void setManager(final Manager manager) {
    checkDisposed();
    
    this.manager = manager;
  }
}

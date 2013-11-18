package org.lunifera.dsl.entity.xtext.tests.jpa.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Contract;

/**
 * Test 112233
 */
@Entity
public class Client {
  private boolean disposed;
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private Long id;
  
  @Column
  private String name;
  
  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Contract> contracts;
  
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
      if (this.contracts != null) {
        for (Contract contract : this.contracts) {
          contract.dispose();
        }
        this.contracts = null;
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
   * Returns an unmodifiable list of contracts.
   */
  public List<Contract> getContracts() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetContracts());
  }
  
  /**
   * Returns the list of <code>Contract</code>s thereby lazy initializing it.
   */
  private List<Contract> internalGetContracts() {
    if (this.contracts == null) {
      this.contracts = new ArrayList<Contract>();
    }
    return this.contracts;
  }
  
  /**
   * Adds the given contract to this object. <p>
   * Since the reference is a composition reference, the opposite reference (Contract.client)
   * of the contract will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Contract#setClient(Contract)}.
   * 
   */
  public void addToContracts(final Contract contract) {
    checkDisposed();
    contract.setClient(this);
  }
  
  /**
   * Removes the given contract from this object. <p>
   * Since the reference is a composition reference, the opposite reference (Contract.client)
   * of the contract will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Contract#setClient(Contract)}.
   * 
   */
  public void removeFromContracts(final Contract contract) {
    checkDisposed();
    contract.setClient(null);
  }
  
  void internalAddToContracts(final Contract contract) {
    internalGetContracts().add(contract);
  }
  
  void internalRemoveFromContracts(final Contract contract) {
    internalGetContracts().remove(contract);
  }
}

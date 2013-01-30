package org.lunifera.dsl.entity.xtext.tests.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Project;

@Entity
public class Developer {
  private boolean disposed;
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private Long id;
  
  @Column
  private String name;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PROJECT")
  private Project project;
  
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
    disposed = true;
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
   * Returns the project property or <code>null</code> if not present.
   */
  public Project getProject() {
    checkDisposed();
    return this.project;
  }
  
  /**
   * Sets the project property to this instance.
   * Since the reference is a container reference, the opposite reference (Project.developers)
   * of the project will be handled automatically and no further coding is required to keep them in sync.
   * See {@link Project#setDevelopers(Project)}.
   */
  public void setProject(final Project project) {
    checkDisposed();
    if (this.project != null) {
      this.project.internalRemoveFromDevelopers(this);
    }
    this.project = project;
    if (this.project != null) {
      this.project.internalAddToDevelopers(this);
    }
    
  }
}

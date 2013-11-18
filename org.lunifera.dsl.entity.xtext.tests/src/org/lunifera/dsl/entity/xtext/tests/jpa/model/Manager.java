package org.lunifera.dsl.entity.xtext.tests.jpa.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.lunifera.dsl.entity.xtext.tests.jpa.model.Project;

@Entity
public class Manager {
  private boolean disposed;
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private Long id;
  
  @Column
  private String name;
  
  @OneToMany(mappedBy = "manager")
  private List<Project> projects;
  
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
   * Returns an unmodifiable list of projects.
   */
  public List<Project> getProjects() {
    checkDisposed();
    return Collections.unmodifiableList(internalGetProjects());
  }
  
  /**
   * Returns the list of <code>Project</code>s thereby lazy initializing it.
   */
  private List<Project> internalGetProjects() {
    if (this.projects == null) {
      this.projects = new ArrayList<Project>();
    }
    return this.projects;
  }
  
  /**
   * Adds the given project to this object. <p>
   * Since the reference is a composition reference, the opposite reference (Project.manager)
   * of the project will be handled automatically and no further coding is required to keep them in sync. 
   * See {@link Project#setManager(Project)}.
   * 
   */
  public void addToProjects(final Project project) {
    checkDisposed();
    project.setManager(this);
  }
  
  /**
   * Removes the given project from this object. <p>
   * 
   */
  public void removeFromProjects(final Project project) {
    checkDisposed();
    project.setManager(null);
  }
  
  void internalAddToProjects(final Project project) {
    internalGetProjects().add(project);
  }
  
  void internalRemoveFromProjects(final Project project) {
    internalGetProjects().remove(project);
  }
  
  public int getProjectsCount() {
    int _xifexpression = (int) 0;
    boolean _notEquals = ObjectExtensions.operator_notEquals(this.projects, null);
    if (_notEquals) {
      int _size = this.projects.size();
      _xifexpression = _size;
    } else {
      _xifexpression = 0;
    }
    return _xifexpression;
  }
}

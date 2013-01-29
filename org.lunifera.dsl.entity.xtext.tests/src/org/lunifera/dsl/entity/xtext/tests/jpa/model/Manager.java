package org.lunifera.dsl.entity.xtext.tests.jpa.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.lunifera.dsl.entity.xtext.tests.jpa.model.Project;

@Entity
public class Manager {
  private boolean disposed;
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  @Id
  private long id;
  
  @Column
  private String name;
  
  @JoinColumn
  @OneToMany(mappedBy = "manager")
  private List<Project> projects;
  
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
   * Returns an unmodifiable list of projects.
   * 
   * @return projects
   */
  public List<Project> getProjects() {
    checkDisposed();
    
    ensureProjects();
    return java.util.Collections.unmodifiableList(this.projects);
  }
  
  /**
   * Adds the given project to this object. <p>
   * 
   * @param project
   */
  public void addProjects(final Project project) {
    checkDisposed();
    
    // If project is null, we do not add it
    if(project==null){
    	return;
    }
    
    ensureProjects();
    
    // Adds the parameter to the list
    if(!this.projects.contains(project)){
    	this.projects.add(project);
    }
  }
  
  /**
   * Removes the given project from this object.
   * 
   * @param project
   */
  public void removeProjects(final Project project) {
    checkDisposed();
    
    // If project or the projects are null, we can leave
    if(project==null || this.projects==null){
    	return;
    }
    
    this.projects.remove(project);
  }
  
  /**
   * Ensures that the list of projects is created. It will be instantiated 
   * lazy.
   */
  private void ensureProjects() {
    if (this.projects == null) {
    	this.projects = new java.util.ArrayList<Project>();
    }
  }
  
  public int getProjectsCount() {
    List<Project> _projects = this.getProjects();
    int _size = _projects.size();
    return _size;
  }
}

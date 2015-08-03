/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.classinheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.lunifera.dsl.common.datatypes.IEntity;
import org.lunifera.dsl.entity.xtext.tests.classinheritance.OneByClass;
import org.lunifera.runtime.common.annotations.Dispose;

@Entity
@DiscriminatorValue(value = "TWO_BY_CLASS")
@SuppressWarnings("all")
public class TwoByClass extends OneByClass implements IEntity {
  @Column(name = "STUFF")
  private Long stuff;
  
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
  @Dispose
  public void dispose() {
    if (isDisposed()) {
      return;
    }
    super.dispose();
  }
  
  /**
   * Returns the stuff property or <code>null</code> if not present.
   */
  public Long getStuff() {
    checkDisposed();
    return this.stuff;
  }
  
  /**
   * Sets the stuff property to this instance.
   */
  public void setStuff(final Long stuff) {
    checkDisposed();
    this.stuff = stuff;
  }
}

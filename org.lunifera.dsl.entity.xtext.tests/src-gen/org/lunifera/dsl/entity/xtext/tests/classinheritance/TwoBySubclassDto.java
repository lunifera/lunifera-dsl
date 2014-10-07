/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.lunifera.dsl.entity.xtext.tests.classinheritance;

import java.io.Serializable;

@SuppressWarnings("all")
public class TwoBySubclassDto implements org.lunifera.dsl.entity.xtext.tests.classinheritance.OneBySubclassDto, Serializable {
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
   * Sets the <code>stuff</code> property to this instance.
   * 
   * @param stuff - the property
   * @throws RuntimeException if instance is <code>disposed</code>
   * 
   */
  public void setStuff(final Long stuff) {
    firePropertyChange("stuff", this.stuff, this.stuff = stuff );
  }
}

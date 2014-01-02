/**
 */
package org.lunifera.dsl.semantic.entity;

import org.lunifera.dsl.semantic.common.types.LFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LEntity Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityFeature#getPersistenceInfo <em>Persistence Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLEntityFeature()
 * @model
 * @generated
 */
public interface LEntityFeature extends LFeature
{
  /**
   * Returns the value of the '<em><b>Persistence Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Persistence Info</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Persistence Info</em>' containment reference.
   * @see #setPersistenceInfo(LEntityColumnPersistenceInfo)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLEntityFeature_PersistenceInfo()
   * @model containment="true"
   * @generated
   */
  LEntityColumnPersistenceInfo getPersistenceInfo();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityFeature#getPersistenceInfo <em>Persistence Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Persistence Info</em>' containment reference.
   * @see #getPersistenceInfo()
   * @generated
   */
  void setPersistenceInfo(LEntityColumnPersistenceInfo value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.ecore.EObject%> _eContainer = this.eContainer();\nreturn ((<%org.lunifera.dsl.semantic.entity.LEntity%>) _eContainer);'"
   * @generated
   */
  LEntity getEntity();

} // LEntityFeature

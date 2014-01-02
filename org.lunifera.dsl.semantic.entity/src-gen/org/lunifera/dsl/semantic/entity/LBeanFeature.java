/**
 */
package org.lunifera.dsl.semantic.entity;

import org.lunifera.dsl.semantic.common.types.LFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LBean Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLBeanFeature()
 * @model
 * @generated
 */
public interface LBeanFeature extends LFeature
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.ecore.EObject%> _eContainer = this.eContainer();\nreturn ((<%org.lunifera.dsl.semantic.entity.LBean%>) _eContainer);'"
   * @generated
   */
  LBean getBean();

} // LBeanFeature

/**
 */
package org.lunifera.dsl.semantic.dto;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.dto.DtoPackage
 * @generated
 */
public interface DtoFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DtoFactory eINSTANCE = org.lunifera.dsl.semantic.dto.impl.DtoFactoryImpl.init();

  /**
   * Returns a new object of class '<em>LDto Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDto Model</em>'.
   * @generated
   */
  LDtoModel createLDtoModel();

  /**
   * Returns a new object of class '<em>LDto</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDto</em>'.
   * @generated
   */
  LDto createLDto();

  /**
   * Returns a new object of class '<em>LDto Mapper</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDto Mapper</em>'.
   * @generated
   */
  LDtoMapper createLDtoMapper();

  /**
   * Returns a new object of class '<em>LDto Feature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDto Feature</em>'.
   * @generated
   */
  LDtoFeature createLDtoFeature();

  /**
   * Returns a new object of class '<em>LDto Inherited Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDto Inherited Attribute</em>'.
   * @generated
   */
  LDtoInheritedAttribute createLDtoInheritedAttribute();

  /**
   * Returns a new object of class '<em>LDto Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDto Attribute</em>'.
   * @generated
   */
  LDtoAttribute createLDtoAttribute();

  /**
   * Returns a new object of class '<em>LDto Inherited Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDto Inherited Reference</em>'.
   * @generated
   */
  LDtoInheritedReference createLDtoInheritedReference();

  /**
   * Returns a new object of class '<em>LDto Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDto Reference</em>'.
   * @generated
   */
  LDtoReference createLDtoReference();

  /**
   * Returns a new object of class '<em>LDto Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LDto Operation</em>'.
   * @generated
   */
  LDtoOperation createLDtoOperation();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DtoPackage getDtoPackage();

} //DtoFactory

/**
 */
package org.lunifera.dsl.component.semantic.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.component.semantic.model.ComponentFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.lunifera.org/dsl/component/v1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentPackage eINSTANCE = org.lunifera.dsl.component.semantic.model.impl.ComponentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.component.semantic.model.impl.ComponentModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.component.semantic.model.impl.ComponentModelImpl
	 * @see org.lunifera.dsl.component.semantic.model.impl.ComponentPackageImpl#getComponentModel()
	 * @generated
	 */
	int COMPONENT_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Unit Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__UNIT_TYPES = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.component.semantic.model.impl.UnitTypeImpl <em>Unit Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.component.semantic.model.impl.UnitTypeImpl
	 * @see org.lunifera.dsl.component.semantic.model.impl.ComponentPackageImpl#getUnitType()
	 * @generated
	 */
	int UNIT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.component.semantic.model.ComponentModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.lunifera.dsl.component.semantic.model.ComponentModel
	 * @generated
	 */
	EClass getComponentModel();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.component.semantic.model.ComponentModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.component.semantic.model.ComponentModel#getName()
	 * @see #getComponentModel()
	 * @generated
	 */
	EAttribute getComponentModel_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.component.semantic.model.ComponentModel#getUnitTypes <em>Unit Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit Types</em>'.
	 * @see org.lunifera.dsl.component.semantic.model.ComponentModel#getUnitTypes()
	 * @see #getComponentModel()
	 * @generated
	 */
	EReference getComponentModel_UnitTypes();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.component.semantic.model.UnitType <em>Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Type</em>'.
	 * @see org.lunifera.dsl.component.semantic.model.UnitType
	 * @generated
	 */
	EClass getUnitType();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.component.semantic.model.UnitType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.lunifera.dsl.component.semantic.model.UnitType#getName()
	 * @see #getUnitType()
	 * @generated
	 */
	EAttribute getUnitType_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentFactory getComponentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.component.semantic.model.impl.ComponentModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.component.semantic.model.impl.ComponentModelImpl
		 * @see org.lunifera.dsl.component.semantic.model.impl.ComponentPackageImpl#getComponentModel()
		 * @generated
		 */
		EClass COMPONENT_MODEL = eINSTANCE.getComponentModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_MODEL__NAME = eINSTANCE.getComponentModel_Name();

		/**
		 * The meta object literal for the '<em><b>Unit Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_MODEL__UNIT_TYPES = eINSTANCE.getComponentModel_UnitTypes();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.component.semantic.model.impl.UnitTypeImpl <em>Unit Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.component.semantic.model.impl.UnitTypeImpl
		 * @see org.lunifera.dsl.component.semantic.model.impl.ComponentPackageImpl#getUnitType()
		 * @generated
		 */
		EClass UNIT_TYPE = eINSTANCE.getUnitType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_TYPE__NAME = eINSTANCE.getUnitType_Name();

	}

} //ComponentPackage

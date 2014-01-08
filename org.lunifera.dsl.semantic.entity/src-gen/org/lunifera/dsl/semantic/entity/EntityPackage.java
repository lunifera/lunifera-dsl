/**
 */
package org.lunifera.dsl.semantic.entity;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

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
 * @see org.lunifera.dsl.semantic.entity.EntityFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel fileExtensions='entitymodel' modelName='Entity' prefix='Entity' basePackage='org.lunifera.dsl.semantic'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore rootPackage='entity'"
 * @generated
 */
public interface EntityPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "entity";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.lunifera.org/dsl/entity/v1";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "entity";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EntityPackage eINSTANCE = org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl.init();

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityModelImpl <em>LEntity Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LEntityModelImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityModel()
   * @generated
   */
  int LENTITY_MODEL = 0;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_MODEL__PACKAGES = 0;

  /**
   * The number of structural features of the '<em>LEntity Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_MODEL_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>LEntity Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_MODEL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LBeanImpl <em>LBean</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LBeanImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLBean()
   * @generated
   */
  int LBEAN = 1;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN__ANNOTATIONS = LunTypesPackage.LCLASS__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN__NAME = LunTypesPackage.LCLASS__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN__ANNOTATION_INFO = LunTypesPackage.LCLASS__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN__ABSTRACT = LunTypesPackage.LCLASS__ABSTRACT;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN__SERIALIZABLE = LunTypesPackage.LCLASS__SERIALIZABLE;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN__SHORT_NAME = LunTypesPackage.LCLASS__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN__FEATURES = LunTypesPackage.LCLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN__SUPER_TYPE = LunTypesPackage.LCLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Sub Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN__SUB_TYPES = LunTypesPackage.LCLASS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>LBean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_FEATURE_COUNT = LunTypesPackage.LCLASS_FEATURE_COUNT + 3;

  /**
   * The operation id for the '<em>Get Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN___GET_FEATURES = LunTypesPackage.LCLASS_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Operations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN___GET_OPERATIONS = LunTypesPackage.LCLASS_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Get References</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN___GET_REFERENCES = LunTypesPackage.LCLASS_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN___GET_ATTRIBUTES = LunTypesPackage.LCLASS_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Get All Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN___GET_ALL_FEATURES = LunTypesPackage.LCLASS_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get All Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN___GET_ALL_ATTRIBUTES = LunTypesPackage.LCLASS_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Get All References</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN___GET_ALL_REFERENCES = LunTypesPackage.LCLASS_OPERATION_COUNT + 7;

  /**
   * The operation id for the '<em>Collect All Lun Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN___COLLECT_ALL_LUN_FEATURES__LBEAN_LIST = LunTypesPackage.LCLASS_OPERATION_COUNT + 8;

  /**
   * The number of operations of the '<em>LBean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_OPERATION_COUNT = LunTypesPackage.LCLASS_OPERATION_COUNT + 9;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl <em>LEntity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LEntityImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntity()
   * @generated
   */
  int LENTITY = 2;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__ANNOTATIONS = LunTypesPackage.LCLASS__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__NAME = LunTypesPackage.LCLASS__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__ANNOTATION_INFO = LunTypesPackage.LCLASS__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__ABSTRACT = LunTypesPackage.LCLASS__ABSTRACT;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__SERIALIZABLE = LunTypesPackage.LCLASS__SERIALIZABLE;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__SHORT_NAME = LunTypesPackage.LCLASS__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Cacheable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__CACHEABLE = LunTypesPackage.LCLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Historized</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__HISTORIZED = LunTypesPackage.LCLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mapped Superclass</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__MAPPED_SUPERCLASS = LunTypesPackage.LCLASS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Persistence Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__PERSISTENCE_INFO = LunTypesPackage.LCLASS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Inheritance Strategy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__INHERITANCE_STRATEGY = LunTypesPackage.LCLASS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__FEATURES = LunTypesPackage.LCLASS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__INDEXES = LunTypesPackage.LCLASS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__SUPER_TYPE = LunTypesPackage.LCLASS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Sub Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY__SUB_TYPES = LunTypesPackage.LCLASS_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>LEntity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_FEATURE_COUNT = LunTypesPackage.LCLASS_FEATURE_COUNT + 9;

  /**
   * The operation id for the '<em>Get Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY___GET_FEATURES = LunTypesPackage.LCLASS_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Operations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY___GET_OPERATIONS = LunTypesPackage.LCLASS_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Get References</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY___GET_REFERENCES = LunTypesPackage.LCLASS_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY___GET_ATTRIBUTES = LunTypesPackage.LCLASS_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Get All Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY___GET_ALL_FEATURES = LunTypesPackage.LCLASS_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get All Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY___GET_ALL_ATTRIBUTES = LunTypesPackage.LCLASS_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Get All References</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY___GET_ALL_REFERENCES = LunTypesPackage.LCLASS_OPERATION_COUNT + 7;

  /**
   * The operation id for the '<em>Collect All Lun Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY___COLLECT_ALL_LUN_FEATURES__LENTITY_LIST = LunTypesPackage.LCLASS_OPERATION_COUNT + 8;

  /**
   * The number of operations of the '<em>LEntity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_OPERATION_COUNT = LunTypesPackage.LCLASS_OPERATION_COUNT + 9;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityPersistenceInfoImpl <em>LEntity Persistence Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LEntityPersistenceInfoImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityPersistenceInfo()
   * @generated
   */
  int LENTITY_PERSISTENCE_INFO = 3;

  /**
   * The feature id for the '<em><b>Schema Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_PERSISTENCE_INFO__SCHEMA_NAME = 0;

  /**
   * The feature id for the '<em><b>Table Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_PERSISTENCE_INFO__TABLE_NAME = 1;

  /**
   * The number of structural features of the '<em>LEntity Persistence Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_PERSISTENCE_INFO_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>LEntity Persistence Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_PERSISTENCE_INFO_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityColumnPersistenceInfoImpl <em>LEntity Column Persistence Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LEntityColumnPersistenceInfoImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityColumnPersistenceInfo()
   * @generated
   */
  int LENTITY_COLUMN_PERSISTENCE_INFO = 4;

  /**
   * The feature id for the '<em><b>Column Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_COLUMN_PERSISTENCE_INFO__COLUMN_NAME = 0;

  /**
   * The number of structural features of the '<em>LEntity Column Persistence Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_COLUMN_PERSISTENCE_INFO_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>LEntity Column Persistence Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_COLUMN_PERSISTENCE_INFO_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy <em>LEntity Inheritance Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityInheritanceStrategy()
   * @generated
   */
  int LENTITY_INHERITANCE_STRATEGY = 5;

  /**
   * The number of structural features of the '<em>LEntity Inheritance Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_INHERITANCE_STRATEGY_FEATURE_COUNT = 0;

  /**
   * The number of operations of the '<em>LEntity Inheritance Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_INHERITANCE_STRATEGY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LTablePerClassStrategyImpl <em>LTable Per Class Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LTablePerClassStrategyImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLTablePerClassStrategy()
   * @generated
   */
  int LTABLE_PER_CLASS_STRATEGY = 6;

  /**
   * The feature id for the '<em><b>Discriminator Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_COLUMN = LENTITY_INHERITANCE_STRATEGY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Discriminator Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_TYPE = LENTITY_INHERITANCE_STRATEGY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Discriminator Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_VALUE = LENTITY_INHERITANCE_STRATEGY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>LTable Per Class Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_CLASS_STRATEGY_FEATURE_COUNT = LENTITY_INHERITANCE_STRATEGY_FEATURE_COUNT + 3;

  /**
   * The number of operations of the '<em>LTable Per Class Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_CLASS_STRATEGY_OPERATION_COUNT = LENTITY_INHERITANCE_STRATEGY_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LTablePerSubclassStrategyImpl <em>LTable Per Subclass Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LTablePerSubclassStrategyImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLTablePerSubclassStrategy()
   * @generated
   */
  int LTABLE_PER_SUBCLASS_STRATEGY = 7;

  /**
   * The feature id for the '<em><b>Discriminator Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_COLUMN = LENTITY_INHERITANCE_STRATEGY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Discriminator Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_TYPE = LENTITY_INHERITANCE_STRATEGY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Discriminator Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_VALUE = LENTITY_INHERITANCE_STRATEGY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>LTable Per Subclass Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_SUBCLASS_STRATEGY_FEATURE_COUNT = LENTITY_INHERITANCE_STRATEGY_FEATURE_COUNT + 3;

  /**
   * The number of operations of the '<em>LTable Per Subclass Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTABLE_PER_SUBCLASS_STRATEGY_OPERATION_COUNT = LENTITY_INHERITANCE_STRATEGY_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityFeatureImpl <em>LEntity Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LEntityFeatureImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityFeature()
   * @generated
   */
  int LENTITY_FEATURE = 8;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_FEATURE__ANNOTATIONS = LunTypesPackage.LFEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_FEATURE__NAME = LunTypesPackage.LFEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_FEATURE__MULTIPLICITY = LunTypesPackage.LFEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_FEATURE__ANNOTATION_INFO = LunTypesPackage.LFEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Persistence Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_FEATURE__PERSISTENCE_INFO = LunTypesPackage.LFEATURE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>LEntity Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_FEATURE_FEATURE_COUNT = LunTypesPackage.LFEATURE_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Entity</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_FEATURE___GET_ENTITY = LunTypesPackage.LFEATURE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>LEntity Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_FEATURE_OPERATION_COUNT = LunTypesPackage.LFEATURE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityAttributeImpl <em>LEntity Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LEntityAttributeImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityAttribute()
   * @generated
   */
  int LENTITY_ATTRIBUTE = 9;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__ANNOTATIONS = LENTITY_FEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__NAME = LENTITY_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__MULTIPLICITY = LENTITY_FEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__ANNOTATION_INFO = LENTITY_FEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Persistence Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__PERSISTENCE_INFO = LENTITY_FEATURE__PERSISTENCE_INFO;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__ID = LENTITY_FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__VERSION = LENTITY_FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__LAZY = LENTITY_FEATURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__CASCADING = LENTITY_FEATURE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__TRANSIENT = LENTITY_FEATURE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__TYPE = LENTITY_FEATURE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Uuid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE__UUID = LENTITY_FEATURE_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>LEntity Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE_FEATURE_COUNT = LENTITY_FEATURE_FEATURE_COUNT + 7;

  /**
   * The operation id for the '<em>Get Entity</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE___GET_ENTITY = LENTITY_FEATURE___GET_ENTITY;

  /**
   * The number of operations of the '<em>LEntity Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_ATTRIBUTE_OPERATION_COUNT = LENTITY_FEATURE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityReferenceImpl <em>LEntity Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LEntityReferenceImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityReference()
   * @generated
   */
  int LENTITY_REFERENCE = 10;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE__ANNOTATIONS = LENTITY_FEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE__NAME = LENTITY_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE__MULTIPLICITY = LENTITY_FEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE__ANNOTATION_INFO = LENTITY_FEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Persistence Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE__PERSISTENCE_INFO = LENTITY_FEATURE__PERSISTENCE_INFO;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE__LAZY = LENTITY_FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE__CASCADING = LENTITY_FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE__TYPE = LENTITY_FEATURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE__OPPOSITE = LENTITY_FEATURE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>LEntity Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE_FEATURE_COUNT = LENTITY_FEATURE_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Get Entity</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE___GET_ENTITY = LENTITY_FEATURE___GET_ENTITY;

  /**
   * The number of operations of the '<em>LEntity Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENTITY_REFERENCE_OPERATION_COUNT = LENTITY_FEATURE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LBeanFeatureImpl <em>LBean Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LBeanFeatureImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLBeanFeature()
   * @generated
   */
  int LBEAN_FEATURE = 11;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_FEATURE__ANNOTATIONS = LunTypesPackage.LFEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_FEATURE__NAME = LunTypesPackage.LFEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_FEATURE__MULTIPLICITY = LunTypesPackage.LFEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_FEATURE__ANNOTATION_INFO = LunTypesPackage.LFEATURE__ANNOTATION_INFO;

  /**
   * The number of structural features of the '<em>LBean Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_FEATURE_FEATURE_COUNT = LunTypesPackage.LFEATURE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Bean</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_FEATURE___GET_BEAN = LunTypesPackage.LFEATURE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>LBean Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_FEATURE_OPERATION_COUNT = LunTypesPackage.LFEATURE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl <em>LBean Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLBeanAttribute()
   * @generated
   */
  int LBEAN_ATTRIBUTE = 12;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__ANNOTATIONS = LBEAN_FEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__NAME = LBEAN_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__MULTIPLICITY = LBEAN_FEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__ANNOTATION_INFO = LBEAN_FEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__ID = LBEAN_FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__VERSION = LBEAN_FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__LAZY = LBEAN_FEATURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__CASCADING = LBEAN_FEATURE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__TRANSIENT = LBEAN_FEATURE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE__TYPE = LBEAN_FEATURE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>LBean Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE_FEATURE_COUNT = LBEAN_FEATURE_FEATURE_COUNT + 6;

  /**
   * The operation id for the '<em>Get Bean</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE___GET_BEAN = LBEAN_FEATURE___GET_BEAN;

  /**
   * The number of operations of the '<em>LBean Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_ATTRIBUTE_OPERATION_COUNT = LBEAN_FEATURE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LBeanReferenceImpl <em>LBean Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LBeanReferenceImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLBeanReference()
   * @generated
   */
  int LBEAN_REFERENCE = 13;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE__ANNOTATIONS = LBEAN_FEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE__NAME = LBEAN_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE__MULTIPLICITY = LBEAN_FEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE__ANNOTATION_INFO = LBEAN_FEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE__LAZY = LBEAN_FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE__CASCADING = LBEAN_FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE__TYPE = LBEAN_FEATURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE__OPPOSITE = LBEAN_FEATURE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>LBean Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE_FEATURE_COUNT = LBEAN_FEATURE_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Get Bean</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE___GET_BEAN = LBEAN_FEATURE___GET_BEAN;

  /**
   * The number of operations of the '<em>LBean Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LBEAN_REFERENCE_OPERATION_COUNT = LBEAN_FEATURE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LIndexImpl <em>LIndex</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LIndexImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLIndex()
   * @generated
   */
  int LINDEX = 14;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINDEX__UNIQUE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINDEX__NAME = 1;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINDEX__FEATURES = 2;

  /**
   * The number of structural features of the '<em>LIndex</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINDEX_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>LIndex</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINDEX_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.impl.LOperationImpl <em>LOperation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.impl.LOperationImpl
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLOperation()
   * @generated
   */
  int LOPERATION = 15;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__ANNOTATIONS = LunTypesPackage.LOPERATION__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__MODIFIER = LunTypesPackage.LOPERATION__MODIFIER;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__TYPE = LunTypesPackage.LOPERATION__TYPE;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__PARAMS = LunTypesPackage.LOPERATION__PARAMS;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__BODY = LunTypesPackage.LOPERATION__BODY;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__NAME = LunTypesPackage.LOPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__MULTIPLICITY = LunTypesPackage.LOPERATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__ANNOTATION_INFO = LunTypesPackage.LOPERATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Persistence Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__PERSISTENCE_INFO = LunTypesPackage.LOPERATION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>LOperation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION_FEATURE_COUNT = LunTypesPackage.LOPERATION_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Get Bean</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION___GET_BEAN = LunTypesPackage.LOPERATION_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Entity</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION___GET_ENTITY = LunTypesPackage.LOPERATION_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>LOperation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION_OPERATION_COUNT = LunTypesPackage.LOPERATION_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.entity.LDiscriminatorType <em>LDiscriminator Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.entity.LDiscriminatorType
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLDiscriminatorType()
   * @generated
   */
  int LDISCRIMINATOR_TYPE = 16;

  /**
   * The meta object id for the '<em>Operations List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getOperationsList()
   * @generated
   */
  int OPERATIONS_LIST = 17;

  /**
   * The meta object id for the '<em>Feature List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getEntityFeatureList()
   * @generated
   */
  int ENTITY_FEATURE_LIST = 18;

  /**
   * The meta object id for the '<em>Reference List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getEntityReferenceList()
   * @generated
   */
  int ENTITY_REFERENCE_LIST = 19;

  /**
   * The meta object id for the '<em>Attribute List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getEntityAttributeList()
   * @generated
   */
  int ENTITY_ATTRIBUTE_LIST = 20;

  /**
   * The meta object id for the '<em>Bean Feature List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getBeanFeatureList()
   * @generated
   */
  int BEAN_FEATURE_LIST = 21;

  /**
   * The meta object id for the '<em>Bean Reference List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getBeanReferenceList()
   * @generated
   */
  int BEAN_REFERENCE_LIST = 22;

  /**
   * The meta object id for the '<em>Bean Attribute List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getBeanAttributeList()
   * @generated
   */
  int BEAN_ATTRIBUTE_LIST = 23;


  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LEntityModel <em>LEntity Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEntity Model</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityModel
   * @generated
   */
  EClass getLEntityModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.entity.LEntityModel#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityModel#getPackages()
   * @see #getLEntityModel()
   * @generated
   */
  EReference getLEntityModel_Packages();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LBean <em>LBean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LBean</em>'.
   * @see org.lunifera.dsl.semantic.entity.LBean
   * @generated
   */
  EClass getLBean();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.entity.LBean#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.lunifera.dsl.semantic.entity.LBean#getFeatures()
   * @see #getLBean()
   * @generated
   */
  EReference getLBean_Features();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.entity.LBean#getSuperType <em>Super Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Super Type</em>'.
   * @see org.lunifera.dsl.semantic.entity.LBean#getSuperType()
   * @see #getLBean()
   * @generated
   */
  EReference getLBean_SuperType();

  /**
   * Returns the meta object for the reference list '{@link org.lunifera.dsl.semantic.entity.LBean#getSubTypes <em>Sub Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Sub Types</em>'.
   * @see org.lunifera.dsl.semantic.entity.LBean#getSubTypes()
   * @see #getLBean()
   * @generated
   */
  EReference getLBean_SubTypes();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LBean#getOperations() <em>Get Operations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Operations</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LBean#getOperations()
   * @generated
   */
  EOperation getLBean__GetOperations();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LBean#getReferences() <em>Get References</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get References</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LBean#getReferences()
   * @generated
   */
  EOperation getLBean__GetReferences();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LBean#getAttributes() <em>Get Attributes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Attributes</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LBean#getAttributes()
   * @generated
   */
  EOperation getLBean__GetAttributes();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LBean#getAllFeatures() <em>Get All Features</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Features</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LBean#getAllFeatures()
   * @generated
   */
  EOperation getLBean__GetAllFeatures();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LBean#getAllAttributes() <em>Get All Attributes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Attributes</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LBean#getAllAttributes()
   * @generated
   */
  EOperation getLBean__GetAllAttributes();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LBean#getAllReferences() <em>Get All References</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All References</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LBean#getAllReferences()
   * @generated
   */
  EOperation getLBean__GetAllReferences();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LBean#collectAllLunFeatures(org.lunifera.dsl.semantic.entity.LBean, java.util.List) <em>Collect All Lun Features</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Collect All Lun Features</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LBean#collectAllLunFeatures(org.lunifera.dsl.semantic.entity.LBean, java.util.List)
   * @generated
   */
  EOperation getLBean__CollectAllLunFeatures__LBean_List();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LEntity <em>LEntity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEntity</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity
   * @generated
   */
  EClass getLEntity();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LEntity#isCacheable <em>Cacheable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cacheable</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity#isCacheable()
   * @see #getLEntity()
   * @generated
   */
  EAttribute getLEntity_Cacheable();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LEntity#isHistorized <em>Historized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Historized</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity#isHistorized()
   * @see #getLEntity()
   * @generated
   */
  EAttribute getLEntity_Historized();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LEntity#isMappedSuperclass <em>Mapped Superclass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mapped Superclass</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity#isMappedSuperclass()
   * @see #getLEntity()
   * @generated
   */
  EAttribute getLEntity_MappedSuperclass();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.entity.LEntity#getPersistenceInfo <em>Persistence Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Persistence Info</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getPersistenceInfo()
   * @see #getLEntity()
   * @generated
   */
  EReference getLEntity_PersistenceInfo();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.entity.LEntity#getInheritanceStrategy <em>Inheritance Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inheritance Strategy</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getInheritanceStrategy()
   * @see #getLEntity()
   * @generated
   */
  EReference getLEntity_InheritanceStrategy();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.entity.LEntity#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getFeatures()
   * @see #getLEntity()
   * @generated
   */
  EReference getLEntity_Features();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.entity.LEntity#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Indexes</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getIndexes()
   * @see #getLEntity()
   * @generated
   */
  EReference getLEntity_Indexes();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.entity.LEntity#getSuperType <em>Super Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Super Type</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getSuperType()
   * @see #getLEntity()
   * @generated
   */
  EReference getLEntity_SuperType();

  /**
   * Returns the meta object for the reference list '{@link org.lunifera.dsl.semantic.entity.LEntity#getSubTypes <em>Sub Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Sub Types</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getSubTypes()
   * @see #getLEntity()
   * @generated
   */
  EReference getLEntity_SubTypes();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LEntity#getOperations() <em>Get Operations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Operations</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getOperations()
   * @generated
   */
  EOperation getLEntity__GetOperations();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LEntity#getReferences() <em>Get References</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get References</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getReferences()
   * @generated
   */
  EOperation getLEntity__GetReferences();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LEntity#getAttributes() <em>Get Attributes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Attributes</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getAttributes()
   * @generated
   */
  EOperation getLEntity__GetAttributes();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LEntity#getAllFeatures() <em>Get All Features</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Features</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getAllFeatures()
   * @generated
   */
  EOperation getLEntity__GetAllFeatures();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LEntity#getAllAttributes() <em>Get All Attributes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Attributes</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getAllAttributes()
   * @generated
   */
  EOperation getLEntity__GetAllAttributes();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LEntity#getAllReferences() <em>Get All References</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All References</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LEntity#getAllReferences()
   * @generated
   */
  EOperation getLEntity__GetAllReferences();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LEntity#collectAllLunFeatures(org.lunifera.dsl.semantic.entity.LEntity, java.util.List) <em>Collect All Lun Features</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Collect All Lun Features</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LEntity#collectAllLunFeatures(org.lunifera.dsl.semantic.entity.LEntity, java.util.List)
   * @generated
   */
  EOperation getLEntity__CollectAllLunFeatures__LEntity_List();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo <em>LEntity Persistence Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEntity Persistence Info</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo
   * @generated
   */
  EClass getLEntityPersistenceInfo();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo#getSchemaName <em>Schema Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Schema Name</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo#getSchemaName()
   * @see #getLEntityPersistenceInfo()
   * @generated
   */
  EAttribute getLEntityPersistenceInfo_SchemaName();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo#getTableName <em>Table Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Table Name</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityPersistenceInfo#getTableName()
   * @see #getLEntityPersistenceInfo()
   * @generated
   */
  EAttribute getLEntityPersistenceInfo_TableName();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo <em>LEntity Column Persistence Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEntity Column Persistence Info</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo
   * @generated
   */
  EClass getLEntityColumnPersistenceInfo();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo#getColumnName <em>Column Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Column Name</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo#getColumnName()
   * @see #getLEntityColumnPersistenceInfo()
   * @generated
   */
  EAttribute getLEntityColumnPersistenceInfo_ColumnName();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy <em>LEntity Inheritance Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEntity Inheritance Strategy</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy
   * @generated
   */
  EClass getLEntityInheritanceStrategy();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy <em>LTable Per Class Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LTable Per Class Strategy</em>'.
   * @see org.lunifera.dsl.semantic.entity.LTablePerClassStrategy
   * @generated
   */
  EClass getLTablePerClassStrategy();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorColumn <em>Discriminator Column</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Discriminator Column</em>'.
   * @see org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorColumn()
   * @see #getLTablePerClassStrategy()
   * @generated
   */
  EAttribute getLTablePerClassStrategy_DiscriminatorColumn();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorType <em>Discriminator Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Discriminator Type</em>'.
   * @see org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorType()
   * @see #getLTablePerClassStrategy()
   * @generated
   */
  EAttribute getLTablePerClassStrategy_DiscriminatorType();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorValue <em>Discriminator Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Discriminator Value</em>'.
   * @see org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorValue()
   * @see #getLTablePerClassStrategy()
   * @generated
   */
  EAttribute getLTablePerClassStrategy_DiscriminatorValue();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy <em>LTable Per Subclass Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LTable Per Subclass Strategy</em>'.
   * @see org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy
   * @generated
   */
  EClass getLTablePerSubclassStrategy();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy#getDiscriminatorColumn <em>Discriminator Column</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Discriminator Column</em>'.
   * @see org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy#getDiscriminatorColumn()
   * @see #getLTablePerSubclassStrategy()
   * @generated
   */
  EAttribute getLTablePerSubclassStrategy_DiscriminatorColumn();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy#getDiscriminatorType <em>Discriminator Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Discriminator Type</em>'.
   * @see org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy#getDiscriminatorType()
   * @see #getLTablePerSubclassStrategy()
   * @generated
   */
  EAttribute getLTablePerSubclassStrategy_DiscriminatorType();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy#getDiscriminatorValue <em>Discriminator Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Discriminator Value</em>'.
   * @see org.lunifera.dsl.semantic.entity.LTablePerSubclassStrategy#getDiscriminatorValue()
   * @see #getLTablePerSubclassStrategy()
   * @generated
   */
  EAttribute getLTablePerSubclassStrategy_DiscriminatorValue();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LEntityFeature <em>LEntity Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEntity Feature</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityFeature
   * @generated
   */
  EClass getLEntityFeature();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.entity.LEntityFeature#getPersistenceInfo <em>Persistence Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Persistence Info</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityFeature#getPersistenceInfo()
   * @see #getLEntityFeature()
   * @generated
   */
  EReference getLEntityFeature_PersistenceInfo();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LEntityFeature#getEntity() <em>Get Entity</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Entity</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LEntityFeature#getEntity()
   * @generated
   */
  EOperation getLEntityFeature__GetEntity();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LEntityAttribute <em>LEntity Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEntity Attribute</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityAttribute
   * @generated
   */
  EClass getLEntityAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LEntityAttribute#isUuid <em>Uuid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uuid</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityAttribute#isUuid()
   * @see #getLEntityAttribute()
   * @generated
   */
  EAttribute getLEntityAttribute_Uuid();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LEntityReference <em>LEntity Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEntity Reference</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityReference
   * @generated
   */
  EClass getLEntityReference();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.entity.LEntityReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityReference#getType()
   * @see #getLEntityReference()
   * @generated
   */
  EReference getLEntityReference_Type();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.entity.LEntityReference#getOpposite <em>Opposite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Opposite</em>'.
   * @see org.lunifera.dsl.semantic.entity.LEntityReference#getOpposite()
   * @see #getLEntityReference()
   * @generated
   */
  EReference getLEntityReference_Opposite();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LBeanFeature <em>LBean Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LBean Feature</em>'.
   * @see org.lunifera.dsl.semantic.entity.LBeanFeature
   * @generated
   */
  EClass getLBeanFeature();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.entity.LBeanFeature#getBean() <em>Get Bean</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Bean</em>' operation.
   * @see org.lunifera.dsl.semantic.entity.LBeanFeature#getBean()
   * @generated
   */
  EOperation getLBeanFeature__GetBean();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LBeanAttribute <em>LBean Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LBean Attribute</em>'.
   * @see org.lunifera.dsl.semantic.entity.LBeanAttribute
   * @generated
   */
  EClass getLBeanAttribute();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LBeanReference <em>LBean Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LBean Reference</em>'.
   * @see org.lunifera.dsl.semantic.entity.LBeanReference
   * @generated
   */
  EClass getLBeanReference();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.lunifera.dsl.semantic.entity.LBeanReference#getType()
   * @see #getLBeanReference()
   * @generated
   */
  EReference getLBeanReference_Type();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.entity.LBeanReference#getOpposite <em>Opposite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Opposite</em>'.
   * @see org.lunifera.dsl.semantic.entity.LBeanReference#getOpposite()
   * @see #getLBeanReference()
   * @generated
   */
  EReference getLBeanReference_Opposite();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LIndex <em>LIndex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LIndex</em>'.
   * @see org.lunifera.dsl.semantic.entity.LIndex
   * @generated
   */
  EClass getLIndex();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LIndex#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see org.lunifera.dsl.semantic.entity.LIndex#isUnique()
   * @see #getLIndex()
   * @generated
   */
  EAttribute getLIndex_Unique();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.entity.LIndex#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.lunifera.dsl.semantic.entity.LIndex#getName()
   * @see #getLIndex()
   * @generated
   */
  EAttribute getLIndex_Name();

  /**
   * Returns the meta object for the reference list '{@link org.lunifera.dsl.semantic.entity.LIndex#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Features</em>'.
   * @see org.lunifera.dsl.semantic.entity.LIndex#getFeatures()
   * @see #getLIndex()
   * @generated
   */
  EReference getLIndex_Features();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.entity.LOperation <em>LOperation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LOperation</em>'.
   * @see org.lunifera.dsl.semantic.entity.LOperation
   * @generated
   */
  EClass getLOperation();

  /**
   * Returns the meta object for enum '{@link org.lunifera.dsl.semantic.entity.LDiscriminatorType <em>LDiscriminator Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>LDiscriminator Type</em>'.
   * @see org.lunifera.dsl.semantic.entity.LDiscriminatorType
   * @generated
   */
  EEnum getLDiscriminatorType();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Operations List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Operations List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.entity.LOperation>"
   * @generated
   */
  EDataType getOperationsList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Feature List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Feature List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.entity.LEntityFeature>"
   * @generated
   */
  EDataType getEntityFeatureList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Reference List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Reference List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.entity.LEntityReference>"
   * @generated
   */
  EDataType getEntityReferenceList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Attribute List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Attribute List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.entity.LEntityAttribute>"
   * @generated
   */
  EDataType getEntityAttributeList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Bean Feature List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Bean Feature List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.entity.LBeanFeature>"
   * @generated
   */
  EDataType getBeanFeatureList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Bean Reference List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Bean Reference List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.entity.LBeanReference>"
   * @generated
   */
  EDataType getBeanReferenceList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Bean Attribute List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Bean Attribute List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.entity.LBeanAttribute>"
   * @generated
   */
  EDataType getBeanAttributeList();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EntityFactory getEntityFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityModelImpl <em>LEntity Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LEntityModelImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityModel()
     * @generated
     */
    EClass LENTITY_MODEL = eINSTANCE.getLEntityModel();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY_MODEL__PACKAGES = eINSTANCE.getLEntityModel_Packages();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LBeanImpl <em>LBean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LBeanImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLBean()
     * @generated
     */
    EClass LBEAN = eINSTANCE.getLBean();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LBEAN__FEATURES = eINSTANCE.getLBean_Features();

    /**
     * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LBEAN__SUPER_TYPE = eINSTANCE.getLBean_SuperType();

    /**
     * The meta object literal for the '<em><b>Sub Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LBEAN__SUB_TYPES = eINSTANCE.getLBean_SubTypes();

    /**
     * The meta object literal for the '<em><b>Get Operations</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LBEAN___GET_OPERATIONS = eINSTANCE.getLBean__GetOperations();

    /**
     * The meta object literal for the '<em><b>Get References</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LBEAN___GET_REFERENCES = eINSTANCE.getLBean__GetReferences();

    /**
     * The meta object literal for the '<em><b>Get Attributes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LBEAN___GET_ATTRIBUTES = eINSTANCE.getLBean__GetAttributes();

    /**
     * The meta object literal for the '<em><b>Get All Features</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LBEAN___GET_ALL_FEATURES = eINSTANCE.getLBean__GetAllFeatures();

    /**
     * The meta object literal for the '<em><b>Get All Attributes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LBEAN___GET_ALL_ATTRIBUTES = eINSTANCE.getLBean__GetAllAttributes();

    /**
     * The meta object literal for the '<em><b>Get All References</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LBEAN___GET_ALL_REFERENCES = eINSTANCE.getLBean__GetAllReferences();

    /**
     * The meta object literal for the '<em><b>Collect All Lun Features</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LBEAN___COLLECT_ALL_LUN_FEATURES__LBEAN_LIST = eINSTANCE.getLBean__CollectAllLunFeatures__LBean_List();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityImpl <em>LEntity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LEntityImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntity()
     * @generated
     */
    EClass LENTITY = eINSTANCE.getLEntity();

    /**
     * The meta object literal for the '<em><b>Cacheable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENTITY__CACHEABLE = eINSTANCE.getLEntity_Cacheable();

    /**
     * The meta object literal for the '<em><b>Historized</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENTITY__HISTORIZED = eINSTANCE.getLEntity_Historized();

    /**
     * The meta object literal for the '<em><b>Mapped Superclass</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENTITY__MAPPED_SUPERCLASS = eINSTANCE.getLEntity_MappedSuperclass();

    /**
     * The meta object literal for the '<em><b>Persistence Info</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY__PERSISTENCE_INFO = eINSTANCE.getLEntity_PersistenceInfo();

    /**
     * The meta object literal for the '<em><b>Inheritance Strategy</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY__INHERITANCE_STRATEGY = eINSTANCE.getLEntity_InheritanceStrategy();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY__FEATURES = eINSTANCE.getLEntity_Features();

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY__INDEXES = eINSTANCE.getLEntity_Indexes();

    /**
     * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY__SUPER_TYPE = eINSTANCE.getLEntity_SuperType();

    /**
     * The meta object literal for the '<em><b>Sub Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY__SUB_TYPES = eINSTANCE.getLEntity_SubTypes();

    /**
     * The meta object literal for the '<em><b>Get Operations</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LENTITY___GET_OPERATIONS = eINSTANCE.getLEntity__GetOperations();

    /**
     * The meta object literal for the '<em><b>Get References</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LENTITY___GET_REFERENCES = eINSTANCE.getLEntity__GetReferences();

    /**
     * The meta object literal for the '<em><b>Get Attributes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LENTITY___GET_ATTRIBUTES = eINSTANCE.getLEntity__GetAttributes();

    /**
     * The meta object literal for the '<em><b>Get All Features</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LENTITY___GET_ALL_FEATURES = eINSTANCE.getLEntity__GetAllFeatures();

    /**
     * The meta object literal for the '<em><b>Get All Attributes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LENTITY___GET_ALL_ATTRIBUTES = eINSTANCE.getLEntity__GetAllAttributes();

    /**
     * The meta object literal for the '<em><b>Get All References</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LENTITY___GET_ALL_REFERENCES = eINSTANCE.getLEntity__GetAllReferences();

    /**
     * The meta object literal for the '<em><b>Collect All Lun Features</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LENTITY___COLLECT_ALL_LUN_FEATURES__LENTITY_LIST = eINSTANCE.getLEntity__CollectAllLunFeatures__LEntity_List();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityPersistenceInfoImpl <em>LEntity Persistence Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LEntityPersistenceInfoImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityPersistenceInfo()
     * @generated
     */
    EClass LENTITY_PERSISTENCE_INFO = eINSTANCE.getLEntityPersistenceInfo();

    /**
     * The meta object literal for the '<em><b>Schema Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENTITY_PERSISTENCE_INFO__SCHEMA_NAME = eINSTANCE.getLEntityPersistenceInfo_SchemaName();

    /**
     * The meta object literal for the '<em><b>Table Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENTITY_PERSISTENCE_INFO__TABLE_NAME = eINSTANCE.getLEntityPersistenceInfo_TableName();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityColumnPersistenceInfoImpl <em>LEntity Column Persistence Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LEntityColumnPersistenceInfoImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityColumnPersistenceInfo()
     * @generated
     */
    EClass LENTITY_COLUMN_PERSISTENCE_INFO = eINSTANCE.getLEntityColumnPersistenceInfo();

    /**
     * The meta object literal for the '<em><b>Column Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENTITY_COLUMN_PERSISTENCE_INFO__COLUMN_NAME = eINSTANCE.getLEntityColumnPersistenceInfo_ColumnName();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy <em>LEntity Inheritance Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.LEntityInheritanceStrategy
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityInheritanceStrategy()
     * @generated
     */
    EClass LENTITY_INHERITANCE_STRATEGY = eINSTANCE.getLEntityInheritanceStrategy();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LTablePerClassStrategyImpl <em>LTable Per Class Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LTablePerClassStrategyImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLTablePerClassStrategy()
     * @generated
     */
    EClass LTABLE_PER_CLASS_STRATEGY = eINSTANCE.getLTablePerClassStrategy();

    /**
     * The meta object literal for the '<em><b>Discriminator Column</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_COLUMN = eINSTANCE.getLTablePerClassStrategy_DiscriminatorColumn();

    /**
     * The meta object literal for the '<em><b>Discriminator Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_TYPE = eINSTANCE.getLTablePerClassStrategy_DiscriminatorType();

    /**
     * The meta object literal for the '<em><b>Discriminator Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTABLE_PER_CLASS_STRATEGY__DISCRIMINATOR_VALUE = eINSTANCE.getLTablePerClassStrategy_DiscriminatorValue();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LTablePerSubclassStrategyImpl <em>LTable Per Subclass Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LTablePerSubclassStrategyImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLTablePerSubclassStrategy()
     * @generated
     */
    EClass LTABLE_PER_SUBCLASS_STRATEGY = eINSTANCE.getLTablePerSubclassStrategy();

    /**
     * The meta object literal for the '<em><b>Discriminator Column</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_COLUMN = eINSTANCE.getLTablePerSubclassStrategy_DiscriminatorColumn();

    /**
     * The meta object literal for the '<em><b>Discriminator Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_TYPE = eINSTANCE.getLTablePerSubclassStrategy_DiscriminatorType();

    /**
     * The meta object literal for the '<em><b>Discriminator Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTABLE_PER_SUBCLASS_STRATEGY__DISCRIMINATOR_VALUE = eINSTANCE.getLTablePerSubclassStrategy_DiscriminatorValue();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityFeatureImpl <em>LEntity Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LEntityFeatureImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityFeature()
     * @generated
     */
    EClass LENTITY_FEATURE = eINSTANCE.getLEntityFeature();

    /**
     * The meta object literal for the '<em><b>Persistence Info</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY_FEATURE__PERSISTENCE_INFO = eINSTANCE.getLEntityFeature_PersistenceInfo();

    /**
     * The meta object literal for the '<em><b>Get Entity</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LENTITY_FEATURE___GET_ENTITY = eINSTANCE.getLEntityFeature__GetEntity();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityAttributeImpl <em>LEntity Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LEntityAttributeImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityAttribute()
     * @generated
     */
    EClass LENTITY_ATTRIBUTE = eINSTANCE.getLEntityAttribute();

    /**
     * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENTITY_ATTRIBUTE__UUID = eINSTANCE.getLEntityAttribute_Uuid();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LEntityReferenceImpl <em>LEntity Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LEntityReferenceImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLEntityReference()
     * @generated
     */
    EClass LENTITY_REFERENCE = eINSTANCE.getLEntityReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY_REFERENCE__TYPE = eINSTANCE.getLEntityReference_Type();

    /**
     * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENTITY_REFERENCE__OPPOSITE = eINSTANCE.getLEntityReference_Opposite();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LBeanFeatureImpl <em>LBean Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LBeanFeatureImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLBeanFeature()
     * @generated
     */
    EClass LBEAN_FEATURE = eINSTANCE.getLBeanFeature();

    /**
     * The meta object literal for the '<em><b>Get Bean</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LBEAN_FEATURE___GET_BEAN = eINSTANCE.getLBeanFeature__GetBean();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl <em>LBean Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LBeanAttributeImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLBeanAttribute()
     * @generated
     */
    EClass LBEAN_ATTRIBUTE = eINSTANCE.getLBeanAttribute();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LBeanReferenceImpl <em>LBean Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LBeanReferenceImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLBeanReference()
     * @generated
     */
    EClass LBEAN_REFERENCE = eINSTANCE.getLBeanReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LBEAN_REFERENCE__TYPE = eINSTANCE.getLBeanReference_Type();

    /**
     * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LBEAN_REFERENCE__OPPOSITE = eINSTANCE.getLBeanReference_Opposite();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LIndexImpl <em>LIndex</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LIndexImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLIndex()
     * @generated
     */
    EClass LINDEX = eINSTANCE.getLIndex();

    /**
     * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINDEX__UNIQUE = eINSTANCE.getLIndex_Unique();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINDEX__NAME = eINSTANCE.getLIndex_Name();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINDEX__FEATURES = eINSTANCE.getLIndex_Features();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.impl.LOperationImpl <em>LOperation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.impl.LOperationImpl
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLOperation()
     * @generated
     */
    EClass LOPERATION = eINSTANCE.getLOperation();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.entity.LDiscriminatorType <em>LDiscriminator Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.entity.LDiscriminatorType
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getLDiscriminatorType()
     * @generated
     */
    EEnum LDISCRIMINATOR_TYPE = eINSTANCE.getLDiscriminatorType();

    /**
     * The meta object literal for the '<em>Operations List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getOperationsList()
     * @generated
     */
    EDataType OPERATIONS_LIST = eINSTANCE.getOperationsList();

    /**
     * The meta object literal for the '<em>Feature List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getEntityFeatureList()
     * @generated
     */
    EDataType ENTITY_FEATURE_LIST = eINSTANCE.getEntityFeatureList();

    /**
     * The meta object literal for the '<em>Reference List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getEntityReferenceList()
     * @generated
     */
    EDataType ENTITY_REFERENCE_LIST = eINSTANCE.getEntityReferenceList();

    /**
     * The meta object literal for the '<em>Attribute List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getEntityAttributeList()
     * @generated
     */
    EDataType ENTITY_ATTRIBUTE_LIST = eINSTANCE.getEntityAttributeList();

    /**
     * The meta object literal for the '<em>Bean Feature List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getBeanFeatureList()
     * @generated
     */
    EDataType BEAN_FEATURE_LIST = eINSTANCE.getBeanFeatureList();

    /**
     * The meta object literal for the '<em>Bean Reference List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getBeanReferenceList()
     * @generated
     */
    EDataType BEAN_REFERENCE_LIST = eINSTANCE.getBeanReferenceList();

    /**
     * The meta object literal for the '<em>Bean Attribute List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.entity.impl.EntityPackageImpl#getBeanAttributeList()
     * @generated
     */
    EDataType BEAN_ATTRIBUTE_LIST = eINSTANCE.getBeanAttributeList();

  }

} //EntityPackage

/**
 */
package org.lunifera.dsl.semantic.common.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.lunifera.dsl.semantic.common.types.LunTypesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel fileExtensions='typesmodel' modelName='Types' prefix='LunTypes' basePackage='org.lunifera.dsl.semantic.common'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore rootPackage='types'"
 * @generated
 */
public interface LunTypesPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "types";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.lunifera.org/dsl/common/types/v1";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "types";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LunTypesPackage eINSTANCE = org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LPackageImpl <em>LPackage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LPackageImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLPackage()
   * @generated
   */
  int LPACKAGE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LPACKAGE__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LPACKAGE__IMPORTS = 1;

  /**
   * The number of structural features of the '<em>LPackage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LPACKAGE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>LPackage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LPACKAGE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LTypedPackageImpl <em>LTyped Package</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LTypedPackageImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLTypedPackage()
   * @generated
   */
  int LTYPED_PACKAGE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPED_PACKAGE__NAME = LPACKAGE__NAME;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPED_PACKAGE__IMPORTS = LPACKAGE__IMPORTS;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPED_PACKAGE__TYPES = LPACKAGE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>LTyped Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPED_PACKAGE_FEATURE_COUNT = LPACKAGE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>LTyped Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPED_PACKAGE_OPERATION_COUNT = LPACKAGE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LImportImpl <em>LImport</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LImportImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLImport()
   * @generated
   */
  int LIMPORT = 2;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The number of structural features of the '<em>LImport</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIMPORT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>LImport</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIMPORT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LAnnotationTargetImpl <em>LAnnotation Target</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LAnnotationTargetImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLAnnotationTarget()
   * @generated
   */
  int LANNOTATION_TARGET = 5;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANNOTATION_TARGET__ANNOTATIONS = 0;

  /**
   * The number of structural features of the '<em>LAnnotation Target</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANNOTATION_TARGET_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>LAnnotation Target</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANNOTATION_TARGET_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LTypeImpl <em>LType</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LTypeImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLType()
   * @generated
   */
  int LTYPE = 3;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPE__ANNOTATIONS = LANNOTATION_TARGET__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPE__NAME = LANNOTATION_TARGET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPE__ANNOTATION_INFO = LANNOTATION_TARGET_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>LType</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPE_FEATURE_COUNT = LANNOTATION_TARGET_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Resolved Annotations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPE___GET_RESOLVED_ANNOTATIONS = LANNOTATION_TARGET_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>LType</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTYPE_OPERATION_COUNT = LANNOTATION_TARGET_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LAnnotationDefImpl <em>LAnnotation Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LAnnotationDefImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLAnnotationDef()
   * @generated
   */
  int LANNOTATION_DEF = 4;

  /**
   * The feature id for the '<em><b>Exclude</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANNOTATION_DEF__EXCLUDE = 0;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANNOTATION_DEF__ANNOTATION = 1;

  /**
   * The number of structural features of the '<em>LAnnotation Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANNOTATION_DEF_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>LAnnotation Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANNOTATION_DEF_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LScalarTypeImpl <em>LScalar Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LScalarTypeImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLScalarType()
   * @generated
   */
  int LSCALAR_TYPE = 6;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSCALAR_TYPE__ANNOTATIONS = LTYPE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSCALAR_TYPE__NAME = LTYPE__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSCALAR_TYPE__ANNOTATION_INFO = LTYPE__ANNOTATION_INFO;

  /**
   * The number of structural features of the '<em>LScalar Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSCALAR_TYPE_FEATURE_COUNT = LTYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Resolved Annotations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSCALAR_TYPE___GET_RESOLVED_ANNOTATIONS = LTYPE___GET_RESOLVED_ANNOTATIONS;

  /**
   * The number of operations of the '<em>LScalar Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSCALAR_TYPE_OPERATION_COUNT = LTYPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl <em>LData Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLDataType()
   * @generated
   */
  int LDATA_TYPE = 7;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__ANNOTATIONS = LSCALAR_TYPE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__NAME = LSCALAR_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__ANNOTATION_INFO = LSCALAR_TYPE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Jvm Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__JVM_TYPE_REFERENCE = LSCALAR_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>As Primitive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__AS_PRIMITIVE = LSCALAR_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__DATE = LSCALAR_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>As Blob</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__AS_BLOB = LSCALAR_TYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__LENGTH = LSCALAR_TYPE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Date Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__DATE_TYPE = LSCALAR_TYPE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Synthetic Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__SYNTHETIC_FLAG = LSCALAR_TYPE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Synthetic Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE__SYNTHETIC_TYPE = LSCALAR_TYPE_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>LData Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE_FEATURE_COUNT = LSCALAR_TYPE_FEATURE_COUNT + 8;

  /**
   * The operation id for the '<em>Get Resolved Annotations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE___GET_RESOLVED_ANNOTATIONS = LSCALAR_TYPE___GET_RESOLVED_ANNOTATIONS;

  /**
   * The number of operations of the '<em>LData Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDATA_TYPE_OPERATION_COUNT = LSCALAR_TYPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LEnumImpl <em>LEnum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LEnumImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLEnum()
   * @generated
   */
  int LENUM = 8;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM__ANNOTATIONS = LSCALAR_TYPE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM__NAME = LSCALAR_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM__ANNOTATION_INFO = LSCALAR_TYPE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM__LITERALS = LSCALAR_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>LEnum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM_FEATURE_COUNT = LSCALAR_TYPE_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Resolved Annotations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM___GET_RESOLVED_ANNOTATIONS = LSCALAR_TYPE___GET_RESOLVED_ANNOTATIONS;

  /**
   * The number of operations of the '<em>LEnum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM_OPERATION_COUNT = LSCALAR_TYPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LEnumLiteralImpl <em>LEnum Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LEnumLiteralImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLEnumLiteral()
   * @generated
   */
  int LENUM_LITERAL = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM_LITERAL__NAME = 0;

  /**
   * The number of structural features of the '<em>LEnum Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM_LITERAL_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>LEnum Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LENUM_LITERAL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LClassImpl <em>LClass</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LClassImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLClass()
   * @generated
   */
  int LCLASS = 10;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCLASS__ANNOTATIONS = LTYPE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCLASS__NAME = LTYPE__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCLASS__ANNOTATION_INFO = LTYPE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCLASS__ABSTRACT = LTYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCLASS__SERIALIZABLE = LTYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCLASS__SHORT_NAME = LTYPE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>LClass</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCLASS_FEATURE_COUNT = LTYPE_FEATURE_COUNT + 3;

  /**
   * The operation id for the '<em>Get Resolved Annotations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCLASS___GET_RESOLVED_ANNOTATIONS = LTYPE___GET_RESOLVED_ANNOTATIONS;

  /**
   * The number of operations of the '<em>LClass</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LCLASS_OPERATION_COUNT = LTYPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.LFeaturesHolder <em>LFeatures Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.LFeaturesHolder
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLFeaturesHolder()
   * @generated
   */
  int LFEATURES_HOLDER = 11;

  /**
   * The number of structural features of the '<em>LFeatures Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURES_HOLDER_FEATURE_COUNT = 0;

  /**
   * The operation id for the '<em>Get Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURES_HOLDER___GET_FEATURES = 0;

  /**
   * The operation id for the '<em>Get All Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURES_HOLDER___GET_ALL_FEATURES = 1;

  /**
   * The number of operations of the '<em>LFeatures Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURES_HOLDER_OPERATION_COUNT = 2;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.LFeature <em>LFeature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.LFeature
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLFeature()
   * @generated
   */
  int LFEATURE = 12;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURE__ANNOTATIONS = LANNOTATION_TARGET__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURE__NAME = LANNOTATION_TARGET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURE__MULTIPLICITY = LANNOTATION_TARGET_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURE__ANNOTATION_INFO = LANNOTATION_TARGET_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>LFeature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURE_FEATURE_COUNT = LANNOTATION_TARGET_FEATURE_COUNT + 3;

  /**
   * The operation id for the '<em>Get Resolved Annotations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURE___GET_RESOLVED_ANNOTATIONS = LANNOTATION_TARGET_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>LFeature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LFEATURE_OPERATION_COUNT = LANNOTATION_TARGET_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.LReference <em>LReference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.LReference
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLReference()
   * @generated
   */
  int LREFERENCE = 13;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LREFERENCE__ANNOTATIONS = LFEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LREFERENCE__NAME = LFEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LREFERENCE__MULTIPLICITY = LFEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LREFERENCE__ANNOTATION_INFO = LFEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LREFERENCE__LAZY = LFEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LREFERENCE__CASCADING = LFEATURE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>LReference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LREFERENCE_FEATURE_COUNT = LFEATURE_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Resolved Annotations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LREFERENCE___GET_RESOLVED_ANNOTATIONS = LFEATURE___GET_RESOLVED_ANNOTATIONS;

  /**
   * The number of operations of the '<em>LReference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LREFERENCE_OPERATION_COUNT = LFEATURE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.LAttribute <em>LAttribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.LAttribute
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLAttribute()
   * @generated
   */
  int LATTRIBUTE = 14;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__ANNOTATIONS = LFEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__NAME = LFEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__MULTIPLICITY = LFEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__ANNOTATION_INFO = LFEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__ID = LFEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__VERSION = LFEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__LAZY = LFEATURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__CASCADING = LFEATURE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__TRANSIENT = LFEATURE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE__TYPE = LFEATURE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>LAttribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE_FEATURE_COUNT = LFEATURE_FEATURE_COUNT + 6;

  /**
   * The operation id for the '<em>Get Resolved Annotations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE___GET_RESOLVED_ANNOTATIONS = LFEATURE___GET_RESOLVED_ANNOTATIONS;

  /**
   * The number of operations of the '<em>LAttribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATTRIBUTE_OPERATION_COUNT = LFEATURE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LOperationImpl <em>LOperation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LOperationImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLOperation()
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
  int LOPERATION__ANNOTATIONS = LANNOTATION_TARGET__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__MODIFIER = LANNOTATION_TARGET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__TYPE = LANNOTATION_TARGET_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__PARAMS = LANNOTATION_TARGET_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION__BODY = LANNOTATION_TARGET_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>LOperation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION_FEATURE_COUNT = LANNOTATION_TARGET_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Get Resolved Annotations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION___GET_RESOLVED_ANNOTATIONS = LANNOTATION_TARGET_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>LOperation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOPERATION_OPERATION_COUNT = LANNOTATION_TARGET_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LModifierImpl <em>LModifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LModifierImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLModifier()
   * @generated
   */
  int LMODIFIER = 16;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LMODIFIER__FINAL = 0;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LMODIFIER__STATIC = 1;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LMODIFIER__VISIBILITY = 2;

  /**
   * The number of structural features of the '<em>LModifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LMODIFIER_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>LModifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LMODIFIER_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.impl.LMultiplicityImpl <em>LMultiplicity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.impl.LMultiplicityImpl
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLMultiplicity()
   * @generated
   */
  int LMULTIPLICITY = 17;

  /**
   * The feature id for the '<em><b>Lower</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LMULTIPLICITY__LOWER = 0;

  /**
   * The feature id for the '<em><b>Upper</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LMULTIPLICITY__UPPER = 1;

  /**
   * The number of structural features of the '<em>LMultiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LMULTIPLICITY_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>LMultiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LMULTIPLICITY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.LDateType <em>LDate Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.LDateType
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLDateType()
   * @generated
   */
  int LDATE_TYPE = 18;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.LVisibility <em>LVisibility</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.LVisibility
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLVisibility()
   * @generated
   */
  int LVISIBILITY = 19;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.LLowerBound <em>LLower Bound</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.LLowerBound
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLLowerBound()
   * @generated
   */
  int LLOWER_BOUND = 20;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.common.types.LUpperBound <em>LUpper Bound</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.common.types.LUpperBound
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLUpperBound()
   * @generated
   */
  int LUPPER_BOUND = 21;

  /**
   * The meta object id for the '<em>Operations List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getOperationsList()
   * @generated
   */
  int OPERATIONS_LIST = 22;

  /**
   * The meta object id for the '<em>Features List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getFeaturesList()
   * @generated
   */
  int FEATURES_LIST = 23;

  /**
   * The meta object id for the '<em>Annotation List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.EList
   * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getAnnotationList()
   * @generated
   */
  int ANNOTATION_LIST = 24;


  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LPackage <em>LPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LPackage</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LPackage
   * @generated
   */
  EClass getLPackage();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LPackage#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LPackage#getName()
   * @see #getLPackage()
   * @generated
   */
  EAttribute getLPackage_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.common.types.LPackage#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LPackage#getImports()
   * @see #getLPackage()
   * @generated
   */
  EReference getLPackage_Imports();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LTypedPackage <em>LTyped Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LTyped Package</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LTypedPackage
   * @generated
   */
  EClass getLTypedPackage();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.common.types.LTypedPackage#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LTypedPackage#getTypes()
   * @see #getLTypedPackage()
   * @generated
   */
  EReference getLTypedPackage_Types();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LImport <em>LImport</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LImport</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LImport
   * @generated
   */
  EClass getLImport();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LImport#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LImport#getImportedNamespace()
   * @see #getLImport()
   * @generated
   */
  EAttribute getLImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LType <em>LType</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LType</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LType
   * @generated
   */
  EClass getLType();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LType#getName()
   * @see #getLType()
   * @generated
   */
  EAttribute getLType_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.common.types.LType#getAnnotationInfo <em>Annotation Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Annotation Info</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LType#getAnnotationInfo()
   * @see #getLType()
   * @generated
   */
  EReference getLType_AnnotationInfo();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.common.types.LType#getResolvedAnnotations() <em>Get Resolved Annotations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Resolved Annotations</em>' operation.
   * @see org.lunifera.dsl.semantic.common.types.LType#getResolvedAnnotations()
   * @generated
   */
  EOperation getLType__GetResolvedAnnotations();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LAnnotationDef <em>LAnnotation Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LAnnotation Def</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAnnotationDef
   * @generated
   */
  EClass getLAnnotationDef();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LAnnotationDef#isExclude <em>Exclude</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exclude</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAnnotationDef#isExclude()
   * @see #getLAnnotationDef()
   * @generated
   */
  EAttribute getLAnnotationDef_Exclude();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.common.types.LAnnotationDef#getAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Annotation</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAnnotationDef#getAnnotation()
   * @see #getLAnnotationDef()
   * @generated
   */
  EReference getLAnnotationDef_Annotation();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LAnnotationTarget <em>LAnnotation Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LAnnotation Target</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAnnotationTarget
   * @generated
   */
  EClass getLAnnotationTarget();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.common.types.LAnnotationTarget#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAnnotationTarget#getAnnotations()
   * @see #getLAnnotationTarget()
   * @generated
   */
  EReference getLAnnotationTarget_Annotations();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LScalarType <em>LScalar Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LScalar Type</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LScalarType
   * @generated
   */
  EClass getLScalarType();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LDataType <em>LData Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LData Type</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDataType
   * @generated
   */
  EClass getLDataType();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.common.types.LDataType#getJvmTypeReference <em>Jvm Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Jvm Type Reference</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDataType#getJvmTypeReference()
   * @see #getLDataType()
   * @generated
   */
  EReference getLDataType_JvmTypeReference();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LDataType#isAsPrimitive <em>As Primitive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>As Primitive</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDataType#isAsPrimitive()
   * @see #getLDataType()
   * @generated
   */
  EAttribute getLDataType_AsPrimitive();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LDataType#isDate <em>Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Date</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDataType#isDate()
   * @see #getLDataType()
   * @generated
   */
  EAttribute getLDataType_Date();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LDataType#isAsBlob <em>As Blob</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>As Blob</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDataType#isAsBlob()
   * @see #getLDataType()
   * @generated
   */
  EAttribute getLDataType_AsBlob();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LDataType#getLength <em>Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Length</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDataType#getLength()
   * @see #getLDataType()
   * @generated
   */
  EAttribute getLDataType_Length();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LDataType#getDateType <em>Date Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Date Type</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDataType#getDateType()
   * @see #getLDataType()
   * @generated
   */
  EAttribute getLDataType_DateType();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LDataType#isSyntheticFlag <em>Synthetic Flag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Synthetic Flag</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDataType#isSyntheticFlag()
   * @see #getLDataType()
   * @generated
   */
  EAttribute getLDataType_SyntheticFlag();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LDataType#getSyntheticType <em>Synthetic Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Synthetic Type</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDataType#getSyntheticType()
   * @see #getLDataType()
   * @generated
   */
  EAttribute getLDataType_SyntheticType();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LEnum <em>LEnum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEnum</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LEnum
   * @generated
   */
  EClass getLEnum();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.common.types.LEnum#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LEnum#getLiterals()
   * @see #getLEnum()
   * @generated
   */
  EReference getLEnum_Literals();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LEnumLiteral <em>LEnum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LEnum Literal</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LEnumLiteral
   * @generated
   */
  EClass getLEnumLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LEnumLiteral#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LEnumLiteral#getName()
   * @see #getLEnumLiteral()
   * @generated
   */
  EAttribute getLEnumLiteral_Name();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LClass <em>LClass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LClass</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LClass
   * @generated
   */
  EClass getLClass();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LClass#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LClass#isAbstract()
   * @see #getLClass()
   * @generated
   */
  EAttribute getLClass_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LClass#isSerializable <em>Serializable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Serializable</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LClass#isSerializable()
   * @see #getLClass()
   * @generated
   */
  EAttribute getLClass_Serializable();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LClass#getShortName <em>Short Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Short Name</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LClass#getShortName()
   * @see #getLClass()
   * @generated
   */
  EAttribute getLClass_ShortName();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LFeaturesHolder <em>LFeatures Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LFeatures Holder</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LFeaturesHolder
   * @generated
   */
  EClass getLFeaturesHolder();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.common.types.LFeaturesHolder#getFeatures() <em>Get Features</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Features</em>' operation.
   * @see org.lunifera.dsl.semantic.common.types.LFeaturesHolder#getFeatures()
   * @generated
   */
  EOperation getLFeaturesHolder__GetFeatures();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.common.types.LFeaturesHolder#getAllFeatures() <em>Get All Features</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Features</em>' operation.
   * @see org.lunifera.dsl.semantic.common.types.LFeaturesHolder#getAllFeatures()
   * @generated
   */
  EOperation getLFeaturesHolder__GetAllFeatures();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LFeature <em>LFeature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LFeature</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LFeature
   * @generated
   */
  EClass getLFeature();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LFeature#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LFeature#getName()
   * @see #getLFeature()
   * @generated
   */
  EAttribute getLFeature_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.common.types.LFeature#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LFeature#getMultiplicity()
   * @see #getLFeature()
   * @generated
   */
  EReference getLFeature_Multiplicity();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.common.types.LFeature#getAnnotationInfo <em>Annotation Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Annotation Info</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LFeature#getAnnotationInfo()
   * @see #getLFeature()
   * @generated
   */
  EReference getLFeature_AnnotationInfo();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.common.types.LFeature#getResolvedAnnotations() <em>Get Resolved Annotations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Resolved Annotations</em>' operation.
   * @see org.lunifera.dsl.semantic.common.types.LFeature#getResolvedAnnotations()
   * @generated
   */
  EOperation getLFeature__GetResolvedAnnotations();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LReference <em>LReference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LReference</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LReference
   * @generated
   */
  EClass getLReference();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LReference#isLazy <em>Lazy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lazy</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LReference#isLazy()
   * @see #getLReference()
   * @generated
   */
  EAttribute getLReference_Lazy();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LReference#isCascading <em>Cascading</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cascading</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LReference#isCascading()
   * @see #getLReference()
   * @generated
   */
  EAttribute getLReference_Cascading();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LAttribute <em>LAttribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LAttribute</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAttribute
   * @generated
   */
  EClass getLAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAttribute#isId()
   * @see #getLAttribute()
   * @generated
   */
  EAttribute getLAttribute_Id();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAttribute#isVersion()
   * @see #getLAttribute()
   * @generated
   */
  EAttribute getLAttribute_Version();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isLazy <em>Lazy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lazy</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAttribute#isLazy()
   * @see #getLAttribute()
   * @generated
   */
  EAttribute getLAttribute_Lazy();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isCascading <em>Cascading</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cascading</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAttribute#isCascading()
   * @see #getLAttribute()
   * @generated
   */
  EAttribute getLAttribute_Cascading();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LAttribute#isTransient <em>Transient</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Transient</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAttribute#isTransient()
   * @see #getLAttribute()
   * @generated
   */
  EAttribute getLAttribute_Transient();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.common.types.LAttribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LAttribute#getType()
   * @see #getLAttribute()
   * @generated
   */
  EReference getLAttribute_Type();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LOperation <em>LOperation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LOperation</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LOperation
   * @generated
   */
  EClass getLOperation();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.common.types.LOperation#getModifier <em>Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modifier</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LOperation#getModifier()
   * @see #getLOperation()
   * @generated
   */
  EReference getLOperation_Modifier();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.common.types.LOperation#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LOperation#getType()
   * @see #getLOperation()
   * @generated
   */
  EReference getLOperation_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.common.types.LOperation#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LOperation#getParams()
   * @see #getLOperation()
   * @generated
   */
  EReference getLOperation_Params();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.common.types.LOperation#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LOperation#getBody()
   * @see #getLOperation()
   * @generated
   */
  EReference getLOperation_Body();

  /**
   * Returns the meta object for the '{@link org.lunifera.dsl.semantic.common.types.LOperation#getResolvedAnnotations() <em>Get Resolved Annotations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Resolved Annotations</em>' operation.
   * @see org.lunifera.dsl.semantic.common.types.LOperation#getResolvedAnnotations()
   * @generated
   */
  EOperation getLOperation__GetResolvedAnnotations();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LModifier <em>LModifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LModifier</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LModifier
   * @generated
   */
  EClass getLModifier();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LModifier#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LModifier#isFinal()
   * @see #getLModifier()
   * @generated
   */
  EAttribute getLModifier_Final();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LModifier#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LModifier#isStatic()
   * @see #getLModifier()
   * @generated
   */
  EAttribute getLModifier_Static();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LModifier#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LModifier#getVisibility()
   * @see #getLModifier()
   * @generated
   */
  EAttribute getLModifier_Visibility();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.common.types.LMultiplicity <em>LMultiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LMultiplicity</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LMultiplicity
   * @generated
   */
  EClass getLMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LMultiplicity#getLower()
   * @see #getLMultiplicity()
   * @generated
   */
  EAttribute getLMultiplicity_Lower();

  /**
   * Returns the meta object for the attribute '{@link org.lunifera.dsl.semantic.common.types.LMultiplicity#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LMultiplicity#getUpper()
   * @see #getLMultiplicity()
   * @generated
   */
  EAttribute getLMultiplicity_Upper();

  /**
   * Returns the meta object for enum '{@link org.lunifera.dsl.semantic.common.types.LDateType <em>LDate Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>LDate Type</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LDateType
   * @generated
   */
  EEnum getLDateType();

  /**
   * Returns the meta object for enum '{@link org.lunifera.dsl.semantic.common.types.LVisibility <em>LVisibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>LVisibility</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LVisibility
   * @generated
   */
  EEnum getLVisibility();

  /**
   * Returns the meta object for enum '{@link org.lunifera.dsl.semantic.common.types.LLowerBound <em>LLower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>LLower Bound</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LLowerBound
   * @generated
   */
  EEnum getLLowerBound();

  /**
   * Returns the meta object for enum '{@link org.lunifera.dsl.semantic.common.types.LUpperBound <em>LUpper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>LUpper Bound</em>'.
   * @see org.lunifera.dsl.semantic.common.types.LUpperBound
   * @generated
   */
  EEnum getLUpperBound();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Operations List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Operations List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.common.types.LOperation>"
   * @generated
   */
  EDataType getOperationsList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Features List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Features List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<? extends org.lunifera.dsl.semantic.common.types.LFeature>"
   * @generated
   */
  EDataType getFeaturesList();

  /**
   * Returns the meta object for data type '{@link org.eclipse.emf.common.util.EList <em>Annotation List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Annotation List</em>'.
   * @see org.eclipse.emf.common.util.EList
   * @model instanceClass="org.eclipse.emf.common.util.EList<org.lunifera.dsl.semantic.common.types.LAnnotationDef>"
   * @generated
   */
  EDataType getAnnotationList();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LunTypesFactory getLunTypesFactory();

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
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LPackageImpl <em>LPackage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LPackageImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLPackage()
     * @generated
     */
    EClass LPACKAGE = eINSTANCE.getLPackage();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LPACKAGE__NAME = eINSTANCE.getLPackage_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LPACKAGE__IMPORTS = eINSTANCE.getLPackage_Imports();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LTypedPackageImpl <em>LTyped Package</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LTypedPackageImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLTypedPackage()
     * @generated
     */
    EClass LTYPED_PACKAGE = eINSTANCE.getLTypedPackage();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LTYPED_PACKAGE__TYPES = eINSTANCE.getLTypedPackage_Types();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LImportImpl <em>LImport</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LImportImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLImport()
     * @generated
     */
    EClass LIMPORT = eINSTANCE.getLImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LIMPORT__IMPORTED_NAMESPACE = eINSTANCE.getLImport_ImportedNamespace();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LTypeImpl <em>LType</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LTypeImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLType()
     * @generated
     */
    EClass LTYPE = eINSTANCE.getLType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTYPE__NAME = eINSTANCE.getLType_Name();

    /**
     * The meta object literal for the '<em><b>Annotation Info</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LTYPE__ANNOTATION_INFO = eINSTANCE.getLType_AnnotationInfo();

    /**
     * The meta object literal for the '<em><b>Get Resolved Annotations</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LTYPE___GET_RESOLVED_ANNOTATIONS = eINSTANCE.getLType__GetResolvedAnnotations();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LAnnotationDefImpl <em>LAnnotation Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LAnnotationDefImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLAnnotationDef()
     * @generated
     */
    EClass LANNOTATION_DEF = eINSTANCE.getLAnnotationDef();

    /**
     * The meta object literal for the '<em><b>Exclude</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LANNOTATION_DEF__EXCLUDE = eINSTANCE.getLAnnotationDef_Exclude();

    /**
     * The meta object literal for the '<em><b>Annotation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANNOTATION_DEF__ANNOTATION = eINSTANCE.getLAnnotationDef_Annotation();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LAnnotationTargetImpl <em>LAnnotation Target</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LAnnotationTargetImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLAnnotationTarget()
     * @generated
     */
    EClass LANNOTATION_TARGET = eINSTANCE.getLAnnotationTarget();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANNOTATION_TARGET__ANNOTATIONS = eINSTANCE.getLAnnotationTarget_Annotations();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LScalarTypeImpl <em>LScalar Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LScalarTypeImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLScalarType()
     * @generated
     */
    EClass LSCALAR_TYPE = eINSTANCE.getLScalarType();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl <em>LData Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LDataTypeImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLDataType()
     * @generated
     */
    EClass LDATA_TYPE = eINSTANCE.getLDataType();

    /**
     * The meta object literal for the '<em><b>Jvm Type Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDATA_TYPE__JVM_TYPE_REFERENCE = eINSTANCE.getLDataType_JvmTypeReference();

    /**
     * The meta object literal for the '<em><b>As Primitive</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LDATA_TYPE__AS_PRIMITIVE = eINSTANCE.getLDataType_AsPrimitive();

    /**
     * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LDATA_TYPE__DATE = eINSTANCE.getLDataType_Date();

    /**
     * The meta object literal for the '<em><b>As Blob</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LDATA_TYPE__AS_BLOB = eINSTANCE.getLDataType_AsBlob();

    /**
     * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LDATA_TYPE__LENGTH = eINSTANCE.getLDataType_Length();

    /**
     * The meta object literal for the '<em><b>Date Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LDATA_TYPE__DATE_TYPE = eINSTANCE.getLDataType_DateType();

    /**
     * The meta object literal for the '<em><b>Synthetic Flag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LDATA_TYPE__SYNTHETIC_FLAG = eINSTANCE.getLDataType_SyntheticFlag();

    /**
     * The meta object literal for the '<em><b>Synthetic Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LDATA_TYPE__SYNTHETIC_TYPE = eINSTANCE.getLDataType_SyntheticType();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LEnumImpl <em>LEnum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LEnumImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLEnum()
     * @generated
     */
    EClass LENUM = eINSTANCE.getLEnum();

    /**
     * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LENUM__LITERALS = eINSTANCE.getLEnum_Literals();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LEnumLiteralImpl <em>LEnum Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LEnumLiteralImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLEnumLiteral()
     * @generated
     */
    EClass LENUM_LITERAL = eINSTANCE.getLEnumLiteral();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LENUM_LITERAL__NAME = eINSTANCE.getLEnumLiteral_Name();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LClassImpl <em>LClass</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LClassImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLClass()
     * @generated
     */
    EClass LCLASS = eINSTANCE.getLClass();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LCLASS__ABSTRACT = eINSTANCE.getLClass_Abstract();

    /**
     * The meta object literal for the '<em><b>Serializable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LCLASS__SERIALIZABLE = eINSTANCE.getLClass_Serializable();

    /**
     * The meta object literal for the '<em><b>Short Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LCLASS__SHORT_NAME = eINSTANCE.getLClass_ShortName();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.LFeaturesHolder <em>LFeatures Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.LFeaturesHolder
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLFeaturesHolder()
     * @generated
     */
    EClass LFEATURES_HOLDER = eINSTANCE.getLFeaturesHolder();

    /**
     * The meta object literal for the '<em><b>Get Features</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LFEATURES_HOLDER___GET_FEATURES = eINSTANCE.getLFeaturesHolder__GetFeatures();

    /**
     * The meta object literal for the '<em><b>Get All Features</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LFEATURES_HOLDER___GET_ALL_FEATURES = eINSTANCE.getLFeaturesHolder__GetAllFeatures();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.LFeature <em>LFeature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.LFeature
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLFeature()
     * @generated
     */
    EClass LFEATURE = eINSTANCE.getLFeature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LFEATURE__NAME = eINSTANCE.getLFeature_Name();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LFEATURE__MULTIPLICITY = eINSTANCE.getLFeature_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Annotation Info</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LFEATURE__ANNOTATION_INFO = eINSTANCE.getLFeature_AnnotationInfo();

    /**
     * The meta object literal for the '<em><b>Get Resolved Annotations</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LFEATURE___GET_RESOLVED_ANNOTATIONS = eINSTANCE.getLFeature__GetResolvedAnnotations();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.LReference <em>LReference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.LReference
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLReference()
     * @generated
     */
    EClass LREFERENCE = eINSTANCE.getLReference();

    /**
     * The meta object literal for the '<em><b>Lazy</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LREFERENCE__LAZY = eINSTANCE.getLReference_Lazy();

    /**
     * The meta object literal for the '<em><b>Cascading</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LREFERENCE__CASCADING = eINSTANCE.getLReference_Cascading();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.LAttribute <em>LAttribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.LAttribute
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLAttribute()
     * @generated
     */
    EClass LATTRIBUTE = eINSTANCE.getLAttribute();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LATTRIBUTE__ID = eINSTANCE.getLAttribute_Id();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LATTRIBUTE__VERSION = eINSTANCE.getLAttribute_Version();

    /**
     * The meta object literal for the '<em><b>Lazy</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LATTRIBUTE__LAZY = eINSTANCE.getLAttribute_Lazy();

    /**
     * The meta object literal for the '<em><b>Cascading</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LATTRIBUTE__CASCADING = eINSTANCE.getLAttribute_Cascading();

    /**
     * The meta object literal for the '<em><b>Transient</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LATTRIBUTE__TRANSIENT = eINSTANCE.getLAttribute_Transient();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LATTRIBUTE__TYPE = eINSTANCE.getLAttribute_Type();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LOperationImpl <em>LOperation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LOperationImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLOperation()
     * @generated
     */
    EClass LOPERATION = eINSTANCE.getLOperation();

    /**
     * The meta object literal for the '<em><b>Modifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOPERATION__MODIFIER = eINSTANCE.getLOperation_Modifier();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOPERATION__TYPE = eINSTANCE.getLOperation_Type();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOPERATION__PARAMS = eINSTANCE.getLOperation_Params();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOPERATION__BODY = eINSTANCE.getLOperation_Body();

    /**
     * The meta object literal for the '<em><b>Get Resolved Annotations</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LOPERATION___GET_RESOLVED_ANNOTATIONS = eINSTANCE.getLOperation__GetResolvedAnnotations();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LModifierImpl <em>LModifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LModifierImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLModifier()
     * @generated
     */
    EClass LMODIFIER = eINSTANCE.getLModifier();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LMODIFIER__FINAL = eINSTANCE.getLModifier_Final();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LMODIFIER__STATIC = eINSTANCE.getLModifier_Static();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LMODIFIER__VISIBILITY = eINSTANCE.getLModifier_Visibility();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.impl.LMultiplicityImpl <em>LMultiplicity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.impl.LMultiplicityImpl
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLMultiplicity()
     * @generated
     */
    EClass LMULTIPLICITY = eINSTANCE.getLMultiplicity();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LMULTIPLICITY__LOWER = eINSTANCE.getLMultiplicity_Lower();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LMULTIPLICITY__UPPER = eINSTANCE.getLMultiplicity_Upper();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.LDateType <em>LDate Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.LDateType
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLDateType()
     * @generated
     */
    EEnum LDATE_TYPE = eINSTANCE.getLDateType();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.LVisibility <em>LVisibility</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.LVisibility
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLVisibility()
     * @generated
     */
    EEnum LVISIBILITY = eINSTANCE.getLVisibility();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.LLowerBound <em>LLower Bound</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.LLowerBound
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLLowerBound()
     * @generated
     */
    EEnum LLOWER_BOUND = eINSTANCE.getLLowerBound();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.common.types.LUpperBound <em>LUpper Bound</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.common.types.LUpperBound
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getLUpperBound()
     * @generated
     */
    EEnum LUPPER_BOUND = eINSTANCE.getLUpperBound();

    /**
     * The meta object literal for the '<em>Operations List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getOperationsList()
     * @generated
     */
    EDataType OPERATIONS_LIST = eINSTANCE.getOperationsList();

    /**
     * The meta object literal for the '<em>Features List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getFeaturesList()
     * @generated
     */
    EDataType FEATURES_LIST = eINSTANCE.getFeaturesList();

    /**
     * The meta object literal for the '<em>Annotation List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.EList
     * @see org.lunifera.dsl.semantic.common.types.impl.LunTypesPackageImpl#getAnnotationList()
     * @generated
     */
    EDataType ANNOTATION_LIST = eINSTANCE.getAnnotationList();

  }

} //LunTypesPackage

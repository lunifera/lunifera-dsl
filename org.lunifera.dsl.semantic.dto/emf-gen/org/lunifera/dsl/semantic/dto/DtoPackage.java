/**
 */
package org.lunifera.dsl.semantic.dto;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.dto.DtoFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel fileExtensions='dtomodel' modelName='DTO' prefix='Dto' runtimeVersion='2.9' operationReflection='false' basePackage='org.lunifera.dsl.semantic'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore rootPackage='dto'"
 * @generated
 */
public interface DtoPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dto";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.lunifera.org/dsl/dto/v1";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dto";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DtoPackage eINSTANCE = org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl.init();

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoModelImpl <em>LDto Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoModelImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoModel()
   * @generated
   */
  int LDTO_MODEL = 0;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_MODEL__PACKAGES = 0;

  /**
   * The number of structural features of the '<em>LDto Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoImpl <em>LDto</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDto()
   * @generated
   */
  int LDTO = 1;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__ANNOTATIONS = LunTypesPackage.LCLASS__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__NAME = LunTypesPackage.LCLASS__NAME;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__ANNOTATION_INFO = LunTypesPackage.LCLASS__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__ABSTRACT = LunTypesPackage.LCLASS__ABSTRACT;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__SERIALIZABLE = LunTypesPackage.LCLASS__SERIALIZABLE;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__SHORT_NAME = LunTypesPackage.LCLASS__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__FEATURES = LunTypesPackage.LCLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__SUPER_TYPE = LunTypesPackage.LCLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Sub Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__SUB_TYPES = LunTypesPackage.LCLASS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Wrapped Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO__WRAPPED_TYPE = LunTypesPackage.LCLASS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>LDto</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_FEATURE_COUNT = LunTypesPackage.LCLASS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoMapperImpl <em>LDto Mapper</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoMapperImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoMapper()
   * @generated
   */
  int LDTO_MAPPER = 2;

  /**
   * The feature id for the '<em><b>To DTO</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_MAPPER__TO_DTO = 0;

  /**
   * The feature id for the '<em><b>From DTO</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_MAPPER__FROM_DTO = 1;

  /**
   * The number of structural features of the '<em>LDto Mapper</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_MAPPER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoFeatureImpl <em>LDto Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoFeatureImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoFeature()
   * @generated
   */
  int LDTO_FEATURE = 3;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_FEATURE__ANNOTATIONS = LunTypesPackage.LFEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_FEATURE__NAME = LunTypesPackage.LFEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_FEATURE__MULTIPLICITY = LunTypesPackage.LFEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_FEATURE__ANNOTATION_INFO = LunTypesPackage.LFEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Mapper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_FEATURE__MAPPER = LunTypesPackage.LFEATURE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>LDto Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_FEATURE_FEATURE_COUNT = LunTypesPackage.LFEATURE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoAbstractAttributeImpl <em>LDto Abstract Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoAbstractAttributeImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoAbstractAttribute()
   * @generated
   */
  int LDTO_ABSTRACT_ATTRIBUTE = 4;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__ANNOTATIONS = LDTO_FEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__NAME = LDTO_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__MULTIPLICITY = LDTO_FEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__ANNOTATION_INFO = LDTO_FEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Mapper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__MAPPER = LDTO_FEATURE__MAPPER;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__ID = LDTO_FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__VERSION = LDTO_FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__LAZY = LDTO_FEATURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__CASCADING = LDTO_FEATURE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__TRANSIENT = LDTO_FEATURE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE__TYPE = LDTO_FEATURE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>LDto Abstract Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_ATTRIBUTE_FEATURE_COUNT = LDTO_FEATURE_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoInheritedAttributeImpl <em>LDto Inherited Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoInheritedAttributeImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoInheritedAttribute()
   * @generated
   */
  int LDTO_INHERITED_ATTRIBUTE = 5;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__ANNOTATIONS = LDTO_ABSTRACT_ATTRIBUTE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__NAME = LDTO_ABSTRACT_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__MULTIPLICITY = LDTO_ABSTRACT_ATTRIBUTE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__ANNOTATION_INFO = LDTO_ABSTRACT_ATTRIBUTE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Mapper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__MAPPER = LDTO_ABSTRACT_ATTRIBUTE__MAPPER;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__ID = LDTO_ABSTRACT_ATTRIBUTE__ID;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__VERSION = LDTO_ABSTRACT_ATTRIBUTE__VERSION;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__LAZY = LDTO_ABSTRACT_ATTRIBUTE__LAZY;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__CASCADING = LDTO_ABSTRACT_ATTRIBUTE__CASCADING;

  /**
   * The feature id for the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__TRANSIENT = LDTO_ABSTRACT_ATTRIBUTE__TRANSIENT;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__TYPE = LDTO_ABSTRACT_ATTRIBUTE__TYPE;

  /**
   * The feature id for the '<em><b>Inherited Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE = LDTO_ABSTRACT_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>LDto Inherited Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_ATTRIBUTE_FEATURE_COUNT = LDTO_ABSTRACT_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoAttributeImpl <em>LDto Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoAttributeImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoAttribute()
   * @generated
   */
  int LDTO_ATTRIBUTE = 6;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__ANNOTATIONS = LDTO_ABSTRACT_ATTRIBUTE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__NAME = LDTO_ABSTRACT_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__MULTIPLICITY = LDTO_ABSTRACT_ATTRIBUTE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__ANNOTATION_INFO = LDTO_ABSTRACT_ATTRIBUTE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Mapper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__MAPPER = LDTO_ABSTRACT_ATTRIBUTE__MAPPER;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__ID = LDTO_ABSTRACT_ATTRIBUTE__ID;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__VERSION = LDTO_ABSTRACT_ATTRIBUTE__VERSION;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__LAZY = LDTO_ABSTRACT_ATTRIBUTE__LAZY;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__CASCADING = LDTO_ABSTRACT_ATTRIBUTE__CASCADING;

  /**
   * The feature id for the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__TRANSIENT = LDTO_ABSTRACT_ATTRIBUTE__TRANSIENT;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE__TYPE = LDTO_ABSTRACT_ATTRIBUTE__TYPE;

  /**
   * The number of structural features of the '<em>LDto Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ATTRIBUTE_FEATURE_COUNT = LDTO_ABSTRACT_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoAbstractReferenceImpl <em>LDto Abstract Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoAbstractReferenceImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoAbstractReference()
   * @generated
   */
  int LDTO_ABSTRACT_REFERENCE = 7;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_REFERENCE__ANNOTATIONS = LDTO_FEATURE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_REFERENCE__NAME = LDTO_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_REFERENCE__MULTIPLICITY = LDTO_FEATURE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_REFERENCE__ANNOTATION_INFO = LDTO_FEATURE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Mapper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_REFERENCE__MAPPER = LDTO_FEATURE__MAPPER;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_REFERENCE__LAZY = LDTO_FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_REFERENCE__CASCADING = LDTO_FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_REFERENCE__TYPE = LDTO_FEATURE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>LDto Abstract Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_ABSTRACT_REFERENCE_FEATURE_COUNT = LDTO_FEATURE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoInheritedReferenceImpl <em>LDto Inherited Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoInheritedReferenceImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoInheritedReference()
   * @generated
   */
  int LDTO_INHERITED_REFERENCE = 8;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE__ANNOTATIONS = LDTO_ABSTRACT_REFERENCE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE__NAME = LDTO_ABSTRACT_REFERENCE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE__MULTIPLICITY = LDTO_ABSTRACT_REFERENCE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE__ANNOTATION_INFO = LDTO_ABSTRACT_REFERENCE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Mapper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE__MAPPER = LDTO_ABSTRACT_REFERENCE__MAPPER;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE__LAZY = LDTO_ABSTRACT_REFERENCE__LAZY;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE__CASCADING = LDTO_ABSTRACT_REFERENCE__CASCADING;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE__TYPE = LDTO_ABSTRACT_REFERENCE__TYPE;

  /**
   * The feature id for the '<em><b>Inherited Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE__INHERITED_FEATURE = LDTO_ABSTRACT_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>LDto Inherited Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_INHERITED_REFERENCE_FEATURE_COUNT = LDTO_ABSTRACT_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoReferenceImpl <em>LDto Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoReferenceImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoReference()
   * @generated
   */
  int LDTO_REFERENCE = 9;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE__ANNOTATIONS = LDTO_ABSTRACT_REFERENCE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE__NAME = LDTO_ABSTRACT_REFERENCE__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE__MULTIPLICITY = LDTO_ABSTRACT_REFERENCE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE__ANNOTATION_INFO = LDTO_ABSTRACT_REFERENCE__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Mapper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE__MAPPER = LDTO_ABSTRACT_REFERENCE__MAPPER;

  /**
   * The feature id for the '<em><b>Lazy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE__LAZY = LDTO_ABSTRACT_REFERENCE__LAZY;

  /**
   * The feature id for the '<em><b>Cascading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE__CASCADING = LDTO_ABSTRACT_REFERENCE__CASCADING;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE__TYPE = LDTO_ABSTRACT_REFERENCE__TYPE;

  /**
   * The feature id for the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE__OPPOSITE = LDTO_ABSTRACT_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>LDto Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_REFERENCE_FEATURE_COUNT = LDTO_ABSTRACT_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoOperationImpl <em>LDto Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.lunifera.dsl.semantic.dto.impl.LDtoOperationImpl
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoOperation()
   * @generated
   */
  int LDTO_OPERATION = 10;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION__ANNOTATIONS = LunTypesPackage.LOPERATION__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION__MODIFIER = LunTypesPackage.LOPERATION__MODIFIER;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION__TYPE = LunTypesPackage.LOPERATION__TYPE;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION__PARAMS = LunTypesPackage.LOPERATION__PARAMS;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION__BODY = LunTypesPackage.LOPERATION__BODY;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION__NAME = LunTypesPackage.LOPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION__MULTIPLICITY = LunTypesPackage.LOPERATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION__ANNOTATION_INFO = LunTypesPackage.LOPERATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Mapper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION__MAPPER = LunTypesPackage.LOPERATION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>LDto Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LDTO_OPERATION_FEATURE_COUNT = LunTypesPackage.LOPERATION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '<em>Feature List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getDtoFeatureList()
   * @generated
   */
  int DTO_FEATURE_LIST = 11;

  /**
   * The meta object id for the '<em>Operations List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getOperationsList()
   * @generated
   */
  int OPERATIONS_LIST = 12;

  /**
   * The meta object id for the '<em>Reference List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getDtoReferenceList()
   * @generated
   */
  int DTO_REFERENCE_LIST = 13;

  /**
   * The meta object id for the '<em>Attribute List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getDtoAttributeList()
   * @generated
   */
  int DTO_ATTRIBUTE_LIST = 14;


  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoModel <em>LDto Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Model</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoModel
   * @generated
   */
  EClass getLDtoModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.dto.LDtoModel#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoModel#getPackages()
   * @see #getLDtoModel()
   * @generated
   */
  EReference getLDtoModel_Packages();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDto <em>LDto</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDto
   * @generated
   */
  EClass getLDto();

  /**
   * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.semantic.dto.LDto#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDto#getFeatures()
   * @see #getLDto()
   * @generated
   */
  EReference getLDto_Features();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.dto.LDto#getSuperType <em>Super Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Super Type</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDto#getSuperType()
   * @see #getLDto()
   * @generated
   */
  EReference getLDto_SuperType();

  /**
   * Returns the meta object for the reference list '{@link org.lunifera.dsl.semantic.dto.LDto#getSubTypes <em>Sub Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Sub Types</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDto#getSubTypes()
   * @see #getLDto()
   * @generated
   */
  EReference getLDto_SubTypes();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.dto.LDto#getWrappedType <em>Wrapped Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Wrapped Type</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDto#getWrappedType()
   * @see #getLDto()
   * @generated
   */
  EReference getLDto_WrappedType();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoMapper <em>LDto Mapper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Mapper</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoMapper
   * @generated
   */
  EClass getLDtoMapper();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.dto.LDtoMapper#getToDTO <em>To DTO</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To DTO</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoMapper#getToDTO()
   * @see #getLDtoMapper()
   * @generated
   */
  EReference getLDtoMapper_ToDTO();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.dto.LDtoMapper#getFromDTO <em>From DTO</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>From DTO</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoMapper#getFromDTO()
   * @see #getLDtoMapper()
   * @generated
   */
  EReference getLDtoMapper_FromDTO();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoFeature <em>LDto Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Feature</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoFeature
   * @generated
   */
  EClass getLDtoFeature();

  /**
   * Returns the meta object for the containment reference '{@link org.lunifera.dsl.semantic.dto.LDtoFeature#getMapper <em>Mapper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mapper</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoFeature#getMapper()
   * @see #getLDtoFeature()
   * @generated
   */
  EReference getLDtoFeature_Mapper();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute <em>LDto Abstract Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Abstract Attribute</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
   * @generated
   */
  EClass getLDtoAbstractAttribute();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute <em>LDto Inherited Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Inherited Attribute</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute
   * @generated
   */
  EClass getLDtoInheritedAttribute();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute#getInheritedFeature <em>Inherited Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Inherited Feature</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute#getInheritedFeature()
   * @see #getLDtoInheritedAttribute()
   * @generated
   */
  EReference getLDtoInheritedAttribute_InheritedFeature();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoAttribute <em>LDto Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Attribute</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoAttribute
   * @generated
   */
  EClass getLDtoAttribute();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoAbstractReference <em>LDto Abstract Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Abstract Reference</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoAbstractReference
   * @generated
   */
  EClass getLDtoAbstractReference();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.dto.LDtoAbstractReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoAbstractReference#getType()
   * @see #getLDtoAbstractReference()
   * @generated
   */
  EReference getLDtoAbstractReference_Type();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoInheritedReference <em>LDto Inherited Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Inherited Reference</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoInheritedReference
   * @generated
   */
  EClass getLDtoInheritedReference();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.dto.LDtoInheritedReference#getInheritedFeature <em>Inherited Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Inherited Feature</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoInheritedReference#getInheritedFeature()
   * @see #getLDtoInheritedReference()
   * @generated
   */
  EReference getLDtoInheritedReference_InheritedFeature();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoReference <em>LDto Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Reference</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoReference
   * @generated
   */
  EClass getLDtoReference();

  /**
   * Returns the meta object for the reference '{@link org.lunifera.dsl.semantic.dto.LDtoReference#getOpposite <em>Opposite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Opposite</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoReference#getOpposite()
   * @see #getLDtoReference()
   * @generated
   */
  EReference getLDtoReference_Opposite();

  /**
   * Returns the meta object for class '{@link org.lunifera.dsl.semantic.dto.LDtoOperation <em>LDto Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LDto Operation</em>'.
   * @see org.lunifera.dsl.semantic.dto.LDtoOperation
   * @generated
   */
  EClass getLDtoOperation();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Feature List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Feature List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.dto.LDtoFeature>"
   * @generated
   */
  EDataType getDtoFeatureList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Operations List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Operations List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.dto.LDtoOperation>"
   * @generated
   */
  EDataType getOperationsList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Reference List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Reference List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.dto.LDtoReference>"
   * @generated
   */
  EDataType getDtoReferenceList();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Attribute List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Attribute List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List<org.lunifera.dsl.semantic.dto.LDtoAttribute>"
   * @generated
   */
  EDataType getDtoAttributeList();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DtoFactory getDtoFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoModelImpl <em>LDto Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoModelImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoModel()
     * @generated
     */
    EClass LDTO_MODEL = eINSTANCE.getLDtoModel();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_MODEL__PACKAGES = eINSTANCE.getLDtoModel_Packages();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoImpl <em>LDto</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDto()
     * @generated
     */
    EClass LDTO = eINSTANCE.getLDto();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO__FEATURES = eINSTANCE.getLDto_Features();

    /**
     * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO__SUPER_TYPE = eINSTANCE.getLDto_SuperType();

    /**
     * The meta object literal for the '<em><b>Sub Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO__SUB_TYPES = eINSTANCE.getLDto_SubTypes();

    /**
     * The meta object literal for the '<em><b>Wrapped Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO__WRAPPED_TYPE = eINSTANCE.getLDto_WrappedType();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoMapperImpl <em>LDto Mapper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoMapperImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoMapper()
     * @generated
     */
    EClass LDTO_MAPPER = eINSTANCE.getLDtoMapper();

    /**
     * The meta object literal for the '<em><b>To DTO</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_MAPPER__TO_DTO = eINSTANCE.getLDtoMapper_ToDTO();

    /**
     * The meta object literal for the '<em><b>From DTO</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_MAPPER__FROM_DTO = eINSTANCE.getLDtoMapper_FromDTO();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoFeatureImpl <em>LDto Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoFeatureImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoFeature()
     * @generated
     */
    EClass LDTO_FEATURE = eINSTANCE.getLDtoFeature();

    /**
     * The meta object literal for the '<em><b>Mapper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_FEATURE__MAPPER = eINSTANCE.getLDtoFeature_Mapper();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoAbstractAttributeImpl <em>LDto Abstract Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoAbstractAttributeImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoAbstractAttribute()
     * @generated
     */
    EClass LDTO_ABSTRACT_ATTRIBUTE = eINSTANCE.getLDtoAbstractAttribute();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoInheritedAttributeImpl <em>LDto Inherited Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoInheritedAttributeImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoInheritedAttribute()
     * @generated
     */
    EClass LDTO_INHERITED_ATTRIBUTE = eINSTANCE.getLDtoInheritedAttribute();

    /**
     * The meta object literal for the '<em><b>Inherited Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_INHERITED_ATTRIBUTE__INHERITED_FEATURE = eINSTANCE.getLDtoInheritedAttribute_InheritedFeature();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoAttributeImpl <em>LDto Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoAttributeImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoAttribute()
     * @generated
     */
    EClass LDTO_ATTRIBUTE = eINSTANCE.getLDtoAttribute();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoAbstractReferenceImpl <em>LDto Abstract Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoAbstractReferenceImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoAbstractReference()
     * @generated
     */
    EClass LDTO_ABSTRACT_REFERENCE = eINSTANCE.getLDtoAbstractReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_ABSTRACT_REFERENCE__TYPE = eINSTANCE.getLDtoAbstractReference_Type();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoInheritedReferenceImpl <em>LDto Inherited Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoInheritedReferenceImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoInheritedReference()
     * @generated
     */
    EClass LDTO_INHERITED_REFERENCE = eINSTANCE.getLDtoInheritedReference();

    /**
     * The meta object literal for the '<em><b>Inherited Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_INHERITED_REFERENCE__INHERITED_FEATURE = eINSTANCE.getLDtoInheritedReference_InheritedFeature();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoReferenceImpl <em>LDto Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoReferenceImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoReference()
     * @generated
     */
    EClass LDTO_REFERENCE = eINSTANCE.getLDtoReference();

    /**
     * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LDTO_REFERENCE__OPPOSITE = eINSTANCE.getLDtoReference_Opposite();

    /**
     * The meta object literal for the '{@link org.lunifera.dsl.semantic.dto.impl.LDtoOperationImpl <em>LDto Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.lunifera.dsl.semantic.dto.impl.LDtoOperationImpl
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getLDtoOperation()
     * @generated
     */
    EClass LDTO_OPERATION = eINSTANCE.getLDtoOperation();

    /**
     * The meta object literal for the '<em>Feature List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getDtoFeatureList()
     * @generated
     */
    EDataType DTO_FEATURE_LIST = eINSTANCE.getDtoFeatureList();

    /**
     * The meta object literal for the '<em>Operations List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getOperationsList()
     * @generated
     */
    EDataType OPERATIONS_LIST = eINSTANCE.getOperationsList();

    /**
     * The meta object literal for the '<em>Reference List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getDtoReferenceList()
     * @generated
     */
    EDataType DTO_REFERENCE_LIST = eINSTANCE.getDtoReferenceList();

    /**
     * The meta object literal for the '<em>Attribute List</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.lunifera.dsl.semantic.dto.impl.DtoPackageImpl#getDtoAttributeList()
     * @generated
     */
    EDataType DTO_ATTRIBUTE_LIST = eINSTANCE.getDtoAttributeList();

  }

} //DtoPackage

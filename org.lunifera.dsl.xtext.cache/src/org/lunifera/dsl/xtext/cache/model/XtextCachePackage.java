/**
 */
package org.lunifera.dsl.xtext.cache.model;

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
 * @see org.lunifera.dsl.xtext.cache.model.XtextCacheFactory
 * @model kind="package"
 * @generated
 */
public interface XtextCachePackage extends EPackage {
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
	String eNS_URI = "http://www.lunifera.org/xtext/cache/v1";

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
	XtextCachePackage eINSTANCE = org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCCacheContentImpl <em>XC Cache Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XCCacheContentImpl
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCCacheContent()
	 * @generated
	 */
	int XC_CACHE_CONTENT = 0;

	/**
	 * The feature id for the '<em><b>Model Association</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_CACHE_CONTENT__MODEL_ASSOCIATION = 0;

	/**
	 * The feature id for the '<em><b>Members Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_CACHE_CONTENT__MEMBERS_INFO = 1;

	/**
	 * The number of structural features of the '<em>XC Cache Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_CACHE_CONTENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>XC Cache Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_CACHE_CONTENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCJvmModelAssociationImpl <em>XC Jvm Model Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XCJvmModelAssociationImpl
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCJvmModelAssociation()
	 * @generated
	 */
	int XC_JVM_MODEL_ASSOCIATION = 1;

	/**
	 * The feature id for the '<em><b>Source To Targets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_JVM_MODEL_ASSOCIATION__SOURCE_TO_TARGETS = 0;

	/**
	 * The feature id for the '<em><b>Target To Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_JVM_MODEL_ASSOCIATION__TARGET_TO_SOURCES = 1;

	/**
	 * The feature id for the '<em><b>Local Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_JVM_MODEL_ASSOCIATION__LOCAL_CONTAINERS = 2;

	/**
	 * The number of structural features of the '<em>XC Jvm Model Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_JVM_MODEL_ASSOCIATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>XC Jvm Model Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_JVM_MODEL_ASSOCIATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCSourceToTargetImpl <em>XC Source To Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XCSourceToTargetImpl
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCSourceToTarget()
	 * @generated
	 */
	int XC_SOURCE_TO_TARGET = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_SOURCE_TO_TARGET__KEY = 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_SOURCE_TO_TARGET__VALUES = 1;

	/**
	 * The number of structural features of the '<em>XC Source To Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_SOURCE_TO_TARGET_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>XC Source To Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_SOURCE_TO_TARGET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCTargetToSourceImpl <em>XC Target To Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XCTargetToSourceImpl
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCTargetToSource()
	 * @generated
	 */
	int XC_TARGET_TO_SOURCE = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_TARGET_TO_SOURCE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_TARGET_TO_SOURCE__VALUES = 1;

	/**
	 * The number of structural features of the '<em>XC Target To Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_TARGET_TO_SOURCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>XC Target To Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_TARGET_TO_SOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCLogicalContainerImpl <em>XC Logical Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XCLogicalContainerImpl
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCLogicalContainer()
	 * @generated
	 */
	int XC_LOGICAL_CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_LOGICAL_CONTAINER__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_LOGICAL_CONTAINER__VALUE = 1;

	/**
	 * The number of structural features of the '<em>XC Logical Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_LOGICAL_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>XC Logical Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_LOGICAL_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCMemberInfoImpl <em>XC Member Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XCMemberInfoImpl
	 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCMemberInfo()
	 * @generated
	 */
	int XC_MEMBER_INFO = 5;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_MEMBER_INFO__MEMBER = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_MEMBER_INFO__DOCUMENTATION = 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_MEMBER_INFO__BODY = 2;

	/**
	 * The number of structural features of the '<em>XC Member Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_MEMBER_INFO_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>XC Member Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XC_MEMBER_INFO_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.xtext.cache.model.XCCacheContent <em>XC Cache Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XC Cache Content</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCCacheContent
	 * @generated
	 */
	EClass getXCCacheContent();

	/**
	 * Returns the meta object for the containment reference '{@link org.lunifera.dsl.xtext.cache.model.XCCacheContent#getModelAssociation <em>Model Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Association</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCCacheContent#getModelAssociation()
	 * @see #getXCCacheContent()
	 * @generated
	 */
	EReference getXCCacheContent_ModelAssociation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.xtext.cache.model.XCCacheContent#getMembersInfo <em>Members Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members Info</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCCacheContent#getMembersInfo()
	 * @see #getXCCacheContent()
	 * @generated
	 */
	EReference getXCCacheContent_MembersInfo();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation <em>XC Jvm Model Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XC Jvm Model Association</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation
	 * @generated
	 */
	EClass getXCJvmModelAssociation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation#getSourceToTargets <em>Source To Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source To Targets</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation#getSourceToTargets()
	 * @see #getXCJvmModelAssociation()
	 * @generated
	 */
	EReference getXCJvmModelAssociation_SourceToTargets();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation#getTargetToSources <em>Target To Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target To Sources</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation#getTargetToSources()
	 * @see #getXCJvmModelAssociation()
	 * @generated
	 */
	EReference getXCJvmModelAssociation_TargetToSources();

	/**
	 * Returns the meta object for the containment reference list '{@link org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation#getLocalContainers <em>Local Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Containers</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation#getLocalContainers()
	 * @see #getXCJvmModelAssociation()
	 * @generated
	 */
	EReference getXCJvmModelAssociation_LocalContainers();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.xtext.cache.model.XCSourceToTarget <em>XC Source To Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XC Source To Target</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCSourceToTarget
	 * @generated
	 */
	EClass getXCSourceToTarget();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.xtext.cache.model.XCSourceToTarget#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCSourceToTarget#getKey()
	 * @see #getXCSourceToTarget()
	 * @generated
	 */
	EReference getXCSourceToTarget_Key();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.xtext.cache.model.XCSourceToTarget#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCSourceToTarget#getValues()
	 * @see #getXCSourceToTarget()
	 * @generated
	 */
	EReference getXCSourceToTarget_Values();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.xtext.cache.model.XCTargetToSource <em>XC Target To Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XC Target To Source</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCTargetToSource
	 * @generated
	 */
	EClass getXCTargetToSource();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.xtext.cache.model.XCTargetToSource#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCTargetToSource#getKey()
	 * @see #getXCTargetToSource()
	 * @generated
	 */
	EReference getXCTargetToSource_Key();

	/**
	 * Returns the meta object for the reference list '{@link org.lunifera.dsl.xtext.cache.model.XCTargetToSource#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCTargetToSource#getValues()
	 * @see #getXCTargetToSource()
	 * @generated
	 */
	EReference getXCTargetToSource_Values();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.xtext.cache.model.XCLogicalContainer <em>XC Logical Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XC Logical Container</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCLogicalContainer
	 * @generated
	 */
	EClass getXCLogicalContainer();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.xtext.cache.model.XCLogicalContainer#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCLogicalContainer#getKey()
	 * @see #getXCLogicalContainer()
	 * @generated
	 */
	EReference getXCLogicalContainer_Key();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.xtext.cache.model.XCLogicalContainer#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCLogicalContainer#getValue()
	 * @see #getXCLogicalContainer()
	 * @generated
	 */
	EReference getXCLogicalContainer_Value();

	/**
	 * Returns the meta object for class '{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo <em>XC Member Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XC Member Info</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCMemberInfo
	 * @generated
	 */
	EClass getXCMemberInfo();

	/**
	 * Returns the meta object for the reference '{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getMember()
	 * @see #getXCMemberInfo()
	 * @generated
	 */
	EReference getXCMemberInfo_Member();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Documentation</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getDocumentation()
	 * @see #getXCMemberInfo()
	 * @generated
	 */
	EAttribute getXCMemberInfo_Documentation();

	/**
	 * Returns the meta object for the attribute '{@link org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.lunifera.dsl.xtext.cache.model.XCMemberInfo#getBody()
	 * @see #getXCMemberInfo()
	 * @generated
	 */
	EAttribute getXCMemberInfo_Body();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XtextCacheFactory getXtextCacheFactory();

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
		 * The meta object literal for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCCacheContentImpl <em>XC Cache Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XCCacheContentImpl
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCCacheContent()
		 * @generated
		 */
		EClass XC_CACHE_CONTENT = eINSTANCE.getXCCacheContent();

		/**
		 * The meta object literal for the '<em><b>Model Association</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_CACHE_CONTENT__MODEL_ASSOCIATION = eINSTANCE.getXCCacheContent_ModelAssociation();

		/**
		 * The meta object literal for the '<em><b>Members Info</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_CACHE_CONTENT__MEMBERS_INFO = eINSTANCE.getXCCacheContent_MembersInfo();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCJvmModelAssociationImpl <em>XC Jvm Model Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XCJvmModelAssociationImpl
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCJvmModelAssociation()
		 * @generated
		 */
		EClass XC_JVM_MODEL_ASSOCIATION = eINSTANCE.getXCJvmModelAssociation();

		/**
		 * The meta object literal for the '<em><b>Source To Targets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_JVM_MODEL_ASSOCIATION__SOURCE_TO_TARGETS = eINSTANCE.getXCJvmModelAssociation_SourceToTargets();

		/**
		 * The meta object literal for the '<em><b>Target To Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_JVM_MODEL_ASSOCIATION__TARGET_TO_SOURCES = eINSTANCE.getXCJvmModelAssociation_TargetToSources();

		/**
		 * The meta object literal for the '<em><b>Local Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_JVM_MODEL_ASSOCIATION__LOCAL_CONTAINERS = eINSTANCE.getXCJvmModelAssociation_LocalContainers();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCSourceToTargetImpl <em>XC Source To Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XCSourceToTargetImpl
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCSourceToTarget()
		 * @generated
		 */
		EClass XC_SOURCE_TO_TARGET = eINSTANCE.getXCSourceToTarget();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_SOURCE_TO_TARGET__KEY = eINSTANCE.getXCSourceToTarget_Key();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_SOURCE_TO_TARGET__VALUES = eINSTANCE.getXCSourceToTarget_Values();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCTargetToSourceImpl <em>XC Target To Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XCTargetToSourceImpl
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCTargetToSource()
		 * @generated
		 */
		EClass XC_TARGET_TO_SOURCE = eINSTANCE.getXCTargetToSource();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_TARGET_TO_SOURCE__KEY = eINSTANCE.getXCTargetToSource_Key();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_TARGET_TO_SOURCE__VALUES = eINSTANCE.getXCTargetToSource_Values();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCLogicalContainerImpl <em>XC Logical Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XCLogicalContainerImpl
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCLogicalContainer()
		 * @generated
		 */
		EClass XC_LOGICAL_CONTAINER = eINSTANCE.getXCLogicalContainer();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_LOGICAL_CONTAINER__KEY = eINSTANCE.getXCLogicalContainer_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_LOGICAL_CONTAINER__VALUE = eINSTANCE.getXCLogicalContainer_Value();

		/**
		 * The meta object literal for the '{@link org.lunifera.dsl.xtext.cache.model.impl.XCMemberInfoImpl <em>XC Member Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XCMemberInfoImpl
		 * @see org.lunifera.dsl.xtext.cache.model.impl.XtextCachePackageImpl#getXCMemberInfo()
		 * @generated
		 */
		EClass XC_MEMBER_INFO = eINSTANCE.getXCMemberInfo();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XC_MEMBER_INFO__MEMBER = eINSTANCE.getXCMemberInfo_Member();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XC_MEMBER_INFO__DOCUMENTATION = eINSTANCE.getXCMemberInfo_Documentation();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XC_MEMBER_INFO__BODY = eINSTANCE.getXCMemberInfo_Body();

	}

} //XtextCachePackage

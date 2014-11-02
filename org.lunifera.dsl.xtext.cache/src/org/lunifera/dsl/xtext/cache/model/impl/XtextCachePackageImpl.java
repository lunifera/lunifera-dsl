/**
 */
package org.lunifera.dsl.xtext.cache.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.lunifera.dsl.xtext.cache.model.XCCacheContent;
import org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation;
import org.lunifera.dsl.xtext.cache.model.XCLogicalContainer;
import org.lunifera.dsl.xtext.cache.model.XCMemberInfo;
import org.lunifera.dsl.xtext.cache.model.XCSourceToTarget;
import org.lunifera.dsl.xtext.cache.model.XCTargetToSource;
import org.lunifera.dsl.xtext.cache.model.XtextCacheFactory;
import org.lunifera.dsl.xtext.cache.model.XtextCachePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextCachePackageImpl extends EPackageImpl implements XtextCachePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xcCacheContentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xcJvmModelAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xcSourceToTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xcTargetToSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xcLogicalContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xcMemberInfoEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.lunifera.dsl.xtext.cache.model.XtextCachePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XtextCachePackageImpl() {
		super(eNS_URI, XtextCacheFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link XtextCachePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XtextCachePackage init() {
		if (isInited) return (XtextCachePackage)EPackage.Registry.INSTANCE.getEPackage(XtextCachePackage.eNS_URI);

		// Obtain or create and register package
		XtextCachePackageImpl theXtextCachePackage = (XtextCachePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XtextCachePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XtextCachePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theXtextCachePackage.createPackageContents();

		// Initialize created meta-data
		theXtextCachePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXtextCachePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XtextCachePackage.eNS_URI, theXtextCachePackage);
		return theXtextCachePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCCacheContent() {
		return xcCacheContentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCCacheContent_ModelAssociation() {
		return (EReference)xcCacheContentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCCacheContent_MembersInfo() {
		return (EReference)xcCacheContentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCJvmModelAssociation() {
		return xcJvmModelAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCJvmModelAssociation_SourceToTargets() {
		return (EReference)xcJvmModelAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCJvmModelAssociation_TargetToSources() {
		return (EReference)xcJvmModelAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCJvmModelAssociation_LocalContainers() {
		return (EReference)xcJvmModelAssociationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCSourceToTarget() {
		return xcSourceToTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCSourceToTarget_Key() {
		return (EReference)xcSourceToTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCSourceToTarget_Values() {
		return (EReference)xcSourceToTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCTargetToSource() {
		return xcTargetToSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCTargetToSource_Key() {
		return (EReference)xcTargetToSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCTargetToSource_Values() {
		return (EReference)xcTargetToSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCLogicalContainer() {
		return xcLogicalContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCLogicalContainer_Key() {
		return (EReference)xcLogicalContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCLogicalContainer_Value() {
		return (EReference)xcLogicalContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCMemberInfo() {
		return xcMemberInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCMemberInfo_Member() {
		return (EReference)xcMemberInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXCMemberInfo_Documentation() {
		return (EAttribute)xcMemberInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXCMemberInfo_Body() {
		return (EAttribute)xcMemberInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextCacheFactory getXtextCacheFactory() {
		return (XtextCacheFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xcCacheContentEClass = createEClass(XC_CACHE_CONTENT);
		createEReference(xcCacheContentEClass, XC_CACHE_CONTENT__MODEL_ASSOCIATION);
		createEReference(xcCacheContentEClass, XC_CACHE_CONTENT__MEMBERS_INFO);

		xcJvmModelAssociationEClass = createEClass(XC_JVM_MODEL_ASSOCIATION);
		createEReference(xcJvmModelAssociationEClass, XC_JVM_MODEL_ASSOCIATION__SOURCE_TO_TARGETS);
		createEReference(xcJvmModelAssociationEClass, XC_JVM_MODEL_ASSOCIATION__TARGET_TO_SOURCES);
		createEReference(xcJvmModelAssociationEClass, XC_JVM_MODEL_ASSOCIATION__LOCAL_CONTAINERS);

		xcSourceToTargetEClass = createEClass(XC_SOURCE_TO_TARGET);
		createEReference(xcSourceToTargetEClass, XC_SOURCE_TO_TARGET__KEY);
		createEReference(xcSourceToTargetEClass, XC_SOURCE_TO_TARGET__VALUES);

		xcTargetToSourceEClass = createEClass(XC_TARGET_TO_SOURCE);
		createEReference(xcTargetToSourceEClass, XC_TARGET_TO_SOURCE__KEY);
		createEReference(xcTargetToSourceEClass, XC_TARGET_TO_SOURCE__VALUES);

		xcLogicalContainerEClass = createEClass(XC_LOGICAL_CONTAINER);
		createEReference(xcLogicalContainerEClass, XC_LOGICAL_CONTAINER__KEY);
		createEReference(xcLogicalContainerEClass, XC_LOGICAL_CONTAINER__VALUE);

		xcMemberInfoEClass = createEClass(XC_MEMBER_INFO);
		createEReference(xcMemberInfoEClass, XC_MEMBER_INFO__MEMBER);
		createEAttribute(xcMemberInfoEClass, XC_MEMBER_INFO__DOCUMENTATION);
		createEAttribute(xcMemberInfoEClass, XC_MEMBER_INFO__BODY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(xcCacheContentEClass, XCCacheContent.class, "XCCacheContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCCacheContent_ModelAssociation(), this.getXCJvmModelAssociation(), null, "modelAssociation", null, 0, 1, XCCacheContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCCacheContent_MembersInfo(), this.getXCMemberInfo(), null, "membersInfo", null, 0, -1, XCCacheContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xcJvmModelAssociationEClass, XCJvmModelAssociation.class, "XCJvmModelAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCJvmModelAssociation_SourceToTargets(), this.getXCSourceToTarget(), null, "sourceToTargets", null, 0, -1, XCJvmModelAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCJvmModelAssociation_TargetToSources(), this.getXCTargetToSource(), null, "targetToSources", null, 0, -1, XCJvmModelAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCJvmModelAssociation_LocalContainers(), this.getXCLogicalContainer(), null, "localContainers", null, 0, -1, XCJvmModelAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xcSourceToTargetEClass, XCSourceToTarget.class, "XCSourceToTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCSourceToTarget_Key(), ecorePackage.getEObject(), null, "key", null, 0, 1, XCSourceToTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCSourceToTarget_Values(), ecorePackage.getEObject(), null, "values", null, 0, -1, XCSourceToTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xcTargetToSourceEClass, XCTargetToSource.class, "XCTargetToSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCTargetToSource_Key(), ecorePackage.getEObject(), null, "key", null, 0, 1, XCTargetToSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCTargetToSource_Values(), ecorePackage.getEObject(), null, "values", null, 0, -1, XCTargetToSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xcLogicalContainerEClass, XCLogicalContainer.class, "XCLogicalContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCLogicalContainer_Key(), ecorePackage.getEObject(), null, "key", null, 0, 1, XCLogicalContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCLogicalContainer_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, XCLogicalContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xcMemberInfoEClass, XCMemberInfo.class, "XCMemberInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCMemberInfo_Member(), ecorePackage.getEObject(), null, "member", null, 0, 1, XCMemberInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXCMemberInfo_Documentation(), ecorePackage.getEString(), "documentation", null, 0, 1, XCMemberInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXCMemberInfo_Body(), ecorePackage.getEString(), "body", null, 0, 1, XCMemberInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XtextCachePackageImpl

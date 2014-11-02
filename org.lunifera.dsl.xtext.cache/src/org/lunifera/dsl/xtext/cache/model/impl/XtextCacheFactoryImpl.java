/**
 */
package org.lunifera.dsl.xtext.cache.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.lunifera.dsl.xtext.cache.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextCacheFactoryImpl extends EFactoryImpl implements XtextCacheFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XtextCacheFactory init() {
		try {
			XtextCacheFactory theXtextCacheFactory = (XtextCacheFactory)EPackage.Registry.INSTANCE.getEFactory(XtextCachePackage.eNS_URI);
			if (theXtextCacheFactory != null) {
				return theXtextCacheFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XtextCacheFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextCacheFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XtextCachePackage.XC_CACHE_CONTENT: return createXCCacheContent();
			case XtextCachePackage.XC_JVM_MODEL_ASSOCIATION: return createXCJvmModelAssociation();
			case XtextCachePackage.XC_SOURCE_TO_TARGET: return createXCSourceToTarget();
			case XtextCachePackage.XC_TARGET_TO_SOURCE: return createXCTargetToSource();
			case XtextCachePackage.XC_LOGICAL_CONTAINER: return createXCLogicalContainer();
			case XtextCachePackage.XC_MEMBER_INFO: return createXCMemberInfo();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCCacheContent createXCCacheContent() {
		XCCacheContentImpl xcCacheContent = new XCCacheContentImpl();
		return xcCacheContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCJvmModelAssociation createXCJvmModelAssociation() {
		XCJvmModelAssociationImpl xcJvmModelAssociation = new XCJvmModelAssociationImpl();
		return xcJvmModelAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCSourceToTarget createXCSourceToTarget() {
		XCSourceToTargetImpl xcSourceToTarget = new XCSourceToTargetImpl();
		return xcSourceToTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCTargetToSource createXCTargetToSource() {
		XCTargetToSourceImpl xcTargetToSource = new XCTargetToSourceImpl();
		return xcTargetToSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCLogicalContainer createXCLogicalContainer() {
		XCLogicalContainerImpl xcLogicalContainer = new XCLogicalContainerImpl();
		return xcLogicalContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCMemberInfo createXCMemberInfo() {
		XCMemberInfoImpl xcMemberInfo = new XCMemberInfoImpl();
		return xcMemberInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextCachePackage getXtextCachePackage() {
		return (XtextCachePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XtextCachePackage getPackage() {
		return XtextCachePackage.eINSTANCE;
	}

} //XtextCacheFactoryImpl

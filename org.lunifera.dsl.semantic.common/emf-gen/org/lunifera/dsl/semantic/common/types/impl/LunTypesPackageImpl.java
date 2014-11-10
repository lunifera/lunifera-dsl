/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
 * 
 *  Based on ideas from Xtext, Xtend, Xcore
 *   
 *  Contributors:  
 *  		Florian Pirchner - Initial implementation 
 *  
 */
package org.lunifera.dsl.semantic.common.types.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

import org.lunifera.dsl.semantic.common.types.LAnnotationDef;
import org.lunifera.dsl.semantic.common.types.LAnnotationTarget;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LCommonModel;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LDateType;
import org.lunifera.dsl.semantic.common.types.LEnum;
import org.lunifera.dsl.semantic.common.types.LEnumLiteral;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LFeaturesHolder;
import org.lunifera.dsl.semantic.common.types.LImport;
import org.lunifera.dsl.semantic.common.types.LLowerBound;
import org.lunifera.dsl.semantic.common.types.LModifier;
import org.lunifera.dsl.semantic.common.types.LMultiplicity;
import org.lunifera.dsl.semantic.common.types.LOperation;
import org.lunifera.dsl.semantic.common.types.LPackage;
import org.lunifera.dsl.semantic.common.types.LReference;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.common.types.LUpperBound;
import org.lunifera.dsl.semantic.common.types.LVisibility;
import org.lunifera.dsl.semantic.common.types.LunTypesFactory;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LunTypesPackageImpl extends EPackageImpl implements LunTypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lCommonModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lTypedPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lAnnotationDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lAnnotationTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lScalarTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lEnumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lEnumLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lFeaturesHolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lMultiplicityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lDateTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lVisibilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lLowerBoundEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lUpperBoundEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType operationsListEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType featuresListEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType annotationListEDataType = null;

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
	 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LunTypesPackageImpl() {
		super(eNS_URI, LunTypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LunTypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LunTypesPackage init() {
		if (isInited) return (LunTypesPackage)EPackage.Registry.INSTANCE.getEPackage(LunTypesPackage.eNS_URI);

		// Obtain or create and register package
		LunTypesPackageImpl theLunTypesPackage = (LunTypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LunTypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LunTypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XbasePackage.eINSTANCE.eClass();
		XAnnotationsPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLunTypesPackage.createPackageContents();

		// Initialize created meta-data
		theLunTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLunTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LunTypesPackage.eNS_URI, theLunTypesPackage);
		return theLunTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLCommonModel() {
		return lCommonModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLCommonModel_Packages() {
		return (EReference)lCommonModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLPackage() {
		return lPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLPackage_Name() {
		return (EAttribute)lPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLPackage_Imports() {
		return (EReference)lPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLTypedPackage() {
		return lTypedPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLTypedPackage_Types() {
		return (EReference)lTypedPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLImport() {
		return lImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLImport_ImportedNamespace() {
		return (EAttribute)lImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLType() {
		return lTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLType_Name() {
		return (EAttribute)lTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLType_AnnotationInfo() {
		return (EReference)lTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLType__GetResolvedAnnotations() {
		return lTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLAnnotationDef() {
		return lAnnotationDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAnnotationDef_Exclude() {
		return (EAttribute)lAnnotationDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLAnnotationDef_Annotation() {
		return (EReference)lAnnotationDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLAnnotationTarget() {
		return lAnnotationTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLAnnotationTarget_Annotations() {
		return (EReference)lAnnotationTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLScalarType() {
		return lScalarTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLDataType() {
		return lDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLDataType_JvmTypeReference() {
		return (EReference)lDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLDataType_AsPrimitive() {
		return (EAttribute)lDataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLDataType_Date() {
		return (EAttribute)lDataTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLDataType_AsBlob() {
		return (EAttribute)lDataTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLDataType_Length() {
		return (EAttribute)lDataTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLDataType_DateType() {
		return (EAttribute)lDataTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLDataType_SyntheticFlag() {
		return (EAttribute)lDataTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLDataType_SyntheticSelector() {
		return (EAttribute)lDataTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLDataType_SyntheticTypeReference() {
		return (EReference)lDataTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLDataType_SyntheticType() {
		return (EReference)lDataTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEnum() {
		return lEnumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLEnum_Literals() {
		return (EReference)lEnumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEnumLiteral() {
		return lEnumLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLEnumLiteral_Name() {
		return (EAttribute)lEnumLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLClass() {
		return lClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLClass_Abstract() {
		return (EAttribute)lClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLClass_Serializable() {
		return (EAttribute)lClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLClass_ShortName() {
		return (EAttribute)lClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLFeaturesHolder() {
		return lFeaturesHolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLFeaturesHolder__GetFeatures() {
		return lFeaturesHolderEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLFeaturesHolder__GetAllFeatures() {
		return lFeaturesHolderEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLFeature() {
		return lFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLFeature_Name() {
		return (EAttribute)lFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLFeature_Multiplicity() {
		return (EReference)lFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLFeature_AnnotationInfo() {
		return (EReference)lFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLFeature__GetResolvedAnnotations() {
		return lFeatureEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLReference() {
		return lReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLReference_Lazy() {
		return (EAttribute)lReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLReference_Cascading() {
		return (EAttribute)lReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLAttribute() {
		return lAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAttribute_Id() {
		return (EAttribute)lAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAttribute_Uuid() {
		return (EAttribute)lAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAttribute_Version() {
		return (EAttribute)lAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAttribute_Lazy() {
		return (EAttribute)lAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAttribute_Cascading() {
		return (EAttribute)lAttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAttribute_Transient() {
		return (EAttribute)lAttributeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAttribute_Derived() {
		return (EAttribute)lAttributeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAttribute_DomainKey() {
		return (EAttribute)lAttributeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLAttribute_DomainDescription() {
		return (EAttribute)lAttributeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLAttribute_DerivedGetterExpression() {
		return (EReference)lAttributeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLAttribute_Type() {
		return (EReference)lAttributeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLOperation() {
		return lOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLOperation_Modifier() {
		return (EReference)lOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLOperation_Type() {
		return (EReference)lOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLOperation_Params() {
		return (EReference)lOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLOperation_Body() {
		return (EReference)lOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLOperation__GetResolvedAnnotations() {
		return lOperationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLModifier() {
		return lModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLModifier_Final() {
		return (EAttribute)lModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLModifier_Static() {
		return (EAttribute)lModifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLModifier_Visibility() {
		return (EAttribute)lModifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLMultiplicity() {
		return lMultiplicityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLMultiplicity_Lower() {
		return (EAttribute)lMultiplicityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLMultiplicity_Upper() {
		return (EAttribute)lMultiplicityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLDateType() {
		return lDateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLVisibility() {
		return lVisibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLLowerBound() {
		return lLowerBoundEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLUpperBound() {
		return lUpperBoundEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOperationsList() {
		return operationsListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFeaturesList() {
		return featuresListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAnnotationList() {
		return annotationListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LunTypesFactory getLunTypesFactory() {
		return (LunTypesFactory)getEFactoryInstance();
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
		lCommonModelEClass = createEClass(LCOMMON_MODEL);
		createEReference(lCommonModelEClass, LCOMMON_MODEL__PACKAGES);

		lPackageEClass = createEClass(LPACKAGE);
		createEAttribute(lPackageEClass, LPACKAGE__NAME);
		createEReference(lPackageEClass, LPACKAGE__IMPORTS);

		lTypedPackageEClass = createEClass(LTYPED_PACKAGE);
		createEReference(lTypedPackageEClass, LTYPED_PACKAGE__TYPES);

		lImportEClass = createEClass(LIMPORT);
		createEAttribute(lImportEClass, LIMPORT__IMPORTED_NAMESPACE);

		lTypeEClass = createEClass(LTYPE);
		createEAttribute(lTypeEClass, LTYPE__NAME);
		createEReference(lTypeEClass, LTYPE__ANNOTATION_INFO);
		createEOperation(lTypeEClass, LTYPE___GET_RESOLVED_ANNOTATIONS);

		lAnnotationDefEClass = createEClass(LANNOTATION_DEF);
		createEAttribute(lAnnotationDefEClass, LANNOTATION_DEF__EXCLUDE);
		createEReference(lAnnotationDefEClass, LANNOTATION_DEF__ANNOTATION);

		lAnnotationTargetEClass = createEClass(LANNOTATION_TARGET);
		createEReference(lAnnotationTargetEClass, LANNOTATION_TARGET__ANNOTATIONS);

		lScalarTypeEClass = createEClass(LSCALAR_TYPE);

		lDataTypeEClass = createEClass(LDATA_TYPE);
		createEReference(lDataTypeEClass, LDATA_TYPE__JVM_TYPE_REFERENCE);
		createEAttribute(lDataTypeEClass, LDATA_TYPE__AS_PRIMITIVE);
		createEAttribute(lDataTypeEClass, LDATA_TYPE__DATE);
		createEAttribute(lDataTypeEClass, LDATA_TYPE__AS_BLOB);
		createEAttribute(lDataTypeEClass, LDATA_TYPE__LENGTH);
		createEAttribute(lDataTypeEClass, LDATA_TYPE__DATE_TYPE);
		createEAttribute(lDataTypeEClass, LDATA_TYPE__SYNTHETIC_FLAG);
		createEAttribute(lDataTypeEClass, LDATA_TYPE__SYNTHETIC_SELECTOR);
		createEReference(lDataTypeEClass, LDATA_TYPE__SYNTHETIC_TYPE_REFERENCE);
		createEReference(lDataTypeEClass, LDATA_TYPE__SYNTHETIC_TYPE);

		lEnumEClass = createEClass(LENUM);
		createEReference(lEnumEClass, LENUM__LITERALS);

		lEnumLiteralEClass = createEClass(LENUM_LITERAL);
		createEAttribute(lEnumLiteralEClass, LENUM_LITERAL__NAME);

		lClassEClass = createEClass(LCLASS);
		createEAttribute(lClassEClass, LCLASS__ABSTRACT);
		createEAttribute(lClassEClass, LCLASS__SERIALIZABLE);
		createEAttribute(lClassEClass, LCLASS__SHORT_NAME);

		lFeaturesHolderEClass = createEClass(LFEATURES_HOLDER);
		createEOperation(lFeaturesHolderEClass, LFEATURES_HOLDER___GET_FEATURES);
		createEOperation(lFeaturesHolderEClass, LFEATURES_HOLDER___GET_ALL_FEATURES);

		lFeatureEClass = createEClass(LFEATURE);
		createEAttribute(lFeatureEClass, LFEATURE__NAME);
		createEReference(lFeatureEClass, LFEATURE__MULTIPLICITY);
		createEReference(lFeatureEClass, LFEATURE__ANNOTATION_INFO);
		createEOperation(lFeatureEClass, LFEATURE___GET_RESOLVED_ANNOTATIONS);

		lReferenceEClass = createEClass(LREFERENCE);
		createEAttribute(lReferenceEClass, LREFERENCE__LAZY);
		createEAttribute(lReferenceEClass, LREFERENCE__CASCADING);

		lAttributeEClass = createEClass(LATTRIBUTE);
		createEAttribute(lAttributeEClass, LATTRIBUTE__ID);
		createEAttribute(lAttributeEClass, LATTRIBUTE__UUID);
		createEAttribute(lAttributeEClass, LATTRIBUTE__VERSION);
		createEAttribute(lAttributeEClass, LATTRIBUTE__LAZY);
		createEAttribute(lAttributeEClass, LATTRIBUTE__CASCADING);
		createEAttribute(lAttributeEClass, LATTRIBUTE__TRANSIENT);
		createEAttribute(lAttributeEClass, LATTRIBUTE__DERIVED);
		createEAttribute(lAttributeEClass, LATTRIBUTE__DOMAIN_KEY);
		createEAttribute(lAttributeEClass, LATTRIBUTE__DOMAIN_DESCRIPTION);
		createEReference(lAttributeEClass, LATTRIBUTE__DERIVED_GETTER_EXPRESSION);
		createEReference(lAttributeEClass, LATTRIBUTE__TYPE);

		lOperationEClass = createEClass(LOPERATION);
		createEReference(lOperationEClass, LOPERATION__MODIFIER);
		createEReference(lOperationEClass, LOPERATION__TYPE);
		createEReference(lOperationEClass, LOPERATION__PARAMS);
		createEReference(lOperationEClass, LOPERATION__BODY);
		createEOperation(lOperationEClass, LOPERATION___GET_RESOLVED_ANNOTATIONS);

		lModifierEClass = createEClass(LMODIFIER);
		createEAttribute(lModifierEClass, LMODIFIER__FINAL);
		createEAttribute(lModifierEClass, LMODIFIER__STATIC);
		createEAttribute(lModifierEClass, LMODIFIER__VISIBILITY);

		lMultiplicityEClass = createEClass(LMULTIPLICITY);
		createEAttribute(lMultiplicityEClass, LMULTIPLICITY__LOWER);
		createEAttribute(lMultiplicityEClass, LMULTIPLICITY__UPPER);

		// Create enums
		lDateTypeEEnum = createEEnum(LDATE_TYPE);
		lVisibilityEEnum = createEEnum(LVISIBILITY);
		lLowerBoundEEnum = createEEnum(LLOWER_BOUND);
		lUpperBoundEEnum = createEEnum(LUPPER_BOUND);

		// Create data types
		operationsListEDataType = createEDataType(OPERATIONS_LIST);
		featuresListEDataType = createEDataType(FEATURES_LIST);
		annotationListEDataType = createEDataType(ANNOTATION_LIST);
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

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		XAnnotationsPackage theXAnnotationsPackage = (XAnnotationsPackage)EPackage.Registry.INSTANCE.getEPackage(XAnnotationsPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		lTypedPackageEClass.getESuperTypes().add(this.getLPackage());
		lTypeEClass.getESuperTypes().add(this.getLAnnotationTarget());
		lScalarTypeEClass.getESuperTypes().add(this.getLType());
		lDataTypeEClass.getESuperTypes().add(this.getLScalarType());
		lEnumEClass.getESuperTypes().add(this.getLScalarType());
		lClassEClass.getESuperTypes().add(this.getLType());
		lFeatureEClass.getESuperTypes().add(this.getLAnnotationTarget());
		lReferenceEClass.getESuperTypes().add(this.getLFeature());
		lAttributeEClass.getESuperTypes().add(this.getLFeature());
		lOperationEClass.getESuperTypes().add(this.getLAnnotationTarget());

		// Initialize classes, features, and operations; add parameters
		initEClass(lCommonModelEClass, LCommonModel.class, "LCommonModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLCommonModel_Packages(), this.getLTypedPackage(), null, "packages", null, 0, -1, LCommonModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lPackageEClass, LPackage.class, "LPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLPackage_Name(), theEcorePackage.getEString(), "name", null, 0, 1, LPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLPackage_Imports(), this.getLImport(), null, "imports", null, 0, -1, LPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lTypedPackageEClass, LTypedPackage.class, "LTypedPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLTypedPackage_Types(), this.getLType(), null, "types", null, 0, -1, LTypedPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lImportEClass, LImport.class, "LImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLImport_ImportedNamespace(), theEcorePackage.getEString(), "importedNamespace", null, 0, 1, LImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lTypeEClass, LType.class, "LType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLType_Name(), theEcorePackage.getEString(), "name", null, 0, 1, LType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLType_AnnotationInfo(), this.getLAnnotationTarget(), null, "annotationInfo", null, 0, 1, LType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getLType__GetResolvedAnnotations(), this.getAnnotationList(), "getResolvedAnnotations", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(lAnnotationDefEClass, LAnnotationDef.class, "LAnnotationDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLAnnotationDef_Exclude(), theEcorePackage.getEBoolean(), "exclude", null, 0, 1, LAnnotationDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLAnnotationDef_Annotation(), theXAnnotationsPackage.getXAnnotation(), null, "annotation", null, 0, 1, LAnnotationDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lAnnotationTargetEClass, LAnnotationTarget.class, "LAnnotationTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLAnnotationTarget_Annotations(), this.getLAnnotationDef(), null, "annotations", null, 0, -1, LAnnotationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lScalarTypeEClass, LScalarType.class, "LScalarType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lDataTypeEClass, LDataType.class, "LDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLDataType_JvmTypeReference(), theTypesPackage.getJvmTypeReference(), null, "jvmTypeReference", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLDataType_AsPrimitive(), theEcorePackage.getEBoolean(), "asPrimitive", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLDataType_Date(), theEcorePackage.getEBoolean(), "date", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLDataType_AsBlob(), theEcorePackage.getEBoolean(), "asBlob", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLDataType_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLDataType_DateType(), this.getLDateType(), "dateType", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLDataType_SyntheticFlag(), theEcorePackage.getEBoolean(), "syntheticFlag", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLDataType_SyntheticSelector(), theEcorePackage.getEString(), "syntheticSelector", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLDataType_SyntheticTypeReference(), this.getLFeature(), null, "syntheticTypeReference", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLDataType_SyntheticType(), this.getLType(), null, "syntheticType", null, 0, 1, LDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lEnumEClass, LEnum.class, "LEnum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLEnum_Literals(), this.getLEnumLiteral(), null, "literals", null, 0, -1, LEnum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lEnumLiteralEClass, LEnumLiteral.class, "LEnumLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLEnumLiteral_Name(), theEcorePackage.getEString(), "name", null, 0, 1, LEnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lClassEClass, LClass.class, "LClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLClass_Abstract(), theEcorePackage.getEBoolean(), "abstract", null, 0, 1, LClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLClass_Serializable(), theEcorePackage.getEBoolean(), "serializable", null, 0, 1, LClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLClass_ShortName(), theEcorePackage.getEString(), "shortName", null, 0, 1, LClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lFeaturesHolderEClass, LFeaturesHolder.class, "LFeaturesHolder", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getLFeaturesHolder__GetFeatures(), this.getFeaturesList(), "getFeatures", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getLFeaturesHolder__GetAllFeatures(), this.getFeaturesList(), "getAllFeatures", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(lFeatureEClass, LFeature.class, "LFeature", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLFeature_Name(), theEcorePackage.getEString(), "name", null, 0, 1, LFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLFeature_Multiplicity(), this.getLMultiplicity(), null, "multiplicity", null, 0, 1, LFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLFeature_AnnotationInfo(), this.getLAnnotationTarget(), null, "annotationInfo", null, 0, 1, LFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getLFeature__GetResolvedAnnotations(), this.getAnnotationList(), "getResolvedAnnotations", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(lReferenceEClass, LReference.class, "LReference", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLReference_Lazy(), theEcorePackage.getEBoolean(), "lazy", null, 0, 1, LReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLReference_Cascading(), theEcorePackage.getEBoolean(), "cascading", null, 0, 1, LReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lAttributeEClass, LAttribute.class, "LAttribute", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLAttribute_Id(), theEcorePackage.getEBoolean(), "id", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAttribute_Uuid(), theEcorePackage.getEBoolean(), "uuid", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAttribute_Version(), theEcorePackage.getEBoolean(), "version", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAttribute_Lazy(), theEcorePackage.getEBoolean(), "lazy", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAttribute_Cascading(), theEcorePackage.getEBoolean(), "cascading", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAttribute_Transient(), theEcorePackage.getEBoolean(), "transient", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAttribute_Derived(), theEcorePackage.getEBoolean(), "derived", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAttribute_DomainKey(), theEcorePackage.getEBoolean(), "domainKey", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLAttribute_DomainDescription(), theEcorePackage.getEBoolean(), "domainDescription", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLAttribute_DerivedGetterExpression(), theXbasePackage.getXExpression(), null, "derivedGetterExpression", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLAttribute_Type(), this.getLScalarType(), null, "type", null, 0, 1, LAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lOperationEClass, LOperation.class, "LOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLOperation_Modifier(), this.getLModifier(), null, "modifier", null, 0, 1, LOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLOperation_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, LOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLOperation_Params(), theTypesPackage.getJvmFormalParameter(), null, "params", null, 0, -1, LOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLOperation_Body(), theXbasePackage.getXExpression(), null, "body", null, 0, 1, LOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getLOperation__GetResolvedAnnotations(), this.getAnnotationList(), "getResolvedAnnotations", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(lModifierEClass, LModifier.class, "LModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLModifier_Final(), theEcorePackage.getEBoolean(), "final", null, 0, 1, LModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLModifier_Static(), theEcorePackage.getEBoolean(), "static", null, 0, 1, LModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLModifier_Visibility(), this.getLVisibility(), "visibility", null, 0, 1, LModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lMultiplicityEClass, LMultiplicity.class, "LMultiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLMultiplicity_Lower(), this.getLLowerBound(), "lower", null, 0, 1, LMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLMultiplicity_Upper(), this.getLUpperBound(), "upper", null, 0, 1, LMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(lDateTypeEEnum, LDateType.class, "LDateType");
		addEEnumLiteral(lDateTypeEEnum, LDateType.DATE);
		addEEnumLiteral(lDateTypeEEnum, LDateType.TIME);
		addEEnumLiteral(lDateTypeEEnum, LDateType.TIMESTAMP);

		initEEnum(lVisibilityEEnum, LVisibility.class, "LVisibility");
		addEEnumLiteral(lVisibilityEEnum, LVisibility.PACKAGE);
		addEEnumLiteral(lVisibilityEEnum, LVisibility.PRIVATE);
		addEEnumLiteral(lVisibilityEEnum, LVisibility.PROTECTED);
		addEEnumLiteral(lVisibilityEEnum, LVisibility.PUBLIC);

		initEEnum(lLowerBoundEEnum, LLowerBound.class, "LLowerBound");
		addEEnumLiteral(lLowerBoundEEnum, LLowerBound.NULL);
		addEEnumLiteral(lLowerBoundEEnum, LLowerBound.MANY);
		addEEnumLiteral(lLowerBoundEEnum, LLowerBound.OPTIONAL);
		addEEnumLiteral(lLowerBoundEEnum, LLowerBound.ATLEASTONE);
		addEEnumLiteral(lLowerBoundEEnum, LLowerBound.ZERO);
		addEEnumLiteral(lLowerBoundEEnum, LLowerBound.ONE);

		initEEnum(lUpperBoundEEnum, LUpperBound.class, "LUpperBound");
		addEEnumLiteral(lUpperBoundEEnum, LUpperBound.NULL);
		addEEnumLiteral(lUpperBoundEEnum, LUpperBound.MANY);
		addEEnumLiteral(lUpperBoundEEnum, LUpperBound.ONE);

		// Initialize data types
		initEDataType(operationsListEDataType, List.class, "OperationsList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.lunifera.dsl.semantic.common.types.LOperation>");
		initEDataType(featuresListEDataType, List.class, "FeaturesList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<? extends org.lunifera.dsl.semantic.common.types.LFeature>");
		initEDataType(annotationListEDataType, EList.class, "AnnotationList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "org.eclipse.emf.common.util.EList<org.lunifera.dsl.semantic.common.types.LAnnotationDef>");

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "rootPackage", "types"
		   });
	}

} //LunTypesPackageImpl

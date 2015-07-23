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
package org.lunifera.dsl.semantic.common.types.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.lunifera.dsl.semantic.common.types.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.common.types.LunTypesPackage
 * @generated
 */
public class LunTypesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LunTypesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LunTypesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LunTypesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LunTypesSwitch<Adapter> modelSwitch =
		new LunTypesSwitch<Adapter>() {
			@Override
			public Adapter caseLCommonModel(LCommonModel object) {
				return createLCommonModelAdapter();
			}
			@Override
			public Adapter caseLLazyResolver(LLazyResolver object) {
				return createLLazyResolverAdapter();
			}
			@Override
			public Adapter caseLPackage(LPackage object) {
				return createLPackageAdapter();
			}
			@Override
			public Adapter caseLTypedPackage(LTypedPackage object) {
				return createLTypedPackageAdapter();
			}
			@Override
			public Adapter caseLImport(LImport object) {
				return createLImportAdapter();
			}
			@Override
			public Adapter caseLType(LType object) {
				return createLTypeAdapter();
			}
			@Override
			public Adapter caseLAnnotationDef(LAnnotationDef object) {
				return createLAnnotationDefAdapter();
			}
			@Override
			public Adapter caseLAnnotationTarget(LAnnotationTarget object) {
				return createLAnnotationTargetAdapter();
			}
			@Override
			public Adapter caseLScalarType(LScalarType object) {
				return createLScalarTypeAdapter();
			}
			@Override
			public Adapter caseLDataType(LDataType object) {
				return createLDataTypeAdapter();
			}
			@Override
			public Adapter caseLEnum(LEnum object) {
				return createLEnumAdapter();
			}
			@Override
			public Adapter caseLEnumLiteral(LEnumLiteral object) {
				return createLEnumLiteralAdapter();
			}
			@Override
			public Adapter caseLClass(LClass object) {
				return createLClassAdapter();
			}
			@Override
			public Adapter caseLFeaturesHolder(LFeaturesHolder object) {
				return createLFeaturesHolderAdapter();
			}
			@Override
			public Adapter caseLFeature(LFeature object) {
				return createLFeatureAdapter();
			}
			@Override
			public Adapter caseLReference(LReference object) {
				return createLReferenceAdapter();
			}
			@Override
			public Adapter caseLAttribute(LAttribute object) {
				return createLAttributeAdapter();
			}
			@Override
			public Adapter caseLKeyAndValue(LKeyAndValue object) {
				return createLKeyAndValueAdapter();
			}
			@Override
			public Adapter caseLOperation(LOperation object) {
				return createLOperationAdapter();
			}
			@Override
			public Adapter caseLModifier(LModifier object) {
				return createLModifierAdapter();
			}
			@Override
			public Adapter caseLMultiplicity(LMultiplicity object) {
				return createLMultiplicityAdapter();
			}
			@Override
			public Adapter caseLConstraints(LConstraints object) {
				return createLConstraintsAdapter();
			}
			@Override
			public Adapter caseLConstraint(LConstraint object) {
				return createLConstraintAdapter();
			}
			@Override
			public Adapter caseLDatatypeConstraint(LDatatypeConstraint object) {
				return createLDatatypeConstraintAdapter();
			}
			@Override
			public Adapter caseLDtCAssertFalse(LDtCAssertFalse object) {
				return createLDtCAssertFalseAdapter();
			}
			@Override
			public Adapter caseLDtCAssertTrue(LDtCAssertTrue object) {
				return createLDtCAssertTrueAdapter();
			}
			@Override
			public Adapter caseLDtCDecimalMax(LDtCDecimalMax object) {
				return createLDtCDecimalMaxAdapter();
			}
			@Override
			public Adapter caseLDtCDecimalMin(LDtCDecimalMin object) {
				return createLDtCDecimalMinAdapter();
			}
			@Override
			public Adapter caseLDtCDigits(LDtCDigits object) {
				return createLDtCDigitsAdapter();
			}
			@Override
			public Adapter caseLDtCFuture(LDtCFuture object) {
				return createLDtCFutureAdapter();
			}
			@Override
			public Adapter caseLDtCPast(LDtCPast object) {
				return createLDtCPastAdapter();
			}
			@Override
			public Adapter caseLDtCNumericMax(LDtCNumericMax object) {
				return createLDtCNumericMaxAdapter();
			}
			@Override
			public Adapter caseLDtCNumericMin(LDtCNumericMin object) {
				return createLDtCNumericMinAdapter();
			}
			@Override
			public Adapter caseLDtCNotNull(LDtCNotNull object) {
				return createLDtCNotNullAdapter();
			}
			@Override
			public Adapter caseLDtCNull(LDtCNull object) {
				return createLDtCNullAdapter();
			}
			@Override
			public Adapter caseLDtCRegEx(LDtCRegEx object) {
				return createLDtCRegExAdapter();
			}
			@Override
			public Adapter caseLDtCSize(LDtCSize object) {
				return createLDtCSizeAdapter();
			}
			@Override
			public Adapter caseLAttributeMatchingConstraint(LAttributeMatchingConstraint object) {
				return createLAttributeMatchingConstraintAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LCommonModel <em>LCommon Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LCommonModel
	 * @generated
	 */
	public Adapter createLCommonModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LLazyResolver <em>LLazy Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LLazyResolver
	 * @generated
	 */
	public Adapter createLLazyResolverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LPackage <em>LPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LPackage
	 * @generated
	 */
	public Adapter createLPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LTypedPackage <em>LTyped Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LTypedPackage
	 * @generated
	 */
	public Adapter createLTypedPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LImport <em>LImport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LImport
	 * @generated
	 */
	public Adapter createLImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LType <em>LType</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LType
	 * @generated
	 */
	public Adapter createLTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LAnnotationDef <em>LAnnotation Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LAnnotationDef
	 * @generated
	 */
	public Adapter createLAnnotationDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LAnnotationTarget <em>LAnnotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LAnnotationTarget
	 * @generated
	 */
	public Adapter createLAnnotationTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LScalarType <em>LScalar Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LScalarType
	 * @generated
	 */
	public Adapter createLScalarTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDataType <em>LData Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDataType
	 * @generated
	 */
	public Adapter createLDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LEnum <em>LEnum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LEnum
	 * @generated
	 */
	public Adapter createLEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LEnumLiteral <em>LEnum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LEnumLiteral
	 * @generated
	 */
	public Adapter createLEnumLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LClass <em>LClass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LClass
	 * @generated
	 */
	public Adapter createLClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LFeaturesHolder <em>LFeatures Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LFeaturesHolder
	 * @generated
	 */
	public Adapter createLFeaturesHolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LFeature <em>LFeature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LFeature
	 * @generated
	 */
	public Adapter createLFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LReference <em>LReference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LReference
	 * @generated
	 */
	public Adapter createLReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LAttribute <em>LAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LAttribute
	 * @generated
	 */
	public Adapter createLAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LKeyAndValue <em>LKey And Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LKeyAndValue
	 * @generated
	 */
	public Adapter createLKeyAndValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LOperation <em>LOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LOperation
	 * @generated
	 */
	public Adapter createLOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LModifier <em>LModifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LModifier
	 * @generated
	 */
	public Adapter createLModifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LMultiplicity <em>LMultiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LMultiplicity
	 * @generated
	 */
	public Adapter createLMultiplicityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LConstraints <em>LConstraints</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LConstraints
	 * @generated
	 */
	public Adapter createLConstraintsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LConstraint <em>LConstraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LConstraint
	 * @generated
	 */
	public Adapter createLConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDatatypeConstraint <em>LDatatype Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDatatypeConstraint
	 * @generated
	 */
	public Adapter createLDatatypeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCAssertFalse <em>LDt CAssert False</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCAssertFalse
	 * @generated
	 */
	public Adapter createLDtCAssertFalseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCAssertTrue <em>LDt CAssert True</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCAssertTrue
	 * @generated
	 */
	public Adapter createLDtCAssertTrueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCDecimalMax <em>LDt CDecimal Max</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCDecimalMax
	 * @generated
	 */
	public Adapter createLDtCDecimalMaxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCDecimalMin <em>LDt CDecimal Min</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCDecimalMin
	 * @generated
	 */
	public Adapter createLDtCDecimalMinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCDigits <em>LDt CDigits</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCDigits
	 * @generated
	 */
	public Adapter createLDtCDigitsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCFuture <em>LDt CFuture</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCFuture
	 * @generated
	 */
	public Adapter createLDtCFutureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCPast <em>LDt CPast</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCPast
	 * @generated
	 */
	public Adapter createLDtCPastAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCNumericMax <em>LDt CNumeric Max</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCNumericMax
	 * @generated
	 */
	public Adapter createLDtCNumericMaxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCNumericMin <em>LDt CNumeric Min</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCNumericMin
	 * @generated
	 */
	public Adapter createLDtCNumericMinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCNotNull <em>LDt CNot Null</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCNotNull
	 * @generated
	 */
	public Adapter createLDtCNotNullAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCNull <em>LDt CNull</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCNull
	 * @generated
	 */
	public Adapter createLDtCNullAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCRegEx <em>LDt CReg Ex</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCRegEx
	 * @generated
	 */
	public Adapter createLDtCRegExAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LDtCSize <em>LDt CSize</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LDtCSize
	 * @generated
	 */
	public Adapter createLDtCSizeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint <em>LAttribute Matching Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.common.types.LAttributeMatchingConstraint
	 * @generated
	 */
	public Adapter createLAttributeMatchingConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //LunTypesAdapterFactory

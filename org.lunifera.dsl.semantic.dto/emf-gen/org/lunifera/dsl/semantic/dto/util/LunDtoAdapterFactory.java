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
package org.lunifera.dsl.semantic.dto.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.lunifera.dsl.semantic.common.types.LAnnotationTarget;
import org.lunifera.dsl.semantic.common.types.LAttribute;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LFeaturesHolder;
import org.lunifera.dsl.semantic.common.types.LLazyResolver;
import org.lunifera.dsl.semantic.common.types.LOperation;
import org.lunifera.dsl.semantic.common.types.LReference;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.common.types.LType;

import org.lunifera.dsl.semantic.dto.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage
 * @generated
 */
public class LunDtoAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LunDtoPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LunDtoAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LunDtoPackage.eINSTANCE;
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
	protected LunDtoSwitch<Adapter> modelSwitch =
		new LunDtoSwitch<Adapter>() {
			@Override
			public Adapter caseLDtoModel(LDtoModel object) {
				return createLDtoModelAdapter();
			}
			@Override
			public Adapter caseLDto(LDto object) {
				return createLDtoAdapter();
			}
			@Override
			public Adapter caseLAutoInheritDto(LAutoInheritDto object) {
				return createLAutoInheritDtoAdapter();
			}
			@Override
			public Adapter caseLDtoMapper(LDtoMapper object) {
				return createLDtoMapperAdapter();
			}
			@Override
			public Adapter caseLDtoFeature(LDtoFeature object) {
				return createLDtoFeatureAdapter();
			}
			@Override
			public Adapter caseLDtoAbstractAttribute(LDtoAbstractAttribute object) {
				return createLDtoAbstractAttributeAdapter();
			}
			@Override
			public Adapter caseLDtoInheritedAttribute(LDtoInheritedAttribute object) {
				return createLDtoInheritedAttributeAdapter();
			}
			@Override
			public Adapter caseLDtoAttribute(LDtoAttribute object) {
				return createLDtoAttributeAdapter();
			}
			@Override
			public Adapter caseLDtoAbstractReference(LDtoAbstractReference object) {
				return createLDtoAbstractReferenceAdapter();
			}
			@Override
			public Adapter caseLDtoInheritedReference(LDtoInheritedReference object) {
				return createLDtoInheritedReferenceAdapter();
			}
			@Override
			public Adapter caseLDtoReference(LDtoReference object) {
				return createLDtoReferenceAdapter();
			}
			@Override
			public Adapter caseLDtoOperation(LDtoOperation object) {
				return createLDtoOperationAdapter();
			}
			@Override
			public Adapter caseLLazyResolver(LLazyResolver object) {
				return createLLazyResolverAdapter();
			}
			@Override
			public Adapter caseLAnnotationTarget(LAnnotationTarget object) {
				return createLAnnotationTargetAdapter();
			}
			@Override
			public Adapter caseLType(LType object) {
				return createLTypeAdapter();
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
			public Adapter caseLScalarType(LScalarType object) {
				return createLScalarTypeAdapter();
			}
			@Override
			public Adapter caseLFeature(LFeature object) {
				return createLFeatureAdapter();
			}
			@Override
			public Adapter caseLAttribute(LAttribute object) {
				return createLAttributeAdapter();
			}
			@Override
			public Adapter caseLReference(LReference object) {
				return createLReferenceAdapter();
			}
			@Override
			public Adapter caseLOperation(LOperation object) {
				return createLOperationAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoModel <em>LDto Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoModel
	 * @generated
	 */
	public Adapter createLDtoModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDto <em>LDto</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDto
	 * @generated
	 */
	public Adapter createLDtoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LAutoInheritDto <em>LAuto Inherit Dto</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LAutoInheritDto
	 * @generated
	 */
	public Adapter createLAutoInheritDtoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoMapper <em>LDto Mapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoMapper
	 * @generated
	 */
	public Adapter createLDtoMapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoFeature <em>LDto Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoFeature
	 * @generated
	 */
	public Adapter createLDtoFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute <em>LDto Abstract Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoAbstractAttribute
	 * @generated
	 */
	public Adapter createLDtoAbstractAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute <em>LDto Inherited Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoInheritedAttribute
	 * @generated
	 */
	public Adapter createLDtoInheritedAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoAttribute <em>LDto Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoAttribute
	 * @generated
	 */
	public Adapter createLDtoAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoAbstractReference <em>LDto Abstract Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoAbstractReference
	 * @generated
	 */
	public Adapter createLDtoAbstractReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoInheritedReference <em>LDto Inherited Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoInheritedReference
	 * @generated
	 */
	public Adapter createLDtoInheritedReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoReference <em>LDto Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoReference
	 * @generated
	 */
	public Adapter createLDtoReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.lunifera.dsl.semantic.dto.LDtoOperation <em>LDto Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.lunifera.dsl.semantic.dto.LDtoOperation
	 * @generated
	 */
	public Adapter createLDtoOperationAdapter() {
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

} //LunDtoAdapterFactory

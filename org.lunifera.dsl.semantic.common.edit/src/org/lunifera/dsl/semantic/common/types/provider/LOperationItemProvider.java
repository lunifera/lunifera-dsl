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
package org.lunifera.dsl.semantic.common.types.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.xtext.common.types.TypesFactory;

import org.eclipse.xtext.xbase.XbaseFactory;

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory;

import org.lunifera.dsl.semantic.common.types.LOperation;
import org.lunifera.dsl.semantic.common.types.LunTypesFactory;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;

/**
 * This is the item provider adapter for a {@link org.lunifera.dsl.semantic.common.types.LOperation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LOperationItemProvider extends LAnnotationTargetItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LOperationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(LunTypesPackage.Literals.LOPERATION__MODIFIER);
			childrenFeatures.add(LunTypesPackage.Literals.LOPERATION__TYPE);
			childrenFeatures.add(LunTypesPackage.Literals.LOPERATION__PARAMS);
			childrenFeatures.add(LunTypesPackage.Literals.LOPERATION__BODY);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns LOperation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LOperation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_LOperation_type");
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(LOperation.class)) {
			case LunTypesPackage.LOPERATION__MODIFIER:
			case LunTypesPackage.LOPERATION__TYPE:
			case LunTypesPackage.LOPERATION__PARAMS:
			case LunTypesPackage.LOPERATION__BODY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__MODIFIER,
				 LunTypesFactory.eINSTANCE.createLModifier()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__TYPE,
				 TypesFactory.eINSTANCE.createJvmParameterizedTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__TYPE,
				 TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__TYPE,
				 TypesFactory.eINSTANCE.createJvmWildcardTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__TYPE,
				 TypesFactory.eINSTANCE.createJvmAnyTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__TYPE,
				 TypesFactory.eINSTANCE.createJvmMultiTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__TYPE,
				 TypesFactory.eINSTANCE.createJvmDelegateTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__TYPE,
				 TypesFactory.eINSTANCE.createJvmSynonymTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__TYPE,
				 TypesFactory.eINSTANCE.createJvmUnknownTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__PARAMS,
				 TypesFactory.eINSTANCE.createJvmFormalParameter()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XAnnotationsFactory.eINSTANCE.createXAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXIfExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXSwitchExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXBlockExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXVariableDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXMemberFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXFeatureCall()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXConstructorCall()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXBooleanLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXNullLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXNumberLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXListLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXSetLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXClosure()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXCastedExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXBinaryOperation()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXUnaryOperation()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXPostfixOperation()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXForLoopExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXBasicForLoopExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXDoWhileExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXWhileExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXTypeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXInstanceOfExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXThrowExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXTryCatchFinallyExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXReturnExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LOPERATION__BODY,
				 XbaseFactory.eINSTANCE.createXSynchronizedExpression()));
	}

}

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
package org.lunifera.dsl.semantic.entity.provider;


import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.xtext.common.types.TypesFactory;
import org.lunifera.dsl.semantic.common.types.LunTypesFactory;
import org.lunifera.dsl.semantic.common.types.LunTypesPackage;
import org.lunifera.dsl.semantic.entity.LBeanReference;
import org.lunifera.dsl.semantic.entity.LunEntityPackage;

/**
 * This is the item provider adapter for a {@link org.lunifera.dsl.semantic.entity.LBeanReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LBeanReferenceItemProvider extends LBeanFeatureItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LBeanReferenceItemProvider(AdapterFactory adapterFactory) {
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

			addLazyPropertyDescriptor(object);
			addCascadingPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addOppositePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Lazy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLazyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LReference_lazy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LReference_lazy_feature", "_UI_LReference_type"),
				 LunTypesPackage.Literals.LREFERENCE__LAZY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cascading feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCascadingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LReference_cascading_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LReference_cascading_feature", "_UI_LReference_type"),
				 LunTypesPackage.Literals.LREFERENCE__CASCADING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LBeanReference_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LBeanReference_type_feature", "_UI_LBeanReference_type"),
				 LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Opposite feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOppositePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LBeanReference_opposite_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LBeanReference_opposite_feature", "_UI_LBeanReference_type"),
				 LunEntityPackage.Literals.LBEAN_REFERENCE__OPPOSITE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
			childrenFeatures.add(LunTypesPackage.Literals.LREFERENCE__PROPERTIES);
			childrenFeatures.add(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS);
			childrenFeatures.add(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM);
			childrenFeatures.add(LunEntityPackage.Literals.LBEAN_REFERENCE__RESULT_FILTERS);
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
	 * This returns LBeanReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LBeanReference"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((LBeanReference)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_LBeanReference_type") :
			getString("_UI_LBeanReference_type") + " " + label;
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

		switch (notification.getFeatureID(LBeanReference.class)) {
			case LunEntityPackage.LBEAN_REFERENCE__LAZY:
			case LunEntityPackage.LBEAN_REFERENCE__CASCADING:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case LunEntityPackage.LBEAN_REFERENCE__PROPERTIES:
			case LunEntityPackage.LBEAN_REFERENCE__CONSTRAINTS:
			case LunEntityPackage.LBEAN_REFERENCE__TYPE_JVM:
			case LunEntityPackage.LBEAN_REFERENCE__RESULT_FILTERS:
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
				(LunTypesPackage.Literals.LREFERENCE__PROPERTIES,
				 LunTypesFactory.eINSTANCE.createLKeyAndValue()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCAssertFalse()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCAssertTrue()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCDecimalMax()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCDecimalMin()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCDigits()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCFuture()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCPast()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCNumericMax()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCNumericMin()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCNotNull()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCNull()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCRegEx()));

		newChildDescriptors.add
			(createChildParameter
				(LunTypesPackage.Literals.LREFERENCE__CONSTRAINTS,
				 LunTypesFactory.eINSTANCE.createLDtCSize()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM,
				 TypesFactory.eINSTANCE.createJvmParameterizedTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM,
				 TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM,
				 TypesFactory.eINSTANCE.createJvmWildcardTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM,
				 TypesFactory.eINSTANCE.createJvmAnyTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM,
				 TypesFactory.eINSTANCE.createJvmMultiTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM,
				 TypesFactory.eINSTANCE.createJvmDelegateTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM,
				 TypesFactory.eINSTANCE.createJvmSynonymTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM,
				 TypesFactory.eINSTANCE.createJvmUnknownTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__TYPE_JVM,
				 TypesFactory.eINSTANCE.createJvmInnerTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(LunEntityPackage.Literals.LBEAN_REFERENCE__RESULT_FILTERS,
				 LunTypesFactory.eINSTANCE.createLResultFilters()));
	}

}
